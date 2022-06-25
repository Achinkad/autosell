package vista.oficinas;

import javax.swing.*;

public class JanelaOficinas extends JFrame {
    private JPanel painelOficinas;

    public JanelaOficinas() {
        setContentPane(painelOficinas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
