
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;


public class Scash extends JFrame{

  JLabel label1;
 JTextField text1;
 
 JPanel panel;
 RandomAccessFile rrf;
 
  Scash(){
	  
 try{
		rrf=new RandomAccessFile("data1.txt","r");  
		  
	  }
 
  catch (FileNotFoundException e){
	  System.out.println("error in opening file");
  }
 
 
	  panel=new JPanel();
	  panel.setLayout(new GridLayout(0,2));
	  
	  label1=new JLabel("Total cash Collected ");
	  
	  panel.add(label1);
	  
	  text1=new JTextField(15);
	  
	 try{
		 rrf.seek(0);


		 
		 System.out.println(rrf.length());
		 rrf.seek(0);
		 System.out.println(rrf.readDouble());
		 rrf.seek(0);
		 text1.setText(String.valueOf(rrf.readDouble()));
		 
		 rrf.close();
	 }
	 
	 catch (IOException er){
			System.out.println("error in io");
		}
	 
		catch(NumberFormatException ef){
			System.out.println("error in number format");
		}
	
	 
	 panel.add(text1);
	 
	 add(panel);
	 
	
	  
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame jf=new Scash();
		jf.setTitle(" Total Cash spend");
		jf.setSize(400,150);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

	}

}
