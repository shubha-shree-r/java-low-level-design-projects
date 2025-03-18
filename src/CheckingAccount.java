public class CheckingAccount extends BankAccount {

    private int transactionCount;
    private int freeTransactionLimit = 3;
    private double overdraftLimit = 500;

    public CheckingAccount(int accountNumber,int transactionCount, int freeTransactionLimit){
        super(accountNumber,freeTransactionLimit);
        this.transactionCount = transactionCount;
        this.freeTransactionLimit = freeTransactionLimit;


    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactionCount++;
    }

    @Override
    public void withdrawal(double amount) throws OverdraftLimitExceededException {
        if (amount <= getAccountBalance()) {
            setAccountBalance(getAccountBalance() - amount);
        } else if (amount <= getAccountBalance() + overdraftLimit) {
            overdraftLimit -= (amount - getAccountBalance());
            setAccountBalance(0);
            System.out.println("Overdraft protection used. Remaining overdraft limit: " + overdraftLimit);
        } else {
            throw new OverdraftLimitExceededException("Withdrawal not allowed. Overdraft limit exceeded.");
        }
    }

    public void applyTransactionFees(double feePerTransaction) throws OverdraftLimitExceededException {
        int transactionsToCharge = transactionCount - freeTransactionLimit;
        if (transactionsToCharge > 0) {
            double fees = transactionsToCharge * feePerTransaction;
            super.withdrawal(fees);
        }
        transactionCount = 0;
    }


    public static void main(String[] args) {
        // ...
        CheckingAccount account = new CheckingAccount(12121323,10,1);

        try {
            account.withdrawal(800);
        } catch (OverdraftLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.withdrawal(1200);
        } catch (OverdraftLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }
}
 class OverdraftLimitExceededException extends Exception {
    public OverdraftLimitExceededException(String message) {
        super(message);
    }
}