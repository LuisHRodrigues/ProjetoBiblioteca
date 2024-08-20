package View;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public interface Utility {

    static void mudarTelas (JFrame ant, JFrame prox){
        ant.setVisible(false);
        prox.setVisible(true);
    }

     static void frameStartup (JFrame frame, int width, int height){
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

     static void retornar (JFrame ant, JFrame prox, int x, int y) {
        JButton retornar = new JButton("Retornar");

        retornar.setBounds(x, y, 100, 30);

        ant.add(retornar);

        retornar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mudarTelas(ant, prox);
            }
        });
    }

    static void cadastrar (JFrame prox, JLabel one, JLabel two, JLabel three, JLabel four) {
        JFrame cads = new JFrame("Inserção de novos dados");

        mudarTelas(prox, cads);

        frameStartup(cads, 350, 600);

        JTextField o = new JTextField(50);
        JTextField tw = new JTextField(50);
        JTextField thr = new JTextField(50);
        JTextField f = new JTextField(50);

        JButton confirmar = new JButton("Confirmar");

        one.setBounds(100, 20, 150, 30);
        o.setBounds(100, 60, 150, 30);

        two.setBounds(100, 140, 150, 30);
        tw.setBounds(100, 180, 150, 30);

        three.setBounds(100, 260, 150, 30);
        thr.setBounds(100, 300, 150, 30);

        four.setBounds(100, 380, 150, 30);
        f.setBounds(100, 420, 150, 30);

        confirmar.setBounds(100, 465, 150, 30);

        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Operação concluída!","Inserção efetuada com êxito!", JOptionPane.INFORMATION_MESSAGE);
                Utility.mudarTelas(cads, prox);
            }
        });

        cads.add(one);
        cads.add(two);
        cads.add(three);
        cads.add(four);
        cads.add(o);
        cads.add(tw);
        cads.add(thr);
        cads.add(f);
        cads.add(confirmar);
    }

    static void excluir (JFrame prox, JLabel one) {

        JFrame excluir = new JFrame("Exluir");
        frameStartup(excluir, 350, 350);
        mudarTelas(prox, excluir);

        JTextField removal = new JTextField(50);

        JButton confirmar = new JButton("Confirmar");

        one.setBounds(100, 50, 150, 30);

        removal.setBounds(100, 90, 150, 30);

        confirmar.setBounds(100, 220, 150, 30);

        confirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mudarTelas(excluir, prox);
                JOptionPane.showMessageDialog(null,"\"" + removal + "\" removido.",
                        "Operação concluída!", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        excluir.add(removal);
        excluir.add(one);
        excluir.add(confirmar);

    }
    static void table (JFrame frame, Object [][] data, String columns []) {
        JTable tble = new JTable(data, columns);
        JScrollPane scrl = new JScrollPane(tble);
        JPanel plce = new JPanel(new FlowLayout());
        plce.setBounds(30, 90, 420, 100);
        plce.add(scrl);
        frame.add(plce);
    }

    static void buscar (JFrame frame, JLabel one, JLabel two, JLabel three, JLabel four) {
        JFrame buscar = new JFrame("Visualizar");
        frameStartup(buscar, 350, 400);
        retornar(buscar, frame, 120, 100);

        mudarTelas(frame, buscar);

        one.setBounds(135, 50, 300, 30);
        two.setBounds(135, 100, 300, 30);
        three.setBounds(135, 150, 300, 30);
        four.setBounds(135, 200, 300, 30);

        buscar.add(one);
        buscar.add(two);
        buscar.add(three);
        buscar.add(four);
    }
}
