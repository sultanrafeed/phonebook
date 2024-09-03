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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



class Person {
	String firstname;
	String lastname;
	String age;
	String gender;
	String post;
	String number;
	String email;
	String address;

	public Person(String fn, String ln, String ag, String gen, String pos, String num, String email, String add) {
		this.firstname = fn;
		this.lastname = ln;
		this.age = ag;
		this.gender = gen;
		this.post = pos;
		this.number = num;
		this.email = email;
		this.address = add;

	}

	public String toString() {
		return this.firstname + " " + this.lastname + " " + this.age + " " + this.gender + " " + this.post + " "
				+ this.number + " " + this.email + " " + this.address + " " + "\n";
	}
}

public class SEARCH extends JFrame implements ActionListener {

	int n;
	Person myCourses[] = new Person[n];

	String path = "/Users/taseenhakim/eclipse-workspace/LABPROJECTDEMO/src/DEM/CONtact.txt";

	Container con = getContentPane();

	JTextField searchBox = new JTextField();
	JButton searchButton = new JButton("SEARCH");
	JButton resetButton = new JButton("RESET");
	JButton backButton = new JButton("<-");
	DefaultTableModel model = new DefaultTableModel();
	JTable courseTable = new JTable(model);
	JScrollPane scroll = new JScrollPane(courseTable);
	JLabel mainLabel = new JLabel("CONTACTX");
	private JLabel imageLabel;
  private ImageIcon imageIcon; 

	SEARCH() {

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

	public void Init() {
		con.setLayout(null);
		con.setBackground(new Color(107, 179, 157));
		scroll.setBounds(100, 130, 500, 100);
		con.add(scroll);

		mainLabel.setBounds(300, 60, 100, 30);
		mainLabel.setForeground(Color.DARK_GRAY);
		mainLabel.setFont(new Font("Phosphate", Font.BOLD, 17));
		con.add(mainLabel);
		
		 con.add(imageLabel);

		searchBox.setBounds(100, 250, 250, 25);
		searchBox.setToolTipText("Search here");
		con.add(searchBox);

		searchButton.setBounds(380, 250, 95, 25);
		con.add(searchButton);

		resetButton.setBounds(480, 250, 95, 25);
		con.add(resetButton);
		
		backButton.setBounds(650, 20, 35, 25);
		con.add(backButton);

	}

	public void addActionEvent() {
		searchButton.addActionListener(this);
		resetButton.addActionListener(this);
	
		backButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == searchButton) {
			String text = searchBox.getText();
			model.setRowCount(0);

			for (int i = 0; i < n; i++) {
				if (text.equalsIgnoreCase(myCourses[i].firstname) || text.equalsIgnoreCase(myCourses[i].lastname)
						|| text.equalsIgnoreCase(myCourses[i].age) || text.equalsIgnoreCase(myCourses[i].gender)
						|| text.equalsIgnoreCase(myCourses[i].post) || text.equalsIgnoreCase(myCourses[i].number)
						|| text.equalsIgnoreCase(myCourses[i].email) || text.equalsIgnoreCase(myCourses[i].address)) {
					model.addRow(new Object[] { myCourses[i].firstname, myCourses[i].lastname, myCourses[i].age,
							myCourses[i].gender, myCourses[i].post, myCourses[i].number, myCourses[i].email, myCourses[i].address });
				} else if (text.equals("")) {
					model.addRow(new Object[] { myCourses[i].firstname, myCourses[i].lastname, myCourses[i].age,
							myCourses[i].gender, myCourses[i].post, myCourses[i].number, myCourses[i].email, myCourses[i].address });
				}
			}
		}
	
			
		if (e.getSource() == resetButton) {
			if (!searchBox.equals("")) {
				model.setRowCount(0);
				model.setColumnCount(0);
				searchBox.setText("");
				LoadTable();
			}
		}
		if(e.getSource() == backButton) {
			this.setVisible(false);
			MAINPAGE page = new MAINPAGE();
	    page.setVisible(true);
			
				}
	}

	public int countLines() {
		int count = 0;
		try {
			Scanner get = new Scanner(new File(path));

			while (get.hasNextLine()) {
				get.nextLine();
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		n = count;
		myCourses = new Person[n];

		return count;
	}

	public void Load() {
		try {

			Scanner get = new Scanner(new File(path));
			String line, arr[];

			for (int i = 0; i < n; i++) {
				line = get.nextLine();
				arr = line.split(" ");
				myCourses[i] = new Person(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
			}
		} catch (Exception ep) {
			System.out.println("ERROR 404! File-Not-Found");

		}
	}

	public void LoadTable() {
		// add header
		model.addColumn("FirstName");
		model.addColumn("Last Name");
		model.addColumn("Age");
		model.addColumn("Gender");
		model.addColumn("Post");
		model.addColumn("Number");
		model.addColumn("Email");
		model.addColumn("Address");

		// add data
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] { myCourses[i].firstname, myCourses[i].lastname, myCourses[i].age, myCourses[i].gender,
					myCourses[i].post, myCourses[i].number, myCourses[i].email, myCourses[i].address });
		}

	}

}
