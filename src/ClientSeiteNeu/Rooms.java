/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientSeiteNeu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alisi
 */
public final class Rooms {

    /**
     * @return the cm
     */
    public ChartMenu getCm() {
        return cm;
    }

    /**
     * @param cm the cm to set
     */
    public void setCm(ChartMenu cm) {
        this.cm = cm;
    }



    final private String os = System.getProperty("os.name").toLowerCase();
    private String path;
    //   private String parameterPath;
    private String dataPath;
    private String grundPath;
    private String dataPathName;

    private String konfFileName;
    private boolean circulatingLeft, circulatingRight, suction, damp, co2, ethylen, cooler, heater = false;
    Properties prop;
    private SplitKonfiguration sc;
    private GrundDaten gd;
    private ChartMenu cm;

    private String parametersListe;
    private String prozessDatenZurLaufzeit;
    private JDateChooser selectedDate;

    private String dateBegin;
    private String timeBegin;
    private Boolean startTimer = false;
    Countdown cd;
    RoomParameters roomPar;
    public Rooms(SplitKonfiguration sc, GrundDaten gd, ChartMenu cm, Countdown cd,RoomParameters roomPar) {
        //     this.setParameterPath(checkPaths("PrgParameters"));
        this.cd = cd;
        this.sc = sc;
        this.gd = gd;
        this.cm = cm;
        this.roomPar=roomPar;

        parametersListe = parameterListeErzeugen();

        gd.aktiveRoomPathSetzen("Room1");
        if (gd.getOs().contains("win")) {

            String fName = gd.getAktiveRoomPath() + "\\parameterListe" + gd.getAktiveRoomName() + ".txt";
            datenAusDemSpeicherZurLaufZeit(fName);
            prozessDatenZurLaufzeit = dataFurDenServerProzessVorbereiten(gd.getAktiveRoomPath() + "\\parameterListe" + gd.getAktiveRoomName() + ".txt");
            menuSave();
            getDuration();
            updateProzessDaten();
            getProzessDatenZurLaufzeit();
            getDuration();

        }

        if (gd.getOs().contains("linux")) {
            System.out.println("LINUX   " + gd.getAktiveRoomPath() + "  " + gd.getAktiveRoomName());
            String fName = gd.getAktiveRoomPath() + "/parameterListe" + gd.getAktiveRoomName() + ".txt";
            datenAusDemSpeicherZurLaufZeit(fName);
            prozessDatenZurLaufzeit = dataFurDenServerProzessVorbereiten(gd.getAktiveRoomPath() + "/parameterListe" + gd.getAktiveRoomName() + ".txt");
            menuSave();
            getDuration();
            updateProzessDaten();
            getProzessDatenZurLaufzeit();
        }
    }

    public void updateProzessDaten() {
        if (gd.getOs().contains("win")) {
            setProzessDatenZurLaufzeit(dataFurDenServerProzessVorbereiten(gd.getAktiveRoomPath() + "\\parameterListe" + gd.getAktiveRoomName() + ".txt"));
        }
        if (gd.getOs().contains("linux")) {
            setProzessDatenZurLaufzeit(dataFurDenServerProzessVorbereiten(gd.getAktiveRoomPath() + "/parameterListe" + gd.getAktiveRoomName() + ".txt"));
        }
    }

