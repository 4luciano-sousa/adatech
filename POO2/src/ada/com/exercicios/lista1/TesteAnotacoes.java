package ada.com.exercicios.lista1;

public class TesteAnotacoes {

	public static void main(String[] args) {
		AnotacaoProfissional anotacaoProfissional = new AnotacaoProfissional("Reunião às 10h");
		AnotacaoPessoal anotacaoPessoal = new AnotacaoPessoal("Comprar leite");

		AnotacaoArquivoGerenciador.salvarEmDisco(anotacaoProfissional, "anotacao_profissional.txt");
		AnotacaoArquivoGerenciador.salvarEmDisco(anotacaoPessoal, "anotacao_pessoal.txt");
	}
}