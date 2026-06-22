package com.barrehtopia.api.repository;

import com.barrehtopia.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}