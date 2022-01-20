import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {
    Charac p;
    public Image bg;
    Timer timer;
    static Boolean ingame=true;
    static Font font = new Font("SanSerif",Font.BOLD,25);
    static int G=100,F=100,flag=0;

    public MyPanel() {
        p = new Charac();

        addKeyListener(new AL());
        setFocusable(true);
        
        ImageIcon icon1 = new ImageIcon("background.png");
        bg = icon1.getImage();

        timer = new Timer(5, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        p.moveF();
        p.shoot();
        p.shoot1();
        p.Collision();
        checkCollisions();
        checkGameOver();
        checkHealth();
        repaint();
    }


    public void checkGameOver()
    {
        if(ingame==false)
        {
            timer.stop();

            //System.exit(0);
        }
    }

    public void checkHealth()
    {
        if(G==0)
        {
            flag=1;
            ingame= false;
        }
        else if(F==0)
        {
            flag=2;
            ingame = false;
        }
    }

    public void checkCollisions()
    {
        Rectangle r1 = p.getK1Bounds();
        Rectangle r2 = p.getK2Bounds();
        Rectangle r3 = p.getGBounds();
        Rectangle r4 = p.getFBounds();
        if(p.shot1==true && p.shot2==true)
        {
            if(r1.intersects(r2))
            {
                p.ki1 =null;
                p.shot1 = false;
                p.readyToFire1 = true;
                p.ki2 = null;
                p.shot2 = false;
                p.ReadyToFire2 = true;
            }
            if(r1.intersects(r4))
            {
                F=F-20;
                p.ki1 =null;
                p.shot1 = false;
                p.readyToFire1 = true; 
            }
            if(r2.intersects(r3))
            {
                G=G-20;
                p.ki2 = null;
                p.shot2 = false;
                p.ReadyToFire2 = true;
            }
        }
        if(p.shot1==true)
        {
            if(r1.intersects(r4))
            {
                F=F-20;
        
                p.ki1 =null;
                p.shot1 = false;
                p.readyToFire1 = true; 
            }
        }
        if(p.shot2==true)
        {
            if(r2.intersects(r3))
            {
                G=G-20;
                
                p.ki2 = null;
                p.shot2 = false;
                p.ReadyToFire2 = true;
            }
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg, 0, 100, null);
        g.setColor(Color.black);
        g.fillRect(0,0, 800, 100);
        g2d.setFont(font);
        g2d.setColor(Color.white);
        g2d.drawString("Player 1",30 ,40);
        g2d.drawString("HP: "+G, 40, 75);
        g2d.drawString("Player 2", 600, 40);
        g2d.drawString("HP: "+F, 610, 75);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        g2d.drawImage(p.getFImage(), p.getFX(), p.getFY(), null);

        if(p.shot1)
        {
            g2d.drawImage(p.getKi1Image(),p.getKi1X(), p.getKi1Y(),null);
        }

        if(p.shot2)
        {
            g2d.drawImage(p.getKi2Image(),p.getKi2X(),p.getKi2Y(), null);
        }

        if(flag==1)
        {
            g2d.setColor(Color.black);
            g2d.drawString("!! Player 2 Wins !!", 300, 300);
        }
        if(flag==2)
        {
            g2d.setColor(Color.black);
            g2d.drawString("!! Player 1 Wins !!", 300, 300);
        }
    }

    private class AL extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }

    }
}