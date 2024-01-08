/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientSeiteNeu;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import javax.swing.JProgressBar;

public class Countdown {
    
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
    private SplitKonfiguration sc;
    private  ChartMenu cm;

    public Countdown( SplitKonfiguration sc,  ChartMenu cm) {
        this.sc=sc;
        this.cm=cm;
    }

    public  void ccTimer(int period, int delay,SplitKonfiguration sc,JProgressBar bar) {

      
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(11);
          bar.setMaximum(period);
        //    isRunning = false;
        final Runnable runnable = new Runnable() {
            int countdownStarter = period;

            public void run() {
                countdownStarter--;
                System.out.println(countdownStarter);
                bar.setValue(countdownStarter);//.setText(String.valueOf(countdownStarter));
                  sc.getjTextArea2().append(String.valueOf(countdownStarter+ "\n"));
                  sc.getjLabelZähler().setText(String.valueOf(countdownStarter));
                if (countdownStarter <= 0) {
                    System.out.println("Timer Over!");
                    sc.getjTextArea1().setText(String.valueOf("Timer Over!"));
                    //  countdownStarter = period;
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, delay, 1, SECONDS);
        
        
        
    }

     public  void ccTimerRoom(int period, int delay, JProgressBar bar) {

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(11);
          bar.setMaximum(period);
        //    isRunning = false;
        final Runnable runnable = new Runnable() {
            int countdownStarter = period;

            public void run() {
                countdownStarter--;
                System.out.println(countdownStarter);
                bar.setValue(countdownStarter);//.setText(String.valueOf(countdownStarter));
                //  sc.getjTextArea2().append(String.valueOf(countdownStarter+ "\n"));
                 cm.getjTextFieldAnzeige().setText(String.valueOf(countdownStarter+ "\n"));
                  cm.getjLabelSetTimeCircLeft().setText(String.valueOf(countdownStarter));
                  sc.getjLabelZähler().setText(String.valueOf(countdownStarter));
                if (countdownStarter <= 0) {
                    System.out.println("Timer Over!");
                    cm.getjTextFieldAnzeige().setText(String.valueOf("Timer Over!"));
                    //  countdownStarter = period;
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, delay, 1, SECONDS);
    }

    /**
     * @return the rm
     */
   

  

}
