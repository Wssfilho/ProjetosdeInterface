import java.awt.*;

import static java.awt.Component.LEFT_ALIGNMENT;

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
    JButton btnSalvar, btnCancelar;
    JLabel lbltitulo, lblinstrutor;
    JLabel lbliniciodat, lblfimdat, lblListaCursos;
    JTextField txttitulo, txtintrutor, txtiniciodat, txtfimdat;
    JList jlistodos;
    DefaultListModel lientes;
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
        ltscursos.add(csos);

        JOptionPane.showMessageDialog(rootPane, "Novo curso criado: " +
                csos.titulo);
        
        AtualizarLista();

    }
    public void AtualizarLista()
    {
        int i;
        lientes.clear();
        for(Cursos aux : ltscursos)
        {
            // DefaultListModel atribuído ao JList
            lientes.addElement("titulo: " + aux.getTitulo() +" , " + "Instrutor: " + aux.getIntrutor());

        }
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
        lientes = new DefaultListModel();
        jlistodos = new JList(lientes);
        btnSalvar   = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        JPanel formulario = new JPanel();
        formulario.setBackground(Color.LIGHT_GRAY);
        formulario.setLayout(new GridLayout(5, 2));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formulario.add(lbltitulo);
        formulario.add(txttitulo);
        formulario.add(lblinstrutor);
        formulario.add(txtintrutor);
        formulario.add(lbliniciodat);
        formulario.add(txtiniciodat);
        formulario.add(lblfimdat);
        formulario.add(txtfimdat);
        formulario.add(btnSalvar);
        formulario.add(btnCancelar);
        JScrollPane listScroller = new JScrollPane(jlistodos);
        listScroller.setPreferredSize(new Dimension(300, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        JPanel listPane = new JPanel();

        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(lblListaCursos);
        listPane.add(Box.createRigidArea(new Dimension(2,5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        Container contentPane = getContentPane();
        contentPane.add(formulario, BorderLayout.NORTH);
        contentPane.add(listPane, BorderLayout.CENTER);

        EventoHandler handler = new EventoHandler();
        btnSalvar.addActionListener(handler);
        btnCancelar.addActionListener(handler);
    }
    private class EventoHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String string = "";

            if (event.getSource() == btnSalvar)
            {
                NovoCurso();

            }
            else if (event.getSource() == btnCancelar)
            {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
            }

        }
    }
    public static void main(String[] args)
    {
        JFrame a = new estudo();
        a.setTitle("Cadastro de cursos");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setBounds(300, 300, 400, 400);
        a.setVisible(true);
    }
    public class Cursos
    {

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

