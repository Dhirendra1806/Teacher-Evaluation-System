import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
public class feedbacku extends JFrame  implements ActionListener{
	
	JLabel l1,lbl1,lbl2,lbl3,lbl4,lbl5,l;
	JTextArea ta1;
	JTextField txt1,txt2,txt3,txt4,txt5;
	JButton btn1,btn2,btn3;
	JTextArea a1;
	ImageIcon img,img4;
	JSpinner sp;
	JComboBox cb,sy;
	
	
	public feedbacku() {
		
		img = new ImageIcon("img90.jpg");
		l = new JLabel(img);
		l.setBounds(100,100,100,100);
		add(l);
	
		l1 = new JLabel("Feedback");
		l1.setBounds(1600,20,170,40);
		l1.setFont(new Font("monospaced",Font.BOLD,30));
		l.add(l1);
		
		
		lbl1 = new JLabel("Student Id");
		lbl1.setBounds(1400,150,150,40);
		lbl1.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(lbl1);
		
		sy = new JComboBox();
		sy.setBounds(1620,150,250,40);
		sy.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(sy);
		
		
		lbl2 = new JLabel("Date Feeback");
		lbl2.setBounds(1400,250,150,40);
		lbl2.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(lbl2);
		
		
		
		txt2 = new JTextField();
		txt2.setBounds(1620,250,260,40);
		txt2.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(txt2);
		
		
		lbl3 = new JLabel("Teacher Id");
		lbl3.setBounds(1400,350,150,40);
		lbl3.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(lbl3);
		
		cb = new JComboBox();
		cb.setBounds(1620,350,250,40);
		cb.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(cb);
		
		
		lbl4 = new JLabel("Rating");
		lbl4.setBounds(1400,450,150,40);
		lbl4.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(lbl4);
		
		sp = new JSpinner();
		sp.setBounds(1620,450,250,40);
		sp.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(sp);
		
		lbl5 = new JLabel("Comments");
		lbl5.setBounds(1400,550,150,40);
		lbl5.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(lbl5);
		
		
		a1 = new JTextArea();
		a1.setBounds(1620,550,350,100);
		a1.setFont(new Font("monospaced",Font.BOLD,18));
		l.add(a1);
		
		btn1 = new JButton("Save");
		btn1.setBounds(1490,690,150,40);
		btn1.addActionListener(this);
		btn1.setFont(new Font("monospaced",Font.BOLD,18));
		img4 = new ImageIcon(getClass().getResource("ok.png"));
		btn1.setIcon((img4));
		l.add(btn1);
		
		btn2 = new JButton("Cancel");
		btn2.setBounds(1690,690,150,40);
		btn2.addActionListener(this);
		btn2.setFont(new Font("monospaced",Font.BOLD,18));
		img4 = new ImageIcon(getClass().getResource("can.png"));
		btn2.setIcon((img4));
		l.add(btn2);
		
		
		btn3 = new JButton("Back");
		btn3.setBounds(1369,10,150,50);
		btn3.addActionListener(this);
		btn3.setFont(new Font("monospaced",Font.BOLD,18));
		img4 = new ImageIcon(getClass().getResource("bk3.png"));
		btn3.setIcon((img4));
		l.add(btn3);
		fillda();
	filldata();
			setTitle("Feedback");
		setLayout(new FlowLayout());
		setSize(650,850);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new feedbacku();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1) {
			String s = sy.getSelectedItem().toString();
			String s1 = txt2.getText();
			String s2=cb.getSelectedItem().toString();
			if (Integer.parseInt(sp.getValue().toString())<=5)
			{
			String s3=sp.getValue().toString();
			String s4 = a1.getText();
			try {
				Connection con;
				PreparedStatement st;
				ResultSet rs;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str = "insert into feedbacku values(?,?,?,?,?)";
				st = con.prepareStatement(str);
				st.setString(1,s);
				st.setString(2, s1);
				st.setString(3, s2);
				st.setString(4, s3);
				st.setString(5, s4);
				
				int g = st.executeUpdate();
			    con.commit();
			    JOptionPane.showConfirmDialog(this, "Do you Want  to Save ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			    JOptionPane.showMessageDialog(this, "Record Saved");
			    txt2.setText("");
			    a1.setText("");
			    
			   
			}
			catch(Exception ex)
			{
				System.out.println(ex.toString());}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "You Can't give more then 5 rating");
			}
			}
	if(e.getSource()==btn3) {
		new User2();
		dispose();
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
				String str="select teacher_id from teacherinfo ";
				st=con.prepareStatement(str);
				rs=st.executeQuery();
				while (rs.next())
				{
				cb.addItem(rs.getString(1));
				}
			}
			catch(Exception e)
			{
				System.out.println(e.toString());}
			}
			
		void fillda()
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
				sy.addItem(rs.getString(1));
				}
			}
			catch(Exception e)
			{
				System.out.println(e.toString());}
			}
		}
	
		
	
		
