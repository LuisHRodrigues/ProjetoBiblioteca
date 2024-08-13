package View;



import javax.swing.JFrame;

public class frontStartup {
    public static void main (String [] args) {
        JFrame login = new JFrame("Login");

        JFrame menuUser = new JFrame("Seja bem vinda(o)!");
        JFrame menuFunc = new JFrame("Administrador");

        JFrame obra = new JFrame("Obras");
        JFrame obraFun = new JFrame("Obras");

        JFrame rese = new JFrame("Reservas");
        JFrame reseFun = new JFrame("Reserva: ADM");

        JFrame trab = new JFrame("Trabalhos");
        JFrame trabFun = new JFrame("Trabalhos: ADM");

        JFrame empr = new JFrame("Empréstimos");
        JFrame emprFun = new JFrame("Empréstimos: ADM");

        JFrame user = new JFrame("Usuários");

        //Inicialização, tamanho e largura

        Utility.frameStartup(login,350, 350);

        Utility.frameStartup(menuUser,405, 325);
        Utility.frameStartup(menuFunc,405, 365);

        Utility.frameStartup(obra,405, 325);
        Utility.frameStartup(obraFun,405, 365);

        Utility.frameStartup(rese,405, 325);
        Utility.frameStartup(reseFun,405, 365);

        Utility.frameStartup(trab,405, 325);
        Utility.frameStartup(trabFun,405, 365);

        Utility.frameStartup(empr,405, 325);
        Utility.frameStartup(emprFun,405, 365);

        Utility.frameStartup(user,405, 325);

        //JLabels e verificações de funcionário

        Login.loginComponents(login, menuUser, menuFunc);

        Menu.menuComponents(menuUser,obra,rese,empr,trab);
        Menu.menuComponents(menuFunc,obraFun,reseFun,emprFun,trabFun);

        Emprestimo.empComponents(empr);
        Emprestimo.empComponents(emprFun);
        Emprestimo.FuncComp(emprFun, null);

        Menu.FuncComp(menuFunc, user);

        //Inicialização da tela de login ao começo do programa

        login.setVisible(true);
    }
}