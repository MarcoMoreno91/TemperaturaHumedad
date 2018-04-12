package comunicacion_arduino_java;
import javax.swing.JFrame;
/**
 *
 * @author Toño Moreno
 */
//Main principal con donde se crea un objeto de la clase window
//en el cual muestra y crea la ventana principal con respectivo
//tamaño, orientación y lo hace visible. 
public class PruebaComunicacion {

    public static void main(String arg[]) {
        window captura = new window();
        captura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        captura.setSize(270, 350);
        captura.setVisible(true);
        captura.setLocation(100, 250);
        captura.setResizable(false);
    }
}
