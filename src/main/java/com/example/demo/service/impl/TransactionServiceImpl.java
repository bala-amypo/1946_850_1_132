// package com.example.demo.service.impl;

// import com.example.demo.model.BarterTransaction;
// import com.example.demo.model.SkillMatch;
// import com.example.demo.repository.BarterTransactionRepository;
// import com.example.demo.repository.SkillMatchRepository;
// import com.example.demo.service.TransactionService;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class TransactionServiceImpl implements TransactionService {

//     private final BarterTransactionRepository transactionRepository;
//     private final SkillMatchRepository matchRepository;

//     public TransactionServiceImpl(BarterTransactionRepository transactionRepository,
//                                   SkillMatchRepository matchRepository) {
//         this.transactionRepository = transactionRepository;
//         this.matchRepository = matchRepository;
//     }

//     @Override
//     public BarterTransaction createTransaction(Long matchId) {
//         SkillMatch match = matchRepository.findById(matchId).orElse(null);
//         if (match != null && "ACCEPTED".equals(match.getMatchStatus())) {
//             BarterTransaction transaction = new BarterTransaction();
//             transaction.setMatch(match);
//             transaction.setStatus("INITIATED");
//             return transactionRepository.save(transaction);
//         }
//         return null;
//     }

//     @Override
//     public BarterTransaction getTransaction(Long id) {
//         return transactionRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<BarterTransaction> getAllTransactions() {
//         return transactionRepository.findAll();
//     }

//     @Override
//     public BarterTransaction completeTransaction(Long transactionId,
//                                                  Integer offererRating,
//                                                  Integer requesterRating) {
//         BarterTransaction transaction = getTransaction(transactionId);
//         if (transaction != null) {
//             transaction.setStatus("COMPLETED");
//             transaction.setOffererRating(offererRating);
//             transaction.setRequesterRating(requesterRating);
//             transaction.setCompletedAt(LocalDateTime.now());
//             return transactionRepository.save(transaction);
//         }
//         return null;
//     }

//     @Override
//     public List<BarterTransaction> getTransactionsByStatus(String status) {
//         return transactionRepository.findByStatus(status);
//     }
// }
