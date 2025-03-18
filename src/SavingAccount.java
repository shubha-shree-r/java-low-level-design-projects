public class SavingAccount extends BankAccount{
    private int intrestRate;

    public SavingAccount(int accountNumber, double accountBalance, int intrestRate) {
        super(accountNumber,accountBalance);
        this.intrestRate = intrestRate;

    }

    @Override
    public String displayAccountDetails() {
        return super.displayAccountDetails() + ", IntrestRate:"  + intrestRate + "%";

    }


    public void earnInterest(){
      double  intrest = accountBalance * intrestRate;

        accountBalance += intrest;
        System.out.printf(intrest + " " + accountBalance);
    }



}