    public String dataFurDenServerProzessVorbereiten(String fileName) {

        //DIESER erzugter Text wir an den Server gesendet
        //       System.out.println("Parameter liste für den Server        " + parameterName);
        //     System.out.println("File Name        " + fileName);
        String text1 = "";
        StringTokenizer st = new StringTokenizer(parametersListe, ";");

        try (InputStream input = new FileInputStream(fileName)) {

            Properties prop1 = new Properties();

            // load a properties file
            prop1.load(input);

            text1 = st.nextToken() + ";" + roomPar.getROOMNAME() + ";"
                    + st.nextToken() + ";" + roomPar.getUSERSELECTION() + ";"
                    + st.nextToken() + ";" + roomPar.getPRODUKTSELECTION() + ";"
                    + st.nextToken() + ";" + roomPar.getPRODUKTNRSELECTION() + ";"
                    + st.nextToken() + ";" + roomPar.getSPLITMENGE() + ";"
                    + st.nextToken() + ";" + roomPar.getETHYLSETPUTTIME() + ";"
                    + st.nextToken() + ";" + roomPar.getDELAYTIMEETHYLTOMES() + ";"
                    + st.nextToken() + ";" + roomPar.getCIRCULATINGAIR() + ";"
                    + st.nextToken() + ";" + roomPar.getCIRCULATINAIRDELAY() + ";"
                    + st.nextToken() + ";" + roomPar.getHEATERDELAY() + ";"
                    + st.nextToken() + ";" + roomPar.getCOOLERDELAY() + ";"
                    + st.nextToken() + ";" + roomPar.getDAMPERDELAY() + ";"
                    + st.nextToken() + ";" + roomPar.getFRESHAIRDELAY() + ";"
                    + st.nextToken() + ";" + roomPar.getBEGINTIMEHOUR() + ";"
                    + st.nextToken() + ";" + roomPar.getBEGINTIMEMIN() + ";"
                    + st.nextToken() + ";" + roomPar.getIPADRESS() + ";"
                    + st.nextToken() + ";" + roomPar.getPORTNR() + ";"
                    + st.nextToken() + ";" + roomPar.getS1DURATIONDAY() + ";"
                    + st.nextToken() + ";" + roomPar.getS1DURATIONHOUR() + ";"
                    + st.nextToken() + ";" + roomPar.getS1DURATIONMIN() + ";"
                    + st.nextToken() + ";" + roomPar.getS1SETTEMP() + ";"
                    + st.nextToken() + ";" + roomPar.getS1SETTEMPTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS1SETHUM() + ";"
                    + st.nextToken() + ";" + roomPar.getS1SETHUMTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS1SETCO2() + ";"
                    + st.nextToken() + ";" + roomPar.getS1SETCO2TOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS1SETETHYL() + ";"
                    + st.nextToken() + ";" + roomPar.getS1SETETHYLTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS2DURATIONDAY() + ";"
                    + st.nextToken() + ";" + roomPar.getS2DURATIONHOUR() + ";"
                    + st.nextToken() + ";" + roomPar.getS2DURATIONMIN() + ";"
                    + st.nextToken() + ";" + roomPar.getS2SETTEMP() + ";"
                    + st.nextToken() + ";" + roomPar.getS2SETTEMPTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS2SETHUM() + ";"
                    + st.nextToken() + ";" + roomPar.getS2SETHUMTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS2SETCO2() + ";"
                    + st.nextToken() + ";" + roomPar.getS2SETCO2TOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS2SETETHYL() + ";"
                    + st.nextToken() + ";" + roomPar.getS2SETETHYLTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS3DURATIONDAY() + ";"
                    + st.nextToken() + ";" + roomPar.getS3DURATIONHOUR() + ";"
                    + st.nextToken() + ";" + roomPar.getS3DURATIONMIN() + ";"
                    + st.nextToken() + ";" + roomPar.getS3SETTEMP() + ";"
                    + st.nextToken() + ";" + roomPar.getS3SETTEMPTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS3SETHUM() + ";"
                    + st.nextToken() + ";" + roomPar.getS3SETHUMTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS3SETCO2() + ";"
                    + st.nextToken() + ";" + roomPar.getS3SETCO2TOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS3SETETHYL() + ";"
                    + st.nextToken() + ";" + roomPar.getS3SETETHYLTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS4DURATIONDAY() + ";"
                    + st.nextToken() + ";" + roomPar.getS4DURATIONHOUR() + ";"
                    + st.nextToken() + ";" + roomPar.getS4DURATIONMIN() + ";"
                    + st.nextToken() + ";" + roomPar.getS4SETTEMP() + ";"
                    + st.nextToken() + ";" + roomPar.getS4SETTEMPTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS4SETHUM() + ";"
                    + st.nextToken() + ";" + roomPar.getS4SETHUMTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS4SETCO2() + ";"
                    + st.nextToken() + ";" + roomPar.getS4SETCO2TOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS4SETETHYL() + ";"
                    + st.nextToken() + ";" + roomPar.getS4SETETHYLTOL() + ";"
                    + st.nextToken() + ";" + roomPar.getS1DURATION() + ";"
                    + st.nextToken() + ";" + roomPar.getS1STARTDATE() + ";"
                    + st.nextToken() + ";" + roomPar.getS2DURATION() + ";"
                    + st.nextToken() + ";" + roomPar.getS2STARTDATE() + ";"
                    + st.nextToken() + ";" + roomPar.getS3DURATION() + ";"
                    + st.nextToken() + ";" + roomPar.getS3STARTDATE() + ";"
                    + st.nextToken() + ";" + roomPar.getS4DURATION() + ";"
                    + st.nextToken() + ";" + roomPar.getS4STARTDATE() + ";"
                    + st.nextToken() + ";" + roomPar.getPROZESSBEGINN() + ";"
                    + st.nextToken() + ";" + roomPar.getPROZESSEND();

            System.out.println("PROZESSDATEN ZUM SERVER  " + text1);
            input.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return text1;
    }

    public String parameterListeErzeugen() {
        String text;
        text = "ROOMNAME"
                + ";" + "USERSELECTION"
                + ";" + "PRODUKTSELECTION"
                + ";" + "PRODUKTNRSELECTION"
                + ";" + "SPLITMENGE"
                + ";" + "ETHYLSETPUTTIME"
                + ";" + "DELAYTIMEETHYLTOMES"
                + ";" + "CIRCULATINGAIR"
                + ";" + "CIRCULATINAIRDEL"
                + ";" + "HEATERDELAY"
                + ";" + "COOLERDELAY"
                + ";" + "DAMPERDELAY"
                + ";" + "FRESHAIRDELAY"
                + ";" + "BEGINTIMEHOUR"
                + ";" + "BEGINTIMEMIN"
                + ";" + "IPADRESS"
                + ";" + "PORTNR"
                + ";" + "S1DURATIONDAY"
                + ";" + "S1DURATIONHOUR"
                + ";" + "S1DURATIONMIN"
                + ";" + "S1SETTEMP"
                + ";" + "S1SETTEMPTOL"
                + ";" + "S1SETHUM"
                + ";" + "S1SETHUMTOL"
                + ";" + "S1SETCO2"
                + ";" + "S1SETCO2TOL"
                + ";" + "S1SETETHYL"
                + ";" + "S1SETETHYLTOL"
                + ";" + "S2DURATIONDAY"
                + ";" + "S2DURATIONHOUR"
                + ";" + "S2DURATIONMIN"
                + ";" + "S2SETTEMP"
                + ";" + "S2SETTEMPTOL"
                + ";" + "S2SETHUM"
                + ";" + "S2SETHUMTOL"
                + ";" + "S2SETCO2"
                + ";" + "S2SETCO2TOL"
                + ";" + "S2SETETHYL"
                + ";" + "S2SETETHYLTOL"
                + ";" + "S3DURATIONDAY"
                + ";" + "S3DURATIONHOUR"
                + ";" + "S3DURATIONMIN"
                + ";" + "S3SETTEMP"
                + ";" + "S3SETTEMPTOL"
                + ";" + "S3SETHUM"
                + ";" + "S3SETHUMTOL"
                + ";" + "S3SETCO2"
                + ";" + "S3SETCO2TOL"
                + ";" + "S3SETETHYL"
                + ";" + "S3SETETHYLTOL"
                + ";" + "S4DURATIONDAY"
                + ";" + "S4DURATIONHOUR"
                + ";" + "S4DURATIONMIN"
                + ";" + "S4SETTEMP"
                + ";" + "S4SETTEMPTOL"
                + ";" + "S4SETHUM"
                + ";" + "S4SETHUMTOL"
                + ";" + "S4SETCO2"
                + ";" + "S4SETCO2TOL"
                + ";" + "S4SETETHYL"
                + ";" + "S4SETETHYLTOL"
                + ";" + "S1DURATION"
                + ";" + "S1STARTDATE"
                + ";" + "S2DURATION"
                + ";" + "S2STARTDATE"
                + ";" + "S3DURATION"
                + ";" + "S3STARTDATE"
                + ";" + "S4DURATION"
                + ";" + "S4STARTDATE"
                + ";" + "PROZESSBEGINN"
                + ";" + "PROZESSEND";
        System.out.println("PARAMETERLISTE -       " + text + "\n");
        return text;
    }

    public void upDateMenuDaten() {
// Die Laufzeitdaten aus dem Speicher lesen mit Parameter liste aktualisieren  
        String fName = gd.getAktiveRoomPath() + "/parameterListe" + gd.getAktiveRoomName() + ".txt";
        datenAusDemSpeicherZurLaufZeit(fName);
    }

    public void datenAusDemSpeicherZurLaufZeit(String fileName) {
        //   parametersListe = parameterListeErzeugen();

        //    System.out.println("DATEN AUS DEM SPEICHER   " + fileName);
        String[] text;

        StringTokenizer st = new StringTokenizer(parametersListe, ";");

        try (InputStream input = new FileInputStream(fileName)) {

            Properties prop1 = new Properties();

            // load a properties file
            prop1.load(input);
            roomPar.setROOMNAME(prop1.getProperty(st.nextToken()));
            roomPar.setUSERSELECTION(prop1.getProperty(st.nextToken()));
            roomPar.setPRODUKTSELECTION(prop1.getProperty(st.nextToken()));//, getPRODUKTSELECTION());
            roomPar.setPRODUKTNRSELECTION(prop1.getProperty(st.nextToken()));
            roomPar.setSPLITMENGE(prop1.getProperty(st.nextToken()));
            roomPar.setETHYLSETPUTTIME(prop1.getProperty(st.nextToken()));
            roomPar.setDELAYTIMEETHYLTOMES(prop1.getProperty(st.nextToken()));
            roomPar.setCIRCULATINGAIR(prop1.getProperty(st.nextToken()));
            roomPar.setCIRCULATINAIRDELAY(prop1.getProperty(st.nextToken()));//, getCIRCULATINAIRDELAY());
            roomPar.setHEATERDELAY(prop1.getProperty(st.nextToken()));//, getHEATERDELAY());
            roomPar.setCOOLERDELAY(prop1.getProperty(st.nextToken()));//, getCOOLERDELAY());
            roomPar.setDAMPERDELAY(prop1.getProperty(st.nextToken()));//, getDAMPERDELAY());
            roomPar.setFRESHAIRDELAY(prop1.getProperty(st.nextToken()));//, getFRESHAIRDELAY());
            roomPar.setBEGINTIMEHOUR(prop1.getProperty(st.nextToken()));//, getBEGINTIMEHOUR());
            roomPar.setBEGINTIMEMIN(prop1.getProperty(st.nextToken()));//, getBEGINTIMEMIN());
            roomPar.setIPADRESS(prop1.getProperty(st.nextToken()));//, getIPADRESS());
            roomPar.setPORTNR(prop1.getProperty(st.nextToken()));//, getPORTNR());
            roomPar.setS1DURATIONDAY(prop1.getProperty(st.nextToken()));//, getS1DURATIONDAY());
            roomPar.setS1DURATIONHOUR(prop1.getProperty(st.nextToken()));//, getS1DURATIONHOUR());
            roomPar.setS1DURATIONMIN(prop1.getProperty(st.nextToken()));//, getS1DURATIONMIN());
            roomPar.setS1SETTEMP(prop1.getProperty(st.nextToken()));//, getS1SETTEMP());
            roomPar.setS1SETTEMPTOL(prop1.getProperty(st.nextToken()));//, getS1SETTEMPTOL());
            roomPar.setS1SETHUM(prop1.getProperty(st.nextToken()));
            roomPar.setS1SETHUMTOL(prop1.getProperty(st.nextToken()));
            roomPar.setS1SETCO2(prop1.getProperty(st.nextToken()));
            roomPar.setS1SETCO2TOL(prop1.getProperty(st.nextToken()));//, getS1SETCO2TOL());
            roomPar.setS1SETETHYL(prop1.getProperty(st.nextToken()));//, getS1SETETHYL());
            roomPar.setS1SETETHYLTOL(prop1.getProperty(st.nextToken()));//, getS1SETETHYLTOL());
            //2
            //////////////////////////////////
            roomPar.setS2DURATIONDAY(prop1.getProperty(st.nextToken()));//, getS2DURATIONDAY());
            roomPar.setS2DURATIONHOUR(prop1.getProperty(st.nextToken()));//, getS2DURATIONHOUR());
            roomPar.setS2DURATIONMIN(prop1.getProperty(st.nextToken()));//, getS2DURATIONMIN());
            roomPar.setS2SETTEMP(prop1.getProperty(st.nextToken()));//, getS2SETTEMP());
            roomPar.setS2SETTEMPTOL(prop1.getProperty(st.nextToken()));//, getS2SETTEMPTOL());
            roomPar.setS2SETHUM(prop1.getProperty(st.nextToken()));
            roomPar.setS2SETHUMTOL(prop1.getProperty(st.nextToken()));
            roomPar.setS2SETCO2(prop1.getProperty(st.nextToken()));
            roomPar.setS2SETCO2TOL(prop1.getProperty(st.nextToken()));//, getS2SETCO2TOL());
            roomPar.setS2SETETHYL(prop1.getProperty(st.nextToken()));//, getS2SETETHYL());
            roomPar.setS2SETETHYLTOL(prop1.getProperty(st.nextToken()));//, getS2SETETHYLTOL());
            //////////// 3
            roomPar.setS3DURATIONDAY(prop1.getProperty(st.nextToken()));//, getS3DURATIONDAY());
            roomPar.setS3DURATIONHOUR(prop1.getProperty(st.nextToken()));//, getS3DURATIONHOUR());
            roomPar.setS3DURATIONMIN(prop1.getProperty(st.nextToken()));//, getS3DURATIONMIN());
            roomPar.setS3SETTEMP(prop1.getProperty(st.nextToken()));//, getS3SETTEMP());
            roomPar.setS3SETTEMPTOL(prop1.getProperty(st.nextToken()));//, getS3SETTEMPTOL());
            roomPar.setS3SETHUM(prop1.getProperty(st.nextToken()));
            roomPar.setS3SETHUMTOL(prop1.getProperty(st.nextToken()));
            roomPar.setS3SETCO2(prop1.getProperty(st.nextToken()));
            roomPar.setS3SETCO2TOL(prop1.getProperty(st.nextToken()));//, getS3SETCO2TOL());
            roomPar.setS3SETETHYL(prop1.getProperty(st.nextToken()));//, getS3SETETHYL());
            roomPar.setS3SETETHYLTOL(prop1.getProperty(st.nextToken()));//, getS3SETETHYLTOL());
            ///////////// 4
            roomPar.setS4DURATIONDAY(prop1.getProperty(st.nextToken()));//, getS4DURATIONDAY());
            roomPar.setS4DURATIONHOUR(prop1.getProperty(st.nextToken()));//, getS4DURATIONHOUR());
            roomPar.setS4DURATIONMIN(prop1.getProperty(st.nextToken()));//, getS4DURATIONMIN());
            roomPar.setS4SETTEMP(prop1.getProperty(st.nextToken()));//, getS4SETTEMP());
            roomPar.setS4SETTEMPTOL(prop1.getProperty(st.nextToken()));//, getS4SETTEMPTOL());
            roomPar.setS4SETHUM(prop1.getProperty(st.nextToken()));
            roomPar.setS4SETHUMTOL(prop1.getProperty(st.nextToken()));
            roomPar.setS4SETCO2(prop1.getProperty(st.nextToken()));
            roomPar.setS4SETCO2TOL(prop1.getProperty(st.nextToken()));//, getS4SETCO2TOL());
            roomPar.setS4SETETHYL(prop1.getProperty(st.nextToken()));//, getS4SETETHYL());
            roomPar.setS4SETETHYLTOL(prop1.getProperty(st.nextToken()));//, getS4SETETHYLTOL());

            roomPar.setS1DURATION(prop1.getProperty(st.nextToken()));
            roomPar.setS1STARTDATE(prop1.getProperty(st.nextToken()));

            roomPar.setS2DURATION(prop1.getProperty(st.nextToken()));
            roomPar.setS2STARTDATE(prop1.getProperty(st.nextToken()));

            roomPar.setS3DURATION(prop1.getProperty(st.nextToken()));
            roomPar.setS3STARTDATE(prop1.getProperty(st.nextToken()));

            roomPar.setS4DURATION(prop1.getProperty(st.nextToken()));
            roomPar.setS4STARTDATE(prop1.getProperty(st.nextToken()));

            roomPar.setPROZESSBEGINN(prop1.getProperty(st.nextToken()));
            roomPar.setPROZESSEND(prop1.getProperty(st.nextToken()));
            input.close();
            menuUpdateSchreiben();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void menuSave() {
        // menuParameterSetzen();
        String text = parametersListe;
        String fileName = gd.getAktiveRoomPath() + "\\parameterListe" + gd.getAktiveRoomName() + ".txt";
        menuLesenInDieLaufzeit();
        prop = new Properties();
        FileOutputStream fr;

//        System.out.println("After Loading properties ISNNANA asdasdasd   " + fileName);
//        System.out.println(" xxxxxxxxxxxxxxxx  " + text);
        File file = new File(fileName);
        //  System.out.println("After Loading properties ISNNANA: " + roomPar.getDataPathName());
        StringTokenizer st = new StringTokenizer(text, ";");
        //     System.out.println("After Loading properties ISNNANA: " + st.nextToken()+"  "+st.nextToken()+"  "+st.nextToken());

        try {
            fr = new FileOutputStream(file);
            prop.setProperty(st.nextToken(), roomPar.getROOMNAME());
            prop.setProperty(st.nextToken(), roomPar.getUSERSELECTION());
            prop.setProperty(st.nextToken(), roomPar.getPRODUKTSELECTION());
            prop.setProperty(st.nextToken(), roomPar.getPRODUKTNRSELECTION());
            prop.setProperty(st.nextToken(), roomPar.getSPLITMENGE());
            prop.setProperty(st.nextToken(), roomPar.getETHYLSETPUTTIME());
            prop.setProperty(st.nextToken(), roomPar.getDELAYTIMEETHYLTOMES());
            prop.setProperty(st.nextToken(), roomPar.getCIRCULATINGAIR());
            prop.setProperty(st.nextToken(), roomPar.getCIRCULATINAIRDELAY());
            prop.setProperty(st.nextToken(), roomPar.getHEATERDELAY());
            prop.setProperty(st.nextToken(), roomPar.getCOOLERDELAY());
            prop.setProperty(st.nextToken(), roomPar.getDAMPERDELAY());
            prop.setProperty(st.nextToken(), roomPar.getFRESHAIRDELAY());
            prop.setProperty(st.nextToken(), roomPar.getBEGINTIMEHOUR());
            prop.setProperty(st.nextToken(), roomPar.getBEGINTIMEMIN());
            prop.setProperty(st.nextToken(), roomPar.getIPADRESS());
            prop.setProperty(st.nextToken(), roomPar.getPORTNR());
            prop.setProperty(st.nextToken(), roomPar.getS1DURATIONDAY());
            prop.setProperty(st.nextToken(), roomPar.getS1DURATIONHOUR());
            prop.setProperty(st.nextToken(), roomPar.getS1DURATIONMIN());
            prop.setProperty(st.nextToken(), roomPar.getS1SETTEMP());
            prop.setProperty(st.nextToken(), roomPar.getS1SETTEMPTOL());
            prop.setProperty(st.nextToken(), roomPar.getS1SETHUM());
            prop.setProperty(st.nextToken(), roomPar.getS1SETHUMTOL());
            prop.setProperty(st.nextToken(), roomPar.getS1SETCO2());
            prop.setProperty(st.nextToken(), roomPar.getS1SETCO2TOL());
            prop.setProperty(st.nextToken(), roomPar.getS1SETETHYL());
            prop.setProperty(st.nextToken(), roomPar.getS1SETETHYLTOL());
            prop.setProperty(st.nextToken(), roomPar.getS2DURATIONDAY());
            prop.setProperty(st.nextToken(), roomPar.getS2DURATIONHOUR());
            prop.setProperty(st.nextToken(), roomPar.getS2DURATIONMIN());
            prop.setProperty(st.nextToken(), roomPar.getS2SETTEMP());
            prop.setProperty(st.nextToken(), roomPar.getS2SETTEMPTOL());
            prop.setProperty(st.nextToken(), roomPar.getS2SETHUM());
            prop.setProperty(st.nextToken(), roomPar.getS2SETHUMTOL());
            prop.setProperty(st.nextToken(), roomPar.getS2SETCO2());
            prop.setProperty(st.nextToken(), roomPar.getS2SETCO2TOL());
            prop.setProperty(st.nextToken(), roomPar.getS2SETETHYL());
            prop.setProperty(st.nextToken(), roomPar.getS2SETETHYLTOL());
//2 ENDE
            prop.setProperty(st.nextToken(), roomPar.getS3DURATIONDAY());
            prop.setProperty(st.nextToken(), roomPar.getS3DURATIONHOUR());
            prop.setProperty(st.nextToken(), roomPar.getS3DURATIONMIN());
            prop.setProperty(st.nextToken(), roomPar.getS3SETTEMP());
            prop.setProperty(st.nextToken(), roomPar.getS3SETTEMPTOL());
            prop.setProperty(st.nextToken(), roomPar.getS3SETHUM());
            prop.setProperty(st.nextToken(), roomPar.getS3SETHUMTOL());
            prop.setProperty(st.nextToken(), roomPar.getS3SETCO2());
            prop.setProperty(st.nextToken(), roomPar.getS3SETCO2TOL());
            prop.setProperty(st.nextToken(), roomPar.getS3SETETHYL());
            prop.setProperty(st.nextToken(), roomPar.getS3SETETHYLTOL());
// 3 Ende
            prop.setProperty(st.nextToken(), roomPar.getS4DURATIONDAY());
            prop.setProperty(st.nextToken(), roomPar.getS4DURATIONHOUR());
            prop.setProperty(st.nextToken(), roomPar.getS4DURATIONMIN());
            prop.setProperty(st.nextToken(), roomPar.getS4SETTEMP());
            prop.setProperty(st.nextToken(), roomPar.getS4SETTEMPTOL());
            prop.setProperty(st.nextToken(), roomPar.getS4SETHUM());
            prop.setProperty(st.nextToken(), roomPar.getS4SETHUMTOL());
            prop.setProperty(st.nextToken(), roomPar.getS4SETCO2());
            prop.setProperty(st.nextToken(), roomPar.getS4SETCO2TOL());
            prop.setProperty(st.nextToken(), roomPar.getS4SETETHYL());
            prop.setProperty(st.nextToken(), roomPar.getS4SETETHYLTOL());
            
             prop.setProperty(st.nextToken(), roomPar.getS4SETETHYLTOL());
// 4 Ende 
            prop.store(fr, null);
            fr.close();
            menuUpdateSchreiben();

            //        System.out.println("After saving properties:cccccccccccc " + prop);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
// Aktuelle Menu Daten Lesen in die Parametersliste
    public void menuLesenInDieLaufzeit() {

        roomPar.setROOMNAME(getSc().getRoomName().getSelectedItem().toString());
        roomPar.setPRODUKTNRSELECTION(getSc().getProduktNrSelection().getSelectedItem().toString());
        roomPar.setPRODUKTSELECTION(getSc().getProduktSelection().getSelectedItem().toString());
        roomPar.setUSERSELECTION(getSc().getUserSelection().getSelectedItem().toString());
        roomPar.setSPLITMENGE(getSc().getSplitMenge().getSelectedItem().toString());

        roomPar.setBEGINTIMEHOUR(getSc().getBeginTimeHour().getSelectedItem().toString());
        roomPar.setBEGINTIMEMIN(getSc().getBeginTimeMin().getSelectedItem().toString());
        roomPar.setIPADRESS(getSc().getIpAddress().getText());
        roomPar.setPORTNR(getSc().getPortNr().getText());

        roomPar.setCIRCULATINGAIR(getSc().getcirculatingAir().getSelectedItem().toString());
        roomPar.setCIRCULATINAIRDELAY(String.valueOf(getSc().getCirculatingAirDelay1().getSelectedItem()));
        roomPar.setCOOLERDELAY(getSc().getCoolDelay1().getSelectedItem().toString());
        roomPar.setHEATERDELAY(getSc().getHeaterDelay1().getSelectedItem().toString());
        roomPar.setDAMPERDELAY(getSc().getDamperDelay1().getSelectedItem().toString());
        roomPar.setFRESHAIRDELAY(getSc().getFreshAirDelay1().getSelectedItem().toString());
        roomPar.setETHYLSETPUTTIME(getSc().getEthylSetPutTime1().getSelectedItem().toString());
        roomPar.setDELAYTIMEETHYLTOMES(getSc().getDelayTimeEthylToMessung1().getSelectedItem().toString());
//
        roomPar.setS1DURATIONDAY(getSc().getSplitDurationDay1().getSelectedItem().toString());
        roomPar.setS1DURATIONHOUR(getSc().getSplitDurationHour1().getSelectedItem().toString());
        roomPar.setS1DURATIONMIN(getSc().getSplitDurationMin1().getSelectedItem().toString());

        roomPar.setS1SETTEMP(Integer.toString(getSc().getSplitTemp1().getValue()));
        roomPar.setS1SETTEMPANZEIGE(getSc().getSplitTempAnzeige1().getText());
        roomPar.setS1SETTEMPTOL(getSc().getSplitTempTol1().getSelectedItem().toString());

        roomPar.setS1SETHUM(Integer.toString(getSc().getSplitHum1().getValue()));
        roomPar.setS1SETHUMANZEIGE(getSc().getSplitHumAnzeige1().getText());
        roomPar.setS1SETHUMTOL(getSc().getSplitHumTol1().getSelectedItem().toString());

        roomPar.setS1SETCO2(Integer.toString(getSc().getSplitCo21().getValue()));
        roomPar.setS1SETCO2ANZEIGE(getSc().getSplitCo2Anzeige1().getText());
        roomPar.setS1SETCO2TOL(getSc().getSplitCo2Tol1().getSelectedItem().toString());

        roomPar.setS1SETETHYL(Integer.toString(getSc().getSplitEthyl1().getValue()));
        roomPar.setS1SETETHYLANZEIGE(getSc().getSplitEthylAnzeige1().getText());
        roomPar.setS1SETETHYLTOL(getSc().getSplitEthylTol1().getSelectedItem().toString());

        roomPar.setS2DURATIONDAY(getSc().getSplitDurationDay2().getSelectedItem().toString());
        roomPar.setS2DURATIONHOUR(getSc().getSplitDurationHour2().getSelectedItem().toString());
        roomPar.setS2DURATIONMIN(getSc().getSplitDurationMin2().getSelectedItem().toString());

        roomPar.setS2SETTEMP(Integer.toString(getSc().getSplitTemp2().getValue()));
        roomPar.setS2SETTEMPANZEIGE(getSc().getSplitTempAnzeige2().getText());
        roomPar.setS2SETTEMPTOL(getSc().getSplitTempTol2().getSelectedItem().toString());

        roomPar.setS2SETHUM(Integer.toString(getSc().getSplitHum2().getValue()));
        roomPar.setS2SETHUMANZEIGE(getSc().getSplitHumAnzeige2().getText());
        roomPar.setS2SETHUMTOL(getSc().getSplitHumTol2().getSelectedItem().toString());

        roomPar.setS2SETCO2(Integer.toString(getSc().getSplitCo22().getValue()));
        roomPar.setS2SETCO2ANZEIGE(getSc().getSplitCo2Anzeige2().getText());
        roomPar.setS2SETCO2TOL(getSc().getSplitCo2Tol2().getSelectedItem().toString());

        roomPar.setS2SETETHYL(Integer.toString(getSc().getSplitEthyl2().getValue()));
        roomPar.setS2SETETHYLANZEIGE(getSc().getSplitEthylAnzeige2().getText());
        roomPar.setS2SETETHYLTOL(getSc().getSplitEthylTol2().getSelectedItem().toString());

        roomPar.setS3DURATIONDAY(getSc().getSplitDurationDay3().getSelectedItem().toString());
        roomPar.setS3DURATIONHOUR(getSc().getSplitDurationHour3().getSelectedItem().toString());
        roomPar.setS3DURATIONMIN(getSc().getSplitDurationMin3().getSelectedItem().toString());

        roomPar.setS3SETTEMP(Integer.toString(getSc().getSplitTemp3().getValue()));
        roomPar.setS3SETTEMPANZEIGE(getSc().getSplitTempAnzeige3().getText());
        roomPar.setS3SETTEMPTOL(getSc().getSplitTempTol3().getSelectedItem().toString());

        roomPar.setS3SETHUM(Integer.toString(getSc().getSplitHum3().getValue()));
        roomPar.setS3SETHUMANZEIGE(getSc().getSplitHumAnzeige3().getText());
        roomPar.setS3SETHUMTOL(getSc().getSplitHumTol3().getSelectedItem().toString());

        roomPar.setS3SETCO2(Integer.toString(getSc().getSplitCo23().getValue()));
        roomPar.setS3SETCO2ANZEIGE(getSc().getSplitCo2Anzeige3().getText());
        roomPar.setS3SETCO2TOL(getSc().getSplitCo2Tol3().getSelectedItem().toString());

        roomPar.setS3SETETHYL(Integer.toString(getSc().getSplitEthyl3().getValue()));
        roomPar.setS3SETETHYLANZEIGE(getSc().getSplitEthylAnzeige3().getText());
        roomPar.setS3SETETHYLTOL(getSc().getSplitEthylTol3().getSelectedItem().toString());

        roomPar.setS4DURATIONDAY(getSc().getSplitDurationDay4().getSelectedItem().toString());
        roomPar.setS4DURATIONHOUR(getSc().getSplitDurationHour4().getSelectedItem().toString());
        roomPar.setS4DURATIONMIN(getSc().getSplitDurationMin4().getSelectedItem().toString());

        roomPar.setS4SETTEMP(Integer.toString(getSc().getSplitTemp4().getValue()));
        roomPar.setS4SETTEMPANZEIGE(getSc().getSplitTempAnzeige4().getText());
        roomPar.setS4SETTEMPTOL(getSc().getSplitTempTol4().getSelectedItem().toString());

        roomPar.setS4SETHUM(Integer.toString(getSc().getSplitHum4().getValue()));
        roomPar.setS4SETHUMANZEIGE(getSc().getSplitHumAnzeige4().getText());
        roomPar.setS4SETHUMTOL(getSc().getSplitHumTol4().getSelectedItem().toString());

        roomPar.setS4SETCO2(Integer.toString(getSc().getSplitCo24().getValue()));
        roomPar.setS4SETCO2ANZEIGE(getSc().getSplitCo2Anzeige4().getText());
        roomPar.setS4SETCO2TOL(getSc().getSplitCo2Tol4().getSelectedItem().toString());

        roomPar.setS4SETETHYL(Integer.toString(getSc().getSplitEthyl4().getValue()));
        roomPar.setS4SETETHYLANZEIGE(getSc().getSplitEthylAnzeige4().getText());
        roomPar.setS4SETETHYLTOL(getSc().getSplitEthylTol4().getSelectedItem().toString());

        roomPar.setS1DURATION(getSc().getSplitDuration1().getText());
        roomPar.setS1STARTDATE(getSc().getSplitAnfangsDate1().getText());

        roomPar.setS2DURATION(getSc().getSplitDuration2().getText());
        roomPar.setS2STARTDATE(getSc().getSplitAnfangsDate2().getText());

        roomPar.setS3DURATION(getSc().getSplitDuration3().getText());
        roomPar.setS3STARTDATE(getSc().getSplitAnfangsDate3().getText());

        roomPar.setS4DURATION(getSc().getSplitDuration4().getText());
        roomPar.setS4STARTDATE(getSc().getSplitAnfangsDate4().getText());

//      roomPar.getS1Duration();
    }

    public void menuUpdateSchreiben() {
        this.getSc().getRoomName().setSelectedItem(roomPar.getROOMNAME());
        this.getSc().getUserSelection().setSelectedItem(roomPar.getUSERSELECTION());
        this.getSc().getProduktSelection().setSelectedItem(roomPar.getPRODUKTSELECTION());
        this.getSc().getProduktNrSelection().setSelectedItem(roomPar.getPRODUKTNRSELECTION());
        this.getSc().getSplitMenge().setSelectedItem(roomPar.getSPLITMENGE());
        this.getSc().getEthylSetPutTime1().setSelectedItem(roomPar.getETHYLSETPUTTIME());
        this.getSc().getDelayTimeEthylToMessung1().setSelectedItem(roomPar.getDELAYTIMEETHYLTOMES());
        this.getSc().getcirculatingAir().setSelectedItem(roomPar.getCIRCULATINGAIR());
        this.getSc().getCirculatingAirDelay1().setSelectedItem(roomPar.getCIRCULATINAIRDELAY());
        this.getSc().getHeaterDelay1().setSelectedItem(roomPar.getHEATERDELAY());
        this.getSc().getCoolDelay1().setSelectedItem(roomPar.getCOOLERDELAY());
        this.getSc().getDamperDelay1().setSelectedItem(roomPar.getDAMPERDELAY());
        this.getSc().getFreshAirDelay1().setSelectedItem(roomPar.getFRESHAIRDELAY());
        this.getSc().getBeginTimeHour().setSelectedItem(roomPar.getBEGINTIMEHOUR());
        this.getSc().getBeginTimeMin().setSelectedItem(roomPar.getBEGINTIMEMIN());
        this.getSc().getIpAddress().setText(roomPar.getIPADRESS());
        this.getSc().getPortNr().setText(roomPar.getPORTNR());
        // sc.roomPar.getPortNr().setText(roomPar.getPORTNR());

        //sc.roomPar.getSplitAnfangsDate1().setText(roomPar.getS1DURATIONDAY());
        this.getSc().getSplitDurationDay1().setSelectedItem(roomPar.getS1DURATIONDAY());
        this.getSc().getSplitDurationHour1().setSelectedItem(roomPar.getS1DURATIONHOUR());
        this.getSc().getSplitDurationMin1().setSelectedItem(roomPar.getS1DURATIONMIN());
        this.getSc().getSplitTemp1().setValue(Integer.parseInt(roomPar.getS1SETTEMP()));
        this.getSc().getSplitTempTol1().setSelectedItem(roomPar.getS1SETTEMPTOL());
        this.getSc().getSplitHum1().setValue(Integer.parseInt(roomPar.getS1SETHUM()));
        this.getSc().getSplitHumTol1().setSelectedItem((roomPar.getS1SETHUMTOL()));
        this.getSc().getSplitCo21().setValue(Integer.parseInt(roomPar.getS1SETCO2()));
        this.getSc().getSplitCo2Tol1().setSelectedItem(roomPar.getS1SETCO2TOL());
        this.getSc().getSplitEthyl1().setValue(Integer.parseInt(roomPar.getS1SETETHYL()));
        this.getSc().getSplitEthylTol1().setSelectedItem(roomPar.getS1SETETHYLTOL());

        //2      666666
        this.getSc().getSplitDurationDay2().setSelectedItem(roomPar.getS2DURATIONDAY());
        this.getSc().getSplitDurationHour2().setSelectedItem(roomPar.getS2DURATIONHOUR());
        this.getSc().getSplitDurationMin2().setSelectedItem(roomPar.getS2DURATIONMIN());
        this.getSc().getSplitTemp2().setValue(Integer.parseInt(roomPar.getS2SETTEMP()));
        this.getSc().getSplitTempTol2().setSelectedItem(roomPar.getS2SETTEMPTOL());
        this.getSc().getSplitHum2().setValue(Integer.parseInt(roomPar.getS2SETHUM()));
        this.getSc().getSplitHumTol2().setSelectedItem((roomPar.getS2SETHUMTOL()));
        this.getSc().getSplitCo22().setValue(Integer.parseInt(roomPar.getS2SETCO2()));
        this.getSc().getSplitCo2Tol2().setSelectedItem(roomPar.getS2SETCO2TOL());
        this.getSc().getSplitEthyl2().setValue(Integer.parseInt(roomPar.getS2SETETHYL()));
        this.getSc().getSplitEthylTol2().setSelectedItem(roomPar.getS2SETETHYLTOL());

        // 3  666666666666666
        this.getSc().getSplitDurationDay3().setSelectedItem(roomPar.getS3DURATIONDAY());
        this.getSc().getSplitDurationHour3().setSelectedItem(roomPar.getS3DURATIONHOUR());
        this.getSc().getSplitDurationMin3().setSelectedItem(roomPar.getS3DURATIONMIN());
        this.getSc().getSplitTemp3().setValue(Integer.parseInt(roomPar.getS3SETTEMP()));
        this.getSc().getSplitTempTol3().setSelectedItem(roomPar.getS3SETTEMPTOL());
        this.getSc().getSplitHum3().setValue(Integer.parseInt(roomPar.getS3SETHUM()));
        this.getSc().getSplitHumTol3().setSelectedItem((roomPar.getS3SETHUMTOL()));
        this.getSc().getSplitCo23().setValue(Integer.parseInt(roomPar.getS3SETCO2()));
        this.getSc().getSplitCo2Tol3().setSelectedItem(roomPar.getS3SETCO2TOL());
        this.getSc().getSplitEthyl3().setValue(Integer.parseInt(roomPar.getS3SETETHYL()));
        this.getSc().getSplitEthylTol3().setSelectedItem(roomPar.getS3SETETHYLTOL());

        // 4 666666666666
        this.getSc().getSplitDurationDay4().setSelectedItem(roomPar.getS4DURATIONDAY());
        this.getSc().getSplitDurationHour4().setSelectedItem(roomPar.getS4DURATIONHOUR());
        this.getSc().getSplitDurationMin4().setSelectedItem(roomPar.getS4DURATIONMIN());
        this.getSc().getSplitTemp4().setValue(Integer.parseInt(roomPar.getS4SETTEMP()));
        this.getSc().getSplitTempTol4().setSelectedItem(roomPar.getS4SETTEMPTOL());
        this.getSc().getSplitHum4().setValue(Integer.parseInt(roomPar.getS4SETHUM()));
        this.getSc().getSplitHumTol4().setSelectedItem((roomPar.getS4SETHUMTOL()));
        this.getSc().getSplitCo24().setValue(Integer.parseInt(roomPar.getS4SETCO2()));
        this.getSc().getSplitCo2Tol4().setSelectedItem(roomPar.getS4SETCO2TOL());
        this.getSc().getSplitEthyl4().setValue(Integer.parseInt(roomPar.getS4SETETHYL()));
        this.getSc().getSplitEthylTol4().setSelectedItem(roomPar.getS4SETETHYLTOL());

        sollUntoleranzInChartMenuSezten();
    }

    public void erzeugeWerteTabelle(String fileName) {
        // Beim Start Room anlegen werden die Daten erzeugt mit Parameterversehen  
        //      System.out.println("Directory cannot be created asdssadsad     " + fileName);
        File file = new File(fileName);
        try {
            FileOutputStream fr = new FileOutputStream(file);

            if (!file.exists()) {
                try (OutputStream outputStream = new FileOutputStream(fileName)) {

                    prop.setProperty("ROOMNAME", "ROOM1");
                    prop.setProperty("PRODUKTSELECTION", "0");
                    prop.setProperty("USERSELECTION", "0");
                    prop.setProperty("PRODUKTNRSELECTION", "0");
                    prop.setProperty("SPLITMENGE", "0");
                    prop.setProperty("ETHYLSETPUTTIME", "0");
                    prop.setProperty("DELAYTIMEETHYLTOMES", "0");
                    prop.setProperty("CIRCULATINGAIR", "0");
                    prop.setProperty("CIRCULATINAIRDELAY", "0");
                    prop.setProperty("HEATERDELAY", "0");
                    prop.setProperty("COOLERDELAY", "0");
                    prop.setProperty("DAMPERDELAY", "0");
                    prop.setProperty("FRESHAIRDELAY", "0");
                    prop.setProperty("BEGINTIMEHOUR", "0");
                    prop.setProperty("BEGINTIMEMIN", "0");
                    prop.setProperty("IPADRESS", "0");
                    prop.setProperty("PORTNR", "0");
                    prop.setProperty("S1DURATIONDAY", "0");
                    prop.setProperty("S1DURATIONHOUR", "0");
                    prop.setProperty("S1DURATIONMIN", "0");
                    prop.setProperty("S1SETTEMP", "0");
                    prop.setProperty("S1SETTEMPTOL", "0");
                    prop.setProperty("S1SETHUM", "0");
                    prop.setProperty("S1SETHUMTOL", "0");
                    prop.setProperty("S1SETCO2", "0");
                    prop.setProperty("S1SETCO2TOL", "0");
                    prop.setProperty("S1SETETHYL", "0");
                    prop.setProperty("S1SETETHYLTOL", "0");
                    prop.setProperty("S2DURATIONDAY", "0");
                    prop.setProperty("S2DURATIONHOUR", "0");
                    prop.setProperty("S2DURATIONMIN", "0");
                    prop.setProperty("S2SETTEMP", "0");
                    prop.setProperty("S2SETTEMPTOL", "0");
                    prop.setProperty("S2SETHUM", "0");
                    prop.setProperty("S2SETHUMTOL", "0");
                    prop.setProperty("S2SETCO2", "0");
                    prop.setProperty("S2SETCO2TOL", "0");
                    prop.setProperty("S2SETETHYL", "0");
                    prop.setProperty("S2SETETHYLTOL", "0");
                    prop.setProperty("S3DURATIONDAY", "0");
                    prop.setProperty("S3DURATIONHOUR", "0");
                    prop.setProperty("S3DURATIONMIN", "0");
                    prop.setProperty("S3SETTEMP", "0");
                    prop.setProperty("S3SETTEMPTOL", "0");
                    prop.setProperty("S3SETHUM", "0");
                    prop.setProperty("S3SETHUMTOL", "0");
                    prop.setProperty("S3SETCO2", "0");
                    prop.setProperty("S3SETCO2TOL", "0");
                    prop.setProperty("S3SETETHYL", "0");
                    prop.setProperty("S3SETETHYLTOL", "0");
                    prop.setProperty("S4DURATIONDAY", "0");
                    prop.setProperty("S4DURATIONHOUR", "0");
                    prop.setProperty("S4DURATIONMIN", "0");
                    prop.setProperty("S4SETTEMP", "0");
                    prop.setProperty("S4SETTEMPTOL", "0");
                    prop.setProperty("S4SETHUM", "0");
                    prop.setProperty("S4SETHUMTOL", "0");
                    prop.setProperty("S4SETCO2", "0");
                    prop.setProperty("S4SETCO2TOL", "0");
                    prop.setProperty("S4SETETHYL", "0");
                    prop.setProperty("S4SETETHYLTOL", "0");
                    prop.setProperty("S1DURATION", "0");
                    prop.setProperty("S1STARTDATE", "0");
                    prop.setProperty("S2DURATION", "0");
                    prop.setProperty("S2STARTDATE", "0");
                    prop.setProperty("S3DURATION", "0");
                    prop.setProperty("S3STARTDATE", "0");
                    prop.setProperty("S4DURATION", "0");
                    prop.setProperty("S4STARTDATE", "0");
                    prop.setProperty("PROZESSBEGINN", "0");
                    prop.setProperty("PROZESSEND", "0");
                    prop.store(outputStream, null);
                    outputStream.close();
                } catch (IOException e) {
                }
                //        System.out.println("------------------------" + prop.getProperty("ROOMNAME"));
                //outputStream.
                fr.close();

                //             System.out.println("After saving properties: ");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDuration() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm");
        //    SimpleDateFormat formatter2 = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        Calendar prozessAnfang = getSc().getHauptCalendar();
        Calendar prozessEnde = getSc().getHauptCalendar();
        Calendar s1AnfangC = getSc().getHauptCalendar();

        switch (getSc().getSplitMenge().getSelectedIndex()) {
            case 0:
                setFarbe0();

                // Split 1 Gesamt min ausrechnen
                roomPar.setGesamtMinS1(Integer.parseInt((String) getSc().getSplitDurationDay1().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour1().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin1().getSelectedItem()));
                // beginnin dazu rechnen
                roomPar.setBeginnInMinuten(Integer.parseInt((String) getSc().getBeginTimeHour().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getBeginTimeMin().getSelectedItem()));
                // Split1 gesamt min anzeigen

                prozessAnfang.add(prozessAnfang.MINUTE, (int) roomPar.getBeginnInMinuten());
                //     System.out.println("dddddddddddddddddd1             " + roomPar.getBeginnInMinuten());

                getSc().getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
                getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1()));
                getSc().getSplitDuration1().setText(Integer.toString(roomPar.getGesamtMinS1()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS1Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS1Anfang(s1AnfangC.getTimeInMillis());
                setNull_234();

                break;
            case 1:
                setFarbe1();
                System.out.println("SAMIHHHHHHHHHHHHH" + "");
                // Split 1 Gesamt min ausrechnen
                roomPar.setGesamtMinS1(Integer.parseInt((String) getSc().getSplitDurationDay1().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour1().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin1().getSelectedItem()));

                roomPar.setBeginnInMinuten(Integer.parseInt((String) getSc().getBeginTimeHour().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getBeginTimeMin().getSelectedItem()));
                // Split1 gesamt min anzeigen

                prozessAnfang.add(prozessAnfang.MINUTE, (int) roomPar.getBeginnInMinuten());
                //        System.out.println("dddddddddddddddddd1             " + roomPar.getBeginnInMinuten());

                // Split1 gesamt min anzeigen
                getSc().getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
                getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1()));
                getSc().getSplitDuration1().setText(Integer.toString(roomPar.getGesamtMinS1()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS1Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS1Anfang(s1AnfangC.getTimeInMillis());
                // SPLIT1 ENDE

///////////////////////////////////
                roomPar.setGesamtMinS2(Integer.parseInt((String) getSc().getSplitDurationDay2().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour2().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin2().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessAnfang = prozessEnde;
                getSc().getSplitAnfangsDate2().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime2().setText(formatter1.format(prozessAnfang.getTime()));
                // getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                // getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // Split 2 DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() +roomPar. getGesamtMinS2()));
                //         System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv 1             " + getSc().getGesamtDurationMin().getText());
                getSc().getSplitDuration2().setText(Integer.toString(roomPar.getGesamtMinS2()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS2());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS2Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS2Anfang(s1AnfangC.getTimeInMillis());

                setNull_34();
                break;
            case 2:
                setFarbe2();

                // Split 1 Gesamt min ausrechnen
                roomPar.setGesamtMinS1(Integer.parseInt((String) getSc().getSplitDurationDay1().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour1().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin1().getSelectedItem()));

                roomPar.setBeginnInMinuten(Integer.parseInt((String) getSc().getBeginTimeHour().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getBeginTimeMin().getSelectedItem()));
                // Split1 gesamt min anzeigen

                prozessAnfang.add(prozessAnfang.MINUTE, (int) roomPar.getBeginnInMinuten());
                //         System.out.println("dddddddddddddddddd1             " + roomPar.getBeginnInMinuten());

// Split1 gesamt min anzeigen
                getSc().getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
                getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1()));
                getSc().getSplitDuration1().setText(Integer.toString(roomPar.getGesamtMinS1()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS1Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS1Anfang(s1AnfangC.getTimeInMillis());
                // SPLIT1 ENDE

///////////////////////////////////
                roomPar.setGesamtMinS2(Integer.parseInt((String) getSc().getSplitDurationDay2().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour2().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin2().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessAnfang = prozessEnde;
                getSc().getSplitAnfangsDate2().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime2().setText(formatter1.format(prozessAnfang.getTime()));
                // getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                // getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // Split 2 DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2()));
                //       System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv  2 1           " + getSc().getGesamtDurationMin().getText());
                getSc().getSplitDuration2().setText(Integer.toString(roomPar.getGesamtMinS2()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS2());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS2Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS2Anfang(s1AnfangC.getTimeInMillis());
                //////////SPLIT 3 parti ///////////////////////////////////////////

                roomPar.setGesamtMinS3(Integer.parseInt((String) getSc().getSplitDurationDay3().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour3().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin3().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessAnfang = prozessEnde;
                getSc().getSplitAnfangsDate3().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime3().setText(formatter1.format(prozessAnfang.getTime()));
                // getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                // getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // Split 2 DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2() + roomPar.getGesamtMinS3()));
                //        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv   2 2           " + getSc().getGesamtDurationMin().getText());
                getSc().getSplitDuration3().setText(Integer.toString(roomPar.getGesamtMinS3()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS3());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate3().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime3().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS3Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS3Anfang(s1AnfangC.getTimeInMillis());
                setNull_4();
                break;
            case 3:
                setFarbe3();//  einsezteb

                // Split 1 Gesamt min ausrechnen
                roomPar.setGesamtMinS1(Integer.parseInt((String) getSc().getSplitDurationDay1().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour1().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin1().getSelectedItem()));

                roomPar.setBeginnInMinuten(Integer.parseInt((String) getSc().getBeginTimeHour().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getBeginTimeMin().getSelectedItem()));
                // Split1 gesamt min anzeigen

                prozessAnfang.add(prozessAnfang.MINUTE, (int) roomPar.getBeginnInMinuten());
                //             System.out.println("dddddddddddddddddd1             " + roomPar.getBeginnInMinuten());

                // Split1 gesamt min anzeigen
                getSc().getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
                getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1()));
                getSc().getSplitDuration1().setText(Integer.toString(roomPar.getGesamtMinS1()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS1Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS1Anfang(s1AnfangC.getTimeInMillis());
                // SPLIT1 ENDE

///////////////////////////////////
                roomPar.setGesamtMinS2(Integer.parseInt((String) getSc().getSplitDurationDay2().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour2().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin2().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessAnfang = prozessEnde;
                getSc().getSplitAnfangsDate2().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime2().setText(formatter1.format(prozessAnfang.getTime()));
                // getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                // getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // Split 2 DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2()));
                //        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv  3 1            " + getSc().getGesamtDurationMin().getText());
                getSc().getSplitDuration2().setText(Integer.toString(roomPar.getGesamtMinS2()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS2());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS2Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS2Anfang(s1AnfangC.getTimeInMillis());
                //////////SPLIT 3 parti ///////////////////////////////////////////

                roomPar.setGesamtMinS3(Integer.parseInt((String) getSc().getSplitDurationDay3().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour3().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin3().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessAnfang = prozessEnde;
                getSc().getSplitAnfangsDate3().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime3().setText(formatter1.format(prozessAnfang.getTime()));
                // getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                // getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // Split 2 DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2() +roomPar. getGesamtMinS3()));
                //           System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv   3 2           " + getSc().getGesamtDurationMin().getText());
                getSc().getSplitDuration3().setText(Integer.toString(roomPar.getGesamtMinS3()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS3());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate3().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime3().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS3Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS3Anfang(s1AnfangC.getTimeInMillis());

                //////////SPLIT 3 ENDE //////////////////////////////////
                roomPar.setGesamtMinS4(Integer.parseInt((String) getSc().getSplitDurationDay4().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour4().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin4().getSelectedItem()));
                prozessAnfang = prozessEnde;
                getSc().getSplitAnfangsDate4().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime4().setText(formatter1.format(prozessAnfang.getTime()));
                // getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                // getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                // Split 2 DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2() + roomPar.getGesamtMinS3() + roomPar.getGesamtMinS4()));
                //         System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv   3 3           " + getSc().getGesamtDurationMin().getText());
                getSc().getSplitDuration4().setText(Integer.toString(roomPar.getGesamtMinS4()));
                // Split1 Prozessende berechnen und ausgeben
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS4());
                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Ende ausgeben 
                getSc().getSplitEndDate4().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime4().setText(formatter1.format(prozessEnde.getTime()));
                // Split 1 Dauer berechnen und ausgeben
                roomPar.setS4Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS4Anfang(s1AnfangC.getTimeInMillis());
                break;
        }

        roomPar.setPROZESSBEGINN(getSc().getDateProzessBeginn().getText() + "-" + getSc().getTimeProzessBeginn().getText());
        roomPar.setPROZESSEND(getSc().getDateProzessEnd().getText() + "-" + getSc().getTimeProzessEnde().getText());
    }

    private void sollUntoleranzInChartMenuSezten() {
        float x = Float.valueOf(roomPar.getS1SETTEMP()) / 10;
        getCm().getjLabelTempSoll().setText(String.valueOf(x));
        getCm().getjLabelTempTol().setText(roomPar.getS1SETTEMPTOL());

        getCm().getjLabelCo2Soll().setText(roomPar.getS1SETCO2());
        getCm().getjLabelCo2Tol().setText(roomPar.getS1SETCO2TOL());

        getCm().getjLabelDampSoll().setText(roomPar.getS1SETHUM());
        getCm().getjLabelDampTol().setText(roomPar.getS1SETHUMTOL());

        getCm().getjLabelEthylSoll().setText(roomPar.getS1SETETHYL());
        getCm().getjLabelEthylTol().setText(roomPar.getS1SETETHYLTOL());
    }

    public String textErz() {
        String text = getSc().getRoomName().getSelectedItem() + "*"
                + getSc().getUserSelection().getSelectedItem().toString() + "*"
                + getSc().getProduktSelection().getSelectedItem().toString() + "*"
                + getSc().getProduktNrSelection().getSelectedItem().toString() + "*"
                + getSc().getSplitMenge().getSelectedItem().toString() + "*"
                + getSc().getEthylSetPutTime1().getSelectedItem().toString() + "*"
                + getSc().getDelayTimeEthylToMessung1().getSelectedItem().toString() + "*"
                + getSc().getcirculatingAir().getSelectedItem().toString() + "*"
                + getSc().getCirculatingAirDelay1().getSelectedItem().toString() + "*"
                + getSc().getHeaterDelay1().getSelectedItem().toString() + "*"
                + getSc().getCoolDelay1().getSelectedItem().toString() + "*"
                + getSc().getDamperDelay1().getSelectedItem().toString() + "*"
                + getSc().getFreshAirDelay1().getSelectedItem().toString() + "*"
                + getSc().getBeginTimeHour().getSelectedItem().toString() + "*"
                + getSc().getBeginTimeMin().getSelectedItem().toString() + "*"
                + getSc().getIpAddress().getText() + "*"
                + getSc().getPortNr().getText() + "*"
                + getSc().getSplitDurationDay1().getSelectedItem().toString() + "*"
                + getSc().getSplitDurationHour1().getSelectedItem().toString() + "*"
                + getSc().getSplitDurationMin1().getSelectedItem().toString() + "*"
                + getSc().getSplitTemp1().getValue() + "*"
                + getSc().getSplitTempTol1().getSelectedItem().toString() + "*"
                + getSc().getSplitHum1().getValue() + "*"
                + getSc().getSplitHumTol1().getSelectedItem().toString() + "*"
                + getSc().getSplitCo21().getValue() + "*"
                + getSc().getSplitCo2Tol1().getSelectedItem().toString() + "*"
                + getSc().getSplitEthyl1().getValue() + "*"
                + getSc().getSplitEthylTol1().getSelectedItem().toString() + "*"
                + // 2
                getSc().getSplitDurationDay2().getSelectedItem().toString() + "*"
                + getSc().getSplitDurationHour2().getSelectedItem().toString() + "*"
                + getSc().getSplitDurationMin2().getSelectedItem().toString() + "*"
                + getSc().getSplitTemp2().getValue() + "*"
                + getSc().getSplitTempTol2().getSelectedItem().toString() + "*"
                + getSc().getSplitHum2().getValue() + "*"
                + getSc().getSplitHumTol2().getSelectedItem().toString() + "*"
                + getSc().getSplitCo22().getValue() + "*"
                + getSc().getSplitCo2Tol2().getSelectedItem().toString() + "*"
                + getSc().getSplitEthyl2().getValue() + "*"
                + getSc().getSplitEthylTol2().getSelectedItem().toString() + "*"
                + // 3
                getSc().getSplitDurationDay3().getSelectedItem().toString() + "*"
                + getSc().getSplitDurationHour3().getSelectedItem().toString() + "*"
                + getSc().getSplitDurationMin3().getSelectedItem().toString() + "*"
                + getSc().getSplitTemp3().getValue() + "*"
                + getSc().getSplitTempTol3().getSelectedItem().toString() + "*"
                + getSc().getSplitHum3().getValue() + "*"
                + getSc().getSplitHumTol3().getSelectedItem().toString() + "*"
                + getSc().getSplitCo23().getValue() + "*"
                + getSc().getSplitCo2Tol3().getSelectedItem().toString() + "*"
                + getSc().getSplitEthyl3().getValue() + "*"
                + getSc().getSplitEthylTol3().getSelectedItem().toString() + "*"
                + //4
                getSc().getSplitDurationDay4().getSelectedItem().toString() + "*"
                + getSc().getSplitDurationHour4().getSelectedItem().toString() + "*"
                + getSc().getSplitDurationMin4().getSelectedItem().toString() + "*"
                + getSc().getSplitTemp4().getValue() + "*"
                + getSc().getSplitTempTol4().getSelectedItem().toString() + "*"
                + getSc().getSplitHum4().getValue() + "*"
                + getSc().getSplitHumTol4().getSelectedItem().toString() + "*"
                + getSc().getSplitCo24().getValue() + "*"
                + getSc().getSplitCo2Tol4().getSelectedItem().toString() + "*"
                + getSc().getSplitEthyl4().getValue() + "*"
                + getSc().getSplitEthylTol4().getSelectedItem().toString();
        //      System.out.println(text);
        return text;
    }

    public void menuInTextEinlesen() {
        parameterListeErzeugen();
        textErz();
//         System.out.println(parameterListeErzeugen());
//         System.out.println(textErz());

        String rohDatenListe = parameterListeErzeugen();
        StringTokenizer st1 = new StringTokenizer(rohDatenListe, "*");
        while (st1.hasMoreTokens()) {
            st1.nextToken();

            //    System.out.println(st2.nextToken());
        }
        //   System.out.println("NENNNNNNNNNNNNNNN  " + neueText);
    }

    public void menuLesen(String fileName) {

    }

    public void menuParameterSetzen() {

        roomPar.setROOMNAME(getSc().getRoomName().getSelectedItem().toString());
        roomPar.setUSERSELECTION(getSc().getUserSelection().getSelectedItem().toString());
        roomPar.setPRODUKTSELECTION(getSc().getProduktSelection().getSelectedItem().toString());
        roomPar.setPRODUKTNRSELECTION(getSc().getProduktNrSelection().getSelectedItem().toString());

        roomPar.setIPADRESS(getSc().getIpAddress().getText());
        roomPar.setPORTNR(getSc().getPortNr().getText());
        roomPar.setBEGINTIMEHOUR(getSc().getBeginTimeHour().getSelectedItem().toString());
        roomPar.setBEGINTIMEMIN(getSc().getBeginTimeMin().getSelectedItem().toString());

        roomPar.setSPLITMENGE(getSc().getSplitMenge().getSelectedItem().toString());
        roomPar.setCIRCULATINGAIR(getSc().getcirculatingAir().getSelectedItem().toString());
        roomPar.setCIRCULATINAIRDELAY(getSc().getCirculatingAirDelay1().getSelectedItem().toString());

        roomPar.setHEATERDELAY(getSc().getHeaterDelay1().getSelectedItem().toString());
        roomPar.setCOOLERDELAY(getSc().getCoolDelay1().getSelectedItem().toString());
        roomPar.setETHYLSETPUTTIME(getSc().getEthylSetPutTime1().getSelectedItem().toString());
        roomPar.setDELAYTIMEETHYLTOMES(getSc().getDelayTimeEthylToMessung1().getSelectedItem().toString());
        roomPar.setDAMPERDELAY(getSc().getDamperDelay1().getSelectedItem().toString());
        roomPar.setFRESHAIRDELAY(getSc().getFreshAirDelay1().getSelectedItem().toString());

        roomPar.setS1DURATIONDAY(getSc().getSplitDurationDay1().getSelectedItem().toString());
        roomPar.setS1DURATIONHOUR(getSc().getSplitDurationHour1().getSelectedItem().toString());
        roomPar.setS1DURATIONMIN(getSc().getSplitDurationMin1().getSelectedItem().toString());
        roomPar.setS1SETTEMP(String.valueOf(getSc().getSplitTemp1().getValue() / 10));
        roomPar.setS1SETTEMPTOL(getSc().getSplitTempTol1().getSelectedItem().toString());

        roomPar.setS1SETHUM(String.valueOf(getSc().getSplitHum1().getValue()));
        roomPar.setS1SETHUMTOL(getSc().getSplitHumTol1().getSelectedItem().toString());

        roomPar.setS1SETCO2(String.valueOf(getSc().getSplitCo21().getValue()));
        roomPar.setS1SETCO2TOL(getSc().getSplitCo2Tol1().getSelectedItem().toString());

        roomPar.setS1SETETHYL(String.valueOf(getSc().getSplitEthyl2().getValue()));
        roomPar.setS1SETETHYLTOL(getSc().getSplitEthylTol1().getSelectedItem().toString());

        roomPar.setS2DURATIONDAY(getSc().getSplitDurationDay2().getSelectedItem().toString());
        roomPar.setS2DURATIONHOUR(getSc().getSplitDurationHour2().getSelectedItem().toString());
        roomPar.setS2DURATIONMIN(getSc().getSplitDurationMin2().getSelectedItem().toString());
        roomPar.setS2SETTEMP(String.valueOf(getSc().getSplitTemp2().getValue()));
        roomPar.setS2SETTEMPTOL(getSc().getSplitTempTol2().getSelectedItem().toString());

        roomPar.setS2SETHUM(String.valueOf(getSc().getSplitHum2().getValue()));
        roomPar.setS2SETHUMTOL(getSc().getSplitHumTol2().getSelectedItem().toString());

        roomPar.setS2SETCO2(String.valueOf(getSc().getSplitCo22().getValue()));
        roomPar.setS2SETCO2TOL(getSc().getSplitCo2Tol2().getSelectedItem().toString());
        roomPar.setS2SETETHYL(String.valueOf(getSc().getSplitEthyl2().getValue()));
        roomPar.setS2SETETHYLTOL(getSc().getSplitEthylTol2().getSelectedItem().toString());

        //
        roomPar.setS3DURATIONDAY(getSc().getSplitDurationDay3().getSelectedItem().toString());
        roomPar.setS3DURATIONHOUR(getSc().getSplitDurationHour3().getSelectedItem().toString());
        roomPar.setS3DURATIONMIN(getSc().getSplitDurationMin3().getSelectedItem().toString());
        roomPar.setS3SETTEMP(String.valueOf(getSc().getSplitTemp3().getValue()));
        roomPar.setS3SETTEMPTOL(getSc().getSplitTempTol3().getSelectedItem().toString());

        roomPar.setS3SETHUM(String.valueOf(getSc().getSplitHum3().getValue()));
        roomPar.setS3SETHUMTOL(getSc().getSplitHumTol3().getSelectedItem().toString());

        roomPar.setS3SETCO2(String.valueOf(getSc().getSplitCo23().getValue()));
        roomPar.setS3SETCO2TOL(getSc().getSplitCo2Tol3().getSelectedItem().toString());
        roomPar.setS3SETETHYL(String.valueOf(getSc().getSplitEthyl3().getValue()));
        roomPar.setS3SETETHYLTOL(getSc().getSplitEthylTol3().getSelectedItem().toString());

        //
        roomPar.setS4DURATIONDAY(getSc().getSplitDurationDay4().getSelectedItem().toString());
        roomPar.setS4DURATIONHOUR(getSc().getSplitDurationHour4().getSelectedItem().toString());
        roomPar.setS4DURATIONMIN(getSc().getSplitDurationMin4().getSelectedItem().toString());
        roomPar.setS4SETTEMP(String.valueOf(getSc().getSplitTemp4().getValue()));
        roomPar.setS4SETTEMPTOL(getSc().getSplitTempTol4().getSelectedItem().toString());

        roomPar.setS4SETHUM(String.valueOf(getSc().getSplitHum4().getValue()));
        roomPar.setS4SETHUMTOL(getSc().getSplitHumTol4().getSelectedItem().toString());

        roomPar.setS4SETCO2(String.valueOf(getSc().getSplitCo24().getValue()));
        roomPar.setS4SETCO2TOL(getSc().getSplitCo2Tol4().getSelectedItem().toString());
        roomPar.setS4SETETHYL(String.valueOf(getSc().getSplitEthyl4().getValue()));
        roomPar.setS4SETETHYLTOL(getSc().getSplitEthylTol4().getSelectedItem().toString());
//
//        text = sc.getjTextFieldRoomName().getText() + "*"
//                + sc.getUserSelection().getSelectedItem().toString() + "*"
//                + sc.getProduktSelection().getSelectedItem().toString() + "*"
//                + sc.getProduktNrSelection().getSelectedItem().toString() + "*"
//                + sc.getIpAddress().getText() + "*"
//                + sc.getPortNr().getText() + "*"
//                + sc.getBeginTimeHour().getSelectedItem().toString() + "*"
//                + sc.getBeginTimeMin().getSelectedItem().toString() + "*"
//                + sc.getSplitMenge().getSelectedItem().toString() + "*"
//                + sc.getcirculatingAir().getSelectedItem().toString() + "*"
//                + sc.getCirculatingAirDelay1().getSelectedItem().toString() + "*"
//                + sc.getHeaterDelay1().getSelectedItem().toString() + "*"
//                + sc.getCoolDelay1().getSelectedItem().toString() + "*"
//                + sc.getEthylSetPutTime1().getSelectedItem().toString() + "*"
//                + sc.getDelayTimeEthylToMessung1().getSelectedItem().toString() + "*"
//                + sc.getDamperDelay1().getSelectedItem().toString() + "*"
//                + sc.getFreshAirDelay1().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationDay1().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationHour1().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationMin1().getSelectedItem().toString() + "*"
//                + sc.getSplitTemp1().getValue() + "*"
//                + sc.getSplitTempTol1().getSelectedItem().toString() + "*"
//                + sc.getSplitHum1().getValue() + "*"
//                + sc.getSplitHumTol1().getSelectedItem().toString() + "*"
//                + sc.getSplitCo21().getValue() + "*"
//                + sc.getSplitCo2Tol1().getSelectedItem().toString() + "*"
//                + sc.getSplitEthyl1().getValue() + "*"
//                + sc.getSplitEthylTol1().getSelectedItem().toString() + "*"
//                // 2
//                + sc.getSplitDurationDay2().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationHour2().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationMin2().getSelectedItem().toString() + "*"
//                + sc.getSplitTemp2().getValue() + "*"
//                + sc.getSplitTempTol2().getSelectedItem().toString() + "*"
//                + sc.getSplitHum2().getValue() + "*"
//                + sc.getSplitHumTol2().getSelectedItem().toString() + "*"
//                + sc.getSplitCo22().getValue() + "*"
//                + sc.getSplitCo2Tol2().getSelectedItem().toString() + "*"
//                + sc.getSplitEthyl2().getValue() + "*"
//                + sc.getSplitEthylTol2().getSelectedItem().toString() + "*"
//                // 3
//                + sc.getSplitDurationDay3().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationHour3().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationMin3().getSelectedItem().toString() + "*"
//                + sc.getSplitTemp3().getValue() + "*"
//                + sc.getSplitTempTol3().getSelectedItem().toString() + "*"
//                + sc.getSplitHum3().getValue() + "*"
//                + sc.getSplitHumTol3().getSelectedItem().toString() + "*"
//                + sc.getSplitCo23().getValue() + "*"
//                + sc.getSplitCo2Tol3().getSelectedItem().toString() + "*"
//                + sc.getSplitEthyl3().getValue() + "*"
//                + sc.getSplitEthylTol3().getSelectedItem().toString() + "*"
//                //4
//                + sc.getSplitDurationDay4().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationHour4().getSelectedItem().toString() + "*"
//                + sc.getSplitDurationMin4().getSelectedItem().toString() + "*"
//                + sc.getSplitTemp4().getValue() + "*"
//                + sc.getSplitTempTol4().getSelectedItem().toString() + "*"
//                + sc.getSplitHum4().getValue() + "*"
//                + sc.getSplitHumTol4().getSelectedItem().toString() + "*"
//                + sc.getSplitCo24().getValue() + "*"
//                + sc.getSplitCo2Tol4().getSelectedItem().toString() + "*"
//                + sc.getSplitEthyl4().getValue() + "*"
//                + sc.getSplitEthylTol4().getSelectedItem().toString();
//
//        System.out.println(text);
//        return text;
    }

//    public void menuDatenSpeichern(String text, String datName, String datNameMitPath) {
//        StringTokenizer st = new StringTokenizer(text, "*");
//        
//        try ( OutputStream output = new FileOutputStream(datNameMitPath)) {
//
//            Properties prop = new Properties();
//                   
//                    prop.setProperty(st.nextToken(), dv.getROOMNAME());
//                    prop.setProperty(st.nextToken(), dv.getPRODUKTSELECTION());
//                    prop.setProperty(st.nextToken(), dv.getUSERSELECTION());
//                    prop.setProperty(st.nextToken(), dv.getPRODUKTNRSELECTION());
//
//                    prop.setProperty(st.nextToken(), dv.getSPLITMENGE());
//                    prop.setProperty(st.nextToken(), dv.getETHYLSETPUTTIME());
//                    prop.setProperty(st.nextToken(), dv.getDELAYTIMEETHYLTOMES());
//                    prop.setProperty(st.nextToken(), dv.getCIRCULATINGAIR());
//                    prop.setProperty(st.nextToken(), dv.getCIRCULATINAIRDELAY());
//                    prop.setProperty(st.nextToken(), dv.getHEATERDELAY());
//                    prop.setProperty(st.nextToken(), dv.getCOOLERDELAY());
//                    prop.setProperty(st.nextToken(), dv.getDAMPERDELAY());
//                    prop.setProperty(st.nextToken(), dv.getFRESHAIRDELAY());
//                    prop.setProperty(st.nextToken(), dv.getBEGINTIMEHOUR());
//                    prop.setProperty(st.nextToken(), dv.getBEGINTIMEMIN());
//                    prop.setProperty(st.nextToken(), dv.getIPADRESS());
//                    prop.setProperty(st.nextToken(), dv.getPORTNR());
//                    prop.setProperty(st.nextToken(), dv.getS1DURATIONDAY());
//                    prop.setProperty(st.nextToken(), dv.getS1DURATIONHOUR());
//                    prop.setProperty(st.nextToken(), dv.getS1DURATIONMIN());
//                    prop.setProperty(st.nextToken(), dv.getS1SETTEMP());
//                    prop.setProperty(st.nextToken(), dv.getS1SETTEMPTOL());
//                    prop.setProperty(st.nextToken(), dv.getS1SETHUM());
//                    prop.setProperty(st.nextToken(), dv.getS1SETHUMTOL());
//                    prop.setProperty(st.nextToken(), dv.getS1SETCO2());
//                    prop.setProperty(st.nextToken(), dv.getS1SETCO2TOL());
//                    prop.setProperty(st.nextToken(), dv.getS1SETETHYL());
//                    prop.setProperty(st.nextToken(), dv.getS1SETETHYLTOL());
//                    //2
//                    prop.setProperty(st.nextToken(), dv.getS2DURATIONDAY());
//                    prop.setProperty(st.nextToken(), dv.getS2DURATIONHOUR());
//                    prop.setProperty(st.nextToken(), dv.getS2DURATIONMIN());
//                    prop.setProperty(st.nextToken(), dv.getS2SETTEMP());
//                    prop.setProperty(st.nextToken(), dv.getS2SETTEMPTOL());
//                    prop.setProperty(st.nextToken(), dv.getS2SETHUM());
//                    prop.setProperty(st.nextToken(), dv.getS2SETHUMTOL());
//                    prop.setProperty(st.nextToken(), dv.getS2SETCO2());
//                    prop.setProperty(st.nextToken(), dv.getS2SETCO2TOL());
//                    prop.setProperty(st.nextToken(), dv.getS2SETETHYL());
//                    prop.setProperty(st.nextToken(), dv.getS2SETETHYLTOL());
//                    //3
//                    prop.setProperty(st.nextToken(), dv.getS3DURATIONDAY());
//                    prop.setProperty(st.nextToken(), dv.getS3DURATIONHOUR());
//                    prop.setProperty(st.nextToken(), dv.getS3DURATIONMIN());
//                    prop.setProperty(st.nextToken(), dv.getS3SETTEMP());
//                    prop.setProperty(st.nextToken(), dv.getS3SETTEMPTOL());
//                    prop.setProperty(st.nextToken(), dv.getS3SETHUM());
//                    prop.setProperty(st.nextToken(), dv.getS3SETHUMTOL());
//                    prop.setProperty(st.nextToken(), dv.getS3SETCO2());
//                    prop.setProperty(st.nextToken(), dv.getS3SETCO2TOL());
//                    prop.setProperty(st.nextToken(), dv.getS3SETETHYL());
//                    prop.setProperty(st.nextToken(), dv.getS3SETETHYLTOL());
//                    // 4
//                    prop.setProperty(st.nextToken(), dv.getS4DURATIONDAY());
//                    prop.setProperty(st.nextToken(), dv.getS4DURATIONHOUR());
//                    prop.setProperty(st.nextToken(), dv.getS4DURATIONMIN());
//                    prop.setProperty(st.nextToken(), dv.getS4SETTEMP());
//                    prop.setProperty(st.nextToken(), dv.getS4SETTEMPTOL());
//                    prop.setProperty(st.nextToken(), dv.getS4SETHUM());
//                    prop.setProperty(st.nextToken(), dv.getS4SETHUMTOL());
//                    prop.setProperty(st.nextToken(), dv.getS4SETCO2());
//                    prop.setProperty(st.nextToken(), dv.getS4SETCO2TOL());
//                    prop.setProperty(st.nextToken(), dv.getS4SETETHYL());
//                    prop.setProperty(st.nextToken(), dv.getS4SETETHYLTOL());
////                    prop.setProperty(st.nextToken(), dv.getPROZESSBEGINN());
////                    prop.setProperty(st.nextToken(), dv.getPROZESSEND());
//
//                    System.out.println("Gelesene Zeile: " + text);
//                
////            } catch (IOException e) {
////                e.printStackTrace();
////            } finally {
////
////                if (in != null)
////                try {
////                    in.close();
////                } catch (IOException e) {
////                }
////            }
//
//            // save properties to project root folder
//            prop.store(output, null);
//            output.close();
//
//            System.out.println(prop);
//
//        } catch (IOException io) {
//        }
//
//    }
//        public Path mkdir1(String name) {
//        // create an abstract pathname (File object)
//        String classpathStr = System.getProperty("user.dir");
//        String sammelpathOfParameters = classpathStr + "\\src\\" + name;
//        System.out.println("class PATH WURDE gesetzt " + classpathStr);
//        // pathName = classpathStr + pathPlus;
//
//        File f = new File(sammelpathOfParameters);
//        System.out.println("class gesetzt  " + classpathStr + "\\src" + "\\" + name);
//        if (!f.isDirectory()) {
//            // check if the directory can be created
//            // using the abstract path name
//            if (f.mkdir()) {
//                // display that the directory is created
//                // as the function returned true
//                System.out.println("Directory is created");
//            } else {
//                // display that the directory cannot be created
//                // as the function returned false
//                System.out.println("Directory cannot be created");
//            }
//        }
//        System.out.println("Directory was created " + Paths.get(sammelpathOfParameters));
//        return Paths.get(sammelpathOfParameters);
//    }
//
//    public void setDefaultWerte(String datName, String datNameMitPath) {
//
//        try ( OutputStream output = new FileOutputStream(datNameMitPath)) {
//
//            Properties prop = new Properties();
//            File fileWert = new File(datName);
//
//            if (!fileWert.canRead() || !fileWert.isFile()) {
//                System.exit(0);
//            }
//
//            BufferedReader in = null;
//            try {
//                in = new BufferedReader(new FileReader(datName));
//                String zeile = null;
//                String dings = "0";
//                while ((zeile = in.readLine()) != null) {
//                    prop.setProperty(zeile, dings);
//                    System.out.println("Gelesene Zeile: " + zeile);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//
//                if (in != null)
//                try {
//                    in.close();
//                } catch (IOException e) {
//                }
//            }
//
//            // save properties to project root folder
//            prop.store(output, null);
//
//            System.out.println(prop);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
//
//    }
//    public String checkFile(String fileName, String filePathString) {
//        String fileFullName = null;
//
//        this.setKonfFileName(fileName);
//        System.out.println("ÜBERGABE     " + filePathString + "\\" + fileName);
//
//        File f = new File(filePathString + "\\" + fileName);
//        if (f.exists() && !f.isDirectory()) {
//            // do something
//            System.out.println(getPath() + " Exists");
//
//            try {
//                //create an object
//                FileWriter writeInFile = new FileWriter(filePathString + "\\" + fileName);
//
//                //Adding content to this file
//                writeInFile.write("FILE EXIST\n");
//                writeInFile.write("FILE EXIST.\n");
//                //    writeInFile.write(this.getBEGINTIMEMIN().codePointAt(1));//"FILE EXIST.\n");
//
//                writeInFile.close();
////                System.out.println("Successfully done!"  +this.getBEGINTIMEMIN().codePointAt(1) );
//                fileFullName = filePathString + "\\" + fileName;
//            } catch (IOException x) {
//                System.out.println("An error is encountered.");
//                x.printStackTrace();
//                fileFullName = null;
//
//            }
//
//        } else {
//            System.out.println(" Do not Exists");
//
//            System.out.println("ERSTELLTE PATH   " + filePathString + "\\" + fileName);
//
//            File file = new File(filePathString + "\\" + fileName);
//
//            // do something
//            try {
//                //create an object
//                FileWriter writeInFile = new FileWriter(filePathString + "\\" + fileName);
//
//                //Adding content to this file
//                writeInFile.write("FILE not  EXIST.\n");
//                writeInFile.write("FILE not  EXIST.\n");
//
//                writeInFile.close();
//                System.out.println("Successfully done!");
//                fileFullName = filePathString + "\\" + fileName;
//            } catch (IOException x) {
//                System.out.println("An error is encountered.");
//                x.printStackTrace();
//                fileFullName = null;
//            }
//        }
//
//        return fileFullName;
//    }
    /**
     * @return the os
     */
    /**
     * @return the path
     */
    private void setFarbe3() {
        getSc().getSplitDuration1().setBackground(Color.PINK);
        getSc().getDateProzessBeginn().setBackground(Color.YELLOW);
        getSc().getTimeProzessBeginn().setBackground(Color.YELLOW);
        getSc().getDateProzessEnd().setBackground(Color.YELLOW);
        getSc().getTimeProzessEnde().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsDate1().setBackground(Color.YELLOW);
        getSc().getSplitEndTime1().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsDate1().setBackground(Color.YELLOW);
        getSc().getSplitEndTime1().setBackground(Color.YELLOW);
        getSc().getGesamtDurationMin().setBackground(Color.PINK);

        getSc().getSplitAnfangsDate2().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsTime2().setBackground(Color.YELLOW);
        getSc().getSplitEndDate2().setBackground(Color.YELLOW);
        getSc().getSplitEndTime2().setBackground(Color.YELLOW);
        getSc().getSplitDuration2().setBackground(Color.PINK);

//        rm.getSplitAnfangsDate2().setBackground(Color.WHITE);
//        rm.getSplitEndDate2().setBackground(Color.WHITE);
//        rm.getSplitAnfangsTime2().setBackground(Color.WHITE);
//        rm.getSplitEndTime2().setBackground(Color.WHITE);
//        rm.getSplitDuration2().setBackground(Color.WHITE);
//
//        rm.getSplitTempAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitTempTolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitHumAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitHumTolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitCo2Anzeige2().setBackground(Color.WHITE);
//        rm.getSplitCo2TolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitEthylAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitEthylTolAnzeige2().setBackground(Color.WHITE);
        getSc().getSplitAnfangsDate3().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsTime3().setBackground(Color.YELLOW);
        getSc().getSplitEndDate3().setBackground(Color.YELLOW);
        getSc().getSplitEndTime3().setBackground(Color.YELLOW);
        getSc().getSplitDuration3().setBackground(Color.PINK);

//        rm.getSplitAnfangsDate3().setBackground(Color.WHITE);
//        rm.getSplitEndDate3().setBackground(Color.WHITE);
//        rm.getSplitAnfangsTime3().setBackground(Color.WHITE);
//        rm.getSplitEndTime3().setBackground(Color.WHITE);
//        rm.getSplitDuration3().setBackground(Color.WHITE);
//
//        rm.getSplitTempAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitTempTolAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitHumAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitHumTolAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitCo2Anzeige3().setBackground(Color.WHITE);
//        rm.getSplitCo2TolAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitEthylAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitEthylTolAnzeige3().setBackground(Color.WHITE);
        getSc().getSplitAnfangsDate4().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsTime4().setBackground(Color.YELLOW);
        getSc().getSplitEndDate4().setBackground(Color.YELLOW);
        getSc().getSplitEndTime4().setBackground(Color.YELLOW);
        getSc().getSplitDuration4().setBackground(Color.PINK);

//        rm.getSplitAnfangsDate4().setBackground(Color.WHITE);
//        rm.getSplitEndDate4().setBackground(Color.WHITE);
//        rm.getSplitAnfangsTime4().setBackground(Color.WHITE);
//        rm.getSplitEndTime4().setBackground(Color.WHITE);
//        rm.getSplitDuration4().setBackground(Color.WHITE);
//
//        rm.getSplitTempAnzeige4().setBackground(Color.WHITE);
//        rm.getSplitTempTolAnzeige4().setBackground(Color.WHITE);
//        rm.getSplitHumAnzeige4().setBackground(Color.WHITE);
//        rm.getSplitHumTolAnzeige4().setBackground(Color.WHITE);
//        rm.getSplitCo2Anzeige4().setBackground(Color.WHITE);
//        rm.getSplitCo2TolAnzeige4().setBackground(Color.WHITE);
//        rm.getSplitEthylAnzeige4().setBackground(Color.WHITE);
//        rm.getSplitEthylTolAnzeige4().setBackground(Color.WHITE);
    }

    private void setFarbe2() {
        getSc().getSplitDuration1().setBackground(Color.PINK);
        getSc().getDateProzessBeginn().setBackground(Color.YELLOW);
        getSc().getTimeProzessBeginn().setBackground(Color.YELLOW);
        getSc().getDateProzessEnd().setBackground(Color.YELLOW);
        getSc().getTimeProzessEnde().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsDate1().setBackground(Color.YELLOW);
        getSc().getSplitEndTime1().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsDate1().setBackground(Color.YELLOW);
        getSc().getSplitEndTime1().setBackground(Color.YELLOW);
        getSc().getGesamtDurationMin().setBackground(Color.PINK);
        getSc().getSplitAnfangsDate2().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsTime2().setBackground(Color.YELLOW);
        getSc().getSplitEndDate2().setBackground(Color.YELLOW);
        getSc().getSplitEndTime2().setBackground(Color.YELLOW);
        getSc().getSplitDuration2().setBackground(Color.PINK);

//        rm.getSplitAnfangsDate2().setBackground(Color.WHITE);
//        rm.getSplitEndDate2().setBackground(Color.WHITE);
//        rm.getSplitAnfangsTime2().setBackground(Color.WHITE);
//        rm.getSplitEndTime2().setBackground(Color.WHITE);
//        rm.getSplitDuration2().setBackground(Color.WHITE);
//        rm.getSplitTempAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitTempTolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitHumAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitHumTolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitCo2Anzeige2().setBackground(Color.WHITE);
//        rm.getSplitCo2TolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitEthylAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitEthylTolAnzeige2().setBackground(Color.WHITE);
        getSc().getSplitAnfangsDate3().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsTime3().setBackground(Color.YELLOW);
        getSc().getSplitEndDate3().setBackground(Color.YELLOW);
        getSc().getSplitEndTime3().setBackground(Color.YELLOW);
        getSc().getSplitDuration3().setBackground(Color.PINK);

//        rm.getSplitAnfangsDate3().setBackground(Color.WHITE);
//        rm.getSplitEndDate3().setBackground(Color.WHITE);
//        rm.getSplitAnfangsTime3().setBackground(Color.WHITE);
//        rm.getSplitEndTime3().setBackground(Color.WHITE);
//        rm.getSplitDuration3().setBackground(Color.WHITE);
//
//        rm.getSplitTempAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitTempTolAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitHumAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitHumTolAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitCo2Anzeige3().setBackground(Color.WHITE);
//        rm.getSplitCo2TolAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitEthylAnzeige3().setBackground(Color.WHITE);
//        rm.getSplitEthylTolAnzeige3().setBackground(Color.WHITE);
        getSc().getSplitAnfangsDate4().setBackground(Color.BLACK);
        getSc().getSplitAnfangsTime4().setBackground(Color.BLACK);
        getSc().getSplitEndDate4().setBackground(Color.BLACK);
        getSc().getSplitEndTime4().setBackground(Color.BLACK);
        getSc().getSplitDuration4().setBackground(Color.BLACK);

//        rm.getSplitAnfangsDate4().setBackground(Color.BLACK);
//        rm.getSplitEndDate4().setBackground(Color.BLACK);
//        rm.getSplitAnfangsTime4().setBackground(Color.BLACK);
//        rm.getSplitEndTime4().setBackground(Color.BLACK);
//        rm.getSplitDuration4().setBackground(Color.BLACK);
//
//        rm.getSplitTempAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitTempTolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitHumAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitHumTolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitCo2Anzeige4().setBackground(Color.BLACK);
//        rm.getSplitCo2TolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitEthylAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitEthylTolAnzeige4().setBackground(Color.BLACK);
    }

    private void setFarbe1() {
        getSc().getSplitDuration1().setBackground(Color.PINK);
        getSc().getDateProzessBeginn().setBackground(Color.YELLOW);
        getSc().getDateProzessEnd().setBackground(Color.YELLOW);
        getSc().getTimeProzessBeginn().setBackground(Color.YELLOW);
        getSc().getTimeProzessEnde().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsDate1().setBackground(Color.YELLOW);
        getSc().getSplitEndTime1().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsDate1().setBackground(Color.YELLOW);
        getSc().getSplitEndTime1().setBackground(Color.YELLOW);
        getSc().getGesamtDurationMin().setBackground(Color.PINK);

        getSc().getSplitAnfangsDate2().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsTime2().setBackground(Color.YELLOW);
        getSc().getSplitEndDate2().setBackground(Color.YELLOW);
        getSc().getSplitEndTime2().setBackground(Color.YELLOW);
        getSc().getSplitDuration2().setBackground(Color.PINK);

//        rm.getSplitAnfangsDate2().setBackground(Color.WHITE);
//        rm.getSplitEndDate2().setBackground(Color.WHITE);
//        rm.getSplitAnfangsTime2().setBackground(Color.WHITE);
//        rm.getSplitEndTime2().setBackground(Color.WHITE);
//        rm.getSplitDuration2().setBackground(Color.WHITE);
//        rm.getSplitTempAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitTempTolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitHumAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitHumTolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitCo2Anzeige2().setBackground(Color.WHITE);
//        rm.getSplitCo2TolAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitEthylAnzeige2().setBackground(Color.WHITE);
//        rm.getSplitEthylTolAnzeige2().setBackground(Color.WHITE);
        getSc().getSplitAnfangsDate3().setBackground(Color.BLACK);
        getSc().getSplitAnfangsTime3().setBackground(Color.BLACK);
        getSc().getSplitEndDate3().setBackground(Color.BLACK);
        getSc().getSplitEndTime3().setBackground(Color.BLACK);
        getSc().getSplitDuration3().setBackground(Color.BLACK);

//        rm.getSplitAnfangsDate3().setBackground(Color.BLACK);
//        rm.getSplitEndDate3().setBackground(Color.BLACK);
//        rm.getSplitAnfangsTime3().setBackground(Color.BLACK);
//        rm.getSplitEndTime3().setBackground(Color.BLACK);
//        rm.getSplitDuration3().setBackground(Color.BLACK);
//        rm.getSplitTempAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitTempTolAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitHumAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitHumTolAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitCo2Anzeige3().setBackground(Color.BLACK);
//        rm.getSplitCo2TolAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitEthylAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitEthylTolAnzeige3().setBackground(Color.BLACK);
        getSc().getSplitAnfangsDate4().setBackground(Color.BLACK);
        getSc().getSplitAnfangsTime4().setBackground(Color.BLACK);
        getSc().getSplitEndDate4().setBackground(Color.BLACK);
        getSc().getSplitEndTime4().setBackground(Color.BLACK);
        getSc().getSplitDuration4().setBackground(Color.BLACK);

//        rm.getSplitAnfangsDate4().setBackground(Color.BLACK);
//        rm.getSplitEndDate4().setBackground(Color.BLACK);
//        rm.getSplitAnfangsTime4().setBackground(Color.BLACK);
//        rm.getSplitEndTime4().setBackground(Color.BLACK);
//        rm.getSplitDuration4().setBackground(Color.BLACK);
//        rm.getSplitTempAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitTempTolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitHumAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitHumTolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitCo2Anzeige4().setBackground(Color.BLACK);
//        rm.getSplitCo2TolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitEthylAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitEthylTolAnzeige4().setBackground(Color.BLACK);
    }

    private void setFarbe0() {
        getSc().getSplitDuration1().setBackground(Color.PINK);
        getSc().getGesamtDurationMin().setBackground(Color.PINK);
        getSc().getDateProzessBeginn().setBackground(Color.YELLOW);
        getSc().getDateProzessEnd().setBackground(Color.YELLOW);
        getSc().getTimeProzessBeginn().setBackground(Color.YELLOW);
        getSc().getTimeProzessEnde().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsDate1().setBackground(Color.YELLOW);
        getSc().getSplitEndDate1().setBackground(Color.YELLOW);
        getSc().getSplitAnfangsTime1().setBackground(Color.YELLOW);
        getSc().getSplitEndTime1().setBackground(Color.YELLOW);

        getSc().getSplitAnfangsDate2().setBackground(Color.BLACK);
        getSc().getSplitAnfangsTime2().setBackground(Color.BLACK);
        getSc().getSplitEndDate2().setBackground(Color.BLACK);
        getSc().getSplitEndTime2().setBackground(Color.BLACK);
        getSc().getSplitDuration2().setBackground(Color.BLACK);

//        rm.getSplitAnfangsDate2().setBackground(Color.BLACK);
//        rm.getSplitEndDate2().setBackground(Color.BLACK);
//        rm.getSplitAnfangsTime2().setBackground(Color.BLACK);
//        rm.getSplitEndTime2().setBackground(Color.BLACK);
//        rm.getSplitDuration2().setBackground(Color.BLACK);
//
//        rm.getSplitTempAnzeige2().setBackground(Color.BLACK);
//        rm.getSplitTempTolAnzeige2().setBackground(Color.BLACK);
//        rm.getSplitHumAnzeige2().setBackground(Color.BLACK);
//        rm.getSplitHumTolAnzeige2().setBackground(Color.BLACK);
//        rm.getSplitCo2Anzeige2().setBackground(Color.BLACK);
//        rm.getSplitCo2TolAnzeige2().setBackground(Color.BLACK);
//        rm.getSplitEthylAnzeige2().setBackground(Color.BLACK);
//        rm.getSplitEthylTolAnzeige2().setBackground(Color.BLACK);
        getSc().getSplitAnfangsDate3().setBackground(Color.BLACK);
        getSc().getSplitAnfangsTime3().setBackground(Color.BLACK);
        getSc().getSplitEndDate3().setBackground(Color.BLACK);
        getSc().getSplitEndTime3().setBackground(Color.BLACK);
        getSc().getSplitDuration3().setBackground(Color.BLACK);

//        rm.getSplitAnfangsDate3().setBackground(Color.BLACK);
//        rm.getSplitEndDate3().setBackground(Color.BLACK);
//        rm.getSplitAnfangsTime3().setBackground(Color.BLACK);
//        rm.getSplitEndTime3().setBackground(Color.BLACK);
//        rm.getSplitDuration3().setBackground(Color.BLACK);
//
//        rm.getSplitTempAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitTempTolAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitHumAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitHumTolAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitCo2Anzeige3().setBackground(Color.BLACK);
//        rm.getSplitCo2TolAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitEthylAnzeige3().setBackground(Color.BLACK);
//        rm.getSplitEthylTolAnzeige3().setBackground(Color.BLACK);
        getSc().getSplitAnfangsDate4().setBackground(Color.BLACK);
        getSc().getSplitAnfangsTime4().setBackground(Color.BLACK);
        getSc().getSplitEndDate4().setBackground(Color.BLACK);
        getSc().getSplitEndTime4().setBackground(Color.BLACK);
        getSc().getSplitDuration4().setBackground(Color.BLACK);

//        rm.getSplitAnfangsDate4().setBackground(Color.BLACK);
//        rm.getSplitEndDate4().setBackground(Color.BLACK);
//        rm.getSplitAnfangsTime4().setBackground(Color.BLACK);
//        rm.getSplitEndTime4().setBackground(Color.BLACK);
//        rm.getSplitDuration4().setBackground(Color.BLACK);
//
//        rm.getSplitTempAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitTempTolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitHumAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitHumTolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitCo2Anzeige4().setBackground(Color.BLACK);
//        rm.getSplitCo2TolAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitEthylAnzeige4().setBackground(Color.BLACK);
//        rm.getSplitEthylTolAnzeige4().setBackground(Color.BLACK);
    }

    public void setNull_234() {
        getSc().getSplitAnfangsDate2().setText("0");
        getSc().getSplitAnfangsTime2().setText("0");
        getSc().getSplitEndDate2().setText("0");
        getSc().getSplitEndTime2().setText("0");
        getSc().getSplitDuration2().setText("0");
        getSc().getSplitDurationDay2().setSelectedIndex(0);
        getSc().getSplitDurationHour2().setSelectedIndex(0);
        getSc().getSplitDurationMin2().setSelectedIndex(0);
        getSc().getSplitTemp2().setValue(0);
        getSc().getSplitTempAnzeige2().setText("0");
        getSc().getSplitTempTol2().setSelectedIndex(0);
        getSc().getSplitHum2().setValue(0);
        getSc().getSplitHumAnzeige2().setText("0");
        getSc().getSplitHumTol2().setSelectedIndex(0);
        getSc().getSplitCo22().setValue(0);
        getSc().getSplitCo2Anzeige2().setText("0");
        getSc().getSplitCo2Tol2().setSelectedIndex(0);
        getSc().getSplitEthyl2().setValue(0);
        getSc().getSplitEthylAnzeige2().setText("0");
        getSc().getSplitEthylTol2().setSelectedIndex(0);
//***********************************
        getSc().getSplitAnfangsDate3().setText("0");
        getSc().getSplitAnfangsTime3().setText("0");
        getSc().getSplitEndDate3().setText("0");
        getSc().getSplitEndTime3().setText("0");
        getSc().getSplitDuration3().setText("0");
        getSc().getSplitDurationDay3().setSelectedIndex(0);
        getSc().getSplitDurationHour3().setSelectedIndex(0);
        getSc().getSplitDurationMin3().setSelectedIndex(0);
        getSc().getSplitTemp3().setValue(0);
        getSc().getSplitTempAnzeige3().setText("0");
        getSc().getSplitTempTol3().setSelectedIndex(0);
        getSc().getSplitHum3().setValue(0);
        getSc().getSplitHumAnzeige3().setText("0");
        getSc().getSplitHumTol3().setSelectedIndex(0);
        getSc().getSplitCo23().setValue(0);
        getSc().getSplitCo2Anzeige3().setText("0");
        getSc().getSplitCo2Tol3().setSelectedIndex(0);
        getSc().getSplitEthyl3().setValue(0);
        getSc().getSplitEthylAnzeige3().setText("0");
        getSc().getSplitEthylTol3().setSelectedIndex(0);
//***********************************
        getSc().getSplitAnfangsDate4().setText("0");
        getSc().getSplitAnfangsTime4().setText("0");
        getSc().getSplitEndDate4().setText("0");
        getSc().getSplitEndTime4().setText("0");
        getSc().getSplitDuration4().setText("0");
        getSc().getSplitDurationDay4().setSelectedIndex(0);
        getSc().getSplitDurationHour4().setSelectedIndex(0);
        getSc().getSplitDurationMin4().setSelectedIndex(0);
        getSc().getSplitTemp4().setValue(0);
        getSc().getSplitTempAnzeige4().setText("0");
        getSc().getSplitTempTol4().setSelectedIndex(0);
        getSc().getSplitHum4().setValue(0);
        getSc().getSplitHumAnzeige4().setText("0");
        getSc().getSplitHumTol4().setSelectedIndex(0);
        getSc().getSplitCo24().setValue(0);
        getSc().getSplitCo2Anzeige4().setText("0");
        getSc().getSplitCo2Tol4().setSelectedIndex(0);
        getSc().getSplitEthyl4().setValue(0);
        getSc().getSplitEthylAnzeige4().setText("0");
        getSc().getSplitEthylTol4().setSelectedIndex(0);

//        rm.getSplitAnfangsDate2().setText("0");
//        rm.getSplitEndDate2().setText("0");
//        rm.getSplitAnfangsTime2().setText("0");
//        rm.getSplitEndTime2().setText("0");
//        rm.getSplitDuration2().setText("0");
//
//        rm.getSplitTempAnzeige2().setText("0");
//        rm.getSplitTempTolAnzeige2().setText("0");
//
//        rm.getSplitHumAnzeige2().setText("0");
//        rm.getSplitHumTolAnzeige2().setText("0");
//
//        rm.getSplitCo2Anzeige2().setText("0");
//        rm.getSplitCo2TolAnzeige2().setText("0");
//
//        rm.getSplitEthylAnzeige2().setText("0");
//        rm.getSplitEthylTolAnzeige2().setText("0");
//
//        rm.getSplitAnfangsDate3().setText("0");
//        rm.getSplitEndDate3().setText("0");
//        rm.getSplitAnfangsTime3().setText("0");
//        rm.getSplitEndTime3().setText("0");
//        rm.getSplitDuration3().setText("0");
//
//        rm.getSplitTempAnzeige3().setText("0");
//        rm.getSplitTempTolAnzeige3().setText("0");
//
//        rm.getSplitHumAnzeige3().setText("0");
//        rm.getSplitHumTolAnzeige3().setText("0");
//
//        rm.getSplitCo2Anzeige3().setText("0");
//        rm.getSplitCo2TolAnzeige3().setText("0");
//
//        rm.getSplitEthylAnzeige3().setText("0");
//        rm.getSplitEthylTolAnzeige3().setText("0");
//
//        rm.getSplitAnfangsDate4().setText("0");
//        rm.getSplitEndDate4().setText("0");
//        rm.getSplitAnfangsTime4().setText("0");
//        rm.getSplitEndTime4().setText("0");
//        rm.getSplitDuration4().setText("0");
//        rm.getSplitTempAnzeige4().setText("0");
//        rm.getSplitTempTolAnzeige4().setText("0");
//
//        rm.getSplitHumAnzeige4().setText("0");
//        rm.getSplitHumTolAnzeige4().setText("0");
//
//        rm.getSplitCo2Anzeige4().setText("0");
//        rm.getSplitCo2TolAnzeige4().setText("0");
//
//        rm.getSplitEthylAnzeige4().setText("0");
//        rm.getSplitEthylTolAnzeige4().setText("0");
    }

    public void setNull_34() {

        getSc().getSplitAnfangsDate3().setText("0");
        getSc().getSplitAnfangsTime3().setText("0");
        getSc().getSplitEndDate3().setText("0");
        getSc().getSplitEndTime3().setText("0");
        getSc().getSplitDuration3().setText("0");
        getSc().getSplitDurationDay3().setSelectedIndex(0);
        getSc().getSplitDurationHour3().setSelectedIndex(0);
        getSc().getSplitDurationMin3().setSelectedIndex(0);
        getSc().getSplitTemp3().setValue(0);
        getSc().getSplitTempAnzeige3().setText("0");
        getSc().getSplitTempTol3().setSelectedIndex(0);
        getSc().getSplitHum3().setValue(0);
        getSc().getSplitHumAnzeige3().setText("0");
        getSc().getSplitHumTol3().setSelectedIndex(0);
        getSc().getSplitCo23().setValue(0);
        getSc().getSplitCo2Anzeige3().setText("0");
        getSc().getSplitCo2Tol3().setSelectedIndex(0);
        getSc().getSplitEthyl3().setValue(0);
        getSc().getSplitEthylAnzeige3().setText("0");
        getSc().getSplitEthylTol3().setSelectedIndex(0);
//***********************************
        getSc().getSplitAnfangsDate4().setText("0");
        getSc().getSplitAnfangsTime4().setText("0");
        getSc().getSplitEndDate4().setText("0");
        getSc().getSplitEndTime4().setText("0");
        getSc().getSplitDuration4().setText("0");
        getSc().getSplitDurationDay4().setSelectedIndex(0);
        getSc().getSplitDurationHour4().setSelectedIndex(0);
        getSc().getSplitDurationMin4().setSelectedIndex(0);
        getSc().getSplitTemp4().setValue(0);
        getSc().getSplitTempAnzeige4().setText("0");
        getSc().getSplitTempTol4().setSelectedIndex(0);
        getSc().getSplitHum4().setValue(0);
        getSc().getSplitHumAnzeige4().setText("0");
        getSc().getSplitHumTol4().setSelectedIndex(0);
        getSc().getSplitCo24().setValue(0);
        getSc().getSplitCo2Anzeige4().setText("0");
        getSc().getSplitCo2Tol4().setSelectedIndex(0);
        getSc().getSplitEthyl4().setValue(0);
        getSc().getSplitEthylAnzeige4().setText("0");
        getSc().getSplitEthylTol4().setSelectedIndex(0);

//        rm.getSplitAnfangsDate3().setText("0");
//        rm.getSplitEndDate3().setText("0");
//        rm.getSplitAnfangsTime3().setText("0");
//        rm.getSplitEndTime3().setText("0");
//        rm.getSplitDuration3().setText("0");
//
//        rm.getSplitTempAnzeige3().setText("0");
//        rm.getSplitTempTolAnzeige3().setText("0");
//
//        rm.getSplitHumAnzeige3().setText("0");
//        rm.getSplitHumTolAnzeige3().setText("0");
//
//        rm.getSplitCo2Anzeige3().setText("0");
//        rm.getSplitCo2TolAnzeige3().setText("0");
//
//        rm.getSplitEthylAnzeige3().setText("0");
//        rm.getSplitEthylTolAnzeige3().setText("0");
//
//        rm.getSplitAnfangsDate4().setText("0");
//        rm.getSplitEndDate4().setText("0");
//        rm.getSplitAnfangsTime4().setText("0");
//        rm.getSplitEndTime4().setText("0");
//        rm.getSplitDuration4().setText("0");
//        rm.getSplitTempAnzeige4().setText("0");
//        rm.getSplitTempTolAnzeige4().setText("0");
//
//        rm.getSplitHumAnzeige4().setText("0");
//        rm.getSplitHumTolAnzeige4().setText("0");
//
//        rm.getSplitCo2Anzeige4().setText("0");
//        rm.getSplitCo2TolAnzeige4().setText("0");
//
//        rm.getSplitEthylAnzeige4().setText("0");
//        rm.getSplitEthylTolAnzeige4().setText("0");
    }

    public void setNull_4() {
        String s = "0";
//***********************************
        getSc().getSplitAnfangsDate4().setText("0");
        getSc().getSplitAnfangsTime4().setText("0");
        getSc().getSplitEndDate4().setText("0");
        getSc().getSplitEndTime4().setText("0");
        getSc().getSplitDuration4().setText("0");
        getSc().getSplitDurationDay4().setSelectedIndex(0);
        getSc().getSplitDurationHour4().setSelectedIndex(0);
        getSc().getSplitDurationMin4().setSelectedIndex(0);
        getSc().getSplitTemp4().setValue(0);
        getSc().getSplitTempAnzeige4().setText("0");
        getSc().getSplitTempTol4().setSelectedIndex(0);
        getSc().getSplitHum4().setValue(0);
        getSc().getSplitHumAnzeige4().setText("0");
        getSc().getSplitHumTol4().setSelectedIndex(0);
        getSc().getSplitCo24().setValue(0);
        getSc().getSplitCo2Anzeige4().setText("0");
        getSc().getSplitCo2Tol4().setSelectedIndex(0);
        getSc().getSplitEthyl4().setValue(0);
        getSc().getSplitEthylAnzeige4().setText("0");
        getSc().getSplitEthylTol4().setSelectedIndex(0);

//        rm.getSplitAnfangsDate4().setText("0");
//        rm.getSplitEndDate4().setText("0");
//        rm.getSplitAnfangsTime4().setText("0");
//        rm.getSplitEndTime4().setText("0");
//        rm.getSplitDuration4().setText("0");
//        rm.getSplitTempAnzeige4().setText("0");
//        rm.getSplitTempTolAnzeige4().setText("0");
//
//        rm.getSplitHumAnzeige4().setText("0");
//        rm.getSplitHumTolAnzeige4().setText("0");
//
//        rm.getSplitCo2Anzeige4().setText("0");
//        rm.getSplitCo2TolAnzeige4().setText("0");
//
//        rm.getSplitEthylAnzeige4().setText("0");
//        rm.getSplitEthylTolAnzeige4().setText("0");
    }
    /**
     * @return the multiDampIst
     */
   

    /**
     * @return the konfFileName
     */
    public String getKonfFileName() {
        return konfFileName;
    }

    /**
     * @param konfFileName the konfFileName to set
     */
    public void setKonfFileName(String konfFileName) {
        this.konfFileName = konfFileName;
    }

    /**
     * @return the parametersListe
     */
    public String getParametersListe() {
        return parametersListe;
    }

    /**
     * @param parametersListe the parametersListe to set
     */
    public void setParametersListe(String parametersListe) {
        this.parametersListe = parametersListe;
    }

    /**
     * @param mainTemp1Wire the mainTemp1Wire to set
     */
    /**
     * @return the sc
     */
    public SplitKonfiguration getSc() {
        return sc;
    }

    /**
     * @param sc the sc to set
     */
    public void setSc(SplitKonfiguration sc) {
        this.sc = sc;
    }

    /**
     * @return the gd
     */
    public GrundDaten getGd() {
        return gd;
    }

    /**
     * @param gd the gd to set
     */
    public void setGd(GrundDaten gd) {
        this.gd = gd;
    }

    /**
     * @return the rm
     */
    /**
     * @param mainTemp1Wire the mainTemp1Wire to set
     */
  
    /**
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * @return the grundPath
     */
    public String getGrundPath() {
        return grundPath;
    }

    /**
     * @param grundPath the grundPath to set
     */
    public void setGrundPath(String grundPath) {
        this.grundPath = grundPath;
    }

    /**
     * @return the circulatingLeft
     */
    public boolean isCirculatingLeft() {
        return circulatingLeft;
    }

    /**
     * @param circulatingLeft the circulatingLeft to set
     */
    public void setCirculatingLeft(boolean circulatingLeft) {
        this.circulatingLeft = circulatingLeft;
    }

    /**
     * @return the circulatingRight
     */
    public boolean isCirculatingRight() {
        return circulatingRight;
    }

    /**
     * @param circulatingRight the circulatingRight to set
     */
    public void setCirculatingRight(boolean circulatingRight) {
        this.circulatingRight = circulatingRight;
    }

    /**
     * @return the suction
     */
    public boolean isSuction() {
        return suction;
    }

    /**
     * @param suction the suction to set
     */
    public void setSuction(boolean suction) {
        this.suction = suction;
    }

    /**
     * @return the damp
     */
    public boolean isDamp() {
        return damp;
    }

    /**
     * @param damp the damp to set
     */
    public void setDamp(boolean damp) {
        this.damp = damp;
    }

    /**
     * @return the co2
     */
    public boolean isCo2() {
        return co2;
    }

    /**
     * @param co2 the co2 to set
     */
    public void setCo2(boolean co2) {
        this.co2 = co2;
    }

    /**
     * @return the ethylen
     */
    public boolean isEthylen() {
        return ethylen;
    }

    /**
     * @param ethylen the ethylen to set
     */
    public void setEthylen(boolean ethylen) {
        this.ethylen = ethylen;
    }

    /**
     * @return the cooler
     */
    public boolean isCooler() {
        return cooler;
    }

    /**
     * @param cooler the cooler to set
     */
    public void setCooler(boolean cooler) {
        this.cooler = cooler;
    }

    /**
     * @return the heater
     */
    public boolean isHeater() {
        return heater;
    }

    /**
     * @param heater the heater to set
     */
    public void setHeater(boolean heater) {
        this.heater = heater;
    }

    /**
     * @return the dataPathName
     */
    public String getDataPathName() {
        return dataPathName;
    }

    /**
     * @param dataPathName the dataPathName to set
     */
    public void setDataPathName(String dataPathName) {
        this.dataPathName = dataPathName;
    }

    /**
     * @return the selectedDate
     */
    public JDateChooser getSelectedDate() {
        return selectedDate;
    }

    /**
     * @param selectedDate the selectedDate to set
     */
    public void setSelectedDate(JDateChooser selectedDate) {
        this.selectedDate = selectedDate;
    }

    public void getDuration1() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm");
        //    SimpleDateFormat formatter2 = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        Calendar prozessAnfang = getSc().getHauptCalendar();
        Calendar prozessEnde = getSc().getHauptCalendar();
        Calendar s1AnfangC = getSc().getHauptCalendar();

        switch (getSc().getSplitMenge().getSelectedIndex()) {
            case 0:
                setFarbe0();

                // Split 1 Gesamt min ausrechnen
                roomPar.setGesamtMinS1(Integer.parseInt((String) getSc().getSplitDurationDay1().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour1().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin1().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());

                // Split 1prozessAnfangdatum formatieren und ausgeben
//                prozessAnfang.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
//                prozessAnfang.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));
//                prozessEnde.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
//                prozessEnde.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));
//                s1AnfangC.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
//                s1AnfangC.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));
                getSc().getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
                getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));

                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());

                // DAUER IN MIN AUSGEBEN
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1()));
                getSc().getSplitDuration1().setText(Integer.toString(roomPar.getGesamtMinS1()));

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                getSc().getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));

//                rm.getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
//                rm.getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration1().setText(Integer.toString(getGesamtMinS1()));
                roomPar.setS1Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS1Anfang(s1AnfangC.getTimeInMillis());

//                //s1Anfang=now.getInstance().getTimeInMillis();
//
//
//                System.out.println("s1Anfang   " + s1AnfangC.getTime() + "  s1 Anfang in Mills  " + s1AnfangC.getTimeInMillis() + " s2Anfang in Mills   " + getS1Duration());
//                System.out.println("s3Anfang in Mills  " + getS3Anfang() / 31536000 + "  s3 Dauer " + getS3Duration() + " s4Anfang in Mills  " + getS4Anfang() + "  s4 Dauer " + getS4Duration());
                setNull_234();

                break;
            case 1:
                setFarbe1();
                // Split 1 Gesamt min ausrechnen
                roomPar.setGesamtMinS1(Integer.parseInt((String) getSc().getSplitDurationDay1().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour1().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin1().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());
                // Split 1prozessAnfangdatum formatieren und ausgeben
                prozessAnfang.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                prozessAnfang.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));
                prozessEnde.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                prozessEnde.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));

                s1AnfangC.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                s1AnfangC.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));

                getSc().getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));

                getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));

                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS1());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));

                // DAUER IN MIN AUSGEBEN
//                sc.getGesamtDurationMin().setText(Integer.toString(getGesamtMinS1()));
                getSc().getSplitDuration1().setText(Integer.toString(roomPar.getGesamtMinS1()));

                roomPar.setS1Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS1Anfang(s1AnfangC.getTimeInMillis());
                s1AnfangC.add(Calendar.MINUTE, +roomPar.getGesamtMinS1());

                getSc().getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));

                roomPar.setGesamtMinS2(Integer.parseInt((String) getSc().getSplitDurationDay2().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour2().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin2().getSelectedItem()));
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2()));
                getSc().getSplitDuration2().setText(Integer.toString(roomPar.getGesamtMinS2()));

                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS2());

