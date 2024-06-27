package questionnaire_test.gui.console;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ConsoleRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (value instanceof Message) {
			Message m = (Message) value;
			if (m.getColor() != null) {
				setForeground(m.getColor());
			}
			setText(m.toString());
		}
		setOpaque(isSelected);
		return this;
	}

}
