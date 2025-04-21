package com.egg.casaelectricidad.services;

import com.egg.casaelectricidad.entities.Articulo;
import com.egg.casaelectricidad.entities.Fabrica;
import com.egg.casaelectricidad.entities.Imagen;
import com.egg.casaelectricidad.exceptions.MyException;
import com.egg.casaelectricidad.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ArticuloService {

    private AtomicInteger contador;
    private static final int STRINGS_MAX_LONGITUD = 255;

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ImagenService imagenService;

    // Cuando se inicializa la app se va a generar un contador con el valor maximo de nro_articulo
    public ArticuloService(ArticuloRepository articuloRepository) {
        // Inicializamos el contador con el valor máximo de nroArticulo en la base de datos
        int maxNroArticulo = articuloRepository.findMaxNroArticulo().orElse(0); // esta consulta devuelve un Optional<Integer>
        this.contador = new AtomicInteger(maxNroArticulo + 1);
    }

    @Transactional
    public Articulo crearArticulo(MultipartFile archivo, String nombreArticulo, String descripcionArticulo, Fabrica fabrica) throws MyException{
        validarEntradas(nombreArticulo, descripcionArticulo, fabrica);

        Articulo articulo = new Articulo();
        articulo.setNroArticulo(contador.getAndIncrement()); // Asignar un nuevo número único
        articulo.setNombreArticulo(nombreArticulo);
        articulo.setDescripcionArticulo(descripcionArticulo);
        articulo.setFabrica(fabrica);
        Imagen imagen = imagenService.guardar(archivo);
        articulo.setImagen(imagen);

        return articuloRepository.save(articulo); // Persistir en la base de datos
    }

    @Transactional
    public void actualizar(UUID idArticulo, MultipartFile archivo, String nombreArticulo, String descripcionArticulo, Fabrica fabrica) throws MyException{
        validarEntradas(nombreArticulo, descripcionArticulo, fabrica);

        Optional<Articulo> respuesta = articuloRepository.findById(idArticulo); // Buscar el articulo por id>

        if (respuesta.isEmpty()) {
            throw new MyException("El articulo especificado no existe.");
        }

        Articulo articulo = respuesta.get();
        articulo.setNombreArticulo(nombreArticulo);
        articulo.setDescripcionArticulo(descripcionArticulo);
        articulo.setFabrica(fabrica);

        UUID idImagen =  null;

        if (articulo.getImagen() != null) {
            idImagen = articulo.getImagen().getId();
        }

        Imagen imagen = imagenService.actualizar(archivo, idImagen);
        articulo.setImagen(imagen);
    }

    @Transactional(readOnly = true)
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Articulo getOne(UUID id) throws MyException {
        validarId(id);
        return articuloRepository.getReferenceById (id);
    }

    @Transactional
    public void eliminarArticulo(UUID idArticulo) throws MyException {
        validarId(idArticulo);
        try {
            articuloRepository.deleteById(idArticulo);
        } catch (Exception e) {
            throw new MyException("No se pudo eliminar el articulo.");
        }
    }

    // Método privado para validar entradas
    private void validarEntradas(String nombreArticulo, String descripcionArticulo, Fabrica fabrica) throws MyException {
        if (nombreArticulo == null || nombreArticulo.trim().isEmpty()) {
            throw new MyException("El nombre del artículo no puede estar vacío.");
        }
        if (descripcionArticulo == null || descripcionArticulo.trim().isEmpty()) {
            throw new MyException("La descripción del artículo no puede estar vacía.");
        }
        if (nombreArticulo.length() > STRINGS_MAX_LONGITUD) {
            throw new MyException("El nombre del artículo no puede exceder " + STRINGS_MAX_LONGITUD + " caracteres.");
        }
        if (descripcionArticulo.length() > STRINGS_MAX_LONGITUD) {
            throw new MyException("La descripción del artículo no puede exceder " + STRINGS_MAX_LONGITUD + " caracteres.");
        }
        if (fabrica == null) {
            throw new MyException("La fábrica asociada no puede ser nula.");
        }
        Optional<Articulo> existente = articuloRepository.findByNroArticulo(contador.get());
        if (existente.isPresent()) {
            throw new MyException("Ya existe un artículo con el número: " + contador);
        } // esto con el uso correcto de AtomicInteger no deberia de pasar nunca.-
    }

    private void validarId(UUID id) throws MyException {
        if (id == null) {
            throw new MyException("El ID no puede ser nulo.");
        }
    }

}

