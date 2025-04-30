package com.example.microservice.inventory.repository;

import com.example.microservice.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory, Long>
{
    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Inventory i " +
            "WHERE i.skuCode = :skuCode AND i.quantity >= :quantity")
    boolean existsBySkuCodeAndQuantityQueryExplicitCase(
            @Param("skuCode") String skuCode,
            @Param("quantity") Integer quantity
    );
}
