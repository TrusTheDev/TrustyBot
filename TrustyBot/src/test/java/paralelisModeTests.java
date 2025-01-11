import java.awt.*;
import javax.swing.JPanel
import static java.lang.Thread.sleep;

public class paralelisModeTests {

    public static class TeclaPresionada implements Runnable {

        private int tecla;

        // Constructor para recibir la tecla que se presiona
        public TeclaPresionada(int tecla) {
            this.tecla = tecla;
        }

        // Este es el código que se ejecutará cuando el hilo sea lanzado

        public void run() {
            try {
                // Simula el toque de la tecla
                Robot robot = new Robot();
                robot.keyPress(tecla);
                sleep(1000);  // Simula que la tecla se mantiene presionada por 1 segundo
                robot.keyRelease(tecla);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }

        // Método para crear y ejecutar un hilo
        public static void presionarTecla(int tecla) {
            // Creamos un objeto Runnable que representa el toque de la tecla
            Runnable tarea = new TeclaPresionada(tecla);

            // Creamos un nuevo hilo para ejecutar la tarea
            Thread hilo = new Thread(tarea);

            // Iniciamos el hilo
            hilo.start();
        }

        public static void main(String[] args) throws InterruptedException {
            // Simulamos la presión de varias teclas
            sleep(1000);
            presionarTecla(65);
            presionarTecla(66);
            presionarTecla(67);

            // Esperamos un poco para que los hilos terminen de ejecutarse
            try {
                sleep(2000);  // Dormir el hilo principal para esperar a los hilos secundarios
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
