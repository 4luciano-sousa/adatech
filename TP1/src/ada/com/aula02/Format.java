package ada.com.aula02;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Format {

	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dt = LocalDateTime.of(date, time);
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

		var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
		System.out.println(LocalDateTime.now().format(f));

		var dateTime = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
		var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
		System.out.println(dateTime.format(formatter));
		System.out.println(formatter.format(dateTime));

	}
}