package View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Emprestimo implements Utility {

    static JFrame lise = new JFrame("Empréstimos registrados");
    static JFrame viem = new JFrame ("Visualizar empréstimo");
    static JFrame buem = new JFrame ("Buscar empréstimo");
    static JFrame empt = new JFrame ("Emprestar");
    static JFrame emptFun = new JFrame ("Administração: Emprestar");

    public static void startup(JFrame Empr){
        Utility.frameStartup(empt, 350, 350);
        Utility.frameStartup(viem, 405, 325);
        Utility.frameStartup(buem, 810, 350);
        Utility.frameStartup(lise, 500, 350);
        Utility.frameStartup(emptFun, 350, 600);

        liseComponents();
        emptComponents(Empr);
        emptFunComponents(Empr);


        Utility.retornar(empt, Empr, 600, 25);
        Utility.retornar(buem, Empr, 600, 25);
        Utility.retornar(viem, Empr, 280, 250);
        Utility.retornar(lise, Empr, 350, 25);
    }

    public static void empComponents(JFrame Empr, JFrame Menu) {
        startup(Empr);

        Utility.retornar(Empr, Menu, 135, 286);

        JLabel list = new JLabel("Listar empréstimos");
        JLabel visu = new JLabel("Visualizar empréstimo");
        JLabel busc = new JLabel("Buscar empréstimo");
        JLabel empr = new JLabel("Emprestar");

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
                String cod_obra = JOptionPane.showInputDialog(null, "Digite o código da obra: ", "Visualizar empréstimo", JOptionPane.INFORMATION_MESSAGE);
                viemComponents(cod_obra);
                Utility.mudarTelas(Empr, viem);
            }
        });

        busc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String cod_obra = JOptionPane.showInputDialog(null, "Digite o código da obra: ", "Buscar por empréstimo", JOptionPane.INFORMATION_MESSAGE);
                buemComponents(buem, cod_obra);
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

        if (Login.getUser().equalsIgnoreCase("F")){
            FuncComp(Empr);
        }

    }

    public static void FuncComp (JFrame EmpFun) {
        JLabel empr = new JLabel("Emprestar (ADM)");
        empr.setBounds(135, 250, 300, 30);
        EmpFun.add(empr);

        empr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                emptFunComponents(EmpFun);
                Utility.mudarTelas(EmpFun, emptFun);
            }
        });
    }

    public static void liseComponents () {
        String [] columns = {"ID_Usuário", "ID_Obra", "Data", "Horário"};

        Object [][] data = {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
        };

        Utility.table(lise, data, columns);

        JButton visu = new JButton("Visualizar empréstimo");

        visu.setBounds(30, 25, 100, 30);

        visu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String cod_obra = JOptionPane.showInputDialog(null, "Digite o código da obra: ", "Visualizar empréstimo", JOptionPane.INFORMATION_MESSAGE);
                viemComponents(cod_obra);
                Utility.mudarTelas(lise, viem);
            }
        });
        lise.add(visu);
    }

    public static void viemComponents (String cod_obra) {
        buemComponents(viem, cod_obra);

        JButton rnvr = new JButton("Renovar");
        JButton devr = new JButton("Devolver");

        rnvr.setBounds(20, 250, 100, 30);
        devr.setBounds(150, 250,100, 30);

        rnvr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null ,"Obra \"" + cod_obra + "\" renovada por cinco dias!", "Obra renovada", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        devr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null ,"Obra \"" + cod_obra + "\" devolvida com éxito.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        viem.add(rnvr);
        viem.add(devr);
    }

    public static void buemComponents (JFrame frame, String cod_obra) {
        JLabel code = new JLabel("Código da obra: \"" + cod_obra + "\".");
        JLabel user = new JLabel("Código do usuário: \"" + null + "\".");
        JLabel data = new JLabel("Data: " + null + " Hora: " + null + ".");

        code.setBounds(135, 50, 300, 30);
        user.setBounds(135, 100, 300, 30);
        data.setBounds(135, 150, 300, 30);

        frame.add(code);
        frame.add(user);
        frame.add(data);
    }

    public static void emptComponents (JFrame Empr) {

        JLabel cobr = new JLabel("Código da obra");

        JLabel rcbd = new JLabel("Código do recebedor");

        JTextField cbra = new JTextField(50);
        JTextField recb = new JTextField(50);

        JButton confirmar = new JButton("Confirmar");

        cobr.setBounds(100, 20, 150, 30);
        cbra.setBounds(100, 60, 150, 30);
        rcbd.setBounds(100, 140, 150, 30);
        recb.setBounds(100, 180, 150, 30);
        confirmar.setBounds(100, 245, 150, 30);

        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Operação concluída, " + Login.getUser() + ".", //Não aparecia no JLabel..,
                        "Obra emprestada com êxito!", JOptionPane.INFORMATION_MESSAGE);
                Utility.mudarTelas(empt, Empr);
            }
        });

        empt.add(cobr);
        empt.add(cbra);
        empt.add(rcbd);
        empt.add(recb);
        empt.add(confirmar);
    }

    public static void emptFunComponents (JFrame Empr) {
        JLabel cobr = new JLabel("Código da obra");
        JLabel coem = new JLabel("Código do emprestador");
        JLabel rcbd = new JLabel("Código do recebedor");
        JLabel data = new JLabel("Data para emprestar");


        JTextField cbra = new JTextField(50);
        JTextField recb = new JTextField(50);
        JTextField coer = new JTextField(50);
        JTextField daem = new JTextField(50);


        JButton confirmar = new JButton("Confirmar");


        cobr.setBounds(100, 20, 150, 30);
        cbra.setBounds(100, 60, 150, 30);

        coem.setBounds(100, 140, 150, 30);
        coer.setBounds(100, 180, 150, 30);

        rcbd.setBounds(100, 260, 150, 30);
        recb.setBounds(100, 300, 150, 30);

        data.setBounds(100, 380, 150, 30);
        daem.setBounds(100, 420, 150, 30);

        confirmar.setBounds(100, 465, 150, 30);

        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Operação concluída!","Obra emprestada com êxito!", JOptionPane.INFORMATION_MESSAGE);
                Utility.mudarTelas(emptFun, Empr);
            }
        });

        emptFun.add(cobr);
        emptFun.add(cbra);
        emptFun.add(coem);
        emptFun.add(coer);
        emptFun.add(rcbd);
        emptFun.add(recb);
        emptFun.add(daem);
        emptFun.add(data);
        emptFun.add(confirmar);
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







