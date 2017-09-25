package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};
    protected Scanner in = new Scanner(System.in);

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) {
        try {
            boolean achou = false;
            
            for (int i = 0; i < papelMoeda.length && !achou; i++) {
                if (papelMoeda[i] == quantia) {
                    achou = true;
                    System.out.println("Moeda aceita!");
                }
            }

            if (!achou) {
                throw new PapelMoedaInvalidaException();
            }
            this.saldo += quantia;

        } catch (PapelMoedaInvalidaException e) {
            System.out.println("Sua nota não foi aceita! Por favor retirar! "
                    + "Digite 1 para informar que retirou sua nota!!");
            int retirou = in.nextInt();
            
            while(retirou != 1){
                System.out.println("Por favor retirar a nota!");
                retirou = in.nextInt();
            }             
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
