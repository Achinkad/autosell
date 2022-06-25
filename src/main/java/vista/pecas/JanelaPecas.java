package vista.pecas;

import javax.swing.*;

public class JanelaPecas extends JFrame {
    private JPanel painelPecas;

    public JanelaPecas() {
        setContentPane(painelPecas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
