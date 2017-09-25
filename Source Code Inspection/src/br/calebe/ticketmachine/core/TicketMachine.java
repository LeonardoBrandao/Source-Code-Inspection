package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) {
        try {
            boolean achou = false;
            for (int i = 0; i < papelMoeda.length && !achou; i++) {
                if (papelMoeda[1] == quantia) {
                    achou = true;
                    System.out.println("Moeda aceita!");
                }
            }
            
            if (!achou) {
                throw new PapelMoedaInvalidaException();
            }
            this.saldo += quantia;
            
        } catch (PapelMoedaInvalidaException e) {
            System.err.println("Erro papel Moeda Invalida");
        }

    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<Integer> getTroco() {
        return null;
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
