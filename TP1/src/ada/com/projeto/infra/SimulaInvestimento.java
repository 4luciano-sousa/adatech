package ada.com.projeto.infra;

import java.time.LocalDate;

public class SimulaInvestimento {
	
	public static LocalDate simularInvestimento(double valorAplicado, double taxaJurosMensal, double valorFuturo) {
        LocalDate dataAtual = LocalDate.now();
        double valorAtual = valorAplicado;

        while (valorAtual < valorFuturo) {
            valorAtual += valorAtual * (taxaJurosMensal / 100);
            dataAtual = dataAtual.plusMonths(1);
        }

        return dataAtual;
    }
}