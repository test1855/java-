package CartSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BuyUI extends JFrame implements ActionListener{

	JDialog jd,jd1;
	JTextField fillIsbn=new JTextField(10),fillNumber=new JTextField(10);
	JLabel Isbn=new JLabel("Isbn:"),Number=new JLabel("Number:");
	JLabel BookName=new JLabel("BookName"),shoppingBookInformation,Total=new JLabel("Total"),Totalmoney;
	JButton Buy=new JButton("Buy"),Cancel=new JButton("Cancel"),OK=new JButton("OK");
	
	public void buyBook()
	{
		jd=new JDialog();
		jd.setLayout(new GridLayout(10,2));	
		Iterator<ProductSpecification> it1 = Global.bookcatalog.books.iterator();
		while(it1.hasNext()){
			ProductSpecification temp=it1.next();
			jd.add(new JLabel(temp.toString()));
		}
		jd.add(new JLabel());
		jd.add(Isbn);jd.add(fillIsbn);
		jd.add(Number);jd.add(fillNumber);
		jd.add(Buy);jd.add(Cancel);
		Buy.addActionListener(this);
		Cancel.addActionListener(this);
		
		jd.setTitle("BuyBook");//窗体标签  
		jd.setSize(1000,500);//窗体大小  
		jd.setLocationRelativeTo(null); 
		jd.setVisible(true);	
	}
	
	public void shoppingCar()
	{
		jd1=new JDialog();
		jd1.setLayout(new GridLayout(8,2));
		jd1.add(BookName);jd1.add(Number);
		Iterator<SaleLineItem> it1 = Global.shoppingsales.items.iterator();
		while(it1.hasNext()){
			SaleLineItem temp=it1.next();
			jd1.add(new JLabel(temp.prodSpec.title));
		    jd1.add(new JLabel(String.valueOf(temp.copies)));
		}
		Totalmoney=new JLabel(String.valueOf(Global.shoppingsales.getTotal()));
		jd1.add(Total);jd1.add(Totalmoney);
		jd1.add(OK);
		OK.addActionListener(this);
		jd1.setTitle("BuyBook");//窗体标签  
		jd1.setSize(1000,500);//窗体大小  
		jd1.setLocationRelativeTo(null); 
		jd1.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == Buy)
		{
			if(fillIsbn.getText().isEmpty()||fillNumber.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Isbn或Number输入不能为空！","StrategiesUI",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				String lineisbn=fillIsbn.getText();
				int linenum=Integer.parseInt(fillNumber.getText());
				ProductSpecification temp=Global.bookcatalog.getProductSpecification(lineisbn);
				if(temp==null){
					JOptionPane.showMessageDialog(null,"Isbn不存在！","StrategiesUI",JOptionPane.WARNING_MESSAGE);
				}
				else if(temp!=null&&linenum>0){
					SaleLineItem line=new SaleLineItem(linenum,temp);
					Global.shoppingsales.addSaleLineItem(line);
					System.out.println(Global.shoppingsales.toString());
					clear();
					jd.setVisible(false);
					jd.dispose();	
					shoppingCar();
				}
				
				
				else{
					JOptionPane.showMessageDialog(null,"Number输入错误！","StrategiesUI",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		else if(e.getSource()==OK)
		{
			jd1.setVisible(false);
			jd1.dispose();
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
		fillNumber.setText("");
	}
	
}
