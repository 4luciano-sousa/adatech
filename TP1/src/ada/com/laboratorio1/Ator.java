package ada.com.laboratorio1;

	class Ator {
	
		String name;
		String movie;
		int oscarYr;
		String birthDateFormat;
		int age;
		int ageCurrent;

	public Ator(String name, String movie, int oscarYr, String birthDateFormat, int age, int ageCurrent) {
		
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