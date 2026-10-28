package com.ejemplo.existenciasservice.repository;
 import com.ejemplo.existenciasservice.entity.Existencia; import org.springframework.data.jpa.repository.JpaRepository;
 public interface ExistenciaRepository extends JpaRepository<Existencia, Long> {}