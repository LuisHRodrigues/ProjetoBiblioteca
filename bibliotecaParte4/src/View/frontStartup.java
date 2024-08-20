package View;



import javax.swing.JFrame;

public class frontStartup {
    public static void main (String [] args) {

        JFrame login = new JFrame("Login");

        JFrame menu = new JFrame("Seja bem vinda(o)!");

        JFrame obra = new JFrame("Obras");

        JFrame rese = new JFrame("Reservas");

        JFrame empr = new JFrame("Empréstimos");

        JFrame trab = new JFrame("Submissão de trabalho");

        JFrame user = new JFrame("Usuários");

        //Inicialização, tamanho e largura

        Utility.frameStartup(login,350, 350);

        Utility.frameStartup(menu,405, 365);

        Utility.frameStartup(obra,405, 365);

        Utility.frameStartup(rese,405, 365);

        Utility.frameStartup(trab,810, 360);

        Utility.frameStartup(empr,405, 365);

        Utility.frameStartup(user,810, 500);

        //JLabels e verificações de funcionário

        Login.loginComponents(login, menu);

        Menu.menuComponents(menu,obra,rese,empr,trab,user,login);

        Emprestimo.empComponents(empr, menu);

        Obra.obraComponents(obra, menu);

        Reserva.reservaComponents(rese, menu);

        Trabalho.trabComponents(trab, menu);

        Usuarios.userComponents(menu, user);

        //Inicialização da tela de login ao começo do programa

        login.setVisible(true);
    }
}