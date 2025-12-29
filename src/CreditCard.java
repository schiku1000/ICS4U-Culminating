public class CreditCard extends Card {
    
    // Added Instance Variable
    private double dblLimit; 
    
    // Constructor
    public CreditCard(String strName, String strBank, String strNumber, String strExpiry, short srtCVV, double dblLimit) {
	super(strName, strBank, strNumber, strExpiry, srtCVV); 
	this.dblLimit = dblLimit;
    }
    
    // Getter method for limit 
    public double getLimit() {
	return dblLimit; 
    }
    
    // Setter Method (ONLY FOR BALANCE) 
    // I would do name too, but when you change your name, it also changes your card number typically (NOT ALWAYS)
    public void setLimit(double dblLimit) {
	this.dblLimit = dblLimit;
    }
    
    // toString() method
    @Override 
    public String toString() { 
        return super.toString() + dblLimit + "\n";
    }
}