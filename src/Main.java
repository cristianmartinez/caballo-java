import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Torneo torneo = Main.crearTorneo();

        // d)Mostrar el nombre del caballo que a obtenido el mayor numero de carreras ganadas
        System.out.println("Caballo con mas carreras ganadas: " + torneo.caballoConMasCarrerasGanadas().nombre);

        // e)Mostrar el nombre del Jockey que ah obtenido el mayor número de carreras ganadas.
        System.out.println("Persona con mas carreras ganadas: " + torneo.jockeyConMasCarrerasGanadas().nombre);

        // f) Separar las carreras en 2 de MIL METROS y DOS MIL metros respectivamente donde se registra la información por orden ascendente de tiempo registrado en los caballos.
        Map<String, List<Carrera>> carrerasPorDistancia = torneo.separarCarraras();

        for (String distancia : carrerasPorDistancia.keySet()) {
            System.out.println("Distancia: " + distancia);

            for (Carrera c : carrerasPorDistancia.get(distancia)) {
                System.out.println("Carrera: " + c.metros);
                List<Caballo> caballos = c.obtenerCaballosOrdernadoPorTiempo();
                for (Caballo caballo : caballos) {
                    System.out.println("Caballo: " + caballo.nombre);
                }
            }
        }
    }

    public static Torneo crearTorneo() {
        Torneo torneo = new Torneo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de carreras: ");
        int numeroDeCarreras = scanner.nextInt();

        for (int j = 0; j < numeroDeCarreras; j++) {
            System.out.println("======== CARRERA " + (j + 1) + " ========");
            System.out.println("Distancia: ");
            int metros = scanner.nextInt();
            Carrera carrera = new Carrera(metros);

            System.out.println("Numero de competidores: ");
            int numeroDeCompetidores = scanner.nextInt();

            torneo.registarCarrera(carrera);

            for (int i = 0; i < numeroDeCompetidores; i++) {
                System.out.println("======== COMPETIDOR " + (i + 1) + " (Competidor) ========");
                System.out.println("Nombre del competidor: ");
                String nombreCompetidor = scanner.next();

                System.out.println("Posicion del competidor: ");
                int posicionDelCaballo = scanner.nextInt();

                System.out.println("Tiempo del competidor: ");
                int tiempoDelCompetidor = scanner.nextInt();

                System.out.println("======== COMPETIDOR " + (i + 1) + " (Caballo) ========");

                System.out.println("Nombre del Caballo: ");
                String nombreDelCaballo = scanner.next();

                System.out.println("Peso del Caballo: ");
                int pesoDelCaballo = scanner.nextInt();

                System.out.println("Edad del Caballo: ");
                int edadDelCaballo = scanner.nextInt();

                Persona persona = new Persona(nombreCompetidor);
                Caballo caballo = new Caballo(nombreDelCaballo, edadDelCaballo, pesoDelCaballo);
                Competidor competidor = new Competidor(persona, caballo, posicionDelCaballo, tiempoDelCompetidor);

                carrera.registrarCompetidor(competidor);
            }
        }

        return torneo;
    }
}
