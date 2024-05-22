package ada.com.laboratorio2;

public class Atores {

	String name;
	String movie;
	int oscarYr;
	String birthDateFormat;
	int age;
	int ageCurrent;

	public Atores(String name, String movie, int oscarYr, String birthDateFormat, int age, int ageCurrent) {

		this.name = name;
		this.movie = movie;
		this.oscarYr = oscarYr;
		this.birthDateFormat = birthDateFormat;
		this.age = age;
		this.ageCurrent = ageCurrent;
	}

	@Override
	public String toString() {
		return name + "," + movie + "," + oscarYr + "," + birthDateFormat + "," + age + "," + ageCurrent;
	}
}
