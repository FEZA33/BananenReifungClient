/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientSeiteNeu;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;  
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author alisi
 */
public final class GrundDaten {

    private String datenPirPath;
    private String sollDatenPathFileName;
    private String istDatenPathFileName;
    private String parametersDatenPathFileName;
    private SetupMainFrame smf;
    private String grundPath;
    private String datenPath;

    private String pathRoom1;
    private String pathRoom2;
    private String pathRoom3;
    private String pathRoom4;
    private String pathRoom5;
    private String pathRoom6;
    private String pathRoom7;
    private String pathRoom8;

    private String aktiveRoomName = "ROOM1";
    private String aktiveRoomPath;

    private String os = System.getProperty("os.name").toLowerCase();
    SplitKonfiguration sc;

    public GrundDaten(SetupMainFrame smf, SplitKonfiguration sc) {
        this.smf = smf;
        this.sc = sc;
        //smf = new SetupMainFrame();
        //  smf.setVisible(true);
        //  readPaths();
        //  checkPaths(this.getGrundPath()+"\\src"+"\\DATEN");
        grundPath = setGrundPath();
        //       System.out.println("GrundPath --------   " + this.getGrundPath());
        if (getOs().contains("win")) {
            this.setDatenPath(erzeugeDir(this.getGrundPath() +  "\\DATEN"));
        }
        if (getOs().contains("linux")) {
            this.setDatenPath(erzeugeDir(this.getGrundPath() +  "/DATEN"));
        }
        
//         if (getOs().contains("win")) {
//            this.setDatenPath(erzeugeDir(this.getGrundPath() + "\\src" + "\\DATEN"));
//        }
//        if (getOs().contains("linux")) {
//            this.setDatenPath(erzeugeDir(this.getGrundPath() + "/src" + "/DATEN"));
//        }
        
        
        //      System.out.println("DatenPath --------1   " + this.getDatenPath());
        //    this.setAktiveRoomPath(ativeRoomPathSetzen("ROOM1"));
        // ativeRoomPathSetzen("ROOM1");
        if (getOs().contains("win")) {

            this.setPathRoom1(erzeugeDir(this.getDatenPath() + "\\Room1"));
            this.setPathRoom2(erzeugeDir(this.getDatenPath() + "\\Room2"));
            this.setPathRoom3(erzeugeDir(this.getDatenPath() + "\\Room3"));
            this.setPathRoom4(erzeugeDir(this.getDatenPath() + "\\Room4"));
            this.setPathRoom5(erzeugeDir(this.getDatenPath() + "\\Room5"));
            this.setPathRoom6(erzeugeDir(this.getDatenPath() + "\\Room6"));
            this.setPathRoom7(erzeugeDir(this.getDatenPath() + "\\Room7"));
            this.setPathRoom8(erzeugeDir(this.getDatenPath() + "\\Room8"));

            //   System.out.println("PATH Room 1  " + this.getPathRoom1());
            erzeugeWerteTabelle(this.getPathRoom1() + "\\parameterListeRoom1.txt", "Room1");
            erzeugeWerteTabelle(this.getPathRoom2() + "\\parameterListeRoom2.txt", "Room2");
            erzeugeWerteTabelle(this.getPathRoom3() + "\\parameterListeRoom3.txt", "Room3");
            erzeugeWerteTabelle(this.getPathRoom4() + "\\parameterListeRoom4.txt", "Room4");
            erzeugeWerteTabelle(this.getPathRoom5() + "\\parameterListeRoom5.txt", "Room5");
            erzeugeWerteTabelle(this.getPathRoom6() + "\\parameterListeRoom6.txt", "Room6");
            erzeugeWerteTabelle(this.getPathRoom7() + "\\parameterListeRoom7.txt", "Room7");
            erzeugeWerteTabelle(this.getPathRoom8() + "\\parameterListeRoom8.txt", "Room8");
        }
        if (getOs().contains("linux")) {

            this.setPathRoom1(erzeugeDir(this.getDatenPath() + "/Room1"));
            this.setPathRoom2(erzeugeDir(this.getDatenPath() + "/Room2"));
            this.setPathRoom3(erzeugeDir(this.getDatenPath() + "/Room3"));
            this.setPathRoom4(erzeugeDir(this.getDatenPath() + "/Room4"));
            this.setPathRoom5(erzeugeDir(this.getDatenPath() + "/Room5"));
            this.setPathRoom6(erzeugeDir(this.getDatenPath() + "/Room6"));
            this.setPathRoom7(erzeugeDir(this.getDatenPath() + "/Room7"));
            this.setPathRoom8(erzeugeDir(this.getDatenPath() + "/Room8"));

            //   System.out.println("PATH Room 1  " + this.getPathRoom1());
            erzeugeWerteTabelle(this.getPathRoom1() + "/parameterListeRoom1.txt", "Room1");
            erzeugeWerteTabelle(this.getPathRoom2() + "/parameterListeRoom2.txt", "Room2");
            erzeugeWerteTabelle(this.getPathRoom3() + "/parameterListeRoom3.txt", "Room3");
            erzeugeWerteTabelle(this.getPathRoom4() + "/parameterListeRoom4.txt", "Room4");
            erzeugeWerteTabelle(this.getPathRoom5() + "/parameterListeRoom5.txt", "Room5");
            erzeugeWerteTabelle(this.getPathRoom6() + "/parameterListeRoom6.txt", "Room6");
            erzeugeWerteTabelle(this.getPathRoom7() + "/parameterListeRoom7.txt", "Room7");
            erzeugeWerteTabelle(this.getPathRoom8() + "/parameterListeRoom8.txt", "Room8");
        }

        smf.getjMenuItemÖffnen().addActionListener(e -> loadFromFile());
           smf.getjButton1().addActionListener(e -> setText());
        smf.getjMenuItemTextLöschen().addActionListener(e -> cancel());
        smf.getjMenuItemSpeichern().addActionListener(e -> saveToFile());
        smf.getjMenuItemDefault().addActionListener(e -> loadFromFileDefault());
        // smf.getjMenuItemSetPathParameter().addActionListener(e -> savePathParameters());
        smf.getjMenuItemSetPathParameter().addActionListener(e -> getDirPathUndFileName());
        smf.getjMenuItemSetSollDatenPath().addActionListener(e -> getDirPath());
    }