//                rm.getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration1().setText(Integer.toString(getGesamtMinS1()));
                roomPar.setS2Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS2Anfang(s1AnfangC.getTimeInMillis());
                s1AnfangC.add(Calendar.MINUTE, +roomPar.getGesamtMinS2());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                getSc().getSplitAnfangsDate2().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitAnfangsTime2().setText(formatter1.format(s1AnfangC.getTime()));
                getSc().getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));

//                rm.getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
//                rm.getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitAnfangsDate2().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime2().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration2().setText(Integer.toString(getGesamtMinS2()));
//                System.out.println("s1Anfang in Mills  " + getS1Anfang() + "  s1 Dauer " + getS1Duration() + " s2Anfang in Mills  " + getS2Anfang() + "  s2 Dauer " + getS2Duration());
//                System.out.println("s3Anfang in Mills  " + getS3Anfang() + "  s3 Dauer " + getS3Duration() + " s4Anfang in Mills  " + getS4Anfang() + "  s4 Dauer " + getS4Duration());
                setNull_34();
                break;
            case 2:
                setFarbe2();
                // Split 1 Gesamt min ausrechnen
                roomPar.setGesamtMinS1(Integer.parseInt((String) getSc().getSplitDurationDay1().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour1().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin1().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());
                // Split 1prozessAnfangdatum formatieren und ausgeben
                prozessAnfang.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                prozessAnfang.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));
                prozessEnde.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                prozessEnde.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));

                s1AnfangC.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                s1AnfangC.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));

                getSc().getSplitAnfangsDate1().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitAnfangsTime1().setText(formatter1.format(s1AnfangC.getTime()));
                getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));

                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS1());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));

                // DAUER IN MIN AUSGEBEN
