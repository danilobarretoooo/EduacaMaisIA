package dev.danilobarreto.portalaluno.Service;

import dev.danilobarreto.portalaluno.Dao.AlunoDao;
import dev.danilobarreto.portalaluno.Model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoDao alunoDao;

    public List<Aluno> filtrarAlunosPorCriterio(String criterio, String valor) {
        switch (criterio) {
            case "nome":
                return alunoDao.findByNomeContaining(valor);
            case "curso":
                return alunoDao.findByCursoContaining(valor);
            case "matricula":
                return alunoDao.findByMatriculaContaining(valor);
            case "status":
                return alunoDao.findByStatusContaining(valor);
            case "turno":
                return alunoDao.findByTurnoContaining(valor);
            default:
                throw new IllegalArgumentException("Criterio de pesquisa inválido: " + criterio);
        }
    }
}
