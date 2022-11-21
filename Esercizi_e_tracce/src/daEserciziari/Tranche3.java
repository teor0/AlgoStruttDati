package daEserciziari;
import alberi.*;
/**
 * @author matteo.orlando
 */
public class Tranche3 {
    
    public Tranche3(){}


    /*scrivere un metodo che ritorna true se almeno 2 nodi soddisfano la seguente condizione:
     * se la somma tra il valore del nodo ed livello in cui si trova è <0.
    */

    public static boolean verificaDueNodi(AlberoBin<Integer> a) {
        if(a==null)
            return false;
        return supportoVerificaDueNodi(a,0)>=2;
    }

    private static int supportoVerificaDueNodi(AlberoBin<Integer> a, int l){
        if(a==null)
            return 0;
        if(a.val()+l<0)
            return 1+supportoVerificaDueNodi(a.sin(), l+1)+supportoVerificaDueNodi(a.des(), l+1);
        return supportoVerificaDueNodi(a.sin(), l+1)+supportoVerificaDueNodi(a.des(), l+1);
    }

    /*Dato che devo scorrere tutto l'albero a prescindere abbiamo CTP=CTM=theta(n) 
     * CSP ho un albero degenere quindi chiamate sullo stack pari a n quindi theta(n)
     * CSM ho un albero bilanciato quindi avrò al più chiamate proporzionali all'altezza quindi theta(log n)
    */

    /*scrivere un metodo che ritorna true se TUTTI i nodi non foglia di A contengono un valore di una foglia di A */
    public static boolean verifica(AlberoBin<Integer> a) {
        if(a==null)
            return true;
        if(a.sin()!=null && a.des()!=null)
            if(!supportoVerifica(a, a.val()))
             return false;
        return verifica(a.sin()) && verifica(a.des());
    }

    private static boolean supportoVerifica(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        if(a.sin()==null && a.des()==null && a.val()==x)
            return true;
        return supportoVerifica(a.sin(), x) || supportoVerifica(a.des(), x);
    }




    
    /*scrivere un metodo che restituisce il costo del cammino di costo massimo,
    dove il costo di un cammino è dato dalla somma dei valori dei nodi che si scandiscono 
    */
    public static int camminoMassimo(AlberoBin<Integer> a) {
        if(a==null)
            return 0;
        return a.val()+Math.max(camminoMassimo(a.sin()), camminoMassimo(a.des()));
    }

    /* CTM=CTP perchè devo scandire tutto l'albero a prescindere quindi theta(n)
     * CSP è quando ho un albero degenere quindi ho chiamate sullo stack pari a n perciò theta(n)
     * CSM è quando un albero bilanciato quindi ho theta(log n)
    */


    /*scrivere un metodo che ritorna true se l'intero x appare sia nel sottoalbero destro che sinistro */
    public static boolean appareSottoalberi(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        return (appare(a.sin(), x) && appare(a.des(), x))|| appareSottoalberi(a.sin(), x) || appare(a.des(), x);
    }

    private static boolean appare(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        if(a.val()==x)
            return true;
        return appare(a.sin(), x) || appare(a.des(), x);
    }

    /* CTM è quando ho subito che i figli della radice sono pari a x quindi ho theta(1)
     * CTP è quando devo scandire tutto l'albero per poi non trovare x. Dato che sia il metodo principale 
     * ed il metodo di supporto esplorano tutto l'albero ho theta(n^2)
     * CSM è quando mi trovo in CTM quindi chiamate sullo stack costanti perciò theta(1)
     * CSP è quando ho un albero degenere e non trovo quindi theta(n)
    */



    /*scrivere un metodo, che ritorna true se e solo se tutti i nodi foglia contengono un valore che non appare in altri nodi di A */
    public static boolean verificaNodiFoglia(AlberoBin<Integer> a) {
        if(a==null)
            return true;
        if(!supportoVerificaNodiFoglia(a, a.val()))
             return false;
        return verifica(a.sin()) && verifica(a.des());
    }

    private static boolean supportoVerificaNodiFoglia(AlberoBin<Integer> a, int x){
        if(a==null)
            return true;
        if(a.val()==x)
            return false;
        return supportoVerificaNodiFoglia(a.sin(), x) && supportoVerificaNodiFoglia(a.des(), x);
    }

    /*scrivere un metodo, che calcola il numero dei nodi interni di A, di valore x che hanno UN SOLO figlio */
    public static int contaUnFiglio(AlberoBin<Integer> a, int x){
        if(a==null)
            return 0;
        if(a.val()==x)
            if((a.sin()!=null && a.des()==null) || (a.sin()==null && a.des()!=null))
                return 1+contaUnFiglio(a.sin(), x)+contaUnFiglio(a.des(), x);
        return contaUnFiglio(a.sin(), x)+contaUnFiglio(a.des(), x);
    }