//                sc.getGesamtDurationMin().setText(Integer.toString(getGesamtMinS1()));
                getSc().getSplitDuration1().setText(Integer.toString(roomPar.getGesamtMinS1()));

                roomPar.setS1Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
//                s1Anfang = s1AnfangC.getTimeInMillis()/1000;
                roomPar.setS1Anfang(s1AnfangC.getTimeInMillis());
                s1AnfangC.add(Calendar.MINUTE, +roomPar.getGesamtMinS1());

                getSc().getSplitEndDate1().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitEndTime1().setText(formatter1.format(s1AnfangC.getTime()));

//                rm.getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration1().setText(Integer.toString(getGesamtMinS1()));
                roomPar.setGesamtMinS2(Integer.parseInt((String) getSc().getSplitDurationDay2().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour2().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin2().getSelectedItem()));
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2()));
                getSc().getSplitDuration2().setText(Integer.toString(roomPar.getGesamtMinS2()));

                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS2());
                roomPar.setS2Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
//                s2Anfang = s1AnfangC.getTimeInMillis()/1000;
                roomPar.setS2Anfang(s1AnfangC.getTimeInMillis());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                getSc().getSplitAnfangsDate2().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitAnfangsTime2().setText(formatter1.format(s1AnfangC.getTime()));
                getSc().getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));

                s1AnfangC.add(Calendar.MINUTE, +roomPar.getGesamtMinS2());
