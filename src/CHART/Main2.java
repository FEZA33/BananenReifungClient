/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CHART;
  
//import ClientSeite.TCPClientMainMain;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JPanel;

/**
 *
 * @author alisi
 */
public class Main2 extends JPanel implements Runnable {

    private ChartCanvas chart;
    private Thread thread;
    private float temp;
    private float damp;
    private float co2;
    private float ethy;
    private Random rando = new Random();
  //  TCPClientMainMain tcp;

    public Main2() {   //    public Main2(TCPClientMainMain tcp) {
        //this.tcp = tcp;
  
//            super("CHART_TEST");

        setLayout(new BorderLayout());
        chart = new ChartCanvas();
        add(chart, BorderLayout.CENTER);
        setSize(500, 340);
        this.setBounds(5, 5, 755, 330);
//        	setSize(550,300);
//		setVisible(true);  
        //  this.start();
    }

    @Override
       public synchronized  void run() {

        while (true) {
            try {
                //  this.getDataReal(tcp.getAnkommendeData());
                //newValueRoom();
                //random();
           //   setDataInChart(tcp.getAnkommendeData());
                // System.out.println("ANKOMMENDE DATEN     "+tcp.getAnkommendeData());
                //		chart.newValueRoom(temp,damp,co2,ethy);

                //          chart.newValueRoom(Float.parseFloat(room.getTempIst()),Float.parseFloat(room.getHumIst()),Float.parseFloat(room.getCo2Ist()));
                //            chart.newValueRoom(rf.getTemp(),rf.getDamp(),rf.getCo2(),rf.getEthylen());
//                                temp= (float) oneWire.getAnalogInWert11();
//                                damp= (float) oneWire.getAnalogInWert12();
//                                co2= (float) oneWire.getAnalogInWert13();
//                                ethy= (float) oneWire.getAnalogInWert14();
//                                damp= Float.parseFloat(room.getHumIst());
//                                co2= Float.parseFloat(room.getCo2Ist());
//                                ethy = Float.parseFloat(room.getEthylIst());
                getChart().newValueRoom((float) this.getTemp(), (float) this.getDamp(), (float) this.getCo2()*10, (float) this.getEthy());
                //              chart.newValueRoom(1.30009f,33.440087f,700.00076f,1.1f);

                //              chart.newValueRoom(rf.getTemp(),rf.getDamp(),rf.getCo2(),rf.getEthylen());
//              //                  chart.newValueRoom(Float         room.getTempIst(),room.getHumIst(),room.getCIst(),room.getEthylIst());
                //               System.out.println( "  ISI123  "+  temp+ "  "+  damp+ "  "+co2+ "  "+ethy);
                //                    System.out.println( "  ISI123  "+  room.getTempIst()+ "  "+  room.getHumIst()+ "  "+room.getCo2Ist()+ "  "+room.getEthylIst());
                thread.sleep(1000);
                //       thread.sleep(100);
                //  System.out.println("Chart werte aktualisiert");
            } catch (Exception e) {
                //	thread.interrupt();

                System.out.println("Problem:" + "   " + e.getMessage());
            }
        }
    }

    public  synchronized  void setDataInChart(String text) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy    HH:mm:ss");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());

        System.out.println(simpleDateFormat.format(date) +" SINAN "+ "  " + text);
        if (text != null) {
            StringTokenizer st = new StringTokenizer(text, ";");
//             st.nextToken();
//              st.nextToken();
//              
//               st.nextToken();
//                st.nextToken();
//                
//                 st.nextToken();
//                  st.nextToken();
//                  
//                   st.nextToken();
//                    st.nextToken();
            this.setTemp(Float.valueOf(st.nextToken()));
            st.nextToken();
            this.setDamp(Float.valueOf(st.nextToken()));
            st.nextToken();
            this.setCo2(Float.valueOf(st.nextToken()));
            st.nextToken();
            this.setEthy(Float.valueOf(st.nextToken()));
//          else text
        }
    }

    public String getDataReal(String sensordaten) {
        // zufallsZahl = getRandomNumber(minTemp, maxTemp);
        StringTokenizer st = new StringTokenizer(sensordaten, ";");

        setTemp(Float.parseFloat(st.nextToken()));//Mat) (getSinus(i) * 8));
        setDamp(Float.parseFloat(st.nextToken()));
        setCo2(Float.parseFloat(st.nextToken()) * 100);
        setEthy(Float.parseFloat(st.nextToken()));

        //    System.out.println("Data write1 " + i + "  temp= " + getTemp() + " damp= " + getDamp() + " Co2= " + getCo2() + " Ethyl.= " + getEthylen());
        return getTemp() + " ; " + getDamp() + " ; " + getCo2() + " ; " + getEthy() + " ; " + " ";
        //return i + " temp= " + getTemp() +";"+ " damp= " + getDamp() +";"+ " Co2= " + getCo2() +";"+ " Ethyl.= " + getEthylen()+";"+" ";

    }

    synchronized public void random() {
        setTemp(rando.nextInt(10) + 15);
        setDamp(rando.nextInt(20) + 20);
        setCo2(rando.nextInt(600) + 2400);
        setEthy(rando.nextInt(5));
    }

    /**
     * @return the temp
     */
    public float getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(float temp) {
        this.temp = temp;
    }

    /**
     * @return the damp
     */
    public float getDamp() {
        return damp;
    }

    /**
     * @param damp the damp to set
     */
    public void setDamp(float damp) {
        this.damp = damp;
    }

    /**
     * @return the co2
     */
    public float getCo2() {
        return co2;
    }

    /**
     * @param co2 the co2 to set
     */
    public void setCo2(float co2) {
        this.co2 = co2;
    }

    /**
     * @return the ethy
     */
    public float getEthy() {
        return ethy;
    }

    /**
     * @param ethy the ethy to set
     */
    public void setEthy(float ethy) {
        this.ethy = ethy;
    }

    /**
     * @return the chart
     */
    public ChartCanvas getChart() {
        return chart;
    }

    /**
     * @param chart the chart to set
     */
    public void setChart(ChartCanvas chart) {
        this.chart = chart;
    }
    /**
     * @return the room
     */
//	public static void main(String[] args){
//		new Main1();
//	}

}