    /*scrivere un metodo, che calcola il numero dei nodi interni di A, di valore x che hanno entrambi i figli */
    public static int contaDueFigli(AlberoBin<Integer> a, int x){
        if(a==null)
            return 0;
        if(a.val()==x && (a.sin()!=null && a.des()!=null))
                return 1+contaDueFigli(a.sin(), x)+contaDueFigli(a.des(), x);
        return contaDueFigli(a.sin(), x)+contaDueFigli(a.des(), x);
    }

    /*scrivere un metodo che calcola il numero di nodi compresi tra l e u */
    public static int contaCompresi(AlberoBin<Integer> a, int l, int u){
        if(a==null)
            return 0;
        if(a.val()>=l && a.val()<=u)
            return 1+contaCompresi(a.sin(), l, u) + contaCompresi(a.des(), l, u);
        return contaCompresi(a.sin(), l, u) + contaCompresi(a.des(), l, u);
    }

    /*
     * CTP=CTM in quanto devo calcolare il numero di nodi compresi tra l ed u. 
     * Verificare la condizione su ogni nodo vuol dire complessità theta(n)
     * CSM è quando ho una albero bilanciato quindi avrò chiamate sullo stack pari a theta(log n)
     * CSP è quando ho un albero degenere quindi avrò chiamate sullo stack pari a theta(n)
    */

    /*scrivere un metodo che ritorna true se e solo se tutte le foglie contengono un valore pari a quello della radice */
    public static boolean foglieRadice(AlberoBin<Integer> a){
        if(a==null)
            return true;
        return supportoFoglieRadice(a, a.val());
    }

    private static boolean supportoFoglieRadice(AlberoBin<Integer> a, int x){
        if(a==null)
            return true;
        if(a.sin()==null && a.des()==null){
            if(a.val()!=x)
                return false;
        }
        return supportoFoglieRadice(a.sin(), x) && supportoFoglieRadice(a.des(), x);
    }

    /*
     * CTP è quando ho che tutte le foglie verificano la condizione quindi theta(n)
     * CTM è quando il figlio sinistro della radice è una foglia con valore diverso dalla radice quindi theta(1)
     * CSP è quando mi trovo in CTP ed ho una albero degenere quindi theta(n)
     * CSM è quando mi trovo in CTM e faccio un numero di chiamate costanti quindi theta(1)
    */

    /*scrivere un metodo che ritorna true se almeno una foglia, abbia un valore non maggiore di tutti i suoi antenati */
    public static boolean unicaFoglia(AlberoBin<Integer> a){
        if(a==null)
            return false;
        return cercaFoglia(a.sin(), a.val()) || cercaFoglia(a.des(), a.val());
    }

    private static boolean cercaFoglia(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        if(a.sin()==null && a.des()==null)
            if(a.val()<x){ //verifico se la foglia è minore del minore
                System.out.println(a.val()+ " e x: "+ x);
                return true;
            }
        if(a.val()<x)
            return cercaFoglia(a.sin(), a.val()) || cercaFoglia(a.des(), a.val());
        return cercaFoglia(a.sin(), x) || cercaFoglia(a.des(), x);

    }

    /*
     * CTP è quando devo cercare in tutto l'albero quindi ho theta(n)
     * CTM è quando il figlio sinistro o destro è foglia ed è minore della radice quindi si ha theta(1)
     * CSM è quando mi trovo in CTM ed ho chiamate costanti quindi theta(1)
     * CSP è quando devo cercare in un albero degenere ed ho chiamate proporzionali ad n quindi theta(n) 
     * 
    */

   /*scrivere un metodo che ritorna il nodo simmetrico del nodo x, dove il simmetrico è il nodo
    * che esiste alla posizione simmetrica del nodo x nel sottoalbero opposto alla radice
    * assumere interi positivi e distinti in valore
    */

    public static int trovaSimmetrico(AlberoBin<Integer> a, int x) {
        if(a==null)
            return -1;
        if(a.val()==x)
            return x;
        return simmetrico(a.sin(),a.des(),x);
    }

    private static int simmetrico(AlberoBin<Integer> sin, AlberoBin<Integer> des, int x){
        if(sin==null || des==null)
            return -1;
        if(sin.val()==x)
            return des.val();
        if(des.val()==x)
            return sin.val();
        int simm=simmetrico(sin.sin(), des.des(), x);
        if(simm!=-1)
            return simm;
        return simmetrico(sin.des(), des.sin(), x);
    }   

    /*
     * CTM trovo subito che i figli della radice sono simmetrici quindi theta(1)
     * CTP ho un albero bilanciato e vado ad esaminare una delle sue foglie perciò theta(n)
     * CSM theta(1)
     * CSP albero bilanciato perciò theta(log n)
     */



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
        System.out.println(unicaFoglia(al));
     }

}
