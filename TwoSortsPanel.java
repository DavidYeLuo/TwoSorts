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


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		final int width = 10;  // width of the bars
		final int center = 250;  // location at half of the screen
		final int gap = 20;  // gap between bars
		
		// selection sort
		int start = 150;  // Where the first bar 
		g.setColor(Color.white);
		g.drawString("Selection Sort", center/2+80, 60);
		for(int i=0; i<selectionNumbers.length; i++)
		{
			g.setColor(Color.red);
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
			g.setColor(Color.green);
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
	
	public void insertionSort()
	{
		for(int i=1; i<step+1;i++)
		{
			if(step < insertionNumbers.length)
			{
				Integer key = insertionNumbers[i];  // the number used to compare to
				int position = i;
				// shift the numbers to the right place
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
	private class NextButton implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			selectionSort();
			insertionSort();
			step++;
			repaint();
		}
		
	}
}
