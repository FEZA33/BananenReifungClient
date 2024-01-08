/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSeiteNeu;

/**
 *
 * @author basib 
 */
public class RoomParameters {


        private int gesamtMinS1;
    private int gesamtMinS2;
    private int gesamtMinS3;
    private int gesamtMinS4;
    private long s1Duration, s2Duration, s3Duration, s4Duration, s1Anfang, s2Anfang, s3Anfang, s4Anfang;
    private long beginnInMinuten;
    private String roomName;
    private String ROOMNAME;
    private String PRODUKTSELECTION;
    private String USERSELECTION;
    private String PRODUKTNRSELECTION;
    private String SPLITMENGE;
    private String ETHYLSETPUTTIME;
    private String DELAYTIMEETHYLTOMES;
    private String CIRCULATINGAIR;
    private String CIRCULATINAIRDELAY;
    private String HEATERDELAY;
    private String COOLERDELAY;
    private String DAMPERDELAY;
    private String FRESHAIRDELAY;
    private String BEGINTIMEHOUR;
    private String BEGINTIMEMIN;
    private String IPADRESS;
    private String PORTNR;
    private String S1DURATIONDAY;
    private String S1DURATIONHOUR;
    private String S1DURATIONMIN;
    private String S1SETTEMP;
    private String S1SETTEMPANZEIGE;
    private String S1SETTEMPTOL;
    private String S1SETHUM;
    private String S1SETHUMANZEIGE;
    private String S1SETHUMTOL;
    private String S1SETCO2;
    private String S1SETCO2ANZEIGE;
    private String S1SETCO2TOL;
    private String S1SETETHYL;
    private String S1SETETHYLANZEIGE;
    private String S1SETETHYLTOL;
    private String S2DURATIONDAY;
    private String S2DURATIONHOUR;
    private String S2DURATIONMIN;
    private String S2SETTEMP;
    private String S2SETTEMPANZEIGE;
    private String S2SETTEMPTOL;
    private String S2SETHUM;
    private String S2SETHUMANZEIGE;
    private String S2SETHUMTOL;
    private String S2SETCO2;
    private String S2SETCO2ANZEIGE;
    private String S2SETCO2TOL;
    private String S2SETETHYL;
    private String S2SETETHYLANZEIGE;
    private String S2SETETHYLTOL;
    private String S3DURATIONDAY;
    private String S3DURATIONHOUR;
    private String S3DURATIONMIN;
    private String S3SETTEMP;
    private String S3SETTEMPANZEIGE;
    private String S3SETTEMPTOL;
    private String S3SETHUM;
    private String S3SETHUMANZEIGE;
    private String S3SETHUMTOL;
    private String S3SETCO2;
    private String S3SETCO2ANZEIGE;
    private String S3SETCO2TOL;
    private String S3SETETHYL;
    private String S3SETETHYLANZEIGE;
    private String S3SETETHYLTOL;
    private String S4DURATIONDAY;
    private String S4DURATIONHOUR;
    private String S4DURATIONMIN;
    private String S4SETTEMP;
    private String S4SETTEMPANZEIGE;
    private String S4SETTEMPTOL;
    private String S4SETHUM;
    private String S4SETHUMANZEIGE;
    private String S4SETHUMTOL;
    private String S4SETCO2;
    private String S4SETCO2ANZEIGE;
    private String S4SETCO2TOL;
    private String S4SETETHYL;
    private String S4SETETHYLANZEIGE;
    private String S4SETETHYLTOL;
    private String PROZESSBEGINN;
    private String PROZESSEND;

    private String S1DURATION;
    private String S1STARTDATE;
    private String S2DURATION;
    private String S2STARTDATE;
    private String S3DURATION;
    private String S3STARTDATE;
    private String S4DURATION;
    private String S4STARTDATE;

    private String aktuelleRoomValues;
    private String tempIst, humIst, co2Ist, ethylIst;
    private String multiDamp, multiTemp, z1In, z1Out, z2In, z2Out, prT1, prT2, prT3, mainTemp1Wire;
    private float multiDampIst, multiTempIst, z1InIst, z1OutIst, z2InIst, z2OutIst, prT1Ist, prT2Ist, prT3Ist, mainTemp1WireIst;

    
    public RoomParameters(){
        
    }
    
        /**
     * @return the gesamtMinS1
     */
    public int getGesamtMinS1() {
        return gesamtMinS1;
    }

    /**
     * @param gesamtMinS1 the gesamtMinS1 to set
     */
    public void setGesamtMinS1(int gesamtMinS1) {
        this.gesamtMinS1 = gesamtMinS1;
    }

    /**
     * @return the gesamtMinS2
     */
    public int getGesamtMinS2() {
        return gesamtMinS2;
    }

    /**
     * @param gesamtMinS2 the gesamtMinS2 to set
     */
    public void setGesamtMinS2(int gesamtMinS2) {
        this.gesamtMinS2 = gesamtMinS2;
    }

    /**
     * @return the gesamtMinS3
     */
    public int getGesamtMinS3() {
        return gesamtMinS3;
    }

    /**
     * @param gesamtMinS3 the gesamtMinS3 to set
     */
    public void setGesamtMinS3(int gesamtMinS3) {
        this.gesamtMinS3 = gesamtMinS3;
    }

    /**
     * @return the gesamtMinS4
     */
    public int getGesamtMinS4() {
        return gesamtMinS4;
    }

    /**
     * @param gesamtMinS4 the gesamtMinS4 to set
     */
    public void setGesamtMinS4(int gesamtMinS4) {
        this.gesamtMinS4 = gesamtMinS4;
    }

    /**
     * @return the s1Duration
     */
    public long getS1Duration() {
        return s1Duration;
    }

    /**
     * @param s1Duration the s1Duration to set
     */
    public void setS1Duration(long s1Duration) {
        this.s1Duration = s1Duration;
    }

    /**
     * @return the s2Duration
     */
    public long getS2Duration() {
        return s2Duration;
    }

