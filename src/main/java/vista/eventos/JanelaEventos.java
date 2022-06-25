package vista.eventos;

import javax.swing.*;

public class JanelaEventos extends JFrame {
    private JPanel painelEventos;

    public JanelaEventos() {
        setContentPane(painelEventos);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
