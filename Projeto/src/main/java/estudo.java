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

    JLabel      lblCodigo, lblNome; // Criação de variáveis para os rótulos dos campos de código e nome
    JLabel      lblNumeroClientes; // Rótulo para o número de clientes
    JTextField  txtCodigo, txtNome; // Campos de texto para entrada de código e nome
    JButton     btnSalvar, btnCancelar; // Botões para salvar e cancelar

    JLabel      lblListaClientes; // Rótulo para a lista de clientes
    JList       jlstClientes; // Lista para exibir os clientes
    DefaultListModel mdlListaClientes; // Modelo de lista para armazenar os clientes

    ArrayList<Cliente> lstClientes = new ArrayList<Cliente>(); // Lista para armazenar os objetos Cliente

    estudo()
    {
        // Inicialização dos componentes da interface
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

        // Criação do manipulador de eventos e associação aos botões
        EventoHandler handler = new EventoHandler();
        btnSalvar.addActionListener(handler);
        btnCancelar.addActionListener(handler);

        // Configuração do painel do formulário
        JPanel formularioPane = new JPanel();
        formularioPane.setLayout(new GridLayout(4, 2));
        formularioPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formularioPane.add(lblCodigo);
        formularioPane.add(txtCodigo);
        formularioPane.add(lblNome);
        formularioPane.add(txtNome);
        formularioPane.add(btnSalvar);
        formularioPane.add(btnCancelar);
        formularioPane.add(lblNumeroClientes);

        // Configuração do painel da lista de clientes
        JScrollPane listScroller = new JScrollPane(jlstClientes);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);

        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(lblListaClientes);
        listPane.add(Box.createRigidArea(new Dimension(0,5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Adição dos painéis ao painel principal
        Container contentPane = getContentPane();
        contentPane.add(formularioPane, BorderLayout.NORTH);
        contentPane.add(listPane, BorderLayout.CENTER);

    }

    public void NovoCliente()
    {
        // Método para criar um novo cliente e adicionar à lista
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
        // Método para atualizar a lista de clientes na interface
        int i;
        mdlListaClientes.clear();
        for(Cliente aux : lstClientes)
        {
            mdlListaClientes.addElement(aux.getNome());
        }
    }

    public static void main(String[] args)
    {
        // Método principal para iniciar a aplicação
        JFrame f = new ExemploUI();
        f.setTitle("Primeira Janela");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(300, 300, 400, 400);
        f.setVisible(true);
    }

    // Classe interna para manipulação de eventos
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
                JOptionPane.showMessageDialog(null, "Operação cancelada."); // Exibe uma mensagem de diálogo informando que a operação foi cancelada



            }
        }

    }

// Classe Cliente para representar um cliente
public class Cliente
{
    private int codigo; // Código do cliente
    private String nome; // Nome do cliente

    // Construtor da classe Cliente
    Cliente(int pCodigo, String pNome)
    {
        this.codigo = pCodigo; // Inicializa o código do cliente com o valor passado
        this.nome   = pNome; // Inicializa o nome do cliente com o valor passado
    }

    // Método getter para o código do cliente
    public int getCodigo() {
        return codigo;
    }

    // Método setter para o código do cliente
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Método setter para o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para o nome do cliente
    public String getNome() {
        return nome;
    }
}

}

