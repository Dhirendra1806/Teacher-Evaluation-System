import java.awt.*;
    	import java.awt.event.ActionEvent;
    	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
    	public class Stu_delete extends JFrame implements ActionListener{
    	      JLabel l1,td,j1,j2,j3,j4,j5,j6,j7,j8;
    	      JTextField t2,t3,t5,t7,t8,t9;
    	      ImageIcon img;
    	      JPasswordField p1;
    	      JComboBox cbs,cbc,cbid;
    	      JButton btcancel,btdelete,Bck;
    		public Stu_delete(){
    			img = new ImageIcon(getClass().getResource("imi3.jpg"));
    			l1 = new JLabel(img);
    			l1.setBounds(100,100,100,100);
    			add(l1);
    			
    			td=new JLabel("Students details");
    			td.setBounds(1600,100,400,50);
    			td.setFont(new Font("monospaced",Font.BOLD,35));
    			td.setForeground(Color.white);
    			l1.add(td);
    		
    			j1=new JLabel("Student Id");
    			j1.setBounds(1450,200,400,50);
    			j1.setFont(new Font("monospaced",Font.BOLD,25));
    			j1.setForeground(Color.white);
    			l1.add(j1);
    			
    			j2=new JLabel("Student Name");
    			j2.setBounds(1450,260,400,50);
    			j2.setFont(new Font("monospaced",Font.BOLD,25));
    			j2.setForeground(Color.white);
    			l1.add(j2);
    				
    			j3=new JLabel("Student Address");
    			j3.setBounds(1450,310,400,50);
    			j3.setFont(new Font("monospaced",Font.BOLD,25));
    			j3.setForeground(Color.white);
    			l1.add(j3);
    			
    			j4=new JLabel("Student city");
    			j4.setBounds(1450,360,400,50);
    			j4.setFont(new Font("monospaced",Font.BOLD,25));
    			j4.setForeground(Color.white);
    			l1.add(j4);
    			
    			j5=new JLabel("Student PhoneNo.");
    			j5.setBounds(1450,410,400,50);
    			j5.setFont(new Font("monospaced",Font.BOLD,25));
    			j5.setForeground(Color.white);
    			l1.add(j5);
    			
    			j7=new JLabel("Student Password");
    			j7.setBounds(1450,460,400,50);
    			j7.setFont(new Font("monospaced",Font.BOLD,25));
    			j7.setForeground(Color.white);
    			l1.add(j7);
    			
    			j8=new JLabel("Student EmailId");
    			j8.setBounds(1450,510,400,50);
    			j8.setFont(new Font("monospaced",Font.BOLD,25));
    			j8.setForeground(Color.white);
    			l1.add(j8);
    			
    			j6=new JLabel("Stream");
    			j6.setBounds(1450,560,400,50);
    			j6.setFont(new Font("monospaced",Font.BOLD,25));
    			j6.setForeground(Color.white);
    			l1.add(j6);
    			
    			cbid = new JComboBox ();
    			cbid.setBounds(1800,200,250,40);
    			cbid.setFont(new Font("monospaced",Font.BOLD,25));
    			cbid.setForeground(Color.black);
    			cbid.addActionListener(this);	
    			l1.add(cbid);
    			
    			
    			t2=new JTextField();
    			t2.setBounds(1800,260,250,35);
    			t2.setFont(new Font("monospaced",Font.BOLD,25));
    			t2.setEditable(false);
    			l1.add(t2);
    			
    			t3=new JTextField();
    			t3.setBounds(1800,310,250,35);
    			t3.setFont(new Font("monospaced",Font.BOLD,25));
    			t3.setEditable(false);
    			l1.add(t3);
    			
    			
    			
    			t5=new JTextField();
    			t5.setBounds(1800,410,250,35);
    			t5.setFont(new Font("monospaced",Font.BOLD,25));
    			t5.setEditable(false);
    			l1.add(t5);
    			
    			t8=new JTextField();
    			t8.setBounds(1800,360,250,35);
    			t8.setFont(new Font("monospaced",Font.BOLD,25));
    			t8.setEditable(false);
    			l1.add(t8);
    			
    			t9=new JTextField();
    			t9.setBounds(1800,560,250,35);
    			t9.setFont(new Font("monospaced",Font.BOLD,25));
    			t9.setEditable(false);
    			l1.add(t9);
    			
    			p1=new JPasswordField();
    			p1.setBounds(1800,460,250,35);
    			p1.setFont(new Font("monospaced",Font.BOLD,25));
    			p1.setEditable(false);
    			l1.add(p1);
    			
    			
    			t7=new JTextField();
    			t7.setBounds(1800,510,250,35);
    			t7.setFont(new Font("monospaced",Font.BOLD,25));
    			t7.setEditable(false);
    			l1.add(t7);
    			
    			
    			

    			btdelete=new JButton("delete..");
    			btdelete.setBounds(1550,650,150,40);
    			l1.add(btdelete);
    			
    			btdelete.addActionListener(this);
    	    	
    	    	btcancel=new JButton("Cancel");
    	    	btcancel.setBounds(1750,650,150,40);
    	    	l1.add(btcancel);
    	    	
    	    	btcancel.addActionListener(this);
    	    	
    	    	Bck=new JButton("Back");
    	    	Bck.setBounds(850,70,150,40);
    	    	l1.add(Bck);
    	    	Bck.addActionListener(this);
    	    	
    	    	filldata();
    	    	//filldata2();
    	    	
    	    	
    	    	setLayout(new FlowLayout());
    	    	setSize(2000,2000);
    			setVisible(true);
    			setDefaultCloseOperation(EXIT_ON_CLOSE);
    			 
    		}
    		
    		public static void main(String[] args) {
    			// TODO Auto-generated method stub
    	         new Stu_delete();
    		}

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			if (e.getSource()==btdelete)
    			{
    				int x=Integer.parseInt(cbid.getSelectedItem().toString());
    			try {
    				Connection con;
    				PreparedStatement st;
    				ResultSet rs;
    				Class.forName("oracle.jdbc.driver.OracleDriver");
    				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
    				String str = "delete from studentinfo where student_id=?";
    				st = con.prepareStatement(str);
    				st.setInt(1,x);
    				int g=st.executeUpdate();
    				JOptionPane.showMessageDialog(this, "Record Deleted");
    				con.commit();
    				con.close();
    			}	
    			catch(Exception ex)
    			{
    				System.out.println(ex.toString());
    			}
    			}
    			if (e.getSource()==btcancel)
    			{
    				cbid.getSelectedItem().toString();
    				System.exit(0);
    			}
	if (e.getSource()==cbid)
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
    						int x1= Integer.parseInt(cbid.getSelectedItem().toString());
    						st.setInt(1, x1);
    					rs=st.executeQuery();
    						if (rs.next())
    						{
    							
    						//	t1.setText(rs.getString(1));
    							t2.setText(rs.getString(1));
    						t3.setText(rs.getString(2));
    						t8.setText(rs.getString(3));
    							t5.setText(rs.getString(4));
    							p1.setText(rs.getString(5));
    							t7.setText(rs.getString(6));
    							t9.setText(rs.getString(7));
    	    					
    						}
    					}
    					catch(Exception ex)
    					{
    						System.out.println(ex.toString());
    					}
    					
    				
    					 
    				}
    			
    			if(e.getSource()==btcancel) {
    			System.exit(0);		
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
    			cbid.addItem(rs.getString(1));
    				}
    			}
    			catch(Exception ex)
    			{
    				System.out.println(ex.toString());
    			}
    		}
    			
    	
    			
	}
	

	
    		
	