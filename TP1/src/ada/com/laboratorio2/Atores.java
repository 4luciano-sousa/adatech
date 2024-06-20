package ada.com.laboratorio2;

public class Atores {

	String nome;
	String filme;
	int oscarYr;
	String birthDateFormat;
	int age;
	int ageCurrent;

	public Atores(String nome, String filme, int oscarYr, String birthDateFormat, int age, int ageCurrent) {

		this.nome = nome;
		this.filme = filme;
		this.oscarYr = oscarYr;
		this.birthDateFormat = birthDateFormat;
		this.age = age;
		this.ageCurrent = ageCurrent;
	}

	@Override
	public String toString() {
		return nome + "," + filme + "," + oscarYr + "," + birthDateFormat + "," + age + "," + ageCurrent;
	}
}
