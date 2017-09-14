package CartSystem;

public interface IPricingStrategy {

	public double getSubTotal(SaleLineItem x);
	
	public String getIndex();
	public void setIndex(String i);
	
	public String getName();
	public void setName(String n);
	
	public int getFitType();
	public void setFitType(int t);
	
	public String getDiscountPercentage();
	public void setDiscountPercentage(String d);
	
	public String toString();
	public String toString1();
	
	public int getIPricingType();
}
