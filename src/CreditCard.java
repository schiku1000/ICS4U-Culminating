public class CreditCard extends Card {
    
    // Added Instance Variable
    private long lngLimit; 
    
    // Constructor
    public CreditCard(String strName, String strBank, long lngNumber, String strExpiry, short srtCVV, long lngLimit) {
	super(strName, strBank, lngNumber, strExpiry, srtCVV); 
	this.lngLimit = lngLimit;
    }
    
    // Setter Method (ONLY FOR BALANCE) 
    // I would do name too, but when you change your name, it also changes your card number typically (NOT ALWAYS)
    public void setLimit(long lngLimit) {
	this.lngLimit = lngLimit;
    }
    
    // toString() method
    @Override 
    public String toString() { 
        return super.toString() + lngLimit + "\n";
    }
}