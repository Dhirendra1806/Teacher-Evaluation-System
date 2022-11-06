import java.awt.*;
    	import java.awt.event.ActionEvent;
    	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
    	public class Stu_update extends JFrame implements ActionListener{
    	      JLabel l1,td,j1,j2,j3,j4,j5,j6,j7,j8;
    	      JTextField t1,t2,t3,t4,t5,t7;
    	      ImageIcon img;
    	      JPasswordField p6;
    	      JComboBox cb1,cb,cbid;
    	      JButton btcancel,btupdate,Bck;
    		public Stu_update(){
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
    			
    			
    			t1=new JTextField();
    			t1.setBounds(1800,260,250,35);
    			l1.add(t1);
    			
    		   	t2=new JTextField();
    		 	t2.setBounds(1800,310,250,35);
    			l1.add(t2);
    			
    			/*cb1 = new JComboBox ();
    			cb1.setBounds(1800,360,250,40);
    			cb1.addItem("Mumbai");
    			cb1.addItem("Delhi");
    			cb1.addItem("Banglore");
    			cb1.addItem("Agra");
    			cb1.addItem("Surat");
    			cb1.addItem("Pune");
    			cb1.addItem("Punjab");
    			cb1.addItem("Ahendabad");
    			cb1.addItem("Chennai");
    			cb1.addItem("Indore");
    			cb1.addItem("Alwar");
    			cb1.addItem("Dehradoon");
    			cb1.addItem("Firojabad");
    			cb1.addItem("Gwalior");
    			cb1.addItem("Haridwar");
    			cb1.addItem("Jaipur");
    			cb1.addItem("Kota");
    			cb1.addItem("Kolkata");
    			cb1.addItem("Lonavala");
    			cb1.addItem("Ludhiyana");
    			cb1.addItem("Manglore");
    			cb1.addItem("Ooty");
    			cb1.addItem("Pushkar");
    			cb1.addItem("Rajasthan");
    			cb1.addItem("Rajkot");
    			cb1.addItem("Shrinagar");
    			cb1.addItem("Udupi");
    			cb1.addItem("Ujjain");
    			cb1.addItem("Vanarasi");
    			cb1.addItem("Raipur");
    			
    			cb1.setFont(new Font("monospaced",Font.BOLD,25));
    			cb1.setForeground(Color.black);
    				
    			l1.add(cb1);
    	*/		
    			t3=new JTextField();
    			t3.setBounds(1800,360,250,35);
    			l1.add(t3);
    			
    			t4=new JTextField();
    			t4.setBounds(1800,410,250,35);
    			l1.add(t4);
    			
    			p6=new JPasswordField();
    			p6.setBounds(1800,460,250,35);
    			l1.add(p6);
    			
    			t5=new JTextField();
    			t5.setBounds(1800,510,250,35);
    			l1.add(t5);
    		/*	
    			cb=new JComboBox();
    			cb.setBounds(1800,560,250,35);
    			cb.addItem("Computer Science");
    			cb.addItem("Maths");
    			cb.addItem("Arts");
    			cb.addItem("Commerce");
    			cb.addItem("");
    			l1.add(cb);
    		*/	
    			t7=new JTextField();
    			t7.setBounds(1800,560,250,35);
    			l1.add(t7);
    			
    			
    			

    			btupdate=new JButton("Update..");
    			btupdate.setBounds(1550,650,150,40);
    			l1.add(btupdate);
    			
    			btupdate.addActionListener(this);
    	    	
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
    	         new Stu_update();
    		}

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			if(e.getSource()==btupdate) {
    				int x = Integer.parseInt(cbid.getSelectedItem().toString());
    				String s=t1.getText();
    				String s1=t2.getText();
    				String s2=t3.getText();
    				String s3=t4.getText();
    				String s4=t5.getText();
    				String s5=p6.getText();	
    				String s6=t7.getText();
    				try {
    					Connection con;
    					PreparedStatement st;
    					Class.forName("oracle.jdbc.driver.OracleDriver");
    					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
    					String str="update studentinfo set student_name=?,student_address=?,student_city=?,student_phoneno=?,student_password=?, student_emailid=?, student_stream =? where student_id=?";
    					
    					st=con.prepareStatement(str);
    					st.setString(1,s);
    					st.setString(2,s1);
    					st.setString(3,s2);
    					st.setString(4,s3);
    					st.setString(5,s4);
    					st.setString(6,s5);
    					st.setString(7,s6);
    					st.setInt(8,x);
    					int g=st.executeUpdate();
    					con.commit();
    					JOptionPane.showMessageDialog(this,"Record Update");
    					/*t1.setText("");*/
    					//cbid.setText("");
    					t1.setText("");
    					t2.setText("");
    					t3.setText("");
    					t4.setText("");
    					t5.setText("");
    					p6.setText("");
    					t7.setText("");
    					//cb.setText("");
    					
    						
    			}catch(Exception ex)
    				{
    				System.out.println(ex.getMessage().toString());
    				}
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
    							t1.setText(rs.getString(1));
    							t2.setText(rs.getString(2));
    						    t3.setText(rs.getString(3));
    						    t4.setText(rs.getString(4));
    						    t5.setText(rs.getString(6));
    						  
    							p6.setText(rs.getString(5));
    							t7.setText(rs.getString(7));
    						//	t9.setText(rs.getString(7));
    	    					
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
	

	
    		
	