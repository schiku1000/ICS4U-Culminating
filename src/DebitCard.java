public class DebitCard extends Card {
    
    // Added Instance Variable
    private long lngBalance; 
    
    // Constructor
    public DebitCard(String strName, String strBank, long lngNumber, String strExpiry, short srtCVV, long lngBalance) {
	super(strName, strBank, lngNumber, strExpiry, srtCVV); 
	this.lngBalance = lngBalance;
    }
    
    // Setter Method (ONLY FOR BALANCE) 
    // I would do name too, but when you change your name, it also changes your card number typically (NOT ALWAYS)
    public void setLimit(long lngLimit) {
	this.lngBalance = lngBalance;
    }
    
    // toString() method
    @Override 
    public String toString() { 
        return super.toString() + lngBalance + "\n";
    }
}
