package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Emprestimo {

    public static void empComponents(JFrame Empr) {

        JLabel list = new JLabel("Listar empréstimos");
        JLabel visu = new JLabel("Visualizar empréstimo");
        JLabel busc = new JLabel("Buscar empréstimo");
        JLabel empr = new JLabel("Emprestar");

        list.setBounds(135, 50, 300, 30);
        visu.setBounds(135, 100, 300, 30);
        busc.setBounds(135, 150, 300, 30);
        empr.setBounds(135, 200, 300, 30);

        Empr.add(list);
        Empr.add(busc);
        Empr.add(visu);
        Empr.add(empr);
    }

    public static void FuncComp (JFrame EmpFun, JFrame Emprestar) {
        JLabel empr = new JLabel("Emprestar (ADM)");
        empr.setBounds(135, 250, 300, 30);
        EmpFun.add(empr);

        empr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(EmpFun, Emprestar);
            }
        });
    }
}

    /*Listar empréstimos (lista todos os empréstimos e fornece botão para visualizar um determinado
            empréstimo)
    Visualizar empréstimo (Mostra detalhes de um empréstimo e deverá conter botão para renovar e
devolver)
Buscar empréstimo (fornece botão para visualizar um determinado empréstimo)
Emprestar (Não é necessário informar o usuário, uma vez que o usuário deverá estar logado)
     */

    /* Func

Emprestar (A partir de uma obra deve ser disponibilizado um botão para empréstimo que levará para
uma tela em que será possível informar o usuário que deseja efetuar um empréstimo, bem como as
outras informações relativas ao empréstimo)

     */

