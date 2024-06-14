package paint;

public class Paint {

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista(modelo);
        Controlador controlador = new Controlador(modelo, vista);
        vista.setVisible(true);       
       
    }

}
