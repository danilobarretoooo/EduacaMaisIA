package dev.danilobarreto.portalaluno.Dao;

import dev.danilobarreto.portalaluno.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    @Query("select i from Usuario  i where i.email = :email")
    public Usuario findByEmail(String email);

    @Query("select j from Usuario  j where j.user = :user and j.password = :password")
    public Usuario buscarLogin(String user, String password);

}
