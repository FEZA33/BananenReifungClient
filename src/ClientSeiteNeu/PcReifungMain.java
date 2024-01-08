package ClientSeiteNeu;

import CHART.Main1;

public class PcReifungMain {

    public static void main(String args[]) {
//        RoomDisplay rm new RoomDisplay();
//    
//        rm.setVisible(true);
        System.out.println("TestMain");
//        RoomDisplay rm = new RoomDisplay();
//        rm.setVisible(true);gg
        ChartMenu cm = new ChartMenu();  
        cm.setSize(1030, 700);
        cm.setVisible(true);
        SplitKonfiguration sc = new SplitKonfiguration();
        //sc.setVisible(true);
        Countdown cd = new Countdown(sc, cm);
        SetupMainFrame smf = new SetupMainFrame();
        GrundDaten gd = new GrundDaten(smf, sc);
        
        RoomParameters roomPar = new RoomParameters();
        Rooms room = new Rooms(sc, gd, cm, cd,roomPar);
//  
        TCPClientMainMain tcp = new TCPClientMainMain(room);
        Thread t1 = new Thread(tcp);
        t1.start();//.run();
//

        RoomMenuListener rml = new RoomMenuListener(cm, sc, gd, room, tcp);
        Main1 main1 = new Main1(tcp);
        // Main1 main1 = new Main1(tcp);

        cm.getjPanel1().add(main1);

        //  rm.getjPanel1().add(main1);
        main1.setVisible(true);
        Thread t2 = new Thread(main1);
        t2.start();
//
//        //    Sender sender = new Sender();
////        SenderEmpfanger se = new SenderEmpfanger();
        //Thread t3 = new Thread();
        SystemUhr scc = new SystemUhr(sc, cm);
        scc.start();  
//        Thread t3 = new Thread(scc);
//        t3.start();
//  

    }
}


