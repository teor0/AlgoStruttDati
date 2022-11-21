package Esempi;
/**
 * @author matteo.orlando
 */
public class Stack<E> {

    private int top; //cima dello stack
    private int capacity;
    private E[] st; //stack

    public Stack(int capacity){
        this.capacity=capacity;
        st=(E[])new Object[capacity];
        top=-1;
    }

    public void push(E elem){
        if(isFull()){
            int currSize=top+1;
            E[] nuovo=(E[])new Object[currSize*2];
            for(int i=0; i<currSize; i++)
                nuovo[i]=st[i];
            st=nuovo;
            capacity=nuovo.length;
        }
        st[top++]=elem;
    }
    /* CASO MIGLIORE theta(1) in quanto non bisogna espandere lo stack
     * CASO PEGGIORE theta(n)
     * complessità O(n)
     * 
     * nel caso di n push la complessità non theta(n^2) ma grazie alla complessità ammortizzata si ha theta(n)
    */

    public E pop(){
        if(isEmpty()){
            System.err.println("Stack vuoto!");
            return null;
        }
        E ret=st[top];
        st[top]=null;
        top--;
        int curr_len=top+1;
        if(curr_len<=capacity/4){
            E[] nuovo=(E[])new Object[capacity/2];
            System.arraycopy(st,0,nuovo,0,nuovo.length);
            st=nuovo;
            capacity=nuovo.length;
        }
        return ret;
    }
    /* CASO MIGLIORE theta(1) in quanto non bisogna ridefinire la dimensione dello stack
     * CASO PEGGIORE theta(n) bisogna ridefinire la dimensione dello stack
     * complessità O(n)
     * 
     * nel caso di n pop la complessità non theta(n^2) ma grazie alla complessità ammortizzata si ha theta(n)
    */


    public boolean isEmpty(){
        return top==-1;
    }
    /* CASO MIGLIORE theta(1)
     * CASO PEGGIORE theta(1)
     * complessità O(1)
    */

    public boolean isFull(){
        return top+1==capacity;
    }
    /* CASO MIGLIORE theta(1)
     * CASO PEGGIORE theta(1)
     * complessità O(1)
    */

    /* Nello stack distinguiamo 2 casi in base alla capacità c
     * 
     * se la dimensione n è pari a c allora c=c*2
     * se la dimensione n è pari a c/4 allora c=c/2
     * 
     * Usando questa strategia, la complessità spaziale è theta(n)
     * 
     * Infine usare una linked list porta vantaggi in termini di pop e push
     */



}