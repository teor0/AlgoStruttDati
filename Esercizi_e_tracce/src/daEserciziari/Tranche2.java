package daEserciziari;
import alberi.*;
/**
 * @author matteo.orlando
 */
public class Tranche2 {
    
    public Tranche2(){}

    /*scrivere un metodo che calcola il numero di nodi di valore x che ha entrambi i figli */

    public static int countEqualTo(AlberoBin<Integer> a, int  x){
        if(a==null)
            return 0;
        if(a.sin()!=null && a.des()!=null)
            if(a.val()==x)
                return 1+countEqualTo(a.sin(), x)+countEqualTo(a.des(), x);
        return countEqualTo(a.sin(), x)+countEqualTo(a.des(), x);
    }

    /* CTM e CTP sono uguali in quanto l'algoritmo deve fare un conteggio e quindi esaminare tutto l'albero
     * detto ciò, il costo è pari a theta(n)
     * CSP mi ritrovo con un albero degenere quindi le chiamate essendo proporzionali ai nodi ho theta(n)
     * CSM mi ritrovo con un albero bilanciato quindi chiamate proporzionali all'altezza dell'albero quindi theta(log_2 n)
    */


    /* il metodo restituisce true se esiste un nodo che si trova al livello l nell'albero 
     * che ha valore 0 e che sia il suo sottoalbero destro che sinistro abbiano nodi con valore 0 
    */

    public static boolean verificaCammini(AlberoBin<Integer> a, int l){
        if(a==null)
            return true;
        if(l==0 && a.val()==0)
            return figliZero(a.sin()) && figliZero(a.des());
        return verificaCammini(a.sin(), l-1) && verificaCammini(a.des(), l-1);
    }

    private static boolean figliZero(AlberoBin<Integer> a){
        if(a==null)
            return true;
        return a.val()==0 && figliZero(a.sin()) && figliZero(a.des());
    }

    /* CTP devo scorrere tutto quanto l'albero per verificare la condizione quindi theta(n)
     * CTM una volta arrivato al livello con nodo 0 ho subito figlio sinistro !=0 quindi scendo fino al livello l
     * perciò ho theta(l)
     * CSP albero degenere quindi ho theta(n)
     * CSM albero bilanciato quindi ho theta(log(l)) 
     * ora se ho l abbastanza piccolo ho che CTM=CSM=theta(1)
    */

    /*scrivere un metodo che ritorna true, se la foglia meno profonda dell'albero appare ad un livello minore di l */
    public static boolean analizzaFoglia(AlberoBin<Integer> a, int liv, int lf){
        if(lf>=liv)
            return false;
        if(a==null)
            return true;
        if(a.sin()==null && a.des()==null)
            if(lf<liv)
                return true;
        return analizzaFoglia(a.sin(), liv, lf+1) || analizzaFoglia(a.des(), liv, lf+1);   
    }

    /*
     * CTP esamino tutto l'albero in quanto ho L grande abbastanza per farlo quindi ho theta(n)
     * CTM ho una foglia subito superiore al livello L quindi ho theta(log(l+1))
     * CSM ho chiamate sullo stack date da CTM quindi theta(log l)
     * CSP ho un albero degenere ed un L sufficientemente grande da esaminare la foglia quindi ho theta(n)
     */

    /*scrivere un metodo che restituisce il numero di nodi al livello L, se L<0 oppure l'albero è vuoto restituire 0 */

    public static int contaNodiL(AlberoBin<Integer> a, int l){
        if(a==null || l<0)
            return 0;
        return (ricercaNodi(a, l, 0));
    }

    private static int ricercaNodi(AlberoBin<Integer> a, int l, int lc){
        if(a==null|| lc>l)
            return 0;
        if(lc==l)
            return 1+ricercaNodi(a.sin(), l, lc+1)+ricercaNodi(a.des(), l, lc+1);
        return ricercaNodi(a.sin(), l, lc+1) + ricercaNodi(a.des(), l, lc+1);
    }

    /* essendo un conteggio CTP=CTM quindi esaminando tutti nodi ho theta(n)
     * MA per come ho implementato ho che CTM è quando arrivo al nodo più a destra del livello l+1 e mi fermo
     * quindi esamino un numero di nodi proporzionali a (l+1) quindi ho theta(log(l+1))
     * CTP resta theta(n). N.B. meglio togliere l'ottimizzazione e dire theta(n)
     * CSP è quando ho un albero degenere e L sufficientemente grande da dover esaminre tutti i nodi quindi ho theta(n)
     * CSM è quando ho un albero bilanciato quindi ho theta(log l) chiamate attive sullo stack
    */


    /*scrivere un metodo che ritorna true se c'è nel sottoalbero destro e sinistro di un nodo N l'intero x */
    public static boolean eRipetuto(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        if(cercaNodo(a.sin(), x) && cercaNodo(a.des(), x))
            return true;
        return eRipetuto(a.sin(), x) || eRipetuto(a.des(), x);
    }

    private static boolean cercaNodo(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        return a.val()==x || cercaNodo(a.sin(), x) || cercaNodo(a.des(), x);
    }






    public static boolean verifica(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        return mediaCammini(a,x,a.val(),1);
    }

    private static boolean mediaCammini(AlberoBin<Integer> a, int x, int sum, int c) {
        if(a==null)
            return false;
        if(a.sin()==null && a.des()==null)
            return (sum+=a.val())/c >x;
        return mediaCammini(a.sin(), x, sum+a.val(), c+1) || mediaCammini(a.des(), x, sum+a.val(), c+1);
    }






    /*scrivere un metodo che ritorna true se tutti i nodi foglia sono >k */
    public static boolean foglieMaggiori(AlberoBin<Integer> a, int k){
        if(a==null)
            return true;
        if(a.sin()==null && a.des()==null)
            return a.val()>k;
        return foglieMaggiori(a.sin(), k) && foglieMaggiori(a.des(), k);
    }    

    public static int contaNodiA(AlberoBin<Integer> a){
        if(a==null)
            return 0;
        return 1+contaNodiA(a.sin())+contaNodiA(a.des());
    }





    public static void main(String[] args) {
        
        AlberoBinLF<Integer> al=new AlberoBinLF<Integer>(15);
        AlberoBinLF<Integer> al1=new AlberoBinLF<Integer>(7);
        AlberoBinLF<Integer> al2=new AlberoBinLF<Integer>(5);
        AlberoBinLF<Integer> al3=new AlberoBinLF<Integer>(8);
        AlberoBinLF<Integer> al4=new AlberoBinLF<Integer>(33);
        AlberoBinLF<Integer> al5=new AlberoBinLF<Integer>(22);
        AlberoBinLF<Integer> al6=new AlberoBinLF<Integer>(80);
        al4.setSin(al5);
        al4.setDes(al6);
        al1.setDes(al3);
        al1.setSin(al2);
        al.setSin(al1);
        al.setDes(al4);
        System.out.println(verifica(al, 100));
     }




     
     


}
