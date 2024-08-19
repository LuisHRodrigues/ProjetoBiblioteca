package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

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

        prox.add(retornar);

        retornar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mudarTelas(ant, prox);
            }
        });
    }

    static void crud (JFrame center) {
        JButton cads = new JButton("Adicionar");
        JButton visu = new JButton("Visualizar");
        JButton edit = new JButton("Editar");
        JButton excl = new JButton("Excluir");

        cads.setBounds(30, 25, 100, 30);
        visu.setBounds(172, 25, 100, 30);
        edit.setBounds(314, 25, 100, 30);
        excl.setBounds(456, 25, 100, 30);


        center.add(cads);
        center.add(visu);
        center.add(edit);
        center.add(excl);
    }
}
