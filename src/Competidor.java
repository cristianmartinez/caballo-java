public class Competidor {
    Persona jockey;
    Caballo caballo;

    int position;

    int tiempo;

    Competidor(Persona persona, Caballo caballo, int position, int tiempo) {
        this.jockey = persona;
        this.caballo = caballo;
        this.position = position;
        this.tiempo = tiempo;
    }
}
