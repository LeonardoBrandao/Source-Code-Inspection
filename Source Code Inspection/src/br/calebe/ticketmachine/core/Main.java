/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Main {

    public static void main(String[] args) throws SaldoInsuficienteException {
        Scanner in = new Scanner(System.in);
        TicketMachine tckMachine = new TicketMachine(20);
        Troco troco;
        
        int menu;
        int valorDinheiro;
        
        outer:
        while (true) {
            String separador = "*****************";

            System.out.println(separador);
            System.out.println("SALDO ATUAL R$ " + tckMachine.getSaldo() + ",00");
            System.out.println(separador);

            System.out.println("MENU");
            System.out.println(separador);
            System.out.println("1 - Inserir Dinheiro");
            System.out.println(separador);
            System.out.println("2 - Solicitar Bilhete");
            System.out.println(separador);
            System.out.println("3 - Solicitar Troco");
            System.out.println(separador);
            System.out.println("4 - Sair");
            System.out.println(separador);

            menu = in.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Digite o valor que deseja inserir de dinheiro");
                    valorDinheiro = in.nextInt();
                    tckMachine.inserir(valorDinheiro);
                    System.out.println(separador);
                    System.out.println("Saldo atual " + tckMachine.getSaldo());
                    break;
                case 2:
                    tckMachine.imprimir();
                    break;
                case 3:
                    System.out.println("Realizar solicitação de troco");
                    troco = new Troco(tckMachine.getSaldo());
                    troco.getIterator();
                    break;
                case 4:
                    if (tckMachine.getSaldo() > 0) {
                        System.out.println("Retire seu troco primeiro!");
                        break;
                    } else {
                        break outer;
                    }
                default:
                    System.out.println(separador);
                    System.out.println("Opção inválida.");
            }

            
        }
    }
}
