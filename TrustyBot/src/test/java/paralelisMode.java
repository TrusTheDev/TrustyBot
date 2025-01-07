public class paralelisMode {

    public static class TeclaPresionada implements Runnable {

        private String tecla;

        // Constructor para recibir la tecla que se presiona
        public TeclaPresionada(String tecla) {
            this.tecla = tecla;
        }

        // Este es el código que se ejecutará cuando el hilo sea lanzado
        @Override
        public void run() {
            try {
                // Simula el toque de la tecla
                System.out.println("Tecla " + tecla + " presionada.");
                Thread.sleep(1000);  // Simula que la tecla se mantiene presionada por 1 segundo
                System.out.println("Tecla " + tecla + " soltada.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Método para crear y ejecutar un hilo
        public static void presionarTecla(String tecla) {
            // Creamos un objeto Runnable que representa el toque de la tecla
            Runnable tarea = new TeclaPresionada(tecla);

            // Creamos un nuevo hilo para ejecutar la tarea
            Thread hilo = new Thread(tarea);

            // Iniciamos el hilo
            hilo.start();
        }

        public static void main(String[] args) {
            // Simulamos la presión de varias teclas
            presionarTecla("A");
            presionarTecla("B");
            presionarTecla("C");

            // Esperamos un poco para que los hilos terminen de ejecutarse
            try {
                Thread.sleep(2000);  // Dormir el hilo principal para esperar a los hilos secundarios
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
