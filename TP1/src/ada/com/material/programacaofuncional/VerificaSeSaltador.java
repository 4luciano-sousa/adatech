package ada.com.material.programacaofuncional;

public class VerificaSeSaltador implements Verificador {

	@Override
	public boolean verificar(Animal a) {
		return a.podeSaltar();
	}
}
