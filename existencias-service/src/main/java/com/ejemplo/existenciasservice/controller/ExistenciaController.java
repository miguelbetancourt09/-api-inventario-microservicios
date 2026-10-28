package com.ejemplo.existenciasservice.controller;
 import com.ejemplo.existenciasservice.entity.Existencia; import com.ejemplo.existenciasservice.service.ExistenciaService;
 import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus;
 import jakarta.validation.Valid; import java.util.List;
 @RestController @RequestMapping("/api/existencias") public class ExistenciaController {
 private final ExistenciaService service;
 public ExistenciaController(ExistenciaService service) {this.service=service;}
 @GetMapping public List<Existencia> listar() {return service.listar();}
 @GetMapping("/{id}") public Existencia obtener(@PathVariable Long id) {return service.obtener(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Existencia crear(@Valid @RequestBody Existencia item) {return service.crear(item);}
 @PutMapping("/{id}") public Existencia actualizar(@PathVariable Long id,@Valid @RequestBody Existencia item) {return service.actualizar(id,item);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id) {service.eliminar(id);}
 }