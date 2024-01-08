package CHART;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.Graphics;
import java.util.Vector;

public class ChartCanvas extends Canvas {
 
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int graphy[] = {-120, -100, -50, 0, 50, 100, 140};
    private int graphx[] = {120, 3, 50, 0, -50, -100, -5};
    private int graphy1[] = {-120, -100, -50, 0, 50, 100, 140};
    private int graphx1[] = {120, 3, 50, 0, -50, -100, -5};
    private int graphy2[] = {-120, -100, -50, 0, 50, 100, 140};
    private int graphx2[] = {120, 3, 50, 0, -50, -100, -5};
    private int graphy3[] = {-120, -100, -50, 0, 50, 100, 140};
    private int graphx3[] = {120, 3, 50, 0, -50, -100, -5};
    private int point = 0, point1 = 0, point2 = 0, point3 = 0;
    private Font font;

    private int[] co2x, co2y, dampx, dampy, tempx, tempy, ethx, ethy;
    private int co2p, dampp, tempp, ethp;
    private Vector tempVector0, tempVector1, tempVector2, tempVector3;

    public ChartCanvas() {
        setBackground(ColorExemple.lightgrey);
        setForeground(Color.BLACK);
        setSize(750, 320);
        co2x = new int[600];
        co2y = new int[600];
        tempx = new int[600];
        tempy = new int[600];
        dampx = new int[600];
        dampy = new int[600];
        ethx = new int[600];
        ethy = new int[600];
        tempVector0 = new Vector();
        tempVector1 = new Vector();
        tempVector2 = new Vector();
        tempVector3 = new Vector();

    }

