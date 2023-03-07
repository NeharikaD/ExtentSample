package RestAssuredTest.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    ExcelUtils (String excelPath, String sheetName) throws IOException {

        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);
    }

    public static void getCellData(int rowNum, int cellNum) throws IOException {
//        String val = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
//        System.out.println(val);
//
//        double valNum = sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();  //we'll get decimal number, to neglect that we use data formatter as shown below
//        System.out.println(valNum);

        //to get data for any kind of datatype do use as follows
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));    //or 1,1
        System.out.println(value);
    }
    public static void getRowCount() throws IOException {
//        System.out.println(System.getProperty("user.dir"));   //--> C:\Users\Neharika\IdeaProjects\RestAssuredPractice
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of rows: "+rowCount);

    }
}
