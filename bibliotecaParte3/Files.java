import java.io.File;

public class Files {
    private static final String ABSOLUTE_PATH = "C:\\biblioteca_dados";
    private static final String USUARIOS_FILE = ABSOLUTE_PATH + "\\usuarios.txt";
    private static final String OBRA_FILE = ABSOLUTE_PATH + "\\livros.txt";
    private static final String EMPRESTIMOS_FILE = ABSOLUTE_PATH + "\\emprestimos.txt";
    private static final String RESERVAS_FILE = ABSOLUTE_PATH + "\\reservas.txt";

    public static String getAbsolutePath() {
        return ABSOLUTE_PATH;
    }

    public static String getUsuariosFile() {
        return USUARIOS_FILE;
    }

    public static String getObraFile() {
        return OBRA_FILE;
    }

    public static String getEmprestimosFile() {
        return EMPRESTIMOS_FILE;
    }

    public static String getReservasFile() {
        return RESERVAS_FILE;
    }
}
