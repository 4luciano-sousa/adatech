package ada.com.aula07;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class BasicMethods {

	public static void fileAndDirectoryInfo(final String filename) throws IOException {

		Objects.requireNonNull(filename, "File name must not be null");

		// create Path object based on user input
		Path path = Paths.get(filename);

		// if path exists, output info about it
		if (Files.exists(path)) {

			// display file (or directory) information
			System.out.printf("%n%s exists%n", path.getFileName());

			System.out.printf("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not");

			System.out.printf("%s an absolute path%n", path.isAbsolute() ? "Is" : "Is not");

			System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(path));

			System.out.printf("Size: %s%n", Files.size(path));

			System.out.printf("Path: %s%n", path);

			System.out.printf("Absolute path: %s%n", path.toAbsolutePath());

			// output directory listing
			if (Files.isDirectory(path)) {
				System.out.printf("%nDirectory contents:%n");

				// object for iterating through a directory's contents
				try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {

					for (Path p : directoryStream)
						System.out.println(p);
				}
			}
		} else { // not file or directory, output error message
			System.out.printf("\n%s does not exist%n", path);
		}
	}
}
