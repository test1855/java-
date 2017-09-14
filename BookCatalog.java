package CartSystem;
import java.util.*;
public class BookCatalog {

	ArrayList <ProductSpecification> books;
	
	public BookCatalog()
	{
		books=new ArrayList <ProductSpecification>();		
	}
	
	public ProductSpecification getProductSpecification(String id)
	{
		Iterator<ProductSpecification> it1 = books.iterator();
	    while(it1.hasNext()){
	    	ProductSpecification temp=it1.next();
	    //	System.out.println(temp.toString());
	    	if(temp.isbn.equals(id))
	    		return temp;
	    }
	    return null;
	}
	
	public void addBook(ProductSpecification b)
	{
		books.add(b);
	}
	
	public String printBooks()
	{
		String str="isbn\t"+"书名\t"+"价格\t"+"书类型\n";
		Iterator<ProductSpecification> it1 = books.iterator();
	    while(it1.hasNext()){
	    	ProductSpecification temp=it1.next();
	    	str=str+temp.toString();
	    }
	   // System.out.println(str);
	    return str;
	}
}