    public void paint(Graphics g) {

        font = new Font("Arial", Font.CENTER_BASELINE, 12);
        System.out.println("PAINT gerufen");
                  //y-Axis for Temperature
        g.setColor(Color.PINK);//.RED);
        g.drawLine(120, 30, 120, 280);

        //scala vertical for temperatur
        g.drawLine(120, 280, 115, 280); //sub-section
        g.drawLine(120, 255, 117, 255);
        g.drawLine(120, 230, 115, 230); //sub-section
        g.drawLine(120, 205, 117, 205);
        g.drawLine(120, 180, 115, 180); //sub-section
        g.drawLine(120, 155, 117, 155);
        g.drawLine(120, 130, 115, 130); //sub-section
        g.drawLine(120, 105, 117, 105);
        g.drawLine(120, 80, 115, 80); //sub-section
        g.drawLine(120, 55, 117, 55);
        g.drawLine(120, 30, 115, 30); //sub-section

        //first y-axis scala value
        font = new Font("Arial", Font.CENTER_BASELINE, 10);

        g.setFont(font);
        g.drawString("0", 105, 283);
        g.drawString("6", 105, 233);
        g.drawString("12", 100, 183);
        g.drawString("18", 100, 133);
        g.drawString("24", 100, 83);
        g.drawString("30", 100, 33);
        g.drawString("[°C]", 99, 16);

        // Axis for the DampValue
        g.setColor(Color.BLACK);
        //y-Axis
        g.drawLine(90, 30, 90, 280);
        //scala2 vertical for damp
        g.drawLine(90, 280, 85, 280); //sub-section
        g.drawLine(90, 255, 87, 255);
        g.drawLine(90, 230, 85, 230); //sub-section
        g.drawLine(90, 205, 87, 205);
        g.drawLine(90, 180, 85, 180); //sub-section
        g.drawLine(90, 155, 87, 155);
        g.drawLine(90, 130, 85, 130); //sub-section
        g.drawLine(90, 105, 87, 105);
        g.drawLine(90, 80, 85, 80); //sub-section
        g.drawLine(90, 55, 87, 55);
        g.drawLine(90, 30, 85, 30); //sub-section

        //first y-axis scala value
        g.drawString("0", 75, 283);
        g.drawString("20", 70, 233);
        g.drawString("40", 70, 183);
        g.drawString("60", 70, 133);
        g.drawString("80", 70, 83);
        g.drawString("100", 65, 33);
        g.drawString("[%]", 69, 16);

//		 Axis for the EthylenValue
        g.setColor(Color.BLUE);
        //y-Axis
        g.drawLine(60, 30, 60, 280);
        //scala3 vertical for Ethylen
        g.drawLine(60, 280, 55, 280); //sub-section
        g.drawLine(60, 255, 57, 255);
        g.drawLine(60, 230, 55, 230); //sub-section
        g.drawLine(60, 205, 57, 205);
        g.drawLine(60, 180, 55, 180); //sub-section
        g.drawLine(60, 155, 57, 155);
        g.drawLine(60, 130, 55, 130); //sub-section
        g.drawLine(60, 105, 57, 105);
        g.drawLine(60, 80, 55, 80); //sub-section
        g.drawLine(60, 55, 57, 55);
        g.drawLine(60, 30, 55, 30); //sub-section

        //first y-axis scala value
        g.drawString("0", 45, 283);
        g.drawString("5", 45, 233);
        g.drawString("12", 40, 183);
        g.drawString("18", 40, 133);
        g.drawString("24", 40, 83);
        g.drawString("30", 40, 33);
        g.drawString("[ppm]", 34, 16);

//		 Axis for the CO2Value
        g.setColor(Color.GREEN);
        //y-Axis
        g.drawLine(30, 30, 30, 280);
        //scala3 vertical for Ethylen
        g.drawLine(30, 280, 25, 280); //sub-section
        g.drawLine(30, 255, 27, 255);
        g.drawLine(30, 230, 25, 230); //sub-section
        g.drawLine(30, 205, 27, 205);
        g.drawLine(30, 180, 25, 180); //sub-section
        g.drawLine(30, 155, 27, 155);
        g.drawLine(30, 130, 25, 130); //sub-section
        g.drawLine(30, 105, 27, 105);
        g.drawLine(30, 80, 25, 80); //sub-section
        g.drawLine(30, 55, 27, 55);
        g.drawLine(30, 30, 25, 30); //sub-section

        //scala4 co2value
        g.drawString("0", 15, 283);
        g.drawString("600", 5, 233);
        g.drawString("1200", 0, 183);
        g.drawString("1800", 0, 133);
        g.drawString("2400", 0, 83);
        g.drawString("3000", 0, 33);
        g.drawString("[ppm]", 1, 16);

//		x-Axis
        g.setColor(Color.black);
        g.drawLine(120, 280, 720, 280);
        g.drawLine(120, 281, 720, 281);

        //scala horizontal
        g.drawLine(120, 280, 120, 286); //sub-section
        g.drawLine(180, 280, 180, 284);
        g.drawLine(240, 280, 240, 284);
        g.drawLine(300, 280, 300, 284);
        g.drawLine(360, 280, 360, 284);
        g.drawLine(420, 280, 420, 286); //sub-section
        g.drawLine(480, 280, 480, 284);
        g.drawLine(540, 280, 540, 284);
        g.drawLine(600, 280, 600, 284);
        g.drawLine(660, 280, 660, 284);
        g.drawLine(720, 280, 720, 286); //sub-section

        //x-axis scala value
        g.drawString("0", 118, 298);
        g.drawString("5", 418, 298);
        g.drawString("10", 715, 298);
        g.drawString("[min]", 724, 310);

        //legends
        g.setFont(new Font("Arial", Font.CENTER_BASELINE, 10));
        g.setColor(Color.GREEN);
        g.fillRect(20, 310, 20, 4);
        g.drawString("co2", 48, 315);
        g.setColor(Color.BLUE);
        g.fillRect(120, 310, 20, 4);
        g.drawString("ethylen", 148, 315);
        g.setColor(Color.BLACK);
        g.fillRect(220, 310, 20, 4);
        g.drawString("damp", 248, 315);
        g.setColor(Color.RED);
        g.fillRect(320, 310, 20, 4);
        g.drawString("temp", 348, 315);

        // graphes
        
        g.setColor(Color.RED);
        g.drawPolyline(graphy, graphx, point);
        g.setColor(Color.BLACK);
        g.drawPolyline(graphy1, graphx1, point1);
        g.setColor(Color.BLUE);
        g.drawPolyline(graphy2, graphx2, point2);
        g.setColor(Color.GREEN);
        g.drawPolyline(graphy3, graphx3, point3);
        //g.drawPolyline(Main.getGraphy1(),Main.getGraphx1(),Main.getPoint());

        //Its value dynamic block-diagramm
        //Legend of Value
        g.fillRect(200, -160, 20, 3);
        g.setColor(Color.GREEN);
        g.fillRect(200, -150, 20, 3);
        g.setColor(Color.BLACK);
        g.fillRect(200, -140, 20, 3);
        g.setColor(Color.BLUE);
        g.fillRect(200, -130, 20, 3);
      

    }

