package app;

public class DisciplinaNaoAtribuidaException extends Exception {
    public DisciplinaNaoAtribuidaException() {
        super("A turma deve ter uma disciplina atribuída.");
    }
}