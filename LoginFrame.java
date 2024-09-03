package DEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
	String path = "/Users/taseenhakim/eclipse-workspace/LABPROJECTDEMO/src/DEM/registrationfile.txt"; 
  Container container = getContentPane();
  JLabel mainLabel = new JLabel("CONTACTX");
  JLabel userLabel = new JLabel("USERNAME");
  JLabel passwordLabel = new JLabel("PASSWORD");
  JTextField userTextField = new JTextField();
  JPasswordField passwordField = new JPasswordField();
  JButton loginButton = new JButton("LOGIN");
  JButton signButton = new JButton("SIGNUP");
  private JLabel imageLabel;
  private ImageIcon imageIcon; 
  private ImageIcon logoIcon;
   

  
  JCheckBox showPassword = new JCheckBox("Show Password");


  LoginFrame() {
  	 this.setTitle("CONTACTX MANAGEMENT");
  	
  	 
     this.getContentPane().setBackground(new Color(107, 179, 157));
     this.setBounds(600, 150, 370, 450);
     
     imageIcon = new ImageIcon(getClass().getResource("contactxlogo4choto_adobespark_3.png"));
     
     imageLabel = new JLabel(imageIcon);
 
     imageLabel.setBounds(90,60,imageIcon.getIconWidth(),imageIcon.getIconHeight());
     
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
  	
  	  mainLabel.setForeground(Color.DARK_GRAY);
  	  mainLabel.setFont(new Font("Phosphate",Font.BOLD,17));
      userLabel.setBounds(50, 150, 100, 30);
      passwordLabel.setBounds(50, 220, 100, 30);
      userTextField.setBounds(150, 150, 150, 30);
      passwordField.setBounds(150, 220, 150, 30);
      showPassword.setBounds(150, 250, 150, 30);
      loginButton.setBounds(130, 300, 100, 30);
      signButton.setBounds(130, 330, 100, 30);
    


  }

  public void addComponentsToContainer() {
  
      container.add(userLabel);
      container.add(passwordLabel);
      container.add(userTextField);
      container.add(passwordField);
      container.add(showPassword);
      container.add(loginButton);
      container.add(imageLabel);
      container.add(signButton);
  }

  public void addActionEvent() {
      loginButton.addActionListener(this);
      signButton.addActionListener(this);
      showPassword.addActionListener(this);
  }


  @Override
  public void actionPerformed(ActionEvent e) {

  	 if (e.getSource() == loginButton) {
  	      	String userText;
  	        String pwdText;
  	        userText = userTextField.getText();
  	        pwdText = passwordField.getText();
  	        try {
  	        	FileReader fr = new FileReader(path);
  	          BufferedReader br = new BufferedReader(fr);
  	          boolean isLoginSuccess = false;
  	          int u=0;
  	          
  	          String line, fusername, fid, fpass;
  	          while((line = br.readLine()) != null)
  	          {
  	            
  	            fusername = line.split(" ")[0];
  	               fpass = line.split(" ")[2];
  	               if ((fusername.equalsIgnoreCase(userText)) && fpass.equalsIgnoreCase(pwdText)) {
  	                 //isLoginSuccess = true;
  	              	 JOptionPane.showMessageDialog(this, "Login Successful");

  	                 this.setVisible(false);
  	                
  	                 MAINPAGE p = new MAINPAGE();
  	                p.setVisible(true);
  	    
  	               
  	            }
  	               else 
  	            {
  	             
  	             
  	             JOptionPane.showMessageDialog(this, "Invalid Username or Password");             
  	             
  	            }
  	            
  	            fr.close();
  	            //get.close();

  	 }
  	        }
  	 catch (Exception ep) {
  	 System.out.println("ERROR 404! File-Not-Found");
  	            //ep.printStackTrace();
  	        }
  	         }
  	         

  	
  	
  	
      if (e.getSource() == signButton) {
      	this.setVisible(false);
      	signupFrame s = new signupFrame();
      	s.setVisible(true);
      }
      
      
      if (e.getSource() == showPassword) {
          if (showPassword.isSelected()) {
              passwordField.setEchoChar((char) 0);
          } else {
              passwordField.setEchoChar('*');
          }


      }
  }

}