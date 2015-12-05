package w2LabHomeworkLesson7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Qn1 {

}

class Conversion extends JFrame
{
	JTextField mileField;
	JTextField kmField;
	JTextField poundField;
	JTextField kgField;
	JTextField gallonField;
	JTextField literField;
	JTextField frField;
	JTextField ctField;
	Conversion()
	{
		setTitle("Metric Conversion Assistant");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel mileLabel = new JLabel("Mile:");
		mileLabel.setBounds(35,20,60,20);
		add(mileLabel);
		mileField = new JTextField(20);
		mileField.setBounds(65,20,100,20);
		add(mileField);
		
		JLabel kmLabel =new JLabel("Kilometer:");
		kmLabel.setBounds(180,20,60,20);
		add(kmLabel);
		kmField = new JTextField(20);
		kmField.setBounds(240, 20, 100, 20);
		add(kmField);
		
		JLabel poundLabel = new JLabel("Pound:");
		poundLabel.setBounds(25,50,60,20);
		add(poundLabel);
		poundField = new JTextField(20);
		poundField.setBounds(65,50,100,20);
		add(poundField);
		
		JLabel kgLabel =new JLabel("Kilogram:");
		kgLabel.setBounds(185,50,60,20);
		add(kgLabel);
		kgField = new JTextField(20);
		kgField.setBounds(240, 50, 100, 20);
		add(kgField);
		
		JLabel gallonLabel = new JLabel("Gallon:");
		gallonLabel.setBounds(25,80,60,20);
		add(gallonLabel);
		gallonField = new JTextField(20);
		gallonField.setBounds(65,80,100,20);
		add(gallonField);
		
		JLabel literLabel =new JLabel("Liter:");
		literLabel.setBounds(210,80,60,20);
		add(literLabel);
		literField = new JTextField(20);
		literField.setBounds(240, 80, 100, 20);
		add(literField);
		
		JLabel frLabel = new JLabel("Fahrenheit:");
		frLabel.setBounds(2,110,70,20);
		add(frLabel);
		frField = new JTextField(20);
		frField.setBounds(65,110,100,20);
		add(frField);
		
		JLabel ctLabel =new JLabel("Centigrade:");
		ctLabel.setBounds(175,110,70,20);
		add(ctLabel);
		ctField = new JTextField(20);
		ctField.setBounds(240, 110, 100, 20);
		add(ctField);
		
		//InnerConversion e = new InnerConversion();
		JButton btn = new JButton("Convert");
		btn.setBounds(130, 150, 100, 40);
		btn.addActionListener(
				evt->{
					DecimalFormat df = new DecimalFormat();
					
					if(mileField.getText().length()!=0)
					{
						float mile = Float.parseFloat(mileField.getText());
						df.setMaximumFractionDigits(2);
						kmField.setText(String.valueOf(df.format(mile*1.609344)));
					}
					
					if(poundField.getText().length() !=0)
					{
						float pound = Float.parseFloat(poundField.getText());
						float val = (float) (pound/2.2);
						df.setMaximumFractionDigits(2);
						kgField.setText(String.valueOf(df.format(val)));
					}
					
					if(gallonField.getText().length()!=0)
					{
						float gallon = Float.parseFloat(gallonField.getText());
						float val = (float)(gallon*3.785411784);
						df.setMaximumFractionDigits(2);
						literField.setText(String.valueOf(df.format(val)));
						
					}
					
					if(frField.getText().length()!=0)
					{
						float fr = Float.parseFloat(frField.getText());
						float val = (float) ((fr-32)*0.5556);
						df.setMaximumFractionDigits(2);
						ctField.setText(String.valueOf(df.format(val)));
					}
					
				});
		add(btn);
	}
	
	public static void main(String[] args)
	{
		Conversion c = new Conversion();
		c.setVisible(true);
	}
	
}