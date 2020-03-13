package calculator;

import javax.swing.*;
import java.rmi.Naming;

public class CalculatorClient {

    public static final String URL = "//localhost:1020/CalculatorService";

    public static void main(String[] args) {
        try {
            final Calculator c = (Calculator) Naming.lookup(URL);
            final int valor1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Primeiro valor:"));
            final String operacao = JOptionPane.showInputDialog(null, "Operação (+ - / *):");
            final int valor2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Segundo valor"));
            switch (operacao) {
                case "+":
                    JOptionPane.showMessageDialog(null, "Resultado: " + c.add(valor1, valor2));
                    break;

                case "-":
                    JOptionPane.showMessageDialog(null, "Resultado: " + c.sub(valor1, valor2));
                    break;

                case "*":
                    JOptionPane.showMessageDialog(null, "Resultado: " + c.mul(valor1, valor2));
                    break;

                case "/":
                    JOptionPane.showMessageDialog(null, "Resultado: " + c.div(valor1, valor2));
                    break;
            }
        } catch (final Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
        }
    }

}
