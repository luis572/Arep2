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

import java.io.IOException;
import java.nio.file.*;


/**
 *
 * @author Luis Pizza
 */
public  class Lectura {
    public static LinkedList<Double> columna1; //lista que almacena los datos de la segunda columna de la tabla
    public static LinkedList<Double> columna2; //lista que almacena los datos de la primera columna de la tabla
    public  static FileReader archivoAleer;//  archivo de prueba a leer 
    /**
	 * @param test//el nombre del archivo de prueba a leer 
	 * @throws Exception// la Exepcion para filereader y BufferedReader
    */
    
    public Lectura(String test) throws Exception{
        columna1=new LinkedList<>();
        columna2=new LinkedList<>();
        archivoAleer= new FileReader(Paths.get("src/test/java/edu/escuelaing/arem/ASE/app/"+test).toString());
        leer();
    }
    /**
	 * Realiza la respectiva lectura del archivo de prueba y los guarda en las listas asignadas 
	 * @throws Exception// la Exepcion para filereader y BufferedReader
    */
     public static  void   leer() throws Exception{
        
        try {
            
            String cadena;
            BufferedReader b;
            b = new BufferedReader(archivoAleer);
            while((cadena = b.readLine())!=null) {
                String[] tupla=cadena.split(" ");
                Double a =Double.parseDouble(tupla[0]);
                Double c =Double.parseDouble(tupla[1]);
                columna2.add(c);
                columna1.add(a);
            }
            b.close();
        
        } catch (Exception e) {
			System.out.println("");
			
		} 
        
        
    }
    public static LinkedList<Double> getColumna1() {
        return columna1;
    }

    public static LinkedList<Double> getColumna2() {
        return columna2;
    }
}