//                rm.getSplitAnfangsDate2().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime2().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration2().setText(Integer.toString(getGesamtMinS2()));

                ////////////////////
                roomPar.setGesamtMinS3(Integer.parseInt((String) getSc().getSplitDurationDay3().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour3().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin3().getSelectedItem()));
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2() +roomPar. getGesamtMinS3()));
                getSc().getSplitDuration3().setText(Integer.toString(roomPar.getGesamtMinS3()));

                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS3());
                roomPar.setS3Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS3Anfang(s1AnfangC.getTimeInMillis());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                getSc().getSplitAnfangsDate3().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitAnfangsTime3().setText(formatter1.format(s1AnfangC.getTime()));
                getSc().getSplitEndDate3().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime3().setText(formatter1.format(prozessEnde.getTime()));

//                rm.getSplitAnfangsDate3().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime3().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate3().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime3().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration3().setText(Integer.toString(getGesamtMinS3()));
//                System.out.println("s1Anfang in Mills  " + getS1Anfang() + "  s1 Dauer " + getS1Duration() + " s2Anfang in Mills  " + getS2Anfang() + "  s2 Dauer " + getS2Duration());
//                System.out.println("s3Anfang in Mills  " + getS3Anfang() + "  s3 Dauer " + getS3Duration() + " s4Anfang in Mills  " + getS4Anfang() + "  s4 Dauer " + getS4Duration());
                setNull_4();
                break;
            case 3:
                setFarbe3();//  einsezteb
                // Split 1 Gesamt min ausrechnen
                roomPar.setGesamtMinS1(Integer.parseInt((String) getSc().getSplitDurationDay1().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour1().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin1().getSelectedItem()));
                // Split1 gesamt min anzeigen
                prozessEnde.add(prozessAnfang.MINUTE, +roomPar.getGesamtMinS1());
                // Split 1prozessAnfangdatum formatieren und ausgeben
                prozessAnfang.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                prozessAnfang.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));
                prozessEnde.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                prozessEnde.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));

                s1AnfangC.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSc().getBeginTimeHour().getSelectedItem().toString()));
                s1AnfangC.set(Calendar.MINUTE, Integer.parseInt(getSc().getBeginTimeMin().getSelectedItem().toString()));

                getSc().getSplitAnfangsDate1().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitAnfangsTime1().setText(formatter1.format(s1AnfangC.getTime()));
                getSc().getDateProzessBeginn().setText(formatter.format(prozessAnfang.getTime()));
                getSc().getTimeProzessBeginn().setText(formatter1.format(prozessAnfang.getTime()));
                //*********

