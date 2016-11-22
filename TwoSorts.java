/**
 * TwoSorts --- Shows step by step sorting algorithm
 * @author       David Ye Luo, Kenta Medina
 * @version      1.0
 * @since        2016-11-22
 */
//-----------------------------------------------------------
// 1) Generate a list with 10 random numbers
// 2) Sorting Algorithm
//    a) Add button
//    b) When button clicked, take one step on sorting
// 3) When the list is sorted, make the bars gray.
//-----------------------------------------------------------
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