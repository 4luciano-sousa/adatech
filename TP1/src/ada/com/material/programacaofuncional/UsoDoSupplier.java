package ada.com.material.programacaofuncional;

import java.util.function.Supplier;

public class UsoDoSupplier {

	public static void main(String[] args) {
		Supplier<Integer> number = () -> 42;
		System.out.println(returnNumber(number));
	}

	private static int returnNumber(Supplier<Integer> supplier) {
		return supplier.get();
	}

}