//                rm.getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
                //*********
                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS1());
//                s1AnfangC.add(Calendar.MINUTE, +getGesamtMinS1());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));

                // DAUER IN MIN AUSGEBEN
//                sc.getGesamtDurationMin().setText(Integer.toString(getGesamtMinS1()));
                getSc().getSplitDuration1().setText(Integer.toString(roomPar.getGesamtMinS1()));

                roomPar.setS1Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
//                s1Anfang = s1AnfangC.getTimeInMillis()/1000;
                roomPar.setS1Anfang(s1AnfangC.getTimeInMillis());

                s1AnfangC.add(Calendar.MINUTE, +roomPar.getGesamtMinS1());
                getSc().getSplitEndDate1().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitEndTime1().setText(formatter1.format(s1AnfangC.getTime()));

//                rm.getSplitAnfangsDate1().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime1().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate1().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime1().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration1().setText(Integer.toString(getGesamtMinS1()));
                roomPar.setGesamtMinS2(Integer.parseInt((String) getSc().getSplitDurationDay2().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour2().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin2().getSelectedItem()));
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() +roomPar. getGesamtMinS2()));
                getSc().getSplitDuration2().setText(Integer.toString(roomPar.getGesamtMinS2()));

                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS2());
                roomPar.setS2Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
