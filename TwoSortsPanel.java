/**
 * TwoSortsPanel --- Program to show insertion and selection sort
 * @author       David Ye Luo, Kenta Medina
 * @version      1.0
 * @since        2016-11-22
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
   
public class TwoSortsPanel extends JPanel
{
	private Integer[] selectionNumbers;
	private Integer[] insertionNumbers;
	private boolean[] numbersTaken;  // used to record numbers
	private int generator;  // used with 
	private JButton button;
	private int step;  // record for button press
	
	// Useful variable used to plot images
	private final int width = 10;  // width of the bars
	private final int center = 250;  // location at half of the screen
	private final int gap = 20;  // the gap between bars
	
	//-----------------------------------------------------------
	// Default Constructor
	//-----------------------------------------------------------
	public TwoSortsPanel()
	{
		button = new JButton("Next");
		step = 0;
		selectionNumbers = new Integer[10];  // 0-9 Integers
		numbersTaken = new boolean[selectionNumbers.length+1];  // 0-10 booleans && 0 is not used
		
		// initialize all booleans to false
		for(int i=0;i<numbersTaken.length;i++)
		{
			numbersTaken[i] = false;
		}
		
		// initialize selectionNumbers[] with random numbers
		// numberTaken[] is used to prevent repeating numbers
		for(int i=0;i<selectionNumbers.length;i++)
		{
			generator = (int)(Math.random() * 10)+1; // generate number from 1-10
			while(numbersTaken[generator] == true)
			{
				generator = (int)(Math.random()*10)+1;
			}
			selectionNumbers[i] = generator;
			numbersTaken[generator] = true;  
		}
		
		insertionNumbers = selectionNumbers.clone();  // copy
		
		add(button);
		button.addActionListener(new NextButton());
		
		setBackground(Color.black);
		setPreferredSize(new Dimension(500,500));
	}

	//-----------------------------------------------------------
	// Draws the Panel
	//-----------------------------------------------------------
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// selection sort
		int start = 150;  // Where the first bar 
		g.setColor(Color.white);
		g.drawString("Selection Sort", center/2+80, 60);
		for(int i=0; i<selectionNumbers.length; i++)
		{
			if(isSorted(selectionNumbers))
			{
				g.setColor(Color.gray);
			}
			else
			{
				g.setColor(Color.red);
			}
			g.fillRect(start, 
					center/2+50 - selectionNumbers[i]*10, // reflects the bars to face up
					width, 
					selectionNumbers[i]* 10);  // selectionNumbers determines the height
			g.setColor(Color.white);
			g.drawString(selectionNumbers[i].toString(), start, center/2+50 +20);
			start += gap;
		}
		
		// insertion sort
		start = 150; //reset gap
		g.setColor(Color.white);
		g.drawString("Insertion Sort", center/2+80, 240);
		for(int i=0; i<insertionNumbers.length;i++)
		{
			if(isSorted(insertionNumbers))
			{
				g.setColor(Color.gray);
			}
			else
			{
				g.setColor(Color.green);
			}
			g.fillRect(start,
					center+100 - insertionNumbers[i]*10,  // reflects the bars to face up
					width, 
					insertionNumbers[i]* 10);  // insertionNumbers determines the height
			g.setColor(Color.white);
			g.drawString(insertionNumbers[i].toString(), start, center+100 +20);
			start += 20;
		}
		
		// show the step
		g.setColor(Color.white);
		g.drawString("Step: " + step, center/2 -50, center-30);
		
	}
	
	//-----------------------------------------------------------
	// Perform selectionSort depending on what step it is
	//-----------------------------------------------------------
	public void selectionSort()
	{
		if(step < selectionNumbers.length)
		{
			int min = step;  // the location where the smallest num is at
			int temp = selectionNumbers[step];  // used to swap variables
			
			for(int scan=step+1; scan<selectionNumbers.length;scan++)
			{
				if(selectionNumbers[scan].compareTo(selectionNumbers[min]) < 0)  // try the smallest number
				{
					temp = selectionNumbers[scan];  // record the number
					min = scan;  // record the location
				}
			}
			
			//swap the values
			selectionNumbers[min] = selectionNumbers[step];
			selectionNumbers[step] = temp;
		}
	}
	
	//-----------------------------------------------------------
	// Perform insertion sort depending on what step it is
	//-----------------------------------------------------------
	public void insertionSort()
	{
		for(int i=1; i<step+2;i++)
		{
			if(step < insertionNumbers.length)
			{
				Integer key = insertionNumbers[i];  // the number used to compare to
				int position = i;
				// shift the numbers
				while(position > 0 
						&& key.compareTo(insertionNumbers[position-1]) < 0) // compare the key to 
				{
					insertionNumbers[position] = insertionNumbers[position-1];
					position--;
				}
				insertionNumbers[position] = key;
			}
		}
	}
	
	//-----------------------------------------------------------
	// Check if the list is sorted
	//-----------------------------------------------------------
	public boolean isSorted(Integer[] list)
	{
		// return true if list is ascending order
		// return false for unsorted
		for(int i=0;i<list.length-1;i++)
		{
			if(list[i] > list[i+1])
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * NextButton --- Program to sort
	 * @author       David Ye Luo, Kenta Medina
	 * @version      1.0
	 * @since        2016-11-22
	 */
	private class NextButton implements ActionListener
	{
		//-----------------------------------------------------------
		// Listen for button press
		//-----------------------------------------------------------
		public void actionPerformed(ActionEvent e) 
		{
			selectionSort();
			insertionSort();
			step++;
			repaint();
		}
		
	}
}
