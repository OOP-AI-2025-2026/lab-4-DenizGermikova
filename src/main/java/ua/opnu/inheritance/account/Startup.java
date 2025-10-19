package ua.opnu.inheritance.account;

public class Startup {
    private final int initialBalance;

    public Startup(int initialBalance) {
        this.initialBalance = initialBalance;
    }

    public int getInitialBalance() {
        return initialBalance;
    }
}
