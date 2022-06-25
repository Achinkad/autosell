package vista.veiculos;

import javax.swing.*;

public class JanelaVeiculos extends JFrame{
    private JPanel painelVeiculos;

    public JanelaVeiculos() {
        setContentPane(painelVeiculos);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
