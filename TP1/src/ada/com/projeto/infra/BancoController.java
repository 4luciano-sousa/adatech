package ada.com.projeto.infra;

import java.time.LocalDate;
import java.util.List;

import ada.com.projeto.cliente.Cliente;
import ada.com.projeto.conta.Conta;
import ada.com.projeto.conta.ContaCorrente;
import ada.com.projeto.conta.ContaInvestimento;
import ada.com.projeto.conta.ContaPoupanca;
import ada.com.projeto.conta.NumeroConta;

public class BancoController {
	private ContaRepositorio contaRepositorio;

	public BancoController(ContaRepositorio contaRepositorio) {
		this.contaRepositorio = contaRepositorio;
	}

	public void abrirConta(Cliente cliente, TipoConta tipoConta) {
		Conta conta;
		NumeroConta numeroConta = new NumeroConta();
		switch (tipoConta) {
		case CORRENTE:
			conta = new ContaCorrente(numeroConta, cliente);
			break;
		case INVESTIMENTO:
			conta = new ContaInvestimento(numeroConta, cliente);
			break;
		case POUPANCA:
			conta = new ContaPoupanca(numeroConta, cliente);
			break;
		default:
			throw new IllegalArgumentException("Tipo de conta inválido");
		}
		contaRepositorio.salvar(conta);
	}

	public Conta buscarConta(String identificador) {
		List<Conta> contas = contaRepositorio.buscarCliente(identificador);
		if (!contas.isEmpty()) {
			return contas.get(0);
		}
		return null;
	}

//    public Conta buscarConta(String numero) {
//        return contaRepositorio.buscarPorNumero(numero);
//    }

	public void depositar(Conta conta, double valor) {
		conta.depositar(valor);
		contaRepositorio.atualizar(conta);
	}

	public void investir(Conta conta, double valor) {
		if (conta instanceof ContaCorrente) {
			((ContaCorrente) conta).transferir(valor, buscarConta(conta.getNumero()));
		}
		contaRepositorio.atualizar(conta);
	}

	public void sacar(Conta conta, double valor) {
		conta.sacar(valor);
		contaRepositorio.atualizar(conta);
	}

	public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
		contaOrigem.transferir(valor, contaDestino);
		contaRepositorio.atualizar(contaOrigem);
		contaRepositorio.atualizar(contaDestino);
	}

	public LocalDate simularInvestimento(double valorAplicado, double taxaJurosMensal, double valorFuturo) {
		return SimulaInvestimento.simularInvestimento(valorAplicado, taxaJurosMensal, valorFuturo);
	}

}