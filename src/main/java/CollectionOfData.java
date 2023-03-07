import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class CollectionOfData {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:/Users/Neharika/IdeaProjects/PracticeExtentMaven/report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        List<String> listData = new ArrayList<>();
        listData.add("Harry Potter");
        listData.add("Hermione Granger");
        listData.add("ron weasley");

        Map<Integer, String> map = new HashMap<>();
        map.put(101,"Harry Potter");
        map.put(102,"Hermione Granger");
        map.put(103,"ron weasley");

        Set<Integer> setData = map.keySet();

        extentReports.createTest("List based Data")
                        .info(MarkupHelper.createOrderedList(listData))
                        .info(MarkupHelper.createUnorderedList(listData));

        extentReports.createTest("Map based Data")
                .info(MarkupHelper.createOrderedList(map))
                .info(MarkupHelper.createUnorderedList(map));

        extentReports.createTest("Set based Data")
                .info(MarkupHelper.createOrderedList(setData))
                .info(MarkupHelper.createUnorderedList(setData));

        extentReports.createTest("Highlighted log Test")
                .info(MarkupHelper.createLabel("Get Highlighted!", ExtentColor.YELLOW))
                .info("Normal Message");

        try{
            int x = 5/0;
        }catch(Exception e){
            extentReports.createTest("Exception log test")
                    .info(e);
        }

        Throwable t = new RuntimeException("This is a custom exception");
        extentReports.createTest("Exception log test")
                .fail(t);

        extentReports.createTest("Exception log test")
                .fail(t);

        extentReports.flush();
        Desktop.getDesktop().browse(file.toURI());
    }
}
