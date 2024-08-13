package View;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login implements Utility {

    public static void loginComponents (JFrame Login, JFrame menuUser, JFrame menuFunc) {

        JLabel l = new JLabel("Login");
        JLabel s = new JLabel("Senha");

        JTextField login = new JTextField(50);
        JPasswordField senha = new JPasswordField(50);

        JButton entrar = new JButton("Entrar");

        l.setBounds(100, 40, 150, 30);
        s.setBounds(100, 120, 150, 30);

        login.setBounds(100, 90, 150, 30);
        senha.setBounds(100, 160, 150, 30);

        entrar.setBounds(100, 220, 150, 30);

        Login.add(l);
        Login.add(login);
        Login.add(s);
        Login.add(senha);
        Login.add(entrar);

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (login.getText().equalsIgnoreCase("C"))
                    Utility.mudarTelas(Login, menuUser);
                if (login.getText().equalsIgnoreCase("F"))
                    Utility.mudarTelas(Login, menuFunc);
            }
        });
    }

}
