package com.ejemplo.productosservice.repository;
 import com.ejemplo.productosservice.entity.Producto; import org.springframework.data.jpa.repository.JpaRepository;
 public interface ProductoRepository extends JpaRepository<Producto, Long> {}