import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class New_User extends JFrame implements ActionListener{
	JLabel l1,li,l3,l2,l4;
	JButton btn1,btn2,btn3;
	JTextField t;
	JPasswordField p,p1;
	ImageIcon img,img1,img3,img4;
	public New_User() {
		
		img = new ImageIcon(getClass().getResource("mg4.jpg"));
		li = new JLabel(img);
		li.setBounds(100,100,100,100);
		add(li);
		
		l3 = new JLabel("New User ?");
		l3.setBounds(850,20,400,40);
		l3.setFont(new Font("monospaced",Font.BOLD,35));
		l3.setForeground(Color.white);
		li.add(l3);
		
		
		
		
		l1 = new JLabel("Student Id");
		l1.setBounds(700,120,150,40);
		l1.setFont(new Font("monospaced",Font.BOLD,21));
		l1.setForeground(Color.white);
		li.add(l1);
		
		l2 = new JLabel("Password");
		l2.setBounds(700,190,150,40);
		l2.setFont(new Font("monospaced",Font.BOLD,21));
		l2.setForeground(Color.white);
		li.add(l2);
	
		t = new JTextField();
		t.setBounds(960,120,250,35);
		t.setFont(new Font("monospaced",Font.BOLD,21));
		li.add(t);
		

		p = new JPasswordField();
		p.setBounds(960,190,250,35);
		p.setFont(new Font("monospaced",Font.BOLD,21));
		li.add(p);
	
		btn1 = new JButton("Save");
		btn1.setBounds(750,300,150,45);
		btn1.setFont(new Font("monospaced",Font.BOLD,18));
		btn1.addActionListener(this);
		img1 = new ImageIcon(getClass().getResource("ok.png"));
		btn1.setIcon((img1));
		li.add(btn1);
		
		btn2 = new JButton("Cancel");
		btn2.setBounds(950,300,150,45);
		btn2.setFont(new Font("monospaced",Font.BOLD,18));
		btn2.addActionListener(this);
		img3 = new ImageIcon(getClass().getResource("can.png"));
		btn2.setIcon((img3));
		li.add(btn2);
		
		btn3 = new JButton("Login");
		btn3.setBounds(850,380,150,45);
		btn3.setFont(new Font("monospaced",Font.BOLD,18));
		btn3.addActionListener(this);
		img3 = new ImageIcon(getClass().getResource("uin.png"));
		btn3.setIcon((img3));
		li.add(btn3);
		
		
		
		setSize(600,500);
		setVisible(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new New_User();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			
			String s1 = t.getText();
			String s=p.getText();
			try {
				Connection con;
				PreparedStatement st;
				ResultSet rs;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str = "insert into blogin values(?,?)";
				st = con.prepareStatement(str);
				st.setString(1,s1);
				st.setString(2, s);
				
				int g = st.executeUpdate();
			    con.commit();
			    JOptionPane.showMessageDialog(this, "Record Saved");
			    t.setText("");
			    p.setText("");
			   
			}
			catch(Exception ex)
			{
				System.out.println(ex.toString());
			}
			
			}
		
		
		if(e.getSource()==btn2) {
			System.exit(0);
		}
		if(e.getSource()==btn3) {
			new User2();
			dispose();
		}
		
	}

}
