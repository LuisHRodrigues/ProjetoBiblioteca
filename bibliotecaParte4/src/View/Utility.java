package View;

import javax.swing.*;

public interface Utility {

    public static void mudarTelas (JFrame ant, JFrame prox){
        ant.setVisible(false);
        prox.setVisible(true);
    }

    public static void frameStartup (JFrame frame, int width, int height){
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

}
