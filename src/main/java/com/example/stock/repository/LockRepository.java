package com.example.stock.repository;

import com.example.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 편의성을 위해 Stock 엔티티를 그대로 사용하지만 실제로는 그러면 안됩.
 * 별도의 JDBC를 사용하던가 해야함.
 * 여기서는 어디까지나 예제이기 떄문에 이렇게 하는 것
 */
public interface LockRepository extends JpaRepository<Stock, Long> {
    @Query(value = "select get_lock(:key, 3000)", nativeQuery = true)
    void getLock(String key);

    @Query(value = "select release_lock(:key)", nativeQuery = true)
    void releaseLock(String key);
}
