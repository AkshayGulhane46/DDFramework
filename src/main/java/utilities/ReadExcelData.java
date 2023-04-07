package utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Method;

public class ReadExcelData {
    @DataProvider(name="bvtData")
    public String[][] getData(Method m) throws EncryptedDocumentException , IOException {
        File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\testData.xlsx");
        String excelSheetName = m.getName();
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);
        int totalRows = sheetName.getLastRowNum(); // this will return the number of rows in an excel sheet
        Row totalCells = sheetName.getRow(0); //  This is the logical row whre the column names are written
        int totalCols = totalCells.getLastCellNum(); // This will return the last column of the excel sheet

        String testData[][] = new String[totalRows][totalCols]; // 2D array for storing the data from the excel sheet

        DataFormatter  format = new DataFormatter();
        for(int i = 1 ; i <= totalRows ; i++){
            for(int j = 0 ; j < totalCols ; j++){
                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
        return testData;
    }
}
