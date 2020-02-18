package ProyectoCNYT;

import ProyectoCNYT.Numero_complejo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Unit test for Proyecto.
 */
public class NumeroComplejoTest {
        
    Proyecto PR= new Proyecto();
    Numero_complejo ejemplos[] = {new Numero_complejo(2,2), new Numero_complejo(2,2)};
    Numero_complejo ejemplos1[] = {new Numero_complejo(-2,-2),new Numero_complejo(6,3),new Numero_complejo(0,0),new Numero_complejo(13,13),new Numero_complejo(12,8)};
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void SumarTest(){
        Numero_complejo a = PR.New_complex(10,9);
        Numero_complejo b = PR.New_complex(12, 11);
        Numero_complejo result = PR.sumar(a, b);
        Numero_complejo NumTest = PR.New_complex(22,20);
        Assert.assertTrue(result.equals(NumTest));         
    }
    
    
    @Test
    public void MultiplicarTest(){
        Numero_complejo a = PR.New_complex(3,-2);
        Numero_complejo b = PR.New_complex(1, 2);
        Numero_complejo result = PR.Multiplicar(a, b);
        Numero_complejo NumTest = PR.New_complex(7,4);
        Assert.assertTrue(result.equals(NumTest)); 
    }
    
    @Test
    public void RestarTest(){
        Numero_complejo a = PR.New_complex(3,-2);
        Numero_complejo b = PR.New_complex(1, 2);
        Numero_complejo result = PR.Restar(a, b);
        Numero_complejo NumTest = PR.New_complex(2,-4);
        Assert.assertTrue(result.equals(NumTest)); 
    }
    
    @Test
    public void DividirTest(){
        Numero_complejo a = PR.New_complex(-2,1);
        Numero_complejo b = PR.New_complex(1, 2);
        Numero_complejo result = PR.Dividir(a, b);
        Numero_complejo NumTest = PR.New_complex(0,1);
        Assert.assertTrue(result.equals(NumTest));  
    }
    
    
    @Test
    public void ModuloTest(){
        Numero_complejo a = PR.New_complex(1,-1);
        double result = PR.Modulo(a);
        double Num_test = Math.sqrt(2);
        Assert.assertEquals(Num_test,result,0.1);  
    }
    
    @Test
    public void ConjugadoTest(){
        Numero_complejo a = PR.New_complex(-2,1);
        Numero_complejo result = PR.Conjugado(a);
        Numero_complejo NumTest = PR.New_complex(-2,-1);
        Assert.assertTrue(result.equals(NumTest));  
    }
    
    /*@Test
    public void Circuito(){
        Numero_complejo zero = new Numero_complejo(0,0);
        Numero_complejo one = new Numero_complejo(1,0);
        Matriz H =new Matriz(2,2);
        double[][] elementos ={{1/Math.sqrt(2),0},{1/Math.sqrt(2),0},{1/Math.sqrt(2),0},{-1/Math.sqrt(2),0}};
        H=PR.rellenar_matriz(elementos,H,H.fil,H.col);
        Matriz X =new Matriz(2,2);
        double[][] el ={{0,0},{1,0},{1,0},{0,0}};
        X=PR.rellenar_matriz(el,X,X.fil,X.col);
        Numero_complejo [] elementos_qbit1 = {zero,one};
        Vector qbit1 = PR.New_Vector(elementos_qbit1, 2);
        Numero_complejo [] elementos_qbit = {one,zero};
        Vector qbit0 = PR.New_Vector(elementos_qbit, 2);
        Matriz M2=H.multiplicacion(H);
        Matriz M1=H.multiplicacion(X);
        Vector qbit4 = qbit0.Producto_Tensor(qbit1);
        Vector result=M2.producto_tensor(M1).Accion(qbit4);
        result.print();
        System.out.println("Resultado = "+result.Elementos[0].a*result.Elementos[0].a+", "+result.Elementos[1].a*result.Elementos[1].a);
    }*/
    
    
    @Test
    public void Carteciana_Polares(){
        Numero_complejo a = PR.New_complex(-2,1);
        Numero_complejo NumTest = a.Cartecianas_Polares();
        Numero_complejo result= PR.New_complex(Math.sqrt(2), 0.7785);
        Assert.assertTrue(result.equals(NumTest)); 
    }
    
    
    //Cartesianas
    
    
    @After
    public void tearDown() {
    }
}