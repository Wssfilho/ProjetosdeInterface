import java.awt.BorderLayout;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class estudo extends JFrame{

    JLabel lbltitulo, lblinstrutor;
    JLabel lbliniciodat, lblfimdat;
    JTextField txttitulo, txtintrutor, txtiniciodat, txtfimdat;
    JList listodos;
    DefaultListModel mdlListaClientes;
    //ArrayList<cursos> ltscursos = new ArrayList<cursos>();

    estudo()
    {
        lbltitulo = new JLabel("titular");
        txttitulo = new JTextField();
        lblinstrutor = new JLabel("Instrutor");
        txtintrutor = new JTextField();
        lbliniciodat = new JLabel("iniciodata");
        txtiniciodat = new JTextField();
        lblfimdat = new JLabel("fimdata");
        txtfimdat = new JTextField();
        mdlListaClientes = new DefaultListModel();
        listodos = new JList(mdlListaClientes);
        JPanel formulario = new JPanel();
        formulario.setLayout(new GridLayout(4, 2));
        formulario.add(lbltitulo);
        formulario.add(txttitulo);
        formulario.add(lblinstrutor);
        formulario.add(txtintrutor);


    }
    public static void main(String[] args)
    {
        JFrame a = new estudo();
        a.setTitle("Primeira Janela");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setBounds(300, 300, 400, 400);
        a.setVisible(true);
    }



}

