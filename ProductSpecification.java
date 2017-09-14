package CartSystem;

public class ProductSpecification {

	public String isbn;
	private double price;
	public String title;
	public int type;//1�ǽ̲���ļ����ͼ�顢2�̲���ͼ�顢3��������ͼ�顢4����
	
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
		String str=isbn+"  \t��"+price+"  \t"+title+"  \t"+type+"\n";
		return str;
	}

	public double getPrice()
	{
		return price;
	}
}
