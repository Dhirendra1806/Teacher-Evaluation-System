import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class User2 extends JFrame implements ActionListener {

		JLabel l1,l2,l3,l4,li;
		JButton btn1,btn2,btn3,btn4;
		JTextField t;
		JPasswordField p;
		ImageIcon img,img1,img3,img4;
		
		public User2() {
		
			img = new ImageIcon(getClass().getResource("p.jpg"));
			li = new JLabel(img);
			li.setBounds(100,100,100,100);
			add(li);
			
			l3 = new JLabel("User Login");
			l3.setBounds(2980,20,400,40);
			l3.setFont(new Font("monospaced",Font.BOLD,35));
			l3.setForeground(Color.white);
			li.add(l3);
			
			l1 = new JLabel("User Id");
			l1.setBounds(2910,150,150,40);
			l1.setFont(new Font("monospaced",Font.BOLD,21));
			l1.setForeground(Color.white);
			li.add(l1);
				
			
			l2 = new JLabel("Password");
			l2.setBounds(2910,250,150,40);
			l2.setFont(new Font("monospaced",Font.BOLD,21));
			l2.setForeground(Color.white);
			li.add(l2);
			
			
			t = new JTextField();
			t.setBounds(3080,150,300,35);
			t.setFont(new Font("monospaced",Font.BOLD,21));
			li.add(t);
			

			p = new JPasswordField();
			p.setBounds(3080,250,300,35);
			p.setFont(new Font("monospaced",Font.BOLD,21));
			li.add(p);
			
			btn1 = new JButton("Login");
			btn1.setBounds(2940,350,150,40);
			btn1.setFont(new Font("monospaced",Font.BOLD,18));
			btn1.addActionListener(this);
			img1 = new ImageIcon(getClass().getResource("ok.png"));
			btn1.setIcon((img1));
			li.add(btn1);
			
			btn2 = new JButton("Cancel");
			btn2.setBounds(3110,350,150,40);
			btn2.setFont(new Font("monospaced",Font.BOLD,18));
			btn2.addActionListener(this);
			img3 = new ImageIcon(getClass().getResource("can.png"));
			btn2.setIcon((img3));
			li.add(btn2);
			
			
			btn4 = new JButton("Back");
			btn4.setBounds(3300,20,160,35);
			btn4.setFont(new Font("monospaced",Font.BOLD,18));
			btn4.addActionListener(this);
			img4 = new ImageIcon("bk3.png");
			btn4.setIcon((img4));
			li.add(btn4);
			
			
			setTitle("User Login");
			setLayout(new FlowLayout());
			setSize(800,550);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

		public static void main(String[] args) {
			new User2();

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn1) {
				if(t.getText().length()>0 && p.getText().length()>0){
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="select * from studentinfo where student_id=? and student_password=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1,t.getText() );
					ps.setString(2, p.getText());
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "You Can Only Give Feedback to The Teacher");
						
						new feedbacku();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect UserName and Password ");
					}
					rs.close();
					ps.close();
			}
			catch (Exception t)
			{ 
				System.out.println(t);
				
			}
				}
			else {
					JOptionPane.showMessageDialog(this,"Data is Blank,Please Fill the Blanks","Warning",JOptionPane.WARNING_MESSAGE);
				}
		    }
			dispose();
			
			
			if(e.getSource()==btn2) {
		    	System.exit(0);
		    }
			
				
			
			if(e.getSource()==btn4) {
				new Main();
				dispose();
			}
			
			
		}

	

	

}
