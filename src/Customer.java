import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private int pin;
    private ArrayList<Account> accountArrayList= new ArrayList<>();

    public Customer(String firstName, String lastName, int pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getPin(){
        return pin;
    }
    public ArrayList<Account> getAccountArrayList(){
        return accountArrayList;
    }
    public void addAccount(Account account){
        accountArrayList.add(account);
    }
    public void removeAccount(Account account){
        accountArrayList.remove(account);
    }
    public Account getAccount(int accountNumber){
        Account foundAccount = null;
        for(Account account : accountArrayList){
            if(account.getAccountNumber() == accountNumber){
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }

    @Override
    public String toString(){
        return String.format("Name: %s %s\nPIN: %d\n",firstName,lastName,pin);
    }
}
