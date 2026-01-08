public class CreditCard extends Card {
    
    // Added Instance Variable
    private String strLimit; 
    
    // Constructor
    public CreditCard(String strName, String strBank, String strNumber, String strExpiry, String strCVV, String strLimit) {
	super(strName, strBank, strNumber, strExpiry, strCVV); 
	this.strLimit = strLimit;
    }
    
    // Getter method for limit 
    public String getLimit() {
	return strLimit; 
    }
    
    // Setter Method (ONLY FOR BALANCE) 
    // I would do name too, but when you change your name, it also changes your card number typically (NOT ALWAYS)
    public void setLimit(String strLimit) {
	this.strLimit = strLimit;
    }
    
    // toString() method
    @Override 
    public String toString() { 
        return super.toString() + strLimit + "\n";
    }
}