//                s2Anfang = s1AnfangC.getTimeInMillis()/1000;
                roomPar.setS2Anfang(s1AnfangC.getTimeInMillis());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                getSc().getSplitAnfangsDate2().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitAnfangsTime2().setText(formatter1.format(s1AnfangC.getTime()));
                getSc().getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));

                s1AnfangC.add(Calendar.MINUTE, +roomPar.getGesamtMinS2());

//                rm.getSplitAnfangsDate2().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime2().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate2().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime2().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration2().setText(Integer.toString(getGesamtMinS2()));
                ////////////////////
                roomPar.setGesamtMinS3(Integer.parseInt((String) getSc().getSplitDurationDay3().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour3().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin3().getSelectedItem()));
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2() +roomPar. getGesamtMinS3()));
                getSc().getSplitDuration3().setText(Integer.toString(roomPar.getGesamtMinS3()));

                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS3());
                roomPar.setS3Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
                roomPar.setS3Anfang(s1AnfangC.getTimeInMillis());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                getSc().getSplitAnfangsDate3().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitAnfangsTime3().setText(formatter1.format(s1AnfangC.getTime()));
                getSc().getSplitEndDate3().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime3().setText(formatter1.format(prozessEnde.getTime()));

                s1AnfangC.add(Calendar.MINUTE, +roomPar.getGesamtMinS3());