    /**
     * @param s2Duration the s2Duration to set
     */
    public void setS2Duration(long s2Duration) {
        this.s2Duration = s2Duration;
    }

    /**
     * @return the s3Duration
     */
    public long getS3Duration() {
        return s3Duration;
    }

    /**
     * @param s3Duration the s3Duration to set
     */
    public void setS3Duration(long s3Duration) {
        this.s3Duration = s3Duration;
    }

    /**
     * @return the s4Duration
     */
    public long getS4Duration() {
        return s4Duration;
    }

    /**
     * @param s4Duration the s4Duration to set
     */
    public void setS4Duration(long s4Duration) {
        this.s4Duration = s4Duration;
    }

    /**
     * @return the s1Anfang
     */
    public long getS1Anfang() {
        return s1Anfang;
    }

    /**
     * @param s1Anfang the s1Anfang to set
     */
    public void setS1Anfang(long s1Anfang) {
        this.s1Anfang = s1Anfang;
    }

    /**
     * @return the s2Anfang
     */
    public long getS2Anfang() {
        return s2Anfang;
    }

    /**
     * @param s2Anfang the s2Anfang to set
     */
    public void setS2Anfang(long s2Anfang) {
        this.s2Anfang = s2Anfang;
    }

    /**
     * @return the s3Anfang
     */
    public long getS3Anfang() {
        return s3Anfang;
    }

    /**
     * @param s3Anfang the s3Anfang to set
     */
    public void setS3Anfang(long s3Anfang) {
        this.s3Anfang = s3Anfang;
    }

    /**
     * @return the s4Anfang
     */
    public long getS4Anfang() {
        return s4Anfang;
    }

    /**
     * @param s4Anfang the s4Anfang to set
     */
    public void setS4Anfang(long s4Anfang) {
        this.s4Anfang = s4Anfang;
    }

    /**
     * @return the beginnInMinuten
     */
    public long getBeginnInMinuten() {
        return beginnInMinuten;
    }

    /**
     * @param beginnInMinuten the beginnInMinuten to set
     */
    public void setBeginnInMinuten(long beginnInMinuten) {
        this.beginnInMinuten = beginnInMinuten;
    }

    /**
     * @return the roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * @return the ROOMNAME
     */
    public String getROOMNAME() {
        return ROOMNAME;
    }

    /**
     * @param ROOMNAME the ROOMNAME to set
     */
    public void setROOMNAME(String ROOMNAME) {
        this.ROOMNAME = ROOMNAME;
    }

    /**
     * @return the PRODUKTSELECTION
     */
    public String getPRODUKTSELECTION() {
        return PRODUKTSELECTION;
    }

    /**
     * @param PRODUKTSELECTION the PRODUKTSELECTION to set
     */
    public void setPRODUKTSELECTION(String PRODUKTSELECTION) {
        this.PRODUKTSELECTION = PRODUKTSELECTION;
    }

    /**
     * @return the USERSELECTION
     */
    public String getUSERSELECTION() {
        return USERSELECTION;
    }

    /**
     * @param USERSELECTION the USERSELECTION to set
     */
    public void setUSERSELECTION(String USERSELECTION) {
        this.USERSELECTION = USERSELECTION;
    }

    /**
     * @return the PRODUKTNRSELECTION
     */
    public String getPRODUKTNRSELECTION() {
        return PRODUKTNRSELECTION;
    }

    /**
     * @param PRODUKTNRSELECTION the PRODUKTNRSELECTION to set
     */
    public void setPRODUKTNRSELECTION(String PRODUKTNRSELECTION) {
        this.PRODUKTNRSELECTION = PRODUKTNRSELECTION;
    }

    /**
     * @return the SPLITMENGE
     */
    public String getSPLITMENGE() {
        return SPLITMENGE;
    }

    /**
     * @param SPLITMENGE the SPLITMENGE to set
     */
    public void setSPLITMENGE(String SPLITMENGE) {
        this.SPLITMENGE = SPLITMENGE;
    }

    /**
     * @return the ETHYLSETPUTTIME
     */
    public String getETHYLSETPUTTIME() {
        return ETHYLSETPUTTIME;
    }

    /**
     * @param ETHYLSETPUTTIME the ETHYLSETPUTTIME to set
     */
    public void setETHYLSETPUTTIME(String ETHYLSETPUTTIME) {
        this.ETHYLSETPUTTIME = ETHYLSETPUTTIME;
    }

    /**
     * @return the DELAYTIMEETHYLTOMES
     */
    public String getDELAYTIMEETHYLTOMES() {
        return DELAYTIMEETHYLTOMES;
    }

    /**
     * @param DELAYTIMEETHYLTOMES the DELAYTIMEETHYLTOMES to set
     */
    public void setDELAYTIMEETHYLTOMES(String DELAYTIMEETHYLTOMES) {
        this.DELAYTIMEETHYLTOMES = DELAYTIMEETHYLTOMES;
    }

    /**
     * @return the CIRCULATINGAIR
     */
    public String getCIRCULATINGAIR() {
        return CIRCULATINGAIR;
    }

    /**
     * @param CIRCULATINGAIR the CIRCULATINGAIR to set
     */
    public void setCIRCULATINGAIR(String CIRCULATINGAIR) {
        this.CIRCULATINGAIR = CIRCULATINGAIR;
    }

    /**
     * @return the CIRCULATINAIRDELAY
     */
    public String getCIRCULATINAIRDELAY() {
        return CIRCULATINAIRDELAY;
    }

    /**
     * @param CIRCULATINAIRDELAY the CIRCULATINAIRDELAY to set
     */
    public void setCIRCULATINAIRDELAY(String CIRCULATINAIRDELAY) {
        this.CIRCULATINAIRDELAY = CIRCULATINAIRDELAY;
    }

    /**
     * @return the HEATERDELAY
     */
    public String getHEATERDELAY() {
        return HEATERDELAY;
    }

