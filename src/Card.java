// Abstract class which will hold all the details of the card 
public abstract class Card {
    
    // Instance variables 
    private String strName;
    private String strBank; 
    private String lngNumber; 
    private String strExpiry; 
    private short srtCVV; 

    // Constructor 
    public Card(String strName, String strBank, String strNumber, String strExpiry, short srtCVV) {
	this.strName = strName;
	this.strBank = strBank;
	this.lngNumber = lngNumber;
	this.strExpiry = strExpiry;
	this.srtCVV = srtCVV;
    }
    
    // Getter Methods 
    public String getName() {
	return strName;
    }

    public String getBank() {
	return strBank;
    }

    public long getNumber() {
	return lngNumber;
    }

    public String getExpiry() {
	return strExpiry;
    }

    public short getCVV() {
	return srtCVV;
    }
   
    // toString() method
    @Override 
    public String toString() { 
        return strName + "\n" + strBank + "\n" + lngNumber + "\n" + strExpiry + "\n" + srtCVV + "\n";
    }
}