    private void zeichneGRafen(Graphics g){
      
    }
    public Dimension getMinimumSize() {
        return new Dimension(750, 323);
    }

    // Die Lieblingsgröße setzen wir auf die Minimalgröße
    public Dimension getPreferredSize() {
        return getMinimumSize();
    }

    public void chartTempValue() {
        if (tempVector0 != null && tempVector0.size() <= 600) {
            int y = 0;
            int ykoo = 121;
            this.tempp = tempVector0.size();

            for (int i = 0; i < tempVector0.size(); i++) {

                // System.out.println(tempValue.getValue());
                float temp = Float.parseFloat(tempVector0.elementAt(i) + "");
                int value = tempKoordinate(temp);
                tempx[i] = value;
                tempy[y] = ykoo;
                // System.out.println(temp+"TestChart"+y+",,,"+value+",,,"+ykoo+",,,"+tempp);

                ykoo++;
                y++;

            }
        }
        if (tempVector0.size() > 600) {
            int y = 0;
            int x = 0;
            int ykoo = 121;
            int begin = tempVector0.size() - 600;

            for (int i = begin; i < tempVector0.size(); i++) {

                float temp = Float.parseFloat(tempVector0.elementAt(i) + "");
                int value = tempKoordinate(temp);
                tempx[x] = value;
                tempy[y] = ykoo;

                ykoo++;
                y++;
                x++;

            }

        }

    }

    /**
     *
     *
     */
    public void chartCo2Value() {

        if (tempVector1 != null && tempVector1.size() <= 600) {
            int y = 0;
            int ykoo = 121;
            this.co2p = tempVector1.size();

            for (int i = 0; i < tempVector1.size(); i++) {

                float co2 = Float.parseFloat(tempVector1.elementAt(i) + "");
                int value = co2Koordinate(co2);
                co2x[i] = value;
                co2y[y] = ykoo;
                //System.out.println(co2+" TestChart"+y+",,,"+value+",,,"+ykoo+",,,"+co2p);
                ykoo++;
                y++;

            }
        }
        if (tempVector1.size() > 600) {
            int y = 0;
            int x = 0;
            int ykoo = 121;
            int begin = tempVector1.size() - 600;

            for (int i = begin; i < tempVector1.size(); i++) {

                float co2 = Float.parseFloat(tempVector1.elementAt(i) + "");
                int value = co2Koordinate(co2);
                co2x[x] = value;
                co2y[y] = ykoo;

                ykoo++;
                y++;
                x++;

            }

        }

    }

    /**
     *
     *
     */
    public void chartDampValue() {
        if (tempVector2 != null && tempVector2.size() <= 600) {
            int y = 0;
            int ykoo = 121;
            this.dampp = tempVector2.size();

            for (int i = 0; i < tempVector2.size(); i++) {

                float damp = Float.parseFloat(tempVector2.elementAt(i) + "");
                int value = dampKoordinate(damp);
                dampx[i] = value;
                dampy[y] = ykoo;

                ykoo++;
                y++;

            }
        }
        if (tempVector2.size() > 600) {
            int y = 0;
            int x = 0;
            int ykoo = 121;
            int begin = tempVector2.size() - 600;

            for (int i = begin; i < tempVector2.size(); i++) {

                float damp = Float.parseFloat(tempVector2.elementAt(i) + "");
                int value = dampKoordinate(damp);
                dampx[x] = value;
                dampy[y] = ykoo;

                ykoo++;
                y++;
                x++;

            }

        }

    }

    /**
     *
     *
     */
    public void chartEthyValue() {
        if (tempVector3 != null && tempVector3.size() <= 600) {
            int y = 0;
            int ykoo = 121;
            this.ethp = tempVector3.size();
            for (int i = 0; i < tempVector3.size(); i++) {

                float eth = Float.parseFloat(tempVector3.elementAt(i) + "");
                int value = ethKoordinate(eth);
                ethx[i] = value;
                ethy[y] = ykoo;

                ykoo++;
                y++;
                // System.out.println(eth+" TestChart"+y+",,,"+value+",,,"+ykoo+",,,"+co2p);

            }
        }
        if (tempVector3.size() > 600) {
            int y = 0;
            int x = 0;
            int ykoo = 121;
            int begin = tempVector3.size() - 600;

            for (int i = begin; i < tempVector3.size(); i++) {

                float eth = Float.parseFloat(tempVector3.elementAt(i) + "");
                int value = ethKoordinate(eth);
                ethx[x] = value;
                ethy[y] = ykoo;

                ykoo++;
                y++;
                x++;

            }

        }

    }

