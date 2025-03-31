package com.egg.casaelectricidad.repositories;

import com.egg.casaelectricidad.entities.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, UUID> {
    @Query("SELECT u FROM WebUser u WHERE u.email = :email")
    public WebUser buscarPorEmail(@Param("email")String email);
}
