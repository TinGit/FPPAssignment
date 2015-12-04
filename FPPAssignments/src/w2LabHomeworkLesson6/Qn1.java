package w2LabHomeworkLesson6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Qn1 {

}

class StringUtility extends JFrame{

	StringUtility()
	{
		setTitle("String Manipulation");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(0,0,300,300);
		//setLayout(new BorderLayout());
		
		JPanel jp = new JPanel();
	//	jp.setBounds(0, 0, 70, 400);
		jp.setLayout(null);
		
		JButton count = new JButton("Count Letters");
		count.setBounds(20,20,150,20);
		jp.add(count);
		
		JButton reverse = new JButton("Reverse Letters");
		reverse.setBounds(20,60,150,20);
		jp.add(reverse);
		
		JButton remove =new JButton("Remove Duplicates");
		remove.setBounds(20,100,150,20);
		jp.add(remove);
		
		//JPanel jp2 = new JPanel();
		//jp2.setBounds(0, 200, 70, 400);
		//jp2.setLayout(null);
		JLabel in = new JLabel("Input");
		in.setBounds(200,20,40,20);
		jp.add(in);
		
		JTextField input = new JTextField(20);
		input.setBounds(200,40,150,20);
		jp.add(input);
		
		
		JLabel out = new JLabel("Output");
		out.setBounds(200, 60, 40, 20);
		jp.add(out);
		
		JTextField output = new JTextField(20);
		output.setBounds(200,80,150,20);
		jp.add(output);
		
		add(jp);
		
		//Anonymous class
		count.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				output.setText(String.valueOf(count(input.getText())));
			}
		});
		
		reverse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				output.setText(reverse(input.getText()));
			}
		});
		
		remove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				output.setText(remove(input.getText()));
			}
		});
}
	

	
	public static void main(String[] args)
	{
		StringUtility su = new StringUtility();
		su.setVisible(true);	
	}
	
	public int count(String input)
	{	
		return input.length();
	}
	
	public String reverse(String input)
	{
		if(input.length()==0)
			return "";
		int len = input.length();
		return input.charAt(len-1)+reverse(input.substring(0, len-1));	
	}
	
	public String remove(String input)
	{
		boolean duplicate = false;
		String ret="";
		
		for(int i=0;i<=input.length()-1;i++)
		{
			for(int j=i+1;j<input.length();j++)
			{
				if(input.charAt(i) == input.charAt(j))
				{
					duplicate = true;
					break;
				}
			}
			if(duplicate==false)
			{
				ret=ret+input.charAt(i);
			}
			else
				duplicate=false;
		}
		return ret;
	}

}
