package buoi13.testmodule2;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Employee employeeInCharge;

    public Account(String accountNumber, String accountHolder, double balance, Employee employeeInCharge) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.employeeInCharge = employeeInCharge;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public Employee getEmployeeInCharge() {
        return employeeInCharge;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance;
    }
}