    /**
     * @param HEATERDELAY the HEATERDELAY to set
     */
    public void setHEATERDELAY(String HEATERDELAY) {
        this.HEATERDELAY = HEATERDELAY;
    }

    /**
     * @return the COOLERDELAY
     */
    public String getCOOLERDELAY() {
        return COOLERDELAY;
    }

    /**
     * @param COOLERDELAY the COOLERDELAY to set
     */
    public void setCOOLERDELAY(String COOLERDELAY) {
        this.COOLERDELAY = COOLERDELAY;
    }

    /**
     * @return the DAMPERDELAY
     */
    public String getDAMPERDELAY() {
        return DAMPERDELAY;
    }

    /**
     * @param DAMPERDELAY the DAMPERDELAY to set
     */
    public void setDAMPERDELAY(String DAMPERDELAY) {
        this.DAMPERDELAY = DAMPERDELAY;
    }

    /**
     * @return the FRESHAIRDELAY
     */
    public String getFRESHAIRDELAY() {
        return FRESHAIRDELAY;
    }

    /**
     * @param FRESHAIRDELAY the FRESHAIRDELAY to set
     */
    public void setFRESHAIRDELAY(String FRESHAIRDELAY) {
        this.FRESHAIRDELAY = FRESHAIRDELAY;
    }

    /**
     * @return the BEGINTIMEHOUR
     */
    public String getBEGINTIMEHOUR() {
        return BEGINTIMEHOUR;
    }

    /**
     * @param BEGINTIMEHOUR the BEGINTIMEHOUR to set
     */
    public void setBEGINTIMEHOUR(String BEGINTIMEHOUR) {
        this.BEGINTIMEHOUR = BEGINTIMEHOUR;
    }

    /**
     * @return the BEGINTIMEMIN
     */
    public String getBEGINTIMEMIN() {
        return BEGINTIMEMIN;
    }

    /**
     * @param BEGINTIMEMIN the BEGINTIMEMIN to set
     */
    public void setBEGINTIMEMIN(String BEGINTIMEMIN) {
        this.BEGINTIMEMIN = BEGINTIMEMIN;
    }

    /**
     * @return the IPADRESS
     */
    public String getIPADRESS() {
        return IPADRESS;
    }

    /**
     * @param IPADRESS the IPADRESS to set
     */
    public void setIPADRESS(String IPADRESS) {
        this.IPADRESS = IPADRESS;
    }

    /**
     * @return the PORTNR
     */
    public String getPORTNR() {
        return PORTNR;
    }

    /**
     * @param PORTNR the PORTNR to set
     */
    public void setPORTNR(String PORTNR) {
        this.PORTNR = PORTNR;
    }

    /**
     * @return the S1DURATIONDAY
     */
    public String getS1DURATIONDAY() {
        return S1DURATIONDAY;
    }

    /**
     * @param S1DURATIONDAY the S1DURATIONDAY to set
     */
    public void setS1DURATIONDAY(String S1DURATIONDAY) {
        this.S1DURATIONDAY = S1DURATIONDAY;
    }

    /**
     * @return the S1DURATIONHOUR
     */
    public String getS1DURATIONHOUR() {
        return S1DURATIONHOUR;
    }

    /**
     * @param S1DURATIONHOUR the S1DURATIONHOUR to set
     */
    public void setS1DURATIONHOUR(String S1DURATIONHOUR) {
        this.S1DURATIONHOUR = S1DURATIONHOUR;
    }

    /**
     * @return the S1DURATIONMIN
     */
    public String getS1DURATIONMIN() {
        return S1DURATIONMIN;
    }

    /**
     * @param S1DURATIONMIN the S1DURATIONMIN to set
     */
    public void setS1DURATIONMIN(String S1DURATIONMIN) {
        this.S1DURATIONMIN = S1DURATIONMIN;
    }

    /**
     * @return the S1SETTEMP
     */
    public String getS1SETTEMP() {
        return S1SETTEMP;
    }

    /**
     * @param S1SETTEMP the S1SETTEMP to set
     */
    public void setS1SETTEMP(String S1SETTEMP) {
        this.S1SETTEMP = S1SETTEMP;
    }

    /**
     * @return the S1SETTEMPANZEIGE
     */
    public String getS1SETTEMPANZEIGE() {
        return S1SETTEMPANZEIGE;
    }

    /**
     * @param S1SETTEMPANZEIGE the S1SETTEMPANZEIGE to set
     */
    public void setS1SETTEMPANZEIGE(String S1SETTEMPANZEIGE) {
        this.S1SETTEMPANZEIGE = S1SETTEMPANZEIGE;
    }

    /**
     * @return the S1SETTEMPTOL
     */
    public String getS1SETTEMPTOL() {
        return S1SETTEMPTOL;
    }

    /**
     * @param S1SETTEMPTOL the S1SETTEMPTOL to set
     */
    public void setS1SETTEMPTOL(String S1SETTEMPTOL) {
        this.S1SETTEMPTOL = S1SETTEMPTOL;
    }

    /**
     * @return the S1SETHUM
     */
    public String getS1SETHUM() {
        return S1SETHUM;
    }

    /**
     * @param S1SETHUM the S1SETHUM to set
     */
    public void setS1SETHUM(String S1SETHUM) {
        this.S1SETHUM = S1SETHUM;
    }

    /**
     * @return the S1SETHUMANZEIGE
     */
    public String getS1SETHUMANZEIGE() {
        return S1SETHUMANZEIGE;
    }

    /**
     * @param S1SETHUMANZEIGE the S1SETHUMANZEIGE to set
     */
    public void setS1SETHUMANZEIGE(String S1SETHUMANZEIGE) {
        this.S1SETHUMANZEIGE = S1SETHUMANZEIGE;
    }

    /**
     * @return the S1SETHUMTOL
     */
    public String getS1SETHUMTOL() {
        return S1SETHUMTOL;
    }

    /**
     * @param S1SETHUMTOL the S1SETHUMTOL to set
     */
    public void setS1SETHUMTOL(String S1SETHUMTOL) {
        this.S1SETHUMTOL = S1SETHUMTOL;
    }

