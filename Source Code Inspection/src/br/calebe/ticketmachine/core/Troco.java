package br.calebe.ticketmachine.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calebe de Paula Bianchini
 */
final class Troco {

    protected PapelMoeda[] papeisMoeda;

    /**
     * @return the papeisMoeda
     */
    public PapelMoeda[] getPapeisMoeda() {
        return papeisMoeda;
    }

    /**
     * @param papeisMoeda the papeisMoeda to set
     */
    public void setPapeisMoeda(PapelMoeda[] papeisMoeda) {
        this.papeisMoeda = papeisMoeda;
    }

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        if (valor >= 100) {
            do {
                valor = valor - 100;
                count++;
                if (valor < 100) {
                    break;
                }
            } while (valor % 100 != 0);
            papeisMoeda[5] = new PapelMoeda(100, count);
        }
        count = 0;
        if (valor >= 50) {
            do {
                valor = valor - 50;
                count++;
                if (valor < 50) {
                    break;
                }
            } while (valor % 50 != 0);
            papeisMoeda[4] = new PapelMoeda(50, count);
        }
        count = 0;
        if (valor >= 20) {
            do {
                valor = valor - 20;
                count++;
                if (valor < 20) {
                    break;
                }
            } while (valor % 20 != 0);
            papeisMoeda[3] = new PapelMoeda(20, count);
        }
        count = 0;
        if (valor >= 10) {
            do {
                valor = valor - 10;
                count++;
                if (valor < 10) {
                    break;
                }
            } while (valor % 10 != 0);
            papeisMoeda[2] = new PapelMoeda(10, count);
        }
        count = 0;
        if (valor >= 5) {
            do {
                valor = valor - 5;
                count++;
                if (valor < 5) {
                    break;
                }
            } while (valor % 5 != 0);
            papeisMoeda[1] = new PapelMoeda(5, count);
        }
        count = 0;
        if (valor >= 2) {
            do {
                valor = valor - 2;
                count++;
                if (valor < 2) {
                    break;
                }
            } while (valor % 2 != 0);
            papeisMoeda[0] = new PapelMoeda(2, count);
        }
        this.setPapeisMoeda(papeisMoeda);
    }

    public List<PapelMoeda> getValorQtd() {
        PapelMoeda ret = null;
        List<PapelMoeda> listQtdValor = new ArrayList();
        for (int i = 5; i >= 0; i--) {
            if (this.papeisMoeda[i] != null) {
                ret = new PapelMoeda(this.papeisMoeda[i].getValor(), this.papeisMoeda[i].getQuantidade());
                listQtdValor.add(ret);
                ret = null;
            }
        }
        return listQtdValor;
    }
}
