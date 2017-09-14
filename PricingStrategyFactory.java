package CartSystem;

import java.util.Enumeration;

public class PricingStrategyFactory {

	private PricingStrategyFactory instance;
	
	public PricingStrategyFactory getInstance()
	{
		return instance;
	}

	public IPricingStrategy getPricingStrategy(int bookType)
	{
		Enumeration<IPricingStrategy> s=Global.strategycatalog.strategies.elements();
		while(s.hasMoreElements()){
			IPricingStrategy temp=s.nextElement();
			if(temp.getFitType()==bookType)
				return temp;
		}
		return null;
	}
}
