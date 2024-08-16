package View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Trabalho {

    public static void trabComponents (JFrame Trab, JFrame Menu) {

        JLabel l_id = new JLabel("I.D. Trabalho:");
        JLabel l_titulo = new JLabel("Título:");
        JLabel l_faculdade = new JLabel("Código da faculdade:");
        JLabel l_dtConclusao = new JLabel("Data de conclusão:");
        JLabel l_aluno = new JLabel("I.D. Aluno(a):");
        JLabel l_orientador = new JLabel("I.D. Orientador(a):");
        JLabel l_curso = new JLabel("Código do curso:");
        JLabel l_lcArquivo = new JLabel("Local do arquivo:");
        JLabel l_score = new JLabel("Pontuação:");
        JLabel l_qtdVotos = new JLabel("Quantidade de votos:");

        JTextField id = new JTextField(27);
        JTextField titulo = new JTextField(27);
        JTextField faculdade = new JTextField(27);
        JTextField dtConclusao = new JTextField(27);
        JTextField aluno = new JTextField(27);
        JTextField orientador = new JTextField(27);
        JTextField curso = new JTextField(27);
        JTextField lcArquivo = new JTextField(27);
        JTextField score = new JTextField(27);
        JTextField qtdVotos = new JTextField(27);

        JButton submeter = new JButton("Submeter");

        l_id.setBounds(112, 30, 300, 30);
        l_titulo.setBounds(112, 80, 300, 30);
        l_faculdade.setBounds(112, 130, 300, 30);
        l_dtConclusao.setBounds(112, 180, 300, 30);
        l_aluno.setBounds(112, 230, 300, 30);

        id.setBounds(250, 30, 150, 30);
        titulo.setBounds(250, 80, 150, 30);
        faculdade.setBounds(250, 130, 150, 30);
        dtConclusao.setBounds(250, 180, 150, 30);
        aluno.setBounds(250, 230, 150, 30);

        l_orientador.setBounds(450, 30, 300, 30);
        l_curso.setBounds(450, 80, 300, 30);
        l_lcArquivo.setBounds(450, 130, 300, 30);
        l_score.setBounds(450, 180, 300, 30);
        l_qtdVotos.setBounds(450, 230, 350, 30);

        orientador.setBounds(588, 30, 150, 30);
        curso.setBounds(588, 80, 150, 30);
        lcArquivo.setBounds(588, 130, 150, 30);
        score.setBounds(588, 180, 150, 30);
        qtdVotos.setBounds(588, 230, 150, 30);

        submeter.setBounds(300, 280, 250, 30);

        Trab.add(l_id);
        Trab.add(id);
        Trab.add(l_titulo);
        Trab.add(titulo);
        Trab.add(l_faculdade);
        Trab.add(faculdade);
        Trab.add(l_aluno);
        Trab.add(aluno);
        Trab.add(l_orientador);
        Trab.add(orientador);
        Trab.add(l_dtConclusao);
        Trab.add(dtConclusao);
        Trab.add(l_score);
        Trab.add(score);
        Trab.add(l_lcArquivo);
        Trab.add(lcArquivo);
        Trab.add(l_curso);
        Trab.add(curso);
        Trab.add(l_qtdVotos);
        Trab.add(qtdVotos);
        Trab.add(submeter);

        submeter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Trab, Menu);
                JOptionPane.showMessageDialog(null, "Trabalho enviado com sucesso!", "Êxito na operação", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
