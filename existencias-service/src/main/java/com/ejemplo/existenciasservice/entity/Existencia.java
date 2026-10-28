package com.ejemplo.existenciasservice.entity;
 import jakarta.persistence.*;
 @Entity @Table(name="existencias") public class Existencia {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
     @jakarta.validation.constraints.NotNull private Long productoId;
    @jakarta.validation.constraints.NotNull @jakarta.validation.constraints.Min(0) private Integer cantidad;
    @jakarta.validation.constraints.NotBlank private String ubicacion;
 public Long getId() {return id;} public void setId(Long id) {this.id=id;}
     public Long getProductoId() { return productoId; } public void setProductoId(Long value) { this.productoId=value; }
    public Integer getCantidad() { return cantidad; } public void setCantidad(Integer value) { this.cantidad=value; }
    public String getUbicacion() { return ubicacion; } public void setUbicacion(String value) { this.ubicacion=value; }
 }