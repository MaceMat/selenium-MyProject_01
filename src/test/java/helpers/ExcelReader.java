package helpers;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    Workbook excelData;

    public ExcelReader(String excelPath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(excelPath);
        this.excelData = new XSSFWorkbook(fileInputStream);
    }

    public Sheet getSheetByName(String sheetName) {
        return excelData.getSheet(sheetName);
    }

//    public static void main(String[] args) throws IOException {
//
//        //Get sheet from excel file
//        //Sheet sheet = exelData.getSheetAt(1);
//
//        //Get row and cell from excel file
////        Row row = sheet.getRow(0);
////        System.out.println(row.getCell(1).getStringCellValue());
//
//        for (Row row : sheet) {
//            if (row.getRowNum() == 0) {
//                continue;
//            }
//            System.out.println(row.getCell(0).getStringCellValue());
//        }
//    }

}
