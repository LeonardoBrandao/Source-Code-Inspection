package br.calebe.ticketmachine.core;

import java.util.ArrayList;
import java.util.Iterator;
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
            while (valor % 100 == 0) {
                valor = valor - 100;
                count++;
                if (valor < 100) {
                    break;
                }
            }
            papeisMoeda[5] = new PapelMoeda(100, count);
            valor = valor - (count * 100);
        }
        count = 0;
        if (valor >= 50) {
            while (valor % 50 == 0) {
                valor = valor - 50;
                count++;
                if (valor < 50) {
                    break;
                }
            }
            papeisMoeda[4] = new PapelMoeda(50, count);
            valor = valor - (count * 50);
        }
        count = 0;
        if (valor >= 20) {
            while (valor % 20 == 0) {
                valor = valor - 20;
                count++;
                if (valor < 20) {
                    break;
                }
            }
            papeisMoeda[3] = new PapelMoeda(20, count);
            valor = valor - (count * 20);
        }
        count = 0;
        if (valor >= 10) {
            while (valor % 10 == 0) {
                valor = valor - 10;
                count++;
                if (valor < 10) {
                    break;
                }
            }
            papeisMoeda[2] = new PapelMoeda(10, count);
            valor = valor - (count * 10);
        }
        count = 0;
        if (valor >= 5) {
            while (valor % 5 == 0) {
                valor = valor - 5;
                count++;
                if (valor < 5) {
                    break;
                }
            }
            papeisMoeda[1] = new PapelMoeda(5, count);
            valor = valor - (count * 5);
        }
        count = 0;
        if (valor >= 2) {
            while (valor % 2 == 0) {
                valor = valor - 2;
                count++;
                if (valor < 2) {
                    break;
                }
            }
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

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 5; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 5; i >= 0 && ret != null; i--) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