    private int tempKoordinate(float temp) {
        double tempkoordinate = 280;
        double konstant = 8.33;
        if (temp != 0) {
            tempkoordinate = (temp * konstant - 280) * -1;
        }

        if (temp >= 30) {
            tempkoordinate = 30;
        }
        if (temp < 0) {
            tempkoordinate = 280;
        }

        return (int) tempkoordinate;
    }

    private int dampKoordinate(float damp) {
        double tempkoordinate = 280;
        double konstant = 2.5;
        if (damp != 0) {
            tempkoordinate = (damp * konstant - 280) * -1;
        }
        if (damp >= 100) {
            tempkoordinate = 30;
        }
        if (damp < 0) {
            tempkoordinate = 280;
        }

        return (int) tempkoordinate;
    }

    private int co2Koordinate(float co2) {
        double tempkoordinate = 280;
        double konstant = 0.0833;
        if (co2 != 0) {
            tempkoordinate = (co2 * konstant - 280) * -1;
        }
        if (co2 >= 3000) {
            tempkoordinate = 30;
        }
        if (co2 < 0) {
            tempkoordinate = 280;
        }

        return (int) tempkoordinate;
    }

    private int ethKoordinate(float eth) {
        double tempkoordinate = 280;
        double konstant = 8.33;
        if (eth != 0) {
            tempkoordinate = (eth * konstant - 280) * -1;
        }
        if (eth >= 300) {
            tempkoordinate = 30;
        }
        if (eth < 0) {
            tempkoordinate = 280;
        }

        return (int) tempkoordinate;
    }

    public void chartKoordiantes() {

    }

    public synchronized void newValueRoom(float tempa, float dampa, float co2a, float ethya) {
        if (tempVector0.size() > 600) {
            tempVector0.removeElementAt(0);
        }
        if (tempVector1.size() > 600) {
            tempVector1.removeElementAt(0);
        }
        if (tempVector2.size() > 600) {
            tempVector2.removeElementAt(0);
        }
        if (tempVector3.size() > 600) {
            tempVector3.removeElementAt(0);
        }

        tempVector0.add(tempa);
        tempVector1.add(co2a);
        tempVector2.add(dampa);
        tempVector3.add(ethya);

        chartTempValue();
        chartCo2Value();
        chartDampValue();
        chartEthyValue();

        setGraphx(tempx);
        setGraphy(tempy);
        setPoint(tempp);

        setGraphx1(dampx);
        setGraphy1(dampy);
        setPoint1(dampp);

        setGraphx2(ethx);
        setGraphy2(ethy);
        setPoint2(ethp);

        setGraphx3(co2x);
        setGraphy3(co2y);
        setPoint3(co2p);

        repaint();
    }

    public int[] getGraphx() {
        return graphx;
    }

    public void setGraphx(int[] graphx) {
        this.graphx = graphx;
    }

    public int[] getGraphx1() {
        return graphx1;
    }

    public void setGraphx1(int[] graphx1) {
        this.graphx1 = graphx1;
    }

    public int[] getGraphx2() {
        return graphx2;
    }

    public void setGraphx2(int[] graphx2) {
        this.graphx2 = graphx2;
    }

    public int[] getGraphx3() {
        return graphx3;
    }

    public void setGraphx3(int[] graphx3) {
        this.graphx3 = graphx3;
    }

    public int[] getGraphy() {
        return graphy;
    }

    public void setGraphy(int[] graphy) {
        this.graphy = graphy;
    }

    public int[] getGraphy1() {
        return graphy1;
    }

    public void setGraphy1(int[] graphy1) {
        this.graphy1 = graphy1;
    }

    public int[] getGraphy2() {
        return graphy2;
    }

    public void setGraphy2(int[] graphy2) {
        this.graphy2 = graphy2;
    }

    public int[] getGraphy3() {
        return graphy3;
    }

    public void setGraphy3(int[] graphy3) {
        this.graphy3 = graphy3;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint1() {
        return point1;
    }

    public void setPoint1(int point1) {
        this.point1 = point1;
    }

    public int getPoint2() {
        return point2;
    }

    public void setPoint2(int point2) {
        this.point2 = point2;
    }

    public int getPoint3() {
        return point3;
    }

    public void setPoint3(int point3) {
        this.point3 = point3;
    }

}
