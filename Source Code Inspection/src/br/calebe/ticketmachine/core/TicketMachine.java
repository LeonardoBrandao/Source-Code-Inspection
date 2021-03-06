package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import java.util.List;
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

            while (retirou != 1) {
                System.out.println("Por favor retirar a nota!");
                retirou = in.nextInt();
            }
        }
    }

    public int getSaldo() {
        return saldo;
    }

    public void zerarSaldo() {
        this.saldo = 0;
    }

    public String imprimir() throws SaldoInsuficienteException{
        try {
            if (saldo < valor) {
                throw new SaldoInsuficienteException("Seu saldo é menor que o valor do Ticket!");
            }
            
            this.saldo -= this.valor;
                        
            String result = "*****************\n";
            result += "Retire seu bilhete!\n";
            result += "*****************\n";
            result += "Saldo restante:\n";
            result += "*** R$ " + saldo + ",00 ***\n";
            result += "*****************\n";
            return result;
            
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void getTroco(int saldo) {
        Troco troco = new Troco(saldo);
        List<PapelMoeda> papel = troco.getValorQtd();
        for (PapelMoeda p : papel) {
            if (p.getQuantidade() > 0) {
                System.out.println("Valor da nota: " + p.getValor());
                System.out.println("Quantidade de notas: " + p.getQuantidade());
            }
        }
    }
}
