package CartSystem;

public class NoDiscountStrategy  implements IPricingStrategy{
	
	//1�ǽ̲���ļ����ͼ�顢2�̲���ͼ�顢3��������ͼ�顢4����
	private int discountpercentage=0;
	private String index;
	private String name="���Żݲ���";
	private int fitType;
	private int IPricingType=0;
	
	public NoDiscountStrategy (String s,int ft)
	{
		index=s;
		fitType=ft;
	}
	
	public String getIndex()
	{
		return index;
	}
	public void setIndex(String s)
	{
		index=s;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name=n;
	}
	
	public String getDiscountPercentage()
	{
		return String.valueOf(discountpercentage);
	}
	public void setDiscountPercentage(String x)
	{
		this. discountpercentage=Integer.parseInt(x);
	}
	
	public int getFitType()
	{
		return fitType;
	}
	public void setFitType(int t)
	{
		fitType=t;
	}
	public int getIPricingType()
	{
		return IPricingType;
	}
	
	public double getSubTotal(SaleLineItem x)
	{
		return x.copies*x.prodSpec.getPrice();
	}	
	
	public String toString()
	{
		String str=""+index+'\t'+name+'\t'+fitType+'\t'+discountpercentage+'\n';
		return str;
	}
	
	public String toString1()
	{
		String str="���Ա�� �������� �������� �ۿ۰ٷֱ�/ÿ���Żݶ�� \n"+index+' '+name+' '+fitType+' '+discountpercentage;
		return str;
	}
}