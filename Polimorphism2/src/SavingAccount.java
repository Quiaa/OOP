public class SavingAccount extends Account{
    private double interestRate;
    public SavingAccount(int accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void setMonthlyInterest(int monthCount){
        for(int i = 1; i <= monthCount; i++){
            setBalance(getBalance() + (getBalance()/100)*(interestRate/12));
        }
    }
}
