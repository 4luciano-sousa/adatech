package ada.com.projeto.infra;

import ada.com.projeto.conta.Conta;
import java.util.ArrayList;
import java.util.List;

public class ContaRepositorioImpl implements ContaRepositorio {
    private List<Conta> contas;

    public ContaRepositorioImpl() {
        this.contas = new ArrayList<>();
    }

    @Override
    public void atualizar(Conta conta) {
        Conta contaExistente = buscarPorNumero(conta.getNumero());
        if (contaExistente != null) {
            contas.remove(contaExistente);
            contas.add(conta);
        }
    }

    @Override
    public List<Conta> buscarCliente(String identificador) {
        List<Conta> contasCliente = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getCliente().getIdentificador().equals(identificador)) {
                contasCliente.add(conta);
            }
        }
        return contasCliente;
    }

    @Override
    public Conta buscarPorNumero(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public void salvar(Conta conta) {
        contas.add(conta);
    }
}