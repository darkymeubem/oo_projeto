package view;


import app.*;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurmas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuTurma {





    static Professor p;
    static List<Aluno> alunos = new ArrayList<>();

    public static Turmas dadosNovaTurma(CadastroProfessor cadProfessor, CadastroDisciplina cadDisciplina,CadastroAluno cadAluno) throws ProfessorNaoAtribuidoException, CampoEmBrancoException, DisciplinaNaoAtribuidaException {
        String nome = lerNome();
        String codTurma = lerCodigoTurma();
        String matriculaProfessor = lerMatriculaProfessor();
        alunos = lerMatriculaAluno(cadAluno);
        Professor professor = cadProfessor.pesquisarProfessor(matriculaProfessor);
        Disciplina disciplina = cadDisciplina.pesquisarDisciplina(lerDisciplina());
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado.");
            return null;
        }if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
            return null;
        }
       if(!disciplina.getProfessor().equals(professor.getNome())) {
            JOptionPane.showMessageDialog(null,"O código digitado não corresponde ao que o professor ministra.");
            disciplina = null;
       }

        return new Turmas(nome, codTurma, professor,disciplina,alunos);
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da Turma: ");
    }


    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da turma: ");
    }

    private static String lerCodigoTurma() {
        return JOptionPane.showInputDialog("Informe o código da turma: ");
    }

    private static String lerMatriculaProfessor() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor: ");
    } private static String lerDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da disciplina que o professor ministra: ");
    }



    private static List<Aluno> lerMatriculaAluno(CadastroAluno cadAluno) {
        int op = -1;
        List<Aluno> alunos1 = new ArrayList<>();
        do{
            String txt = "Informe a opção desejada \n"
                    + "1 - Cadastrar Aluno na turma\n"
                    + "2 - Remover aluno da turma\n"
                    + "0 - Voltar para menu anterior";
            String stropc = JOptionPane.showInputDialog(txt);
            op = Integer.parseInt(stropc);
            switch(op)  {

                case 1:
                    String matricula = JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
                    Aluno aluno = cadAluno.pesquisarAluno(matricula);
                    if (aluno == null) {
                        JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                    } else {
                        alunos1.add(aluno);
                    }


                    break;
                case 2:
                    matricula = JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
                    alunos1.removeIf(aluno1 -> aluno1.getMatricula().equalsIgnoreCase(matricula));
                    System.gc();
                default:
                    break;


            }

        }
        while(op != 0);
        return alunos1;
    }


    public static void menuTurma(CadastroTurmas cadTurma, CadastroProfessor cadProfessor, CadastroDisciplina cadDisciplina, CadastroAluno cadAluno) throws ProfessorNaoAtribuidoException, CampoEmBrancoException, DisciplinaNaoAtribuidaException {
        if (cadTurma == null) {
            JOptionPane.showMessageDialog(null, "Erro: CadastroTurma não foi inicializado.");
            return;
        }

        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar Turma\n"
                + "2 - Pesquisar Turma\n"
                + "3 - Atualizar Turma\n"
                + "4 - Remover Turma\n"
                + "5 - Imprimir Lista de presença\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turmas novaTurma = dadosNovaTurma(cadProfessor,cadDisciplina,cadAluno);
                   cadTurma.cadastrarTurma(novaTurma);
                    break;

                case 2:
                    String codigo = lerCodigo();
                    if (codigo != null && !codigo.isEmpty()) {
                        Turmas t = cadTurma.pesquisarTurma(codigo);
                        if (t != null) {
                            JOptionPane.showMessageDialog(null, t.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                        }
                    }
                    break;

                case 3:
                    codigo = lerCodigo();
                    if (codigo != null && !codigo.isEmpty()) {
                        Turmas novaCadastro = dadosNovaTurma(cadProfessor,cadDisciplina,cadAluno);
                        boolean atualizado = cadTurma.atualizarTurma(codigo, novaCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar cadastro.");
                        }
                    }
                    break;

                case 4:
                    codigo = lerCodigo();
                    if (codigo != null && !codigo.isEmpty()) {
                        Turmas remover = cadTurma.pesquisarTurma(codigo);
                        if (remover != null) {
                            boolean removido = cadTurma.removerTurma(remover);
                            if (removido) {
                                JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                                System.gc();
                            } else {
                                JOptionPane.showMessageDialog(null, "Falha ao remover turma.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                        }
                    }
                    break;
                case 5:
                    cadTurma.listarTurmas();




                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

}
