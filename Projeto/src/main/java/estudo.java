import java.awt.*;

import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class estudo extends JFrame{

    JLabel lbltitulo, lblinstrutor;
    JLabel lbliniciodat, lblfimdat, lblListaCursos;
    JTextField txttitulo, txtintrutor, txtiniciodat, txtfimdat;
    JList jlistodos;
    DefaultListModel mdlListaClientes;
    ArrayList<Cursos> ltscursos = new ArrayList<Cursos>();
    public void NovoCurso()
    {
        String titulo, instrutor, InDat, outDat;
        int iniciodat, fimdat;
        InDat = txtiniciodat.getText();
        outDat = txtfimdat.getText();
        titulo = txttitulo.getText();
        instrutor   = txtintrutor.getText();
        iniciodat = Integer.parseInt(InDat);
        fimdat = Integer.parseInt(outDat);

        Cursos csos = new Cursos(titulo, instrutor, iniciodat, fimdat);
        jlistodos.add(csos);

        JOptionPane.showMessageDialog(rootPane, "Novo curso criado: " +
                csos.titulo);

        lblNumeroClientes.setText(" Total clientes : "+lstClientes.size());

        AtualizarLista();
    }
    estudo()
    {
        lblListaCursos = new JLabel("Lista de cursos");
        lbltitulo = new JLabel("titular");
        txttitulo = new JTextField();
        lblinstrutor = new JLabel("Instrutor");
        txtintrutor = new JTextField();
        lbliniciodat = new JLabel("Data de inicio");
        txtiniciodat = new JTextField();
        lblfimdat = new JLabel("Data de fim");
        txtfimdat = new JTextField();
        mdlListaClientes = new DefaultListModel();
        jlistodos = new JList(mdlListaClientes);

        JPanel formulario = new JPanel();
        formulario.setBackground(Color.LIGHT_GRAY);
        formulario.setLayout(new GridLayout(4, 2));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formulario.add(lbltitulo);
        formulario.add(txttitulo);
        formulario.add(lblinstrutor);
        formulario.add(txtintrutor);
        formulario.add(lbliniciodat);
        formulario.add(txtiniciodat);
        formulario.add(lblfimdat);
        formulario.add(txtfimdat);
        JScrollPane listScroller = new JScrollPane(jlistodos);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        JPanel listPane = new JPanel();
        listPane.setBackground(Color.black);
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(lblListaCursos);
        listPane.add(Box.createRigidArea(new Dimension(0,5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        Container contentPane = getContentPane();
        contentPane.add(formulario, BorderLayout.NORTH);
        contentPane.add(listPane, BorderLayout.CENTER);
    }
    public static void main(String[] args)
    {
        JFrame a = new estudo();
        a.setTitle("Primeira Janela");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setBounds(300, 300, 400, 400);
        a.setVisible(true);
    }
    public class Cursos
    {
        /*JLabel lbltitulo, lblinstrutor;
        JLabel lbliniciodat, lblfimdat, lblListaCursos;
        JTextField txttitulo, txtintrutor, txtiniciodat, txtfimdat;

         */
        private String titulo, intrutor;
        private int datin, datfim;

        Cursos(String ti, String in, int dain, int daout)
        {
            this.titulo = ti;
            this.intrutor = in;
            this.datfim = daout;
            this.datin = dain;

        }

        public int getDatfim() {
            return datfim;
        }

        public int getDatin() {
            return datin;
        }

        public String getIntrutor() {
            return intrutor;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setDatfim(int datfim) {
            this.datfim = datfim;
        }

        public void setDatin(int datin) {
            this.datin = datin;
        }

        public void setIntrutor(String intrutor) {
            this.intrutor = intrutor;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
    }

}

