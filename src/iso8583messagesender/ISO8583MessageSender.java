/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iso8583messagesender;

/**
 *
 * @author buddhika_j
 */
public class ISO8583MessageSender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nii244 = "00F1600244000002003020078020C0120400000000000000045500000100510001024400374637850000071663D23012011198535000000031323334313233343030303030303030303030303030304D4E21573A74DD5E01469F36020D539F2701805F25031901019B02E8009F3704DFAB1CA982023C009F3303E0F8C89F1E0845303333343631329F090201409F3501225F3401019F34034203009F03060000000000008407A0000000031010950500C00480009A032405089F1A0204625F2A0204629C01009F26089220AD1C80B3FB0B9F4104000000029F02060000000004559F100706010A03A0A8060006303030303031";
        String nii245 ="00F1600245000002003020078020C0120400000000000000045500000100510001024500374637850000071663D23012011198535000000031323334313233343030303030303030303030303030304D4E21573A74DD5E01469F36020D539F2701805F25031901019B02E8009F3704DFAB1CA982023C009F3303E0F8C89F1E0845303333343631329F090201409F3501225F3401019F34034203009F03060000000000008407A0000000031010950500C00480009A032405089F1A0204625F2A0204629C01009F26089220AD1C80B3FB0B9F4104000000029F02060000000004559F100706010A03A0A8060006303030303031";
        String nii450 ="00F1600450000002003020078020C0120400000000000000045500000100510001045000374637850000071663D23012011198535000000031323334313233343030303030303030303030303030304D4E21573A74DD5E01469F36020D539F2701805F25031901019B02E8009F3704DFAB1CA982023C009F3303E0F8C89F1E0845303333343631329F090201409F3501225F3401019F34034203009F03060000000000008407A0000000031010950500C00480009A032405089F1A0204625F2A0204629C01009F26089220AD1C80B3FB0B9F4104000000029F02060000000004559F100706010A03A0A8060006303030303031";
        byte[] iso8583MessageBytes = javax.xml.bind.DatatypeConverter.parseHexBinary(nii245);
//        String ipAddress = "220.247.245.117";
//        int port = 5050;

        String ipAddress = "124.43.16.185";
        int port = 6060;

        int numofConnection = 100;
        CustomLogger.clearLogFile();
        for (int i = 0; i < numofConnection; i++) {
            new Thread(new ISOSender(ipAddress, port,i, iso8583MessageBytes)).start();
//            if(i/100==0){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

    }
    
}
