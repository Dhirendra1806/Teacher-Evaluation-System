import java.awt.*;
    	import java.awt.event.ActionEvent;
    	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
    	public class TeacherUpdate extends JFrame implements ActionListener{
    	      JLabel l1,td,j1,j2,j3,j4,j5,j6,j7,j8;
    	      JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    	      ImageIcon img;
    	      JComboBox cbs,cbc;
    	      JButton btcancel,btupdate,Bck;
    		public TeacherUpdate(){
    			img = new ImageIcon(getClass().getResource("imi3.jpg"));
    			l1 = new JLabel(img);
    			l1.setBounds(100,100,100,100);
    			add(l1);
    			
    			td=new JLabel("Teacher details");
    			td.setBounds(1600,100,400,50);
    			td.setFont(new Font("monospaced",Font.BOLD,35));
    			td.setForeground(Color.white);
    			l1.add(td);
    		
    			j1=new JLabel("Teacher Id");
    			j1.setBounds(1450,200,400,50);
    			j1.setFont(new Font("monospaced",Font.BOLD,25));
    			j1.setForeground(Color.white);
    			l1.add(j1);
    			
    			j2=new JLabel("Teacher Name");
    			j2.setBounds(1450,260,400,50);
    			j2.setFont(new Font("monospaced",Font.BOLD,25));
    			j2.setForeground(Color.white);
    			l1.add(j2);
    			
    			j3=new JLabel("Teacher Address");
    			j3.setBounds(1450,310,400,50);
    			j3.setFont(new Font("monospaced",Font.BOLD,25));
    			j3.setForeground(Color.white);
    			l1.add(j3);
    			
    			j4=new JLabel("Teacher City");
    			j4.setBounds(1450,360,400,50);
    			j4.setFont(new Font("monospaced",Font.BOLD,25));
    			j4.setForeground(Color.white);
    			l1.add(j4);
    			
    			j5=new JLabel("Teacher PhoneNo.");
    			j5.setBounds(1450,410,400,50);
    			j5.setFont(new Font("monospaced",Font.BOLD,25));
    			j5.setForeground(Color.white);
    			l1.add(j5);
    			/*
    			j7=new JLabel("Teacher Password");
    			j7.setBounds(1450,460,400,50);
    			j7.setFont(new Font("monospaced",Font.BOLD,25));
    			j7.setForeground(Color.white);
    			l1.add(j7);
    			
    			j8=new JLabel("Teacher EmailId");
    			j8.setBounds(1450,510,400,50);
    			j8.setFont(new Font("monospaced",Font.BOLD,25));
    			j8.setForeground(Color.white);
    			l1.add(j8);
    			*/
    			j6=new JLabel("Stream");
    			j6.setBounds(1450,460,400,50);
    			j6.setFont(new Font("monospaced",Font.BOLD,25));
    			j6.setForeground(Color.white);
    			l1.add(j6);
    			
    			t1=new JTextField();
    			t1.setBounds(1800,200,250,35);
    			l1.add(t1);
    			
    			t2=new JTextField();
    			t2.setBounds(1800,260,250,35);
    			l1.add(t2);
    			
    			t3=new JTextField();
    			t3.setBounds(1800,310,250,35);
    			l1.add(t3);
    			
    			t4=new JTextField();
    			t4.setBounds(1800,360,250,35);
    			l1.add(t4);
    			
    			t5=new JTextField();
    			t5.setBounds(1800,410,250,35);
    			l1.add(t5);
    			
    		/*	t6=new JTextField();
    			t6.setBounds(1800,460,250,35);
    			l1.add(t6);
    			
    			t7=new JTextField();
    			t7.setBounds(1800,510,250,35);
    			l1.add(t7);
    			*/
    			cbs = new JComboBox ();
    			cbs.addItem("Science");
    			cbs.addItem("Art");
    			cbs.addItem("Commerce");
    			cbs.setBounds(1800,460,250,35);
    			cbs.setFont(new Font("monospaced",Font.BOLD,25));
    			cbs.setForeground(Color.black);
    			cbs.addActionListener(this);	
    			l1.add(cbs);
    			

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
    	    	
    	    	setLayout(new FlowLayout());
    	    	setSize(2000,2000);
    			setVisible(true);
    			setDefaultCloseOperation(EXIT_ON_CLOSE);
    			
    		}
    		
    		public static void main(String[] args) {
    			// TODO Auto-generated method stub
    	         new TeacherUpdate();
    		}

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			if(e.getSource()==btupdate) {
    				{
    				int x=Integer.parseInt(t1.getText());
    				
    				String s=t2.getText();
    				String s1=t3.getText();
    				String c = cbc.getSelectedItem().toString();
    				String s3=t5.getText();
    				String c1 = cbs.getSelectedItem().toString();
    				
    				
    				try {
    					Connection con;
    					PreparedStatement st;
    					ResultSet rs;
    					Class.forName("oracle.jdbc.driver.OracleDriver");
    					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
    					String str = "update teacherinfo set values(?,?,?,?,?,?)";
    					st = con.prepareStatement(str);
    					st.setInt(1,x);
    					st.setString(2, s);
    					st.setString(3,s1);
    					st.setString(4,c);
    					st.setString(5,s3);
    					st.setString(6, c1);
    					
    					
    					int r = st.executeUpdate();
    				    con.commit();
    				    JOptionPane.showMessageDialog(this, "Record Saved");
    				    t1.setText("");
    				    t2.setText("");
    				    t3.setText("");
    				    
    				    t5.setText("");
    				    
    				    
    				}
    				catch(Exception ex)
    				{
    					System.out.println(ex.toString());
    				}
    				
    				}
	
    			}
    			if(e.getSource()==btcancel) {
    			System.exit(0);		
    			}
    			if(e.getSource()==Bck) {
    				new Menu_S();
    			}
		
	}
	

	}

	