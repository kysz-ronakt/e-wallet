package com.wallet.repository;

import com.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByRonak(String ronak);

    List<Wallet> findByUserId(Long userId);

    boolean existsByRonakIgnoreCase(String ronak);

    boolean existsByUserIdAndNameIgnoreCase(Long userId, String name);

    Wallet getReferenceByRonak(String ronak);
}
