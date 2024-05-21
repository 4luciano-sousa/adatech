package ada.com.projeto.conta;

import java.time.LocalDateTime;
import ada.com.projeto.cliente.Cliente;

public class Transacao {
	private TipoTransacao tipoTransacao;
	private double valor;
	private LocalDateTime dataTransacao;
	private String observacao;
	private Cliente destinatario;

	public Transacao(TipoTransacao tipoTransacao, double valor, String observacao, Cliente destinatario) {
		this.tipoTransacao = tipoTransacao;
		this.valor = valor;
		this.dataTransacao = LocalDateTime.now();
		this.observacao = observacao;
		this.destinatario = destinatario;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public double getValor() {
		return valor;
	}

	public LocalDateTime getDataTransacao() {
		return dataTransacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public Cliente getDestinatario() {
		return destinatario;
	}
}