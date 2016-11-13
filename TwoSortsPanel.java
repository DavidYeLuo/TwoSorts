import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TwoSortsPanel extends JPanel
{
	private Integer[] selectionNumbers;
	private Integer[] insertionNumbers;
	private JButton button;
	private int step;
	
	public TwoSortsPanel()
	{
		button = new JButton("Next");
		step = 0;
		
		selectionNumbers = new Integer[10];
		selectionNumbers[0] = 10;
		selectionNumbers[1] = 5;
		selectionNumbers[2] = 1;
		selectionNumbers[3] = 3;
		selectionNumbers[4] = 4;
		selectionNumbers[5] = 7;
		selectionNumbers[6] = 2;
		selectionNumbers[7] = 9;
		selectionNumbers[8] = 6;
		selectionNumbers[9] = 8;
		
		insertionNumbers = selectionNumbers.clone();
		
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
		int start = 150;
		g.setColor(Color.white);
		g.drawString("Selection Sort", center/2+80, 60);
		for(int i=0; i<selectionNumbers.length; i++)
		{
			g.setColor(Color.red);
			g.fillRect(start, center/2+50 - selectionNumbers[i]*10, width, selectionNumbers[i]* 10);
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
			g.fillRect(start, center+100 - insertionNumbers[i]*10, width, insertionNumbers[i]* 10);
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
			int min = step;
			int temp = selectionNumbers[step];
			
			for(int scan=step+1; scan<selectionNumbers.length;scan++)
			{
				if(selectionNumbers[scan].compareTo(selectionNumbers[min]) < 0)
				{
					temp = selectionNumbers[scan];
					min = scan;
				}
			}
			
			//swap the values
			selectionNumbers[min] = selectionNumbers[step];
			selectionNumbers[step] = temp;
		}
	}
	public void insertionSort()
	{
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
