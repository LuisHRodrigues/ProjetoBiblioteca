package View;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login implements Utility {

    static String user = "";
    static String pass = "";
    public static void loginComponents (JFrame Log_in, JFrame Menu) {

        JLabel l = new JLabel("Login");
        JLabel s = new JLabel("Senha");

        JTextField login = new JTextField(50);
        JPasswordField senha = new JPasswordField(50);

        JButton entrar = new JButton("Entrar");

        l.setBounds(100, 50, 150, 30);
        s.setBounds(100, 130, 150, 30);

        login.setBounds(100, 90, 150, 30);
        senha.setBounds(100, 170, 150, 30);

        entrar.setBounds(100, 220, 150, 30);

        Log_in.add(l);
        Log_in.add(login);
        Log_in.add(s);
        Log_in.add(senha);
        Log_in.add(entrar);

        entrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setUser(login.getText());
                if (Login.getUser().equalsIgnoreCase("F") || Login.getUser().equalsIgnoreCase("C") )
                    Utility.mudarTelas(Log_in, Menu);
            }
        });
        setUser("F"); //Since it`s not being saved up there...
    }

    public static void setUser (String user) {Login.user = user;}
    public static void setPass (String pass) {Login.pass = pass;}

    public static String getPass() {return pass;}
    public static String getUser() {return user;}
}
