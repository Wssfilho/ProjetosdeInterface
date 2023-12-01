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

public class ExemploUI extends JFrame{

    JLabel      lblCodigo, lblNome; //curso
    JLabel      lblNumeroClientes;
    JTextField  txtCodigo, txtNome; //
    JButton     btnSalvar, btnCancelar;

    JLabel      lblListaClientes;
    JList       jlstClientes;
    DefaultListModel mdlListaClientes;

    //Cliente c;
    ArrayList<Cliente> lstClientes = new ArrayList<Cliente>();

    ExemploUI()
    {
        lblCodigo = new JLabel("Código");
        txtCodigo = new JTextField();
        lblNome = new JLabel("Nome");
        txtNome = new JTextField();
        btnSalvar   = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");
        lblNumeroClientes = new JLabel("Total clientes: 0");



        lblListaClientes = new JLabel("Lista de Clientes");
        mdlListaClientes = new DefaultListModel();
        jlstClientes = new JList(mdlListaClientes);

        EventoHandler handler = new EventoHandler();
        btnSalvar.addActionListener(handler);
        btnCancelar.addActionListener(handler);

        JPanel formularioPane = new JPanel();
        // Gerenciador de Layout
        formularioPane.setLayout(new GridLayout(4, 2));
        // UMa borda em volta
        formularioPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Adicionando os controles
        formularioPane.add(lblCodigo);
        formularioPane.add(txtCodigo);
        formularioPane.add(lblNome);
        formularioPane.add(txtNome);
        formularioPane.add(btnSalvar);
        formularioPane.add(btnCancelar);
        formularioPane.add(lblNumeroClientes);

        // Parte 2 : Painel com a lista de clientes

        JScrollPane listScroller = new JScrollPane(jlstClientes);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);

        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(lblListaClientes);
        listPane.add(Box.createRigidArea(new Dimension(0,5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // **** Montando as partes maiores
        // O container da Janela (ContentPane) e
        // Os dois paineis com Formulário (superior-Norte) e Lista (Centro)
        Container contentPane = getContentPane();
        contentPane.add(formularioPane, BorderLayout.NORTH);
        contentPane.add(listPane, BorderLayout.CENTER);

    }

    public void NovoCliente()
    {
        String strCodigo, strNome;
        int iCodigo;
        strCodigo = txtCodigo.getText();
        strNome   = txtNome.getText();
        iCodigo = Integer.parseInt(strCodigo);

        Cliente c = new Cliente(iCodigo, strNome);
        lstClientes.add(c);

        JOptionPane.showMessageDialog(rootPane, "Novo cliente criado: " +
                c.getNome());

        lblNumeroClientes.setText(" Total clientes : "+lstClientes.size());

        AtualizarLista();
    }

    public void AtualizarLista()
    {
        int i;
        mdlListaClientes.clear();
        for(Cliente aux : lstClientes)
        {
            // DefaultListModel atribuído ao JList
            mdlListaClientes.addElement(aux.getNome());
        }
    }

    public static void main(String[] args)
    {
        JFrame f = new ExemploUI();
        f.setTitle("Primeira Janela");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(300, 300, 400, 400);
        f.setVisible(true);
    }

    // classe interna private para tratamento de evento
    private class EventoHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String string = "";

            if (event.getSource() == btnSalvar)
            {
                NovoCliente();

            }
            else if (event.getSource() == btnCancelar)
            {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
            }

        }
    }

    public class Cliente
    {
        private int codigo;
        private String nome;

        Cliente(int pCodigo, String pNome)
        {
            this.codigo = pCodigo;
            this.nome   = pNome;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

}