package CartSystem;

public class PercentageStrategy implements IPricingStrategy{
	
	private String index;
	private String name="百分比折扣策略";
	
	private int fitType;
	private int discountpercentage;
	private int IPricingType=2;

	public PercentageStrategy(String s,int d,int ft)
	{
		index=s;
		discountpercentage=d;
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
	
	//1非教材类的计算机图书、2教材类图书、3连环画类图书、4其他
	public double getSubTotal(SaleLineItem x)
	{
		return x.copies*x.prodSpec.getPrice()*(100-this.discountpercentage)/100.0;
	}
	
	public String toString()
	{
		String str=""+index+'\t'+name+'\t'+fitType+'\t'+discountpercentage+'\n';
		return str;
	}
	
	public String toString1()
	{
		String str="策略编号 策略名称 适用类型 折扣百分比/每本优惠额度 \n"+index+' '+name+' '+fitType+' '+discountpercentage;
		return str;
	}
}
