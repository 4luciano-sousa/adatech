package ada.com.material.datascomjava;

import java.time.LocalDate;

public class ManipulandoDatas {

	public static void main(String[] args) {
		LocalDate dataNascimento = LocalDate.of(1979, 3, 15);
		System.out.println("Dia da Semana: " + dataNascimento.getDayOfWeek());
		System.out.println("Três dias antes: " + dataNascimento.minusDays(3));
		System.out.println("Três dias depois: " + dataNascimento.plusDays(3));
	}
}