    /**
     * @return the S1SETCO2
     */
    public String getS1SETCO2() {
        return S1SETCO2;
    }

    /**
     * @param S1SETCO2 the S1SETCO2 to set
     */
    public void setS1SETCO2(String S1SETCO2) {
        this.S1SETCO2 = S1SETCO2;
    }

    /**
     * @return the S1SETCO2ANZEIGE
     */
    public String getS1SETCO2ANZEIGE() {
        return S1SETCO2ANZEIGE;
    }

    /**
     * @param S1SETCO2ANZEIGE the S1SETCO2ANZEIGE to set
     */
    public void setS1SETCO2ANZEIGE(String S1SETCO2ANZEIGE) {
        this.S1SETCO2ANZEIGE = S1SETCO2ANZEIGE;
    }

    /**
     * @return the S1SETCO2TOL
     */
    public String getS1SETCO2TOL() {
        return S1SETCO2TOL;
    }

    /**
     * @param S1SETCO2TOL the S1SETCO2TOL to set
     */
    public void setS1SETCO2TOL(String S1SETCO2TOL) {
        this.S1SETCO2TOL = S1SETCO2TOL;
    }

    /**
     * @return the S1SETETHYL
     */
    public String getS1SETETHYL() {
        return S1SETETHYL;
    }

    /**
     * @param S1SETETHYL the S1SETETHYL to set
     */
    public void setS1SETETHYL(String S1SETETHYL) {
        this.S1SETETHYL = S1SETETHYL;
    }

    /**
     * @return the S1SETETHYLANZEIGE
     */
    public String getS1SETETHYLANZEIGE() {
        return S1SETETHYLANZEIGE;
    }

    /**
     * @param S1SETETHYLANZEIGE the S1SETETHYLANZEIGE to set
     */
    public void setS1SETETHYLANZEIGE(String S1SETETHYLANZEIGE) {
        this.S1SETETHYLANZEIGE = S1SETETHYLANZEIGE;
    }

    /**
     * @return the S1SETETHYLTOL
     */
    public String getS1SETETHYLTOL() {
        return S1SETETHYLTOL;
    }

    /**
     * @param S1SETETHYLTOL the S1SETETHYLTOL to set
     */
    public void setS1SETETHYLTOL(String S1SETETHYLTOL) {
        this.S1SETETHYLTOL = S1SETETHYLTOL;
    }

    /**
     * @return the S2DURATIONDAY
     */
    public String getS2DURATIONDAY() {
        return S2DURATIONDAY;
    }

    /**
     * @param S2DURATIONDAY the S2DURATIONDAY to set
     */
    public void setS2DURATIONDAY(String S2DURATIONDAY) {
        this.S2DURATIONDAY = S2DURATIONDAY;
    }

    /**
     * @return the S2DURATIONHOUR
     */
    public String getS2DURATIONHOUR() {
        return S2DURATIONHOUR;
    }

    /**
     * @param S2DURATIONHOUR the S2DURATIONHOUR to set
     */
    public void setS2DURATIONHOUR(String S2DURATIONHOUR) {
        this.S2DURATIONHOUR = S2DURATIONHOUR;
    }

    /**
     * @return the S2DURATIONMIN
     */
    public String getS2DURATIONMIN() {
        return S2DURATIONMIN;
    }

    /**
     * @param S2DURATIONMIN the S2DURATIONMIN to set
     */
    public void setS2DURATIONMIN(String S2DURATIONMIN) {
        this.S2DURATIONMIN = S2DURATIONMIN;
    }

    /**
     * @return the S2SETTEMP
     */
    public String getS2SETTEMP() {
        return S2SETTEMP;
    }

    /**
     * @param S2SETTEMP the S2SETTEMP to set
     */
    public void setS2SETTEMP(String S2SETTEMP) {
        this.S2SETTEMP = S2SETTEMP;
    }

    /**
     * @return the S2SETTEMPANZEIGE
     */
    public String getS2SETTEMPANZEIGE() {
        return S2SETTEMPANZEIGE;
    }

    /**
     * @param S2SETTEMPANZEIGE the S2SETTEMPANZEIGE to set
     */
    public void setS2SETTEMPANZEIGE(String S2SETTEMPANZEIGE) {
        this.S2SETTEMPANZEIGE = S2SETTEMPANZEIGE;
    }

    /**
     * @return the S2SETTEMPTOL
     */
    public String getS2SETTEMPTOL() {
        return S2SETTEMPTOL;
    }

    /**
     * @param S2SETTEMPTOL the S2SETTEMPTOL to set
     */
    public void setS2SETTEMPTOL(String S2SETTEMPTOL) {
        this.S2SETTEMPTOL = S2SETTEMPTOL;
    }

    /**
     * @return the S2SETHUM
     */
    public String getS2SETHUM() {
        return S2SETHUM;
    }

    /**
     * @param S2SETHUM the S2SETHUM to set
     */
    public void setS2SETHUM(String S2SETHUM) {
        this.S2SETHUM = S2SETHUM;
    }

    /**
     * @return the S2SETHUMANZEIGE
     */
    public String getS2SETHUMANZEIGE() {
        return S2SETHUMANZEIGE;
    }

    /**
     * @param S2SETHUMANZEIGE the S2SETHUMANZEIGE to set
     */
    public void setS2SETHUMANZEIGE(String S2SETHUMANZEIGE) {
        this.S2SETHUMANZEIGE = S2SETHUMANZEIGE;
    }

    /**
     * @return the S2SETHUMTOL
     */
    public String getS2SETHUMTOL() {
        return S2SETHUMTOL;
    }

    /**
     * @param S2SETHUMTOL the S2SETHUMTOL to set
     */
    public void setS2SETHUMTOL(String S2SETHUMTOL) {
        this.S2SETHUMTOL = S2SETHUMTOL;
    }

    /**
     * @return the S2SETCO2
     */
    public String getS2SETCO2() {
        return S2SETCO2;
    }

