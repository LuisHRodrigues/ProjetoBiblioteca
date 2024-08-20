package View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Reserva {

    static JFrame lres = new JFrame("Listagem de reservas");

    static JFrame cres = new JFrame("Marcar reserva");
    static JFrame cresFun = new JFrame("Administração: Marcar reserva");


    public static void startup (JFrame Reserva, JFrame Menu) {
        Utility.frameStartup(lres,810,500);
        Utility.retornar(lres, Reserva, 600, 25);
        Utility.retornar(Reserva, Menu, 135, 286);
        Utility.frameStartup(cresFun, 350, 600);
    }

    public static void reservaComponents (JFrame Reserva, JFrame Menu) {

        startup(Reserva, Menu);

        JLabel list = new JLabel("Listar reservas");
        JLabel visu = new JLabel("Visualizar reserva");
        JLabel busc = new JLabel("Visualizar obra");
        JLabel resv = new JLabel("Reservar");

        list.setBounds(135, 50, 300, 30);
        visu.setBounds(135, 100, 300, 30);
        busc.setBounds(135, 150, 300, 30);
        resv.setBounds(135, 200, 300, 30);

        Reserva.add(list);
        Reserva.add(visu);
        Reserva.add(busc);
        Reserva.add(resv);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lsReserva();
                Utility.mudarTelas(Reserva, lres);
            }
        });

        visu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String cod_obra = JOptionPane.showInputDialog(null, "Digite o código da obra: ", "Visualizar empréstimo", JOptionPane.INFORMATION_MESSAGE);
                JLabel id_user = new JLabel("ID_Usuário: \"" + null + "\".");
                JLabel id_obra = new JLabel("ID_Obra: \"" + cod_obra + "\".");
                JLabel data = new JLabel("Data de expiração: \"" + null + "\".");
                JLabel horario = new JLabel("Horário: \"" + null + "\".");

                Utility.buscar(Reserva,id_obra,id_user,data,horario);
            }
        });

        busc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id_obra = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número do usuário: ",
                        "Visualizar obra", JOptionPane.INFORMATION_MESSAGE));

                JLabel one = new JLabel("Número id: \"" + id_obra +"\".");
                JLabel two = new JLabel("Título da obra: \"" + null +"\".");
                JLabel three = new JLabel("Tipo: \"" + null +"\".");
                JLabel four = new JLabel("Digital: \"" + null +"\".");

                Utility.buscar(Reserva, one, two, three, four);
            }
        });

        resv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cresComponents(Reserva);
                Utility.mudarTelas(Reserva, cres);
            }
        });

        if (Login.getUser().equalsIgnoreCase ("F")) {
            reservaFun(Reserva);
        }
    }

    public static void reservaFun (JFrame Reserva) {
        JLabel rfun = new JLabel("Reservar (ADM)");
        rfun.setBounds(135, 250, 300, 30);
        Reserva.add(rfun);
        rfun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cresFunComponents(Reserva);
                Utility.mudarTelas(Reserva, cres);
            }
        });
    }

    public static void lsReserva () {
        String[] columns = {"ID_Usuário", "ID_Obra", "Data", "Horário"};

        Object[][] data = {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
        };

        Utility.table(lres, data, columns);

        JButton visu = new JButton("Visualizar reserva");

        visu.setBounds(30, 25, 100, 30);

        visu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String cod_obra = JOptionPane.showInputDialog(null, "Digite o código da obra: ", "Visualizar empréstimo", JOptionPane.INFORMATION_MESSAGE);
                JLabel id_user = new JLabel("ID_Usuário: \"" + null + "\".");
                JLabel id_obra = new JLabel("ID_Obra: \"" + cod_obra + "\".");
                JLabel data = new JLabel("Data de expiração: \"" + null + "\".");
                JLabel horario = new JLabel("Horário: \"" + null + "\".");
                Utility.buscar(lres, id_obra, id_user, data, horario);

            }
        });
        lres.add(visu);
    }
        public static void cresComponents (JFrame Reserva) {

            JLabel cobr = new JLabel("Código da obra");

            JLabel dare = new JLabel("Data de reserva");

            JTextField cbra = new JTextField(50);
            JTextField recb = new JTextField(50);

            JButton confirmar = new JButton("Confirmar");

            cobr.setBounds(100, 20, 150, 30);
            cbra.setBounds(100, 60, 150, 30);
            dare.setBounds(100, 140, 150, 30);
            recb.setBounds(100, 180, 150, 30);
            confirmar.setBounds(100, 245, 150, 30);

            confirmar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(null, "Solicitação de reserva enviada, " + Login.getUser() + ".",
                            "Reserva enviada com êxito!", JOptionPane.INFORMATION_MESSAGE);
                    Utility.mudarTelas(cres, Reserva);
                }
            });

            cres.add(cobr);
            cres.add(cbra);
            cres.add(dare);
            cres.add(recb);
            cres.add(confirmar);
        }

        public static void cresFunComponents (JFrame Reserva) {

            JLabel cobr = new JLabel("Código da obra");
            JLabel coem = new JLabel("Código do reservador");
            JLabel datai = new JLabel("Data inicial reserva");
            JLabel dataf = new JLabel("Data final reserva");


            JTextField cbra = new JTextField(50);
            JTextField recb = new JTextField(50);
            JTextField coer = new JTextField(50);
            JTextField daem = new JTextField(50);


            JButton confirmar = new JButton("Confirmar");


            cobr.setBounds(100, 20, 150, 30);
            cbra.setBounds(100, 60, 150, 30);

            coem.setBounds(100, 140, 150, 30);
            coer.setBounds(100, 180, 150, 30);

            datai.setBounds(100, 260, 150, 30);
            recb.setBounds(100, 300, 150, 30);

            dataf.setBounds(100, 380, 150, 30);
            daem.setBounds(100, 420, 150, 30);

            confirmar.setBounds(100, 465, 150, 30);

            confirmar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(null, "Operação concluída!","Obra emprestada com êxito!", JOptionPane.INFORMATION_MESSAGE);
                    Utility.mudarTelas(cresFun, Reserva);
                }
            });

            cresFun.add(cobr);
            cresFun.add(cbra);
            cresFun.add(coem);
            cresFun.add(coer);
            cresFun.add(datai);
            cresFun.add(recb);
            cresFun.add(daem);
            cresFun.add(dataf);
            cresFun.add(confirmar);
        }
}


 /*

     Listar reservas (lista todas as reservas e fornece botão para visualizar uma determinada reserva)
Visualizar reserva (Mostra detalhes de uma reserva e deverá conter botão para cancelar)
Buscar obra (fornece botão para visualizar uma determinada obra)
Reservar (Não é necessário informar o usuário, uma vez que o usuário deverá estar logado)


 */

    /* Func
    Reservar (A partir de uma obra emprestada deve ser disponibilizado um botão de reserva que levará
para uma tela de reserva em que será possível informar o usuário que deseja efetuar a reserva)
     */

