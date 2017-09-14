package CartSystem;
import java.util.*;

public class CopositeStrategy implements IPricingStrategy{
	//public int IPricingtype=3;
	//对所有的教材类图书    实行每本一元的折扣；
	//对连环画类图书3提供每本7%的促销折扣；而对非教材类的计算机图书1有3%的折扣；对其余书没有折扣。
	private int discountpercentage;
	private String index;
	private String name="组合策略";
	private int fitType;
	private String simplyindex="";
	private int IPricingType=3;
	
	public CopositeStrategy(String s,String si,int ft)
	{
		index=s;
	    simplyindex=si;		
		fitType=ft;
	}
	
	public String getIndex()
	{
		return this.index;
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
		return simplyindex;
	}
	public void setDiscountPercentage(String x)
	{
		discountpercentage=Integer.parseInt(x);
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
	
	public String toString()
	{
		String str=""+index+'\t'+name+'\t'+fitType+'\t'+simplyindex+'\n';
		return str;
	}
	
	public String toString1()
	{
		String str="策略编号 策略名称 适用类型 折扣百分比/每本优惠额度 \n"+index+' '+name+' '+fitType+' '+discountpercentage;
		return str;
	}
	
	public double getSubTotal(SaleLineItem x)
	{
		double min=0.0;
		String []array=simplyindex.split("\\|");
		
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
			IPricingStrategy temp= Global.strategycatalog.searchStrategy(array[i]);
			if(i==0&&temp!=null)
				min=temp.getSubTotal(x);
			else if(temp!=null){
				if(min>temp.getSubTotal(x))
					min=temp.getSubTotal(x);
			}
	    }
	    return min;
	}
}
