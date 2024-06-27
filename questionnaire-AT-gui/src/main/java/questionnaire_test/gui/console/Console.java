package questionnaire_test.gui.console;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Console extends Thread {

	private static Logger LOGGER = LoggerFactory.getLogger(Console.class);

	private final static Console instance = new Console();
	
	// pour le buffer de message
	private final Lock lock = new ReentrantLock();
	private final List<Message> messagesBuffer = new LinkedList<Message>();
	
	private JList<Message> messages;
	private DefaultListModel<Message> model;
	private JScrollPane scrollPane;
	private JPanel panel;


	private Console() {
		buildConsole();
		start();
	}
	
	public void clear() {
		 model.removeAllElements();
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			try {
			lock.lock();
				if (messagesBuffer.isEmpty() == false) {
					final List<Message> messagesBufferCopy = new LinkedList<Message>(messagesBuffer); 
					messagesBuffer.clear();
					try {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								messagesBufferCopy.stream().forEachOrdered(model::addElement);
								messages.ensureIndexIsVisible(model.size() - 1);
							}
						});
					} catch (Exception e) {
					} 
					
				}
			}
			catch (Exception e) {
			}
			finally {
				lock.unlock();
			}
			}
		
	}

	public void addMouseListener(MouseListener l) {
		messages.addMouseListener(l);
	}
	
	private void buildConsole() {
		panel = new JPanel(new BorderLayout());
		
		panel.setBorder(BorderFactory.createEmptyBorder());
		
		model = new DefaultListModel<Message>();
		messages = new JList<Message>(model);
		messages.setCellRenderer(new ConsoleRenderer());
		MouseSelection m = new MouseSelection();
		messages.addMouseMotionListener(m);
		messages.addMouseListener(m);
		
		final JPopupMenu menu = new JPopupMenu("Console_Popup");
		menu.setBorder(BorderFactory.createEmptyBorder());
		JMenuItem clearAction = new JMenuItem("Effacer");
	    menu.add(clearAction);
		clearAction.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  model.removeAllElements();
	      }
	    });

		JMenuItem selectAllAllAction = new JMenuItem("Sélectionner");
	    menu.add(selectAllAllAction);
	    selectAllAllAction.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  final int size = model.getSize();
		    	  if (size != 0)
		    		  messages.setSelectionInterval(0, size -1);
		      }
		    });
		
		messages.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent ev) {
				if (ev.isPopupTrigger()) {
					menu.show(ev.getComponent(), ev.getX(), ev.getY());
				}
			}

			public void mouseReleased(MouseEvent ev) {
				if (ev.isPopupTrigger()) {
					menu.show(ev.getComponent(), ev.getX(), ev.getY());
				}
			}
		});

		scrollPane = new JScrollPane(messages);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		panel.add(scrollPane);
	}

	public void addMessage(final Message obj) {
		LOGGER.info(obj.toString());
		lock.lock();
		messagesBuffer.add(obj);
		lock.unlock();
	}

	public void addMessage(final String s) {
		LOGGER.info(s);
		lock.lock();
		messagesBuffer.add(Message.buildMessage(s));
		lock.unlock();
	}

	public void addMessage(Exception e) {
		lock.lock();
		String[] stackTrace = ExceptionUtils.getStackFrames(e);
		for (String st : stackTrace) {
			messagesBuffer.add(Message.buildMessage(st, Color.RED));
		}
		lock.unlock();
	}
	public JComponent getComponent() {
		return panel;
	}

	public static Console getInstance() {
		return instance;
	}

}
