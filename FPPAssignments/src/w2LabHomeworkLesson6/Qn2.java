package w2LabHomeworkLesson6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Qn2 {

}

class RainBowColorFrame extends JFrame implements ActionListener
{
	RainBowColorFrame()
	{
		setTitle("Rainbow Color Frame");
	    setSize(760,140);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton btn1 = new JButton();
		btn1.setName("Red");
		btn1.setBackground(Color.RED);
		btn1.setPreferredSize(new Dimension(100,90));
		btn1.addActionListener(this);
		add(btn1);
		
		JButton btn2 = new JButton();
		btn2.setName("Orange");
		btn2.setBackground(Color.ORANGE);
		btn2.setPreferredSize(new Dimension(100,90));
		btn2.addActionListener(this);
		add(btn2);
		
		JButton btn3 = new JButton();
		btn3.setName("Green");
		btn3.setBackground(Color.GREEN);
		btn3.setPreferredSize(new Dimension(100,90));
		btn3.addActionListener(this);
		add(btn3);
		
		JButton btn4 = new JButton();
		btn4.setName("Blue");
		btn4.setBackground(Color.BLUE);
		btn4.setPreferredSize(new Dimension(100,90));
		btn4.addActionListener(this);
		add(btn4);
		
		JButton btn5 = new JButton();
		btn5.setName("Yellow");
		btn5.setBackground(Color.YELLOW);
		btn5.setPreferredSize(new Dimension(100,90));
		btn5.addActionListener(this);
		add(btn5);
		
		JButton btn6 = new JButton();
		btn6.setName("Indigo");
		btn6.setBackground(new Color(75,0,130));
		btn6.setPreferredSize(new Dimension(100,90));
		btn6.addActionListener(this);
		add(btn6);
		
		JButton btn7 = new JButton();
		btn7.setName("Purple");
		btn7.setBackground(new Color(155,48,255));
		btn7.setPreferredSize(new Dimension(100,90));
		btn7.addActionListener(this);
		add(btn7);
	}
	
	public static void main(String[] args)
	{
		RainBowColorFrame r = new RainBowColorFrame();
		r.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
			// TODO Auto-generated method stub
			JButton btn = (JButton) e.getSource();
			String btnName = btn.getName();
			if(btnName.equals("Red"))
				JOptionPane.showMessageDialog(btn, "Red signifies passion, vitality, enthusiasm and security.");
			else if(btnName.equals("Orange"))
				JOptionPane.showMessageDialog(btn, "Orange signifies creativity, productivity, pleasure and optimism.");
			else if(btnName.equals("Green"))
				JOptionPane.showMessageDialog(btn, "Green signifies nature, soothing, harmony and love.");
			else if(btnName.equals("Yellow"))
				JOptionPane.showMessageDialog(btn, "Yellow signifies joy, cheerfulness, intellect and friendliness.");
			else if(btnName.equals("Indigo"))
				JOptionPane.showMessageDialog(btn, "Indigo signifies companionship, friendship and love.");
			else if(btnName.equals("Purple"))
				JOptionPane.showMessageDialog(btn, "Purple signifies dignity, luxury, wisdom and passion.");
			else if(btnName.equals("Blue"))
				JOptionPane.showMessageDialog(btn, "Blue signifies peace, stability, calmness and confidence.");
	}
		
}