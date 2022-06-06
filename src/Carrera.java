import java.util.ArrayList;
import java.util.List;

public class Carrera {

    ArrayList<Competidor> competidores = new ArrayList<>();

    int metros;

    Carrera(int metros) {
        this.metros = metros;
    }

    public void registrarCompetidor(Competidor competidor) {
        if (competidor.caballo.edad < 7){
            boolean existe = false;
            for (Competidor c : competidores) {
                if (c.caballo.nombre.equals(competidor.caballo.nombre)) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                this.competidores.add(competidor);

                // Ordenar por edad
                competidores.sort((c1, c2) -> c1.caballo.edad - c2.caballo.edad);
            } else {
                System.out.println("El caballo ya esta registrado");
            }
        } else {
            System.out.println("El caballo no puede participar porque es muy viejo");
        }
    }


    public List<Caballo> obtenerCaballosOrdernadoPorTiempo() {
        // Copiamos para evitar que se modifique el original
        List<Competidor> competidoresOrdenadosPorTiempo = new ArrayList(competidores);

        // Ordenar la lista por tiempo
        competidoresOrdenadosPorTiempo.sort((c1, c2) -> c1.tiempo - c2.tiempo);

        List<Caballo> caballosOrdenadosPorTiempo = new ArrayList<>();

        // Agregar los caballos a la lista
        for (Competidor competidor: competidoresOrdenadosPorTiempo) {
            caballosOrdenadosPorTiempo.add(competidor.caballo);
        }

        return caballosOrdenadosPorTiempo;
    }
}
