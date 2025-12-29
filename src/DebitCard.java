public class DebitCard extends Card {
    
    // Added Instance Variable
    private double dblBalance; 
    
    // Constructor
    public DebitCard(String strName, String strBank, String strNumber, String strExpiry, short srtCVV, double dblBalance) {
	super(strName, strBank, strNumber, strExpiry, srtCVV); 
	this.dblBalance = dblBalance;
    }
    
    // Getter method for balance 
    public double getBalance() {
	return dblBalance; 
    }
    
    // Setter Method (ONLY FOR BALANCE) 
    // I would do name too, but when you change your name, it also changes your card number typically (NOT ALWAYS)
    public void setLimit(double dblBalance) {
	this.dblBalance = dblBalance;
    }
    
    // toString() method
    @Override 
    public String toString() { 
        return super.toString() + dblBalance + "\n";
    }
}
