
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;
import static java.lang.Math.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;
/**
 *
 * @author Luis Pizza
 */
public class Operaciones {
    public Lectura leerDatos; // Atributo que se encarga de realizar la respectiva lectura de los datos
    /** 
         * Esta clase maneja los metodos para calcular la media y la desviacion 
	 * @param prueba//el nombre del archivo de prueba a leer 
	 * @throws Exception// las Exepciones para filereader y BufferedReader
         *  @throws IOException// las Exepciones para filereader y BufferedReader
    */
    
    public  Operaciones() throws IOException, Exception{
        
            //leerDatos=new Lectura(prueba);
            //System.out.println(media(leerDatos.getColumna1()));
            //System.out.println(desviacion(leerDatos.getColumna1()));
            //System.out.println(media(leerDatos.getColumna2()));
            //System.out.println(desviacion(leerDatos.getColumna2()));
        
    }
    /**
	 * Este metodo permite calcular la media de una lista
         * @param e// este es de tipo LinkedList
	 * @return double
	 */
    public Double media(LinkedList<Double> e){
        
        Double media=e.get(0);
        int n=e.size();
        int contador=1;
        while(e.size()>contador){
            media+=e.get(contador);
            contador+=1;
        }
        media=media/n;
        DecimalFormat df = new DecimalFormat("#.00");
        media=Double.parseDouble(df.format(media).replace(",", "."));
        return media;
    }

    public Lectura getLeerDatos() {
        return leerDatos;
    }
    /**
	 * Este metodo permite calcular la Desviacion de una lista
         * @param e// este es de tipo LinkedList
	 * @return double
	 */
    public Double desviacion(LinkedList<Double> e){
        Double xavg=media(e);
        Double desviacion=0.0;
        int x=e.size();
        int contador=0;
        while(e.size()>contador){
            desviacion+= (pow((e.get(contador)-xavg),2));
            contador+=1;
        }
        desviacion=(Double) sqrt(desviacion/(x-1));
        DecimalFormat df = new DecimalFormat("#.00");
        desviacion=Double.parseDouble(df.format(desviacion).replace(",", "."));
        return desviacion;
    }

 
}
