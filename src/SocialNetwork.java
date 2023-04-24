import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SocialNetwork {

    private PriorityQueue<Persona> prioridadPersonas;
    private Queue<Persona> colaPersonas;
    private Stack<Persona> historial;

    public SocialNetwork() {
        this.prioridadPersonas = new PriorityQueue<>();
        this.colaPersonas = new LinkedList<>();
        this.historial = new Stack<Persona>();
    }

    public PriorityQueue<Persona> getPrioridadPersonas() {
        return prioridadPersonas;
    }

    public void setPrioridadPersonas(PriorityQueue<Persona> prioridadPersonas) {
        this.prioridadPersonas = prioridadPersonas;
    }

    public Queue<Persona> getColaPersonas() {
        return colaPersonas;
    }

    public void setColaPersonas(Queue<Persona> colaPersonas) {
        this.colaPersonas = colaPersonas;
    }

    public Stack<Persona> getHistorial() {
        return historial;
    }

    public void setHistorial(Stack<Persona> historial) {
        this.historial = historial;
    }

    public Persona BusquedaID(String ID){
        Queue<Persona> colaPersonasCopia=new LinkedList<>();
        Persona p1;
        colaPersonasCopia.addAll(colaPersonas);

        while(!colaPersonasCopia.isEmpty()) { // Mientras la cola no esté vacía
            p1=colaPersonasCopia.poll();
            if(p1.getId()==ID){
                return p1;
            }
        }
        return null;
    }
    public String BusquedaPrioridad(){
        Queue<Persona> colaPersonasCopia=new LinkedList<>();
        Persona p1;
        String acumulador="";
        colaPersonasCopia.addAll(colaPersonas);
        while(!colaPersonasCopia.isEmpty()) { // Mientras la cola no esté vacía
            p1=colaPersonasCopia.poll();
            if(p1.getPrioridad()>50){
                acumulador=acumulador+"Persona "+p1.getId()+"\n";
            }
        }
        return acumulador;

    }
    public boolean ValidarIngreso(String Nombre){
        Queue<Persona> colaPersonasCopia=new LinkedList<>();
        Persona p1;
        String acumulador="";
        colaPersonasCopia.addAll(colaPersonas);
        System.out.println("BACK"+colaPersonasCopia.size());
        while(!colaPersonasCopia.isEmpty()) { // Mientras la cola no esté vacía
            p1=colaPersonasCopia.poll();
            System.out.println(p1.getNombreCompleto());
            if(p1.getNombreCompleto().equals(Nombre)){
                return false;
            }
        }
        return true;
    }

    public void activarTodos(){
        Persona p1;
        while(!colaPersonas.isEmpty()) { // Mientras la cola no esté vacía
            p1=colaPersonas.poll();
            prioridadPersonas.add(p1);
        }
    }
    public void activarSigueinte(){
        Persona p1;
        p1=getColaPersonas().poll();
        prioridadPersonas.add(p1);

    }
    public void eliminarTodos(){
        Persona p1;
        while(!prioridadPersonas.isEmpty()) { // Mientras la cola no esté vacía
            p1=prioridadPersonas.poll();
            historial.push(p1);
        }
    }
    public void eliminarUltimo(){
        Persona p1;
        // Mientras la cola no esté vacía
            p1=prioridadPersonas.poll();
            historial.push(p1);

    }

    public void restaurarTodo(){
        Persona p1;
        while(!historial.isEmpty()) { // Mientras la cola no esté vacía
            p1=historial.pop();
            prioridadPersonas.add(p1);
        }
    }
    public void restaurarUltimo(){
        Persona p1;
        // Mientras la cola no esté vacía
            p1=historial.pop();
            prioridadPersonas.add(p1);

    }

    public String ImprimirPila(){
        String MensajeFinal="";
        Persona p1;
        Stack<Persona> pilaOrden2 = new Stack<Persona>();
        pilaOrden2.addAll(historial);
        while(!pilaOrden2.isEmpty()) { // Mientras la pila no esté vacía
            //System.out.println(pila.pop());// Imprime y desapila el elemento de la cima
            p1=pilaOrden2.pop();
            MensajeFinal="ID: "+p1.getId()+"Nombre: "+p1.getNombreCompleto();
        }
        return MensajeFinal;
    }

}
