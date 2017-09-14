package CartSystem;

public class Controller {
	
	public BookCatalog bookcatalog;
	public StrategyCatalog strategycatalog;
	
	public Controller()
	{
		bookcatalog=new BookCatalog();
		strategycatalog=new StrategyCatalog();
	}
	
	public void addBook(ProductSpecification b)
	{
		bookcatalog.books.add(b);
		bookcatalog.printBooks();
	}
	
	public void addCopositeStrategy(IPricingStrategy i)
	{
		strategycatalog.addStrategy(i);
	}
	public void addSimpleStrategy(IPricingStrategy i)
	{
		strategycatalog.addStrategy(i);
	}
	public void deleteStrategy(String id)
	{
		strategycatalog.deleteStrategy(id);
	}
	public void updateStrategy(String id,String dp,String ft)
	{
		strategycatalog.updateStrategy(id, dp, ft);
	}
	public IPricingStrategy searchStrategy(String id)
	{
		return strategycatalog.searchStrategy(id);
	}
}