/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCNYT;

import static java.time.Clock.system;

/**
 *
 * @author estudiante
 */
public class Proyecto {
    
    /**
     */
    public static void main(String[] args) {
        Numero_complejo zero = new Numero_complejo(0,0);
        Numero_complejo one = new Numero_complejo(1,0);
        Matriz H =new Matriz(2,2);
        double[][] elementos ={{1/Math.sqrt(2),0},{1/Math.sqrt(2),0},{1/Math.sqrt(2),0},{-1/Math.sqrt(2),0}};
        H=rellenar_matriz(elementos,H,H.fil,H.col);
        Matriz X =new Matriz(2,2);
        double[][] el ={{0,0},{1,0},{1,0},{0,0}};
        X=rellenar_matriz(el,X,X.fil,X.col);
        Numero_complejo [] elementos_qbit1 = {zero,one};
        Vector qbit1 = new Vector(elementos_qbit1, 2);
        Numero_complejo [] elementos_qbit = {one,zero};
        Vector qbit0 = new Vector(elementos_qbit, 2);
        Matriz M2=H.multiplicacion(H);
        Matriz M1=H.multiplicacion(X);
        Vector qbit4 = qbit0.Producto_Tensor(qbit1);
        Vector result=M2.producto_tensor(M1).Accion(qbit4);
        result.print();
        System.out.println("Resultado = "+result.Elementos[0].a*result.Elementos[0].a+", "+result.Elementos[1].a*result.Elementos[1].a);
    }
    
    public void Circuito(){
        Numero_complejo zero = new Numero_complejo(0,0);
        Numero_complejo one = new Numero_complejo(1,0);
        Matriz H =new Matriz(2,2);
        double[][] elementos ={{1/Math.sqrt(2),0},{1/Math.sqrt(2),0},{1/Math.sqrt(2),0},{-1/Math.sqrt(2),0}};
        H=rellenar_matriz(elementos,H,H.fil,H.col);
        Matriz X =new Matriz(2,2);
        double[][] el ={{0,0},{1,0},{1,0},{0,0}};
        X=rellenar_matriz(el,X,X.fil,X.col);
        Numero_complejo [] elementos_qbit1 = {zero,one};
        Vector qbit1 = New_Vector(elementos_qbit1, 2);
        Numero_complejo [] elementos_qbit = {one,zero};
        Vector qbit0 = New_Vector(elementos_qbit, 2);
        Matriz M2=H.multiplicacion(H);
        Matriz M1=H.multiplicacion(X);
        Vector qbit4 = qbit0.Producto_Tensor(qbit1);
        Vector result=M2.producto_tensor(M1).Accion(qbit4);
        result.print();
        System.out.println("Resultado = "+result.Elementos[0].a*result.Elementos[0].a+", "+result.Elementos[1].a*result.Elementos[1].a);
    }
    
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public  Numero_complejo New_complex(double a,double b){
        Numero_complejo numero_complejo = new Numero_complejo(a,b);
        return numero_complejo;
    }    
    
    public  Numero_complejo sumar(Numero_complejo a,Numero_complejo b){
        Numero_complejo result= new Numero_complejo();
        result=a.sumar(b);
        return result;
    }
    public  Numero_complejo Multiplicar(Numero_complejo a,Numero_complejo b){
        Numero_complejo result= new Numero_complejo();
        result=a.Multiplicar(b);
        return result;
    }
    
    public  Numero_complejo Restar(Numero_complejo a,Numero_complejo b){
        Numero_complejo result= new Numero_complejo();
        result=a.Restar(b);
        return result;
    }
    
    public  Numero_complejo Dividir(Numero_complejo a,Numero_complejo b){
        Numero_complejo result= new Numero_complejo();
        result=a.Dividir(b);
        return result;
    }
    public  double Modulo(Numero_complejo a){
        return a.Modulo();
    }
    
    public  Numero_complejo Conjugado(Numero_complejo a){
       return  a.Conjugado();
   }
    
    public  Numero_complejo Cartesianas_polares(Numero_complejo a){
        return a.Cartecianas_Polares();
    }
    
    public  Numero_complejo polares_Cartesianas(Numero_complejo a){
        return a.Polares_Cartecianas();
    }
    
    public  Vector New_Vector(Numero_complejo[] Elem,int n){
        return new Vector(Elem, n); 
    }
    
    public  Vector  SumarVectores(Vector a, Vector b){
        return a.Sumar(b);
    }
    
    public static Matriz rellenar_matriz(double[][] elem ,Matriz H,int fil,int col){
        Numero_complejo[] elementos=new Numero_complejo[fil];
        int cont=0;
        for (int i=0;i<col;i++){
            for (int j=0;j<fil;j++){
                elementos[j]=new Numero_complejo(elem[cont][0],elem[cont][1]);
                cont+=1;
            }
            H.setColumna(elementos.clone(), i);
        }
        return H;
    }
    
     public  Matriz rellenar_matriz(double[][] elem ,int fil,int col){
         Matriz H = new Matriz(fil,col);
         Numero_complejo[] elementos=new Numero_complejo[fil];
         int cont=0;
         for (int i=0;i<col;i++){
             for (int j=0;j<fil;j++){
                 elementos[j]=new Numero_complejo(elem[cont][0],elem[cont][1]);
                 cont+=1;
             }
             H.setColumna(elementos.clone(), i);
         }
         return H;
     }
    
}


/*public static void main(String[] args) {
        Numero_complejo zero = new Numero_complejo(0,0);
        Numero_complejo one = new Numero_complejo(1,0);
        Matriz H =new Matriz(2,2);
        double[][] elementos ={{1/Math.sqrt(2),0},{1/Math.sqrt(2),0},{1/Math.sqrt(2),0},{-1/Math.sqrt(2),0}};
        H=rellenar_matriz(elementos,H,H.fil,H.col);
        Matriz X =new Matriz(2,2);
        double[][] el ={{0,0},{1,0},{1,0},{0,0}};
        X=rellenar_matriz(el,X,X.fil,X.col);
        Numero_complejo [] elementos_qbit1 = {zero,one};
        Vector qbit1 = New_Vector(elementos_qbit1, 2);
        Numero_complejo [] elementos_qbit = {one,zero};
        Vector qbit0 = New_Vector(elementos_qbit, 2);
        Matriz M2=H.multiplicacion(H);
        Matriz M1=H.multiplicacion(X);
        Vector qbit4 = new Vector(qbit0.Multiplicacion(qbit1),4);
        Vector result=M2.producto_tensor(M1).Accion(qbit4);
        result.print();
        System.out.println("Resultado = "+result.Elementos[0].a*result.Elementos[0].a+", "+result.Elementos[1].a*result.Elementos[1].a);
    }*/