    private void setText(){
        System.out.println("test");
    }
    public void aktiveRoomPathSetzen(String roomName) {

        System.out.println("AKTIV ROOM NAME     " + roomName);
        String pathPath = null;
        if (getOs().contains("win")) {

            switch (roomName) {
                case "Room1":
                    pathPath = erzeugeDir(this.getDatenPath() + "\\Room1");
                    this.setAktiveRoomName("Room1");
                    sc.getRoomName().setBackground(Color.RED);
                    sc.getjPanel32().setBackground(Color.red);

                    break;
                case "Room2":
                    pathPath = erzeugeDir(this.getDatenPath() + "\\Room2");
                    this.setAktiveRoomName("Room2");
                    sc.getRoomName().setBackground(Color.BLUE);
                    sc.getjPanel32().setBackground(Color.BLUE);
                    break;
                case "Room3":
                    pathPath = erzeugeDir(this.getDatenPath() + "\\Room3");
                    this.setAktiveRoomName("Room3");
                    sc.getRoomName().setBackground(Color.CYAN);
                    sc.getjPanel32().setBackground(Color.CYAN);
                    break;
                case "Room4":
                    pathPath = erzeugeDir(this.getDatenPath() + "\\Room4");
                    this.setAktiveRoomName("Room4");
                    sc.getRoomName().setBackground(Color.PINK);
                    sc.getjPanel32().setBackground(Color.PINK);
                    break;
                case "Room5":
                    pathPath = erzeugeDir(this.getDatenPath() + "\\Room5");
                    this.setAktiveRoomName("Room5");
                    sc.getRoomName().setBackground(Color.MAGENTA);
                    sc.getjPanel32().setBackground(Color.MAGENTA);
                    break;
                case "Room6":
                    pathPath = erzeugeDir(this.getDatenPath() + "\\Room6");
                    this.setAktiveRoomName("Room6");
                    sc.getRoomName().setBackground(Color.GREEN);
                    sc.getjPanel32().setBackground(Color.GREEN);
                    break;
                case "Room7":
                    pathPath = erzeugeDir(this.getDatenPath() + "\\Room7");
                    this.setAktiveRoomName("Room7");
                    sc.getRoomName().setBackground(Color.YELLOW);
                    sc.getjPanel32().setBackground(Color.YELLOW);
                    break;
                case "Room8":
                    // System.out.println("Room NUMMER SINAN  " +erzeugeDir(this.getDatenPath() + "\\Room8"));
                    pathPath = erzeugeDir(this.getDatenPath() + "\\Room8");
                    this.setAktiveRoomName("Room8");
                    sc.getRoomName().setBackground(Color.LIGHT_GRAY);
                    sc.getjPanel32().setBackground(Color.LIGHT_GRAY);
                    break;
            }
        }
        if (getOs().contains("linux")) {

            switch (roomName) {
                case "Room1":
                    pathPath = erzeugeDir(this.getDatenPath() + "/Room1");
                    this.setAktiveRoomName("Room1");
                    sc.getRoomName().setBackground(Color.RED);
                    sc.getjPanel32().setBackground(Color.red);
                    break;
                case "Room2":
                    pathPath = erzeugeDir(this.getDatenPath() + "/Room2");
                    this.setAktiveRoomName("Room2");
                    sc.getRoomName().setBackground(Color.BLUE);
                    sc.getjPanel32().setBackground(Color.BLUE);
                    break;
                case "Room3":
                    pathPath = erzeugeDir(this.getDatenPath() + "/Room3");
                    this.setAktiveRoomName("Room3");
                    sc.getRoomName().setBackground(Color.CYAN);
                    sc.getjPanel32().setBackground(Color.CYAN);
                    break;
                case "Room4":
                    pathPath = erzeugeDir(this.getDatenPath() + "/Room4");
                    this.setAktiveRoomName("Room4");
                    sc.getRoomName().setBackground(Color.PINK);
                    sc.getjPanel32().setBackground(Color.PINK);
                    break;
                case "Room5":
                    pathPath = erzeugeDir(this.getDatenPath() + "/Room5");
                    this.setAktiveRoomName("Room5");
                    sc.getRoomName().setBackground(Color.MAGENTA);
                    sc.getjPanel32().setBackground(Color.MAGENTA);
                    break;
                case "Room6":
                    pathPath = erzeugeDir(this.getDatenPath() + "/Room6");
                    this.setAktiveRoomName("Room6");
                    sc.getRoomName().setBackground(Color.GREEN);
                    sc.getjPanel32().setBackground(Color.GREEN);
                    break;
                case "Room7":
                    pathPath = erzeugeDir(this.getDatenPath() + "/Room7");
                    this.setAktiveRoomName("Room7");
                    sc.getRoomName().setBackground(Color.YELLOW);
                    sc.getjPanel32().setBackground(Color.YELLOW);
                    break;
                case "Room8":
                    // System.out.println("Room NUMMER SINAN  " +erzeugeDir(this.getDatenPath() + "\\Room8"));
                    pathPath = erzeugeDir(this.getDatenPath() + "/Room8");
                    this.setAktiveRoomName("Room8");
                    sc.getRoomName().setBackground(Color.LIGHT_GRAY);
                    sc.getjPanel32().setBackground(Color.LIGHT_GRAY);
                    break;
            }
        }

        this.setAktiveRoomPath(pathPath);
        System.out.println(" AktiveRoomName und Path =   " +this.getAktiveRoomName() +  this.getAktiveRoomPath());
    }

