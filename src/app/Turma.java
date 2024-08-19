package app;

public class Turma {
    private String nome;
    private String codTurma;
    private Professor professor;

    public Turma(String nome, String codTurma, Professor professor) {
        this.nome = nome;
        this.codTurma = codTurma;
        this.professor = professor;
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
        return resposta;
    }
}
