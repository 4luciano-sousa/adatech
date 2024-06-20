package ada.com.laboratorio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RelatorioFinal {

	public static void main(String[] args) {
		String arquivoatores = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio2\\atores.csv";
		String arquivoatrizes = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio2\\atrizes.csv";
		String relatorio = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio2\\relatorio_final.csv";

		try {
			List<Atores> atores = readarquivoatores(arquivoatores);
			List<Atores> atrizes = readarquivoatores(arquivoatrizes);
			
			// Ator mais jovem a ganhar um Oscar.
			Atores maisjovem = atores.stream().min(Comparator.comparingInt(a -> a.age)).orElse(null);
			
			// Atriz que mais vezes foi premiada.
			Atores maispremiada = atrizes.stream()
					.collect(Collectors.groupingBy(a -> a.nome, Collectors.counting())).entrySet().stream()
					.max(Map.Entry.comparingByValue()).map(e -> {
						return atrizes.stream().filter(a -> a.nome.equals(e.getKey())).findFirst().orElse(null);
					}).orElse(null);
			
			// Atriz entre 20 e 30 anos que mais vezes foi vencedora.
			Atores jovemvencedora = atrizes.stream().filter(a -> a.age >= 20 && a.age <= 30)
					.collect(Collectors.groupingBy(a -> a.nome, Collectors.counting())).entrySet().stream()
					.max(Map.Entry.comparingByValue()).map(e -> {
						return atrizes.stream().filter(a -> a.nome.equals(e.getKey())).findFirst().orElse(null);
					}).orElse(null);
			
			//  Atores ou atrizes receberam mais de um Oscar.
			List<String> maisdeumoscar = Stream.concat(atores.stream(), atrizes.stream())
					.collect(Collectors.groupingBy(a -> a.nome, Collectors.counting())).entrySet().stream()
					.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
			
			// Resumo de quantos prêmios foram recebidos
			Map<String, List<Atores>> resumopremiacao = Stream.concat(atores.stream(), atrizes.stream())
					.filter(a -> maisdeumoscar.contains(a.nome)).collect(Collectors.groupingBy(a -> a.nome));

			saveReport(relatorio, maisjovem, maispremiada, jovemvencedora, maisdeumoscar,
					resumopremiacao);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Atores> readarquivoatores(String filePath) throws IOException {
		return Files.lines(Paths.get(filePath)).skip(1).map(line -> {
			String[] parts = line.split(",");
			String nome = parts[0];
			String filme = parts[1];
			int oscarYr = Integer.parseInt(parts[2]);
			String birthDateFormat = parts[3];
			int age = Integer.parseInt(parts[4]);
			int ageCurrent = Integer.parseInt(parts[5]);
			return new Atores(nome, filme, oscarYr, birthDateFormat, age, ageCurrent);
		}).collect(Collectors.toList());
	}

	private static void saveReport(String filePath, Atores maisjovem, Atores maispremiada,
			Atores jovemvencedora, List<String> maisdeumoscar, Map<String, List<Atores>> resumopremiacao)
			throws IOException {
		List<String> lines = new ArrayList<>();
		lines.add("ator_mais_jovem," + (maisjovem != null ? maisjovem.toString() : "N/A"));
		lines.add("atriz_mais_premiada," + (maispremiada != null ? maispremiada.toString() : "N/A"));
		lines.add("atriz_jovem_vencedora,"
				+ (jovemvencedora != null ? jovemvencedora.toString() : "N/A"));
		lines.add("mais_de_um_oscar," + String.join(";", maisdeumoscar));
		resumopremiacao.forEach((nome, atores) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(nome).append(",");
			atores.forEach(a -> sb.append(a.oscarYr).append(":").append(a.age).append(":").append(a.filme).append(";"));
			lines.add("resumo_premiacao," + sb.toString());
		});
		Files.write(Paths.get(filePath), lines);
	}
}
