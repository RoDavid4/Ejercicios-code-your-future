package com.egg.casaelectricidad.services;

import com.egg.casaelectricidad.entities.Fabrica;
import com.egg.casaelectricidad.exceptions.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.casaelectricidad.repositories.FabricaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FabricaService {
    @Autowired
    private FabricaRepository fabricaRepository;

    @Transactional
    public Fabrica crearFabrica (String nombreFabrica) throws MyException {

        validar(nombreFabrica);

        Fabrica fabrica = new Fabrica();
        fabrica.setNombreFabrica(nombreFabrica);

        return fabricaRepository.save(fabrica); // Se persiste la fabrica en la DB
    }

    @Transactional
    public void actualizar(String nombreFabrica, UUID idFabrica) throws MyException {

        validar(nombreFabrica);

        Optional<Fabrica> respuesta = fabricaRepository.findById(idFabrica); // Buscar el articulo por id>

        if (respuesta.isEmpty()) {
            throw new MyException("La fabrica especificada no existe.");
        }

        Fabrica fabrica = respuesta.get();
        fabrica.setNombreFabrica(nombreFabrica);

    }
    @Transactional(readOnly = true)
    public List<Fabrica> listarFabricas() {
        return fabricaRepository.findAll();
    }


    @Transactional
    public void eliminarFabrica(UUID idFabrica) throws MyException {
        Fabrica fabrica = validarPorId(idFabrica); // Reutilizamos el método privado
        System.out.println("la fabrica fue validada correctamente, se procede a eliminar");
        fabricaRepository.delete(fabrica);
    }

    @Transactional(readOnly = true)
    public Fabrica getOne(UUID id) throws MyException {
        validarPorId(id);
        return fabricaRepository.getReferenceById (id);
    }

    private void validar(String nombreFabrica) throws MyException {
        if (nombreFabrica == null || nombreFabrica.trim().isEmpty()) {
            throw new MyException("El nombre de la fabrica no puede estar vacío.");
        }
    }

    private Fabrica validarPorId(UUID idFabrica) throws MyException {
        System.out.println("validando id de fabrica");
        return fabricaRepository.findById(idFabrica)
                .orElseThrow(() -> new MyException("La fábrica especificada no existe."));
    }



}
