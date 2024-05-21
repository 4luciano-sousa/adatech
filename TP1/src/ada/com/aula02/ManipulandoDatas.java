package ada.com.aula02;

import java.time.*;

public class ManipulandoDatas {

	public static void main(String[] args) {
		LocalDate data = LocalDate.now();
		System.out.println("Dia da Semana: " + data.getDayOfWeek());
		System.out.println("Três dias antes: " + data.minusDays(3));
		System.out.println("Três dias depois: " + data.plusDays(3));
	}
}
