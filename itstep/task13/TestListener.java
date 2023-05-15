package itstep.task13;

import org.apache.logging.log4j.LogManager;
import org.monte.screenrecorder.ScreenRecorder;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Format;
import java.util.logging.Level;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.logging.Logger;
//import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.VideoFormatKeys;
import org.monte.screenrecorder.ScreenRecorder;
import javax.imageio.ImageIO;
import java.awt.*;
import com.example.mylibrary.ScreenRecorder;
import java.io.File;
import java.io.IOException;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.VideoFormatKeys;
import org.monte.media.math.Rational;
import org.monte.media.quicktime.QuickTimeWriter;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;


// Implement custom Test and another Listeners with methods for your variant.
//Add logging for all overridden listener methods
//Add video recorder for onFail action (you can use any lib for that)
// V11. ITestListener method task (2, 3); ISuiteListener, IExecutionListener,IInvoke...(2, 3)

// ITestListener method tasks
//onTestStart() - Logging the name of the test method being executed.
//onTestSuccess() - Logging the test result and add the test result record to table in local DB.

// ISuiteListener, IExecutionListener, IInvokedMethodListener method tasks:x
//onFinish(ISuite suite) - Tear down the environment or clean up any data created during the execution of the test suite. Close browser if need.
//onExecutionStart() - Log the start of execution, initialize any resources required for the test suite.


public class TestListener implements ITestListener {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TestListener.class);
    private ScreenRecorder screenRecorder;

    @Override
    public void onTestFailure(ITestResult result) {
        logger.log(Level.SEVERE, "Test failed: {0}", result.getName());
        captureScreenRecording(result.getName());
    }

    private void captureScreenRecording(String testName) {
        try {
            File screenRecordingDir = new File("screen-recordings");
            if (!screenRecordingDir.exists()) {
                screenRecordingDir.mkdir();
            }

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            screenRecorder = new ScreenRecorder(gc, null, new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI), new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, (int)24, FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, (int) (15 * 60)), null);
            screenRecorder.start();


            screenRecorder.stop();
            logger.log(Level.INFO, "Screen recording saved for test: {0}", testName);
        } catch (IOException | AWTException e) {
            logger.log((Level) MarkerFactory.getMarker("ERROR"),
                    "Error occurred during screen recording: {}", e.getMessage());
        }
    }


    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getName();
        logger.log(Level.INFO, "Test method started: {0}", methodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test result: SUCCESS");
        String methodName = result.getName();
        addToLocalDB("Test: " + methodName + ", Result: SUCCESS");
    }

    private void addToLocalDB(String record) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=itstep;integratedSecurity=true;";

        try (Connection connection = DriverManager.getConnection(url)) {
            String insertQuery = "INSERT INTO TestResults (result) VALUES (?)";

            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setString(1, record);
                statement.executeUpdate();
            }

            System.out.println("Adding record to local DB: " + record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}