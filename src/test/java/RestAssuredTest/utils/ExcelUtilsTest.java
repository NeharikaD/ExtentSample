package RestAssuredTest.utils;

import java.io.IOException;

public class ExcelUtilsTest {
    public static void main(String[] args) throws IOException {
        String excelPath = "./data/TestData.xlsx";
        String sheetName = "sheet1";
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        excel.getRowCount();
        excel.getCellData(0,1);
        excel.getCellData(1,2);
        excel.getCellData(2,2);

    }
}
