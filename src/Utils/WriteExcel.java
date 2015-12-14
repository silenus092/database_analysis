package Utils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import jxl.CellView; 
import jxl.Workbook; 
import jxl.WorkbookSettings; 
import jxl.format.UnderlineStyle; 

import jxl.write.Label; 
import jxl.write.Number; 
import jxl.write.WritableCellFormat; 
import jxl.write.WritableFont; 
import jxl.write.WritableSheet; 
import jxl.write.WritableWorkbook; 
import jxl.write.WriteException; 
import jxl.write.biff.RowsExceededException;
import main.GeneSets; 


public class WriteExcel { 

 private WritableCellFormat timesBoldUnderline;
 private WritableCellFormat times;
 private String inputFile;
 
 
 public WriteExcel () {
	   
	  
} 
 
 public void setOutputFile(String inputFile) {
 this.inputFile = inputFile;
 
 } 

 public void write(ArrayList<GeneSets> geneTable,ArrayList<Double> temp_time_arraylist) throws IOException, WriteException {
   File file = new File(inputFile);
   WorkbookSettings wbSettings = new WorkbookSettings();

   wbSettings.setLocale(new Locale("en", "EN"));

   WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
   workbook.createSheet("Report", 0);
   WritableSheet excelSheet = workbook.getSheet(0);
   createLabel(excelSheet);
   createContent(excelSheet,geneTable ,temp_time_arraylist);

   workbook.write();
   workbook.close();
   System.out.println("Please check the result file under "+ this.inputFile);
 } 

 private void createLabel(WritableSheet sheet)
     throws WriteException { 
   // Lets create a times font 
   WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
   // Define the cell format 
   times = new WritableCellFormat(times10pt);
   // Lets automatically wrap the cells 
   times.setWrap(true);

   // create create a bold font with unterlines 
   WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
       UnderlineStyle.SINGLE); 
   timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
   // Lets automatically wrap the cells 
   timesBoldUnderline.setWrap(true);

   CellView cv = new CellView();
   cv.setFormat(times);
   cv.setFormat(timesBoldUnderline);
   cv.setAutosize(true);

   // Write a few headers 
   addCaption(sheet, 0, 0, "Gene Name");
   addCaption(sheet, 1, 0, "Execution time");
    

 } 

 private void createContent(WritableSheet sheet, ArrayList<GeneSets> geneTable,ArrayList<Double> temp_time_arraylist) throws WriteException,
     RowsExceededException { 
   // Write a few number 
	 int j = 0;
   for (int i = 1; i < temp_time_arraylist.size()+1; i++) {
     // First column 
	 addLabel(sheet, 0, i,geneTable.get(j).getSymbol());
     // Second column 
     addNumber(sheet, 1, i, temp_time_arraylist.get(j));
     j++;
   } 

 } 

 private void addCaption(WritableSheet sheet, int column, int row, String s)
     throws RowsExceededException, WriteException { 
   Label label;
   label = new Label(column, row, s, timesBoldUnderline);
   sheet.addCell(label);
 } 

 private void addNumber(WritableSheet sheet, int column, int row,
     Double integer) throws WriteException, RowsExceededException {
   Number number;
   number = new Number(column, row, integer, times);
   sheet.addCell(number);
 } 

 private void addLabel(WritableSheet sheet, int column, int row, String s)
     throws WriteException, RowsExceededException { 
   Label label;
   label = new Label(column, row, s, times);
   sheet.addCell(label);
 } 

}  