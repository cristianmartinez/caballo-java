import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Torneo {

    List<Carrera> carreras = new ArrayList<>();

    public void registarCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }

    public Caballo caballoConMasCarrerasGanadas() {
        Map<Caballo, Integer> carrerasGanadasPorCaballo = new HashMap<>();

        // Hacemos el acomulador de carreras ganadas
        for (Carrera carrera : carreras) {
            for (Competidor competidor : carrera.competidores) {

                // Por cada carrara encontrada en position 1, incrementa el acomulador de carreras ganadas
                if (competidor.position == 1) {
                    // Si ya existe en el mapa, incrementa el contador
                    if (carrerasGanadasPorCaballo.containsKey(competidor.caballo)) {
                        carrerasGanadasPorCaballo.put(competidor.caballo, carrerasGanadasPorCaballo.get(competidor.caballo) + 1);
                    } else {
                        // Si no existe, lo agrega en el mapa con 1
                        carrerasGanadasPorCaballo.put(competidor.caballo, 1);
                    }
                }
            }
        }

        // Buscar el caballo con mas carreras ganadas
        Caballo caballoConMasCarrerasGanadas = null;
        int maxCarrerasGanadas = 0;

        for (Caballo caballo : carrerasGanadasPorCaballo.keySet()) {
            if (carrerasGanadasPorCaballo.get(caballo) > maxCarrerasGanadas) {
                maxCarrerasGanadas = carrerasGanadasPorCaballo.get(caballo);
                caballoConMasCarrerasGanadas = caballo;
            }
        }

        return caballoConMasCarrerasGanadas;
    }

    public Persona jockeyConMasCarrerasGanadas() {
        Map<Persona, Integer> carrerasGanadasPorPersona = new HashMap<>();

        // Hacemos el acomulador de carreras ganadas
        for (Carrera carrera : carreras) {
            for (Competidor competidor : carrera.competidores) {

                // Por cada carrara encontrada en position 1, incrementa el acomulador de carreras ganadas
                if (competidor.position == 1) {
                    // Si ya existe en el mapa, incrementa el contador
                    if (carrerasGanadasPorPersona.containsKey(competidor.jockey)) {
                        carrerasGanadasPorPersona.put(competidor.jockey, carrerasGanadasPorPersona.get(competidor.jockey) + 1);
                    } else {
                        // Si no existe, lo agrega en el mapa con 1
                        carrerasGanadasPorPersona.put(competidor.jockey, 1);
                    }
                }
            }
        }

        // Buscar el caballo con mas carreras ganadas
        Persona personaConMasCarrerasGanadas = null;
        int maxCarrerasGanadas = 0;

        for (Persona persona : carrerasGanadasPorPersona.keySet()) {
            if (carrerasGanadasPorPersona.get(persona) > maxCarrerasGanadas) {
                maxCarrerasGanadas = carrerasGanadasPorPersona.get(persona);
                personaConMasCarrerasGanadas = persona;
            }
        }

        return personaConMasCarrerasGanadas;
    }


    public Map<String, List<Carrera>> separarCarraras() {
        List<Carrera> carreras1000 = new ArrayList<>();
        List<Carrera> carreras2000 = new ArrayList<>();

        for (Carrera carrera : carreras) {
            if (carrera.metros == 1000) {
                carreras1000.add(carrera);
            } else {
                carreras2000.add(carrera);
            }
        }

        Map<String, List<Carrera>> carreras = new HashMap();
        carreras.put("1000", carreras1000);
        carreras.put("2000", carreras2000);

        return carreras;
    }
}
