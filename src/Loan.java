import java.text.DecimalFormat;

public class Loan {
    
    // instance variables
    private double dblPrincipal; // original loan amount
    private double dblInterestRate; // annual interest rate (as a percentage)
    private int intTermMonths; // total loan term in months
    private int intRemainingMonths; // remaining months in the loan term
    private double dblPayment; // calculated monthly payment amount
    private double dblRemainingBalance; // current outstanding loan balance
    
    // format for values 
    private static final DecimalFormat format = new DecimalFormat("###.##");
    
    // constructor
    public Loan(double dblPrincipal, double dblInterestRate, int intTermMonths) {
        this.dblPrincipal = dblPrincipal;
        this.dblInterestRate = dblInterestRate;
        this.intTermMonths = intTermMonths;
        this.intRemainingMonths = intTermMonths;
        this.dblRemainingBalance = dblPrincipal;
        calculateMonthlyPayment();  // calculate the monthly payment upon loan creation
    }
    
    // calculate monthly payment using the standard loan formula
    public void calculateMonthlyPayment() {
        if (dblInterestRate == 0) {
            // no interest case: simple division of principal by term
            dblPayment = dblPrincipal / intTermMonths;
        } else {
            // convert annual interest rate to monthly decimal rate
            double dblMonthlyRate = dblInterestRate / 12 / 100;
            // standard loan payment formula:
            // P = (r * PV) / (1 - (1 + r)^(-n))
            // where P = payment, r = monthly rate, PV = principal, n = term in months
            dblPayment = (dblPrincipal * dblMonthlyRate) / (1 - Math.pow(1 + dblMonthlyRate, -intTermMonths));
        }
    }
    
    // apply a monthly payment to the loan using funds from a Card account
    // returns true if payment was successful, false otherwise
    public boolean applyMonthlyPayment(Card account) {
        if (account instanceof DebitCard) {
            DebitCard debitCard = (DebitCard) account;
            double dblCurrentBalance = Double.parseDouble(debitCard.getBalance());
            
            // check if there are sufficient funds in the debit account
            if (dblCurrentBalance >= dblPayment) {
                // deduct payment from debit card balance
                dblCurrentBalance -= dblPayment;
                debitCard.setLimit(format.format(dblCurrentBalance));
                
                // calculate interest and principal portions of this payment
                double dblMonthlyRate = dblInterestRate / 12 / 100;
                double dblInterestPortion = dblRemainingBalance * dblMonthlyRate;
                double dblPrincipalPortion = dblPayment - dblInterestPortion;
                
                // reduce the remaining loan balance by the principal portion
                dblRemainingBalance -= dblPrincipalPortion;
                
                // decrease the remaining loan term
                if (intRemainingMonths > 0) {
                    intRemainingMonths--;
                }
                
                return true;  // Payment successful
            }
        } else if (account instanceof CreditCard) {
            CreditCard creditCard = (CreditCard) account;
            double dblCurrentLimit = Double.parseDouble(creditCard.getLimit());
            
            // check if there is sufficient available credit
            if (dblCurrentLimit >= dblPayment) {
                // deduct payment from available credit limit
                dblCurrentLimit -= dblPayment;
                creditCard.setLimit(format.format(dblCurrentLimit));
                
                // calculate interest and principal portions of this payment
                double dblMonthlyRate = dblInterestRate / 12 / 100;
                double dblInterestPortion = dblRemainingBalance * dblMonthlyRate;
                double dblPrincipalPortion = dblPayment - dblInterestPortion;
                
                // reduce the remaining loan balance by the principal portion
                dblRemainingBalance -= dblPrincipalPortion;
                
                // decrease the remaining loan term
                if (intRemainingMonths > 0) {
                    intRemainingMonths--;
                }
                
                return true;  // payment successful
            }
        }
        return false;  // payment failed due to insufficient funds/credit
    }  
   
    // check if an account has sufficient funds/credit to make the monthly payment
    // returns true if the account can afford the payment, false otherwise
    public static boolean canAffordPayment(Card account, double dblPayment) {
        if (account instanceof DebitCard) {
            double dblBalance = Double.parseDouble(((DebitCard) account).getBalance());
            return dblBalance >= dblPayment;
        } else if (account instanceof CreditCard) {
            double dblLimit = Double.parseDouble(((CreditCard) account).getLimit());
            return dblLimit >= dblPayment;
        }
        return false;  // unknown account type
    }
    
    // recursive function to calculate accumulated interest over a specified number of months
    public double calculateAccumulatedInterest(int intMonths) {
        // base case: no months remaining, no interest
        if (intMonths <= 0) {
            return 0;
        }
        
        // calculate interest for the current month
        double dblMonthlyRate = dblInterestRate / 12 / 100;
        double dblInterestThisMonth = dblRemainingBalance * dblMonthlyRate;
        
        // recursive case: interest this month + interest for remaining months
        return dblInterestThisMonth + calculateAccumulatedInterest(intMonths - 1);   
    }
    
    // getter methods
    
    // returns the original loan principal amount
    public double getPrincipal() {
        return dblPrincipal;
    }
    
    // returns the annual interest rate (as a percentage)
    public double getInterestRate() {
        return dblInterestRate;
    }   
 
    public int getTermMonths() {
        return intRemainingMonths;
    }
    
    // returns the calculated monthly payment amount
    public double getMonthlyPayment() {
        return dblPayment;
    }
    
    // returns the current remaining loan balance
    public double getRemainingBalance() {
        return dblRemainingBalance;
    }
    
    // calculates and returns the total interest paid over the entire loan term
    public double getTotalInterest() {
        return (dblPayment * intTermMonths) - dblPrincipal;
    }
}