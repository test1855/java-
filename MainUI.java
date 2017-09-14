package CartSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainUI extends JFrame implements ActionListener{

	private JMenuBar bar = new JMenuBar();
	private JMenu AddBookUI = new JMenu("AddBookUI");
	private JMenu StrategiesUI = new JMenu("StrategiesUI");
	private JMenu BuyUI = new JMenu("BuyUI");
	private JMenuItem AddBook=new JMenuItem("AddBook");
	private JMenuItem AddSimpleStrategy=new JMenuItem("AddSimpleStrategy");
	private JMenuItem AddCopositeStrategy=new JMenuItem("AddCopositeStrategy");
	private JMenuItem DeleteStrategy=new JMenuItem("DeleteStrategy");
	private JMenuItem UpdataStrategy=new JMenuItem("UpdataStrategy");
	private JMenuItem SearchStrategy=new JMenuItem("SearchStrategy");
	private JMenuItem BuyBook=new JMenuItem("BuyBook");

	public MainUI()
	{			
		initial();
		AddBookUI.add(AddBook);
		StrategiesUI.add(AddSimpleStrategy);
		StrategiesUI.add(AddCopositeStrategy);
		StrategiesUI.add(DeleteStrategy);
		StrategiesUI.add(UpdataStrategy);
		StrategiesUI.add(SearchStrategy);
		BuyUI.add(BuyBook);
		setTitle("MainUI");
		bar.add(AddBookUI);
		bar.add(StrategiesUI);
		bar.add(BuyUI);
		
		setJMenuBar(bar);
		AddBook.addActionListener(this);
		AddSimpleStrategy.addActionListener(this);	  
		AddCopositeStrategy.addActionListener(this);
		DeleteStrategy.addActionListener(this);
		UpdataStrategy.addActionListener(this);
		SearchStrategy.addActionListener(this);
		BuyBook.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == AddBook)
			new AddBookUI();	 
		else if (e.getSource() == AddSimpleStrategy)
			new StrategiesUI().addSimpleStrategy();
		else if (e.getSource() == AddCopositeStrategy)
			new StrategiesUI().addCopositeStrategy();
		else if (e.getSource() == DeleteStrategy)
			new StrategiesUI().deleteStrategy();
		else if (e.getSource() == UpdataStrategy)
			new StrategiesUI().updataStrategy();
		else if (e.getSource() == SearchStrategy)
			new StrategiesUI().searchStrategy();
		else if (e.getSource() == BuyBook)
			new BuyUI().buyBook();
	}
	
	public void initial()
	{
		ProductSpecification book[]=new ProductSpecification[5];
		book[0]=new ProductSpecification("978-7-302-2",18.00,"《UML与模式应用》",2);
		book[1]=new ProductSpecification("978-7-312-3",34.00,"《Java与模式》",1);
		book[2]=new ProductSpecification("968-6-302-1",58.00,"《HeadFirst 设计模式》",1);
		book[3]=new ProductSpecification("958-1-302-2",30.00,"《爱丽丝历险记》",3);
		book[4]=new ProductSpecification("900-7-392-2",20.00,"《煲汤大全》",4);		
		for(int i=0;i<5;i++)
			Global.bookcatalog.addBook(book[i]);
		Global.bookcatalog.printBooks();
		
		FlatRateStrategy f=new FlatRateStrategy("Discount001",1,2);
		Global.strategycatalog.addStrategy(f);
		PercentageStrategy p=new PercentageStrategy("Discount002",7,3);
		Global.strategycatalog.addStrategy(p);
		PercentageStrategy pp=new PercentageStrategy("Discount003",3,1);
		Global.strategycatalog.addStrategy(pp);
		CopositeStrategy c=new CopositeStrategy("Discount0004","Discount001|Discount003",4);
		Global.strategycatalog.addStrategy(c);	
	}
	
	public static void main(String[] args) {	
		new MainUI();  
	}
}
