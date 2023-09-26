import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ControlPanel extends JPanel implements Runnable
{
	private ImageIcon sprite;
	private int spriteX, spriteY;
	private Thread thread;
	
	public ControlPanel()
	{
		sprite = new ImageIcon("buggyBot.png");
		setBackground(Color.BLACK);
		spriteX = 25;
		spriteY = 25;
		thread = new Thread(this);
		thread.start();
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new GameListener());
	}
	
	class GameListener implements KeyListener
	{
		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_A)
				spriteX -= 10;
			if (e.getKeyCode() == KeyEvent.VK_D)
				spriteX += 10;
			if (e.getKeyCode() == KeyEvent.VK_W)
				spriteY -= 10;
			if (e.getKeyCode() == KeyEvent.VK_S)
				spriteY += 10;
		}
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0,  0, 1200, 1000);
		sprite.paintIcon(this, g, spriteX, spriteY);
		g.setColor(Color.BLACK);
		g.fillRect(spriteX,  spriteY,  50, 50);
		g.setColor(Color.WHITE);
		g.drawString("P", spriteX+20, spriteY+30);
	}
	
	public void run()
	{
		Control control = new Control(this);
		
		ChessPiece piece = new ChessPiece();
		piece.setSize(200,200);
		piece.setVisible(true);
		
		while(true)
		{
			control.updateSprite();
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	public int getSpriteX()
	{
		return spriteX;
	}
	public int getSpriteY()
	{
		return spriteY;
	}
	
	public void setSprite(int newX, int newY)
	{
		spriteX = newX;
		spriteY = newY;
	}
}
