/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simbad;

/**
 *
 * @author Miguel
 */

import java.io.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.concurrent.TimeUnit;
public class SIMBAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, ParseException {
        BufferedReader lector=new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Ingrese N");
        int n=Integer.parseInt(lector.readLine());
        System.out.println("Ingrese M");
        int m=Integer.parseInt(lector.readLine());
        
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/mm/yyyy");
        
        System.out.println("Ingrese primera fecha en formato dd/mm/aaaa");
        Date date1 = myFormat.parse(lector.readLine());
        
        System.out.println("Ingrese segunda fecha en formato dd/mm/aaaa");
        Date date2 = myFormat.parse(lector.readLine());

        
        
        
        reporteUnificado reporte=new reporteUnificado(n,m,date1,date2);
        reporte.ObtenerReporte();
        reporte.MostrarReporte();

        
    }
    
}
