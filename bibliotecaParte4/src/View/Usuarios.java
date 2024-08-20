package View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usuarios {
    public static void userComponents (JFrame Menu, JFrame Users) {
        Utility.retornar(Users, Menu, 600, 25);

        String columns[] = {"ID", "E-mail", "Login", "Senha"};

        Object[][] data = {
                {0, null, Login.getUser(), Login.getPass()},
                {null, null, null, null, null},
                {null, null, null, null, null}
        };

        Utility.table(Users, data, columns);
        crud(Users);
    }

    public static void crud (JFrame center) {
            JButton cada = new JButton("Adicionar");
            JButton visu = new JButton("Visualizar");
            JButton edit = new JButton("Editar");
            JButton excl = new JButton("Excluir");

            JLabel id = new JLabel("ID");
            JLabel email = new JLabel("E-mail");
            JLabel login = new JLabel("Login");
            JLabel senha = new JLabel("Senha");


            cada.setBounds(30, 25, 100, 30);
            visu.setBounds(172, 25, 100, 30);
            edit.setBounds(314, 25, 100, 30);
            excl.setBounds(456, 25, 100, 30);

            center.add(cada);
            center.add(visu);
            center.add(edit);
            center.add(excl);

            cada.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent o) {
                    Utility.cadastrar(center,id,email,login,senha);
                }
            });

            edit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent o) {
                    Utility.cadastrar(center,id,email,login,senha);
                }
            });

            visu.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent o) {
                    int id_usu = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número do usuário: ",
                            "Visualizar usuário", JOptionPane.INFORMATION_MESSAGE));

                    JLabel one = new JLabel("Número id: \"" + id_usu +"\".");
                    JLabel two = new JLabel("E-mail: \"" + null +"\".");
                    JLabel three = new JLabel("Login: \"" + null +"\".");
                    JLabel four = new JLabel("Senha: \"" + null +"\".");

                    Utility.buscar(center, one, two, three, four);
                }
            });

            excl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent o) {
                    Utility.excluir(center,id);
                }
            });
    }
}

    /*
    Listar usuários
    Cadastrar/visualizar/editar/excluir (livros, usuários)
     */
