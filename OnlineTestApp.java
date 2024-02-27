/*Online Java Paper Test*/

//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,100,100,20);
		jb[2].setBounds(50,120,100,20);
		jb[3].setBounds(50,140,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
           
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: What is the return type of the hashCode() method in the Object class?");
			jb[0].setText("Object");jb[1].setText("int");jb[2].setText("void");jb[3].setText("long");	
		}
		if(current==1)
		{
			l.setText("Que2: What does the expression float a = 35 / 0 return?");
			jb[0].setText("0");jb[1].setText("Not a number");jb[2].setText("infinty");jb[3].setText("Run time exception");
		}
		if(current==2)
		{
			l.setText("Que3: Which method of the Class.class is used to determine the name of a class represented by the class object as a String?");
			jb[0].setText("getClass()");jb[1].setText("intern");jb[2].setText("toString()");jb[3].setText("getName()");
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in which package");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(current==4)
		{
			l.setText("Que5: Which package contains the Random class?");
			jb[0].setText("java.awt package");jb[1].setText("java.lang package");jb[2].setText("java.util package");jb[3].setText("java.io package");
		}
		if(current==5)
		{
			l.setText("Que6: In which memory a String is stored, when we create a string using new operator?");
			jb[0].setText("stack");jb[1].setText("String Memory");jb[2].setText("Heap Memory");jb[3].setText("Random storage space");
		}
		if(current==6)
		{
			l.setText("Que7: Which of the following is a reserved keyword in Java?");
			jb[0].setText("object");jb[1].setText("strictfp");jb[2].setText("main");jb[3].setText("system");
		}
		if(current==7)
		{
			l.setText("Que8: Which keyword is used for accessing the features of a package?");
			jb[0].setText("package");jb[1].setText("export");jb[2].setText("extends");jb[3].setText("import");		
		}
		if(current==8)
		{
			l.setText("Que9: What is the initial quantity of the ArrayList list?");
			jb[0].setText("0");jb[1].setText("10");jb[2].setText("100");jb[3].setText("5");
		}
		if(current==9)
		{
			l.setText("Que10:  What is meant by the classes and objects that dependents on each other?");
			jb[0].setText("None of the above");jb[1].setText("Loose Coupling");jb[2].setText("Tight Coupling");jb[3].setText("Cohesion");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Java Test");
	}


}
