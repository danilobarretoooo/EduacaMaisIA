package dev.danilobarreto.portalaluno.Service;

import dev.danilobarreto.portalaluno.Dao.UsuarioDao;
import dev.danilobarreto.portalaluno.Exception.CriptoExistExeption;
import dev.danilobarreto.portalaluno.Exception.EmailExistException;
import dev.danilobarreto.portalaluno.Model.Usuario;
import dev.danilobarreto.portalaluno.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class ServiceUsuario {
    @Autowired
    private UsuarioDao usuarioRepositorio;
    public void salvarUsuario(Usuario user) throws Exception {
        try{
            if(usuarioRepositorio.findByEmail(user.getEmail()) != null){
                throw  new EmailExistException("Já existe um email cadastrado para: " + user.getEmail());
            }
            user.setPassword(Util.md5(user.getPassword()));
        }catch (NoSuchAlgorithmException e){
            throw  new CriptoExistExeption("Erro na criptografia da senha");
        }

        usuarioRepositorio.save(user);
    }


    public Usuario loginUser(String user, String password) throws ServiceExceptions {
        Usuario userLogin = usuarioRepositorio.buscarLogin(user, password);
        return userLogin;
    }
}
