import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        System.out.println("=== CALCULADORA SIMPLES ===");
        System.out.print("Digite o primeiro número: ");
        double num1 = entrada.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = entrada.nextDouble();

        System.out.println("Escolha a operação:");
        System.out.println("1 - Soma (+)");
        System.out.println("2 - Subtração (-)");
        System.out.println("3 - Multiplicação (*)");
        System.out.println("4 - Divisão (/)");
        System.out.print("Opção: ");
        int opcao = entrada.nextInt();

        Operacao operacaoSelecionada;

        switch (opcao) {
            case 1:
                operacaoSelecionada = Operacao.SOMA;
                break;
            case 2:
                operacaoSelecionada = Operacao.SUBTRACAO;
                break;
            case 3:
                operacaoSelecionada = Operacao.MULTIPLICACAO;
                break;
            case 4:
                operacaoSelecionada = Operacao.DIVISAO;
                break;
            default:
                System.out.println("Opção inválida!");
                entrada.close();
                return;
        }

        try {
            double resultado = calc.calcular(num1, num2, operacaoSelecionada);
            System.out.println("Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        entrada.close();
    }
}
