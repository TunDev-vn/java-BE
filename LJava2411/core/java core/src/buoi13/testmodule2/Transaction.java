package buoi13.testmodule2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionId;
    private Account account;
    private String type;
    private double amount;
    private String timestamp;

    public Transaction(Account account, String type, double amount) {
        this.transactionId = generateTransactionId();
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private String generateTransactionId() {
        LocalDateTime now = LocalDateTime.now();
        return String.format("%d-%d-%d-%d-%d-%d",
            System.nanoTime(), now.getSecond(), now.getMinute(), now.getHour(), now.getDayOfMonth(), now.getYear());
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Type: " + type + ", Amount: " + amount + ", Account: " + account.getAccountNumber() + ", Timestamp: " + timestamp;
    }
}
