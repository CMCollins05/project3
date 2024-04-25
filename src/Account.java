public class Account {
    private double balance;
    private int accountNumber;
    static int numOfAccounts = 1000;

    public Account(int deposit){
        this.balance = deposit;
        this.accountNumber = numOfAccounts;
        numOfAccounts++;
    }

    public void deposit(double deposit){
        balance += deposit;
        System.out.printf("You have deposited $%.2f\nYou now have a balance of $%.2f\n", deposit, balance);
    }

    public void withdraw(double withdrawal){
        if(withdrawal <= balance){
            balance -= withdrawal;
            System.out.printf("You have withdrawn $%.2f\nYou now have a balance of $%.2f\n", withdrawal, balance);
        }else{
            System.out.println("You have insufficient funds.");
        }
    }
    public double getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public int getNumOfAccounts(){
        return numOfAccounts;
    }

    @Override
    public String toString(){
        return String.format("Account number: %d\n Balance: $%.2f\n", accountNumber, balance);
    }
}
