/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientSeiteNeu;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author sinan
 */





import java.awt.event.ActionListener;
import javax.swing.Timer;


import java.util.Date;

import java.text.SimpleDateFormat;

public class SystemUhr implements Runnable {

 //   private Reifung_GUI rf;
    private SplitKonfiguration sc;
    ChartMenu cm;
    private Thread thread;
     
   public SystemUhr(SplitKonfiguration sc,ChartMenu cm ) {
        this.sc = sc;
        this.cm=cm;
    //    this.room=room;
     // sc.getTimeAnzeigeConfiguration1().setBackground(COLOR.orange);
       // this.start();

    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            clock();
            thread.start();
        }
        System.out.println("System Uhr Thread gestartet");
    }

    //   Thread thread;
    public void run() {

        System.out.println(" System Uhr Run  gestartet");
    //
    }

    public void clock() {
        final Date date = new Date();
        //	final JLabel label = new JLabel();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy    HH:mm:ss");

        Timer timer = new Timer(100, new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                date.setTime(System.currentTimeMillis());
               // sc.getHauptCalendar().getTime();
               
                sc.getTimeAnzeigeConfiguration1().setText(simpleDateFormat.format(date));
                cm.getTimeAnzeigeHauptMenu().setText(simpleDateFormat.format(date));
                sc.getjTextFieldStateAnzeige().setText(simpleDateFormat.format(date)+" "+simpleDateFormat.format(sc.getHauptCalendar().getTime())+"\n");
                if (simpleDateFormat.format(date)==simpleDateFormat.format(sc.getHauptCalendar().getTime()))
                    sc.getStatusAnzeige1().setText("DATE erreicht");
                // cm.getStatusAnzeigeRoom().setText( simpleDateFormat.format(sc.getHauptCalendar().getTime()));
                
                
              //  sc.get.getSystemUhrAnzeige().setText(simpleDateFormat.format(date));
              
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}