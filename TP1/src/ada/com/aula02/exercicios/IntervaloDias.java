package ada.com.aula02.exercicios;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class IntervaloDias {
	
	public static void main(String[] args) {
		
		// 1 - Escreva um método que conta o número de dias entre 2 datas;
        LocalDate date1 = LocalDate.of(2023, 5, 1);
        LocalDate date2 = LocalDate.now();
        var quantidadeDias = daysBetween(date1, date2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String resultado = String.format(
        "A quantidade de dias entre %S e %S é de %d dias", date1.format(formatter), date2.format(formatter), quantidadeDias);
        System.out.println(resultado);
		
	}

	private static Object daysBetween(LocalDate date1, LocalDate date2) {
		// TODO Auto-generated method stub
		return null;
	}

}