    public String erzeugeDir(String dirName) {
        //    System.out.println("Directory no   " + name);

        // Creating new directory in Java, if it doesn't exists
        File directory = new File(dirName);
        if (directory.exists()) {
            System.out.println("Directory already exists ...");

        } else {
            System.out.println("Directory not exists, creating now");

            //  success = directory.mkdir();
            if (directory.mkdir()) {
                System.out.printf("Successfully created new directory : %s%n", dirName);
            } else {
                System.out.printf("Failed to create new directory: %s%n", dirName);
                dirName = null;
            }
        }
        return dirName;
    }

    public void erzeugeWerteTabelle(String fileName, String roomName) {
        //     System.out.println(   " + fileName);
        Properties prop = new Properties();
        File file = new File(fileName);

        if (!file.exists()) {
            try ( FileOutputStream outputStream = new FileOutputStream(fileName)) {

                prop.setProperty("ROOMNAME", roomName);
                prop.setProperty("PRODUKTSELECTION", "Apfel");
                prop.setProperty("USERSELECTION", "Cem");
                prop.setProperty("PRODUKTNRSELECTION", "1111");
                prop.setProperty("SPLITMENGE", "4");
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
                prop.setProperty("IPADRESS", "192.168.2.33");
                prop.setProperty("PORTNR", "9990");
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
                e.printStackTrace();
            }
          }
    }

