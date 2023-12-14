public class Account{
    private int accountNumber;
    private double balance;

    protected void setBalance(double balance){
        this.balance = balance;
    }
    protected double getBalance(){
        return balance;
    }
    protected int getAccountNumber(){
        return accountNumber;
    }
    public void Deposit(double cash){
        balance += cash; // deposits money
    }
    public void Withdraw(double cash){
        if(cash > balance){
            System.out.println("You don't have enough money in the account");
            return;
        }
        balance -= cash; //withdraws the money
    }
    public Account(int accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
