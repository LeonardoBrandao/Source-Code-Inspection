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
        TicketMachine tckMachine = new TicketMachine(0);
        int menu;

        while (true) {
            String separador = "*****************";

            System.out.println(separador);
            System.out.println("SALDO ATUAL R$ " + tckMachine.getSaldo() + ",00");
            System.out.println(separador);

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
                    System.out.println("realizar metodo para criação de inseri saldo");
                    break;
                case 2:
                    System.out.println("realizar emitir");
                    break;
                case 3:
                    System.out.println("realizar troco");
                    break;
                default:
                    System.out.println("NENHUM MENU ENCONTRADO!!!");
            }
        }
    }
}
