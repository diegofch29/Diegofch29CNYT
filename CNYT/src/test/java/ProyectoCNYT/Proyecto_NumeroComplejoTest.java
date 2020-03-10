package ProyectoCNYT;

import ProyectoCNYT.Numero_complejo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Unit test for Proyecto.
 */
public class Proyecto_NumeroComplejoTest {
        
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
    
    
    
    
    @Test
    public void SistemaCuanticoTest(){
        double[][]estado= {{2,1},{-1,2},{0,1},{1,0},{3,-1},{2,0},{0,-2},{-2,1},{1,-3},{0,-1}};
        double[][]estado2= {{-1,-4},{2,-3},{-7,6},{-1,1},{-5,-3},{5,0},{5,8},{4,-4},{8,-7},{2,-7}};
        double sim = PR.Simulacion(estado, 7);
        Numero_complejo sim2 = PR.transicion(estado, estado2);
        Numero_complejo resp= new Numero_complejo(0.02,0.13);
        Assert.assertTrue((0.1077<sim && sim<0.11) && (sim2.equals(resp)));
    }
    /*public void Carteciana_Polares(){
        Numero_complejo a = PR.New_complex(-2,1);
        Numero_complejo NumTest = a.Cartecianas_Polares();
        Numero_complejo result= PR.New_complex(Math.sqrt(2), 0.7785);
        Assert.assertTrue(result.equals(NumTest)); 
    }*/
    
    
    //Cartesianas
    
    
    @After
    public void tearDown() {
    }
}