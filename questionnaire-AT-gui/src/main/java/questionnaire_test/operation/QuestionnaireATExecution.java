package questionnaire_test.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adis.questionnaire.domaine.TypeGarantie;
import com.adis.questionnaire.mdl.Adhesion;
import com.adis.questionnaire.mdl.Contexte;
import com.adis.questionnaire.mdl.EvaluationDemande;
import com.adis.questionnaire.mdl.Garantie;
import com.adis.questionnaire.quest.Questionnaire;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuestionnaireATExecution {

	private static Logger LOGGER = LoggerFactory.getLogger(QuestionnaireATExecution.class);

	private ObjectMapper mapper = new ObjectMapper();

	private URL url;
	private HttpURLConnection conn;

	private Questionnaire questionnaire;
	private EvaluationDemande evaluationDemande;

	public static final void main(String[] args) throws IOException {

		Garantie g = new Garantie();
		g.setType(TypeGarantie.REMBOURSEMENT_FRAIS_PROFESSIONNEL);
		Contexte contexte = new Contexte();
		Adhesion a = new Adhesion();
		a.getGaranties().add(g);
		contexte.getAdhesions().add(a);

		Questionnaire q = new Questionnaire();

		QuestionnaireATExecution op = new QuestionnaireATExecution(new URL("http://localhost:8080/quest"));
		op.run(contexte, q);
	}

	public QuestionnaireATExecution(URL url) {
		this.url = url;
	}

	private void initConnection() throws IOException {
		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	}

	public void run(Contexte contexte, Questionnaire questionnaire) throws IOException {
		initConnection();

		this.evaluationDemande = new EvaluationDemande();
		this.questionnaire = questionnaire;

		String input = mapper.writeValueAsString(new RequeteAt(contexte, questionnaire));
		LOGGER.debug(input);
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes(StandardCharsets.UTF_8));
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

		String output;

		StringBuilder sb = new StringBuilder();
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		LOGGER.debug(sb.toString());
		ReponseAT reponseAT = mapper.readValue(sb.toString(), ReponseAT.class);

		this.questionnaire = reponseAT.getQuestionnaire();
		this.evaluationDemande = reponseAT.getEvaluationDemande();

		disposeConnection();
	}

	private void disposeConnection() {
		if (conn != null) {
			conn.disconnect();
		}
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public EvaluationDemande getEvaluationDemande() {
		return evaluationDemande;
	}
}
