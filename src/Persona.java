public class Persona implements Comparable<Persona> {

    private String id;
    private String NombreCompleto;
    private int edad;
    private int prioridad;
    private int amigos;

    public Persona(String id, String nombreCompleto, int edad, int prioridad, int amigos) {
        this.id = id;
        NombreCompleto = nombreCompleto;
        this.edad = edad;
        this.prioridad = prioridad;
        this.amigos = amigos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getAmigos() {
        return amigos;
    }

    public void setAmigos(int amigos) {
        this.amigos = amigos;
    }

    @Override
    public int compareTo(Persona o) {
        return Integer.compare(o.prioridad,this.prioridad);
    }
}
