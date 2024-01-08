/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientSeiteNeu;

//import ClientSeite.Rooms;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
/** 
 *
 * @author alisi
 */
public class TCPClientMainMain implements Runnable {

    DataInputStream inStream;
    DataOutputStream outStream;
    Socket socket;
    private String clientMessage = "";
    private String serverMessage = "";
    Rooms room;
    private String ankommendeData;
    private boolean neueDataSenden = false;

    public TCPClientMainMain(Rooms room) {
        this.room = room;
        //   this.run();
        this.setNeueDataSenden(false);

    }

    @Override
    public void run() {
        ClientStart();
        while (true) {
            dataAnforden();
            System.out.println("NEU DATEN GESENDET");
            //sendeErstDaten();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TCPClientMainMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ClientStart() {
System.out.println("NEUE DATA FLAG -----" + this.isNeueDataSenden());
        try {

            socket = new Socket("192.168.2.38", 8888);
            inStream = new DataInputStream(socket.getInputStream());
            outStream = new DataOutputStream(socket.getOutputStream());

            sendeErstDaten();

//    sendeClientMessage("ISTDATAVORHANDEN");
        } catch (IOException ex) {
            Logger.getLogger(TCPClientMainMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendeErstDaten() {
        //    sendeClientMessage("SENDEDATA");
        if (!this.isNeueDataSenden()) {
            sendeClientMessage("SETSOLLDATA");
        }
        sendeClientMessage("ISTDATENVORHANDEN");
        sendeClientMessage("GETSTATUS");
    }

    synchronized public void dataAnforden() {

        try {
           sendeClientMessage("GETNEWISTDATA");
            sendeClientMessage("GETSTATUS");
            // sendeClientMessage("ISTDATENVORHANDEN");
            //  sendeClientMessage("START");

            //  System.out.println("NEUE DATA FLAG -----" + this.isNeueDataSenden());
            if (!this.isNeueDataSenden()) {
                sendeClientMessage("SETSOLLDATA");
            }
            Thread.sleep(1000);

        } catch (InterruptedException ex) {
            Logger.getLogger(TCPClientMainMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sendeClientMessage(String text) {
        try {
            switch (text) {
                case "GETNEWISTDATA":
                    setClientMessage("GETNEWISTDATA");//br.readLine();
                    outStream.writeUTF(getClientMessage());
                    outStream.flush();

                    this.setAnkommendeData(inStream.readUTF());

                    this.setServerMessage(this.getAnkommendeData());
                    dataInMenuAnzeigen(this.getAnkommendeData());
                    room.getCm().getjTextAreaClientSeite().setForeground(Color.red);//.setBackground(Color.red);
                    room.getCm().getjTextAreaClientSeite().append("CLIENT " + getClientMessage() + "  SERVER " + this.getServerMessage() + "\n");
//                    room.getCm().getjTextAreaClientSeite().append("CLIENT SENDET    " + getClientMessage() + "\n");
//                    room.getCm().getjTextAreaServerSeite().append("SERVER SENDET    " + this.getServerMessage() + "\n");
                    room.getCm().getjTextAreaClientSeite().setCaretPosition(room.getCm().getjTextAreaClientSeite().getDocument().getLength());
                   // room.getCm().getjTextAreaServerSeite().setCaretPosition(room.getCm().getjTextAreaServerSeite().getDocument().getLength());

                    break;
                case "GETSTATUS":
                    setClientMessage("GETSTATUS");//br.readLine();
                    outStream.writeUTF(getClientMessage());
                    outStream.flush();
                    setServerMessage(inStream.readUTF());
                    room.getCm().getjTextAreaClientSeite().setBackground(Color.GREEN);
                     room.getCm().getjTextAreaClientSeite().append("CLIENT " + getClientMessage() + "  SERVER " + this.getServerMessage() + "\n");
//                    room.getCm().getjTextAreaClientSeite().append("CLIENT SENDET    " + getClientMessage() + "\n");
//                    room.getCm().getjTextAreaServerSeite().append("SERVER SENDET    " + this.getServerMessage() + "\n");
                    room.getCm().getjTextAreaClientSeite().setCaretPosition(room.getCm().getjTextAreaClientSeite().getDocument().getLength());
//                    room.getCm().getjTextAreaServerSeite().setCaretPosition(room.getCm().getjTextAreaServerSeite().getDocument().getLength());
                    setStatusWord(getServerMessage());
                    setRelais();
                    break;

                case "SETSOLLDATA":
                    setClientMessage("SETSOLLDATA");
                    // Anforedung senden
                    outStream.writeUTF(getClientMessage());
                    outStream.flush();
                    // Rückantwort
                    setServerMessage(inStream.readUTF());
                    //prozessDaten Senden
                    room.updateProzessDaten();
                    outStream.writeUTF(room.getProzessDatenZurLaufzeit());
                    System.out.println(room.getProzessDatenZurLaufzeit());
                    outStream.flush();
                    // Rückantwort
                    setServerMessage(inStream.readUTF());

                    //  System.out.println("WARTEN AUF GODOT  " + getServerMessage());
                     room.getCm().getjTextAreaClientSeite().setBackground(Color.GREEN);
                    room.getCm().getjTextAreaClientSeite().append("CLIENT " + getClientMessage() + "  SERVER " + this.getServerMessage() + "\n");
              //      room.getCm().getjTextAreaServerSeite().append("SERVER SENDET    " + this.getServerMessage() + "\n");
                    room.getCm().getjTextAreaClientSeite().setCaretPosition(room.getCm().getjTextAreaClientSeite().getDocument().getLength());
              //      room.getCm().getjTextAreaServerSeite().setCaretPosition(room.getCm().getjTextAreaServerSeite().getDocument().getLength());
                    this.setNeueDataSenden(true);//isNeueDataSenden())

                    break;
                case "ISTDATENVORHANDEN":
                    setClientMessage("ISTDATENVORHANDEN");
                    outStream.writeUTF(getClientMessage());
                    outStream.flush();
                    setServerMessage(inStream.readUTF());
                      room.getCm().getjTextAreaClientSeite().setBackground(Color.GREEN);
                     room.getCm().getjTextAreaClientSeite().append("CLIENT " + getClientMessage() + "  SERVER " + this.getServerMessage() + "\n");
        //            room.getCm().getjTextAreaClientSeite().append("CLIENT SENDET    " + getClientMessage() + "\n");
          //          room.getCm().getjTextAreaServerSeite().append("SERVER SENDET    " + this.getServerMessage() + "\n");
//                    Runtime rt = Runtime.getRuntime();
//                    room.getCm().getjTextArea2().append("SPEICHER     " + rt.totalMemory()+"  "+rt.freeMemory()+"   "+(rt.totalMemory() - rt.freeMemory())+ "\n");
                    //    System.out.println(rt.totalMemory() - rt.freeMemory());
                    break;

                case "START":
                    setClientMessage("START");
                    outStream.writeUTF(getClientMessage());
                    outStream.flush();
                    setServerMessage(inStream.readUTF());
                      room.getCm().getjTextAreaClientSeite().setBackground(Color.red);
             room.getCm().getjTextAreaClientSeite().append("CLIENT " + getClientMessage() + "  SERVER " + this.getServerMessage() + "\n");
          //          room.getCm().getjTextAreaClientSeite().append("CLIENT SENDET    " + getClientMessage() + "\n");
          //          room.getCm().getjTextAreaServerSeite().append("SERVER SENDET    " + this.getServerMessage() + "\n");
                    break;
                default:

                    break;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(room.getCm(), "Connection invalid",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        //   room.getCm().getjTextArea2().removeAll();//.append
    }

   
    /**
     * @return the clientMessage
     */
    public String getClientMessage() {
        return clientMessage;
    }

    /**
     * @param clientMessage the clientMessage to set
     */
    public void setClientMessage(String clientMessage) {
        this.clientMessage = clientMessage;
    }

    /**
     * @return the serverMessage
     */
    public String getServerMessage() {
        return serverMessage;
    } 

    /**
     * @param serverMessage the serverMessage to set
     */
    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

     private void istDataVerteilung(String data){
         StringTokenizer st = new StringTokenizer(data, ";");
         room.roomPar.setZ1InIst(Float.valueOf(st.nextToken()));
         room.roomPar.setZ1OutIst(Float.valueOf(st.nextToken()));
         room.roomPar.setZ2InIst(Float.valueOf(st.nextToken()));
         room.roomPar.setZ1OutIst(Float.valueOf(st.nextToken()));
         
         room.roomPar.setZ1InIst(Float.valueOf(st.nextToken()));
         room.roomPar.setZ1InIst(Float.valueOf(st.nextToken()));
         room.roomPar.setZ1InIst(Float.valueOf(st.nextToken()));
         room.roomPar.setZ1InIst(Float.valueOf(st.nextToken()));
    }
    
    public void dataInMenuAnzeigen(String data) {
        StringTokenizer st = new StringTokenizer(data, ";");

        room.getCm().getjLabelZ1In().setText(st.nextToken());
        room.getCm().getjLabelZ1Out().setText(st.nextToken());
        room.getCm().getjLabelZ2In().setText(st.nextToken());
        room.getCm().getjLabelZ2Out().setText(st.nextToken());

        room.getCm().getjLabelManuel1().setText(st.nextToken());
        room.getCm().getjLabelManuel2().setText(st.nextToken());
        room.getCm().getjLabelManuel3().setText(st.nextToken());
        room.getCm().getjLabelManuel4().setText(st.nextToken());

          room.getCm().getjLabelMultiTemp().setText(room.getCm().getjLabelZ1In().getText());
        room.getCm().getjLabelMultiDamp().setText(room.getCm().getjLabelZ2In().getText());
        room.getCm().getjLabelMultiCo2().setText(room.getCm().getjLabelZ2In().getText());
        room.getCm().getjLabelMultiEthyl().setText(room.getCm().getjLabelZ2Out().getText());
        
        Color oldColor = room.getCm().getjLabelZ1In().getBackground();//.getCaretColor();
        if (Float.parseFloat(room.getCm().getjLabelZ1In().getText()) >= 30.0) {
            room.getCm().getjLabelZ1In().setBackground(Color.red);
        } else {
            room.getCm().getjLabelZ1In().setBackground(oldColor);
        }

        oldColor = room.getCm().getjLabelZ1Out().getBackground();//.getCaretColor()
        if (Float.parseFloat(room.getCm().getjLabelZ1Out().getText()) >= 30.0) {
            room.getCm().getjLabelZ1Out().setBackground(Color.red);
        } else {
            room.getCm().getjLabelZ1Out().setBackground(oldColor);
        }

        oldColor = room.getCm().getjLabelZ2In().getBackground();//.getCaretColor()
        if (Float.parseFloat(room.getCm().getjLabelZ2In().getText()) >= 30.0) {
            room.getCm().getjLabelZ2In().setBackground(Color.red);
        } else {
            room.getCm().getjLabelZ2In().setBackground(oldColor);
        }

        oldColor = room.getCm().getjLabelZ2Out().getBackground();//.getCaretColor()
        if (Float.parseFloat(room.getCm().getjLabelZ2Out().getText()) >= 30.0) {
            room.getCm().getjLabelZ2Out().setBackground(Color.red);
        } else {
            room.getCm().getjLabelZ2Out().setBackground(oldColor);
        }
        
        //
         oldColor = room.getCm().getjLabelManuel1().getBackground();//.getCaretColor()
        if (Float.parseFloat(room.getCm().getjLabelManuel1().getText()) >= 30.0) {
            room.getCm().getjLabelManuel1().setBackground(Color.red);
        } else {
            room.getCm().getjLabelManuel1().setBackground(oldColor);
        }
        
         oldColor = room.getCm().getjLabelManuel2().getBackground();//.getCaretColor()
        if (Float.parseFloat(room.getCm().getjLabelManuel2().getText()) >= 30.0) {
            room.getCm().getjLabelManuel2().setBackground(Color.red);
        } else {
            room.getCm().getjLabelManuel2().setBackground(oldColor);
        }
        
         oldColor = room.getCm().getjLabelManuel3().getBackground();//.getCaretColor()
        if (Float.parseFloat(room.getCm().getjLabelManuel3().getText()) >= 30.0) {
            room.getCm().getjLabelManuel3().setBackground(Color.red);
        } else {
            room.getCm().getjLabelManuel3().setBackground(oldColor);
        }

         oldColor = room.getCm().getjLabelManuel4().getBackground();//.getCaretColor()
        if (Float.parseFloat(room.getCm().getjLabelManuel4().getText()) >= 30.0) {
            room.getCm().getjLabelManuel4().setBackground(Color.red);
        } else {
            room.getCm().getjLabelManuel4().setBackground(oldColor);
        }
        
    }

    public void setStatusWord(String text1) {

        StringTokenizer st = new StringTokenizer(text1, ";");
        st.nextToken();
        room.setCirculatingLeft(Boolean.parseBoolean(st.nextToken()));
        st.nextToken();
        room.setCirculatingRight(Boolean.parseBoolean(st.nextToken()));
        st.nextToken();
        room.setSuction(Boolean.parseBoolean(st.nextToken()));
        st.nextToken();
        room.setDamp(Boolean.parseBoolean(st.nextToken()));
        st.nextToken();
        room.setCo2(Boolean.parseBoolean(st.nextToken()));
        st.nextToken();
        room.setEthylen(Boolean.parseBoolean(st.nextToken()));
        st.nextToken();
        room.setCooler(Boolean.parseBoolean(st.nextToken()));
        st.nextToken();
        room.setHeater(Boolean.parseBoolean(st.nextToken()));

    }

    public void setRelais() {

        if (room.isCirculatingLeft()) {
            room.getCm().getjButtonCircLeft().setBackground(Color.red);
        } else {
            room.getCm().getjButtonCircLeft().setBackground(Color.GREEN);
        }

        if (room.isCirculatingRight()) {
            room.getCm().getjButtonCircRight().setBackground(Color.red);
        } else {
            room.getCm().getjButtonCircRight().setBackground(Color.GREEN);
        }

        if (room.isSuction()) {
            room.getCm().getjButtonSuction().setBackground(Color.red);
        } else {
            room.getCm().getjButtonSuction().setBackground(Color.GREEN);
        }
        if (room.isDamp()) {
            room.getCm().getjButtonDamper().setBackground(Color.red);
        } else {
            room.getCm().getjButtonDamper().setBackground(Color.GREEN);
        }
        if (room.isCo2()) {
            room.getCm().getjButtonFreshAir().setBackground(Color.red);
        } else {
            room.getCm().getjButtonFreshAir().setBackground(Color.GREEN);
        }
        if (room.isHeater()) {
            room.getCm().getjButtonHeater().setBackground(Color.red);
        } else {
            room.getCm().getjButtonHeater().setBackground(Color.GREEN);
        }
        if (room.isCooler()) {
            room.getCm().getjButtonCooler().setBackground(Color.red);
        } else {
            room.getCm().getjButtonCooler().setBackground(Color.GREEN);
        }
        if (room.isEthylen()) {
            room.getCm().getjButtonEthylen().setBackground(Color.red);
        } else {
            room.getCm().getjButtonEthylen().setBackground(Color.GREEN);
        }
    }

//    public static void main(String[] args) {
//        TCPClientMainMain tcp = new TCPClientMainMain();
//
//    }
    /**
     * @return the ankommendeData
     */
    public String getAnkommendeData() {
        return ankommendeData;
    }

    /**
     * @param ankommendeData the ankommendeData to set
     */
    public void setAnkommendeData(String ankommendeData) {
        this.ankommendeData = ankommendeData;
    }

    /**
     * @return the neueDataSenden
     */
    public boolean isNeueDataSenden() {
        return neueDataSenden;
    }

    /**
     * @param neueDataSenden the neueDataSenden to set
     */
    public void setNeueDataSenden(boolean neueDataSenden) {
        this.neueDataSenden = neueDataSenden;
    }

}
