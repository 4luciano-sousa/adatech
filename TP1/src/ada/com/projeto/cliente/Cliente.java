package ada.com.projeto.cliente;

import java.time.LocalDate;

public class Cliente {
	private Identificador<String> identificador;
	private Classificacao classificacao;
	private String nome;
	private LocalDate dataCadastro;
	private LocalDate dataNascimento; // Adicionando a data de nascimento.
	private boolean status;

	public Cliente(Identificador<String> identificador, Classificacao classificacao, String nome,
		LocalDate dataNascimento) {
		this.identificador = identificador;
		this.classificacao = classificacao;
		this.nome = nome;
		this.dataCadastro = LocalDate.now();
		this.dataNascimento = dataNascimento; // Inicializando a data de nascimento
		this.status = true; // Ativo por padrão
	}

	public void alterarNome(String novoNome) {
		this.nome = novoNome;
	}

	public void ativarDesativar() {
		this.status = !this.status;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public String getIdentificador() {
		return identificador.getValor();
	}

	public String getNome() {
		return nome;
	}

	public boolean isStatus() {
		return status;
	}

	// verifica se aniversário e imprime a mensagem de parabéns
	public void verificarAniversario() {
		LocalDate hoje = LocalDate.now();
		if (hoje.getMonth() == dataNascimento.getMonth() && hoje.getDayOfMonth() == dataNascimento.getDayOfMonth()) {
			System.out.println("Feliz Aniversário, " + nome + "!");
		}
	}
}