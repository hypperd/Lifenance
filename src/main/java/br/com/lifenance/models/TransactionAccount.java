package br.com.lifenance.models;

import br.com.lifenance.models.annotations.ColumnName;
import br.com.lifenance.models.annotations.PrimaryKey;

public class TransactionAccount {

    @PrimaryKey("transaction_bank_account_id")
    private long id;
    @ColumnName("bank_account_id")
    private Account account;
    @ColumnName("transaction_id")
    private Transaction transaction;

    public TransactionAccount(long id, Transaction transaction, Account account) {
        this.id = id;
        this.transaction = transaction;
        this.account = account;
    }

    public TransactionAccount() {
    }

    // Constructor for genericDao
    public TransactionAccount(String arg) {
        String[] split = arg.split(";");
        this.id = Long.parseLong(split[0]);
        this.account = ModelFactory.getModel(Account.class, "bank_accounts", Long.parseLong(split[1]));
        this.transaction = ModelFactory.getModel(Transaction.class, "transactions", Long.parseLong(split[2]));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
