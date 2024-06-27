package questionnaire_test.gui.console;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JList;

public class MouseSelection implements MouseMotionListener, MouseListener {

	private boolean tracking = false;
	private int initialIndex  = -1;
	
	public void mouseDragged(MouseEvent e) {
		if (tracking == false) return;
		JList<?> source = (JList<?>) e.getSource();
		int index = source.locationToIndex(e.getPoint());
		source.setSelectionInterval(initialIndex, index);
	}

	public void mouseMoved(MouseEvent e) {
	
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		tracking = true;
		JList<?> source = (JList<?>) e.getSource();
		initialIndex = source.locationToIndex(e.getPoint());
	}

	public void mouseReleased(MouseEvent e) {
		tracking = false;
	}
}
