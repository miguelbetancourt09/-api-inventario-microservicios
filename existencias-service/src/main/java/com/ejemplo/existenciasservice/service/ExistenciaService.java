package com.ejemplo.existenciasservice.service;
 import com.ejemplo.existenciasservice.entity.Existencia; import com.ejemplo.existenciasservice.repository.ExistenciaRepository;
 import org.springframework.stereotype.Service; import org.springframework.http.HttpStatus;
 import org.springframework.web.server.ResponseStatusException; import java.util.List;
 @Service public class ExistenciaService {
 private final ExistenciaRepository repo;
 private final org.springframework.web.client.RestClient restClient = org.springframework.web.client.RestClient.create();
 @org.springframework.beans.factory.annotation.Value("${REFERENCE_URL:}") private String targetUrl;
 public ExistenciaService(ExistenciaRepository repo) {this.repo=repo;}
 public List<Existencia> listar() {return repo.findAll();}
 public Existencia obtener(Long id) {return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado"));}
 public Existencia crear(Existencia item) {item.setId(null); validarReferencia(item); return repo.save(item);}
 public Existencia actualizar(Long id, Existencia item) {obtener(id); validarReferencia(item); item.setId(id); return repo.save(item);}
 public void eliminar(Long id) {obtener(id); repo.deleteById(id);}
 private void validarReferencia(Existencia item) { if (item.getProductoId() == null) throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.BAD_REQUEST, "Referencia requerida: productoId");
    try { restClient.get().uri(targetUrl + "/" + item.getProductoId()).retrieve().toBodilessEntity(); }
    catch (org.springframework.web.client.HttpClientErrorException.NotFound ex) { throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.BAD_REQUEST, "Referencia no existe: productoId"); }
    catch (org.springframework.web.client.RestClientException ex) { throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE, "Servicio de referencia no disponible"); } }
 }