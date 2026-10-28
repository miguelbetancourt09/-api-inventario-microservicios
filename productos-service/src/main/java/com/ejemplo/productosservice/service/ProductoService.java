package com.ejemplo.productosservice.service;
 import com.ejemplo.productosservice.entity.Producto; import com.ejemplo.productosservice.repository.ProductoRepository;
 import org.springframework.stereotype.Service; import org.springframework.http.HttpStatus;
 import org.springframework.web.server.ResponseStatusException; import java.util.List;
 @Service public class ProductoService {
 private final ProductoRepository repo;

 public ProductoService(ProductoRepository repo) {this.repo=repo;}
 public List<Producto> listar() {return repo.findAll();}
 public Producto obtener(Long id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 public Producto crear(Producto item) {item.setId(null); validarReferencia(item); return repo.save(item);}
 public Producto actualizar(Long id, Producto item) {obtener(id); validarReferencia(item); item.setId(id); return repo.save(item);}
 public void eliminar(Long id) {obtener(id); repo.deleteById(id);}
 private void validarReferencia(Producto item) { }
 }