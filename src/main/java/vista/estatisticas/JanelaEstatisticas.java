package vista.estatisticas;

import javax.swing.*;

public class JanelaEstatisticas extends JFrame {
    private JPanel painelEstatisticas;

    public JanelaEstatisticas() {
        setContentPane(painelEstatisticas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
