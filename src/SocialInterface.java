import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SocialInterface extends JFrame {
    private JTabbedPane PanelPrincipal;
    private JTextField txtnombre;
    private JTextField txtID;
    private JTextField txtEdad;
    private JTextField txtamigos;
    private JButton agregarButton;
    private JTextField txtprioridad;
    private JTextField txtIDBusqueda;
    private JButton btnIDBusqueda;
    private JButton btnPrioridadBusqueda;
    private JTextArea txtResultadoBusqueda;
    private JButton btnQumarDato;
    private JTextArea textArea1;
    private JButton activarTodosButton;
    private JButton activarSiguienteButton;
    private JButton eliminarUltimoButton;
    private JButton eliminarTodosButton;
    private JButton restaurarEleminadosCompletoButton;
    private JButton restauraraUltimoEliminadoButton;
    private JButton imprimirColaButton;
    private JButton imprimilPrioriaddButton;
    private JButton imprimirPilaButton;
    private JTextArea txtRespuesta;
    private Persona persona1;
    private Persona persona2;
    private SocialNetwork Sc;
public SocialInterface(String title) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(PanelPrincipal);
    this.pack();//ajusta el tamaño de la ventana
    Sc=new SocialNetwork();


    agregarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            agregarPersona();

        }
    });
    btnIDBusqueda.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buscarPorID();
        }
    });
    btnPrioridadBusqueda.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            bucarPrioridad();
        }
    });
    btnQumarDato.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            QuemarDatos();
        }
    });
    activarTodosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            activarTodos();
        }
    });
    activarSiguienteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            activarSigueinte();
        }
    });
    eliminarUltimoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eleminarultimo();
        }
    });
    restaurarEleminadosCompletoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            restaueliminarCompleto();
        }
    });
    restauraraUltimoEliminadoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            restaurarelultimo();
        }
    });
    eliminarTodosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarTodoo();
        }
    });
    imprimirPilaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtRespuesta.setText(Sc.ImprimirPila());
        }
    });
}

    private void eliminarTodoo() {
    Sc.eliminarTodos();
    }

    private void restaurarelultimo() {
    Sc.restaurarUltimo();
    }

    private void restaueliminarCompleto() {
    Sc.restaurarTodo();
    }

    private void eleminarultimo() {
    Sc.eliminarUltimo();
    }

    private void activarSigueinte() {
        Sc.activarSigueinte();
    }

    private void activarTodos() {
    Sc.activarTodos();
    }

    private void QuemarDatos() {
        Sc.getColaPersonas().add(new Persona("1","Camila",12,12,12));
        Sc.getColaPersonas().add(new Persona("2","Camila2",12,20,23));
        Sc.getColaPersonas().add(new Persona("3","Camila3",12,30,23));
        Sc.getColaPersonas().add(new Persona("4","Camila4",12,40,34));
        Sc.getColaPersonas().add(new Persona("5","Camila5",12,50,45));
        Sc.getColaPersonas().add(new Persona("6","Camila6",12,60,16));
    }

    private void bucarPrioridad() {
    txtResultadoBusqueda.setText(Sc.BusquedaPrioridad());
    }

    private void buscarPorID() {
        txtResultadoBusqueda.setText("");
        persona2=Sc.BusquedaID(txtIDBusqueda.getText());
        if(persona2!=null){
            txtResultadoBusqueda.setText("Pesona encontrada: "+persona2.getNombreCompleto()+"ID: "+persona2.getId());
        }
        else{
            txtResultadoBusqueda.setText("No se encontraron coincidencias");
        }
    }

    private void agregarPersona() {
        System.out.println("que mismo"+Sc.ValidarIngreso(txtnombre.getText()));
        System.out.println("Nombre: "+txtnombre.getText());
    if(Sc.ValidarIngreso(txtnombre.getText())==true){
        persona1=new Persona(txtID.getText(),txtnombre.getText(),Integer.parseInt(txtEdad.getText()),Integer.parseInt(txtprioridad.getText()),Integer.parseInt(txtamigos.getText()));
        Sc.getColaPersonas().add(persona1);
        JOptionPane.showMessageDialog(null, "Persona Agregada");
        System.out.println("Cola tamanio"+Sc.getColaPersonas().size());

    }
    else{
        JOptionPane.showMessageDialog(null, "Nombre no válido");
    }

    }


    public static void main(String[] args) {
        JFrame buscador= new SocialInterface("Prueba");
        buscador.setVisible(true);
    }


}
