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
public class Matriz {
    
    int col;
    int fil;
    Vector [] columnas;
    
    
    /**
     *
     * @param n
     * @param m
     */
    public  Matriz(int n,int m){
        this.fil=n;
        this.col=m;
        Vector[] colum;  
        colum = new Vector[n];
        this.columnas=colum.clone();
        for (int i=0;i<this.col;i++){
            this.columnas[i]=new Vector(this.fil);
        }
    }
    
    /**
     *
     * @param m
     * @return
     */
    public Matriz sumar(Matriz m){
        Matriz result = new Matriz(this.fil,this.col);
        for (int i=0;i<this.col;i++){
            result.setColumna(this.getColumna(i).Sumar(m.getColumna(i)), i);
        }
        return result;
    }
    
    /**
     *
     * @return
     */
    public Matriz Inversa(){
       Matriz result = new Matriz(this.fil,this.col);
       for (int i=0;i<this.col;i++){
           result.setColumna(this.columnas[i].Inversa(), this.fil);
       }
       return result;
   }
   
    /**
     *
     * @param n
     * @return
     */
    public Matriz Multiplicacion_escalar(Numero_complejo n){
       Matriz result = new Matriz(this.fil,this.col);
        for (int i=0;i<this.col;i++){
            result.setColumna(this.getColumna(i).Multiplicacion_Escalar(n), i);
        }
       return result;
       
   } 
   
    /**
     *
     * @return
     */
    public Matriz Transpuesta(){
       Matriz result = new Matriz(this.col,this.fil);
       for (int i=0;i<this.fil;i++){
           Numero_complejo [] v =new Numero_complejo[this.col];
           for (int j=0;j<this.col;j++){
               v[j]=this.columnas[j].getElemento(i);
           }
           result.setColumna(v, i);
       }
       return result;
   }
   
    /**
     *
     * @return
     */
    public Matriz Conjugada(){
       Matriz result = new Matriz(this.col,this.fil);
       for (int i=0;i<this.col;i++){
           result.setColumna(this.columnas[i].Conjugado(), this.fil);
       }
       return result;
   }
    
    /**
     *
     * @return
     */
    public Matriz Adjunta(){
       return this.Transpuesta().Conjugada();
   }
   
    /**
     *
     * @param v
     * @return
     */
    public Vector Accion(Vector v){
       Numero_complejo[] elementos_v=new Numero_complejo[v.getN()];
       Vector result = new Vector(v.getN());
       for (int i=0;i<this.col;i++){
           elementos_v[i]=this.columnas[i].InnerProduct(v);
       }
       result.setElementos(elementos_v);
       return result;
   }
    
    
    public Matriz multiplicacion(Matriz m){
        Matriz result = new Matriz(this.fil,m.col);
        Matriz mv=this.Transpuesta();
        Numero_complejo [] elem;
        int cont=0;
        int pos;
        for (Vector i:mv.columnas){
            pos=0;
            elem = new Numero_complejo[this.fil];
            for(Vector j:m.columnas){
                elem[pos]=i.InnerProduct(j);
                pos+=1;
            }
            result.setColumna(elem.clone(), cont);
            cont+=1;
        }
        return result;
    }   
    
    public double norma(){
       double result = 0;
       for (Vector i:this.columnas){
           result=i.InnerProduct(i).getA();
       }
       return Math.sqrt(result);
   }
    
    
    public Matriz producto_tensor(Matriz m){
        Matriz result = new Matriz(this.fil*m.fil,m.col*this.col);
        int colum=0;
        for(Vector i:this.columnas){
            for (Vector j:m.columnas){  
                result.setColumna(i.Producto_Tensor(j), colum);
                colum+=1;
            }
        }
        return result;
    }
    public boolean Es_Herminiana(){
        return this.equals(this.Conjugada());
    }
    
    public void print(){
        System.out.println("------------------------Matriz--------------------------");
        for(Vector i:this.columnas){
            i.print();
        }
    }
   
    /**
     *
     * @param v
     * @param col
     */
    public void setColumna(Vector v, int col){
        this.columnas[col]=v;        
    }
    
    /**
     *
     * @param v
     * @param col
     */
    public void setColumna(Numero_complejo[] v, int col){
        this.columnas[col]=new Vector(v,v.length);        
    }
    
    /**
     *
     * @param fil
     * @param col
     * @return
     */
    public Numero_complejo getElemento(int fil,int col){
        return this.columnas[col].getElemento(fil);
    }
    
    /**
     *
     * @param col
     * @return
     */
    public Vector getColumna(int col){
        return this.columnas[col];
    }
    
    /**
     *
     * @param m
     * @return
     */
    public boolean equals(Matriz m){
        boolean res=true;
        for (int i=0;i<this.col;i++){
            res=res && this.columnas[i].equals(m.getColumna(i));
        }
        return res;
    }
    
    
}