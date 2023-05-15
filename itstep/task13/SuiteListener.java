package itstep.task13;

import itstep.task_12.WebDriverSupplier;
import org.testng.*;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite execution finished");
        WebDriverSupplier.closeDriver();
    }

}