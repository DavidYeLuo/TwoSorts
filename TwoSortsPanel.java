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
		selectionNumbers[0] = 2;
		selectionNumbers[1] = 5;
		selectionNumbers[2] = 1;
		selectionNumbers[3] = 3;
		selectionNumbers[4] = 4;
		selectionNumbers[5] = 7;
		selectionNumbers[6] = 6;
		selectionNumbers[7] = 9;
		selectionNumbers[8] = 10;
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

		final int width = 10;
		final int middle = 250;
		final int gap = 20;
		
		
		int start = 150;
		g.setColor(Color.white);
		g.drawString("Selection Sort", middle/2+80, 60);
		for(int i=0; i<selectionNumbers.length; i++)
		{
			g.setColor(Color.red);
			g.fillRect(start, middle/2+50 - selectionNumbers[i]*10, width, selectionNumbers[i]* 10);
			g.setColor(Color.white);
			g.drawString(selectionNumbers[i].toString(), start, middle/2+50 +20);
			start += gap;
		}
		
		start = 150; //reset gap
		g.setColor(Color.white);
		g.drawString("Insertion Sort", middle/2+80, 240);
		for(int i=0; i<insertionNumbers.length;i++)
		{
			g.setColor(Color.green);
			g.fillRect(start, middle+100 - insertionNumbers[i]*10, width, insertionNumbers[i]* 10);
			g.setColor(Color.white);
			g.drawString(insertionNumbers[i].toString(), start, middle+100 +20);
			start += 20;
		}
		
		g.setColor(Color.white);
		g.drawString("Step: " + step, middle/2 -50, middle-30);
		
	}
	
	public void selectionSort()
	{
//		int smallest = selectionNumbers[0];
//		for(int y=0; y<selectionNumbers.length;y++)
//		{
//			for(int x=0; x<selectionNumbers.length;x++)
//			{
//				if(selectionNumbers)
//			}
//		}
	}
	public void insertionSort()
	{
		
	}
	private class NextButton implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			step++;
			repaint();
		}
		
	}
}
