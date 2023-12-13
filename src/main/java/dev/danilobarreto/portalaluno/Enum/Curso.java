package dev.danilobarreto.portalaluno.Enum;

public enum Curso {
    ENFERMAGEM("Enfermagem"),
    COTABILIDADE("Contabilidade"),
    MEDICINA("Medicina"),
    DIREITO("Direito"),
    CIENCIASDACOMPUTACAO("CienciasDaComputacao"),
    PSICOLOGIA("Psicologia"),
    ADMINISTRACAO("Administracao");

    private String curso;

    private Curso(String curso){
        this.curso = curso;
    }
}
