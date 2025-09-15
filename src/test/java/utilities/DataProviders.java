package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {
    //DataProvider
    @DataProvider(name="LoginData")
    public String[][] getData() throws IOException {
        String path = ".\\testData\\OpenCart_LoginData.xlsx"; //taking xl file from testData
        ExcelUtility xlutil =  new ExcelUtility(path); //creating an object for XLUtility
        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1",1);
        String logindata[][] = new String[totalrows][totalcols]; //created for two dimension array which can
        for(int i=1;i<=totalrows;i++)  //read the data from xl storing in two dimensional array
        {
            for(int j=0;j<totalcols;j++)
            {
                String username = xlutil.getCellData("Sheet1", i, 0);
                String password = xlutil.getCellData("Sheet1", i, 1);
                String Exp_Result = xlutil.getCellData("Sheet1",i,2);
                //  Skip if entire row is empty
                if (username == null && password == null && Exp_Result==null ) {
                    continue;
                }
                logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j); //1,0
            }
        }
        return logindata; //returning two dimension array
    }

    //DataProvider 2

    //DataProvider 3


}
