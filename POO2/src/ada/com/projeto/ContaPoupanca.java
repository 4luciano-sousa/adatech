package ada.com.projeto;

import java.util.*;

class ContaPoupanca implements Conta {

	// Implementação da interface
	private Cliente cliente;
	private IdentificadorConta numero;
	private double saldo;
	private List<Transacao> transacoes;
	private boolean status;

	public ContaPoupanca(Cliente cliente) {
		this.cliente = cliente;
		this.numero = gerarNumeroConta(); // Implementação do método para gerar o número da conta
		this.saldo = 0.0;
		this.transacoes = new ArrayList<>();
		this.status = true;
	}

	private IdentificadorConta gerarNumeroConta() {
		// Lógica para gerar o número da conta
		return new NumeroConta("54321"); // Exemplo: número da conta fictício
	}

	@Override
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public IdentificadorConta getNumero() {
		return numero;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		Transacao transacao = new Transacao(TipoTransacao.DEPOSITO, valor, valor, cliente, cliente,
				"Depósito em conta poupança");
		transacoes.add(transacao);
	}

	@Override
	public boolean sacar(double valor) {
		if (valor <= saldo) {
			saldo -= valor;
			Transacao transacao = new Transacao(TipoTransacao.SAQUE, valor, valor, cliente, cliente,
					"Saque em conta poupança");
			transacoes.add(transacao);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void transferir(double valor, Conta destino) {
		if (valor <= saldo) {
			saldo -= valor;
			destino.depositar(valor);
			Transacao transacao = new Transacao(TipoTransacao.TRANSFERENCIA, valor, valor, cliente,
					destino.getCliente(), "Transferência para conta poupança");
			transacoes.add(transacao);
		} else {
			System.out.println("Saldo insuficiente para realizar a transferência.");
		}
	}

	@Override
	public double consultarSaldo() {
		return saldo;
	}
}
