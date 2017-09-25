package br.calebe.ticketmachine.core;

import java.util.Iterator;

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
        while (valor % 100 == 0) {
            valor -= 100;
            count++;
            if(valor == 0){
                break;
            }
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor % 50 == 0) {
            valor -= 50;
            count++;
            if(valor == 0){
                break;
            }
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor % 20 == 0) {
            valor -= 20;
            count++;
            if(valor == 0){
                break;
            }
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor % 10 == 0) {
            valor -= 10;
            count++;
            if(valor == 0){
                break;
            }
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 == 0) {
            valor -= 5;
            count++;
            if(valor == 0){
                break;
            }
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor % 2 == 0) {
            valor -= 2;
            count++;
            if(valor == 0){
                break;
            }
        }
        papeisMoeda[0] = new PapelMoeda(2, count);

        this.setPapeisMoeda(papeisMoeda);
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
            for (int i = 6; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i--) {
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
