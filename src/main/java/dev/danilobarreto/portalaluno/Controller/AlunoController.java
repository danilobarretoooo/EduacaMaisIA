package dev.danilobarreto.portalaluno.Controller;

import dev.danilobarreto.portalaluno.Dao.AlunoDao;
import dev.danilobarreto.portalaluno.Model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AlunoController {

    @Autowired
    private AlunoDao alunoRepositorio;

    @GetMapping("/cadastrar")
    public ModelAndView InsertAlunos(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/create");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("Cadastrar")
    public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br){
        ModelAndView mv = new ModelAndView();
        if(br.hasErrors()){
            mv.setViewName("aluno/create");
            mv.addObject("aluno");
        }else {
            mv.setViewName("redirect:/alunos-adicionar");
            alunoRepositorio.save(aluno);
        }
        return mv;
    }

    @GetMapping("alunos-adicionar")
    public ModelAndView listagemAlunos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/listAlunos");
        mv.addObject("alunosList", alunoRepositorio.findAll());
        return mv;
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alterar");
        Aluno aluno = alunoRepositorio.getOne(id);
        mv.addObject("aluno", aluno);
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        alunoRepositorio.save(aluno);
        mv.setViewName("redirect:/alunos-adicionar");
        return mv;
    }
    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable("id") Long id){
        alunoRepositorio.deleteById(id);
        return "redirect:/alunos-adicionar";
    }

    @GetMapping("filtro-aluno")
    public ModelAndView filtroAluno(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/filtroAluno");
        return mv;
    }
    @GetMapping("alunos-ativos")
    public ModelAndView listagemAlunosAtivos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-ativos");
        mv.addObject("alunosAtivos", alunoRepositorio.findByStatusAtivos());
        return mv;
    }
    @GetMapping("alunos-inativos")
    public ModelAndView listagemAlunosInativos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-inativos");
        mv.addObject("alunosInativos", alunoRepositorio.findByStatusIntivo());
        return mv;
    }
    @GetMapping("alunos-trancados")
    public ModelAndView listagemAlunosTrancados(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-trancados");
        mv.addObject("alunosTrancados", alunoRepositorio.findByStatusTrancado());
        return mv;
    }
    @GetMapping("alunos-cancelados")
    public ModelAndView listagemAlunosCancelados() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-cancelados");
        mv.addObject("alunosCancelados", alunoRepositorio.findByStatusCancelado());
        return mv;
    }
}