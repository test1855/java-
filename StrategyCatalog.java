package CartSystem;
import java.util.*;

public class StrategyCatalog {
	
	//定价策略维护模块，实现对定价策略的增加、删除、修改、查询。
	public Hashtable <String,IPricingStrategy> strategies;
	
	public StrategyCatalog()
	{
		strategies=new Hashtable <String,IPricingStrategy>();
	}
	
	public IPricingStrategy addStrategy(IPricingStrategy i)
	{
		if(strategies.containsKey(i.getIndex())){
			System.out.println("该策略已存在，添加失败！");
			return null;
		}
		else
		{
			strategies.put(i.getIndex(), i);
			System.out.println("添加成功！");
			return i;
		}
	}
	public IPricingStrategy deleteStrategy(String i)
	{
		return strategies.remove(i);		
	}
	public IPricingStrategy updateStrategy(String id,String dp,String ft)
	{
		if(strategies.containsKey(id)==false)
		{
			System.out.println("策略信息不存在，更新失败！");
			return null;
		}
		else
		{
			strategies.get(id).setDiscountPercentage(dp);
			strategies.get(id).setFitType(Integer.parseInt(ft));
			return strategies.get(id);
		}
	}
	public IPricingStrategy searchStrategy(String x)
	{
		if(strategies==null||strategies.isEmpty())
			return null;
		else 
			return strategies.get(x);
	}
	
	public void printStrategy()
	{
		String str="策略编号\t"+"策略名称\t"+"试用图书类型\t"+"折扣百分比/每本优惠额度\n";
		Enumeration<IPricingStrategy> s=strategies.elements();
		while(s.hasMoreElements())
			str=str+s.nextElement().toString();
	    System.out.println(str);	
	}
}
