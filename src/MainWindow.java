import java.awt.EventQueue;
import javax.swing.*;

public class MainWindow 
{
	private JFrame frame;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainWindow()
	{
		initialize();
	}
	
	private void initialize()
	{
		frame = new JFrame("Chess");
		frame.setBounds(200, 25, 1200, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ControlPanel());
	}
}
