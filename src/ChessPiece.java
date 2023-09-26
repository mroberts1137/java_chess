import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessPiece extends ControlPanel
{
	private JPanel mousePanel;
	private JLabel statusbar;
	
	public ChessPiece()
	{
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);
		
		statusbar = new JLabel("default");
		add(statusbar, BorderLayout.SOUTH);
		
		HandlerClass handler = new HandlerClass();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	}
	
	private class HandlerClass implements MouseListener, MouseMotionListener
	{
		public void mouseClicked(MouseEvent event)
		{
			statusbar.setText(String.format("Clicked at %d, %d", event.getX(), event.getY()));
		}
		public void mousePressed(MouseEvent event)
		{
			statusbar.setText("mouse been pressed");
		}
		public void mouseReleased(MouseEvent event)
		{
			statusbar.setText("mouse been released");
		}
		public void mouseEntered(MouseEvent event)
		{
			statusbar.setText("enetered poanel");
			mousePanel.setBackground(Color.BLUE);
		}
		public void mouseExited(MouseEvent event)
		{
			statusbar.setText("mouse left");
			mousePanel.setBackground(Color.WHITE);
		}
		public void mouseDragged(MouseEvent event)
		{
			statusbar.setText("Dragging mouse");
		}
		public void mouseMoved(MouseEvent event)
		{
			statusbar.setText("moving mouse");
		}
	}
}
