package com.egg.libreriaapi.repositories;

import com.egg.libreriaapi.entities.*;
import com.egg.libreriaapi.modelos.LibroListarDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

  @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
  public Libro buscarPorTitulo(@Param("titulo") String titulo);

  @Query(
      "SELECT new com.egg.libreriaapi.modelos.LibroListarDTO(l.titulo, l.ejemplares) "
          + "FROM Libro l WHERE l.autor = :autor")
  public List<LibroListarDTO> buscarPorAutor(@Param("autor") Autor autor);

  @Query(
      "SELECT new com.egg.libreriaapi.modelos.LibroListarDTO(l.titulo, l.ejemplares) "
          + "FROM Libro l WHERE l.editorial = :editorial")
  public List<LibroListarDTO> buscarPorEditorial(@Param("editorial") Editorial editorial);

  @Query(
      "SELECT new com.egg.libreriaapi.modelos.LibroListarDTO(l.titulo, l.ejemplares) "
          + "FROM Libro l WHERE l.autor = :autor AND l.editorial = :editorial")
  public List<LibroListarDTO> buscarPorAutorYEditorial(
      @Param("autor") Autor autor, @Param("editorial") Editorial editorial);

  // Directamente, recupero la info que se precisa en la BBDD creando una isntancia de
  // LibroListarActivosDTO
  @Query(
      "SELECT new com.egg.libreriaapi.modelos.LibroListarDTO(l.titulo, l.ejemplares) "
          + "FROM Libro l WHERE l.libroActivo = :activo")
  List<LibroListarDTO> encontrarActivos(@Param("activo") Boolean activo);
}
