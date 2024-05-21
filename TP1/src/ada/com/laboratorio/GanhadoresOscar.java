package ada.com.laboratorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GanhadoresOscar {

	public static void main(String[] args) {
		String inputFilePath = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio\\oscars_actors.csv";
		String atoresOutputFilePath = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio\\atores.csv";
		String atrizesOutputFilePath = "C:\\Users\\Luciano\\eclipse-workspace\\adatech\\TP1\\src\\ada\\com\\laboratorio\\atrizes.csv";

		List<Ator> atores = new ArrayList<>();
		List<Ator> atrizes = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
			String line;
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Ator actor = new Ator(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8],
						data[9], data[10]);

				if (actor.getAward().toLowerCase().contains("actor")) {
					atores.add(actor);
				} else if (actor.getAward().toLowerCase().contains("actress")) {
					atrizes.add(actor);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Comparator<Ator> comparator = Comparator.comparing(Ator::getName).thenComparing(Ator::getOscarYr);

		Collections.sort(atores, comparator);
		Collections.sort(atrizes, comparator);

		// Escrita nos arquivos
		try (BufferedWriter bwAtores = new BufferedWriter(new FileWriter(atoresOutputFilePath));
				BufferedWriter bwAtrizes = new BufferedWriter(new FileWriter(atrizesOutputFilePath))) {

			bwAtores.write("oscar_no,oscar_yr,award,name,movie,age,birth_pl,birth_date,birth_mo,birth_d,birth_y");
			bwAtores.newLine();

			bwAtrizes.write("oscar_no,oscar_yr,award,name,movie,age,birth_pl,birth_date,birth_mo,birth_d,birth_y");
			bwAtrizes.newLine();

			for (Ator ator : atores) {
				bwAtores.write(ator.toString());
				bwAtores.newLine();
			}

			for (Ator atriz : atrizes) {
				bwAtrizes.write(atriz.toString());
				bwAtrizes.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}