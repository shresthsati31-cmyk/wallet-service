package com.example.wallet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@Transactional
public class WalletService {

    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }

    public void operate(UUID walletId, OperationType type, long amount) {
        Wallet wallet = repository.findByIdForUpdate(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if (type == OperationType.DEPOSIT) {
            wallet.deposit(amount);
        } else {
            wallet.withdraw(amount);
        }
    }

    @Transactional(readOnly = true)
    public long getBalance(UUID walletId) {
        return repository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"))
                .getBalance();
    }
}
