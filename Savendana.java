import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Savendana extends JFrame{

	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;

	JButton jbt1;
	JButton jbt2;
	JButton jbt3;
	JButton jbt4;
	
	Savendana(){
		
		 label1=new JLabel("Store Bill Record ");
		   label2=new JLabel("Update Previous Bill Record ");
		   label3=new JLabel("Show All Bills ");
		   label4=new JLabel("Show Total Cash Collected ");
		   
		   
		   jbt1=new JButton("ENTER 01 ");
		   jbt2=new JButton("ENTER 02");
		   jbt3=new JButton("ENTER 03");
		   jbt4=new JButton("ENTER 04");
		   
		   JPanel panel1=new JPanel();
		   
		   panel1.setLayout(new GridLayout(0,2));
		   panel1.add(label1);
		   panel1.add(jbt1);
		   panel1.add(label2);
		   panel1.add(jbt2);
		   panel1.add(label3);
		   panel1.add(jbt3);
		   panel1.add(label4);
		   panel1.add(jbt4);
		   add(panel1);
		   
		   jbt1ListnerClass listener1=new jbt1ListnerClass();
		   jbt1.addActionListener(listener1);
		   
		   jbt2ListenerClass listener2=new jbt2ListenerClass();
		   jbt2.addActionListener(listener2);
		   
		   jbt3listenerClass listener3=new jbt3listenerClass();
		   jbt3.addActionListener(listener3);
		   
		   jbt4listenerClass listener4=new jbt4listenerClass();
		   jbt4.addActionListener(listener4);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame jf=new Savendana();
		jf.setTitle("Enter Bill");
		jf.setSize(500,300);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}

}



class jbt1ListnerClass implements ActionListener{
	 
	 public void actionPerformed(ActionEvent e){
		 
		 
				
				SBILL obj=new SBILL();
				
		  
		 
	 }
	 
}



class jbt2ListenerClass implements ActionListener{
	 
	 public void actionPerformed(ActionEvent e){
		 UpdateBill obj=new UpdateBill();
		
		 obj.function();
			
	 }
}


class jbt3listenerClass implements ActionListener{
	 
	 public void actionPerformed(ActionEvent e){
		 
		 JFrame myframe=new ShowBill();
			myframe.setTitle("MAKE BILL");
			myframe.setSize(500,300);
			
			
			myframe.setLocationRelativeTo(null);
			
			myframe.setVisible(true);
			
		 
	 }
	 
}


class  jbt4listenerClass implements ActionListener{
	 
	 public void actionPerformed(ActionEvent e){
		 
		 JFrame myframe=new Scash();
			myframe.setTitle("Show  RECORD");
			myframe.setSize(500,150);
			
			
			myframe.setLocationRelativeTo(null);
			
			myframe.setVisible(true);
			
	 }
}

