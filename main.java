import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        Historico historico = new Historico();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== CALCULADORA SIMPLES ===");
            System.out.println("1 - Calcular");
            System.out.println("2 - Ver histórico");
            System.out.println("3 - Limpar histórico");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            int menu = entrada.nextInt();

            switch (menu) {
                case 1 -> {
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
                        case 1 -> operacaoSelecionada = Operacao.SOMA;
                        case 2 -> operacaoSelecionada = Operacao.SUBTRACAO;
                        case 3 -> operacaoSelecionada = Operacao.MULTIPLICACAO;
                        case 4 -> operacaoSelecionada = Operacao.DIVISAO;
                        default -> {
                            System.out.println("Opção inválida!");
                            continue;
                        }
                    }

                    try {
                        double resultado = calc.calcular(num1, num2, operacaoSelecionada);
                        System.out.println("Resultado: " + resultado);

                        // histórico
                        String simbolo = switch (operacaoSelecionada) {
                            case SOMA -> "+";
                            case SUBTRACAO -> "-";
                            case MULTIPLICACAO -> "*";
                            case DIVISAO -> "/";
                        };
                        historico.adicionar(num1 + " " + simbolo + " " + num2 + " = " + resultado);

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 2 -> historico.exibir();
                case 3 -> {
                    historico.limpar();
                    System.out.println("Histórico limpo com sucesso!");
                }
                case 4 -> {
                    System.out.println("Encerrando...");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }

        entrada.close();
    }
}
