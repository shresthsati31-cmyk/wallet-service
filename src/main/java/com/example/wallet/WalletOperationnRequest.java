package com.example.wallet;

import java.util.UUID;

public record WalletOperationRequest(
        UUID walletId,
        OperationType operationType,
        long amount
) {}
