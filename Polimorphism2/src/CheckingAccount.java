public class CheckingAccount extends Account{
    private double limit;
    public CheckingAccount(int accountNumber, double balance, double limit){
        super(accountNumber, balance);
        this.limit = limit;
    }
    @Override
    public void Withdraw(double cash){
        if(getBalance() - cash < (-limit)){
            System.out.println("You don't have enough money and limit in the account. Your limit is: " + (-limit));
            return;
        }
        setBalance(getBalance() - cash);
    }
}
