package View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Obra implements Utility {

    private static JFrame midia_audio = new JFrame("Mídias de aúdio");
    private static JFrame fotografia = new JFrame("Fotografias");
    private static JFrame livro = new JFrame("Livros");

    public static void startup () {
          Utility.frameStartup(livro, 810, 350);
          Utility.frameStartup(fotografia, 810, 350);
          Utility.frameStartup(midia_audio, 810, 350);
    }
    public static void obraComponents(JFrame Obra) {
        startup();

        JLabel list = new JLabel("Listar acervos");
        JLabel digi = new JLabel("Acessar obra digital");

        list.setBounds(135, 50, 300, 30);
        digi.setBounds(135, 150, 300, 30);

        Obra.add(list);
        Obra.add(digi);

        Utility.retornar(Obra, livro, 600, 25);
        Utility.retornar(Obra, fotografia, 600, 25);
        Utility.retornar(Obra, midia_audio, 600, 25);


        Utility.crud(livro);
        Utility.crud(fotografia);
        Utility.crud(midia_audio);

        digi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String [] opt = {"Livro", "Mídia Aúdio", "Foto1grafia"};
                int tipo = JOptionPane.showOptionDialog(null, "Escolha o tipo de obra:", "Acessar obra digital", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opt, opt);
                switch (tipo) {
                    case 0:
                        Utility.mudarTelas(livro, Obra);
                        break;
                    case 1:
                        Utility.mudarTelas(midia_audio, Obra);
                        break;
                    case 2:
                        Utility.mudarTelas(fotografia, Obra);
                        break;
                }
            }
        });

    }
    public static void FuncComp (JFrame obraFunc, JFrame listObraFunc) {
        JLabel devo = new JLabel("Devolução");
        JLabel reno = new JLabel("Renovação");
        JLabel list = new JLabel("Listar acervo (ADM)");

        devo.setBounds(135, 250, 300, 30);
        reno.setBounds(135, 200, 300, 30);
        list.setBounds(135, 100, 300, 30);

        obraFunc.add(devo);
        obraFunc.add(reno);
        obraFunc.add(list);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Utility.mudarTelas(obraFunc, listObraFunc);
            }
        });
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
}
