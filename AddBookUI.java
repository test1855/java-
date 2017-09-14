package CartSystem;
import javax.swing.*;  
import java.awt.*; 
//import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookUI extends JFrame implements ActionListener{

	JDialog jd=new JDialog();
	JTextField fillIsbn=new JTextField(10),fillPrice=new JTextField(10),fillTitle=new JTextField(10),fillType=new JTextField(10);
	JLabel Isbn=new JLabel("ISBN"),Price=new JLabel("PRICE"),Title=new JLabel("TITLE"),Type=new JLabel("TYPE");
	JButton OK=new JButton("OK"),Cancel=new JButton("Cancel");
	
	public AddBookUI(){	
		jd.setLayout(new GridLayout(5,2));
		jd.add(Isbn);jd.add(fillIsbn);
		jd.add(Price);jd.add(fillPrice);
		jd.add(Title);jd.add(fillTitle);		
		jd.add(Type);jd.add(fillType);		
		jd.add(OK);jd.add(Cancel);
		OK.addActionListener(this);
		Cancel.addActionListener(this);
		 
		jd.setTitle("AddBook");//窗体标签  
		jd.setSize(500,300);//窗体大小  
		jd.setLocationRelativeTo(null); 
		jd.setVisible(true);			
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == OK)
		 {
			 if(fillIsbn.getText().isEmpty()||fillPrice.getText().isEmpty()||fillTitle.getText().isEmpty()||fillType.getText().isEmpty()){
				 JOptionPane.showMessageDialog(null,"输入不能为空！","AddBookUI",JOptionPane.WARNING_MESSAGE);
			 }
			 else{
				 ProductSpecification b=new ProductSpecification(fillIsbn.getText(),Double.parseDouble(fillPrice.getText()),fillTitle.getText(),Integer.parseInt(fillType.getText()));
				 //ABcontrollers.addBook(b);
				 Global.bookcatalog.addBook(b);
				 JOptionPane.showMessageDialog(null,"书本信息录入成功！","AddBookUI",JOptionPane.WARNING_MESSAGE);
				 jd.setVisible(false);
				 jd.dispose();
				 Global.bookcatalog.books.toString();
			 }
		 }	
		 else if (e.getSource() == Cancel)
		 {
			clear();
			jd.setVisible(false);
			jd.dispose();
		 }
	}

	public void clear()
	{
		fillIsbn.setText("");
		fillPrice.setText("");
		fillTitle.setText("");
		fillType.setText("");
	}	
}
