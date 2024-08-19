package app;

import java.util.List;

public class Turmas {

    private String nome;
    private String codTurma;
    private Disciplina disciplina;
    private String professore;
    private Professor professor;
    List <Aluno> alunos;


    public Turmas(String nome, String codTurma, Professor professor, Disciplina disciplina,List <Aluno> alunos) throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException  {

        this.nome = nome;
        this.codTurma = codTurma;
        this.professor = professor;
        this.alunos = alunos;
        this.disciplina = disciplina;

        if (codTurma == null || codTurma.trim().isEmpty()) {
            throw new CampoEmBrancoException("Código da turma");
        }if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("Código da turma");
        }
        if (disciplina == null) {
            throw new DisciplinaNaoAtribuidaException();
        }
        if (professor == null) {
            throw new ProfessorNaoAtribuidoException();
        }


    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getNome() {
        return nome;
    }

    public String getCodTurma() {
        return codTurma;
    }

    public Professor getProfessor() {
        return professor;
    }

    @Override
    public String toString() {
        String resposta = "NOME DA TURMA: " + nome + '\n';
        resposta += "CODIGO DA TURMA: " + codTurma + '\n';
        resposta += "PROFESSOR DA TURMA: " + professor.getNome() + '\n';
        resposta += "Disciplina DA TURMA: " + disciplina.getNome() + '\n';
//        if (alunos == null) {
//            resposta += "VAZIO\n";
//        }
//
        for (Aluno aluno : alunos) {
            resposta += "Aluno: " + aluno.getNome() + '\n';
            resposta += "Matrícula: " + aluno.getMatricula() + '\n';
        }

        return resposta;
    }
}
