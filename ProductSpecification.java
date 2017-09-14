package CartSystem;

public class ProductSpecification {

	public String isbn;
	private double price;
	public String title;
	public int type;//1非教材类的计算机图书、2教材类图书、3连环画类图书、4其他
	
	public ProductSpecification(String i,double p,String t,int ty)
	{
		isbn=i;
		price=p;
		title=t;
		type=ty;
	}
	public ProductSpecification(ProductSpecification b)
	{
		isbn=b.isbn;
		price=b.getPrice();
		title=b.title;
		type=b.type;
	}
	
	public String toString()
	{
		String str=isbn+"  \t￥"+price+"  \t"+title+"  \t"+type+"\n";
		return str;
	}

	public double getPrice()
	{
		return price;
	}
}
