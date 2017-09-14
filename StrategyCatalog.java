package CartSystem;
import java.util.*;

public class StrategyCatalog {
	
	//���۲���ά��ģ�飬ʵ�ֶԶ��۲��Ե����ӡ�ɾ�����޸ġ���ѯ��
	public Hashtable <String,IPricingStrategy> strategies;
	
	public StrategyCatalog()
	{
		strategies=new Hashtable <String,IPricingStrategy>();
	}
	
	public IPricingStrategy addStrategy(IPricingStrategy i)
	{
		if(strategies.containsKey(i.getIndex())){
			System.out.println("�ò����Ѵ��ڣ����ʧ�ܣ�");
			return null;
		}
		else
		{
			strategies.put(i.getIndex(), i);
			System.out.println("��ӳɹ���");
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
			System.out.println("������Ϣ�����ڣ�����ʧ�ܣ�");
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
		String str="���Ա��\t"+"��������\t"+"����ͼ������\t"+"�ۿ۰ٷֱ�/ÿ���Żݶ��\n";
		Enumeration<IPricingStrategy> s=strategies.elements();
		while(s.hasMoreElements())
			str=str+s.nextElement().toString();
	    System.out.println(str);	
	}
}
