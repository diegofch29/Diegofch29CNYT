/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCNYT;

/**
 *
 * @author diego.chinchilla
 */
public class Vector {
    
    int n;
    Numero_complejo Elementos[];
    boolean transpuesto = false;
    public Vector (){}
    
    public Vector (int n){
        this.n = n;
    }
    
    public Vector (Numero_complejo Elementos[], int n){
        this.Elementos = Elementos.clone();
        this.n = n;
    }
    
    public Vector(double[][] elem){
        this.Elementos= new Numero_complejo[elem.length];
        for(int i=0;i<elem.length;i++){
            Elementos[i]=new Numero_complejo(elem[i][0], elem[i][1]);
        }
        this.n=elem.length;
    }
    
    /**
     *
     * @param v
     * @return
     */
    public Vector Sumar (Vector v){
        Vector result =new Vector(this.n);
        Numero_complejo NumRes[]=new Numero_complejo [n];
        for (int i=0;i<this.n;i++){
            NumRes[i]=this.Elementos[i].sumar(v.getElemento(i));
        }
        result.setElementos(NumRes);
        return result;
    }
    
    /**
     *
     * @param v
     * @return
     */
    public Vector Restar (Vector v){
        Vector result =new Vector(this.n);
        Numero_complejo NumRes[]=new Numero_complejo [n];
        for (int i=0;i<this.n;i++){
            NumRes[i]=this.Elementos[i].Restar(v.getElemento(i));
        }
        result.setElementos(NumRes);
        return result;
    }
    
    /**
     *
     * @return
     */
    public Vector Inversa() {
        Vector result =new Vector(this.n);
        Numero_complejo NumRes[]=new Numero_complejo [this.n];
        Numero_complejo Uno_N=new Numero_complejo(-1,0);
        for (int i=0;i<this.n;i++){
            NumRes[i]=this.Elementos[i].Restar(Uno_N);
        }
        result.setElementos(NumRes);
        return result;
    }
    
    /**
     *
     * @param n
     * @return
     */
    public Vector Multiplicacion_Escalar(Numero_complejo n) {
        Vector result =new Vector(this.n);
        Numero_complejo NumRes[]=new Numero_complejo [this.n];
        for (int i=0;i<this.n;i++){
            NumRes[i]=this.getElemento(i).Multiplicar(n);
        }
        result.setElementos(NumRes);
        return result;
    }
    
    /**
     *
     * @param v
     * @return
     */
    public Numero_complejo InnerProduct(Vector v){
        Numero_complejo result = new Numero_complejo(0, 0);
        v=v.Conjugado();
        //v.print();
        for (int i=0;i<v.n;i++){
            result=result.sumar(this.Elementos[i].Multiplicar(v.Elementos[i]));
        }
        return result;
    }
    
    /**
     *
     * @return
     */
    public Vector Conjugado() {
        Vector result =new Vector(this.n);
        Numero_complejo NumRes[]=new Numero_complejo [this.n];
        for (int i=0;i<this.n;i++){
            NumRes[i]=this.Elementos[i].Conjugado();
        }
        result.setElementos(NumRes);
        return result;
    }
    
    /**
     *
     * @return
     */
    public Vector Transpuesta(){
        Vector result =new Vector(this.n);
        result.setElementos(this.Elementos.clone());
        result.setTranspuesto(this.transpuesto==false);
        return result;
    }
    
    /**
     *
     * @return
     */
    public Vector adjunta(){
        return this.Conjugado().Transpuesta();
    }
    
    
    public Vector Producto_Tensor(Vector v){
        Numero_complejo[] elementos =new Numero_complejo[this.n*v.getN()];
        int count=0;
        for(Numero_complejo i:this.Elementos){
            for(Numero_complejo j:v.Elementos){
                elementos[count]=i.Multiplicar(j);
                count+=1;
            }
        }
        return new Vector(elementos,this.n*v.getN()) ;
    }
    
    public Numero_complejo Distancia(Vector v){
        v=this.Sumar(v.Inversa());
        return v.InnerProduct(v);
    }
    
    public double Norma(){
        return Math.sqrt(this.InnerProduct(this).a);
    }
    
    
    public void print(){
        System.out.println("----------VECTOR------------");
        for(Numero_complejo i:this.Elementos){
            i.print();
        }
        System.out.println("----------------------------\n");
    }
    /**
     *
     * @param Elementos
     */
    public void setElementos(Numero_complejo[] Elementos){
        this.Elementos = Elementos;
    }
    
    /**
     *
     * @return
     */
    public Numero_complejo[] getElementos(){
        return  this.Elementos;
    }
    
    /**
     *
     * @param n
     * @return
     */
    public Numero_complejo getElemento(int n){
        return  this.Elementos[n];
    }
    
    /**
     *
     * @param n
     * @return
     */
    public boolean Es_transpuesto(boolean n){
        return  this.transpuesto;
    }
 
    /**
     *
     * @param n
     */
    public void setN(int n){
        this.n=n;
    }
    
    /**
     *
     * @return
     */
    public int getN(){
        return this.n;
    } 
    
    /**
     *
     * @param n
     */
    public void setTranspuesto(boolean n){
        this.transpuesto=n;
    }

    /**
     *
     * @param v
     * @return
     */
    public boolean equals(Vector v){
        boolean a = true;
        int pos = 0;
        while(a && n<this.n){
            a=(this.Elementos[pos].equals(v.getElemento(pos)));
            pos+=1;
        }
        return a && this.n==v.getN();
    }
}
