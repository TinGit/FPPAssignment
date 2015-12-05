package w2LabHomeworkLesson6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ExtraCredit extends JFrame{

	@SuppressWarnings("unchecked")
	ExtraCredit()
	{
		setTitle("");
		setSize(600,600);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel head = new JLabel("Welcome to Maharishi University of Management");
		head.setBounds(140,5,300,20);
		add(head);
		JLabel subhead = new JLabel("Online class registration form");
		subhead.setBounds(200,25,180,20);
		add(subhead);
		
		JLabel fname = new JLabel("First name:");
		fname.setBounds(20,55,100,20);
		add(fname);
		
		JTextField ffield = new JTextField(20);
		ffield.setBounds(200,55,200,20);
		add(ffield);
		
		JLabel lname = new JLabel("Last name:");
		lname.setBounds(20,80,100,20);
		add(lname);
		
		JTextField lfield = new JTextField(20);
		lfield.setBounds(200,80,200,20);
		add(lfield);
		
		JLabel street = new JLabel("Street:");
		street.setBounds(20,105,100,20);
		add(street);
		
		JTextField sfield = new JTextField(20);
		sfield.setBounds(200,105,200,20);
		add(sfield);
		
		JLabel city = new JLabel("City:");
		city.setBounds(20,130,100,20);
		add(city);
		
		JTextField cfield = new JTextField(20);
		cfield.setBounds(200,130,200,20);
		add(cfield);
		
		JLabel state = new JLabel("State:");
		state.setBounds(20,155,100,20);
		add(state);
		
		JTextField statefield = new JTextField(20);
		statefield.setBounds(200,155,200,20);
		add(statefield);
		
		JLabel country = new JLabel("Country:");
		country.setBounds(20,180,100,20);
		add(country);
		
		JTextField countryfield = new JTextField(20);
		countryfield.setBounds(200,180,200,20);
		add(countryfield);
		
		JLabel gender = new JLabel("Gender:");
		gender.setBounds(20,205,100,20);
		add(gender);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(210, 205, 60, 20);
		add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(280, 205, 80, 20);
		add(female);
		
		JLabel courselabel = new JLabel("Select Course:");
		courselabel.setBounds(20,230,100,20);
		add(courselabel);
		
		//String[] courses = new String[]{"Java","C++","Algorithm"};
		JComboBox course = new JComboBox();
		course.addItem("Java");
		course.addItem("Algorithm");
		course.addItem("C++");
		course.setBounds(200, 230, 200, 20);
		add(course);
		
		JLabel session = new JLabel("Suitable Session:");
		session.setBounds(20,260,100,20);
		add(session);
		
		JCheckBox morning = new JCheckBox("Morning");
		morning.setBounds(210,260,80,20);
		add(morning);
		
		JCheckBox afternoon = new JCheckBox("Afternoon");
		afternoon.setBounds(290,260,100,20);
		add(afternoon);
		
		JCheckBox evening = new JCheckBox("Evening");
		evening.setBounds(390,260,80,20);
		add(evening);
		
		JLabel msg = new JLabel("Message:");
		msg.setBounds(20,285,100,20);
		add(msg);
		
		JTextArea msgArea = new JTextArea();
		msgArea.setBounds(200,285,300,150);
		add(msgArea);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(200,460,200,30);
		add(submit);
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean notComplete = false;
				if(ffield.getText().isEmpty() || lfield.getText().isEmpty() || sfield.getText().isEmpty() || cfield.getText().isEmpty()
						|| statefield.getText().isEmpty() || countryfield.getText().isEmpty() || msgArea.getText().isEmpty())
				{
					notComplete = true;
					JOptionPane.showMessageDialog(null, "Fill all blank fields to complete registration");
				}
				
			if(notComplete == false)
			{
				if(male.isSelected())
				{
					if(female.isSelected())
					{
						notComplete = true;
						JOptionPane.showMessageDialog(null, "Select either male/female one for gender");
					}
				}
				else if(!(male.isSelected()))
				{
					if(!(female.isSelected()))
					{
						notComplete = true;
						JOptionPane.showMessageDialog(null, "Enter gender information");
					}
				}
			}	
			if(notComplete == false)
			{
				if(morning.isSelected())
				{
					if(evening.isSelected() || afternoon.isSelected())
					{
						notComplete = true;
						JOptionPane.showMessageDialog(null, "Select only one session");
					}
				}
				else if(evening.isSelected())
				{
					if(morning.isSelected() || afternoon.isSelected())
					{
						notComplete = true;
						JOptionPane.showMessageDialog(null, "Select only one session");
					}
				}
				if(afternoon.isSelected())
				{
					if(morning.isSelected() || evening.isSelected())
					{
						notComplete = true;
						JOptionPane.showMessageDialog(null, "Select only one session");
					}
				}
				else
				{
					notComplete = true;
					JOptionPane.showMessageDialog(null, "Check your choice of session please");
				}
			}
			
			if(notComplete == false)
				JOptionPane.showMessageDialog(null, "Successfully Registered");
			}
			
		});
	}
	
	public static void main(String[] args)
	{
		ExtraCredit ec = new ExtraCredit();
		ec.setVisible(true);
	}
}
