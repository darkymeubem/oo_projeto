import javax.swing.JOptionPane;

import app.*;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurmas;
import view.*;

public class Principal {

    static CadastroAluno cadAluno = new CadastroAluno();
    static CadastroDisciplina cadDisciplina = new CadastroDisciplina();
    static CadastroProfessor cadProfessor = new CadastroProfessor();
    static CadastroTurmas cadTurmas = new CadastroTurmas();

    public static void main(String[] args) throws ProfessorNaoAtribuidoException, CampoEmBrancoException, DisciplinaNaoAtribuidaException {
        try {
            Aluno a1 = new Aluno("Felipe", "10001", "felipe@unb.br", "10001", "Engenharia de Software");
            Aluno a2 = new Aluno("Joao Igor", "10002", "joao.i@unb.br", "10002", "Psicologia");
            Aluno a3 = new Aluno("Renato", "10003", "renato@unb.br", "10003", "Música");

            cadAluno.cadastrarAluno(a1);
            cadAluno.cadastrarAluno(a2);
            cadAluno.cadastrarAluno(a3);


            Professor p1 = new Professor("Andre Lanna", "10234", "andre.lanna@unb.br", "Ciencia da Computacao", "1255");
            Professor p2 = new Professor("Thiago", "10235", "thiago@unb.br", "Engenharia elétrica", "2442");
            cadProfessor.cadastrarProfessor(p1);
            cadProfessor.cadastrarProfessor(p2);

            Disciplina d1 = new Disciplina("FGA0158", "Orientacao a Objetos", "Andre Lanna");
            Disciplina d2 = new Disciplina("FGA0073", "PED", "Thiago");
            cadDisciplina.cadastrarDisciplina(d1);
            cadDisciplina.cadastrarDisciplina(d2);

        }
        catch (CampoEmBrancoException | DisciplinaNaoAtribuidaException | ProfessorNaoAtribuidoException e) {
            System.out.println(e.getMessage());
        }


        int opcao = 0;

        do {
            opcao = MenuPrincipal.menuOpcoes();
            switch (opcao) {
                case 1:
                    MenuAluno.menuAluno(cadAluno);
                    break;
                case 2:
                   MenuProfessor.menuProfessor(cadProfessor);
                    break;
                case 3:
                    MenuDisciplina.menuDisciplina(cadDisciplina);
                    break;
                case 4:
                    MenuTurma.menuTurma(cadTurmas,cadProfessor,cadDisciplina, cadAluno);
                    break;


                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);
    }
}
