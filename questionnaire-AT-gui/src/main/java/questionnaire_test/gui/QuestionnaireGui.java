package questionnaire_test.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adis.questionnaire.domaine.Identifiant;
import com.adis.questionnaire.domaine.TypeFranchise;
import com.adis.questionnaire.domaine.TypeGarantie;
import com.adis.questionnaire.domaine.TypePieceJustificative;
import com.adis.questionnaire.mdl.Adhesion;
import com.adis.questionnaire.mdl.Assure;
import com.adis.questionnaire.mdl.Contexte;
import com.adis.questionnaire.mdl.DemandeDePrestation;
import com.adis.questionnaire.mdl.EvaluationDemande;
import com.adis.questionnaire.mdl.Garantie;
import com.adis.questionnaire.mdl.PieceJustificative;
import com.adis.questionnaire.quest.Question;
import com.adis.questionnaire.quest.Questionnaire;
import com.adis.questionnaire.quest.Reponse;
import com.adis.questionnaire.quest.Rubrique;
import com.adis.questionnaire.quest.TypeQuestion;
import com.adis.questionnaire.util.DateUtils;
import com.adis.questionnaire.util.ReponseFormatter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import questionnaire_test.gui.console.Console;
import questionnaire_test.gui.console.Message;
import questionnaire_test.operation.QuestionnaireATExecution;

