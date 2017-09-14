package CartSystem;
import java.util.*;

public class Sale {
	ArrayList <SaleLineItem> items;
	
	public Sale()
	{
		items=new ArrayList<SaleLineItem>();
	}

	public void addSaleLineItem(SaleLineItem x)
	{
		items.add(x);
	}
	public String toString()
	{
		String str="";
		if(items!=null){
			Iterator<SaleLineItem> it1 = items.iterator();
			while(it1.hasNext())
				str=str+it1.next().toString();
		}
	    return str;
	}

	public double getTotal()
	{
		double total=0.0;
		int i=0;
		if(items!=null){
			Iterator<SaleLineItem> it1 = items.iterator();
			while(it1.hasNext()){
				total=total+it1.next().strategy.getSubTotal(items.get(i));
				i++;
			}
		}
	    return total;
	}
}
