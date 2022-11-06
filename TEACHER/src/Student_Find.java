import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Student_Find extends JFrame implements ActionListener{
	
	
	JLabel l1,l2,l3;
	JLabel l,td,j1,j2,j3,j4,j5,j6,j7,j8;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JComboBox cb;
	ImageIcon img,img1,img2;
	JButton btn1,btn2,btn3,Bck;
	JScrollPane jp;
	
	public Student_Find() {
		
		img = new ImageIcon(getClass().getResource("imi3.jpg"));
		l1 = new JLabel(img);
		l1.setBounds(100,100,100,100);
		add(l1);
		
		l2=new JLabel("Students Details");
    	l2.setBounds(1600,100,400,50);
    	l2.setFont(new Font("monospaced",Font.BOLD,35));
		l2.setForeground(Color.white);
    	l1.add(l2);
    	
    	l3=new JLabel("Student Id");
    	l3.setBounds(1450,250,400,50);
    	l3.setFont(new Font("monospaced",Font.BOLD,25));
		l3.setForeground(Color.white);
    	l1.add(l3);
    	
    	cb = new JComboBox ();
		cb.setBounds(1800,250,250,40);
		cb.setFont(new Font("monospaced",Font.BOLD,25));
		cb.setForeground(Color.black);
		cb.addActionListener(this);	
		l1.add(cb);
		
		btn1 = new JButton("Find");
		btn1.setBounds(2100,250,150,45);
		btn1.setFont(new Font("monospaced",Font.BOLD,18));
	//	img1 = new ImageIcon(getClass().getResource("fid.png"));
		btn1.setIcon((img1));
		btn1.addActionListener(this);
		l1.add(btn1);
		
		
		j2=new JLabel("Student Name");
		j2.setBounds(1450,300,400,50);
		j2.setFont(new Font("monospaced",Font.BOLD,25));
		j2.setForeground(Color.white);
		l1.add(j2);
		
		j3=new JLabel("Student Address");
		j3.setBounds(1450,350,400,50);
		j3.setFont(new Font("monospaced",Font.BOLD,25));
		j3.setForeground(Color.white);
		l1.add(j3);
		
		j4=new JLabel("Student City");
		j4.setBounds(1450,400,400,50);
		j4.setFont(new Font("monospaced",Font.BOLD,25));
		j4.setForeground(Color.white);
		l1.add(j4);
		
		j5=new JLabel("Student PhoneNo.");
		j5.setBounds(1450,450,400,50);
		j5.setFont(new Font("monospaced",Font.BOLD,25));
		j5.setForeground(Color.white);
		l1.add(j5);
		
		j7=new JLabel("Student Password");
		j7.setBounds(1450,500,400,50);
		j7.setFont(new Font("monospaced",Font.BOLD,25));
		j7.setForeground(Color.white);
		l1.add(j7);
		
		j8=new JLabel("Student EmailId");
		j8.setBounds(1450,550,400,50);
		j8.setFont(new Font("monospaced",Font.BOLD,25));
		j8.setForeground(Color.white);
		l1.add(j8);
		
		j6=new JLabel("Stream");
		j6.setBounds(1450,600,400,50);
		j6.setFont(new Font("monospaced",Font.BOLD,25));
		j6.setForeground(Color.white);
		l1.add(j6);
		
		t1=new JTextField();
		t1.setBounds(1800,300,250,35);
		t1.setFont(new Font("monospaced",Font.BOLD,25));
		t1.setEditable(false);
		l1.add(t1);
		
		t2=new JTextField();
		t2.setBounds(1800,350,250,35);
		t2.setFont(new Font("monospaced",Font.BOLD,25));
		t2.setEditable(false);
		l1.add(t2);
		
		t3=new JTextField();
		t3.setBounds(1800,400,250,35);
		t3.setFont(new Font("monospaced",Font.BOLD,25));
		t3.setEditable(false);
		l1.add(t3);
		
		t4=new JTextField();
		t4.setBounds(1800,450,250,35);
		t4.setFont(new Font("monospaced",Font.BOLD,25));
		t4.setEditable(false);
		l1.add(t4);
		
		t5=new JTextField();
		t5.setBounds(1800,500,250,35);
		t5.setFont(new Font("monospaced",Font.BOLD,25));
		t5.setEditable(false);
		l1.add(t5);
		
		t6=new JTextField();
		t6.setBounds(1800,550,250,35);
		t6.setFont(new Font("monospaced",Font.BOLD,25));
		t6.setEditable(false);
		l1.add(t6);
		
		t7=new JTextField();
		t7.setBounds(1800,600,250,35);
		t7.setFont(new Font("monospaced",Font.BOLD,25));
		t7.setEditable(false);
		l1.add(t7);
		
		Bck=new JButton("Back");
    	Bck.setBounds(850,50,150,40);
    	l1.add(Bck);
    	Bck.addActionListener(this);

		
		filldata();

		setSize(2000,2000);
		setVisible(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		 new Student_Find();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btn1)
		{
			
			try
			{
				Connection con;
				PreparedStatement st;
				ResultSet rs;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str="select student_name,student_address,student_city,student_phoneno,student_password,student_emailid,student_stream from studentinfo where student_id=?";
				st=con.prepareStatement(str);
				String x  = cb.getSelectedItem().toString();
				st.setString(1, x);
				rs=st.executeQuery();
				if (rs.next()) 
				{
				t1.setText(rs.getString(1));
				t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));
				t4.setText(rs.getString(4));
				t5.setText(rs.getString(5));
				t6.setText(rs.getString(6));
				t7.setText(rs.getString(7));
			//	t8.setText(rs.getString(8));
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.toString());
			}
			
		
			   
				       
		}
		   if(e.getSource()==Bck) {
				new Menu();
			        }
			       
		
			}
	
	void filldata()
	{
		try
		{
			Connection con;
			PreparedStatement st;
			ResultSet rs;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String str="select student_id from studentinfo ";
			st=con.prepareStatement(str);
			rs=st.executeQuery();
			while (rs.next())
			{
			cb.addItem(rs.getString(1));
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		
			
		
		
	}

}