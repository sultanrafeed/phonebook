package DEM;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MAINPAGE extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel mainLabel = new JLabel("CONTACTX");
	JButton Add = new JButton("ADD");
	JButton Edit = new JButton("EDIT");
	JButton Search = new JButton("SEARCH");
	JButton List = new JButton("LIST");
	JButton Remove = new JButton("REMOVE");
	JButton Logout = new JButton("LOGOUT");
	private JLabel imageLabel;
	  private ImageIcon imageIcon; 
	  private ImageIcon logoIcon;
	   
	
	
	 MAINPAGE() {
  	 this.setTitle("CONTACTX MANAGEMENT");
     this.getContentPane().setBackground(new Color(107, 179, 157));
     this.setBounds(500, 150, 550, 550);   
  imageIcon = new ImageIcon(getClass().getResource("Copy of Contact X.gif"));
     
     imageLabel = new JLabel(imageIcon);
 
    imageLabel.setBounds(60,160,imageIcon.getIconWidth(),imageIcon.getIconHeight());
   
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

 	  mainLabel.setBounds(220,70,100,30);
 	  mainLabel.setForeground(Color.DARK_GRAY);
 	  mainLabel.setFont(new Font("Phosphate",Font.BOLD,17));
		Add.setBounds(330, 120, 100, 30);
		 List.setBounds(330, 170, 100, 30);
		 Search.setBounds(330, 220, 100, 30);
		 Edit.setBounds(330, 270, 100, 30);
		 Remove.setBounds(330, 320, 100, 30);
	   Logout.setBounds(330, 370, 100, 30);
	 }
	 
	 public void addComponentsToContainer() {
		 container.add(mainLabel);
		 container.add(Add);
		 container.add(Edit);
		 container.add(Search);
		 container.add(List);
		 container.add(Remove);
		 container.add(Logout);
		 container.add(imageLabel);
	 }
	 public void addActionEvent() {
		 Add.addActionListener(this);
		 Edit.addActionListener(this);
		 Search.addActionListener(this);
		 List.addActionListener(this);
		 Remove.addActionListener(this);
		 Logout.addActionListener(this);
	 }
	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == Add) {
			 this.setVisible(false);
			ADD info = new ADD();
			 //info.setVisible(true);
	 }
		 if (e.getSource() == Search) {
			 this.setVisible(false);
			SEARCH search = new SEARCH();
			 search.setVisible(true);
		 }
		 
		 if (e.getSource() == Logout) {
			 JOptionPane.showMessageDialog(this, "Logout");
			 this.setVisible(false);
			 LoginFrame frame = new LoginFrame();
			 frame.setVisible(true);
		 }
		 if (e.getSource() == List) {
			 this.setVisible(false);
			 LIST list = new LIST();
			 
			 list.setVisible(true);
		 }
	 
		 if (e.getSource() == Edit) {
			 this.setVisible(false);
			 		EDIT edit = new EDIT();
			 		edit.setVisible(true);
			
		 }
		 if (e.getSource() == Remove) {
			 this.setVisible(false);
			 REMOVE rem = new REMOVE();
			 rem.setVisible(true);
		 }
}
}
