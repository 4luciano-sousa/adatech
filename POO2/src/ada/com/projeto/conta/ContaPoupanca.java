package ada.com.projeto.conta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import ada.com.projeto.cliente.Cliente;

public class ContaPoupanca implements Conta {
    private List<Transacao> transacoes;
    private LocalDateTime dataAtualizacao;
    private double saldo;
    private Identificador<String> numeroConta;
    private Cliente cliente;
    private boolean status;

    public ContaPoupanca(Identificador<String> numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
        this.dataAtualizacao = LocalDateTime.now();
        this.saldo = 0;
        this.status = true;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String getNumero() {
        return numeroConta.getValor();
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        this.dataAtualizacao = LocalDateTime.now();
        this.transacoes.add(new Transacao(TipoTransacao.DEPOSITO, valor, "Depósito realizado", null));
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            this.dataAtualizacao = LocalDateTime.now();
            this.transacoes.add(new Transacao(TipoTransacao.SAQUE, valor, "Saque realizado", null));
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para saque");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            this.dataAtualizacao = LocalDateTime.now();
            this.transacoes.add(new Transacao(TipoTransacao.TRANSFERENCIA, valor, "Transferência realizada", contaDestino.getCliente()));
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void ativarDesativar() {
        this.status = !this.status;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}