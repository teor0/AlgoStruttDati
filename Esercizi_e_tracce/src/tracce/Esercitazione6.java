package tracce;
import java.util.*;

import alberi.*;
public class Esercitazione6 {
    
    public Esercitazione6(){}

    /*scrivere un metodo che restituisce il numero dei valori dell'albero che sono ripetuti almeno 2 volte.
     * i valori che appaiono più volte devono essere conteggiati in ragione delle loro occorrenze. 
     * Quindi si deve restituire la somma delle occorrenze dei valori che appaiono più di 2 volte.
     * Ad esempio se i valori sono: [1,2,3,3,3,4,4] ritorna 5
    */

    public static int conteggioNodi(AlberoBin<Integer> a){
        return ripetuti(a,a);
    }

    //metodo che si porta dietro la radice per ripartire ogni volta
    private static int ripetuti(AlberoBin<Integer> a, AlberoBin<Integer> b){
        if(a==null)
            return 0;
        if(conta(b,a.val())>=2)//quando arrivo qui, conto le occorrenze del nodo dove mi trovo
            return 1+ripetuti(a.sin(), b)+ripetuti(a.des(), b);
            //restituire 1 aiuta a non considerare le occorrenze più volte. passo al nodo sinistro per contare le sue occorrenze
        return ripetuti(a.sin(), b)+ripetuti(a.des(), b);
    }
    
    private static int conta(AlberoBin<Integer> a,int x){
        if(a==null)
            return 0;
        if(a.val()==x)
            return 1+conta(a.sin(), x)+conta(a.des(), x);
        return conta(a.sin(),x)+conta(a.des(), x);
    }
    /* CTP e CTM sono uguali in quanto devo scandire l'albero per contare le occorrenze. per ogni nodo visito l'intero albero
     * percio per n nodi faccio una visita su n nodi quindi theta(n^2)
     * CSM quando l'albero è bilanciato ho numero di chiamate è al più pari all'altezza quindi theta(2log n) ovvero theta(log n).
     * N.B. esce 2logn perchè sia conta che ripetuti sono metodi proporzionali all'altezza del albero se è bilanciato quindi 
     * essendo entrambi logn ho 2logn che in notazione asintotica è logn
     * CSP quando l'albero è degenere ed essendo il numero di chiamate proporzionale al numero di nodi ho theta(n)
     */


     /*scrivere un metodo che dati 2 alberi A e B, restituisce true se almeno un nodo di A al livello liv di A,
      * compare in B in un livello maggiore di liv
      */

      public static boolean analizzaLiv(AlberoBin<Integer> a, AlberoBin<Integer> b){
        if(a==null || b==null)
            return false;
        return analizza(a,b,0);
      }

      private static boolean analizza(AlberoBin<Integer> a, AlberoBin<Integer> b, int liv){
        if(a==null)
            return false;
        if(ricerca(a,a.val(),liv,0))//parto la ricerca da livA con livB=0
            return true;
        return analizza(a, b, liv+1) || analizza(a, b, liv+1);
     }
    
    private static boolean ricerca(AlberoBin<Integer> b,int x,int la, int lb){ //metodo di ricerca per trovare il nodo su b
        if(b==null)
            return false;
        if(lb>la && b.val()==x)//sono arrivato ad un livello maggiore di quello che cercavo
            return true;
        return ricerca(b.sin(),x,la,lb+1) || ricerca(b.des(), x, la,lb+1);
    }

    /* CTM è quando la radice di A è il figlio sinistro della radice di B theta(1)
     * CTP è quando non si verifica la proprietà quindi devo scorrere entrambi gli alberi quindi ho theta(n*m)
     * dove n è il numero di nodi di A e m è il numero di nodi B
     * CSM ho numero di chiamate costanti che non dipendono dal numero di nodi di A e B quindi ho theta(1)
     * CSP è quando ho alberi degeneri ed ho la proprietà non verificata. Il numero di chiamate sullo stack
     * attive sono n+m perciò theta(n+m)
     */



    public static void main(String[] args) {
        AlberoBinLF<Integer> al=new AlberoBinLF<Integer>(15);
        AlberoBinLF<Integer> al1=new AlberoBinLF<Integer>(8);
        AlberoBinLF<Integer> al2=new AlberoBinLF<Integer>(2);
        AlberoBinLF<Integer> al3=new AlberoBinLF<Integer>(8);
        AlberoBinLF<Integer> al4=new AlberoBinLF<Integer>(2);
        AlberoBinLF<Integer> al5=new AlberoBinLF<Integer>(2);
        AlberoBinLF<Integer> al6=new AlberoBinLF<Integer>(8);
        al4.setSin(al5);
        al4.setDes(al6);
        al1.setDes(al3);
        al1.setSin(al2);
        al.setSin(al1);
        al.setDes(al4);
		System.out.println(conteggioNodi(al));
     }


    

}
