package com.example.adapter.respository;

import com.example.adapter.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
@Component
public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
    @Query(value = "SELECT * FROM PRICES p WHERE p.product_id = :productId AND p.brand_id = :brandId AND p.start_date <= :date AND p.end_date >= :date ORDER BY p.priority DESC LIMIT 1", nativeQuery = true)



    List<PriceEntity> findPriceByProductIdAndBrandIdAndDate(
            @Param("date") LocalDateTime date,
            @Param("productId") int productId,
            @Param("brandId") int brandId
    );
}
