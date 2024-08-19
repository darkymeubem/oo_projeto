package cadastros;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turmas;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class CadastroTurmas {

    private List<Turmas> turmas;

    public CadastroTurmas() {
        turmas = new ArrayList<>();
    }

    public boolean cadastrarTurma(Turmas t) {
        return turmas.add(t);
    }

    public Turmas pesquisarTurma(String codigoTurma) {
        for (Turmas t : turmas) {
            if (t.getCodTurma().equalsIgnoreCase(codigoTurma)) {
                return t;
            }
        }
        return null;
    }

    public void listarTurmas() {
        for (Turmas turma : turmas) {
            JOptionPane.showMessageDialog(null, turma);
        }
    }

    public boolean removerTurma(Turmas t) {
        return turmas.remove(t);
    }

    public boolean atualizarTurma(String codigoTurma, Turmas novaTurma) {
        Turmas turma = pesquisarTurma(codigoTurma);
        if (turma != null) {
            turmas.remove(turma);
            return turmas.add(novaTurma);
        }
        return false;
    }


}





