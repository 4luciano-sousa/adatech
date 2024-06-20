package ada.com.projeto.infra;

import ada.com.projeto.cliente.*;
import ada.com.projeto.conta.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

public class BancoControllerTest {

	@Mock
	private ContaRepositorio contaRepositorio;

	@InjectMocks
	private BancoController bancoController;

	private Cliente clientePF;
	private Cliente clientePJ;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);

		clientePF = new Cliente(new CPF("10020030088"), Classificacao.PF, "Cliente PF");
		clientePJ = new Cliente(new CNPJ("00348003004108"), Classificacao.PJ, "Cliente PJ");
	}

	@Test
	public void testAbrirContaCorrente() {
		bancoController.abrirConta(clientePF, TipoConta.CORRENTE);

		ArgumentCaptor<Conta> contaCaptor = ArgumentCaptor.forClass(Conta.class);
		verify(contaRepositorio).salvar(contaCaptor.capture());

		Conta contaSalva = contaCaptor.getValue();
		assertTrue(contaSalva instanceof ContaCorrente);
		assertEquals(clientePF, contaSalva.getCliente());
	}

	@Test
	public void testAbrirContaPoupanca() {
		bancoController.abrirConta(clientePF, TipoConta.POUPANCA);

		ArgumentCaptor<Conta> contaCaptor = ArgumentCaptor.forClass(Conta.class);
		verify(contaRepositorio).salvar(contaCaptor.capture());

		Conta contaSalva = contaCaptor.getValue();
		assertTrue(contaSalva instanceof ContaPoupanca);
		assertEquals(clientePF, contaSalva.getCliente());
	}

	@Test
	public void testAbrirContaInvestimento() {
		bancoController.abrirConta(clientePF, TipoConta.INVESTIMENTO);

		ArgumentCaptor<Conta> contaCaptor = ArgumentCaptor.forClass(Conta.class);
		verify(contaRepositorio).salvar(contaCaptor.capture());

		Conta contaSalva = contaCaptor.getValue();
		assertTrue(contaSalva instanceof ContaInvestimento);
		assertEquals(clientePF, contaSalva.getCliente());
	}

	@Test
	public void testDepositar() {
		Conta conta = new ContaCorrente(new NumeroConta(), clientePF);
		bancoController.depositar(conta, 100.0);

		assertEquals(100.0, conta.consultarSaldo());
		verify(contaRepositorio).atualizar(conta);
	}

	@Test
	public void testSacar() {
		Conta conta = new ContaCorrente(new NumeroConta(), clientePF);
		bancoController.depositar(conta, 200.0);
		bancoController.sacar(conta, 100.0);

		assertEquals(100.0, conta.consultarSaldo());
		verify(contaRepositorio, times(2)).atualizar(conta);
	}

	@Test
	public void testSacarSaldoInsuficiente() {
		Conta conta = new ContaCorrente(new NumeroConta(), clientePF);
		bancoController.depositar(conta, 50.0);

		assertThrows(IllegalArgumentException.class, () -> bancoController.sacar(conta, 100.0));
	}

	@Test
	public void testTransferir() {
		Conta contaOrigem = new ContaCorrente(new NumeroConta(), clientePF);
		Conta contaDestino = new ContaCorrente(new NumeroConta(), clientePJ);

		bancoController.depositar(contaOrigem, 200.0);
		bancoController.transferir(contaOrigem, contaDestino, 100.0);

		assertEquals(100.0, contaOrigem.consultarSaldo());
		assertEquals(100.0, contaDestino.consultarSaldo());
		verify(contaRepositorio, times(2)).atualizar(any(Conta.class));
	}

	@Test
	public void testTransferirSaldoInsuficiente() {
		Conta contaOrigem = new ContaCorrente(new NumeroConta(), clientePF);
		Conta contaDestino = new ContaCorrente(new NumeroConta(), clientePJ);

		bancoController.depositar(contaOrigem, 50.0);

		assertThrows(IllegalArgumentException.class,
				() -> bancoController.transferir(contaOrigem, contaDestino, 100.0));
	}

	@Test
	public void testInvestir() {
		ContaCorrente contaCorrente = new ContaCorrente(new NumeroConta(), clientePF);
		bancoController.depositar(contaCorrente, 200.0);

		// Simular a busca de uma conta existente no repositório (se necessário)
		when(contaRepositorio.buscarPorNumero(anyString())).thenReturn(contaCorrente);

		// Chamar o método de investir
		bancoController.investir(contaCorrente, 100.0);

		// Capturar e verificar a conta de investimento criada
		ArgumentCaptor<Conta> contaCaptor = ArgumentCaptor.forClass(Conta.class);
		verify(contaRepositorio, times(2)).salvar(contaCaptor.capture());

		List<Conta> contasSalvas = contaCaptor.getAllValues();
		Conta contaInvestimento = contasSalvas.get(1); // A segunda conta salva é a de investimento

		assertTrue(contaInvestimento instanceof ContaInvestimento);
		assertEquals(100.0, contaInvestimento.consultarSaldo());
		assertEquals(100.0, contaCorrente.consultarSaldo());
		verify(contaRepositorio, times(2)).atualizar(contaCorrente);
	}
}
