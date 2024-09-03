package DEM;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ADD extends JFrame implements ActionListener {
	String path = "/Users/taseenhakim/eclipse-workspace/LABPROJECTDEMO/src/DEM/CONtact.txt"; 
	
	Container container = getContentPane();
	JLabel mainLabel = new JLabel("CONTACTX");
	JLabel addLabel = new JLabel("ADD");
	JLabel firstname = new JLabel("FIRST NAME");
	JTextField Fname = new JTextField();
  JLabel lastname = new JLabel("LAST NAME");
  JTextField Lname = new JTextField();
  JLabel age = new JLabel("AGE");
  JLabel gender = new JLabel("GENDER");
  JTextField Ggender = new JTextField();
  JTextField Fage = new JTextField();
  JLabel post = new JLabel("POST");
  JTextField Fpost = new JTextField();
  JLabel number = new JLabel("NUMBER");
  JTextField Fnumber = new JTextField();
  JLabel email = new JLabel("EMAIL");
  JTextField Femail = new JTextField();
  JLabel address = new JLabel("ADDRESS");
  JTextField Faddress = new JTextField();
  
  JButton savebutton = new JButton("SAVE");
  JButton cancelbutton = new JButton("CANCEL");
  
  ADD(){
  	 this.setTitle("CONTACTX MANAGEMENT");
     this.getContentPane().setBackground(new Color(107, 179, 157));
     this.setBounds(450, 130, 600, 650);
     this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
     this.setResizable(false);
     
     
     setLayoutManager();
     setLocationAndSize();
     addComponentsToContainer();
     addActionEvent();
     
     
     
     this.setVisible(true);

  }
  public void setLayoutManager() {
    container.setLayout(null);
}


public void setLocationAndSize() {
    mainLabel.setBounds(140,70,100,30);
	  mainLabel.setForeground(Color.DARK_GRAY);
	  mainLabel.setFont(new Font("Phosphate",Font.BOLD,17));
	  addLabel.setBounds(90, 110, 100, 40);
	  addLabel.setForeground(Color.DARK_GRAY);
	  addLabel.setFont(new Font("copperplate",Font.BOLD,17));
	  firstname.setBounds(70, 150, 100, 30);
	  Fname.setBounds(150, 150, 300, 30);
	  lastname.setBounds(70, 200, 100, 30);
	  Lname.setBounds(150, 200, 300, 30);
	  age.setBounds(70, 250, 100, 30);
	  Fage.setBounds(150, 250, 300, 30);
	  gender.setBounds(70,300 , 100, 30);
		Ggender.setBounds(150,300 , 300, 30);
		post.setBounds(70, 350, 100, 30);
	  Fpost.setBounds(150, 350, 300, 30); 
	  number.setBounds(70, 400, 100, 30);
	  Fnumber.setBounds(150, 400, 300, 30);
	  email.setBounds(70, 450, 100, 30);
	  Femail.setBounds(150, 450, 300, 30);
	 address.setBounds(70, 500, 100, 30);
	 Faddress.setBounds(150, 500, 300, 30);
	
	 
	  savebutton.setBounds(200, 570, 100, 30);
	  cancelbutton.setBounds(300, 570, 100, 30);
	 
}
public void addComponentsToContainer() {
	 container.add(mainLabel);
	 container.add(addLabel);
	 container.add(firstname);
	 container.add(Fname);
	 container.add(lastname);
	 container.add(Lname);
	 container.add(age);
	 container.add(Fage);
	 container.add(post);
	 container.add(Fpost);
	 container.add(number);
	 container.add(Fnumber);
	 container.add(email);
	 container.add(Femail);
	 container.add(address);
	 container.add(Faddress);
	 container.add(gender);
	 container.add(Ggender);
	 container.add(savebutton);
	 container.add(cancelbutton);
	 
}
public void addActionEvent() {
	savebutton.addActionListener(this);
	cancelbutton.addActionListener(this);
}
 
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == savebutton) {
		  try {
		  	
		  		FileWriter file = new FileWriter(path,true);
				file.write(Fname.getText()+" "+Lname.getText()+" "+Fage.getText()+" "+Ggender.getText()+" "+Fpost.getText()+" "+Fnumber.getText()+" "+Femail.getText()+" "+Faddress.getText()+"\n" );
				file.close();
				JOptionPane.showMessageDialog(this, "SAVED DATA");
				this.setVisible(false);
				MAINPAGE page = new MAINPAGE();
		    page.setVisible(true);
		  
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			}
	}
			
		
	
	if (e.getSource() == cancelbutton) {
		JOptionPane.showMessageDialog(this, "CANCELLED");
		this.setVisible(false);
		MAINPAGE page = new MAINPAGE();
    page.setVisible(true);
	}
}
}