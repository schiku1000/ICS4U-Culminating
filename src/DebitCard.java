public class DebitCard extends Card {
    
    // Added Instance Variable
    private String strBalance; 
    
    // Constructor
    public DebitCard(String strName, String strBank, String strNumber, String strExpiry, short srtCVV, String strBalance) {
	super(strName, strBank, strNumber, strExpiry, srtCVV); 
	this.strBalance = strBalance;
    }
    
    // Getter method for balance 
    public String getBalance() {
	return strBalance; 
    }
    
    // Setter Method (ONLY FOR BALANCE) 
    // I would do name too, but when you change your name, it also changes your card number typically (NOT ALWAYS)
    public void setLimit(String strBalance) {
	this.strBalance = strBalance;
    }
    
    // toString() method
    @Override 
    public String toString() { 
        return super.toString() + strBalance + "\n";
    }
}
