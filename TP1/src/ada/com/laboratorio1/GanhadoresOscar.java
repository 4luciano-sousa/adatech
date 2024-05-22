package ada.com.laboratorio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GanhadoresOscar {

		public static void main(String[] args) {
	        String inputFile = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio\\oscars_actors.csv";
	        String actorsFile = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio\\atores.csv";
	        String actressesFile = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio\\atrizes.csv";

	        try (Stream<String> lines = Files.lines(Paths.get(inputFile))) {
	            List<Ator> actors = lines.skip(1)
	                    .map(line -> line.split(","))
	                    .filter(parts -> parts[2].equals("Best actor"))
	                    .map(parts -> createActor(parts))
	                    .sorted(Comparator.comparing((Ator a) -> a.name).thenComparing(a -> a.oscarYr))
	                    .collect(Collectors.toList());

	            List<Ator> actresses = Files.lines(Paths.get(inputFile)).skip(1)
	                    .map(line -> line.split(","))
	                    .filter(parts -> parts[2].equals("Best actress"))
	                    .map(parts -> createActor(parts))
	                    .sorted(Comparator.comparing((Ator a) -> a.name).thenComparing(a -> a.oscarYr))
	                    .collect(Collectors.toList());

	            saveToFile(actorsFile, actors);
	            saveToFile(actressesFile, actresses);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static Ator createActor(String[] parts) {
	        String name = parts[3];
	        String movie = parts[4];
	        int oscarYr = Integer.parseInt(parts[1]);
	        String birthDateFormat = formatDate(parts[7]);
	        int age = Integer.parseInt(parts[5]);
	        int ageCurrent = calculateCurrentAge(parts[7]);
	        
	        return new Ator(name, movie, oscarYr, birthDateFormat, age, ageCurrent);
	    }

	    private static String formatDate(String birthDate) {
	        LocalDate date = LocalDate.parse(birthDate);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
	        return date.format(formatter);
	    }

	    private static int calculateCurrentAge(String birthDate) {
	        LocalDate birth = LocalDate.parse(birthDate);
	        LocalDate now = LocalDate.now();
	        return Period.between(birth, now).getYears();
	    }

	    private static void saveToFile(String fileName, List<Ator> actors) {
	        try {
	            Files.write(Paths.get(fileName), (Iterable<String>) actors.stream()
	                    .map(Ator::toString)
	                    ::iterator);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