//                rm.getSplitAnfangsDate3().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime3().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate3().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime3().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration3().setText(Integer.toString(getGesamtMinS3()));

                ////////////////////
                roomPar.setGesamtMinS4(Integer.parseInt((String) getSc().getSplitDurationDay4().getSelectedItem()) * 24 * 60 + Integer.parseInt((String) getSc().getSplitDurationHour4().getSelectedItem()) * 60 + Integer.parseInt((String) getSc().getSplitDurationMin4().getSelectedItem()));
                getSc().getGesamtDurationMin().setText(Integer.toString(roomPar.getGesamtMinS1() + roomPar.getGesamtMinS2() +roomPar. getGesamtMinS3() +roomPar. getGesamtMinS4()));
                getSc().getSplitDuration4().setText(Integer.toString(roomPar.getGesamtMinS4()));

                prozessEnde.add(Calendar.MINUTE, +roomPar.getGesamtMinS4());
                roomPar.setS4Duration(prozessEnde.getTimeInMillis() - s1AnfangC.getTimeInMillis());
//                s4Anfang = s1AnfangC.getTimeInMillis()/1000;
                roomPar.setS4Anfang(s1AnfangC.getTimeInMillis());

                getSc().getDateProzessEnd().setText(formatter.format(prozessEnde.getTime()));
                getSc().getTimeProzessEnde().setText(formatter1.format(prozessEnde.getTime()));
                getSc().getSplitAnfangsDate4().setText(formatter.format(s1AnfangC.getTime()));
                getSc().getSplitAnfangsTime4().setText(formatter1.format(s1AnfangC.getTime()));
                getSc().getSplitEndDate4().setText(formatter.format(prozessEnde.getTime()));
                getSc().getSplitEndTime4().setText(formatter1.format(prozessEnde.getTime()));

//                rm.getSplitAnfangsDate4().setText(formatter.format(prozessAnfang.getTime()));
//                rm.getSplitAnfangsTime4().setText(formatter1.format(prozessAnfang.getTime()));
//                rm.getSplitEndDate4().setText(formatter.format(prozessEnde.getTime()));
//                rm.getSplitEndTime4().setText(formatter1.format(prozessEnde.getTime()));
//                rm.getSplitDuration4().setText(Integer.toString(getGesamtMinS4()));
//                System.out.println("s1Anfang in Mills  " + getS1Anfang() + "  s1 Dauer " + getS1Duration() + " s2Anfang in Mills  " + getS2Anfang() + "  s2 Dauer " + getS2Duration());
//                System.out.println("s3Anfang in Mills  " + getS3Anfang() + "  s3 Dauer " + getS3Duration() + " s4Anfang in Mills  " + getS4Anfang() + "  s4 Dauer " + getS4Duration());
                break;
        }

        roomPar.setPROZESSBEGINN(getSc().getDateProzessBeginn().getText() + "-" + getSc().getTimeProzessBeginn().getText());
        roomPar.setPROZESSEND(getSc().getDateProzessEnd().getText() + "-" + getSc().getTimeProzessEnde().getText());
    }

    public void menuDatenSpeichern111(String text) {
        prop = new Properties();
        FileOutputStream fr;
        File file = new File(this.getDataPathName());
        //   System.out.println("After Loading properties ISNNANA: " + this.getDataPathName());
        StringTokenizer st = new StringTokenizer(text, "*");
        //     System.out.println("After Loading properties ISNNANA: " + st.nextToken()+"  "+st.nextToken()+"  "+st.nextToken());
        String text1 = "";
        try {
            fr = new FileOutputStream(file);

            prop.setProperty(st.nextToken(), roomPar.getROOMNAME());
            prop.setProperty(st.nextToken(), roomPar.getPRODUKTSELECTION());
            prop.setProperty(st.nextToken(), roomPar.getUSERSELECTION());
            prop.setProperty(st.nextToken(), roomPar.getPRODUKTNRSELECTION());

            prop.setProperty(st.nextToken(), roomPar.getSPLITMENGE());
            prop.setProperty(st.nextToken(), roomPar.getETHYLSETPUTTIME());
            prop.setProperty(st.nextToken(), roomPar.getDELAYTIMEETHYLTOMES());
            prop.setProperty(st.nextToken(), roomPar.getCIRCULATINGAIR());

            prop.setProperty(st.nextToken(), roomPar.getCIRCULATINAIRDELAY());
            prop.setProperty(st.nextToken(), roomPar.getHEATERDELAY());
            prop.setProperty(st.nextToken(), roomPar.getCOOLERDELAY());
            prop.setProperty(st.nextToken(), roomPar.getDAMPERDELAY());
            prop.setProperty(st.nextToken(), roomPar.getFRESHAIRDELAY());
            prop.setProperty(st.nextToken(), roomPar.getBEGINTIMEHOUR());
            prop.setProperty(st.nextToken(), roomPar.getBEGINTIMEMIN());

            prop.setProperty(st.nextToken(), roomPar.getIPADRESS());
            prop.setProperty(st.nextToken(), roomPar.getPORTNR());
            prop.setProperty(st.nextToken(), roomPar.getS1DURATIONDAY());
            prop.setProperty(st.nextToken(), roomPar.getS1DURATIONHOUR());
            prop.setProperty(st.nextToken(), roomPar.getS1DURATIONMIN());
            prop.setProperty(st.nextToken(), roomPar.getS1SETTEMP());
            prop.setProperty(st.nextToken(), roomPar.getS1SETTEMPTOL());
            prop.setProperty(st.nextToken(), roomPar.getS1SETHUM());
            prop.setProperty(st.nextToken(), roomPar.getS1SETHUMTOL());
            prop.setProperty(st.nextToken(), roomPar.getS1SETCO2());
            prop.setProperty(st.nextToken(), roomPar.getS1SETCO2TOL());
            prop.setProperty(st.nextToken(), roomPar.getS1SETETHYL());
            prop.setProperty(st.nextToken(), roomPar.getS1SETETHYLTOL());
            //2
            prop.setProperty(st.nextToken(), roomPar.getS2DURATIONDAY());
            prop.setProperty(st.nextToken(), roomPar.getS2DURATIONHOUR());
            prop.setProperty(st.nextToken(), roomPar.getS2DURATIONMIN());
            prop.setProperty(st.nextToken(), roomPar.getS2SETTEMP());
            prop.setProperty(st.nextToken(), roomPar.getS2SETTEMPTOL());
            prop.setProperty(st.nextToken(), roomPar.getS2SETHUM());
            prop.setProperty(st.nextToken(), roomPar.getS2SETHUMTOL());
            prop.setProperty(st.nextToken(), roomPar.getS2SETCO2());
            prop.setProperty(st.nextToken(), roomPar.getS2SETCO2TOL());
            prop.setProperty(st.nextToken(), roomPar.getS2SETETHYL());
            prop.setProperty(st.nextToken(), roomPar.getS2SETETHYLTOL());
            //3
            prop.setProperty(st.nextToken(), roomPar.getS3DURATIONDAY());
            prop.setProperty(st.nextToken(), roomPar.getS3DURATIONHOUR());
            prop.setProperty(st.nextToken(), roomPar.getS3DURATIONMIN());
            prop.setProperty(st.nextToken(), roomPar.getS3SETTEMP());
            prop.setProperty(st.nextToken(), roomPar.getS3SETTEMPTOL());
            prop.setProperty(st.nextToken(), roomPar.getS3SETHUM());
            prop.setProperty(st.nextToken(), roomPar.getS3SETHUMTOL());
            prop.setProperty(st.nextToken(), roomPar.getS3SETCO2());
            prop.setProperty(st.nextToken(), roomPar.getS3SETCO2TOL());
            prop.setProperty(st.nextToken(), roomPar.getS3SETETHYL());
            prop.setProperty(st.nextToken(), roomPar.getS3SETETHYLTOL());
            // 4
            prop.setProperty(st.nextToken(), roomPar.getS4DURATIONDAY());
            prop.setProperty(st.nextToken(), roomPar.getS4DURATIONHOUR());
            prop.setProperty(st.nextToken(), roomPar.getS4DURATIONMIN());
            prop.setProperty(st.nextToken(), roomPar.getS4SETTEMP());
            prop.setProperty(st.nextToken(), roomPar.getS4SETTEMPTOL());
            prop.setProperty(st.nextToken(), roomPar.getS4SETHUM());
            prop.setProperty(st.nextToken(), roomPar.getS4SETHUMTOL());
            prop.setProperty(st.nextToken(), roomPar.getS4SETCO2());
            prop.setProperty(st.nextToken(), roomPar.getS4SETCO2TOL());
            prop.setProperty(st.nextToken(), roomPar.getS4SETETHYL());
            prop.setProperty(st.nextToken(), roomPar.getS4SETETHYLTOL());
            prop.store(fr, null);
            fr.close();

            //       System.out.println("After saving properties:cccccccccccc " + prop);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the prozessDatenZurLaufzeit
     */
    public String getProzessDatenZurLaufzeit() {
        return prozessDatenZurLaufzeit;
    }

    /**
     * @param prozessDatenZurLaufzeit the prozessDatenZurLaufzeit to set
     */
    public void setProzessDatenZurLaufzeit(String prozessDatenZurLaufzeit) {
        this.prozessDatenZurLaufzeit = prozessDatenZurLaufzeit;
    }

    /**
     * @return the startTimer
     */
    public Boolean getStartTimer() {
        return startTimer;
    }

    /**
     * @param startTimer the startTimer to set
     */
    public void setStartTimer(Boolean startTimer) {
        this.startTimer = startTimer;
    }

}
