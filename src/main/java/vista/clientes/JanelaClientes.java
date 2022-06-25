package vista.clientes;

import javax.swing.*;

public class JanelaClientes extends JFrame {
    private JPanel painelClientes;

    public JanelaClientes () {
        setContentPane(painelClientes);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
