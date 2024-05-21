package ada.com.laboratorio;

public class Ator {

		String oscarNo;
		String oscarYr;
		String award;
		String name;
		String movie;
		String age;
		String birthPl;
		String birthDate;
		String birthMo;
		String birthD;
		String birthY;

	public Ator(String oscarNo, String oscarYr, String award, String name, String movie, String age, String birthPl, String birthDate, String birthMo, String birthD, String birthY) {
		this.oscarNo = oscarNo;
		this.oscarYr = oscarYr;
		this.award = award;
		this.name = name;
		this.movie = movie;
		this.age = age;
		this.birthPl = birthPl;
		this.birthDate = birthDate;
		this.birthMo = birthMo;
		this.birthD = birthD;
		this.birthY = birthY;
	}

	public String getAward() {
		return award;
	}

	public String getName() {
		return name;
	}

	public String getOscarYr() {
		return oscarYr;
	}

	@Override
	public String toString() {
		return oscarNo + "," + oscarYr + "," + award + "," + name + "," + movie + "," + age + "," + birthPl + ","
				+ birthDate + "," + birthMo + "," + birthD + "," + birthY;
	}
}
