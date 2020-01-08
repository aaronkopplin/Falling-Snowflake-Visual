import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Snowflakes extends JPanel {
    int width = 500;
    int height = 500;
    int numSnowflakes = 75;
    int[] x = new int[numSnowflakes];
    int[] y = new int[numSnowflakes];
    int[] r = new int[numSnowflakes];
    int[] rate = new int[numSnowflakes];
    Random rand = new Random();
    long time = System.currentTimeMillis();

    public Snowflakes(){
        JFrame frame = new JFrame("Snowflakes");
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(92, 184, 255));

        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        for (int i = 0; i < x.length; i++){
            x[i] = rand.nextInt(width);
            y[i] = rand.nextInt(height);
            r[i] = rand.nextInt(6) + 14;
            rate[i] = rand.nextInt(3) + 1;
        }

        loop();
    }

    public void loop(){
        while (true) {
            long currTime = System.currentTimeMillis();
            if (currTime - time > 30){
                repaint();
                time = System.currentTimeMillis();
            }
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(255, 255, 255, 133));

        for (int i = 0; i < x.length; i++){
            g.fillOval(x[i] + (int)(30*Math.sin(.02*(y[i]))), y[i], r[i], r[i]);
        }

        for (int i = 0; i < y.length; i++){
            y[i] += rate[i];
            if (y[i] == height){
                y[i] = 0;
                x[i] = rand.nextInt(width);
            }
        }
    }

    public static void main(String[] args){
        new Snowflakes();
    }
}

