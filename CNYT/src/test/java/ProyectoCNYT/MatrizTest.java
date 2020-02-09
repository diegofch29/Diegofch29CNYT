/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCNYT;


import ProyectoCNYT.Numero_complejo;
import ProyectoCNYT.Vector;
import ProyectoCNYT.Matriz;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ADMIN
 */
public class MatrizTest {
    Proyecto PR = new Proyecto();
    
    @Before
    public void setUp() {
    }
    
    
    @Test
    
    public void AdicionTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        double[][] elementos2={{5,0},{0,0},{7,-4},{2,-1},{4,5},{2,7},{6,-4},{2,0},{0,0}};
        double[][] elementosR={{8,2},{1,0},{11,-5},{2,-1},{8,7},{2,7},{11,-10},{2,1},{0,4}};
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Matriz M2 = PR.rellenar_matriz(elementos2, 3, 3);
        Matriz Result = PR.rellenar_matriz(elementosR, 3, 3);
        Assert.assertTrue(Result.equals(M1.sumar(M2)));
    }
            
            
    @Test
    
    public void InversaTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        double[][] elementosR={{-3,-2},{-1,-0},{-4,1},{0,0},{-4,-2},{0,0},{-5,6},{0,-1},{0,-4}};
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Matriz Result = PR.rellenar_matriz(elementosR, 3, 3);
        Assert.assertTrue(Result.equals(M1.Inversa()));
    }
    
    
    @Test
    
    public void MultiplicacionEscalarTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        double[][] elementosR={{6,4},{2,0},{8,-2},{0,0},{8,4},{0,0},{10,-12},{0,2},{0,8}};
        Numero_complejo num=new Numero_complejo(2, 0);
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Matriz Result = PR.rellenar_matriz(elementosR, 3, 3);
        Assert.assertTrue(Result.equals(M1.Multiplicacion_escalar(num)));
    }
    
    
    @Test
    
    public void TranspuestaTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        double[][] elementosR={{3,2},{0,0},{5,-6},{1,0},{4,2},{0,1},{4,-1},{0,0},{0,4}};
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Matriz Result = PR.rellenar_matriz(elementosR, 3, 3);
        Assert.assertTrue(Result.equals(M1.Transpuesta()));
    }
    
    
    @Test
    
    public void ConjugadaTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        double[][] elementosR={{3,-2},{1,0},{4,1},{0,0},{4,-2},{0,0},{5,6},{0,-1},{0,-4}};
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Matriz Result = PR.rellenar_matriz(elementosR, 3, 3);
        Assert.assertTrue(Result.equals(M1.Conjugada()));
    }
    
    
    @Test
    
    public void AdjuntaTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        double[][] elementosR={{3,-2},{0,0},{5,6},{1,0},{4,-2},{0,-1},{4,1},{0,0},{0,-4}};
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Matriz Result = PR.rellenar_matriz(elementosR, 3, 3);
        Assert.assertTrue(Result.equals(M1.Adjunta()));
    }
    
    
    @Test
    
    public void ProductoTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        double[][] elementos2={{5,0},{0,0},{7,-4},{2,-1},{4,5},{2,7},{6,-4},{2,0},{0,0}};
        double[][] elementosR={{26,-52},{9,7},{48,-21},{60,24},{1,29},{15,22},{26,0},{14,0},{20,-22}};
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Matriz M2 = PR.rellenar_matriz(elementos2, 3, 3);
        Matriz Result = PR.rellenar_matriz(elementosR, 3, 3);
        Assert.assertTrue(Result.equals(M1.multiplicacion(M2)));
    }
    
    
    @Test
    
    public void AccionSobreVectorTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        double[][] elementosV={{1,0},{1,0},{1,0}};
        double[][] elementosR={{8,0},{4,0},{5,0}};
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Vector v= new Vector (elementosV);
        Vector Result= new Vector (elementosV);
        Assert.assertTrue(Result.equals(M1.Accion(v)));
    }
    
    /*
    @Test
    
    public void EsHermitianaTest(){
        double[][] elementos1={{3,2},{1,0},{4,-1},{0,0},{4,2},{0,0},{5,-6},{0,1},{0,4}};
        Matriz M1 = PR.rellenar_matriz(elementos1, 3, 3);
        Assert.assertTrue(M1.Es_Herminiana()==false);
    }

*/
    //@Test
    //Public Matriz EsunitariaTest()
    
    
    @Test
    public void ProductoTensorTest(){
        
    }
    
    
           //System.out.println(this.fil+" "+this.col+" "+this.columnas.length+" "+i);
    
    
}