public class QuestionnaireGui extends SingleFrameApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(QuestionnaireGui.class);

	private static final String HTTP_LOCALHOST_8080_QUEST = "http://localhost:8080/quest";

	private static final String CONTEXTE_FILE_JSON = "CONTEXTE_FILE_JSON";
	private static final String QUESTIONNAIRE_FILE_JSON = "QUESTIONNAIRE_FILE_JSON";

	private URL url;

	private JTabbedPane tabbedPane;

	private JPanel questionnairePanel;
	private JPanel questionnaireControlPanel;

	private JPanel contextePanel;
	private JTextArea contexteArea;
	private JPanel evaluationPanel;
	private JTextArea evaluationArea;
	private JPanel readmePanel;
	private JTextArea readmeArea;

	private JComboBox<Rubrique> rubriqueComboboxField;
	private JComboBox<Question> questionComboboxField;
	private JTextField reponseTextField;
	private JTextField questionnaireFileTextField;
	private JTextField contexteFileTextField;

	private Rubrique lastRubriqueSelection;
	private Question lastQuestionSelection;

	private Contexte contexte;
	private Questionnaire questionnaire;

	private ObjectMapper mapper = new ObjectMapper();

	@SuppressWarnings("unused")
	private int nbAppel = 0;
	private boolean finished = false;

	public static void main(String[] args) {
		Application.launch(QuestionnaireGui.class, args);
	}

	@Override
	// Actions effectuées au démarrage de l'application, après l'initialisation
	protected void startup() {
		// pretty output
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		show(getTabbedPane());
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) getContext().getLocalStorage().load("map.xml");
			if (map != null) {
				questionnaireFileTextField.setText((String) map.get(QUESTIONNAIRE_FILE_JSON));
				contexteFileTextField.setText((String) map.get(CONTEXTE_FILE_JSON));
			}
		} catch (IOException e) {
		}

		try {
			openContexte();
			openQuestionnaire();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (contexte == null) {
			try {
				// on met un contexte par defaut
				initContexte();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (questionnaire == null) {
			questionnaire = new Questionnaire();
		}

		try {
			url = new URL(HTTP_LOCALHOST_8080_QUEST);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

		displayHelp();

		// Execution MDR
		Task<Void, Void> t = buildTaskMDR();
		t.execute();
	}

	private void displayHelp() {
		StringBuilder sb = new StringBuilder();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("questionnaire_test/gui/help.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String strLine = null;
		try {
			while ((strLine = reader.readLine()) != null) {
				// Print the content on the console
				sb.append(strLine).append("\r\n");
			}
		} catch (IOException e1) {
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		getReadmeArea().setText(sb.toString());
	}

	private void displayContexte() throws JsonProcessingException {
		String s = mapper.writeValueAsString(contexte);
		getContexteArea().setText(s);
	}

	private JComponent getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane();
			tabbedPane.add("Questionnaire", getQuestionnairePanel());
			tabbedPane.add("Contexte", getContextePanel());
			tabbedPane.add("Evaluation de la demande", getEvaluationPanel());
			tabbedPane.add("Readme", getReadmePanel());
		}
		return tabbedPane;
	}

	private Component getReadmePanel() {
		if (readmePanel == null) {

			readmePanel = new JPanel();
			readmePanel.setLayout(new GridBagLayout());

			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.insets = new Insets(5, 0, 0, 0);
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;

			JScrollPane scroll = new JScrollPane(getReadmeArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			readmePanel.add(scroll, gbc);
		}

		return readmePanel;
	}

	private JTextArea getReadmeArea() {
		if (readmeArea == null) {
			readmeArea = new JTextArea();
			Font font = new Font("Arial", Font.PLAIN, 10);
			readmeArea.setFont(font);
		}
		return readmeArea;
	}

	private JComponent getEvaluationPanel() {
		if (evaluationPanel == null) {

			evaluationPanel = new JPanel();
			evaluationPanel.setLayout(new GridBagLayout());

			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.insets = new Insets(5, 0, 0, 0);
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;

			JScrollPane scroll = new JScrollPane(getEvaluationArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			evaluationPanel.add(scroll, gbc);
		}

		return evaluationPanel;
	}

	private JTextArea getEvaluationArea() {
		if (evaluationArea == null) {
			evaluationArea = new JTextArea();
			Font font = new Font("Arial", Font.PLAIN, 10);
			evaluationArea.setFont(font);
		}
		return evaluationArea;
	}

	private JComponent getQuestionnairePanel() {
		if (questionnairePanel == null) {

			questionnairePanel = new JPanel();
			questionnairePanel.setLayout(new GridBagLayout());

			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.insets = new Insets(5, 0, 0, 0);
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			questionnairePanel.add(Console.getInstance().getComponent(), gbc);

			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.insets = new Insets(5, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			questionnairePanel.add(getQuestionnaireControlPanel(), gbc);

			Console.getInstance().addMouseListener(new MouseAdapter() {

				public void mouseClicked(final java.awt.event.MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						if (finished == true)
							return;
						if (evt.getSource() instanceof JList<?> == false)
							return;
						@SuppressWarnings("unchecked")
						JList<Message> source = (JList<Message>) evt.getSource();
						Message selectedValue = source.getSelectedValue();
						if (selectedValue == null)
							return;
						if (selectedValue.getObject() == null)
							return;

						if (selectedValue.getObject() instanceof Rubrique) {
							Rubrique rub = (Rubrique) selectedValue.getObject();
							rubriqueComboboxField.setSelectedItem(rub);
							reponseTextField.setText("");
							return;
						} else if (selectedValue.getObject() instanceof Question) {
							Question quest = (Question) selectedValue.getObject();
							Rubrique rub = findRubrique(source);
							// Rubrique puis Question !
							rubriqueComboboxField.setSelectedItem(rub);
							questionComboboxField.setSelectedItem(quest);
							reponseTextField.setText(getReponseTexte(quest));
						} else if (selectedValue.getObject() instanceof Reponse) {
							Reponse reponse = (Reponse) selectedValue.getObject();
							Question quest = findQuestion(source);
							Rubrique rub = findRubrique(source);
							// Rubrique puis Question !
							rubriqueComboboxField.setSelectedItem(rub);
							questionComboboxField.setSelectedItem(quest);
							if (quest.getType() != TypeQuestion.CHOIX_MULTIPLE) {
								reponseTextField.setText(reponse.getLibelle());
							} else { // GESTION CHOIX_MULTIPLE
								String reponseText = reponseTextField.getText();
								if (reponseText == null || reponseText.isEmpty()) { // put reponse
									reponseTextField.setText(reponse.getLibelle());
								} else {
									reponseTextField.setText(
											getReponseText4ChoixMultiple(quest, reponse, reponseTextField.getText()));
								}
							}
							envoiReponse().execute();
						}

					}
				}

				private String getReponseText4ChoixMultiple(Question quest, Reponse reponse, String reponseText) {
					List<String> libellesReponsesProposees = quest.getReponsesProposees().stream()
							.map(Reponse::getLibelle).collect(Collectors.toList());
					// clear not relevant text
					String[] tab = reponseText.split(",");
					List<String> ls = new LinkedList<>(Arrays.asList(tab));
					Iterator<String> it = ls.iterator();
					// clean ls
					while (it.hasNext()) {
						String s = it.next();
						if (libellesReponsesProposees.contains(s) == false)
							it.remove();
					}

					if (ls.contains(reponse.getLibelle()) == false) { // append
						ls.add(reponse.getLibelle());
					} else { // erase
						ls.remove(reponse.getLibelle());
					}

					return String.join(",", ls);
				}

				private Question findQuestion(JList<Message> source) {
					Question result = null;
					int selectedIndex = source.getSelectedIndex();
					for (int i = selectedIndex - 1; result == null && i > 0; i--) {
						Message message = source.getModel().getElementAt(i);
						if (message.getObject() instanceof Question) { // question
							result = (Question) message.getObject();
						}
					}
					return result;
				}

				private Rubrique findRubrique(JList<Message> source) {
					Rubrique result = null;
					int selectedIndex = source.getSelectedIndex();
					for (int i = selectedIndex - 1; result == null && i >= 0; i--) {
						Message message = source.getModel().getElementAt(i);
						if (message.getObject() instanceof Rubrique) { // question
							result = (Rubrique) message.getObject();
						}
					}

					return result;
				}
			});

			questionnairePanel.registerKeyboardAction(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						saveQuestionnaire();
					} catch (IOException e1) {
						Console.getInstance().addMessage(e1);
					}
				}
			}, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

			questionnairePanel.registerKeyboardAction(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						openQuestionnaire();
						// Execution MDR après chargement
						Task<Void, Void> t = buildTaskMDR();
						t.execute();
					} catch (IOException e1) {
						Console.getInstance().addMessage(e1);
					}
				}
			}, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

		}
		return questionnairePanel;
	}

	private JComponent getContextePanel() {
		if (contextePanel == null) {

			contextePanel = new JPanel();
			contextePanel.setLayout(new GridBagLayout());

			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.insets = new Insets(5, 0, 0, 0);
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;

			JScrollPane scroll = new JScrollPane(getContexteArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			contextePanel.add(scroll, gbc);

			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.insets = new Insets(5, 0, 0, 0);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			JPanel contexteControlPanel = buildChooseContexteFilePanel();
			contextePanel.add(contexteControlPanel, gbc);
		}

		return contextePanel;
	}

	public JTextArea getContexteArea() {
		if (contexteArea == null) {
			contexteArea = new JTextArea();
			Font font = new Font("Arial", Font.PLAIN, 10);
			contexteArea.setFont(font);

			contexteArea.registerKeyboardAction(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						openContexte();
						// Execution MDR après chargement
						Task<Void, Void> t = buildTaskMDR();
						t.execute();
					} catch (Exception ex) {
						LOGGER.error("", ex);
					}
				}
			}, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

			contexteArea.registerKeyboardAction(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						saveContexte();
					} catch (Exception ex) {
						LOGGER.error("", ex);
					}
				}
			}, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

			contexteArea.registerKeyboardAction(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						contexte = mapper.readValue(contexteArea.getText(), Contexte.class);
						Task<Void, Void> t = buildTaskMDR();
						t.execute();
					} catch (Exception ex) {
						LOGGER.error("", ex);
					}
				}
			}, KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);
		}
		return contexteArea;
	}

	private JComponent getQuestionnaireControlPanel() {
		if (questionnaireControlPanel == null) {
			final DocumentListener documentListener = new DocumentListener() {
				public void changedUpdate(DocumentEvent e) {
					fireProperty();
				}

				public void removeUpdate(DocumentEvent e) {
					fireProperty();
				}

				public void insertUpdate(DocumentEvent e) {
					fireProperty();
				}

				public void fireProperty() {
					// firePropertyChange("envoiResponseEnabled", null, null);
				}
			};

			questionnaireControlPanel = new JPanel();
			questionnaireControlPanel.setLayout(new GridBagLayout());

			int iy = 0;

			iy = builRubriqueQuestionPanel(documentListener, iy);
			iy = buildReponsePanel(documentListener, iy);
			iy = buildChooseQuestionnaireFilePanel(documentListener, iy);

		}

		return questionnaireControlPanel;
	}

	private int buildChooseQuestionnaireFilePanel(final DocumentListener documentListener, int iy) {
		JPanel localPanel = new JPanel();
		localPanel.setLayout(new GridBagLayout());
		final ResourceMap resourceMap = getContext().getResourceManager().getResourceMap();
		final String title = resourceMap.getString("panelFileQuestionnaireLabel.text");
		localPanel.setBorder(BorderFactory.createTitledBorder(title));

		questionnaireFileTextField = new JTextField();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 5, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		localPanel.add(questionnaireFileTextField, gbc);

		ActionMap actionMap = getContext().getActionMap();
		javax.swing.Action action = actionMap.get("fileQuestionnaireChoose");
		JButton templateButton = new JButton();
		templateButton.setAction(action);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.fill = GridBagConstraints.NONE;
		localPanel.add(templateButton, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = iy;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 5, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		questionnaireControlPanel.add(localPanel, gbc);

		iy++;
		return iy;
	}

	@Action
	public void fileQuestionnaireChoose() {
		final ResourceMap resourceMap = getContext().getResourceManager().getResourceMap();
		final String title = resourceMap.getString("fileQuestionnaireChoose.title");
		final String fileName = questionnaireFileTextField.getText();

		JFileChooser fileChooser = buildJFileChooser(title, fileName);
		final int r = fileChooser.showOpenDialog(getMainFrame());
		if (r == JFileChooser.APPROVE_OPTION) {
			File selFile = fileChooser.getSelectedFile();
			questionnaireFileTextField.setText(selFile.getAbsolutePath());
		}
	}

	private JFileChooser buildJFileChooser(final String title, final String fileName) {
		JFileChooser fileChooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("fichier json", "json");
		fileChooser.setFileFilter(filter);
		fileChooser.setDialogTitle(title);

		if (fileName.isEmpty() == false) {
			final File file = new File(fileName);
			if (file.exists())
				fileChooser.setSelectedFile(file.getAbsoluteFile());
			else
				fileChooser.setCurrentDirectory(file.getAbsoluteFile().getParentFile());
		}
		return fileChooser;
	}

	private JPanel buildChooseContexteFilePanel() {
		JPanel localPanel = new JPanel();
		localPanel.setLayout(new GridBagLayout());
		final ResourceMap resourceMap = getContext().getResourceManager().getResourceMap();
		final String title = resourceMap.getString("panelFileContexteLabel.text");
		localPanel.setBorder(BorderFactory.createTitledBorder(title));

		contexteFileTextField = new JTextField();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 5, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		localPanel.add(contexteFileTextField, gbc);

		ActionMap actionMap = getContext().getActionMap();
		javax.swing.Action action = actionMap.get("fileContexteChoose");
		JButton templateButton = new JButton();
		templateButton.setAction(action);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.fill = GridBagConstraints.NONE;
		localPanel.add(templateButton, gbc);

		return localPanel;
	}

	@Action
	public void fileContexteChoose() {
		final ResourceMap resourceMap = getContext().getResourceManager().getResourceMap();
		final String title = resourceMap.getString("fileContexteChoose.title");
		final String fileName = contexteFileTextField.getText();

		JFileChooser fileChooser = buildJFileChooser(title, fileName);
		final int r = fileChooser.showOpenDialog(getMainFrame());
		if (r == JFileChooser.APPROVE_OPTION) {
			File selFile = fileChooser.getSelectedFile();
			contexteFileTextField.setText(selFile.getAbsolutePath());
		}
	}

	private int buildReponsePanel(final DocumentListener documentListener, int iy) {
		JPanel localPanel = new JPanel();
		localPanel.setLayout(new GridBagLayout());
		final ResourceMap resourceMap = getContext().getResourceManager().getResourceMap();
		final String title = resourceMap.getString("reponseLabel.text");
		TitledBorder createTitledBorder = BorderFactory.createTitledBorder(title);
		localPanel.setBorder(createTitledBorder);

		reponseTextField = new JTextField();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 5, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		localPanel.add(reponseTextField, gbc);

		ActionMap actionMap = getContext().getActionMap();
		javax.swing.Action action = actionMap.get("envoiReponse");
		JButton runButton = new JButton();
		runButton.setAction(action);
		// gbc = new GridBagConstraints();
		// gbc.gridx = 0; gbc.gridy = 1;
		// gbc.gridwidth = GridBagConstraints.REMAINDER; gbc.gridheight = 1;
		// gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(5, 5, 0, 5);
		// gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.fill = GridBagConstraints.NONE;

		localPanel.add(runButton, gbc);

		reponseTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Task<Void, Void> envoiReponse = envoiReponse();
					envoiReponse.execute();
				}
			}
		});

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = iy;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 5, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		questionnaireControlPanel.add(localPanel, gbc);

		iy++;
		return iy;
	}

	@SuppressWarnings("serial")
	private int builRubriqueQuestionPanel(DocumentListener documentListener, int iy) {
		JPanel localPanel = new JPanel();
		localPanel.setLayout(new GridBagLayout());
		final ResourceMap resourceMap = getContext().getResourceManager().getResourceMap();
		final String title = resourceMap.getString("rubrique_questionLabel.text");
		localPanel.setBorder(BorderFactory.createTitledBorder(title));

		rubriqueComboboxField = new JComboBox<>();
		rubriqueComboboxField.setRenderer(new BasicComboBoxRenderer() {

			public Component getListCellRendererComponent(JList<?> combobox, Object value, int index,
					boolean isSelected, boolean cellHasFocus) {
				super.getListCellRendererComponent(combobox, value, index, isSelected, cellHasFocus);
				if (value != null) {
					Rubrique rub = (Rubrique) value;
					setText(rub.getLibelle());
				}
				return this;
			}
		});

		ActionListener cbActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				questionComboboxField.removeAllItems();
				Rubrique rubrique = (Rubrique) rubriqueComboboxField.getSelectedItem();
				if (rubrique != null) {
					List<Question> collect = rubrique.getQuestions().stream().collect(Collectors.toList());
					if (collect.size() > 0) {
						collect.forEach(s -> questionComboboxField.addItem(s));
						if (lastQuestionSelection != null) {
							questionComboboxField.setSelectedItem(lastQuestionSelection);
							reponseTextField.setText(getReponseTexte(lastQuestionSelection));
						} else
							questionComboboxField.setSelectedIndex(0);
					}

				}
			}
		};
		rubriqueComboboxField.addActionListener(cbActionListener);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 5, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		localPanel.add(rubriqueComboboxField, gbc);

		questionComboboxField = new JComboBox<>();
		questionComboboxField.setRenderer(new BasicComboBoxRenderer() {

			public Component getListCellRendererComponent(JList<?> combobox, Object value, int index,
					boolean isSelected, boolean cellHasFocus) {
				super.getListCellRendererComponent(combobox, value, index, isSelected, cellHasFocus);
				if (value != null) {
					Question quest = (Question) value;
					setText(quest.getLibelle());
				}
				return this;
			}
		});

		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		localPanel.add(questionComboboxField, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = iy;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 5, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		questionnaireControlPanel.add(localPanel, gbc);

		iy++;
		return iy;
	}

	protected String getReponseTexte(Question question) {
		String result = null;
		if (question.getType() == TypeQuestion.CHOIX_MULTIPLE) {
			List<String> collect = question.getReponsesSelections().stream().map(Reponse::getLibelle)
					.collect(Collectors.toList());
			if (collect.isEmpty() == false) {
				result = String.join(",", collect);
			}
		} else {
			Reponse reponseSelectionnee = question.getReponseSelectionnee();
			if (reponseSelectionnee != null)
				result = reponseSelectionnee.getLibelle();
		}
		return result;
	}

	protected void executeMDR() {

		try {
			Console.getInstance().clear();
			QuestionnaireATExecution operation = new QuestionnaireATExecution(url);
			operation.run(contexte, questionnaire);

			nbAppel++;

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					List<Rubrique> rubriquelibelles = QuestionnaireUtilGui.getRubriquesAndInnerRubrique(questionnaire)
							.stream().filter(r -> !r.getQuestions().isEmpty()).collect(Collectors.toList());
					rubriqueComboboxField.removeAllItems();
					rubriquelibelles.forEach(s -> rubriqueComboboxField.addItem(s));
					if (lastRubriqueSelection != null)
						rubriqueComboboxField.setSelectedItem(lastRubriqueSelection);
				}
			});
			questionnaire = operation.getQuestionnaire();
			display(operation.getEvaluationDemande());

			// finished = questionnaire.estComplet();
		} catch (Exception e) {
			Console.getInstance().addMessage(e);
			LOGGER.error("", e);
		}
	}

	@Action()
	public Task<Void, Void> envoiReponse() {

		final Rubrique rubrique = (Rubrique) rubriqueComboboxField.getSelectedItem();
		final Question question = (Question) questionComboboxField.getSelectedItem();
		final String reponse = reponseTextField.getText().trim();

		lastRubriqueSelection = rubrique;
		lastQuestionSelection = question;

		treatResponse(rubrique, question, reponse);

		enableComponents(getQuestionnaireControlPanel(), false);

		Task<Void, Void> task = buildTaskMDR();

		return task;
	}

	private Task<Void, Void> buildTaskMDR() {
		Task<Void, Void> task = new Task<Void, Void>(this) {

			@Override
			protected Void doInBackground() throws Exception {
				executeMDR();
				return null;
			}

			@Override
			protected void succeeded(Void result) {
				super.succeeded(result);
				if (finished == false)
					enableComponents(getQuestionnaireControlPanel(), true);
			}

		};
		return task;
	}

	protected void treatResponse(Rubrique rubrique, Question q, String reponse) {
		try {
			if (q.getType() == TypeQuestion.CHOIX_MULTIPLE) {
				List<Reponse> reponses = new LinkedList<>();
				if (reponse.isEmpty()) {
					q.setReponsesSelections(reponses);
				} else {
					String[] tab = reponse.split(",");
					for (int i = 0; i < tab.length; i++) {
						Reponse rep = getReponse(q, tab[i].trim());
						if (rep == null)
							Console.getInstance().addMessage(Message.buildMessage(
									"cette reponse ne fait pas partie de la liste pour cette question", Color.RED));
						else {
							reponses.add(rep);
						}
					}

					if (reponses.size() == tab.length) {
						q.setReponsesSelections(reponses);
					}
				}
			} else if (q.getType() == TypeQuestion.CHOIX_UNIQUE_LISTE || q.getType() == TypeQuestion.CHOIX_UNIQUE_RADIO
					|| q.getType() == TypeQuestion.OUI_NON || q.getType() == TypeQuestion.OUI_NON_JENESAISPAS) {
				// Console.getInstance().addMessage(Message.buildMessage(
				// 	q.isReponseNeSaisPasPossible() + reponse, Color.BLUE));
				if (q.isReponseNeSaisPasPossible() && reponse.equals("NSP")){
					q.getReponsesSelections().clear();
					q.ajouterReponseSelectionnee(new Reponse("NSP", "NSP"));
				}else{
					Reponse rep = getReponse(q, reponse);
					if (rep == null)
						Console.getInstance().addMessage(Message.buildMessage(
								"cette reponse ne fait pas partie de la liste pour cette question", Color.RED));
					else {
						q.getReponsesSelections().clear();
						q.ajouterReponseSelectionnee(rep);
					}
				}
			} else { // SAISIR_XXXX
				Reponse resp;
				if (q.isReponseNeSaisPasPossible() && reponse.equals("NSP")) {
				 	resp = new Reponse("NSP", Identifiant.Reponse.NSP);
				} else {
					resp = new Reponse(reponse);
					// Gestion Dates
					if (q.getType() == TypeQuestion.SAISIR_DATE) {
						try {
							ReponseFormatter.toDate(resp);
						} catch (Exception e) {
							Console.getInstance()
									.addMessage(Message.buildMessage(
											resp.getLibelle() + " n'est pas une date valide. Le format est dd/MM/yyyy",
											Color.RED));
							return;
						}
					}
					// Gestion entiers
					if (q.getType() == TypeQuestion.SAISIR_NOMBRE) {
						try {
							ReponseFormatter.toInt(resp);
						} catch (Exception e) {
							Console.getInstance()
									.addMessage(Message.buildMessage(
											resp.getLibelle() + " n'est pas un entier valide.",
											Color.RED));
							return;
						}
					}
				}

				q.getReponsesSelections().clear();
				q.ajouterReponseSelectionnee(resp);
			}
		} catch (Exception e) {
			Console.getInstance().addMessage(e);
		}
		return;
	}

	private Reponse getReponse(Question q, String s) {
		Reponse reponse = q.getReponsesProposees().stream().filter(i -> i.getLibelle().equals(s)).findFirst()
				.orElse(null);
		return reponse;
	}

	protected void display(EvaluationDemande evaluation) throws JsonProcessingException {
		displayContexte();
		displayQuestionnaire();
		questionnaire.setValide(true);
		if (questionnaire.evalCompletude())
			displayEvaluation(evaluation);
	}

	private void displayEvaluation(EvaluationDemande evaluation) throws JsonProcessingException {
		Console.getInstance().addMessage(
				"******************************** Le questionnaire est complet:  FIN DE QUESTIONNAIRE ************************");

		String s = mapper.writeValueAsString(evaluation);
		getEvaluationArea().setText(s);
	}

	private void displayQuestionnaire() {
		new AffichageQuestionnaireGUI(questionnaire).display();
	}

	public void enableComponents(JComponent container, boolean enable) {
		Component[] components = container.getComponents();
		for (Component component : components) {
			component.setEnabled(enable);
			if (component instanceof JComponent) {
				enableComponents((JComponent) component, enable);
			}
		}
	}

	@Override
	protected void shutdown() {
		super.shutdown();
		// RulesetExecution.getFactory().release();
		Map<String, Object> persistantMap = new HashMap<String, Object>();

		try {
			persistantMap.put(QUESTIONNAIRE_FILE_JSON, questionnaireFileTextField.getText());
			persistantMap.put(CONTEXTE_FILE_JSON, contexteFileTextField.getText());
			getContext().getLocalStorage().save(persistantMap, "map.xml");
		} catch (IOException e) {
		}
	}

	protected void saveQuestionnaire() throws StreamWriteException, DatabindException, IOException {
		if (questionnaireFileTextField.getText() != null && questionnaireFileTextField.getText().isEmpty() == false) {
			File file = new File(questionnaireFileTextField.getText());
			int dialogResult = JOptionPane.YES_OPTION;
			if (file.exists()) {
				dialogResult = JOptionPane.showConfirmDialog(questionnairePanel,
						"Voulez vous écraser le fichier de questionnaire " + file.getName(), "Warning",
						JOptionPane.YES_NO_OPTION);
			}
			if (dialogResult == JOptionPane.YES_OPTION) {
				mapper.writeValue(file, questionnaire);
			}
		}
	}

	protected void saveContexte() {
		if (contexteFileTextField.getText() != null && contexteFileTextField.getText().isEmpty() == false) {
			File file = new File(contexteFileTextField.getText());
			int dialogResult = JOptionPane.YES_OPTION;
			if (file.exists()) {
				dialogResult = JOptionPane.showConfirmDialog(contextePanel,
						"Voulez vous écraser le fichier de contexte " + file.getName(), "Warning",
						JOptionPane.YES_NO_OPTION);
			}
			if (dialogResult == JOptionPane.YES_OPTION) {
				// get json
				String json = contexteArea.getText();
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
					// check json is correct
					contexte = mapper.readValue(json, Contexte.class);
					// write to file
					writer.write(json);
					// on exécute car on vient de charger un nouveau contexte
					Task<Void, Void> t = buildTaskMDR();
					t.execute();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(contextePanel, e.getMessage());
					LOGGER.error("", e);
				}

			}
		}
	}

	protected void openContexte() throws StreamReadException, DatabindException, IOException {
		if (contexteFileTextField.getText() != null && contexteFileTextField.getText().isEmpty() == false) {
			contexte = mapper.readValue(new File(contexteFileTextField.getText()), Contexte.class);
		}
	}

	protected void openQuestionnaire() throws StreamReadException, DatabindException, IOException {
		if (questionnaireFileTextField.getText() != null && questionnaireFileTextField.getText().isEmpty() == false) {
			questionnaire = mapper.readValue(new File(questionnaireFileTextField.getText()), Questionnaire.class);
		}
	}

	private void initContexte() throws ParseException {
		contexte = new Contexte();

		Assure assure = new Assure();
		assure.setDateNaissance(DateUtils.buildDate("1998-01-01"));
		assure.setBonificationDisponible(true);
		contexte.setAssure(assure);

		Adhesion adhesion = buildAdhesion();
		adhesion.getGaranties().add(buildGarantie(TypeGarantie.INDEMNITES_PERTE_DE_REVENU ));
		contexte.getAdhesions().add(adhesion);

		DemandeDePrestation demande = new DemandeDePrestation();
		demande.setDateTraitement(DateUtils.buildDate("2023-01-01"));
		contexte.setDemandeDePrestation(demande);
		contexte.getDemandeDePrestation().getPiecesJustificatives().add(buildPieceJustificative(TypePieceJustificative.CERFA_ARRET_TRAVAIL));
		contexte.getDemandeDePrestation().getPiecesJustificatives()
				.add(buildPieceJustificative(TypePieceJustificative.BULLETIN_HOSPITALISATION));

		// contexte.getDemandeDePrestation().getEvenementsMedicaux().add(buildEvenementMedicaux());
	}

	/* private EvenementMedical buildEvenementMedicaux() {
		EvenementMedical ev = new EvenementMedical();
		ev.setType("I");
		ev.setCode("AT");
		ev.setDateDebut(buildDate("01/01/2022"));
		ev.setDateFin(buildDate("01/02/2022"));
		ev.setCodePathologique("BI");
		return ev;
	} */

	private PieceJustificative buildPieceJustificative(TypePieceJustificative type) {
		PieceJustificative pj = new PieceJustificative();
		pj.setType(type);
		pj.setDateDebutValidite(DateUtils.buildDate("2022-02-01"));
		pj.setDatefinValidite(DateUtils.buildDate("2022-02-03"));
		pj.setDateTransmission(DateUtils.buildDate("2022-02-04"));
		return pj;
	}

	// public static Date buildDate(String s) {
	// 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// 	try {
	// 		return dateFormat.parse(s);
	// 	} catch (ParseException e) {
	// 		throw new RuntimeException(e);
	// 	}
	// }

	private Adhesion buildAdhesion() {
		Adhesion a = new Adhesion();
		a.setGenerationContrat("A");
		return a;
	}

	public static Garantie buildGarantie(TypeGarantie typeGarantie) {
		Garantie g = new Garantie();
		g.setType(typeGarantie);

		g.setCode("IN");
		g.setNombreClasses(7);

		// A Absolue, SR Semi relative
		g.setTypeFranchise(TypeFranchise.ABSOLUE);

		g.setNombreJoursFranchiseHospitalisationSouscrite(0);
		g.setNombreJoursFranchiseAccidentSouscrite(3);
		g.setNombreJoursFranchiseMaladieSouscrite(15);
		return g;
	}
}
