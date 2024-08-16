package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu implements Utility {

    public static void menuComponents (JFrame Menu, JFrame Obra, JFrame Rese, JFrame Empr, JFrame Trab) {
        JLabel obra = new JLabel("Obras");
        JLabel rese = new JLabel("Reservas");
        JLabel empr = new JLabel("Empréstimos");
        JLabel trab = new JLabel("Submeter trabalho");

        obra.setBounds(135, 50, 300, 30);
        rese.setBounds(135, 100, 300, 30);
        empr.setBounds(135, 150, 300, 30);
        trab.setBounds(135, 200, 300, 30);

        Menu.add(obra);
        Menu.add(empr);
        Menu.add(rese);
        Menu.add(trab);

        obra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Utility.mudarTelas(Menu, Obra);
            }
        });

        rese.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Menu, Rese);
            }
        });

        empr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Menu, Empr);
                Emprestimo.empComponents(Empr);
            }
        });

        trab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

    }

    public static void FuncComp (JFrame Menu, JFrame User) {
        JLabel user = new JLabel("Usuários");
        user.setBounds(135, 250, 300, 30);
        Menu.add(user);

        User.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Menu, User);
            }
        });
    }
}
