package cadastros;

import app.Turma;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class CadastroTurma {
    private List<Turma> turmas;

    public CadastroTurma() {
        turmas = new ArrayList<>();
    }

    public boolean cadastrarTurma(Turma t) {
        return turmas.add(t);
    }

    public Turma pesquisarTurma(String codigoTurma) {
        for (Turma t : turmas) {
            if (t.getCodTurma().equalsIgnoreCase(codigoTurma)) {
                return t;
            }
        }
        return null;
    }

    public void listarTurmas() {
        for (Turma turma : turmas) {
            JOptionPane.showMessageDialog(null, turma);
        }
    }

    public boolean removerTurma(Turma t) {
        return turmas.remove(t);
    }

    public boolean atualizarTurma(String codigoTurma, Turma novaTurma) {
        Turma turma = pesquisarTurma(codigoTurma);
        if (turma != null) {
            turmas.remove(turma);
            return turmas.add(novaTurma);
        }
        return false;
    }
}
