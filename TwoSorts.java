import javax.swing.*;

public class TwoSorts
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new TwoSortsPanel());
		frame.setVisible(true);
		frame.pack();
	}
}
