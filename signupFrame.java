package DEM;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class signupFrame extends JFrame implements ActionListener {
	
	String path = "/Users/taseenhakim/eclipse-workspace/LABPROJECTDEMO/src/DEM/registrationfile.txt"; 


	Container container = getContentPane();
	JLabel mainLabel = new JLabel("CONTACTX");
	JLabel name = new JLabel("NAME");
	JTextField tname = new JTextField();
  JLabel id = new JLabel("COM-ID");
  JTextField tid = new JTextField();
  JLabel password = new JLabel("PASSWORD");
  JTextField tpass = new JTextField();
  JCheckBox showPassword = new JCheckBox("Show Password");
  private JLabel imageLabel;
  private ImageIcon imageIcon; 
	
  
  JButton savebutton = new JButton("SAVE");
  JButton cancelbutton = new JButton("CANCEL");
   
  signupFrame(){
  	this.setTitle("CONTACTX MANAGEMENT");
    this.getContentPane().setBackground(new Color(107, 179, 157));
    this.setBounds(450, 130, 500, 500);
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
    mainLabel.setBounds(140,70,100,30);
	  mainLabel.setForeground(Color.DARK_GRAY);
	  mainLabel.setFont(new Font("Phosphate",Font.BOLD,17));
	  name.setBounds(70, 150, 100, 30);
	  tname.setBounds(150, 150, 300, 30);
	  id.setBounds(70, 200, 100, 30);
	  tid.setBounds(150, 200, 300, 30);
	  password.setBounds(70, 250, 100, 30);
	  tpass.setBounds(150, 250, 300, 30);
	  showPassword.setBounds(100, 250, 150, 30);

	  savebutton.setBounds(150, 320, 100, 30);
	  cancelbutton.setBounds(250, 320, 100, 30);
  }
  public void addComponentsToContainer() {
  	container.add(mainLabel);
  	
  	container.add(name);
  	container.add(tname);
  	container.add(id);
  	container.add(tid);
  	container.add(password);
  	container.add(tpass);
  	//container.add(showPassword);
  	container.add(savebutton);
 	 container.add(cancelbutton);
 	 
  }
  
  public void addActionEvent() {
  	savebutton.addActionListener(this);
  	cancelbutton.addActionListener(this);
  	showPassword.addActionListener(this);
  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == savebutton) {
			 try {
			FileWriter file = new FileWriter(path,true);
			file.write(tname.getText()+" "+tid.getText()+" "+tpass.getText()+"\n" );
			file.close();
			JOptionPane.showMessageDialog(this, "SAVED DATA");
			this.setVisible(false);
			LoginFrame page = new LoginFrame();
	    page.setVisible(true);
			
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				}
		}
		
		
		
		

		if (e.getSource() == cancelbutton) {
			JOptionPane.showMessageDialog(this, "CANCELLED");
			this.setVisible(false);
			LoginFrame frame = new LoginFrame();
			 frame.setVisible(true);
		}
	  


  }
	}
	
