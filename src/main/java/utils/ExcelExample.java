package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelExample {
    public static void main(String[] args) throws IOException {

        /*
            Workbook     -> Sheet     -> Row     -> Cell
            XSSFWorkbook -> XSSFSheet -> XSSFRow -> XSSFCell
         */

        String excelFilePath = "resources/data.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        /*
        This allows for the ability to switch between different sheets.
        Useful when having different test data for each individual page.
         */
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // using for loop
        /*
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int r = 0; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.println(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    default:
                        System.out.printf("Cell type %s not handled%n", cell.getCellType());
                        break;
                }
            }
        }
        */

        // Iterator
        Iterator iterator = sheet.iterator();

        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();

            Iterator cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    default:
                        System.out.printf("Cell type %s not handled%n", cell.getCellType());
                        break;
                }
                System.out.print("  |  ");
            }
            System.out.println();
        }
    }
}