    /**
     * @param S2SETCO2 the S2SETCO2 to set
     */
    public void setS2SETCO2(String S2SETCO2) {
        this.S2SETCO2 = S2SETCO2;
    }

    /**
     * @return the S2SETCO2ANZEIGE
     */
    public String getS2SETCO2ANZEIGE() {
        return S2SETCO2ANZEIGE;
    }

    /**
     * @param S2SETCO2ANZEIGE the S2SETCO2ANZEIGE to set
     */
    public void setS2SETCO2ANZEIGE(String S2SETCO2ANZEIGE) {
        this.S2SETCO2ANZEIGE = S2SETCO2ANZEIGE;
    }

    /**
     * @return the S2SETCO2TOL
     */
    public String getS2SETCO2TOL() {
        return S2SETCO2TOL;
    }

    /**
     * @param S2SETCO2TOL the S2SETCO2TOL to set
     */
    public void setS2SETCO2TOL(String S2SETCO2TOL) {
        this.S2SETCO2TOL = S2SETCO2TOL;
    }

    /**
     * @return the S2SETETHYL
     */
    public String getS2SETETHYL() {
        return S2SETETHYL;
    }

    /**
     * @param S2SETETHYL the S2SETETHYL to set
     */
    public void setS2SETETHYL(String S2SETETHYL) {
        this.S2SETETHYL = S2SETETHYL;
    }

    /**
     * @return the S2SETETHYLANZEIGE
     */
    public String getS2SETETHYLANZEIGE() {
        return S2SETETHYLANZEIGE;
    }

    /**
     * @param S2SETETHYLANZEIGE the S2SETETHYLANZEIGE to set
     */
    public void setS2SETETHYLANZEIGE(String S2SETETHYLANZEIGE) {
        this.S2SETETHYLANZEIGE = S2SETETHYLANZEIGE;
    }

    /**
     * @return the S2SETETHYLTOL
     */
    public String getS2SETETHYLTOL() {
        return S2SETETHYLTOL;
    }

    /**
     * @param S2SETETHYLTOL the S2SETETHYLTOL to set
     */
    public void setS2SETETHYLTOL(String S2SETETHYLTOL) {
        this.S2SETETHYLTOL = S2SETETHYLTOL;
    }

    /**
     * @return the S3DURATIONDAY
     */
    public String getS3DURATIONDAY() {
        return S3DURATIONDAY;
    }

    /**
     * @param S3DURATIONDAY the S3DURATIONDAY to set
     */
    public void setS3DURATIONDAY(String S3DURATIONDAY) {
        this.S3DURATIONDAY = S3DURATIONDAY;
    }

    /**
     * @return the S3DURATIONHOUR
     */
    public String getS3DURATIONHOUR() {
        return S3DURATIONHOUR;
    }

    /**
     * @param S3DURATIONHOUR the S3DURATIONHOUR to set
     */
    public void setS3DURATIONHOUR(String S3DURATIONHOUR) {
        this.S3DURATIONHOUR = S3DURATIONHOUR;
    }

    /**
     * @return the S3DURATIONMIN
     */
    public String getS3DURATIONMIN() {
        return S3DURATIONMIN;
    }

    /**
     * @param S3DURATIONMIN the S3DURATIONMIN to set
     */
    public void setS3DURATIONMIN(String S3DURATIONMIN) {
        this.S3DURATIONMIN = S3DURATIONMIN;
    }

    /**
     * @return the S3SETTEMP
     */
    public String getS3SETTEMP() {
        return S3SETTEMP;
    }

    /**
     * @param S3SETTEMP the S3SETTEMP to set
     */
    public void setS3SETTEMP(String S3SETTEMP) {
        this.S3SETTEMP = S3SETTEMP;
    }

    /**
     * @return the S3SETTEMPANZEIGE
     */
    public String getS3SETTEMPANZEIGE() {
        return S3SETTEMPANZEIGE;
    }

    /**
     * @param S3SETTEMPANZEIGE the S3SETTEMPANZEIGE to set
     */
    public void setS3SETTEMPANZEIGE(String S3SETTEMPANZEIGE) {
        this.S3SETTEMPANZEIGE = S3SETTEMPANZEIGE;
    }

    /**
     * @return the S3SETTEMPTOL
     */
    public String getS3SETTEMPTOL() {
        return S3SETTEMPTOL;
    }

    /**
     * @param S3SETTEMPTOL the S3SETTEMPTOL to set
     */
    public void setS3SETTEMPTOL(String S3SETTEMPTOL) {
        this.S3SETTEMPTOL = S3SETTEMPTOL;
    }

    /**
     * @return the S3SETHUM
     */
    public String getS3SETHUM() {
        return S3SETHUM;
    }

    /**
     * @param S3SETHUM the S3SETHUM to set
     */
    public void setS3SETHUM(String S3SETHUM) {
        this.S3SETHUM = S3SETHUM;
    }

    /**
     * @return the S3SETHUMANZEIGE
     */
    public String getS3SETHUMANZEIGE() {
        return S3SETHUMANZEIGE;
    }

    /**
     * @param S3SETHUMANZEIGE the S3SETHUMANZEIGE to set
     */
    public void setS3SETHUMANZEIGE(String S3SETHUMANZEIGE) {
        this.S3SETHUMANZEIGE = S3SETHUMANZEIGE;
    }

    /**
     * @return the S3SETHUMTOL
     */
    public String getS3SETHUMTOL() {
        return S3SETHUMTOL;
    }

    /**
     * @param S3SETHUMTOL the S3SETHUMTOL to set
     */
    public void setS3SETHUMTOL(String S3SETHUMTOL) {
        this.S3SETHUMTOL = S3SETHUMTOL;
    }

    /**
     * @return the S3SETCO2
     */
    public String getS3SETCO2() {
        return S3SETCO2;
    }

    /**
     * @param S3SETCO2 the S3SETCO2 to set
     */
    public void setS3SETCO2(String S3SETCO2) {
        this.S3SETCO2 = S3SETCO2;
    }

