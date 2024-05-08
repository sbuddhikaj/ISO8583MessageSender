/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iso8583messagesender;
import java.io.*;
import java.net.Socket;
/**
 *
 * @author buddhika_j
 */
public class ISOSender implements Runnable {
    private String ip;
    private int port;
    private byte[] iso8583Message;
    int count=0;
    int scount=1;

    public ISOSender(String ip, int port,int count, byte[] iso8583Message) {
        this.ip = ip;
        this.port = port;
        this.count=count;
        this.iso8583Message = iso8583Message;
    }

    @Override
    public void run() {

        try {

            Socket socket = new Socket();
            socket.connect(new java.net.InetSocketAddress(ip, port), 60000);
            socket.setSoTimeout(30000);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(iso8583Message);
            outputStream.flush();
            CustomLogger.log("Message SEND  "+ count );
            InputStream inputStream = socket.getInputStream();
            byte[] response = new byte[1024];
            int bytesRead = inputStream.read(response);

            if (bytesRead > 0) {
                String hexResponse = bytesToHex(response, bytesRead);
                CustomLogger.log("Response received:  "+ count +"\n Message : "+  hexResponse);
            } else {
                CustomLogger.log("No response received " + count);
            }

            socket.close();
        } catch (Exception e) {
            CustomLogger.log("Error : " + e.getMessage());

        }
    }
    private static String bytesToHex(byte[] bytes, int length) {
        StringBuilder hexString = new StringBuilder(2 * length);
        for (int i = 0; i < length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
