package ru.vlsu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
