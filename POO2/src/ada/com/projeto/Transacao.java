package ada.com.projeto;

import java.util.Date;

public class Transacao {

	private Date data;
	private TipoTransacao tipo;
	private double valorPretendido;
	private double valorReal;
	private Cliente origem;
	private Cliente destino;
	private String observacao;

	public Transacao(TipoTransacao tipo, double valorPretendido, double valorReal, Cliente origem, Cliente destino,
			String observacao) {
	this.data = new Date();
	this.tipo = tipo;
	this.valorPretendido = valorPretendido;
	this.valorReal = valorReal;
	this.origem = origem;
	this.destino = destino;
	this.observacao = observacao;
	}
	public Date getData() {
		return data;
	}
	public TipoTransacao getTipo() {
		return tipo;
	}
	public double getValorPretendido() {
		return valorPretendido;
	}
	public double getValorReal() {
		return valorReal;
	}
	public Cliente getOrigem() {
		return origem;
	}
	public Cliente getDestino() {
		return destino;
	}
	public String getObservacao() {
		return observacao;
	}
}
