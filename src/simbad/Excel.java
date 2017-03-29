/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simbad;

import java.io.*;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author Miguel
 */
public class Excel  {
    //busca mayor latitud
    public double mayorLatitud(Workbook workbook) throws FileNotFoundException, IOException{ 
        
        Sheet sheet=workbook.getSheet("Sheet1"); 
        double mayorLat=0;
        Row row=sheet.getRow(0);
        
        
        for(int j=0;j<row.getLastCellNum();j++){
            if(row.getCell(j).getRichStringCellValue().toString().equals("lat_ciu")) 
                for(int i=1;i<sheet.getLastRowNum();i++){
                    Row row2=sheet.getRow(i);
                    if(i==1 || Double.parseDouble((row2.getCell(j).getRichStringCellValue().toString()))>mayorLat)
                        mayorLat=Double.parseDouble(row2.getCell(j).getRichStringCellValue().toString());
                } 
        }
        return mayorLat;
            
    }
    //busca menor latitud
     public double menorLatitud(Workbook workbook) throws FileNotFoundException, IOException{ 
        
        Sheet sheet=workbook.getSheet("Sheet1"); 
        double menorLat=0;
        Row row=sheet.getRow(0);
        
        
        for(int j=0;j<row.getLastCellNum();j++){
            if(row.getCell(j).getRichStringCellValue().toString().equals("lat_ciu")) 
                for(int i=1;i<sheet.getLastRowNum();i++){
                    Row row2=sheet.getRow(i);
                    if(i==1 || Double.parseDouble((row2.getCell(j).getRichStringCellValue().toString()))<menorLat)
                        menorLat=Double.parseDouble(row2.getCell(j).getRichStringCellValue().toString());
                } 
        }
        
        return menorLat;
    }
     //busca la mayor longitud
    public double mayorLongitud(Workbook workbook) throws FileNotFoundException, IOException{ 
        
        Sheet sheet=workbook.getSheet("Sheet1"); 
        
        double mayorLon=0;
        Row row=sheet.getRow(0);
        
        
        for(int j=0;j<row.getLastCellNum();j++){
            if(row.getCell(j).getRichStringCellValue().toString().equals("lon_ciu")) 
                for(int i=1;i<sheet.getLastRowNum();i++){
                    Row row2=sheet.getRow(i);
                    if(i==1 || Double.parseDouble((row2.getCell(j).getRichStringCellValue().toString()))>mayorLon)
                        mayorLon=Double.parseDouble(row2.getCell(j).getRichStringCellValue().toString());
                } 
        }
        return mayorLon;
    }
    //busca la menor longitud
    public double menorLongitud(Workbook workbook) throws FileNotFoundException, IOException{ 
       
        Sheet sheet=workbook.getSheet("Sheet1"); 
        double menorLon=0;
        Row row=sheet.getRow(0);

        
        for(int j=0;j<row.getLastCellNum();j++){
            if(row.getCell(j).getRichStringCellValue().toString().equals("lon_ciu")) 
                for(int i=1;i<sheet.getLastRowNum();i++){
                    Row row2=sheet.getRow(i);
                    if(i==1 || Double.parseDouble((row2.getCell(j).getRichStringCellValue().toString()))<menorLon)
                        menorLon=Double.parseDouble(row2.getCell(j).getRichStringCellValue().toString());
                } 
        }
        return menorLon;
        
    }
    private double distanciaLongitudes() throws IOException{
       // return (mayorLongitud()-menorLongitud());
    }
    private double distanciaLatitudes() throws IOException{
        //return (mayorLatitud()-menorLongitud());
    }
    
    
    
}
