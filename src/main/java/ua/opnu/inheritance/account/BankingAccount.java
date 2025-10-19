package ua.opnu.inheritance.account;

public class BankingAccount {
    protected int balance; // баланс в копейках

    public BankingAccount(Startup s) {
        this.balance = s.getInitialBalance();
    }

    public int getBalance() {
        return balance;
    }

    public void debit(Debit d) {  // добавить сумму
        balance += d.getAmount();
    }

    public void credit(Credit c) { // уменьшить сумму
        balance += c.getAmount(); // т.к. Credit хранит отрицательное значение
    }
}