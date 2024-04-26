package ada.com.projeto;

public class BancoController {

	private ContaRepositorio contaRepositorio;

	public BancoController(ContaRepositorio contaRepositorio) {
		this.contaRepositorio = contaRepositorio;
	}

	public void abrirConta(Cliente cliente, String tipoConta) {
		Conta conta = ContaFactory.criarConta(tipoConta, cliente);
		contaRepositorio.salvar(conta);
	}

	public Conta buscarConta(String numero) {
		return contaRepositorio.buscarPorNumero(numero);
	}

	public void depositar(Conta conta, double valor) {
		conta.depositar(valor);
		contaRepositorio.atualizar(conta);
	}

	public void sacar(Conta conta, double valor) {
		if (conta.sacar(valor)) {
			contaRepositorio.atualizar(conta);
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	public void transferir(Conta origem, Conta destino, double valor) {
		origem.transferir(valor, destino);
		contaRepositorio.atualizar(origem);
		contaRepositorio.atualizar(destino);
	}
}
