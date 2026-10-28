package com.ejemplo.productosservice.controller;
 import com.ejemplo.productosservice.entity.Producto; import com.ejemplo.productosservice.service.ProductoService;
 import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus;
 import jakarta.validation.Valid; import java.util.List;
 @RestController @RequestMapping("/api/productos") public class ProductoController {
 private final ProductoService service;
 public ProductoController(ProductoService service) {this.service=service;}
 @GetMapping public List<Producto> listar() {return service.listar();}
 @GetMapping("/{id}") public Producto obtener(@PathVariable Long id) {return service.obtener(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Producto crear(@Valid @RequestBody Producto item) {return service.crear(item);}
 @PutMapping("/{id}") public Producto actualizar(@PathVariable Long id,@Valid @RequestBody Producto item) {return service.actualizar(id,item);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id) {service.eliminar(id);}
 }