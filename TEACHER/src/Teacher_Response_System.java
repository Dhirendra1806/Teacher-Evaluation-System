
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Teacher_Response_System extends JFrame implements ActionListener{
	
	JLabel l1,lbl1;
	ImageIcon img,img1;
	JButton btn1,btn2,btn3,btn4,btn5,bt;
	ImageIcon img4;
	public Teacher_Response_System(){
		
		img = new ImageIcon(getClass().getResource("mg20.jpg"));
		l1 = new JLabel(img);
		l1.setBounds(500,500,500,500);
		add(l1);
		
		lbl1 = new JLabel("Teacher Evaluation System");
		lbl1.setFont(new Font("monospaced",Font.BOLD,56));
		lbl1.setForeground(Color.white);
		lbl1.setBounds(250,50,900,70);
		l1.add(lbl1);
		
		btn1 = new JButton("Teacher Details");
		btn1.setBounds(250,350,250,50);
		btn1.setFont(new Font("monospaced",Font.BOLD,20));
		btn1.addActionListener(this);
		l1.add(btn1);
		
		btn2 = new JButton("Student Details");
		btn2.setBounds(550,350,250,50);
		btn2.setFont(new Font("monospaced",Font.BOLD,20));
		btn2.addActionListener(this);
		l1.add(btn2);
		
		btn3 = new JButton("Feedback");
		btn3.setBounds(850,350,250,50);
		btn3.setFont(new Font("monospaced",Font.BOLD,20));
		btn3.addActionListener(this);
		l1.add(btn3);
		
	
		
		bt = new JButton("Back");
		bt.setBounds(10,10,150,50);
		bt.setFont(new Font("monospaced",Font.BOLD,15));
		bt.addActionListener(this);
		//img4 = new ImageIcon(getClass().getResource("bk2.png"));
		//bt.setIcon((img4));
		l1.add(bt);
		
		setTitle("Teacher evaluation System");
		setLayout(new FlowLayout());
		setSize(1300,820);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		 new Teacher_Response_System();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			new Menu_S();
			dispose();
			
		}
		
		if(e.getSource()==btn2) {
			new Menu();
			dispose();
		}
		
		if(e.getSource()==btn3) {
			new feedbacku1();
			dispose();                                               
		}
		if(e.getSource()==bt) {
			new Admin();
		}
		
	}

}
