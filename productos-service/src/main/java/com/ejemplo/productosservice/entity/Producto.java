package com.ejemplo.productosservice.entity;
 import jakarta.persistence.*;
 @Entity @Table(name="productos") public class Producto {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
     @jakarta.validation.constraints.NotBlank private String nombre;
    @jakarta.validation.constraints.NotBlank private String descripcion;
    @jakarta.validation.constraints.NotNull @jakarta.validation.constraints.Min(0) private Integer precio;
 public Long getId() {return id;} public void setId(Long id) {this.id=id;}
     public String getNombre() { return nombre; } public void setNombre(String value) { this.nombre=value; }
    public String getDescripcion() { return descripcion; } public void setDescripcion(String value) { this.descripcion=value; }
    public Integer getPrecio() { return precio; } public void setPrecio(Integer value) { this.precio=value; }
 }