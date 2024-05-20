package aula.exercicio;

import java.util.*;
import java.util.stream.Collectors;

public class Song1 {

	    public static void main(String[] args) {
	        Songs songs = new Songs();

	        System.out.println("Músicas do gênero Rock:");
	        songs.findSongsByGenre("Rock").forEach(System.out::println);
	    }

	    public List<Song> getSongs() {
	        return List.of(
	                new Song("$10", "Hitchhiker", "Electronic", 2016, 183),
	                new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
	                new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
	                new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
	                new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
	                new Song("Silence", "Delerium", "Electronic", 1999, 134),
	                new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 392),
	                new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
	                new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 2004, 312),
	                new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
	                new Song("Come Together", "The Beatles", "Blues rock", 1968, 173),
	                new Song("Come Together", "Ike & Tina Turner", "Rock", 1970, 165),
	                new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
	                new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
	                new Song("Breathe", "The Prodigy", "Electronic", 1996, 337),
	                new Song("What's Going On", "Gaye", "R&B", 1971, 420),
	                new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
	                new Song("Walk Me Home", "P!nk", "Pop", 2019, 459),
	                new Song("I am not a woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
	                new Song("Pasos de cero", "Pablo Alborán", "Latin", 2014, 117),
	                new Song("Smooth", "Santana", "Latin", 1999, 244),
	                new Song("Immigrant song", "Led Zeppelin", "Rock", 1970, 484)
	        );
	    }

	    public List<Song> findSongsByGenre(String genre) {
	        return getSongs().stream()
	                .filter(song -> song.getGenre().equalsIgnoreCase(genre))
	                .collect(Collectors.toList());
	    }

	    public List<String> listAllGenres() {
	        return getSongs().stream()
	                .map(Song::getGenre)
	                .distinct()
	                .sorted()
	                .collect(Collectors.toList());
	    }

	    public long countDistinctArtists() {
	        return getSongs().stream()
	                .map(Song::getArtist)
	                .distinct()
	                .count();
	    }

	    public List<Song> sortSongsByMostPlayed() {
	        return getSongs().stream()
	                .sorted(Comparator.comparingInt(Song::getTimesPlayed).reversed())
	                .collect(Collectors.toList());
	    }

	    public void printTop5Songs() {
	        getSongs().stream()
	                .sorted(Comparator.comparingInt(Song::getTimesPlayed).reversed())
	                .limit(5)
	                .forEach(song -> System.out.println(song.getTitle()));
	    }

	    public List<Song> findSongsByArtist(String artist) {
	        return getSongs().stream()
	                .filter(song -> song.getArtist().equalsIgnoreCase(artist))
	                .collect(Collectors.toList());
	    }

	    public List<Song> findSongsByPrefix(String prefix) {
	        return getSongs().stream()
	                .filter(song -> song.getTitle().startsWith(prefix))
	                .collect(Collectors.toList());
	    }

	    public List<Song> findSongsAfterYear(int year) {
	        return getSongs().stream()
	                .filter(song -> song.getYear() > year)
	                .collect(Collectors.toList());
	    }
	}

	class Songs {
	    private final String title;
	    private final String artist;
	    private final String genre;
	    private final int year;
	    private final int timesPlayed;

	    public Song(String title, String artist, String genre, int year, int timesPlayed) {
	        this.title = title;
	        this.artist = artist;
	        this.genre = genre;
	        this.year = year;
	        this.timesPlayed = timesPlayed;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getArtist() {
	        return artist;
	    }

	    public String getGenre() {
	        return genre;
	    }

	    public int getYear() {
	        return year;
	    }

	    public int getTimesPlayed() {
	        return timesPlayed;
	    }

	    @Override
	    public String toString() {
	        return "Song{" +
	                "title='" + title + '\'' +
	                ", artist='" + artist + '\'' +
	                ", genre='" + genre + '\'' +
	                ", year=" + year +
	                ", timesPlayed=" + timesPlayed +
	                '}';
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Song song = (Song) o;
	        return year == song.year && timesPlayed == song.timesPlayed && Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(genre, song.genre);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(title, artist, genre, year, timesPlayed);
	    }
	}


}
