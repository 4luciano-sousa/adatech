package ada.com.projeto;

import java.util.Date;

public class Cliente {
	
	private Identificador identificador;
    private Classificacao classificacao;
    private String nome;
    private Date dataCadastro;
    private boolean status;

    public Cliente(Identificador identificador, Classificacao classificacao, String nome) {
        this.identificador = identificador;
        this.classificacao = classificacao;
        this.nome = nome;
        this.dataCadastro = new Date();
        this.status = true;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public Identificador getIdentificador() {
        return identificador;
    }

    public boolean isStatus() {
        return status;
    }

    public void ativarDesativar(boolean status) {
        this.status = status;
    }
}

