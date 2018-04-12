/*
Este programa realizado en java es la interfaz donde el usuario podrá  navegar 
con los mensajes el cual se enviará desde la interfaz para la comunicaión 
serial con arduino a la pantalla LDC así como también recibe los datos de la humedad 
y temperatura estos datos solo se podrá imprimir en una etiqueta de la interfaz el 
cual solo podra recibir un dato a la ves y lo mostrará ya que la comunicación serial
asi lo permite.
 */
package comunicacion_arduino_java;
//Uso de librerias de PanamaHitek_Arduino-3.0.0 para realizar 
//la comunicación de arduino con java.

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import comunicacion.Ventana;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
//Uso de librerias de java swing para el manejo de los eventos de
//botones y el combo box.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
//Uso de librerias para instanciar los elementos de java swing.
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Toño Moreno
 */
public class window extends JFrame {

    private final JLabel etiqueta;
    private final JLabel etiqueta2;
    private final JLabel com, temperatura, humedad, mensaje;
    private final JButton comunicacion, Enviar, cerrar;
    private JTextField temp, hum, texto;
    private JComboBox puerto;
    String combo[] = {"COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "COM10"};
    String puerta = "COM1";

//Constructor en cual se instancia los controles como lo son los botones,
//cajas de texto,etiquetas y combo bos.
    window() {
        super("Comunicación");
//Uso de esquema setLayout. 
        setLayout(null);
//Se instancia los controles.

//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        etiqueta = new JLabel("Puerto: ");
        etiqueta.setBounds(10, 10, 150, 20);
        add(etiqueta);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        puerto = new JComboBox(combo);
        puerto.setBounds(90, 10, 100, 20);
        puerto.setMaximumRowCount(6);
        add(puerto);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        comunicacion = new JButton("Comunicar");
        comunicacion.setBounds(90, 40, 100, 20);
        add(comunicacion);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        etiqueta2 = new JLabel("Estado: ");
        etiqueta2.setBounds(10, 80, 100, 20);
        add(etiqueta2);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        com = new JLabel("Desconectado: ");
        com.setBounds(90, 80, 100, 20);
        add(com);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        temperatura = new JLabel("Temperatura: ");
        temperatura.setBounds(10, 110, 100, 20);
        add(temperatura);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        temp = new JTextField(" ", 25);
        temp.setBounds(90, 110, 100, 20);
        add(temp);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        humedad = new JLabel("Humedad: ");
        humedad.setBounds(10, 140, 100, 20);
        add(humedad);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        hum = new JTextField(" ", 25);
        hum.setBounds(90, 140, 100, 20);
        add(hum);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        mensaje = new JLabel("Mensaje de comunicación: ");
        mensaje.setBounds(10, 170, 150, 20);
        add(mensaje);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        texto = new JTextField(" ", 25);
        texto.setBounds(10, 200, 200, 20);
        add(texto);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        Enviar = new JButton("Enviar");
        Enviar.setBounds(10, 260, 120, 20);
        add(Enviar);
//Se inicializa el control con parámetro correspondiente,
//y se asigna la posición y tamañano de estos mismo,
//y se añande al JFrame.
        cerrar = new JButton("Cerra");
        cerrar.setBounds(140, 260, 120, 20);
        add(cerrar);

//Se termina  de instanciar y agregar los controles.        
//Se crea un objeto de la clase manejadora.
        Manejadora obj = new Manejadora();
        comunicacion.addActionListener(obj);
        Enviar.addActionListener(obj);
        cerrar.addActionListener(obj);

    }//Fin del constructor.

//Se crea una clase externa Manejadora el cual implementa ActionListener 
//y ItemListener donde contiene el metodo abstracto actionPerformed que dara 
//la acción al ocurrir un evento.
    public class Manejadora implements ActionListener, ItemListener {

        @Override
//Metodo que dara toda la funcionalidad de los botones comunicación, enviar y cerrar.
        public void actionPerformed(ActionEvent e) {
//Botón para hacer la comunicación.
            if (e.getSource() == comunicacion) {
//Se realiza una condición para seleccionar el puerto de varias opciones  y se asigna 
//como puerta de la comunicación.
                if (puerto.getSelectedItem() == "COM1") {
                    puerta = "COM1";
                }
                if (puerto.getSelectedItem() == "COM2") {
                    puerta = "COM2";
                }
                if (puerto.getSelectedItem() == "COM3") {
                    puerta = "COM3";
                }
                if (puerto.getSelectedItem() == "COM4") {
                    puerta = "COM4";
                }
                if (puerto.getSelectedItem() == "COM5") {
                    puerta = "COM5";
                }
                if (puerto.getSelectedItem() == "COM6") {
                    puerta = "COM6";
                }
                if (puerto.getSelectedItem() == "COM7") {
                    puerta = "COM7";
                }
                if (puerto.getSelectedItem() == "COM8") {
                    puerta = "COM8";
                }
                if (puerto.getSelectedItem() == "COM9") {
                    puerta = "COM9";
                }
                if (puerto.getSelectedItem() == "COM18") {
                    puerta = "COM18";
                }
                try {
                    ino.arduinoRXTX(puerta, 9600, listener);
                    com.setText("Conectado");
                    com.setForeground(new java.awt.Color(0, 204, 0));
                } catch (ArduinoException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    com.setText("Desconectado");
                    com.setForeground(new java.awt.Color(255, 0, 0));
                }
            }
//Botón para enviar el mensaje de comunicación al arduino.            
            if (e.getSource() == Enviar) {
                try {
//Se obtiene el mensaje de la caja de texto y envia el dato a arduino por medio 
//de la comunicación serial y limpria la caja de texto.
                    ino.sendData(texto.getText() + "");
                    texto.setText("");
                } catch (ArduinoException | SerialPortException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//Cierra la venta de la intefaz creada.
            if (e.getSource() == cerrar) {
                dispose();
            }

        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
//Se crea una instancia de la liberia agregada de PanamaHitek_Arduino-3.0.0  el cual contiene distintas clases
//que nos serviran para realizar la comunicación por el serial con los 
//respectivos métodos que contiene y manejo de la excepciones.
    private PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable()) {
                    temp.setText(ino.printMessage() + "º C");
                    hum.setText(ino.printMessage() + " %");
                    //temp.setText("º C");
                    //hum.setText(ino.printMessage() + " %");

                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
}
//Fin de la clase window.
