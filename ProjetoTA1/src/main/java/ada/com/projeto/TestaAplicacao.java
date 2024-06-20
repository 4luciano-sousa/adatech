package ada.com.projeto;

import ada.com.projeto.cliente.*;
import ada.com.projeto.cliente.Identificador;
import ada.com.projeto.conta.*;
import ada.com.projeto.infra.*;

public class TestaAplicacao {
	public static void main(String[] args) {
		ContaRepositorio contaRepositorio = new ContaRepositorioImpl();
		BancoController bancoController = new BancoController(contaRepositorio);

		Identificador<String> cpf = new CPF("12345678901");
		Cliente clientePF = new Cliente(cpf, Classificacao.PF, "João Silva");
		bancoController.abrirConta(clientePF, TipoConta.CORRENTE);

		Identificador<String> cnpj = new CNPJ("12345678000199");
		Cliente clientePJ = new Cliente(cnpj, Classificacao.PJ, "Empresa XYZ");
		bancoController.abrirConta(clientePJ, TipoConta.INVESTIMENTO);

		Conta contaJoao = bancoController.buscarConta(clientePF.getIdentificador());
		bancoController.depositar(contaJoao, 5000.0);
		bancoController.sacar(contaJoao, 1000.0);

		Conta contaEmpresa = bancoController.buscarConta(clientePJ.getIdentificador());
		bancoController.transferir(contaJoao, contaEmpresa, 2000.0);

		System.out.println("Saldo João: " + contaJoao.consultarSaldo());
		System.out.println("Saldo Empresa: " + contaEmpresa.consultarSaldo());
	}
}