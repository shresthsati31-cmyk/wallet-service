package com.example.wallet;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Long balance;

    protected Wallet() {}

    public Wallet(UUID id, Long balance) {
        this.id = id;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public Long getBalance() {
        return balance;
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void withdraw(long amount) {
        if (balance < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        balance -= amount;
    }
}
