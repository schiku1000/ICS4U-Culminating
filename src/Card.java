// Abstract class which will hold all the details of the card 
public abstract class Card {
    
    // Instance variables 
    private String strName;
    private String strBank; 
    private String strNumber; 
    private String strExpiry; 
    private String strCVV; 

    // Constructor 
    public Card(String strName, String strBank, String strNumber, String strExpiry, String strCVV) {
	this.strName = strName;
	this.strBank = strBank;
	this.strNumber = strNumber;
	this.strExpiry = strExpiry;
	this.strCVV = strCVV;
    }
    
    // Getter Methods 
    public String getName() {
	return strName;
    }

    public String getBank() {
	return strBank;
    }

    public String getNumber() {
	return strNumber;
    }

    public String getExpiry() {
	return strExpiry;
    }

    public String getCVV() {
	return strCVV;
    }
   
    // toString() method
    @Override 
    public String toString() { 
        return strName + "\n" + strBank + "\n" + strNumber + "\n" + strExpiry + "\n" + srtCVV + "\n";
    }
}