    /**
     * @return the S3SETCO2ANZEIGE
     */
    public String getS3SETCO2ANZEIGE() {
        return S3SETCO2ANZEIGE;
    }

    /**
     * @param S3SETCO2ANZEIGE the S3SETCO2ANZEIGE to set
     */
    public void setS3SETCO2ANZEIGE(String S3SETCO2ANZEIGE) {
        this.S3SETCO2ANZEIGE = S3SETCO2ANZEIGE;
    }

    /**
     * @return the S3SETCO2TOL
     */
    public String getS3SETCO2TOL() {
        return S3SETCO2TOL;
    }

    /**
     * @param S3SETCO2TOL the S3SETCO2TOL to set
     */
    public void setS3SETCO2TOL(String S3SETCO2TOL) {
        this.S3SETCO2TOL = S3SETCO2TOL;
    }

    /**
     * @return the S3SETETHYL
     */
    public String getS3SETETHYL() {
        return S3SETETHYL;
    }

    /**
     * @param S3SETETHYL the S3SETETHYL to set
     */
    public void setS3SETETHYL(String S3SETETHYL) {
        this.S3SETETHYL = S3SETETHYL;
    }

    /**
     * @return the S3SETETHYLANZEIGE
     */
    public String getS3SETETHYLANZEIGE() {
        return S3SETETHYLANZEIGE;
    }

    /**
     * @param S3SETETHYLANZEIGE the S3SETETHYLANZEIGE to set
     */
    public void setS3SETETHYLANZEIGE(String S3SETETHYLANZEIGE) {
        this.S3SETETHYLANZEIGE = S3SETETHYLANZEIGE;
    }

    /**
     * @return the S3SETETHYLTOL
     */
    public String getS3SETETHYLTOL() {
        return S3SETETHYLTOL;
    }

    /**
     * @param S3SETETHYLTOL the S3SETETHYLTOL to set
     */
    public void setS3SETETHYLTOL(String S3SETETHYLTOL) {
        this.S3SETETHYLTOL = S3SETETHYLTOL;
    }

    /**
     * @return the S4DURATIONDAY
     */
    public String getS4DURATIONDAY() {
        return S4DURATIONDAY;
    }

    /**
     * @param S4DURATIONDAY the S4DURATIONDAY to set
     */
    public void setS4DURATIONDAY(String S4DURATIONDAY) {
        this.S4DURATIONDAY = S4DURATIONDAY;
    }

    /**
     * @return the S4DURATIONHOUR
     */
    public String getS4DURATIONHOUR() {
        return S4DURATIONHOUR;
    }

    /**
     * @param S4DURATIONHOUR the S4DURATIONHOUR to set
     */
    public void setS4DURATIONHOUR(String S4DURATIONHOUR) {
        this.S4DURATIONHOUR = S4DURATIONHOUR;
    }

    /**
     * @return the S4DURATIONMIN
     */
    public String getS4DURATIONMIN() {
        return S4DURATIONMIN;
    }

    /**
     * @param S4DURATIONMIN the S4DURATIONMIN to set
     */
    public void setS4DURATIONMIN(String S4DURATIONMIN) {
        this.S4DURATIONMIN = S4DURATIONMIN;
    }

    /**
     * @return the S4SETTEMP
     */
    public String getS4SETTEMP() {
        return S4SETTEMP;
    }

    /**
     * @param S4SETTEMP the S4SETTEMP to set
     */
    public void setS4SETTEMP(String S4SETTEMP) {
        this.S4SETTEMP = S4SETTEMP;
    }

    /**
     * @return the S4SETTEMPANZEIGE
     */
    public String getS4SETTEMPANZEIGE() {
        return S4SETTEMPANZEIGE;
    }

    /**
     * @param S4SETTEMPANZEIGE the S4SETTEMPANZEIGE to set
     */
    public void setS4SETTEMPANZEIGE(String S4SETTEMPANZEIGE) {
        this.S4SETTEMPANZEIGE = S4SETTEMPANZEIGE;
    }

    /**
     * @return the S4SETTEMPTOL
     */
    public String getS4SETTEMPTOL() {
        return S4SETTEMPTOL;
    }

    /**
     * @param S4SETTEMPTOL the S4SETTEMPTOL to set
     */
    public void setS4SETTEMPTOL(String S4SETTEMPTOL) {
        this.S4SETTEMPTOL = S4SETTEMPTOL;
    }

    /**
     * @return the S4SETHUM
     */
    public String getS4SETHUM() {
        return S4SETHUM;
    }

    /**
     * @param S4SETHUM the S4SETHUM to set
     */
    public void setS4SETHUM(String S4SETHUM) {
        this.S4SETHUM = S4SETHUM;
    }

    /**
     * @return the S4SETHUMANZEIGE
     */
    public String getS4SETHUMANZEIGE() {
        return S4SETHUMANZEIGE;
    }

    /**
     * @param S4SETHUMANZEIGE the S4SETHUMANZEIGE to set
     */
    public void setS4SETHUMANZEIGE(String S4SETHUMANZEIGE) {
        this.S4SETHUMANZEIGE = S4SETHUMANZEIGE;
    }

    /**
     * @return the S4SETHUMTOL
     */
    public String getS4SETHUMTOL() {
        return S4SETHUMTOL;
    }

    /**
     * @param S4SETHUMTOL the S4SETHUMTOL to set
     */
    public void setS4SETHUMTOL(String S4SETHUMTOL) {
        this.S4SETHUMTOL = S4SETHUMTOL;
    }

    /**
     * @return the S4SETCO2
     */
    public String getS4SETCO2() {
        return S4SETCO2;
    }

    /**
     * @param S4SETCO2 the S4SETCO2 to set
     */
    public void setS4SETCO2(String S4SETCO2) {
        this.S4SETCO2 = S4SETCO2;
    }

