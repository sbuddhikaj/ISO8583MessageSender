/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iso8583messagesender;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author buddhika_j
 */
public class CustomLogger {
    private static String logFilePath= "connection_log.txt";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void log(String message) {
        String timestamp = dateFormat.format(new Date());
        String logMessage = timestamp + " - " + message;
        writeLog(logMessage);
    }

    private static synchronized void writeLog(String logMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            writer.println(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearLogFile() {
        try (PrintWriter writer = new PrintWriter(logFilePath)) {
            writer.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
