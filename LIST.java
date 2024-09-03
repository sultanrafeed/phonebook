package DEM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;    
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;  


public class LIST extends JFrame implements ActionListener{
	int n;
	Person myCourses[] = new Person[n];
	
	String path = "/Users/taseenhakim/eclipse-workspace/LABPROJECTDEMO/src/DEM/CONtact.txt"; 

	Container con = getContentPane();
	JButton backButton = new JButton("<-");
	DefaultTableModel model = new DefaultTableModel();
	JTable courseTable = new JTable(model);
	JScrollPane scroll = new JScrollPane(courseTable);
	JLabel mainLabel = new JLabel("CONTACTX");
	private JLabel imageLabel;
  private ImageIcon imageIcon; 
	LIST()
	{
		
		 this.setTitle("CONTACTX MANAGEMENT");
     this.getContentPane().setBackground(new Color(107, 179, 157));
     this.setBounds(300, 100, 700, 600);
 imageIcon = new ImageIcon(getClass().getResource("Copy of Contact X.gif"));
     
     imageLabel = new JLabel(imageIcon);
 
    imageLabel.setBounds(250,320,imageIcon.getIconWidth(),imageIcon.getIconHeight());
    
     this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
     this.setResizable(false);
     
        
        countLines();
        Load();
        
        LoadTable();
        
        Init();
        addActionEvent();
	}
	
	public void Init()
	{	
		con.setLayout(null);
		con.setBackground(new Color(107, 179, 157));
		scroll.setBounds(100, 100, 500, 200);
    	con.add(scroll);
    	

   	  mainLabel.setBounds(300,60,100,30);
   	  mainLabel.setForeground(Color.DARK_GRAY);
   	  mainLabel.setFont(new Font("Phosphate",Font.BOLD,17));
   	  con.add(mainLabel);
   	  
   	 con.add(imageLabel);
		
        
        backButton.setBounds(650, 20, 35, 25);
        con.add(backButton);
        
		
	}
	public void addActionEvent()
	{
		
		backButton.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == backButton) {
			JOptionPane.showMessageDialog(this, "BACK");
			this.setVisible(false);
			MAINPAGE page = new MAINPAGE();
	    page.setVisible(true);
		}
		
	}
	public int countLines()
	{
		int count=0;
		try {
			Scanner get = new Scanner(new File(path));
			
	        while(get.hasNextLine())
	        {
	            get.nextLine();
	            count++;
	        }
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		n = count;
		myCourses = new Person[n];
		
        return count;
	}
	
	public void Load()
	{
		try
	    {
			
			Scanner get = new Scanner(new File(path));
	        String line, arr[];
	        
	        for(int i=0; i<n; i++)
	        {
	        	line = get.nextLine();
	        	arr = line.split(" ");
	        	myCourses[i] = new Person(arr[0], arr[1], arr[2], arr[3],arr[4],arr[5],arr[6],arr[7]);
	        }
	    }
	    catch (Exception ep) {
			System.out.println("ERROR 404! File-Not-Found");
	       
	    }
	}
	public void LoadTable()
	{
		//add header
		model.addColumn("FirstName");
		model.addColumn("Last Name");
		model.addColumn("Age");
		model.addColumn("Gender");
		model.addColumn("Post");
		model.addColumn("Number");
		model.addColumn("Email");
		model.addColumn("Address");
		
		
		for(int i=0; i<n; i++)
		{
			model.addRow(new Object[]{myCourses[i].firstname,myCourses[i].lastname,myCourses[i].age,myCourses[i].gender,myCourses[i].post,myCourses[i].number,myCourses[i].email,myCourses[i].address});			
		}
		
	}
	public static void main(String[] args) {
		new LIST().setVisible(true);
		
		
	}
}
	
