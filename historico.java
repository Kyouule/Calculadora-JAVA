import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<String> registros = new ArrayList<>();

    public void adicionar(String registro) {
        registros.add(registro);
    }

    public void exibir() {
        if (registros.isEmpty()) {
            System.out.println("Nenhum cálculo realizado ainda.");
        } else {
            System.out.println("\n=== HISTÓRICO DE CÁLCULOS ===");
            for (String r : registros) {
                System.out.println(r);
            }
            System.out.println("==============================");
        }
    }

    public void limpar() {
        registros.clear();
    }
}
