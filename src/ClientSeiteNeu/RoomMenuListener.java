/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSeiteNeu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
/**
 *
 * @author sinan
 */
public class RoomMenuListener {

 
    /**
     * @param tcp the tcp to set
     */
    public void setTcp(TCPClientMainMain tcp) {
        this.tcp = tcp;
    }

    private ChartMenu cm;
    private SplitKonfiguration sc;
    private GrundDaten gd;
    private Rooms room;
    //  Rooms rooms;
    private int counter1 = 0;
    private TCPClientMainMain tcp;
    
    //(final RoomDisplay rm, final SplitKonfiguration sc, GrundDaten gd, Rooms room, TCPClientMainMain tcp)

    public RoomMenuListener(final ChartMenu cm, final SplitKonfiguration sc, GrundDaten gd, Rooms room, TCPClientMainMain tcp) {
        this.cm = cm;
        //this.rooms = rooms;
        this.sc = sc;
        this.gd = gd;
        this.room = room;
        this.tcp = tcp;

        // saveDataButton
//        JButton confLoadButton = sc.getLoadConfButton();
//        confLoadButton.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent e) {
//
//                //   Parameters parameters = new Parameters();
//                rooms.readDataVonDateiIndieMenu(sc,rooms.getPathOfParameters()+"\\"+"PROZESSDATEN.dtt");
//                room.getDuration(sc);
//
//                //    parameters.setVisible(true);
//                //  simframe.setVisible(true);
//
//            }
//        });
//
//        JButton confSaveButton = sc.getSaveConfButton();
//        confSaveButton.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent e) {
//                room.writeDataInTheMemory(sc);
//                room.writeDataInTheMemoryMitFile(sc);
//         //       room.readDataVonDateiIndieMenu(sc);
//                room.getDuration(sc);
//                System.out.println(" PROZESSDATEN  ");
//                room.setRoomParameter(sc, "room1");
//                room.setSplitData1();
//            }
//        });
        sc.getSaveConfButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel confMenuSichtbar = cm.getjPanel5();
        confMenuSichtbar.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                setCounter1(getCounter1() + 1);
                System.out.println(getCounter1());
                if (getCounter1() == 4) {
                    setCounter1(0);
                    System.out.println("MAUS CLICKED & MAL");

                    //     Parameters parameters = new Parameters();
                    sc.setVisible(true);

                    //    parameters.setVisible(true);
                    //  simframe.setVisible(true);
                }

            }
        });
        JPanel grundDatenMenuSichtbar = cm.getjPanel6();
        confMenuSichtbar.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                setCounter1(getCounter1() + 1);
                System.out.println(getCounter1());
                if (getCounter1() == 4) {
                    setCounter1(0);
                    System.out.println("MAUS CLICKED & MAL");

                    //     Parameters parameters = new Parameters();
                    gd.getSmf().setVisible(true);

                    //    parameters.setVisible(true);
                    //  simframe.setVisible(true);
                }

            }
        });
        JPanel splitMenuSichtbar = cm.getjPanel10();
        splitMenuSichtbar.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                setCounter1(getCounter1() + 1);
                System.out.println(getCounter1());
                if (getCounter1() == 4) {
                    setCounter1(0);
                    System.out.println("MAUS CLICKED & MAL");

                    //   Parameters parameters = new Parameters();
                    sc.setVisible(true);

                    //    parameters.setVisible(true);
                    //  simframe.setVisible(true);
                }

            }
        });

        sc.getSaveConfButton().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                //   parametersListe = dv.parameterListeErzeugen();
                //      System.out.println(" PATHHHHHHHHHHHHHHHHHH   " + room.getGd().getDatenPirPath());
                //          room.menuSave(room.parameterListeErzeugen(), gd.getAktiveRoomPath() + "\\ParameterListe" + gd.getAktiveRoomName() + ".txt");
                System.out.println("---------------------------   " + sc.getHauptCalendar().getTime());

                //   System.out.println("CLASSSSSSSSSSSSSSSS  ");
                getSc().setHauptCalendar(getSc().getjDateChooser1().getCalendar());
                Date date = getSc().getHauptCalendar().getTime();
