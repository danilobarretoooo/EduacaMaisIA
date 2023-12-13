package dev.danilobarreto.portalaluno.Dao;

import dev.danilobarreto.portalaluno.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AlunoDao extends JpaRepository<Aluno, Long> {

    @Query("select j from Aluno j where j.status = 'ATIVO' ")
    public List<Aluno> findByStatusAtivos();

    @Query("select j from Aluno j where j.status = 'INATIVO' ")
    public List<Aluno> findByStatusIntivo();

    @Query("select j from Aluno j where j.status = 'TRANCADO' ")
    public List<Aluno> findByStatusTrancado();

    @Query("select j from Aluno j where j.status = 'CANCELADO' ")
    public List<Aluno> findByStatusCancelado();

    public List<Aluno> findByNomeContaining(String valor);

    public List<Aluno> findByCursoContaining(String valor);

    public List<Aluno> findByMatriculaContaining(String valor);

    public List<Aluno> findByStatusContaining(String valor);

    public List<Aluno> findByTurnoContaining(String valor);

}