    /**
     * @return the S4SETCO2ANZEIGE
     */
    public String getS4SETCO2ANZEIGE() {
        return S4SETCO2ANZEIGE;
    }

    /**
     * @param S4SETCO2ANZEIGE the S4SETCO2ANZEIGE to set
     */
    public void setS4SETCO2ANZEIGE(String S4SETCO2ANZEIGE) {
        this.S4SETCO2ANZEIGE = S4SETCO2ANZEIGE;
    }

    /**
     * @return the S4SETCO2TOL
     */
    public String getS4SETCO2TOL() {
        return S4SETCO2TOL;
    }

    /**
     * @param S4SETCO2TOL the S4SETCO2TOL to set
     */
    public void setS4SETCO2TOL(String S4SETCO2TOL) {
        this.S4SETCO2TOL = S4SETCO2TOL;
    }

    /**
     * @return the S4SETETHYL
     */
    public String getS4SETETHYL() {
        return S4SETETHYL;
    }

    /**
     * @param S4SETETHYL the S4SETETHYL to set
     */
    public void setS4SETETHYL(String S4SETETHYL) {
        this.S4SETETHYL = S4SETETHYL;
    }

    /**
     * @return the S4SETETHYLANZEIGE
     */
    public String getS4SETETHYLANZEIGE() {
        return S4SETETHYLANZEIGE;
    }

    /**
     * @param S4SETETHYLANZEIGE the S4SETETHYLANZEIGE to set
     */
    public void setS4SETETHYLANZEIGE(String S4SETETHYLANZEIGE) {
        this.S4SETETHYLANZEIGE = S4SETETHYLANZEIGE;
    }

    /**
     * @return the S4SETETHYLTOL
     */
    public String getS4SETETHYLTOL() {
        return S4SETETHYLTOL;
    }

    /**
     * @param S4SETETHYLTOL the S4SETETHYLTOL to set
     */
    public void setS4SETETHYLTOL(String S4SETETHYLTOL) {
        this.S4SETETHYLTOL = S4SETETHYLTOL;
    }

    /**
     * @return the PROZESSBEGINN
     */
    public String getPROZESSBEGINN() {
        return PROZESSBEGINN;
    }

    /**
     * @param PROZESSBEGINN the PROZESSBEGINN to set
     */
    public void setPROZESSBEGINN(String PROZESSBEGINN) {
        this.PROZESSBEGINN = PROZESSBEGINN;
    }

    /**
     * @return the PROZESSEND
     */
    public String getPROZESSEND() {
        return PROZESSEND;
    }

    /**
     * @param PROZESSEND the PROZESSEND to set
     */
    public void setPROZESSEND(String PROZESSEND) {
        this.PROZESSEND = PROZESSEND;
    }

    /**
     * @return the S1DURATION
     */
    public String getS1DURATION() {
        return S1DURATION;
    }

    /**
     * @param S1DURATION the S1DURATION to set
     */
    public void setS1DURATION(String S1DURATION) {
        this.S1DURATION = S1DURATION;
    }

    /**
     * @return the S1STARTDATE
     */
    public String getS1STARTDATE() {
        return S1STARTDATE;
    }

    /**
     * @param S1STARTDATE the S1STARTDATE to set
     */
    public void setS1STARTDATE(String S1STARTDATE) {
        this.S1STARTDATE = S1STARTDATE;
    }

    /**
     * @return the S2DURATION
     */
    public String getS2DURATION() {
        return S2DURATION;
    }

    /**
     * @param S2DURATION the S2DURATION to set
     */
    public void setS2DURATION(String S2DURATION) {
        this.S2DURATION = S2DURATION;
    }

    /**
     * @return the S2STARTDATE
     */
    public String getS2STARTDATE() {
        return S2STARTDATE;
    }

    /**
     * @param S2STARTDATE the S2STARTDATE to set
     */
    public void setS2STARTDATE(String S2STARTDATE) {
        this.S2STARTDATE = S2STARTDATE;
    }

    /**
     * @return the S3DURATION
     */
    public String getS3DURATION() {
        return S3DURATION;
    }

    /**
     * @param S3DURATION the S3DURATION to set
     */
    public void setS3DURATION(String S3DURATION) {
        this.S3DURATION = S3DURATION;
    }

    /**
     * @return the S3STARTDATE
     */
    public String getS3STARTDATE() {
        return S3STARTDATE;
    }

    /**
     * @param S3STARTDATE the S3STARTDATE to set
     */
    public void setS3STARTDATE(String S3STARTDATE) {
        this.S3STARTDATE = S3STARTDATE;
    }

    /**
     * @return the S4DURATION
     */
    public String getS4DURATION() {
        return S4DURATION;
    }

    /**
     * @param S4DURATION the S4DURATION to set
     */
    public void setS4DURATION(String S4DURATION) {
        this.S4DURATION = S4DURATION;
    }

    /**
     * @return the S4STARTDATE
     */
    public String getS4STARTDATE() {
        return S4STARTDATE;
    }

    /**
     * @param S4STARTDATE the S4STARTDATE to set
     */
    public void setS4STARTDATE(String S4STARTDATE) {
        this.S4STARTDATE = S4STARTDATE;
    }

    /**
     * @return the aktuelleRoomValues
     */
    public String getAktuelleRoomValues() {
        return aktuelleRoomValues;
    }

    /**
     * @param aktuelleRoomValues the aktuelleRoomValues to set
     */
    public void setAktuelleRoomValues(String aktuelleRoomValues) {
        this.aktuelleRoomValues = aktuelleRoomValues;
    }

    /**
     * @return the tempIst
     */
    public String getTempIst() {
        return tempIst;
    }

    /**
     * @param tempIst the tempIst to set
     */
    public void setTempIst(String tempIst) {
        this.tempIst = tempIst;
    }

    /**
     * @return the humIst
     */
    public String getHumIst() {
        return humIst;
    }

    /**
     * @param humIst the humIst to set
     */
    public void setHumIst(String humIst) {
        this.humIst = humIst;
    }

