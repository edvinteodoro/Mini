public class run {
    public static void main(String[] args) {
    ManejoArchivos manejoArchivos = new ManejoArchivos();
    Escritorio escritorio = new Escritorio(manejoArchivos);
    escritorio.setVisible(true);
    }
}
