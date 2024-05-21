package ada.com.material.interfacesfuncionais;

import java.time.LocalDate;
import java.util.TreeMap;
import java.util.function.*;

public class UsandoInterfacesFuncionais {

	public static void main(String[] args) {

		// Supplier
		System.out.println("Uso de interfaces funcionais");
		Supplier<LocalDate> s1 = () -> LocalDate.now();
		LocalDate d1 = s1.get();
		System.out.println(d1);

		// Consumer
		Consumer<String> c1 = x -> System.out.println(x);
		c1.accept("Anne");

		// BiConsumer
		var map = new TreeMap<String, Integer>();
		BiConsumer<String, Integer> b1 = (k, v) -> map.put(k, v);
		b1.accept("alguma string", 7);
		b1.accept("string", 1);
		System.out.println(map);

		// Predicate
		Predicate<String> stringVazia = x -> x.isEmpty();
		System.out.println(stringVazia.test("")); // true

		// BiPredicate
		BiPredicate<String, String> verificaPrefixo = (string, prefix) -> string.startsWith(prefix);
		System.out.println(verificaPrefixo.test("cachorro", "cacho")); // true

		// Function
		Function<String, Integer> funcao1 = x -> x.length();
		System.out.println(funcao1.apply("sorte")); // 5

		// BiFunction
		BiFunction<String, String, String> bifunction = (string1, string2) -> string1.concat(string2);
		System.out.println(bifunction.apply("carro ", "novo")); // carro novo

		// UnaryOperator
		UnaryOperator<String> operadorUnario = x -> x.toUpperCase();
		System.out.println(operadorUnario.apply("carro")); // CARRO

		// BinaryOperator
		BinaryOperator<String> operadorBinario = (string1, string2) -> string1.concat(string2);
		System.out.println(operadorBinario.apply("carro ", "velho")); // carro velho

	}
}