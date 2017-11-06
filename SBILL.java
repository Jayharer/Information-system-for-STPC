import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class SBILL {

	JLabel label1;
	
	JTextField text1;
	
	JButton jbt1,save;
	
	int no_of_entries=0;
	
	JPanel panel1,panel2;
	
	JLabel pnamel,purposel,amountl;
	
	JTextField pnametext;
	
	 JFrame frame1;
	
	JLabel dayl,monthl,yearl;
	
	JTextField day,month,year;
	
	JLabel srecord;
	
	RandomAccessFile rf,raf=null;
	
	double bamount=0,total=0;
	
	Double ftotal;
	class Person{
		
		JTextField purpose,amount;
		
	}
	
	Person p[]=new Person[20];
	
JFrame jf;
	
	SBILL(){
		
		
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		
		label1=new JLabel("Enter No Of Entries ");
		
		text1=new JTextField(15);
		
		jbt1=new JButton("Enter akash");
		
		panel1.add(text1);
		panel1.add(label1);
		
		panel1.add(jbt1);
		
	     jf=new JFrame();
		
		jf.setTitle("Enter Bill");
		jf.setSize(500,300);
		jf.setLocationRelativeTo(null);
		jf.add(panel1);
		jf.setVisible(true);
		
		jbt1ListenerClass listener1=new jbt1ListenerClass();
		
		jbt1.addActionListener(listener1);
		
	}
	
	
	 class jbt1ListenerClass implements ActionListener{
		 
		 public void actionPerformed(ActionEvent e){
			 
		jf.setVisible(false);
			 
			 try{
			no_of_entries=Integer.parseInt(text1.getText()) ;
			
			 }
			 
			 catch (NumberFormatException ea){
				 System.out.println("error in number format in no of entries");
				
			 }
			
			System.out.println(no_of_entries);
			
			for(int i=0;i<20;i++)
				p[i]=new Person();
			
			panel2=new JPanel();
			panel2.setLayout(new GridLayout(0,4));
			
			pnamel=new JLabel("Person Name");
			pnametext=new JTextField(20);
			
			panel2.add(pnamel);
			panel2.add(pnametext);
		
			JLabel l1=new JLabel("");
			JLabel l2=new JLabel("");
			
			panel2.add(l1);
			panel2.add(l2);
			for(int j=0;j<no_of_entries;j++){
				
				purposel=new JLabel("Purpose");
				amountl=new JLabel("Amount");
				
				panel2.add(purposel);
		
				p[j].purpose=new JTextField(15);
				
				panel2.add(p[j].purpose);
				
				panel2.add(amountl);
				
				p[j].amount=new JTextField(15);
				
				panel2.add(p[j].amount);
				
				
			}
			dayl=new JLabel("Enter Day");
			monthl=new JLabel("Enter Month");
			yearl=new JLabel("Enter year");
			
			panel2.add(dayl); 	panel2.add(monthl);		panel2.add(yearl);
			
			JLabel l3=new JLabel("");
			JLabel l4=new JLabel("");
			JLabel l5=new JLabel("");
			JLabel l6=new JLabel("");
			panel2.add(l3);
			
			day=new JTextField(15);
			
			
			
			month=new JTextField(15);
			
		
			
			year=new JTextField(15);
			
			panel2.add(day);
			
		
			panel2.add(month);
			
		
			panel2.add(year);
			
			panel2.add(l4);
			
			
			srecord=new JLabel("Save Record");
			
			save=new JButton("Save");
			
			panel2.add(srecord);
			panel2.add(l5);
			panel2.add(l6);
			panel2.add(save);
		
			 frame1=new JFrame();
				frame1.setTitle("Enter Bill");
				frame1.setSize(500,300);
				frame1.setLocationRelativeTo(null);
				
				frame1.add(panel2);
				frame1.setVisible(true);

			
			System.out.println("here ok");
			
			
		saveClass listener2=new saveClass();
		
		save.addActionListener(listener2);
		
		
			 
		 }
	 }
	
	 class saveClass implements ActionListener{
		 
		 public void actionPerformed(ActionEvent eb){
			 
			 try{
				
				 
				 rf=new RandomAccessFile("sssbill.txt","rw");
				 
				 raf=new RandomAccessFile("data1.txt","rw");
				 
				 System.out.println(rf.length());
				 System.out.println(raf.length());
			 }
			 
			 catch (FileNotFoundException ed){
				 
				 System.out.println("error in opening file");
			 }
		
				catch (IOException er){
					System.out.println("error in io");
				}
			 System.out.println("here is ok 1");
			 
			 
			try{
			
				rf.seek(rf.length());
				
				System.out.println(no_of_entries);
				rf.writeInt(no_of_entries);
				
				System.out.println(pnametext.getText());
				
				
				rf.writeUTF(pnametext.getText());
				
				for(int i=0;i<no_of_entries;i++){
					
					
					System.out.println(p[i].purpose.getText());
					rf.writeUTF(p[i].purpose.getText());
					
					
					System.out.println(p[i].amount.getText());
					bamount=Double.parseDouble(p[i].amount.getText());
					
					total=total+bamount;
					
					rf.writeDouble(bamount);
					
					rf.writeInt(Integer.parseInt(day.getText()));
					rf.writeInt(Integer.parseInt(month.getText()));
					rf.writeInt(Integer.parseInt(year.getText()));
					
				}
				
				System.out.println(total);
				rf.writeDouble(total);
				
				
				
				
				ftotal=raf.readDouble();
				
				ftotal=ftotal+total;
				
				raf.seek(0);
				raf.writeDouble(ftotal);
				
				raf.close();
				
				System.out.println(day.getText());
				System.out.println(month.getText());
				System.out.println(year.getText());
				
				
				System.out.println(rf.length());
				
				rf.close();
			}
			
			
			catch(NumberFormatException ef){
				System.out.println("error in number format");
			}
			
			catch (IOException er){
				System.out.println("error in io");
			}
			
			frame1.setVisible(false);
		 }
	 }
	public static void main(String[] args) {
	
		SBILL obj=new SBILL();
		

	}

}








