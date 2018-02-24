import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
class Quiz extends JFrame implements ActionListener  
{
	JFrame open;
	JButton start;  JRadioButton c,java;
	    JLabel l;  String name;
	    JRadioButton jb[]=new JRadioButton[5];  
	    JButton b1,b2;  
	    ButtonGroup bg;  
	    int count=0,current=0,x=1,y=1,now=0;  
	    int m[]=new int[10];      
	boolean[] flag=new boolean[10];
	ButtonModel selected[]=new ButtonModel[10];
	String selecAns[]=new String[10];
	    Quiz(String s)  
	    { 				        super(s);  open=new JFrame("Aptitude Test");
			open.setVisible(true);
			open.setLayout(null);
			JLabel jl=new JLabel("By Anil Krishna & Abhishek Darana");
		Font font = jl.getFont();
		Font boldFont = new Font(font.getFontName(), Font.BOLD, 16);
		jl.setFont(boldFont);
			open.add(jl);jl.setOpaque(true);	
			jl.setForeground(Color.WHITE);
			jl.setBackground(Color.RED);
			jl.setBounds(60,300,280,20);
			open.setSize(500,400); 
			c=new JRadioButton("C");
			JLabel head=new JLabel("Aptitude Test");
			head.setBounds(150,20,200,20);
			head.setOpaque(true);
			
			head.setFont(new Font(head.getFont().getFontName(), Font.BOLD, 19));	
			 open.add(head);

			java=new JRadioButton("JAVA");
			ButtonGroup p=new ButtonGroup();
			p.add(c);p.add(java);
			JLabel lan=new JLabel("Select Language:");
			Font font2 = lan.getFont();
			Font boldFont2 = new Font(font2.getFontName(), Font.BOLD, 16);
			lan.setFont(boldFont2);
			open.add(lan);
			open.add(c);open.add(java);
			java.setBounds(70,100,100,20);
			c.setBounds(70,140,50,20);
			lan.setBounds(50,50,300,20);
			open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			start=new JButton(new ImageIcon("Start.png"));
			start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a)
			{
				if((!java.isSelected()&&!c.isSelected()))
					JOptionPane.showMessageDialog(open,"No Language Selected!!!","Alert",JOptionPane.WARNING_MESSAGE); 
				else{ set();       
				open.setVisible(false);
				setVisible(true);}
			}});start.setBounds(100,170,100,100);
			open.add(start);
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
		        b2=new JButton("Previous");  
		        b1.addActionListener(this);  
		        b2.addActionListener(this);  
		        add(b1);add(b2);  
		          
		        l.setBounds(30,40,450,20);  
		        jb[0].setBounds(50,80,500,20);  
		        jb[1].setBounds(50,110,500,20);  
		        jb[2].setBounds(50,140,500,20);  
		        jb[3].setBounds(50,170,500,20);  
		        b1.setBounds(100,240,100,30);  
		        b2.setBounds(270,240,100,30); b2.setEnabled(false);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		        setLayout(null);  
		        setLocation(250,100);  
		        //setVisible(true);
		        setSize(600,400);
			
	}  
	    public void actionPerformed(ActionEvent e)  
	    {  
		        if(e.getSource()==b1)  
		        {  
			            if(check())  
			         {       count=count+1;  flag[current]=true;}
			else
			{
				flag[current]=false;
			}
			System.out.println(selecAns[current]+"\n");	
			
			selected[current]=bg.getSelection();
			for(int i=0;i<4;i++){
				if(jb[i].isSelected()){
					selecAns[current]=jb[i].getText();}}
			
		            current++;  
			b2.setEnabled(true);
		            set();    
		            if(current==9)  
		            {  
			                b1.setText("Submit");    
		            }	  
		        }        
	        if(e.getActionCommand().equals("Submit"))  
	        {  
		            if(check())  
		                count=count+1;  
		            current++;  
		int n=JOptionPane.showConfirmDialog(this,"Press Yes to submit");
		if(n==JOptionPane.YES_OPTION){

		 name=JOptionPane.showInputDialog(this,"Enter Roll Number");while(name.length()!=12)
{
		 name=JOptionPane.showInputDialog(this,"Enter Valid Roll Number");}
		JFrame score=new JFrame("RESULT");
		this.dispose();
		score.setVisible(true);
		JLabel sc=new JLabel(name+" - Score: "+count);
		Font font = sc.getFont();
		Font boldFont = new Font(font.getFontName(), Font.BOLD, 20);
		sc.setFont(boldFont);
		sc.setOpaque(true);
		sc.setBackground(Color.GRAY);
		sc.setForeground(Color.WHITE);
		sc.setBounds(150,20,250,20);
		score.add(sc);
		int x=50,y=50;int flag2=0;
		score.setLayout(null);
		        score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		for(int i=0;i<10;i++)
		{
			if(!flag[i])
			{
				JLabel que=new JLabel();
				JLabel cor=new JLabel();
				JLabel wr=new JLabel();//sc.setSize(300,1000);
				current=i;
				set();
				que.setText(l.getText());
				que.setBounds(x,y,600,30);
				y+=30;
				wr.setText("Selected Answer: "+selecAns[i]);
				wr.setOpaque(true);
				wr.setBackground(Color.RED);
				wr.setForeground(Color.WHITE);
				wr.setBounds(x,y,300,20);
				y+=30; int k=ans(); if(k==5) {k=4;}
				cor.setText("Correct Answer: "+jb[k].getText());cor.setOpaque(true);
				cor.setBackground(Color.GREEN);
				cor.setForeground(Color.WHITE);	
				cor.setBounds(x,y,300,20); y+=30;
				score.add(que);score.add(wr);score.add(cor);
				if(y>700)
				{
					flag2=1; y=50;x=450;}
			}}
			if(flag2==0)
				score.setSize(600,y+150);
			else
				score.setSize(1000,950);}
	}        
	if(e.getSource()==b2)
		{
		current--;
		if(current==0)
			b2.setEnabled(false);
		if(flag[current])
			count--;
		set();
		int answer=ans();//(current);
		
		if(current==8)
			b1.setText("Next");
			
		bg.setSelected(selected[current],true);
		}
	}
	    void set()  
	    {   jb[4].setSelected(true);  
	 
		if(java.isSelected()){ 
	        if(current==0)  
	        {  
	            l.setText("1. What is the size of a float variable?");  
	            jb[0].setText("8 bit");jb[1].setText("16 bit");jb[2].setText("32 bit");jb[3].setText("4 bit");   
	        }  
	        if(current==1)  
	        {  
		            l.setText("2. Which class is parent of Error and Exception classes?");  
		            jb[0].setText("Catchable");jb[1].setText("MainException");jb[2].setText("Throwable");jb[3].setText("Exception");  
	        }  
	        if(current==2)  
	        {  
		            l.setText("3. Which package is directly available to our class without importing it?");  
		            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");  
        	        }  
       	        if(current==3)  
	        {  
		            l.setText("4.  When does static binding occur?");  
		            jb[0].setText("Compile time");jb[1].setText("Run time.");jb[2].setText("Load time.");jb[3].setText("None of the above");  
	        }  
	        if(current==4)  
	        {  
		            l.setText("5. Which of the following statements about abstract is true?");  
		            jb[0].setText("Constructors can be abstract.");jb[1].setText("A subclass of abstract must define methods in it.");jb[2].setText("An abstract class cannot be 			instantiated.");jb[3].setText("Static methods can be abstract");  
	        }  
	        if(current==5)  
	        {  
		            l.setText("6. Which one among these is not a keyword?");  
		            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
	        }  
	        if(current==6)  
	        {  
		            l.setText("7. Which one among these is not a class? ");  
		            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");  
	                        jb[3].setText("Button");  
	        }  
	        if(current==7)  
	        {  
	 	           l.setText("8. What of the following is the default value of a local variable?");  
		            jb[0].setText("Null");jb[1].setText("0");jb[2].setText("Depends on Type of variable");  
	                        jb[3].setText("Not assigned");         
	        }  
	        if(current==8)  
	        {  
		            l.setText("9. which function is not present in Applet class?");  
		            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");  
	        }  
	        if(current==9)  
	        {  
		            l.setText("10. Which one among these is not a valid component?");  
		            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");  
	                        jb[3].setText("JTextArea");  
	        }  
	        l.setBounds(30,40,450,20);  
	        for(int i=0,j=0;i<=90;i+=30,j++)  
	            jb[j].setBounds(50,80+i,500,20);  }
		else{
       if(current==0)  
	        {  
	            l.setText("1. Which function sets first n characters of a string to char?");  
	            jb[0].setText("strinit()");jb[1].setText("strnset()");jb[2].setText("strset()");jb[3].setText("strcset()");   
	        }  
	        if(current==1)  
	        {  
		            l.setText("2. If the two strings are identical, then strcmp() function returns");  
		            jb[0].setText("-1");jb[1].setText("0");jb[2].setText("0");jb[3].setText("Yes");  
	        }  
	        if(current==2)  
	        {  
		            l.setText("3. getch() method exists in?");  
		            jb[0].setText("math.h");jb[1].setText("stdio.h");jb[2].setText("stddef.h");jb[3].setText("conio.h");  
        	        }  
       	        if(current==3)  
	        {  
		            l.setText("4. Which function is used to find the first occurrence of a given string in another string?");  
		            jb[0].setText("strchr()");jb[1].setText("strrchr()");jb[2].setText("strstr()");jb[3].setText("strnset()");  
	        }  
	        if(current==4)  
	        {  
		            l.setText("5.Which of the following function is more appropriate for reading in a multi-word string?");  
		            jb[0].setText("printf()");jb[1].setText("scanf()");jb[2].setText("gets()");jb[3].setText("puts");  
	        }  
	        if(current==5)  
	        {  
		            l.setText("6. Which one among these is not a keyword?");  
		            jb[0].setText("struct");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
	        }  
	        if(current==6)  
	        {  
		            l.setText("7. What is (void*)0");  
		            jb[0].setText("Representation of NULL pointer");jb[1].setText("Representation of void pointer");jb[2].setText("Error");  
	                        jb[3].setText("None of the above");  
	        }  
	        if(current==7)  
	        {  
	 	           l.setText("8. In which header file is NULL decalred?");  
		            jb[0].setText("stdio.h");jb[1].setText("stddef.h");jb[2].setText("Both");  
	                        jb[3].setText("math.h");         
	        }  
	        if(current==8)  
	        {  
		            l.setText("9. How will you remove allocated memory?");  
		            jb[0].setText("remove");jb[1].setText("free");jb[2].setText("delete");jb[3].setText("dealloc");  
	        }  
	        if(current==9)  
	        {  
		            l.setText("10. Which bitwise operator is suitable for turning off a particular bit in a number?");  
		            jb[0].setText("&&");jb[1].setText("&");jb[2].setText("||");  
	                        jb[3].setText("!");  
	        }  
	        l.setBounds(30,40,450,20);  
	        for(int i=0,j=0;i<=90;i+=30,j++)  
	            jb[j].setBounds(50,80+i,500,20);  
	}
	    }  
	    boolean check()  	
	    {
		if(java.isSelected()){  
	        if(current==0)  
		            return(jb[2].isSelected());  
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
	        return false;  }
		else
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
		            return(jb[0].isSelected());  
	        if(current==7)  
		            return(jb[1].isSelected());  
	        if(current==8)  
		            return(jb[1].isSelected());  
	        if(current==9)  
		            return(jb[1].isSelected());  
	        return false;  
}
	    } 
	int ans()  
	    {
	if(java.isSelected()){  
	        if(current==0)  
		            return(2);  
	        if(current==1)  
		            return(2);  
	        if(current==2)  
		            return(3);  
	        if(current==3)  
		            return(0);  
	        if(current==4)  
		            return(2);  
	        if(current==5)  
		            return(2);  
	        if(current==6)  
		            return(1);  
	        if(current==7)  
		            return(3);  
	        if(current==8)  
		            return(1);  
	        if(current==9)  
		            return(2);    }
	else
{
	        if(current==0)  
		            return(1);  
	        if(current==1)  
		            return(2);  
	        if(current==2)  
		            return(3);  
	        if(current==3)  
		            return(0);  
	        if(current==4)  
		            return(2);  
	        if(current==5)  
		            return(2);  
	        if(current==6)  
		            return(0);  
	        if(current==7)  
		            return(1);  
	        if(current==8)  
		            return(1);  
	        if(current==9)  
		            return(1);    
}
	return 5;
	    } 
	    public static void main(String s[])  
	    {  
		        new Quiz("Java Quiz");  
	    }  
}  