package cadastros;

import java.util.ArrayList;
import java.util.List;
import app.Disciplina;

import javax.swing.*;

public class CadastroDisciplina {
    private List<Disciplina> disciplinas;

    public CadastroDisciplina() {
        disciplinas = new ArrayList<>();
    }

    public boolean cadastrarDisciplina(Disciplina d) {
        return disciplinas.add(d);
    }

    public Disciplina pesquisarDisciplina(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }
    public void listarDisciplina(){
        for(Disciplina disciplina: disciplinas){
            JOptionPane.showMessageDialog(null,disciplina
            );
        }
    }

    public boolean removerDisciplina(Disciplina d) {
        return disciplinas.remove(d);
    }

    public boolean atualizarDisciplina(String codigo, Disciplina novaDisciplina) {
        Disciplina disciplina = pesquisarDisciplina(codigo);
        if (disciplina != null) {
            disciplinas.remove(disciplina);
            return disciplinas.add(novaDisciplina);
        }
        return false;
    }
}
