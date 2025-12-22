package com.example.demo.controller;

import com.example.demo.model.BarterTransaction;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<BarterTransaction> createTransaction(@RequestParam Long matchId) {
        return ResponseEntity.ok(transactionService.createTransaction(matchId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarterTransaction> getTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }

    @GetMapping
    public ResponseEntity<List<BarterTransaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<BarterTransaction> complete(@PathVariable Long id,
                                                      @RequestParam Integer offererRating,
                                                      @RequestParam Integer requesterRating) {
        return ResponseEntity.ok(
                transactionService.completeTransaction(id, offererRating, requesterRating)
        );
    }
}
