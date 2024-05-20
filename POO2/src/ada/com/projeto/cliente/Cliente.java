package ada.com.projeto.cliente;

import java.time.LocalDate;

public class Cliente {
	private Identificador<String> identificador;
	private Classificacao classificacao;
	private String nome;
	private LocalDate dataCadastro;
	private boolean status;

	public Cliente(Identificador<String> identificador, Classificacao classificacao, String nome) {
		this.identificador = identificador;
		this.classificacao = classificacao;
		this.nome = nome;
		this.dataCadastro = LocalDate.now();
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
}
