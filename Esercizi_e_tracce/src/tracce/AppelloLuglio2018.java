package tracce;
import alberi.*;
public class AppelloLuglio2018 {
    
    /*scrivere un metodo che ritorna true se almeno una foglia negativo ha gli antenati tutti negativi */
    public static boolean antenatiPosFiglioNeg(AlberoBin<Integer> a) {
        if(a==null)
            return false;
        return supporto(a, a.val());
    }

    private static boolean supporto(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        if(x<0)
            return false;
        if(a.sin()==null && a.des()==null)
            return a.val()<0;
        return supporto(a.sin(), a.val()) || supporto(a.des(), a.val());
    }

    /* CTM è quando ho subito che la radice è negativa perciò ho subito la condizione falsa per tutte le possibili foglie theta(1) 
     * CTP è quando la foglia più a destra è quella per cui si verifica la condizione quindi esamino tutto l'albero theta(n)
     * CSM è quando mi ritrovo in CTM quindi il numero di chiamate è pari a theta(1)
     * CSP è quando mi trovo in un albero degenere a lista e sono in CTP quindi numero di chiamate pari a theta(n)
     */



    public static void main(String[] args) {
        
        AlberoBinLF<Integer> al=new AlberoBinLF<Integer>(5);
        AlberoBinLF<Integer> al1=new AlberoBinLF<Integer>(7);
        AlberoBinLF<Integer> al2=new AlberoBinLF<Integer>(5);
        AlberoBinLF<Integer> al3=new AlberoBinLF<Integer>(8);
        AlberoBinLF<Integer> al4=new AlberoBinLF<Integer>(33);
        AlberoBinLF<Integer> al5=new AlberoBinLF<Integer>(2);
        AlberoBinLF<Integer> al6=new AlberoBinLF<Integer>(80);
        al4.setSin(al5);
        al4.setDes(al6);
        al1.setDes(al3);
        al1.setSin(al2);
        al.setSin(al1);
        al.setDes(al4);
        System.out.println(antenatiPosFiglioNeg(al));
     }


}
