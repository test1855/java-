package CartSystem;
import java.util.*;

public class CopositeStrategy implements IPricingStrategy{
	//public int IPricingtype=3;
	//�����еĽ̲���ͼ��    ʵ��ÿ��һԪ���ۿۣ�
	//����������ͼ��3�ṩÿ��7%�Ĵ����ۿۣ����Էǽ̲���ļ����ͼ��1��3%���ۿۣ���������û���ۿۡ�
	private int discountpercentage;
	private String index;
	private String name="��ϲ���";
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
		String str="���Ա�� �������� �������� �ۿ۰ٷֱ�/ÿ���Żݶ�� \n"+index+' '+name+' '+fitType+' '+discountpercentage;
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