//                    System.out.println("CLASSSSSSSSSSSSSSSS       " + date.toString() + "   " + (e.getNewValue()));
//                    checkDatum(getSc().getHauptCalendar());
                room.menuSave();
                room.getDuration();
                room.updateProzessDaten();
                room.getProzessDatenZurLaufzeit();
                tcp.setNeueDataSenden(false);//.setAnkommendeData(false);
                // tcp.setIsProzessdatenVorhanden(true);
                //   tcp.

                // dv.menuParameterSetzen();
            }
        }
        );

        sc.getLoadConfButton().addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                //   parametersListe = dv.parameterListeErzeugen();
                //room.loadMenu(room.parameterListeErzeugen(),gd.getAktiveRoomPath()+"\\ParameterListe"+gd.getAktiveRoomName()+".txt");
                System.out.println(" PATHHHHHHHHHHHHHHHHHH   " + gd.getAktiveRoomPath() + "\\ParameterListe" + gd.getAktiveRoomName() + ".txt");
                //room.loadMenu(gd.getAktiveRoomPath() + "\\ParameterListe" + gd.getAktiveRoomName() + ".txt");
                room.upDateMenuDaten();
                room.updateProzessDaten();
                tcp.setNeueDataSenden(false);//.setAnkommendeData(false);
                room.getDuration();
                //  dv.menuLesenInDieLaufzeit();//.menuUpdate();
            }
        }
        );

        sc.getRoomName().addItemListener((ItemEvent e) -> {
            Object item = e.getItem();
            if (e.getStateChange() == ItemEvent.SELECTED) {
                //gd.aktiveRoomPathSetzen((String) item);

                //       gd.aktiveRoomPathSetzen((String) item);
                //  this.setAktiveRoomPath(pathPath);
                gd.aktiveRoomPathSetzen((String) item);
                // System.out.println("zzzzzz   zzz z  z  "+item + gd.getAktiveRoomPath()+"\\ParameterListe"+gd.getAktiveRoomName()+".txt");
                //room.loadMenu(room.getParametersListe(), gd.getAktiveRoomPath()+"\\ParameterListe"+gd.getAktiveRoomName()+".txt");
                //    gd.aktiveRoomPathSetzen("Room1");
                System.out.println(" PATHHHHHHHHHHHHHHHHHH   " + gd.getAktiveRoomPath() + "\\ParameterListe" + gd.getAktiveRoomName() + ".txt");
                room.upDateMenuDaten();
                room.updateProzessDaten();
                //cp.setNeueDataSenden(false);//.setAnkommendeData(false);
                room.getDuration();
                // tcp.setNeueDataSenden(false);//.setAnkommendeData(false);
                // Item has been selected
                System.out.println(item + "  has  been  selected");
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                // Item has been deselected
                System.out.println(item + "  has  been  deselected");
            }
        });
        sc.getjDateChooser1().getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                if ("date".equals(e.getPropertyName())) {
//                System.out.println(e.getPropertyName()
//                    + ": " + (Date) e.getNewValue());

                    //   SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                    // Calendar calendar = Calendar.getInstance();
//                    
//                    String dateInString = "22-01-2015 10:20:56";
//                    Date date = sdf.parse(dateInString);
//
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.setTime(date);
                    System.out.println("CLASSSSSSSSSSSSSSSS  ");
                    getSc().setHauptCalendar(getSc().getjDateChooser1().getCalendar());
                    Date date = getSc().getHauptCalendar().getTime();
                    System.out.println("CLASSSSSSSSSSSSSSSS       " + date.toString() + "   " + (e.getNewValue()));
                    checkDatum(getSc().getHauptCalendar());

////                      getSc().getjDateChooser1().setCalendar(prozessAnfang);
////                    Date date = new Date();
////                    
////                    date.setTime(System.currentTimeMillis());
////                    getSc().getjDateChooser1().setDate(date);
////                    getSc().getjDateChooser1().setBackground(Color.red);
//                    System.out.println("CLASSSSSSSSSSSSSSSS       " + (e.getNewValue()));
//
//                    //   room.getSelectedDate().getDateEditor().getDateFormatString();
//                    //Calendar cal = room.getSelectedDate().getPropertyChangeListeners()..getPropertyChangeListeners()..getCalendar();//.setSelectedDate(e.getNewValue());
//                    sc.getDateProzessBeginn().setText(sdf.format(e.getNewValue()));
//                    sc.getTimeProzessBeginn().setText(sdf1.format(e.getNewValue()));
// 
//                    room.setTimeBegin(sc.getDateProzessBeginn().getText());//sdf1.format(e.getNewValue()));
//                    room.setDateBegin(sc.getTimeProzessBeginn().getText());//sdf.format(e.getNewValue()));
//
//                    //    room.loadMenu(room.getParametersListe(), gd.getAktiveRoomPath()+"\\ParameterListe"+gd.getAktiveRoomName()+".txt");
//                    //    System.out.println(" PATHHHHHHHHHHHHHHHHHH   " + gd.getAktiveRoomPath()+"\\ParameterListe"+gd.getAktiveRoomName()+".txt");
//                    room.loadMenu(gd.getAktiveRoomPath() + "\\ParameterListe" + gd.getAktiveRoomName() + ".txt");
//   dv.getDuration();
                    //  ..format(Date)e.getNewValue());
                     //   System.out.println(sdf.format(Date)e.getNewValue()));
                }
            }
        });
