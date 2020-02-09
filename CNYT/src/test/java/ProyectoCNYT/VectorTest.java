/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCNYT;



import ProyectoCNYT.Numero_complejo;
import ProyectoCNYT.Vector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author ADMIN
 */
public class VectorTest {
    
    
    
    @Before
    public void setUp() {
       
    }
    
    @Test
    public void AdicionTest(){
      double[][] elementos1={{6,-4},{7,3},{4.2,8.1},{0,-3}};
      double[][] elementos2={{16,2.3},{0,7},{6,0},{0,-4}};
      double[][] elementosR={{22,-1.7},{7,-4},{18.2,8.1},{0,-7}};
      Vector v1 =new Vector(elementos1);
      Vector v2 =new Vector(elementos2);
      Vector Result=new Vector(elementosR);
      Vector Test =v1.Sumar(v2);
      Assert.assertTrue(Result.equals(Test));
    }
    
    @Test
    public void InversoTest(){
      double[][] elementos1={{6,-4},{7,3},{4.2,8.1},{0,-3}};
      double[][] elementosR={{-6,4},{-7,-3},{-4.2,-8.1},{0,3}};
      Vector v1 =new Vector(elementos1);
      Vector Result=new Vector(elementosR);
      Vector Test =v1.Inversa();
      Assert.assertTrue(Result.equals(Test));
    }
    
    
    @Test
    public void MultiplicacionEscalarTest(){
      double[][] elementos1 = {{6,3},{0,0},{5,1},{4,0}};
      Numero_complejo num = new Numero_complejo(3,2);
      double[][] elementosR={{12,21},{0,0},{13,13},{12,8}};
      Vector v1 =new Vector(elementos1);
      Vector Result=new Vector(elementosR);
      Vector Test =v1.Multiplicacion_Escalar(num);
      Assert.assertTrue(Result.equals(Test));
    }
    
    
    @Test
    public void InnerProductTest(){
      double[][] elementos1={{6,-4},{7,3},{4.2,8.1},{0,-3}};
      double[][] elementos2={{16,2.3},{0,7},{6,0},{0,-4}};
      Numero_complejo Result=new Numero_complejo(145, -78);
      Vector v1 =new Vector(elementos1);
      Vector v2 =new Vector(elementos2);
      Numero_complejo Test =v1.InnerProduct(v2);
      Assert.assertTrue(Result.equals(Test));
    }
    
    @Test
    public void ConjugadoTest(){
      double[][] elementos1={{6,-4},{7,3},{4.2,8.1},{0,-3}};
      double[][] elementosR={{6,4},{7,-3},{4.2,-8.1},{0,3}};
      Vector v1 =new Vector(elementos1);
      Vector Result=new Vector(elementosR);
      Vector Test =v1.Inversa();
      Assert.assertTrue(Result.equals(Test));
    }
    
    @Test
    public void NormaTest(){
      double[][] elementos1={{6,-4},{7,3},{4.2,8.1},{0,-3}};
      Vector v1 =new Vector(elementos1);
      double Test =v1.Norma();
      Assert.assertTrue(Test-1<=14.2 && 14.2<=Test+1);
    }
    
    public void DistanciaTest(){
      double[][] elementos1={{6,-4},{7,3},{4.2,8.1},{0,-3}};
      double[][] elementos2={{6,-4},{7,3},{4.2,8.1},{0,-3}};
      Numero_complejo Result=new Numero_complejo(0, 0);
      Vector v1 =new Vector(elementos1);
      Vector v2 =new Vector(elementos2);
      Numero_complejo Test =v1.InnerProduct(v2);
      Assert.assertTrue(Result.equals(Test));
    }
    
    @After
    public void tearDown() {
    }
    
}
