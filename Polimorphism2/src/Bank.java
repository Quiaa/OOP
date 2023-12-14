public class Bank{
    public static void main(String[] args){
    Account cheAccount = new CheckingAccount(132333, 200, 500);    
    SavingAccount savAccount = new SavingAccount(236931, 120, 10);
    
    System.out.println("Account number " + cheAccount.getAccountNumber() +"'s balance: "+ cheAccount.getBalance()+ " $");
    cheAccount.Deposit(200);
    System.out.println("Account number " + cheAccount.getAccountNumber() +"'s balance: "+ cheAccount.getBalance()+ " $");
    
    cheAccount.Withdraw(900);
    System.out.println("Account number " + cheAccount.getAccountNumber() +"'s balance: "+ cheAccount.getBalance()+ " $");
    
    System.out.println("");
    System.out.println("Account number " + savAccount.getAccountNumber() +"'s balance: "+ savAccount.getBalance()+ " $");
    savAccount.setMonthlyInterest(4);
    System.out.println("Account number " + savAccount.getAccountNumber() +"'s balance: "+ savAccount.getBalance()+ " $");
    
    }
}
