import javax.swing.*;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.*;
public class All_info2 extends JFrame  {
JTextArea ta;
	public All_info2() {
	 setLayout(null);
	 ta=new JTextArea();
	 ta.setBounds(30, 30, 1200, 800);
	 add(ta);
	 ta.setFont(new Font("Arial",Font.BOLD,20));
	 ta.setAutoscrolls(true);
	 filldata();
	 setSize(900,900);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);	 
}
public static void main(String args[]) {
	new All_info2();
}
public void filldata()
{ String data=null;
	try
	{
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		String str="select * from studentinfo ";
		st=con.prepareStatement(str);
		rs=st.executeQuery();
		data="Data in Student Table";
		data=data+"\n---------------------\n";
		/*
		 * data=data+"StudentId"+"\t"; data=data+"Name"+"\t"; data=data+"Address"+"\t";
		 * data=data+"City"+"\t"; data=data+"Phone"+"\t"; data=data+"Password"+"\t";data=data+""EmailId+"\t";data=data+"Stream"+"\t";
		 */
		data=data+"\n";
		while (rs.next())
		{
		data=data+rs.getInt(1)+"\t";
		data=data+rs.getString(2)+"\t";
		data=data+rs.getString(3)+"\t";
		data=data+rs.getString(4)+"\t";
		data=data+rs.getString(5)+"\t";
		data=data+rs.getString(6)+"\t";
		data=data+rs.getString(7)+"\t";
		data=data+rs.getString(8)+"\t";
		data=data+"\n";
		}
		ta.setText(data);
	}
	catch(Exception ex)
	{
		System.out.println(ex.toString());
	}
	
}}
