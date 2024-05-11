package ada.com.projeto;


import java.util.Scanner;

public class TesteSistemaBancario {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Criando um repositório de contas
	        ContaRepositorio contaRepositorio = new ContaRepositorioImpl();

	        // Criando um banco controller com o repositório criado
	        BancoController bancoController = new BancoController(contaRepositorio);

	        // Solicitando informações do cliente para abrir a conta
	        System.out.println("Informe os dados do cliente:");
	        System.out.print("Nome: ");
	        String nomeCliente = scanner.nextLine();
	        System.out.print("CPF/CNPJ: ");
	        String cpfCnpj = scanner.nextLine();
	        System.out.print("Classificação (PF/PJ): ");
	        String classificacao = scanner.nextLine();

	        // Convertendo CPF/CNPJ para objeto correspondente
	        Identificador identificador;
	        if (classificacao.equalsIgnoreCase("PF")) {
	            identificador = new CPF(cpfCnpj);
	        } else if (classificacao.equalsIgnoreCase("PJ")) {
	            identificador = new CNPJ(cpfCnpj);
	        } else {
	            System.out.println("Classificação inválida.");
	            return;
	        }

	        Cliente cliente = new Cliente(identificador, Classificacao.valueOf(classificacao.toUpperCase()), nomeCliente);

	        // Abrindo conta para o cliente
	        System.out.println("Informe o tipo de conta a ser aberta (CONTA_CORRENTE, CONTA_POUPANCA, CONTA_INVESTIMENTO):");
	        String tipoContaStr = scanner.nextLine();
	        TipoConta tipoConta;
	        try {
	            tipoConta = TipoConta.valueOf(tipoContaStr.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            System.out.println("Tipo de conta inválido.");
	            return;
	        }

	        bancoController.abrirConta(cliente, tipoConta);

	        // Realizando operações bancárias
	        System.out.println("Informe o número da conta para realizar operações:");
	        String numeroContaStr = scanner.nextLine();
	        Conta conta = bancoController.buscarConta(new NumeroConta(numeroContaStr));

	        if (conta == null) {
	            System.out.println("Conta não encontrada.");
	            return;
	        }

	        System.out.println("Escolha a operação a ser realizada (DEPOSITAR, SACAR, TRANSFERIR, CONSULTAR_SALDO):");
	        String operacao = scanner.nextLine();

	        switch (operacao.toUpperCase()) {
	            case "DEPOSITAR":
	                System.out.print("Informe o valor a ser depositado: ");
	                double valorDeposito = scanner.nextDouble();
	                bancoController.depositar(conta, valorDeposito);
	                break;
	            case "SACAR":
	                System.out.print("Informe o valor a ser sacado: ");
	                double valorSaque = scanner.nextDouble();
	                bancoController.sacar(conta, valorSaque);
	                break;
	            case "TRANSFERIR":
	                System.out.println("Informe o número da conta de destino:");
	                String numeroContaDestinoStr = scanner.nextLine();
	                Conta contaDestino = bancoController.buscarConta(new NumeroConta(numeroContaDestinoStr));
	                if (contaDestino == null) {
	                    System.out.println("Conta de destino não encontrada.");
	                    return;
	                }
	                System.out.print("Informe o valor a ser transferido: ");
	                double valorTransferencia = scanner.nextDouble();
	                bancoController.transferir(conta, contaDestino, valorTransferencia);
	                break;
	            case "CONSULTAR_SALDO":
	                double saldo = bancoController.consultarSaldo(conta);
	                System.out.println("Saldo da conta: " + saldo);
	                break;
	            default:
	                System.out.println("Operação inválida.");
	                break;
	        }

	        scanner.close();
	    }
	}
