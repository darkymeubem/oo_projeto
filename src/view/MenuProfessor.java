package view;

import javax.swing.JOptionPane;
import app.Professor;
import app.ProfessorNaoAtribuidoException;
import cadastros.CadastroProfessor;

public class MenuProfessor {

    public static Professor dadosNovoProfessor() throws ProfessorNaoAtribuidoException {
        String nome = lerNome();
        String cpf = lerCPF();
        String email = lerEmail();
        String areaFormacao = lerAreaFormacao();
        String matriculaFUB = lerMatriculaFUB();
        return new Professor(nome, cpf, email, areaFormacao, matriculaFUB);
    }

    private static String lerAreaFormacao() {
        return JOptionPane.showInputDialog("Informe a área de formação do professor: ");
    }

    private static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do professor: ");
    }

    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do professor: ");
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do professor: ");
    }

    private static String lerMatriculaFUB() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor: ");
    }

    public static void menuProfessor(CadastroProfessor cadProfessor) throws ProfessorNaoAtribuidoException {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar professor\n"
                + "2 - Pesquisar professor\n"
                + "3 - Atualizar professor\n"
                + "4 - Remover professor\n"
                + "5 - Listar professores\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Professor novoProfessor = dadosNovoProfessor();
                    cadProfessor.cadastrarProfessor(novoProfessor);
                    break;

                case 2:
                    String matriculaFUB = lerMatriculaFUB();
                    Professor p = cadProfessor.pesquisarProfessor(matriculaFUB);
                    if (p != null)
                        JOptionPane.showMessageDialog(null, p.toString());
                    break;

                case 3:
                    matriculaFUB = lerMatriculaFUB();
                    Professor novoCadastro = dadosNovoProfessor();
                    boolean atualizado = cadProfessor.atualizarProfessor(matriculaFUB, novoCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4:
                    matriculaFUB = lerMatriculaFUB();
                    Professor remover = cadProfessor.pesquisarProfessor(matriculaFUB);
                    boolean removido = cadProfessor.removerProfessor(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
                        System.gc();
                    }
                case 5:
                    cadProfessor.listarProfessor();
                default:

                    break;
            }
        } while (opcao != 0);
        return;
    }
}
