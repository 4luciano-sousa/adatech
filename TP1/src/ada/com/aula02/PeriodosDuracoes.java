package ada.com.aula02;

import java.time.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PeriodosDuracoes {

	public static void main(String[] args) {

		var one = LocalTime.of(5, 15);
		var two = LocalTime.of(6, 30);
		var date = LocalDate.of(2016, 1, 20);
		System.out.println(ChronoUnit.HOURS.between(one, two)); // 1
		System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
		System.out.println(ChronoUnit.MINUTES.between(one, date)); // DateTimeException

		LocalTime time = LocalTime.of(3, 12, 45);
		System.out.println(time); // 03:12:45
		LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES);
		System.out.println(truncated); // 03:12

	}

}
