package ada.com.projeto;

import java.time.LocalDate;

import ada.com.projeto.cliente.*;
import ada.com.projeto.cliente.Identificador;
import ada.com.projeto.conta.*;
import ada.com.projeto.infra.*;

public class TestaAplicacao {
	public static void main(String[] args) {
		ContaRepositorio contaRepositorio = new ContaRepositorioImpl();
		BancoController bancoController = new BancoController(contaRepositorio);

		Identificador<String> cpf = new CPF("12345678901");
		LocalDate dataNascimentoJoao = LocalDate.of(1990, 5, 21); // Data de nascimento do João
		Cliente clientePF = new Cliente(cpf, Classificacao.PF, "João Silva", dataNascimentoJoao);
		bancoController.abrirConta(clientePF, TipoConta.CORRENTE);

		clientePF.verificarAniversario(); // verifica se aniversario

		Identificador<String> cnpj = new CNPJ("12345678000199");
		Cliente clientePJ = new Cliente(cnpj, Classificacao.PJ, "Empresa XYZ", null);
		bancoController.abrirConta(clientePJ, TipoConta.INVESTIMENTO);

		Conta contaJoao = bancoController.buscarConta(clientePF.getIdentificador());
		bancoController.depositar(contaJoao, 5000.0);
		bancoController.sacar(contaJoao, 1000.0);

		Conta contaEmpresa = bancoController.buscarConta(clientePJ.getIdentificador());
		bancoController.transferir(contaJoao, contaEmpresa, 2000.0);

		System.out.println("Saldo João: " + contaJoao.consultarSaldo());
		System.out.println("Saldo Empresa: " + contaEmpresa.consultarSaldo());

		// Simulação de investimento
		double valorAplicado = 1000.0;
		double taxaJurosMensal = 5.5;
		double valorFuturo = 2000.0;

		LocalDate dataRetorno = bancoController.simularInvestimento(valorAplicado, taxaJurosMensal, valorFuturo);
		System.out.println("Data em que o resultado será alcançado: " + dataRetorno);
	}
}