//  sc.getStartButton().addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent e) {
//                
//                  System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrr   ");
//              
//          int tin=Integer.parseInt((String)getSc().getBeginTimeHour().getSelectedItem())*60*60+ Integer.parseInt((String)getSc().getBeginTimeMin().getSelectedItem())*60;
//               System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrr   "+tin);
//               room.cd.ccTimerRoom(tin, tin, rm, rm.getjProgressBarCircLeft());
//               
//            }
//        }
//        );
  
   // cm.getStartButton().addActionListener(e -> timerIn());
        
    }
private void timerIn(){
     int tin=Integer.parseInt((String)getSc().getBeginTimeHour().getSelectedItem())*60*60+ Integer.parseInt((String)getSc().getBeginTimeMin().getSelectedItem())*60;
               System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrr   ");
             //  getCm().getjTextFieldAnzeige().append("rrrrrrrrrrrrrr\n");
              //  room.cd.ccTimerRoom(tin, tin, rm, rm.getjProgressBarCircLeft());
            //  room.cd.ccTimerRoom(23, 2,  getCm().getjProgressBarCircLeft());
              
}
    private void checkDatum(Calendar cal) {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(System.currentTimeMillis());//.getTimeInMillis();
        Date date = now.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        if (cal.before(now)) {
            JOptionPane.showMessageDialog(getSc(), "SECTIGINZ TARIH \n"
                    + sdf.format(cal.getTime()) + "\n"
                    + "BUGÜN  " + sdf.format(date) + "\n",
                    "DAHA ILERI BIR TARIH SECINIZ \n", JOptionPane.ERROR_MESSAGE);
            System.out.println("DAtum muss nache her leiegen");
        } else {
            JOptionPane.showMessageDialog(null, "SIZ ASSGIDAKI TARIHI \n " + sdf.format(cal.getTime()) + "\n" + " SECTINIZ\n", "Heute ist \n" + sdf.format(date), JOptionPane.PLAIN_MESSAGE);
//            JOptionPane.showMessageDialog(getSc(), "Heute ist " +  sdf.format(date),
//                    "Datum Ist ok", JOptionPane.ERROR_MESSAGE);
            System.out.println("DAtum is ok");
        }
    }
    
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

  
    public SplitKonfiguration getSc() {
        return sc;
    }

   
    public void setSc(SplitKonfiguration sc) {
        this.sc = sc;
    }

    public GrundDaten getGd() {
        return gd;
    }

 
    public void setGd(GrundDaten gd) {
        this.gd = gd;
    }

    /**
     * @return the room
     */
    public Rooms getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(Rooms room) {
        this.room = room;
    }

    /**
     * @return the counter1
     */
    public int getCounter1() {
        return counter1;
    }

    /**
     * @param counter1 the counter1 to set
     */
    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }

    /**
     * @return the tcp
     */
    public TCPClientMainMain getTcp() {
        return tcp;
    }

}
