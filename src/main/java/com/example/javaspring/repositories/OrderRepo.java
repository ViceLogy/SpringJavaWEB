package com.example.javaspring.repositories;

import com.example.javaspring.entity.Order;
import com.example.javaspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.security.UnresolvedPermission;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM orders WHERE owner_id = :userId", nativeQuery = true)
    List<Order> findAllByUserId(@Param("userId" )Long id);

    @Query(value = "UPDATE orders SET name = :name, description = :description, price = :price WHERE id = :id",
            nativeQuery = true)
    boolean update(@Param("name")String name, @Param("description") String description, @Param("price") int price,
                   @Param("id")Long id);
}