    public void grundDatenErzeugen(String grundPath) {
        // 1 GrundPath festlegen 
        String text = parameterListeErzeugen();
        this.saveData(grundPath, text);

    }

    /**
     * @param grundPath the grundPath to set
     */
    private String setGrundPath() {

        String zwischenPath = null;
        if (getOs().contains("win")) {
            zwischenPath = System.getProperty("user.dir");
            System.out.println("PATH ANA WIN    " + zwischenPath);
        }
        if (getOs().contains("linux")) {
            zwischenPath = System.getProperty("user.dir");
            System.out.println("PATH ANA LINUX   " + zwischenPath);
        }
        return zwischenPath;
    }

    public void testSchreiben(String fileName) {
        String paths = this.getGrundPath();
        try ( OutputStream output = new FileOutputStream(fileName)) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("SOLLDATENPATH", paths + "\\ROOM1" + "\\solldaten.txt");
            prop.setProperty("ISTDATENPATH", paths + "\\ROOM1" + "\\istdaten.txt");
            prop.setProperty("PARAMETERSPATH", paths + "\\ROOM1" + "\\parameters.txt");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void testLesen(String fileName) {

        try ( InputStream input = new FileInputStream(fileName)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            getSmf().getjTextFieldSollDaten().setText(prop.getProperty("SOLLDATENPATH"));
            getSmf().getjTextFieldIstDaten().setText(prop.getProperty("ISTDATENPATH"));
            getSmf().getjTextFieldParameters().setText(prop.getProperty("PARAMETERSPATH"));
            this.setIstDatenPathFileName(prop.getProperty("ISTDATENPATH"));
            this.setSollDatenPathFileName(prop.getProperty("SOLLDATENPATH"));
            this.setParametersDatenPathFileName(prop.getProperty("PARAMETERSPATH"));
            System.out.println(prop.getProperty("SOLLDATENPATH"));
            System.out.println(prop.getProperty("ISTDATENPATH"));
            System.out.println(prop.getProperty("PARAMETERSPATH"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void readPaths() {

        File f = new File("D:\\Pcreifungkonfiguration\\DefaultData.txt");
        String filepath = f.getPath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String s1 = "", s2 = "";
            //while ((s1 = br.readLine()) != null) {
            //s2 += s1 + "\n";
            getSmf().getjTextFieldParameters().setText(br.readLine());
            getSmf().getjTextFieldIstDaten().setText(br.readLine());
            getSmf().getjTextFieldSollDaten().setText(br.readLine());

            // smf.getjTextArea2().setText(s2);
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getDirPath() {

        // smf.getjTextArea2().setText(null);
        File f = new File("D:\\Pcreifungkonfiguration\\");
        JFileChooser fileChooser = new JFileChooser(f, FileSystemView.getFileSystemView());
        // JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showSaveDialog(getSmf().getjMenuItemSetSollDatenPath());
        System.out.println("BU TEXT OKUNDU xxxxxxxxxxxxxxxxxxxxx ");
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getCurrentDirectory();
//            if (file == null) {
//                return;
//            }
//            if (!file.getName().toLowerCase().endsWith(".txt")) {
//                file = new File(file.getParentFile(), file.getName());
//                System.out.println(file.getParentFile() + "\\" + file.getName());
//            }
//            try {
//                // smf.getjTextArea2().append(file.getParentFile() + "\\" + file.getName() + "\n");
//
//                //smf.getjTextArea2().write(new OutputStreamWriter(new FileOutputStream(file),
//                //        "utf-8"));
//                saveData(file.getParentFile() + "\\" + file.getName(), smf.getjTextArea2().getText());
//                // smf.getjTextArea2()
//                System.out.println("BU TEXT OKUNDU  " + smf.getjTextArea2().getText() + file.getParentFile() + "\\" + file.getName());
//                //Desktop.getDesktop().open(file);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("BU TEXT OKUNDU  " + fileChooser.getCurrentDirectory().toString());
        getSmf().getjTextFieldSollDaten().setText(fileChooser.getCurrentDirectory().toString());
        this.setDatenPirPath(fileChooser.getCurrentDirectory().toString());
        return fileChooser.getCurrentDirectory().toString();
    }

    public String getDirPathUndFileName() {
        // smf.getjTextArea2().setText(null);
        File f = new File("D:\\Pcreifungkonfiguration\\");
        JFileChooser fileChooser = new JFileChooser(f, FileSystemView.getFileSystemView());
        // JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showSaveDialog(getSmf().getjMenuItemSetPathParameter());
        System.out.println("BU TEXT OKUNDU xxxxxxxxxxxxxxxxxxxxx ");
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
//            if (file == null) {
//                return;
//            }
//            if (!file.getName().toLowerCase().endsWith(".txt")) {
//                file = new File(file.getParentFile(), file.getName());
//                System.out.println(file.getParentFile() + "\\" + file.getName());
//            }
//            try {
//                // smf.getjTextArea2().append(file.getParentFile() + "\\" + file.getName() + "\n");
//
//                //smf.getjTextArea2().write(new OutputStreamWriter(new FileOutputStream(file),
//                //        "utf-8"));
//                saveData(file.getParentFile() + "\\" + file.getName(), smf.getjTextArea2().getText());
//                // smf.getjTextArea2()
//                System.out.println("BU TEXT OKUNDU  " + smf.getjTextArea2().getText() + file.getParentFile() + "\\" + file.getName());
//                //Desktop.getDesktop().open(file);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("BU TEXT OKUNDU  " + fileChooser.getSelectedFile().toString());
        getSmf().getjTextFieldParameters().setText(fileChooser.getSelectedFile().toString());
        return fileChooser.getSelectedFile().toString();
    }

    /**
     *
     */
    public void savePathParameters() {

        // smf.getjTextArea2().setText(null);
        File f = new File("D:\\Pcreifungkonfiguration\\");
        JFileChooser fileChooser = new JFileChooser(f, FileSystemView.getFileSystemView());
        // JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showSaveDialog(getSmf().getjMenuItemSetPathParameter());
        System.out.println("BU TEXT OKUNDU xxxxxxxxxxxxxxxxxxxxx ");
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName());
                System.out.println(file.getParentFile() + "\\" + file.getName());
            }
            try {
                // smf.getjTextArea2().append(file.getParentFile() + "\\" + file.getName() + "\n");

                getSmf().getjTextArea2().write(new OutputStreamWriter(new FileOutputStream(file),
                        "utf-8"));
                getSmf().getjTextFieldParameters().setText(file.getParentFile() + "\\" + file.getName());
//                saveData(file.getParentFile() + "\\" + file.getName(),smf.getjTextArea2().getText(0, 100));
//                // smf.getjTextArea2()
//                System.out.println( "BU TEXT OKUNDU  "+smf.getjTextArea2().getText(0, 100)+file.getParentFile() + "\\" + file.getName());
                //Desktop.getDesktop().open(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void loadFromFileDefault() {
        System.out.println("sdasd<cccccccccccccccccttttt");
        //  smf.getjTextArea2().setText(null);
//        File f = new File("D:\\Pcreifungkonfiguration\\");
//        JFileChooser fileChooser = new JFileChooser(f, FileSystemView.getFileSystemView());
//
//        int retval = fileChooser.showSaveDialog(smf.getjMenuDeafulf());
//        if (retval == JFileChooser.APPROVE_OPTION) {
//            File file = fileChooser.getSelectedFile();
//            if (file == null) {
//                return;
//            }
//            if (!file.getName().toLowerCase().endsWith(".txt")) {
//                file = new File(file.getParentFile(), file.getName() + ".txt");
//            }
        try {
            //  smf.getjTextArea2().read(new BufferedReader(new FileReader(fileChooser.getSelectedFile())), null);
            StringTokenizer st = new StringTokenizer(parameterListeErzeugen(), "*");
            while (st.hasMoreTokens()) {
                getSmf().getjTextArea2().append(st.nextToken() + "\n");

            }
            //    "utf-8"));
            //  smf.getjTextArea1().add(file);
            //  Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void loadFromFileDefault1() {

        System.out.println("giis");
        File f = new File("D:\\Pcreifungkonfiguration\\DefaultData.txt");
//        JFileChooser fc = new JFileChooser(f, FileSystemView.getFileSystemView());
//        //   JFileChooser fc = new JFileChooser();
//        int i;
//        i = fc.showOpenDialog(null);
//        if (i == JFileChooser.APPROVE_OPTION) {
//            f = fc.getSelectedFile();
        String filepath = f.getPath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String s1 = "", s2 = "";
            while ((s1 = br.readLine()) != null) {
                s2 += s1 + "\n";
            }
            getSmf().getjTextArea2().setText(s2);
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //   }

    protected void loadFromFile() {
        // smf.getjTextArea2().append("Hallo");
        System.out.println("giis");
        File f = new File("D:\\Pcreifungkonfiguration\\");
        JFileChooser fc = new JFileChooser(f, FileSystemView.getFileSystemView());
        //   JFileChooser fc = new JFileChooser();
        int i;
        i = fc.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            f = fc.getSelectedFile();
            String filepath = f.getPath();
            System.out.println("giis" + f.getPath());
            try {
                BufferedReader br = new BufferedReader(new FileReader(filepath));
                String s1 = "", s2 = "";
                while ((s1 = br.readLine()) != null) {
                    s2 += s1 + "\n";
                }
                System.out.println("giis  " + s2);
                getSmf().getjTextArea2().append(s2);
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //   }
    }

    protected void saveToFile() {

        // smf.getjTextArea2().setText(null);
        File f = new File("D:\\Pcreifungkonfiguration\\");
        JFileChooser fileChooser = new JFileChooser(f, FileSystemView.getFileSystemView());
        // JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showSaveDialog(getSmf().getjMenuItemSpeichern());
        System.out.println("BU TEXT OKUNDU xxxxxxxxxxxxxxxxxxxxx ");
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName());
                System.out.println(file.getParentFile() + "\\" + file.getName());
            }
            try {
                // smf.getjTextArea2().append(file.getParentFile() + "\\" + file.getName() + "\n");

                //smf.getjTextArea2().write(new OutputStreamWriter(new FileOutputStream(file),
                //        "utf-8"));
                saveData(file.getParentFile() + "\\" + file.getName(), getSmf().getjTextArea2().getText());
                // smf.getjTextArea2()
                System.out.println("BU TEXT OKUNDU  " + getSmf().getjTextArea2().getText() + file.getParentFile() + "\\" + file.getName());
                //Desktop.getDesktop().open(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveData(String fileName, String text) {
        try {
            BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName));
            String myString1 = getSmf().getjTextArea2().getText();

            System.out.println("My String   " + text);
            fileOut.write(text);
            System.getProperty("line.separator");

            fileOut.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void cancel() {
        System.out.println("sdasdttttt");
        getSmf().getjTextArea2().setText(null);//.re.removeAll();//.append("sdasdasd");

    }

    public String parameterListeErzeugen() {
        String text;
        text = "ROOMNAME"
                + "*" + "USERSELECTION"
                + "*" + "PRODUKTSELECTION"
                + "*" + "PRODUKTNRSELECTION"
                + "*" + "SPLITMENGE"
                + "*" + "ETHYLSETPUTTIME"
                + "*" + "DELAYTIMEETHYLTOMES"
                + "*" + "CIRCULATINGAIR"
                + "*" + "CIRCULATINAIRDEL"
                + "*" + "HEATERDELAY"
                + "*" + "COOLERDELAY"
                + "*" + "DAMPERDELAY"
                + "*" + "FRESHAIRDELAY"
                + "*" + "BEGINTIMEHOUR"
                + "*" + "BEGINTIMEMIN"
                + "*" + "IPADRESS"
                + "*" + "PORTNR"
                + "*" + "S1DURATIONDAY"
                + "*" + "S1DURATIONHOUR"
                + "*" + "S1DURATIONMIN"
                + "*" + "S1SETTEMP"
                + "*" + "S1SETTEMPTOL"
                + "*" + "S1SETHUM"
                + "*" + "S1SETHUMTOL"
                + "*" + "S1SETCO2"
                + "*" + "S1SETCO2TOL"
                + "*" + "S1SETETHYL"
                + "*" + "S1SETETHYLTOL"
                + "*" + "S2DURATIONDAY"
                + "*" + "S2DURATIONHOUR"
                + "*" + "S2DURATIONMIN"
                + "*" + "S2SETTEMP"
                + "*" + "S2SETTEMPTOL"
                + "*" + "S2SETHUM"
                + "*" + "S2SETHUMTOL"
                + "*" + "S2SETCO2"
                + "*" + "S2SETCO2TOL"
                + "*" + "S2SETETHYL"
                + "*" + "S2SETETHYLTOL"
                + "*" + "S3DURATIONDAY"
                + "*" + "S3DURATIONHOUR"
                + "*" + "S3DURATIONMIN"
                + "*" + "S3SETTEMP"
                + "*" + "S3SETTEMPTOL"
                + "*" + "S3SETHUM"
                + "*" + "S3SETHUMTOL"
                + "*" + "S3SETCO2"
                + "*" + "S3SETCO2TOL"
                + "*" + "S3SETETHYL"
                + "*" + "S3SETETHYLTOL"
                + "*" + "S4DURATIONDAY"
                + "*" + "S4DURATIONHOUR"
                + "*" + "S4DURATIONMIN"
                + "*" + "S4SETTEMP"
                + "*" + "S4SETTEMPTOL"
                + "*" + "S4SETHUM"
                + "*" + "S4SETHUMTOL"
                + "*" + "S4SETCO2"
                + "*" + "S4SETCO2TOL"
                + "*" + "S4SETETHYL"
                + "*" + "S4SETETHYLTOL"
                + "*" + "S1DURATION"
                + "*" + "S1STARTDATE"
                + "*" + "S2DURATION"
                + "*" + "S2STARTDATE"
                + "*" + "S3DURATION"
                + "*" + "S3STARTDATE"
                + "*" + "S4DURATION"
                + "*" + "S4STARTDATE"
                + "*" + "PROZESSBEGINN"
                + "*" + "PROZESSEND";
        System.out.println(text);
        return text;
    }

    /**
     * @param grundPath the grundPath to set
     */
    public void setGrundPath(String grundPath) {
        this.grundPath = grundPath;
    }

    /**
     * @return the datenPath
     */
    public String getDatenPath() {
        return datenPath;
    }

    /**
     * @param datenPath the datenPath to set
     */
    public void setDatenPath(String datenPath) {
        this.datenPath = datenPath;
    }

    /**
     * @return the pathRoom1
     */
    public String getPathRoom1() {
        return pathRoom1;
    }

    /**
     * @param pathRoom1 the pathRoom1 to set
     */
    public void setPathRoom1(String pathRoom1) {
        this.pathRoom1 = pathRoom1;
    }

    /**
     * @return the pathRoom2
     */
    public String getPathRoom2() {
        return pathRoom2;
    }

    /**
     * @param pathRoom2 the pathRoom2 to set
     */
    public void setPathRoom2(String pathRoom2) {
        this.pathRoom2 = pathRoom2;
    }

    /**
     * @return the pathRoom3
     */
    public String getPathRoom3() {
        return pathRoom3;
    }

    /**
     * @param pathRoom3 the pathRoom3 to set
     */
    public void setPathRoom3(String pathRoom3) {
        this.pathRoom3 = pathRoom3;
    }

    /**
     * @return the pathRoom4
     */
    public String getPathRoom4() {
        return pathRoom4;
    }

    /**
     * @param pathRoom4 the pathRoom4 to set
     */
    public void setPathRoom4(String pathRoom4) {
        this.pathRoom4 = pathRoom4;
    }

    /**
     * @return the pathRoom5
     */
    public String getPathRoom5() {
        return pathRoom5;
    }

    /**
     * @param pathRoom5 the pathRoom5 to set
     */
    public void setPathRoom5(String pathRoom5) {
        this.pathRoom5 = pathRoom5;
    }

    /**
     * @return the pathRoom6
     */
    public String getPathRoom6() {
        return pathRoom6;
    }

    /**
     * @param pathRoom6 the pathRoom6 to set
     */
    public void setPathRoom6(String pathRoom6) {
        this.pathRoom6 = pathRoom6;
    }

    /**
     * @return the pathRoom7
     */
    public String getPathRoom7() {
        return pathRoom7;
    }

    /**
     * @param pathRoom7 the pathRoom7 to set
     */
    public void setPathRoom7(String pathRoom7) {
        this.pathRoom7 = pathRoom7;
    }

    /**
     * @return the pathRoom8
     */
    public String getPathRoom8() {
        return pathRoom8;
    }

    /**
     * @param pathRoom8 the pathRoom8 to set
     */
    public void setPathRoom8(String pathRoom8) {
        this.pathRoom8 = pathRoom8;
    }

    /**
     * @return the datenPirPath
     */
    public String getDatenPirPath() {
        return datenPirPath;
    }

    /**
     * @param datenPirPath the datenPirPath to set
     */
    public void setDatenPirPath(String datenPirPath) {
        this.datenPirPath = datenPirPath;
    }

    /**
     * @return the sollDatenPathFileName
     */
    public String getSollDatenPathFileName() {
        return sollDatenPathFileName;
    }

    /**
     * @param sollDatenPathFileName the sollDatenPathFileName to set
     */
    public void setSollDatenPathFileName(String sollDatenPathFileName) {
        this.sollDatenPathFileName = sollDatenPathFileName;
    }

    /**
     * @return the istDatenPathFileName
     */
    public String getIstDatenPathFileName() {
        return istDatenPathFileName;
    }

    /**
     * @param istDatenPathFileName the istDatenPathFileName to set
     */
    public void setIstDatenPathFileName(String istDatenPathFileName) {
        this.istDatenPathFileName = istDatenPathFileName;
    }

    /**
     * @return the parametersDatenPathFileName
     */
    public String getParametersDatenPathFileName() {
        return parametersDatenPathFileName;
    }

    /**
     * @param parametersDatenPathFileName the parametersDatenPathFileName to set
     */
    public void setParametersDatenPathFileName(String parametersDatenPathFileName) {
        this.parametersDatenPathFileName = parametersDatenPathFileName;
    }

    /**
     * @return the smf
     */
    public SetupMainFrame getSmf() {
        return smf;
    }

    /**
     * @param smf the smf to set
     */
    public void setSmf(SetupMainFrame smf) {
        this.smf = smf;
    }

    /**
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * @return the grundPath
     */
    public String getGrundPath() {
        return grundPath;
    }

    /**
     * @return the aktiveRoomName
     */
    public String getAktiveRoomName() {
        return aktiveRoomName;
    }

    /**
     * @param aktiveRoomName the aktiveRoomName to set
     */
    public void setAktiveRoomName(String aktiveRoomName) {
        this.aktiveRoomName = aktiveRoomName;
    }

    /**
     * @return the aktiveRoomPath
     */
    public String getAktiveRoomPath() {
        return aktiveRoomPath;
    }

    /**
     * @param aktiveRoomPath the aktiveRoomPath to set
     */
    public void setAktiveRoomPath(String aktiveRoomPath) {
        this.aktiveRoomPath = aktiveRoomPath;
    }

    /**
     * @return the grundPath
     */
}
