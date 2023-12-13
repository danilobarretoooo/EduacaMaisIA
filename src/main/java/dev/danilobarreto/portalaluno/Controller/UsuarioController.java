package dev.danilobarreto.portalaluno.Controller;

import dev.danilobarreto.portalaluno.Dao.UsuarioDao;
import dev.danilobarreto.portalaluno.Model.Usuario;
import dev.danilobarreto.portalaluno.Service.ServiceExceptions;
import dev.danilobarreto.portalaluno.Service.ServiceUsuario;
import dev.danilobarreto.portalaluno.Util.Util;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioRepository;

    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping("/home")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login/login");
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        mv.setViewName("Login/cadastro");
        return mv;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView cadastrar(Usuario usuario) throws Exception {
        ModelAndView mv = new ModelAndView();
        serviceUsuario.salvarUsuario(usuario);
        mv.setViewName("redirect:/home");
        return mv;
    }
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExceptions {
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        if (br.hasErrors()){
            mv.setViewName("Login/login");
        }


        Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(),
                Util.md5(usuario.getPassword()));
        if (userLogin == null){
            mv.addObject("msg", "Usuario não encontrado. Tente novamente!");
        }else{
            session.setAttribute("usuarioLogado", userLogin);
            return index();
        }
        return mv;
    }
}

