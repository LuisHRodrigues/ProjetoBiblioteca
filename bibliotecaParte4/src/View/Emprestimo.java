package View;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Emprestimo implements Utility {

    static JFrame lise = new JFrame("Empréstimos registrados");
    static JFrame viem = new JFrame ("Visualizar empréstimo");
    static JFrame buem = new JFrame ("Buscar empréstimo");
    static JFrame empt = new JFrame ("Emprestar");

    public static void empComponents(JFrame Empr) {

        JLabel list = new JLabel("Listar empréstimos");
        JLabel visu = new JLabel("Visualizar empréstimo");
        JLabel busc = new JLabel("Buscar empréstimo");
        JLabel empr = new JLabel("Emprestar");


        Utility.frameStartup(empt, 810, 350);
        Utility.frameStartup(viem, 810, 350);
        Utility.frameStartup(buem, 810, 350);
        Utility.frameStartup(lise, 810, 350);

        liseComponents();
        Utility.crud(lise);


        Utility.retornar(empt,Empr, 600, 25);
        Utility.retornar(buem,Empr, 600, 25);
        Utility.retornar(viem,Empr, 600, 25);
        Utility.retornar(lise,Empr, 600, 25);


        list.setBounds(135, 50, 300, 30);
        visu.setBounds(135, 100, 300, 30);
        busc.setBounds(135, 150, 300, 30);
        empr.setBounds(135, 200, 300, 30);


        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Empr, lise);
            }
        });

        visu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Empr, viem);
            }
        });

        busc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Empr, buem);
            }
        });

        empr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Empr, empt);
            }
        });


        Empr.add(list);
        Empr.add(busc);
        Empr.add(visu);
        Empr.add(empr);

    }

    public static void FuncComp (JFrame EmpFun) {
        JLabel empr = new JLabel("Emprestar (ADM)");
        empr.setBounds(135, 250, 300, 30);
        EmpFun.add(empr);

        empr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(EmpFun, empt);
            }
        });
    }

    public static void liseComponents () {
        String [] columns = {"ID_Usuário", "ID_Livro", "Data", "Horário"};

        Object [][] data = {
                {null, null, null, null},
        };

        JTable tabl = new JTable (data, columns);

        tabl.setBounds(30,40,200,300);

        JScrollPane scrl = new JScrollPane(tabl);

        lise.add(scrl);
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

