package ua.opnu.inheritance.account;

public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        this.minBalance = this.balance;
        this.maxBalance = this.balance;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateMinMax();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMax();
    }

    private void updateMinMax() {
        if (balance < minBalance) {
            minBalance = balance;
        }
        if (balance > maxBalance) {
            maxBalance = balance;
        }
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
