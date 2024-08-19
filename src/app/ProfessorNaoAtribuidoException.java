package app;

public class ProfessorNaoAtribuidoException extends Exception {
    public ProfessorNaoAtribuidoException() {
        super("A turma deve ter um professor atribuído.");
    }
}
