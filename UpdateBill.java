
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class UpdateBill {

	JPanel panel1;
	JLabel label1;
	JTextField text1;
	JButton jbt1;
	
	String searchname,personename;
	
	

	JButton save;
	static int old_no_of_entries;
	
	
	JPanel panel2;
	
	JLabel pnamel,purposel,amountl;
	JTextField pnametext;
	

	 JFrame jf;
	
	JLabel dayl,monthl,yearl;
	
	JTextField daytext,monthtext,yeartext;
	
	JLabel srecord;
	
	RandomAccessFile rf=null,raf;
	
	static double total=0;
	
	
	static long initialfpointer,nameendfpointer;
	
	static int nbytes=0;
	
	class Person{
		
		JTextField purpose,amount;
		
	}
	
	Person p[]=new Person[20];
	
	void function(){
		
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		
		label1=new JLabel("Enter Name Of Person ");
		text1=new JTextField(15);
		
		jbt1=new JButton("Enter");
		
		panel1.add(text1);
		panel1.add(label1);
		
		panel1.add(jbt1);
	
		jf=new JFrame();
		 jf.setTitle("Update Bill");
			jf.setSize(500,300);
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
		
		jf.add(panel1);
		
		jbt1ListenerClass listener1=new jbt1ListenerClass();
		jbt1.addActionListener(listener1);
		
	}
	
 class jbt1ListenerClass implements ActionListener{
		 
		 public void actionPerformed(ActionEvent e){
			 
			jf.setVisible(false);
			 
				try{
					rf=new RandomAccessFile("ssbill.txt","rw");
					raf=new RandomAccessFile("rawdata1.txt","rw");
				}
				
				catch (FileNotFoundException eq){
					System.out.println("error in opening file");
				}
			 
	try{
		searchname=text1.getText();
		System.out.println(searchname);
	}
	
	catch (NumberFormatException ea){
		
		System.out.println("error in number format 1");
		
	}
	
	boolean flag=false;
	
	try{
	
	while(true){
		
		System.out.println("file pointer"+rf.getFilePointer());
		System.out.println("file length"+rf.length());
		
		if(rf.length()==rf.getFilePointer()) { 
			
			System.out.println("search unsuccessful");
			
			break;
			} // if block end
		
		initialfpointer=rf.getFilePointer();    //initial file pointer
			
		old_no_of_entries=rf.readInt();
		
		personename=rf.readUTF();
		
	
		
		System.out.println(personename);
		
		if(searchname.equals(personename)){
			
		
			System.out.println("search successful");
			
			for(int i=0;i<old_no_of_entries;i++){
				
				rf.readUTF();
				rf.readDouble();
				rf.readInt();
				rf.readInt();
				rf.readInt();
				
				
			}
			
			nameendfpointer=rf.getFilePointer();  // name file pointer
			
			total=rf.readDouble();
			
			System.out.println("total amount"+total);
			
			
			
			java70 obj=new java70();
			
			
			rf.seek((nameendfpointer+8));
			
			System.out.println("rf file pointer"+rf.getFilePointer());
			
			while(true){
				
				if(rf.length()==rf.getFilePointer())   break;
				
				int n=rf.readInt();
				
				raf.writeInt(n);
				raf.writeUTF(rf.readUTF());
				
				for(int i=0;i<n;i++){
					
					raf.writeUTF(rf.readUTF());
					raf.writeDouble(rf.readDouble());
					raf.writeInt(rf.readInt());
					raf.writeInt(rf.readInt());
					raf.writeInt(rf.readInt());
				}
				
				raf.writeDouble(rf.readDouble());
			}
			
			System.out.println("rawdat length"+raf.length());
			
			flag=true;
		
		}
		
	if(flag) break;
		
		for(int i=0;i<old_no_of_entries;i++){
			
			rf.readUTF();
			rf.readDouble();
			rf.readInt();
			rf.readInt();
			rf.readInt();
		}
			
			rf.readDouble();
		
	         } // while loop end
	
	 rf.close();
	raf.close();
	} // try block end	
	
	catch (IOException ed){	System.out.println("error in io");}
	
	
	 } // action performed method end
 }  // jbt1 listener end
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		UpdateBill jff=new UpdateBill();
		
		jff.function();
	}

}








