package ada.com.laboratorio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RelatorioFinal {

	public static void main(String[] args) {
		String actorsFile = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio2\\atores.csv";
		String actressesFile = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio2\\atrizes.csv";
		String reportFile = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio2\\relatorio_final.csv";

		try {
			List<Atores> actors = readActorsFile(actorsFile);
			List<Atores> actresses = readActorsFile(actressesFile);

			Atores youngestActor = actors.stream().min(Comparator.comparingInt(a -> a.age)).orElse(null);
			Atores mostAwardedActress = actresses.stream()
					.collect(Collectors.groupingBy(a -> a.name, Collectors.counting())).entrySet().stream()
					.max(Map.Entry.comparingByValue()).map(e -> {
						return actresses.stream().filter(a -> a.name.equals(e.getKey())).findFirst().orElse(null);
					}).orElse(null);

			Atores mostAwardedYoungActress = actresses.stream().filter(a -> a.age >= 20 && a.age <= 30)
					.collect(Collectors.groupingBy(a -> a.name, Collectors.counting())).entrySet().stream()
					.max(Map.Entry.comparingByValue()).map(e -> {
						return actresses.stream().filter(a -> a.name.equals(e.getKey())).findFirst().orElse(null);
					}).orElse(null);

			List<String> moreThanOneOscar = Stream.concat(actors.stream(), actresses.stream())
					.collect(Collectors.groupingBy(a -> a.name, Collectors.counting())).entrySet().stream()
					.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

			Map<String, List<Atores>> summaryAwards = Stream.concat(actors.stream(), actresses.stream())
					.filter(a -> moreThanOneOscar.contains(a.name)).collect(Collectors.groupingBy(a -> a.name));

			saveReport(reportFile, youngestActor, mostAwardedActress, mostAwardedYoungActress, moreThanOneOscar,
					summaryAwards);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Atores> readActorsFile(String filePath) throws IOException {
		return Files.lines(Paths.get(filePath)).skip(1).map(line -> {
			String[] parts = line.split(",");
			String name = parts[0];
			String movie = parts[1];
			int oscarYr = Integer.parseInt(parts[2]);
			String birthDateFormat = parts[3];
			int age = Integer.parseInt(parts[4]);
			int ageCurrent = Integer.parseInt(parts[5]);
			return new Atores(name, movie, oscarYr, birthDateFormat, age, ageCurrent);
		}).collect(Collectors.toList());
	}

	private static void saveReport(String filePath, Atores youngestActor, Atores mostAwardedActress,
			Atores mostAwardedYoungActress, List<String> moreThanOneOscar, Map<String, List<Atores>> summaryAwards)
			throws IOException {
		List<String> lines = new ArrayList<>();
		lines.add("ator_mais_jovem," + (youngestActor != null ? youngestActor.toString() : "N/A"));
		lines.add("atriz_mais_premiada," + (mostAwardedActress != null ? mostAwardedActress.toString() : "N/A"));
		lines.add("atriz_jovem_vencedora,"
				+ (mostAwardedYoungActress != null ? mostAwardedYoungActress.toString() : "N/A"));
		lines.add("mais_de_um_oscar," + String.join(";", moreThanOneOscar));
		summaryAwards.forEach((name, actors) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(name).append(",");
			actors.forEach(a -> sb.append(a.oscarYr).append(":").append(a.age).append(":").append(a.movie).append(";"));
			lines.add("resumo_premiacao," + sb.toString());
		});
		Files.write(Paths.get(filePath), lines);
	}
}
