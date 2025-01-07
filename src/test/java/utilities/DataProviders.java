package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    //DataProvider 1

    @DataProvider(name = "LoginData")
    public String [][] getData() throws IOException {

        String path = ".\\test-data\\LoginData.xlsx";
        ExcelUtilities excelUtilities = new ExcelUtilities(path);

        int totalRows = excelUtilities.getRowCount("Sheet1");
        int totalColumns = excelUtilities.getCellCount("Sheet1",1);

        String loginData[][] = new String[totalRows][totalColumns];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                loginData[i-1][j] = excelUtilities.getCellData("Sheet1",i,j);
            }
        }
        return loginData;

    }
}
