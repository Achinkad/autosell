package vista;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Erros {
    private static Map<Integer, String> dicionarioErros = new HashMap<>();

    static {
        dicionarioErros.put(1, "Atributo inválido. Por favor, escolha uma opção.");
        dicionarioErros = Collections.unmodifiableMap(dicionarioErros);
    }

    public static void mostrarErro(Window parent, int numero) {
        if (!dicionarioErros.containsKey(numero)) return;

        JOptionPane.showMessageDialog(
                parent,
                dicionarioErros.get(numero),
                "Erro",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
