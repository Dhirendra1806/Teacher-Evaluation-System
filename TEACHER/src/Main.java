import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Main extends JFrame implements ActionListener{
	JComboBox cb;
	ImageIcon img;
	JLabel lbl1,l1;
	JButton btn1;
	
	
	public Main() {
		
		
		
		
		img = new ImageIcon(getClass().getResource("mg20.jpg"));
		l1 = new JLabel(img);
		l1.setBounds(100,100,100,100);
		add(l1);
		
		lbl1 = new JLabel("Choose to Continue...");
		lbl1.setBounds(550,10,300,30);
		lbl1.setFont(new Font("monospaced",Font.BOLD,23));
		lbl1.setForeground(Color.white);
		l1.add(lbl1);
		
		cb = new JComboBox ();
		cb.addItem("-select Item-");
		cb.addItem("Admin Login");
		cb.addItem("User Login");
		cb.setBounds(550,140,250,40);
		cb.setFont(new Font("monospaced",Font.BOLD,25));
		cb.setForeground(Color.black);
		cb.addActionListener(this);	
		l1.add(cb);
		
		
		setTitle("Teacher Response System");
		setSize(500,400);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main();
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(cb.getSelectedItem()=="Admin Login") {
			new Admin();
			dispose();
		}
		
		
		if(cb.getSelectedItem()=="User Login") {
			new User2();
			dispose();
		}
		
	}
		
	}


