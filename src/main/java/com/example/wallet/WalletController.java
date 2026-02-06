package com.example.wallet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping("/wallet")
    public ResponseEntity<Void> operate(@RequestBody WalletOperationRequest req) {
        service.operate(req.walletId(), req.operationType(), req.amount());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/wallets/{id}")
    public ResponseEntity<Long> balance(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getBalance(id));
    }
}

