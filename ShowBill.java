
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import java.io.*;

public class ShowBill extends JFrame{
	
 JLabel pnamelabel,purposelabel,amountlabel,totallabel;
 JTextField pnametext,purposetext,amounttext,totaltext;
 
 int no_of_entries;
 
 JLabel dayl,monthl,yearl;
 JTextField daytext,monthtext,yeartext;
 
 RandomAccessFile rf;
 
JPanel panel;
 JScrollBar jsb;
 ShowBill(){
	 
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,7));
		

		try{
			rf=new RandomAccessFile("sssbill.txt","rw");
		}
		
		catch (FileNotFoundException e){
			System.out.println("error in opening file sorry");
		}
		try{
			
		
			while(true){
		
     
				System.out.println("file length "+rf.length());
				
				System.out.println("file pointer"+rf.getFilePointer());
				
				if(rf.length()==rf.getFilePointer()){ 
					
					rf.close();
					break; }
				
				
			
			no_of_entries=rf.readInt();
			
			System.out.println(rf.getFilePointer());
			pnamelabel=new JLabel("Person Name");
			
			panel.add(pnamelabel);
			
			pnametext=new JTextField(15);
			
			pnametext.setText(rf.readUTF());
			
			
			System.out.println(rf.getFilePointer());
			panel.add(pnametext);
			
			JLabel l1=new JLabel("");
			JLabel l2=new JLabel("");
			
			panel.add(l1);
			panel.add(l2);
			
			
			dayl=new JLabel(" Day");
			monthl=new JLabel(" Month");
			yearl=new JLabel(" year");
			
			panel.add(dayl);
			panel.add(monthl);
			panel.add(yearl);
			
			
			for(int i=0;i<no_of_entries;i++){
				
				purposelabel=new JLabel("Purpose");
				
				panel.add(purposelabel);
				
				purposetext=new JTextField(15);
				
				purposetext.setText(rf.readUTF());
				
				panel.add(purposetext);
				
				amountlabel=new JLabel("Amount");
			
				panel.add(amountlabel);
				
				amounttext=new JTextField(15);
				
				amounttext.setText(String.valueOf(rf.readDouble()));
				
				panel.add(amounttext);
				
				   daytext=new JTextField(5);
					monthtext=new JTextField(5);
					yeartext=new JTextField(5);
					
					daytext.setText(String.valueOf(rf.readInt()));
					monthtext.setText(String.valueOf(rf.readInt()));
					yeartext.setText(String.valueOf(rf.readInt()));
					
					panel.add(daytext);
					panel.add(monthtext);
					panel.add(yeartext);
			}
			
			totallabel=new JLabel("Total");
			panel.add(totallabel);
			
			totaltext=new JTextField(15);
			
			totaltext.setText(String.valueOf(rf.readDouble()));
			
			JLabel l3=new JLabel("");
			JLabel l4=new JLabel("");
			
			panel.add(l3);
			panel.add(l4);
			
			panel.add(totaltext);
			
			
		
			
			
            JLabel l5=new JLabel("");
		
			panel.add(l5);
			
			JLabel l6=new JLabel("");
		
			panel.add(l6);
		
			
			JLabel l7=new JLabel("");
			
			panel.add(l7);
			} // while end
			
		} //try end
		catch (IOException e){
			System.out.println("error in io");
			
		}
		
		catch (NumberFormatException e){
			System.out.println("error in number format");
			
		}
		
		add(panel);
	
		 jsb=new JScrollBar(JScrollBar.VERTICAL);
		add(jsb,BorderLayout.EAST);
		
		jsbClass listener=new jsbClass();
		
		jsb.addAdjustmentListener(listener);
		
 }
 
class  jsbClass implements AdjustmentListener{
	
	public void adjustmentValueChanged(AdjustmentEvent e){
		
		int value=jsb.getValue();
		int maxvalue=jsb.getMaximum();
		double newy=(value*(panel.getWidth()/maxvalue));
		
	
		
		
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 
		JFrame jf=new ShowBill();
		jf.setTitle("show Bill");
		jf.setSize(500,300);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
	



}








