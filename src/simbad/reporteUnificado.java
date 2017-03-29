/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simbad;

import java.util.Date;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.*;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author Miguel
 */
public class reporteUnificado {
    private int n;
    private int m;
    private Date fechaInicio;
    private Date fechaTermino;
    
    

    public reporteUnificado(int n, int m, Date fechaInicio, Date fechaTermino) {
        this.n = n;
        this.m = m;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }
    
    //Busca la mayor latitud
    private double mayorLatitud() throws FileNotFoundException, IOException{ 
        Workbook workbook=new XSSFWorkbook(new FileInputStream("D:\\ejemplo_datos.xlsx"));
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
    //busca la menor latitud
        private double menorLatitud() throws FileNotFoundException, IOException{ 
        Workbook workbook=new XSSFWorkbook(new FileInputStream("D:\\ejemplo_datos.xlsx"));
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
    private double mayorLongitud() throws FileNotFoundException, IOException{ 
        Workbook workbook=new XSSFWorkbook(new FileInputStream("D:\\ejemplo_datos.xlsx"));
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
    private double menorLongitud() throws FileNotFoundException, IOException{ 
        Workbook workbook=new XSSFWorkbook(new FileInputStream("D:\\ejemplo_datos.xlsx"));
        Sheet sheet=workbook.getSheet("Sheet1"); 
        double menorLon=0;
        Row row=sheet.getRow(0);
        mayorLatitud(workbook);
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
        return (mayorLongitud()-menorLongitud());
    }
    private double distanciaLatitudes() throws IOException{
        return (mayorLatitud()-menorLongitud());
    }
    
    
    
    public void ObtenerReporte() throws IOException {
        
        //Se alimenta de los datos proporcionados por metodos privados que interactuan con excel y genera el reporte unificado
        Workbook workbook=new XSSFWorkbook(new FileInputStream("D:\\ejemplo_datos.xlsx"));
        Sheet sheet=workbook.getSheet("Sheet1");
        
   
        
    }

    public void MostrarReporte() throws IOException {
        Workbook workbook=new XSSFWorkbook(new FileInputStream("C:\\Users\\Miguel\\My Documents\\NetBeansprojects\\SIMBAD\\reporteUnificado.xlsx"));
        Sheet sheet=workbook.getSheet("Sheet1");
        for(Iterator<Row>rit=sheet.rowIterator();rit.hasNext();){
            Row row=rit.next();
            for(Iterator<Cell>cit=row.cellIterator();cit.hasNext();){
                Cell cell=cit.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                System.out.print(cell.getStringCellValue()+"\t");
            }
            System.out.println();
            
        }
        
    }
    
    
}
