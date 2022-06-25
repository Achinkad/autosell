package vista.transacoes;

import javax.swing.*;

public class JanelaTransacoes extends JFrame {
    private JPanel painelTransacoes;

    public JanelaTransacoes() {
        setContentPane(painelTransacoes);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
