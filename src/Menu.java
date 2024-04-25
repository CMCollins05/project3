import java.util.Scanner;
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Bank bank = new Bank();

    public void displayMenu(){
        while(true){
            String selection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.print("Please make a selection: \n" +
                             "1) Access account\n"+
                             "2) Open a New account\n"+
                             "3) Close All Accounts\n"+
                             "4) Exit\n");
            selection = scanner.nextLine();
            if(selection.equals("1")){
                accessAccount();
            }else if(selection.equals("2")){
                openAccount();
            }else if(selection.equals("3")){
                closeAccounts();
            }else if(selection.equals("4")){
                System.out.println("Thank you for using BSU Banking App, Goodbye. Exiting...");
                break;
            }else{
                System.out.println("Invalid entry");
            }
        }
    }

    private Customer createNewCustomer(){
        String firstName;
        String lastName;
        int pin;
        Customer customer;

        System.out.println("Please enter your first name: ");
        firstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        lastName = scanner.nextLine();
        System.out.println("Please enter a 4 digit PIN: ");
        pin = Integer.parseInt(scanner.nextLine());
        customer = new Customer(firstName, lastName, pin);
        bank.addCustomer(customer);
        return customer;
    }
    private void accessAccount(){
        int pin;
        Customer customer;
        System.out.print("Please enter your pin: \n");
        pin = Integer.parseInt(scanner.nextLine());
        customer = bank.getCustomer(pin);
        if(bank.getCustomer(pin) == null){
            System.out.print("PIN is invalid.");
        }else{
            System.out.println("*****Active Accounts*****");
            for(int i = 0; i < customer.getAccountArrayList().toArray().length; i++) {
                System.out.println(customer.getAccountArrayList().get(i));
            }
            System.out.println("Please enter the account number of the account you would like to access: ");
            int accountNumber = Integer.parseInt(scanner.nextLine());
            if(customer.getAccount(accountNumber) == null){
                System.out.println("Account number is invalid.");
            }else{
                while(true) {
                    System.out.print("Please make a selection:\n1) Make a deposit\n2) Make a withdrawal\n3) See account balance\n4) Close account\n5) Exit\n");
                    String selection = scanner.nextLine();
                    int money;
                    Account account = customer.getAccount(accountNumber);
                    if (selection.equals("1")) {
                        System.out.println("Enter the amount of deposit: ");
                        money = Integer.parseInt(scanner.nextLine());
                        account.deposit(money);
                    } else if (selection.equals("2")) {
                        System.out.println("Enter the amount of withdrawal: ");
                        money = Integer.parseInt(scanner.nextLine());
                        account.withdraw(money);
                    } else if (selection.equals("3")) {
                        System.out.printf("Account %d balance $%.2f\n", accountNumber, account.getBalance());
                    } else if (selection.equals("4")) {
                        customer.removeAccount(account);
                        System.out.printf("Account number %d closed\n", accountNumber);
                    } else {
                        break;
                    }
                }
            }
        }
    }
    private void openAccount(){
        System.out.print("Are you a new customer?\n1) Yes\n2) No\n");
        int selection = Integer.parseInt(scanner.nextLine());
        if(selection == 1){
            Customer customer = createNewCustomer();
            System.out.println("Please enter deposit amount:");
            int deposit = Integer.parseInt(scanner.nextLine());
            Account account = new Account(deposit);
            customer.addAccount(account);
            System.out.printf("New account opened: %d\n", account.getAccountNumber());
        }else if(selection == 2){
            System.out.println("Please enter PIN: ");
            int pin = Integer.parseInt(scanner.nextLine());
            Customer customer = bank.getCustomer(pin);
            if(bank.getCustomer(pin) == null){
                System.out.println("PIN is invalid.");
            }else {
                System.out.println("Please enter deposit amount:");
                int deposit = Integer.parseInt(scanner.nextLine());
                Account account = new Account(deposit);
                customer.addAccount(account);
                System.out.printf("New account opened: %d\n", account.getAccountNumber());
            }
        }
    }
    private void closeAccounts(){
        int pin;
        Customer customer;
        System.out.print("Please enter your pin: ");
        pin = Integer.parseInt(scanner.nextLine());
        customer = bank.getCustomer(pin);
        if(pin != customer.getPin()){
            displayMenu();
        }else{
            bank.removeCustomer(customer);
            System.out.println("You have been removed from the bank registry.");
        }
    }
}