    /**
     * @return the co2Ist
     */
    public String getCo2Ist() {
        return co2Ist;
    }

    /**
     * @param co2Ist the co2Ist to set
     */
    public void setCo2Ist(String co2Ist) {
        this.co2Ist = co2Ist;
    }

    /**
     * @return the ethylIst
     */
    public String getEthylIst() {
        return ethylIst;
    }

    /**
     * @param ethylIst the ethylIst to set
     */
    public void setEthylIst(String ethylIst) {
        this.ethylIst = ethylIst;
    }

    /**
     * @return the multiDamp
     */
    public String getMultiDamp() {
        return multiDamp;
    }

    /**
     * @param multiDamp the multiDamp to set
     */
    public void setMultiDamp(String multiDamp) {
        this.multiDamp = multiDamp;
    }

    /**
     * @return the multiTemp
     */
    public String getMultiTemp() {
        return multiTemp;
    }

    /**
     * @param multiTemp the multiTemp to set
     */
    public void setMultiTemp(String multiTemp) {
        this.multiTemp = multiTemp;
    }

    /**
     * @return the z1In
     */
    public String getZ1In() {
        return z1In;
    }

    /**
     * @param z1In the z1In to set
     */
    public void setZ1In(String z1In) {
        this.z1In = z1In;
    }

    /**
     * @return the z1Out
     */
    public String getZ1Out() {
        return z1Out;
    }

    /**
     * @param z1Out the z1Out to set
     */
    public void setZ1Out(String z1Out) {
        this.z1Out = z1Out;
    }

    /**
     * @return the z2In
     */
    public String getZ2In() {
        return z2In;
    }

    /**
     * @param z2In the z2In to set
     */
    public void setZ2In(String z2In) {
        this.z2In = z2In;
    }

    /**
     * @return the z2Out
     */
    public String getZ2Out() {
        return z2Out;
    }

    /**
     * @param z2Out the z2Out to set
     */
    public void setZ2Out(String z2Out) {
        this.z2Out = z2Out;
    }

    /**
     * @return the prT1
     */
    public String getPrT1() {
        return prT1;
    }

    /**
     * @param prT1 the prT1 to set
     */
    public void setPrT1(String prT1) {
        this.prT1 = prT1;
    }

    /**
     * @return the prT2
     */
    public String getPrT2() {
        return prT2;
    }

    /**
     * @param prT2 the prT2 to set
     */
    public void setPrT2(String prT2) {
        this.prT2 = prT2;
    }

    /**
     * @return the prT3
     */
    public String getPrT3() {
        return prT3;
    }

    /**
     * @param prT3 the prT3 to set
     */
    public void setPrT3(String prT3) {
        this.prT3 = prT3;
    }

    /**
     * @return the mainTemp1Wire
     */
    public String getMainTemp1Wire() {
        return mainTemp1Wire;
    }

    /**
     * @param mainTemp1Wire the mainTemp1Wire to set
     */
    public void setMainTemp1Wire(String mainTemp1Wire) {
        this.mainTemp1Wire = mainTemp1Wire;
    }

    /**
     * @return the multiDampIst
     */
    public float getMultiDampIst() {
        return multiDampIst;
    }

    /**
     * @param multiDampIst the multiDampIst to set
     */
    public void setMultiDampIst(float multiDampIst) {
        this.multiDampIst = multiDampIst;
    }

    /**
     * @return the multiTempIst
     */
    public float getMultiTempIst() {
        return multiTempIst;
    }

    /**
     * @param multiTempIst the multiTempIst to set
     */
    public void setMultiTempIst(float multiTempIst) {
        this.multiTempIst = multiTempIst;
    }

    /**
     * @return the z1InIst
     */
    public float getZ1InIst() {
        return z1InIst;
    }

    /**
     * @param z1InIst the z1InIst to set
     */
    public void setZ1InIst(float z1InIst) {
        this.z1InIst = z1InIst;
    }

    /**
     * @return the z1OutIst
     */
    public float getZ1OutIst() {
        return z1OutIst;
    }

    /**
     * @param z1OutIst the z1OutIst to set
     */
    public void setZ1OutIst(float z1OutIst) {
        this.z1OutIst = z1OutIst;
    }

    /**
     * @return the z2InIst
     */
    public float getZ2InIst() {
        return z2InIst;
    }

    /**
     * @param z2InIst the z2InIst to set
     */
    public void setZ2InIst(float z2InIst) {
        this.z2InIst = z2InIst;
    }

    /**
     * @return the z2OutIst
     */
    public float getZ2OutIst() {
        return z2OutIst;
    }

    /**
     * @param z2OutIst the z2OutIst to set
     */
    public void setZ2OutIst(float z2OutIst) {
        this.z2OutIst = z2OutIst;
    }

    /**
     * @return the prT1Ist
     */
    public float getPrT1Ist() {
        return prT1Ist;
    }

    /**
     * @param prT1Ist the prT1Ist to set
     */
    public void setPrT1Ist(float prT1Ist) {
        this.prT1Ist = prT1Ist;
    }

    /**
     * @return the prT2Ist
     */
    public float getPrT2Ist() {
        return prT2Ist;
    }

    /**
     * @param prT2Ist the prT2Ist to set
     */
    public void setPrT2Ist(float prT2Ist) {
        this.prT2Ist = prT2Ist;
    }

    /**
     * @return the prT3Ist
     */
    public float getPrT3Ist() {
        return prT3Ist;
    }

    /**
     * @param prT3Ist the prT3Ist to set
     */
    public void setPrT3Ist(float prT3Ist) {
        this.prT3Ist = prT3Ist;
    }

    /**
     * @return the mainTemp1WireIst
     */
    public float getMainTemp1WireIst() {
        return mainTemp1WireIst;
    }

    /**
     * @param mainTemp1WireIst the mainTemp1WireIst to set
     */
    public void setMainTemp1WireIst(float mainTemp1WireIst) {
        this.mainTemp1WireIst = mainTemp1WireIst;
    }
}
