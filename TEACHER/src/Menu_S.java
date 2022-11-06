import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  Menu_S extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu i,d,f,u;
	JMenuItem i2,f2,d2,u2,a3,b1;
	ImageIcon img,img1;
	JLabel l1,l2,Teach,Stu,Teach1;
	JButton Bck;
	Menu_S(){
		
		//img = new ImageIcon("bc3.jpg");
		img = new ImageIcon(getClass().getResource("bc3.jpg"));	
		l1=new JLabel(img);
		l1.setBounds(100,100,100,100);
		add(l1);
	
		mb=new JMenuBar();
		i=new JMenu("File");
		i.addActionListener(this);
		i.setFont(new Font("monospaced",Font.BOLD,25));
		
		d=new JMenu("Record");
		d.addActionListener(this);
		d.setFont(new Font("monospaced",Font.BOLD,25));
		b1 = new JMenuItem("Data Record");
		b1.setFont(new Font("monospaced",Font.BOLD,25));
	//	img1 = new ImageIcon(getClass().getResource("in.png"));
	//	b1.setIcon((img1));
		b1.addActionListener(this);	
		d.addSeparator();
		d.add(b1);
		
		
		
		i2 = new JMenuItem("Insert");
		i2.setFont(new Font("monospaced",Font.BOLD,25));
		img1 = new ImageIcon(getClass().getResource("in.png"));
		i2.setIcon((img1));
		i2.addActionListener(this);
		
		i.addSeparator();
		i.add(i2);
		u2 = new JMenuItem("Update");
		u2.setFont(new Font("monospaced",Font.BOLD,25));
		u2.addActionListener(this);
		img1 = new ImageIcon(getClass().getResource("up.png"));
		u2.setIcon((img1));
		i.addSeparator();
		i.add(u2);
		d2 = new JMenuItem("Delete");
		d2.setFont(new Font("monospaced",Font.BOLD,25));
		img1 = new ImageIcon(getClass().getResource("de.png"));
		d2.setIcon((img1));
		d2.addActionListener(this);
		i.addSeparator();
		i.add(d2);
		
		f2 = new JMenuItem("Find");
		f2.setFont(new Font("monospaced",Font.BOLD,25));
		f2.addActionListener(this);
		img1 = new ImageIcon(getClass().getResource("fid.png"));
		f2.setIcon((img1));
		i.addSeparator();
		i.add(f2);
		
		/*a3 = new JMenuItem("Data Record");
		a3.setFont(new Font("monospaced",Font.BOLD,25));
		a3.addActionListener(this);
		//img1 = new ImageIcon(getClass().getResource("fid.png"));
		//f2.setIcon((img1));
		i.addSeparator();
		i.add(a3);
		*/
		Bck=new JButton("Back");
    	Bck.setBounds(600,50,160,45);
    	l1.add(Bck);
    	Bck.addActionListener(this);
    	img1 = new ImageIcon(getClass().getResource("bk3.png"));
		Bck.setIcon((img1));
		Bck.setFont(new Font("monospaced",Font.BOLD,20));
		mb.add(i);
		mb.add(d);
	
		
		Teach=new JLabel("Welcome");
		Teach.setBounds(240,200,550,100);
		Teach.setFont(new Font("monospaced",Font.BOLD,55));
		Teach.setForeground(Color.white);
		l1.add(Teach);
		
		Teach1=new JLabel("Teacher");
		Teach1.setBounds(240,320,550,100);
		Teach1.setFont(new Font("monospaced",Font.BOLD,55));
		Teach1.setForeground(Color.white);
		l1.add(Teach1);
		
		setLayout(new FlowLayout());
		setSize(800,700);
		setJMenuBar(mb);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new Menu_S();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==i2) {
			new TeacherInsert();
			dispose();
		}
		if(e.getSource()==f2) {
			new Teacher_Find();
			dispose();
		}
		if(e.getSource()==d2) {
			new TeacherDelete();
			dispose();
		}
		if(e.getSource()==u2) {
			new Teach_update();
			dispose();
		}
		if(e.getSource()==Bck) {
			new Teacher_Response_System();
			dispose();
	}
		if(e.getSource()==a3) {
			new All_info();
			dispose();
		}
		if(e.getSource()==b1) {
			new All_info();
			dispose();
		}
	
	
	

}
}