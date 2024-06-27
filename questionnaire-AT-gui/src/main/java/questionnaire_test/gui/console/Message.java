package questionnaire_test.gui.console;

import java.awt.Color;

public class Message {

	private Object object;

	private String message;
	private Color color;
	
	
	public static Message buildMessage(String s) {
		return new Message(s, null, null);
	}
		public static Message buildMessage(String s, Color color) {
		return new Message(s, color, null);
	}
	public static Message buildMessage(String s, Object o) {
		return new Message(s, null, o);
	}
	public static Message buildMessage(String s, Object o, Color color) {
		return new Message(s, color, o);
	}	
	
	protected Message(String message, Color color, Object object) {
		this.message = message;
		this.color = color;
		this.object = object;
	}
	
	public Object getObject() {
		return object;
	}
	
	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return message;
	}
}
