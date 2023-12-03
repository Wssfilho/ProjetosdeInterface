import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class estudo extends JFrame {
    JLabel caixa;
    JTextField txt_qual;
    JButton salvar;
    DefaultListModel mdlista;

    //ArrayList<>
    estudo()
    {
        caixa = new JLabel("Caixa");
        txt_qual = new JTextField();
        salvar = new JButton("Salvar");

    }
    public static void main(String[] args)
   {
       JFrame f = new ExemploUI();
       f.setTitle("Primeira Janela");
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setBounds(300, 300, 400, 400);
       f.setVisible(true);
   }
    private class EventoHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {

        }
    }


}
