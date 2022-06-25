package vista.armazens;

import javax.swing.*;

public class JanelaArmazens extends JFrame {
    private JPanel painelArmazens;

    public JanelaArmazens() {
        setContentPane(painelArmazens);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
