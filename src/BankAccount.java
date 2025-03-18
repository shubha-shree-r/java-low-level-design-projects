import java.util.Scanner;


public  class BankAccount{

     int accountNumber;
     double accountBalance;



    public BankAccount(int accountNumber,double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = initialBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }


    public static void main(String[] args) throws OverdraftLimitExceededException {
        BankAccount bankAccount = new BankAccount(1289347568,3000);
        Scanner scanner = new Scanner(System.in);
        bankAccount.setAccountNumber(1289347568);
        bankAccount.setAccountBalance(100);

        double currentBalance = bankAccount.getAccountBalance();
        SavingAccount bank = new SavingAccount(bankAccount.accountNumber, bankAccount.accountBalance,9);
//        bank.earnInterest();
//        bankAccount.withdrawal(12324);

        CheckingAccount checkingAccount = new CheckingAccount(bankAccount.accountNumber, 1,2);
         checkingAccount.applyTransactionFees(2);
//
//        System.out.println("Initial account balance: " + currentBalance);
//
//        System.out.println("Enter the amount you need to deposit: ");
//        double input = scanner.nextInt();
//
//        bankAccount.deposit(input);
//
//        System.out.println("Account deposited: " + input);
//
//        System.out.println("Total amount: " + bankAccount.getAccountBalance());
//        System.out.println();
//        System.out.println("Enter the amount you need to withdrawal: ");
//        int input2 = scanner.nextInt();
//
//        bankAccount.withdrawal(input2);
//        System.out.println();
//        System.out.println("Amount withdraw : " + input2);
//        System.out.println();
        System.out.println("Account Balance after withdrawal: " + bankAccount.getAccountBalance());

        bankAccount.displayAccountDetails();
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdrawal(double amount) throws OverdraftLimitExceededException {
        if (accountBalance < amount) {
            System.err.println("Insufficient balance. Unable to withdraw " + amount + ".");
            System.exit(0);
        } else if (accountBalance > amount) {
            accountBalance -= amount;

        }
    }

    public String  displayAccountDetails(){
        System.out.println("Account Number : " +getAccountNumber());
        System.out.println("Account Balance : " +getAccountBalance());
        return "";
    }


}

