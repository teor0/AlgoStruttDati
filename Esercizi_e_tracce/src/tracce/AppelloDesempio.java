package tracce;
import alberi.*;
public class AppelloDesempio {
    

    /*scrivere un metodo che ritorna true se e solo se un valore v che appare in un nodo appare anche in una foglia */
    public static boolean appareDoppio(AlberoBin<Integer> a) {
        if(a==null)
            return false;
        return appare(a, a.val()) || appareDoppio(a.sin()) || appareDoppio(a.des());
    }

    private static boolean appare(AlberoBin<Integer> a, int v){
        if(a==null)
            return false;
        if(a.sin()==null && a.des()==null)
            return a.val()==v;
        return appare(a.sin(), v) || appare(a.des(), v);
    }



}
