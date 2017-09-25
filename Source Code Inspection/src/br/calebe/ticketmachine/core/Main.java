/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TicketMachine tckMachine = new TicketMachine(20);
        Troco troco;
        
        int menu;
        int valorDinheiro;
        int exit;
        while (true) {
            String separador = "*****************";

            System.out.println(separador);
            System.out.println("SALDO ATUAL R$ " + tckMachine.getSaldo() + ",00");
            System.out.println(separador);

            System.out.println("MENU");
            System.out.println(separador);
            System.out.println("1 - Inserir saldo");
            System.out.println(separador);
            System.out.println("2 - Emitir");
            System.out.println(separador);
            System.out.println("3 - Troco");
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
                    System.out.println("Em processo de geração de Ticket....");
                    String result = tckMachine.imprimir();
                    if( result == null){
                        System.out.println(" Ao tentar gerar seu Ticket houve um erro!! "
                                + "Foi constatado que seu saldo é menor que o valor do Ticket!");
                    } else {
                        System.out.println(result);
                    }
                    System.out.println("Por favor retire o Ticket!");
                    break;
                case 3:
                    System.out.println("Realizar solicitação de troco");
                    troco = new Troco(tckMachine.getSaldo());
                    troco.getIterator().remove();
                    
                    break;
                default:
                    System.out.println("NENHUM MENU ENCONTRADO!!!");
            }

            System.out.println(separador);
            System.out.println("Deseja continuar utilizando o sistema? 1 - Sim ou 0 - Não");
            exit = in.nextInt();
            while (exit != 0 && exit != 1) {
                System.out.println("Deseja continuar ustilizando o sistema? 1 - Sim ou 0 - Não");
                exit = in.nextInt();
            }

            if (exit == 0) {
                break;
            }
        }
    }
}
