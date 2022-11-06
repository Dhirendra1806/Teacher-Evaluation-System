import javax.swing.*;

import java.awt.Font;
import java.sql.*;
public class All_info3 extends JFrame {
JTextArea ta;
	public All_info3() {
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
	new All_info3();
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
		String str="select * from feedbacku ";
		st=con.prepareStatement(str);
		rs=st.executeQuery();
		data="Data in Feedback Table";
		data=data+"\n---------------------\n";
		/*
		 * data=data+"StudentId"+"\t"; data=data+"Date"+"\t"; data=data+"Teacher id"+"\t";
		 * data=data+"Rate"+"\t"; data=data+"Comment"+"\t"; 
		 */
		data=data+"\n";
		while (rs.next())
		{
		data=data+rs.getInt(1)+"\t";
		data=data+rs.getString(2)+"\t";
		data=data+rs.getString(3)+"\t";
		data=data+rs.getString(4)+"\t";
		data=data+rs.getString(5)+"\t";
		
		data=data+"\n";
		}
		ta.setText(data);
	}
	catch(Exception ex)
	{
		System.out.println(ex.toString());
	}

}
}
