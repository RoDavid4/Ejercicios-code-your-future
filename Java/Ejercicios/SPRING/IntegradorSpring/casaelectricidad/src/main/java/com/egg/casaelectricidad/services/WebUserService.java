package com.egg.casaelectricidad.services;

import com.egg.casaelectricidad.entities.WebUser;
import com.egg.casaelectricidad.enumerates.Rol;
import com.egg.casaelectricidad.exceptions.MyException;
import com.egg.casaelectricidad.repositories.WebUserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WebUserService implements UserDetailsService {
    @Autowired
    private WebUserRepository usuarioRepository;

//Los métodos del servicio

    @Transactional
    public void registrar(String email, String nombre, String apellido, String password, String password2) throws MyException {
        validar(email, nombre, apellido, password, password2);

        WebUser usuario = new WebUser();
        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password)); // Encripta la contraseña antes de guardar
        usuario.setRol(Rol.USER);

        usuarioRepository.save(usuario);
    }

    @Transactional
    public void actualizar(UUID idUsuario, String email, String nombre, String apellido, String password, String password2) throws MyException {

        validar(email, nombre, apellido, password, password2);

        Optional<WebUser> respuesta = usuarioRepository.findById(idUsuario);

        if (respuesta.isEmpty()) {
            throw new MyException("El usuario especificado no existe.");
        }

        WebUser usuario = respuesta.get();
        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));

        usuarioRepository.save(usuario);
    }

    private void validar(String email, String nombre, String apellido, String password, String password2) throws MyException {
        validarNoNuloNiVacio(email, "email");
        validarNoNuloNiVacio(nombre, "nombre");
        validarNoNuloNiVacio(apellido, "apellido");

        // Validar contraseñas
        if (password == null || password.isBlank() || password.length() <= 5) {
            throw new MyException("La contraseña no puede estar vacía, y debe tener más de 5 caracteres.");
        }

        if (!password.equals(password2)) {
            throw new MyException("Las contraseñas ingresadas deben ser iguales.");
        }

        // Validar existencia del email
        WebUser respuesta = usuarioRepository.buscarPorEmail(email);
        if (respuesta != null) {
            throw new MyException("Ya existe un usuario con ese correo electrónico.");
        }
    }

    private void validarNoNuloNiVacio(String campo, String nombreCampo) throws MyException {
        if (campo == null || campo.isBlank()) {
            throw new MyException("El " + nombreCampo + " no puede ser nulo o estar vacío.");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        WebUser usuario = usuarioRepository.buscarPorEmail(email);

        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            permisos.add(p);
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else {
            return null;
        }

    }

    @Transactional(readOnly = true)
    public List<WebUser> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public WebUser getOne(UUID id) throws MyException {
        validarId(id);
        return usuarioRepository.getReferenceById (id);
    }

    private void validarId(UUID id) throws MyException {
        if (id == null) {
            throw new MyException("El ID no puede ser nulo.");
        }
    }

    @Transactional
    public void cambiarRol(UUID id) {
        Optional<WebUser> respuesta = usuarioRepository.findById(id);

        if (respuesta.isPresent()) {
            WebUser usuario = respuesta.get();
            if (usuario.getRol().equals(Rol.USER)) {
                usuario.setRol(Rol.ADMIN);
            } else if (usuario.getRol().equals(Rol.ADMIN)) {
                usuario.setRol(Rol.USER);
            }
        }
        // Al usar @Transactional no es necesario llamar al repositorio con el metodo .save()
    }

}
