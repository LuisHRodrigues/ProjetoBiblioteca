package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Obra implements Utility {

    private static JFrame midia_audio = new JFrame("Mídias de aúdio");
    private static JFrame fotografia = new JFrame("Fotografias");
    private static JFrame livro = new JFrame("Livros");
    private static JFrame liac = new JFrame("Listar acervo");
    private static JFrame ldac = new JFrame("Administração: Listar acervo");
    private static JFrame viob = new JFrame("Visualizar obra");

    private static JFrame crud = new JFrame("Administração: Operações Banco de dados");

    public static void startup(JFrame Obra, JFrame Menu) {
        Utility.frameStartup(livro, 810, 350);
        Utility.frameStartup(fotografia, 810, 350);
        Utility.frameStartup(midia_audio, 810, 350);
        Utility.frameStartup(liac, 500, 350);
        Utility.frameStartup(ldac, 810, 350);
        Utility.frameStartup(viob, 405, 350);

        liacComponents(Obra);
        crud(ldac);

        Utility.retornar(Obra, Menu, 135, 286);
        Utility.retornar(viob, Obra, 280, 250);
        Utility.retornar(liac, Obra, 350, 25);
        Utility.retornar(ldac, Obra, 600, 25);
        Utility.retornar(livro, Obra, 350, 25);
        Utility.retornar(fotografia, Obra, 350, 25);
        Utility.retornar(midia_audio, Obra, 350, 25);
    }

    public static void obraComponents(JFrame Obra, JFrame Menu) {
        startup(Obra, Menu);

        JLabel list = new JLabel("Listar acervos");
        JLabel digi = new JLabel("Acessar obra digital");

        list.setBounds(135, 50, 300, 30);
        digi.setBounds(135, 150, 300, 30);

        Obra.add(list);
        Obra.add(digi);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(Obra, liac);
            }
        });

        digi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] opt = {"Livro", "Mídia Aúdio", "Fotografia"};
                int tipo = JOptionPane.showOptionDialog(null, "Escolha o tipo de obra:", "Acessar obra digital", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opt, opt);
                switch (tipo) {
                    case 0:

                        String cL[] = {"Código obra", "Título", "Editora", "Edição", "Área", "Ano", "Num_Folhas", "Digital"};

                        Object[][] dataL = {
                                {null, null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null, null}
                        };
                        Utility.table(livro, dataL, cL);
                        Utility.mudarTelas(Obra, livro);
                        break;
                    case 1:

                        String cM[] = {"Código obra", "Título", "Duração", "Ano" , "Digital"};

                        Object[][] dataM = {
                                {null, null, null, null, null,null},
                                {null, null, null, null, null,null},
                                {null, null, null, null, null,null}
                        };

                        Utility.table(midia_audio, dataM, cM);
                        Utility.mudarTelas(Obra, midia_audio);
                        break;

                    case 2:

                        String cF[] = {"Código obra", "Título", "Ano", "Digital"};

                        Object[][] dataF = {
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null}
                        };
                        Utility.table(fotografia, dataF, cF);
                        Utility.mudarTelas(Obra, fotografia);
                        break;
                }
            }
        });

        if (Login.getUser().equalsIgnoreCase("F")){
            FuncComp(Obra);
        }
    }

    public static void FuncComp(JFrame obraFunc) {
        JLabel devo = new JLabel("Devolução/Renovação");
        JLabel list = new JLabel("Listar acervo (ADM)");

        devo.setBounds(135, 200, 300, 30);
        list.setBounds(135, 100, 300, 30);

        obraFunc.add(devo);
        obraFunc.add(list);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(obraFunc, ldac);
            }
        });
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(obraFunc, Emprestimo.viem);
            }
        });
    }

    public static void liacComponents(JFrame Obra) {
        String[] columns = {"Código obra", "Título", "Tipo", "Digital"};

        Object[][] data = {
                {null, null, null,null},
                {null, null, null,null},
                {null, null, null,null}
        };

        Utility.table(liac, data, columns);

        JButton visu = new JButton("Visualizar obra");

        visu.setBounds(30, 25, 100, 30);

        visu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String cod_obra = JOptionPane.showInputDialog(null, "Digite o código da obra: ", "Visualizar empréstimo", JOptionPane.INFORMATION_MESSAGE);
                viobComponents(cod_obra, Obra);
                Utility.mudarTelas(liac, viob);
            }
        });
        liac.add(visu);
    }

    public static void viobComponents (String cod_obra, JFrame Obra) {

        JLabel code = new JLabel("Código da obra: \"" + cod_obra + "\".");
        JLabel user = new JLabel("Digital: \"" + null + "\".");
        JLabel data = new JLabel("Tipo: " + null + ".");

        JButton empr = new JButton("Emprestar");


        code.setBounds(135, 50, 300, 30);
        user.setBounds(135, 100, 300, 30);
        data.setBounds(135, 150, 300, 30);
        empr.setBounds(20, 250, 100, 30);

        empr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Login.getUser().equalsIgnoreCase("C")){
                    Utility.mudarTelas(Obra, Emprestimo.empt);
                }
                if (Login.getUser().equalsIgnoreCase("F")){
                    Utility.mudarTelas(Obra, Emprestimo.emptFun);
                }
            }
        });
        viob.add(empr);
        viob.add(code);
        viob.add(user);
        viob.add(data);
    }

    public static void crud (JFrame center) {
        JButton cada = new JButton("Adicionar");
        JButton visu = new JButton("Visualizar");
        JButton edit = new JButton("Editar");
        JButton excl = new JButton("Excluir");

        JLabel id = new JLabel("Código obra");
        JLabel title = new JLabel("Título");
        JLabel type = new JLabel("Tipo");
        JLabel phys = new JLabel("Digital");


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
                Utility.cadastrar(center,id,title,type,phys);
            }
        });

        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent o) {
                Utility.cadastrar(center,id,title,type,phys);
            }
        });

        visu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent o) {
                int id_obra = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número do usuário: ",
                        "Visualizar obra", JOptionPane.INFORMATION_MESSAGE));

                JLabel one = new JLabel("Número id: \"" + id_obra +"\".");
                JLabel two = new JLabel("Título da obra: \"" + null +"\".");
                JLabel three = new JLabel("Tipo: \"" + null +"\".");
                JLabel four = new JLabel("Digital: \"" + null +"\".");

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

Listar acervo (lista todas as obras e fornece botão para visualizar uma determinada obra)

Visualizar detalhes da obra (Mostra detalhes de uma obra e deverá conter botão para emprestar)

Acessar obra digital (livros, fotografia, MidiaAudio).


*/
    /* Func
    Cadastrar/visualizar/editar/excluir (livros, usuários)
    Devolução/Renovação.
     */

