package CartSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StrategiesUI extends JFrame implements ActionListener{

	//���۲���ά��ģ�飬ʵ�ֶԶ��۲��Ե����ӡ�ɾ�����޸ġ���ѯ��
	//private int discountpercentage;	private String index;private String name="����ֵ�Żݼ򵥲���";private int fitType;
	
	JDialog jd,jd1,jd2,jd3,jd4;
	JTextField fillIndex=new JTextField(10),fillDiscountPercentage=new JTextField(10),fillFitType=new JTextField(10);
	JLabel Index=new JLabel("INDEX"),DiscountPercentage=new JLabel("Discountpercentage"),FitType=new JLabel("FitType");
	JButton FlatRate=new JButton("AddFlatRateStrategy"),Percentage=new JButton("AddPercentageStrategy"),NoDiscount=new JButton("AddNoDiscountStrategy"),Coposite=new JButton("AddCompositStrategy");
	JButton Cancel=new JButton("Cancel"),Cancel1=new JButton("Cancel"),Cancel2=new JButton("Cancel"),Cancel3=new JButton("Cancel"),Cancel4=new JButton("Cancel");
	JButton OK2=new JButton("OK"),OK3=new JButton("OK"),OK4=new JButton("OK");
	
	public void addSimpleStrategy()
	{	
		jd=new JDialog();
		jd.setLayout(new GridLayout(5,2));
		jd.add(Index);jd.add(fillIndex);
		jd.add(DiscountPercentage);jd.add(fillDiscountPercentage);
		jd.add(FitType);jd.add(fillFitType);			
		jd.add(FlatRate);jd.add(Percentage);
		jd.add(NoDiscount);jd.add(Cancel);
		FlatRate.addActionListener(this);
		Percentage.addActionListener(this);
		NoDiscount.addActionListener(this);
		Coposite.addActionListener(this);
		Cancel.addActionListener(this);
		
		jd.setTitle("AddSimpleStrategy");//�����ǩ  
		jd.setSize(500,300);//�����С  
		jd.setLocationRelativeTo(null); 
		jd.setVisible(true);			
	}
	public void addCopositeStrategy()
	{	
		jd1=new JDialog();
		jd1.setLayout(new GridLayout(5,2));
		jd1.add(Index);jd1.add(fillIndex);
		jd1.add(DiscountPercentage);jd1.add(fillDiscountPercentage);
		jd1.add(FitType);jd1.add(fillFitType);			
		jd1.add(Coposite);
		jd1.add(Cancel1);
		Coposite.addActionListener(this);
		Cancel1.addActionListener(this);
		
		jd1.setTitle("AddCopositeStrategy");//�����ǩ  
		jd1.setSize(500,300);//�����С  
		jd1.setLocationRelativeTo(null); 
		jd1.setVisible(true);			
	}
		
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == FlatRate)
		{
			if(fillIndex.getText().isEmpty()||fillDiscountPercentage.getText().isEmpty()||fillFitType.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"FlatRate���벻��Ϊ�գ�","StrategiesUI",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
					FlatRateStrategy f=new FlatRateStrategy(fillIndex.getText(),Integer.parseInt(fillDiscountPercentage.getText()),Integer.parseInt(fillFitType.getText()));
					Global.strategycatalog.addStrategy(f);
					JOptionPane.showMessageDialog(null,"FlatRate������Ϣ¼��ɹ���","StrategiesUI",JOptionPane.WARNING_MESSAGE);
					clear();
					jd.setVisible(false);
					jd.dispose();
					Global.strategycatalog.printStrategy();				
					showStrategies();
			}
		}
		else if(e.getSource() == Percentage)
		{
			if(fillIndex.getText().isEmpty()||fillDiscountPercentage.getText().isEmpty()||fillFitType.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Percentage���벻��Ϊ�գ�","StrategiesUI",JOptionPane.WARNING_MESSAGE);
			}
			else
			{	
				PercentageStrategy f=new PercentageStrategy(fillIndex.getText(),Integer.parseInt(fillDiscountPercentage.getText()),Integer.parseInt(fillFitType.getText()));
				Global.strategycatalog.addStrategy(f);
				JOptionPane.showMessageDialog(null,"Percentage������Ϣ¼��ɹ���","StrategiesUI",JOptionPane.WARNING_MESSAGE); 
				clear();
				jd.setVisible(false);
				jd.dispose();
				Global.strategycatalog.printStrategy();				
				showStrategies();
			}
		}
		else if(e.getSource() == NoDiscount)
		{
			if(fillIndex.getText().isEmpty()||fillDiscountPercentage.getText().isEmpty()||fillFitType.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Nodiscount���벻��Ϊ�գ�","StrategiesUI",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				NoDiscountStrategy f=new NoDiscountStrategy(fillIndex.getText(),Integer.parseInt(fillFitType.getText()));
				Global.strategycatalog.addStrategy(f);					
				JOptionPane.showMessageDialog(null,"NoDiscount������Ϣ¼��ɹ���","StrategiesUI",JOptionPane.WARNING_MESSAGE);
				clear();
				jd.setVisible(false);
				jd.dispose();
				Global.strategycatalog.printStrategy();				
				showStrategies();
			}
		}
	
		else if (e.getSource() == Coposite)
		{
			if(fillIndex.getText().isEmpty()||fillDiscountPercentage.getText().isEmpty()||fillFitType.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Composite���벻��Ϊ�գ�","StrategiesUI",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				CopositeStrategy f=new CopositeStrategy(fillIndex.getText(),fillDiscountPercentage.getText(),Integer.parseInt(fillFitType.getText()));
				Global.strategycatalog.addStrategy(f);	
					
				JOptionPane.showMessageDialog(null,"Composite��ϲ�����Ϣ¼��ɹ���","StrategiesUI",JOptionPane.WARNING_MESSAGE);			
				clear();
				jd1.setVisible(false);
				jd1.dispose();	
				Global.strategycatalog.printStrategy();				
				showStrategies();
			}
		}
		
		else if(e.getSource() == OK2)
		{
			if(fillIndex.getText().isEmpty())
				JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			else
			{
				if( Global.strategycatalog.searchStrategy(fillIndex.getText())==null)
					JOptionPane.showMessageDialog(null,"������Ϣ�����ڣ�ɾ��ʧ�ܣ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				else
				{
					Global.strategycatalog.deleteStrategy(fillIndex.getText());
					JOptionPane.showMessageDialog(null,"ɾ���ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);			
				}
				clear();
				jd2.setVisible(false);
				jd2.dispose();
			}		
		}
		else if(e.getSource() == OK3)
		{
			if(fillIndex.getText().isEmpty()||fillDiscountPercentage.getText().isEmpty()||fillFitType.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				if(Global.strategycatalog.strategies.get(fillIndex.getText())==null)
					JOptionPane.showMessageDialog(null,"������Ϣ�����ڣ��޸�ʧ�ܣ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				else
				{
					Global.strategycatalog.updateStrategy(fillIndex.getText(),fillDiscountPercentage.getText(),fillFitType.getText());
					
				}		
				clear();		
				jd3.setVisible(false);
				jd3.dispose();
				Global.strategycatalog.printStrategy();				
				showStrategies();			
			}
		}
		else if(e.getSource() == OK4)
		{
			if(fillIndex.getText().isEmpty())
				JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			else
			{
				if( Global.strategycatalog.searchStrategy(fillIndex.getText())==null)
					JOptionPane.showMessageDialog(null,"������Ϣ�����ڣ�����ʧ�ܣ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				else
				{
					JOptionPane.showMessageDialog(null, Global.strategycatalog.searchStrategy(fillIndex.getText()).toString1(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
				clear();
				jd4.setVisible(false);
				jd4.dispose();
			}
			
		}
		
		else if (e.getSource() == Cancel)
		{
			clear();
			jd.setVisible(false);
			jd.dispose();
		}
		else if (e.getSource() == Cancel1)
		{
			clear();
			jd1.setVisible(false);
			jd1.dispose();
		}
		else if (e.getSource() == Cancel2)
		{
			clear();
			jd2.setVisible(false);
			jd2.dispose();
		}
		else if (e.getSource() == Cancel3)
		{
			clear();
			jd3.setVisible(false);
			jd3.dispose();
		}
		else if (e.getSource() == Cancel4)
		{
			jd4.setVisible(false);
			jd4.dispose();
		}
	}
	
	public void deleteStrategy()
	{
		jd2=new JDialog();
		jd2.setLayout(new GridLayout(2,2));
		jd2.add(Index);jd2.add(fillIndex);
		
		jd2.add(OK2);
		jd2.add(Cancel2);
		OK2.addActionListener(this);
		Cancel2.addActionListener(this);		
		jd2.setTitle("SearchStrategy");//�����ǩ  
		jd2.setSize(500,300);//�����С  
		jd2.setLocationRelativeTo(null); 
		jd2.setVisible(true);		
	}
	
	public void updataStrategy()
	{
		jd3=new JDialog();
		jd3.setLayout(new GridLayout(4,2));
		jd3.add(Index);jd3.add(fillIndex);
		jd3.add(DiscountPercentage);jd3.add(fillDiscountPercentage);
		jd3.add(FitType);jd3.add(fillFitType);
		jd3.add(OK3);
		jd3.add(Cancel3);
		OK3.addActionListener(this);
		Cancel3.addActionListener(this);
		
		jd3.setTitle("UpdateStrategy");//�����ǩ  
		jd3.setSize(500,300);//�����С  
		jd3.setLocationRelativeTo(null); 
		jd3.setVisible(true);			
	}
	public void searchStrategy()
	{
		jd4=new JDialog();
		jd4.setLayout(new GridLayout(2,2));
		jd4.add(Index);jd4.add(fillIndex);
		
		jd4.add(OK4);
		jd4.add(Cancel4);
		OK4.addActionListener(this);
		Cancel4.addActionListener(this);		
		jd4.setTitle("SearchStrategy");//�����ǩ  
		jd4.setSize(500,300);//�����С  
		jd4.setLocationRelativeTo(null); 
		jd4.setVisible(true);			
	}
	
	public void showStrategies()
	{
		 Global.strategycatalog.printStrategy();
	}
	
	public void clear()
	{
		fillIndex.setText("");
		fillDiscountPercentage.setText("");
		fillFitType.setText("");
	}		
}
