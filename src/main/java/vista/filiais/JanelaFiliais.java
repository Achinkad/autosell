package vista.filiais;

import javax.swing.*;

public class JanelaFiliais extends JFrame {
    private JPanel painelFiliais;

    public JanelaFiliais () {
        setContentPane(painelFiliais);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
