package CartSystem;

public class SaleLineItem {
	
	public int copies;
	public ProductSpecification prodSpec;
	public IPricingStrategy strategy;
	
	public SaleLineItem(int c,String i,double p,String t,int ty)
	{
		copies=c;
		prodSpec=new ProductSpecification(i,p,t,ty);
		strategy=(new PricingStrategyFactory()).getPricingStrategy(ty); 
	}	
	public SaleLineItem(int c,ProductSpecification b)
	{
		copies=c;	
		prodSpec=new ProductSpecification(b);
		strategy=(new PricingStrategyFactory()).getPricingStrategy(b.type); 
	}
	public String toString()
	{
		return ""+prodSpec.title+copies+"\n";
	}
	
	public double getSubTotal()
	{
		return copies*prodSpec.getPrice();
//		return copies*strategy.getSubTotal(x)
	}
}
