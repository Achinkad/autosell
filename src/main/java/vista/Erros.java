package vista;

import modelo.DadosApp;
import modelo.Filial;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Erros {
    private static final Map<Integer, String> dicionarioErros = new HashMap<>();
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    static {
        dicionarioErros.put(1, " inválido(a). Por favor, insira um valor com um mínimo de 2 caracteres e um máximo de 225 caracteres.");
        dicionarioErros.put(2, " inválido(a). Por favor, escolha uma opção.");
        dicionarioErros.put(3, " já existente. Por favor, insira um valor único.");
        dicionarioErros.put(4, " inválido(a). Por favor, insira um valor com um número inteiro e positivo.");
        dicionarioErros.put(5, " inválido(a). Por favor, insira um valor com um número inteiro, positivo e com exatamente 9 dígitos.");
        dicionarioErros.put(6, "E-mail inválido. Por favor, insira um e-mail no formato 'nome@mail.com'.");
        dicionarioErros.put(7, " inválido(a). Por favor, insira um valor com um número inteiro ou nulo, positivo com um máximo de 100.");
        dicionarioErros.put(8, "Já existe outra sede registada no sistema. Por favor, retire a seleção do campo 'Sede' para inserir a filial.");
        dicionarioErros.put(9, " inválido(a). Por favor, insira um valor com um número inteiro, positivo com um máximo de 500.");
        dicionarioErros.put(10, " inválido(a). Por favor, insira um valor com o formato “DD-MM-YYYY” maior ou igual a data atual.");
        dicionarioErros.put(11, " inválido(a). Por favor, insira um valor com o formato “DD-MM-YYYY” maior ou igual a data de início.");
        dicionarioErros.put(12, " inválido(a). Por favor, insira um valor com o formato “DD-MM-YYYY” maior ou igual a data de expedição.");
        dicionarioErros.put(13, " inválido(a). Por favor, insira um valor com o formato “DD-MM-YYYY” maior ou igual a data de receção.");
    }

    public static void mostrarErro(Window parent, int numero, String atributo) {
        if (!dicionarioErros.containsKey(numero)) return;

        String message = null;
        if (numero != 6 && numero != 8) {
            message = dicionarioErros.get(numero);
            dicionarioErros.computeIfPresent(numero, (k, v) -> atributo.concat(v));
        }

        JOptionPane.showMessageDialog(
                parent,
                dicionarioErros.get(numero),
                "Erro",
                JOptionPane.ERROR_MESSAGE
        );

        if (numero != 6 && numero != 8) {
            dicionarioErros.put(numero, message);
        }
    }

    public static boolean validate(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static String removeLastChar(String label) {
        return label.substring(0, label.length() - 1);
    }

    public static boolean checkSede(boolean sede) {
        LinkedList<Filial> filiais = DadosApp.getInstancia().getFiliais();
        for (Filial f : filiais) {
            if (f.isSede()) return true;
        }
        return false;
    }

    public static boolean checkSedeEditavel(boolean sede, Filial filial) {
        LinkedList<Filial> filiais = DadosApp.getInstancia().getFiliais();
        for (Filial f : filiais) {
            if (f.isSede() && !f.equals(filial)) return true;
        }
        return false;
    }
}
