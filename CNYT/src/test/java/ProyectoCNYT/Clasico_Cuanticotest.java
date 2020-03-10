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
 * @author diego
 */
public class Clasico_Cuanticotest {
    Proyecto PR = new Proyecto();
    
    @Before
    public void setUp() {
    }
    
    
    @Test
    public void CanicasTest(){
        double[][]elementos = {{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},
                               {0,0},{0,0},{1,0},{0,0},{0,0},{0,0},
                               {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},
                               {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},
                               {0,0},{0,0},{0,0},{0,0},{0,0},{1,0},
                               {0,0},{0,0},{1,0},{0,0},{0,0},{0,0}};
         double[][]elem={{6,0},{2,0},{1,0},{5,0},{3,0},{10,0}};
         Vector sim=PR.Canicas(elementos, elem, 1);
         double[][] elementos_resp={{0,0},{0,0},{12,0},{5,0},{1,0},{0,0}};
         Vector Result=new Vector(elementos_resp);
         Assert.assertTrue(Result.equals(sim));
    }
    
    @Test
    public void MultiplesResndijasTest(){
        double[][]elementos = {{0,0},{1.0/2.0,0},{1.0/2.0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
                               {0,0},{0,0},{0,0},{1.0/3.0,0},{1.0/3.0,0},{1.0/3.0,0},{0,0},{0,0},
                               {0,0},{0,0},{0,0},{0,0},{0,0},{1.0/3.0,0},{1.0/3.0,0},{1.0/3.0,0},
                               {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},
                               {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},
                               {0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},
                               {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},
                               {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0}};
         Matriz[] sim=PR.slits(3,5,elementos);
         double[][] elementos_respM={{0,0},{0,0},{0,0},{1.0/6.0,0},{1.0/6.0,0},{1.0/3.0,0},{1.0/6.0,0},{1.0/6.0,0},
                                    {0,0},{0,0},{0,0},{1.0/3.0,0},{1.0/3.0,0},{1.0/3.0,0},{0,0},{0,0},
                                    {0,0},{0,0},{0,0},{0,0},{0,0},{1.0/3.0,0},{1.0/3.0,0},{1.0/3.0,0},
                                    {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},
                                    {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},
                                    {0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},
                                    {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},
                                    {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0}};
         double[][] elementos_respV={{0,0},{0,0},{0,0},{1.0/6.0,0},{1.0/6.0,0},{1.0/3.0,0},{1.0/6.0,0},{1.0/6.0,0}};
         Matriz Result=PR.rellenar_matriz(elementos, 8, 8);
         Matriz ResultV= new Matriz(1,0);
         Vector ve = new Vector(elementos_respV);
         ResultV.setColumna(ve, 0);
         Assert.assertTrue(Result.equals(sim[0]) && ResultV.equals(sim[1]));
    }
    
}
