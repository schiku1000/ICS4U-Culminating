public class Loan {
    
    // instance variables
    private double dblPrincipal;
    private double dblInterestRate;
    private int intTermMonths;
    private double dblPayment;
    private double dblRemainingBalance;
    
    // constructor
    public Loan(double dblPrincipal, double dblInterestRate, int intTermMonths) {
        this.dblPrincipal = dblPrincipal;
        this.dblInterestRate = dblInterestRate;
        this.intTermMonths = intTermMonths;
        this.dblRemainingBalance = dblPrincipal;
        calculateMonthlyPayment();
    }
    
    // calculate monthly payment using loan formula
    public void calculateMonthlyPayment() {
        if (dblInterestRate == 0) {
            // no interest case
            dblPayment = dblPrincipal / intTermMonths;
        } else {
            double dblMonthlyRate = dblInterestRate / 12 / 100;
            dblPayment = (dblPrincipal * dblMonthlyRate) / (1 - Math.pow(1 + dblMonthlyRate, -intTermMonths));
        }
    }
    
    // apply monthly payment to an account (not used)
    public boolean applyMonthlyPayment(Card account) {
        if (account instanceof DebitCard) {
            DebitCard debitCard = (DebitCard) account;
            double dblCurrentBalance = Double.parseDouble(debitCard.getBalance());
            
            if (dblCurrentBalance >= dblPayment) {
                dblCurrentBalance -= dblPayment;
                debitCard.setLimit(String.format("%.2f", dblCurrentBalance));
                
                // Update remaining loan balance
                double dblMonthlyRate = dblInterestRate / 12 / 100;
                double dblInterestPortion = dblRemainingBalance * dblMonthlyRate;
                double dblPrincipalPortion = dblPayment - dblInterestPortion;
                dblRemainingBalance -= dblPrincipalPortion;
                
                return true;
            }
        } else if (account instanceof CreditCard) {
            CreditCard creditCard = (CreditCard) account;
            double currentLimit = Double.parseDouble(creditCard.getLimit());
            
            if (currentLimit >= dblPayment) {
                currentLimit -= dblPayment;
                creditCard.setLimit(String.format("%.2f", currentLimit));
                
                // update remaining loan balance
                double dblMonthlyRate = dblInterestRate / 12 / 100;
                double dblInterestPortion = dblRemainingBalance * dblMonthlyRate;
                double dblPrincipalPortion = dblPayment - dblInterestPortion;
                dblRemainingBalance -= dblPrincipalPortion;
                
                return true;
            }
        }
        return false;
    }  
   
    // check if account can afford the monthly payment (not used)
    public static boolean canAffordPayment(Card account, double dblPayment) {
        if (account instanceof DebitCard) {
            double dblBalance = Double.parseDouble(((DebitCard) account).getBalance());
            return dblBalance >= dblPayment;
        } else if (account instanceof CreditCard) {
            double dblLimit = Double.parseDouble(((CreditCard) account).getLimit());
            return dblLimit >= dblPayment;
        }
        return false;
    }
    
    // Getters
    public double getPrincipal() {
        return dblPrincipal;
    }
    
    public double getInterestRate() {
        return dblInterestRate;
    }
    
    public int getTermMonths() {
        return intTermMonths;
    }
    
    public double getMonthlyPayment() {
        return dblPayment;
    }
    
    public double getRemainingBalance() {
        return dblRemainingBalance;
    }
  
    public double getTotalInterest() {
        return (dblPayment * intTermMonths) - dblPrincipal;
    }
}
