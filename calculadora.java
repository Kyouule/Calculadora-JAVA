public class calculadora {

    public double calcular(double num1, double num2, Operacao operacao) {
        switch (operacao) {
            case SOMA:
                return num1 + num2;
            case SUBTRACAO:
                return num1 - num2;
            case MULTIPLICACAO:
                return num1 * num2;
            case DIVISAO:
                if (num2 == 0) {
                    throw new IllegalArgumentException("Erro: divisão por zero não é permitida!");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operação inválida!");
        }
    }''
}

