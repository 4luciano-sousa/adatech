package ada.com.aula02;

import java.time.*;

public class PartesEspecificas {

	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
		System.out.println(date.getDayOfWeek());
		System.out.println(date.getMonth());
		System.out.println(date.getYear());
		System.out.println(date.getDayOfYear());

	}
}