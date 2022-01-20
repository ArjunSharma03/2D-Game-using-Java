import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Charac {
  int x, y, dy, fx, fy, fdy;
  Image Goku, Frieza;
  Image ki1 = null, ki2 = null;
  int k1x, k1y, k2x, k2y;
  boolean readyToFire1, shot1 = false, ReadyToFire2, shot2 = false;

  public Charac() {
    ImageIcon icon1 = new ImageIcon("Goku.gif");
    Goku = icon1.getImage();

    y = 300;
    x = 5;

    ImageIcon icon2 = new ImageIcon("Frieza.gif");
    Frieza = icon2.getImage();

    fy = 110;
    fx = 700;

  }

  public void move() {
    if(y<100)
    {
      y=100;
    }
    else if(y>500)
    {
      y=500;
    }
    else{
      y = y + dy;
    }
  }

  public void moveF() {
    if(fy<100)
    {
      fy = 100;
    }
    else if(fy>500)
    {
      fy=500;
    }
    else{
      fy = fy + fdy;
    }
  }

  public int getX() {
    return x;
  }

  public Rectangle getGBounds()
  {
    return new Rectangle(x,y,89,98);
  }

  public int getFX() {
    return fx;
  }

  public Rectangle getFBounds()
  {
    return new Rectangle(fx,fy,83,98);
  }

  public int getKi1X() {
    return k1x;
  }

  public Rectangle getK1Bounds()
  {
    return new Rectangle(k1x,k1y,20,20);
  }

  public int getKi2X() {
    return k2x;
  }

  public Rectangle getK2Bounds()
  {
    return new Rectangle(k2x,k2y,25,25);
  }

  public int getY() {
    return y;
  }

  public int getFY() {
    return fy;
  }

  public int getKi1Y() {
    return k1y;
  }

  public int getKi2Y() {
    return k2y;
  }

  public Image getImage() {
    return Goku;
  }

  public Image getFImage() {
    return Frieza;
  }

  public Image getKi1Image() {
    return ki1;
  }

  public Image getKi2Image() {
    return ki2;
  }

  public void shoot() {
    if (shot1) {
      k1x = k1x + 10;
    }
  }

  public void shoot1() {
    if (shot2) {
      k2x = k2x - 10;
    }
  }

  public void Collision() {
    if (shot1 == true) {
      readyToFire1 = false;
      if (k1x >= 790) {
        ki1 = null;
        shot1 = false;
        readyToFire1 = true;
      }
    }

    if (shot2 == true) {
      readyToFire1 = false;
      if (k2x <= 5) {
        ki2 = null;
        shot2 = false;
        readyToFire1 = true;
      }
    }

  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == 87) {
      if (y <= 100)
        y = 100;
      else
        dy = -5;
    }

    if (key == 83) {
      if (y >= 500)
        y = 500;
      else
        dy = 5;
    }

    if (key == 38) {
      if (fy <= 100)
        fy = 100;
      else
        fdy = -5;
    }

    if (key == 40) {
      if (fy >= 500)
        fy = 500;
      else
        fdy = 5;
    }

    if (key == 70) {
      if (ki1 == null) {
        readyToFire1 = true;
      }
      if (readyToFire1) {
        k1y = y + 30;
        k1x = x + 100;
        ImageIcon icon3 = new ImageIcon("ki.png");
        ki1 = icon3.getImage();
        shot1 = true;
      }
    }

    if (key == 96) {


      if (ki2 == null) {
        readyToFire1 = true;
      }
      if (readyToFire1) {
        k2y = fy + 30;
        k2x = fx - 20;
        ImageIcon icon4 = new ImageIcon("ki2.png");
        ki2 = icon4.getImage();
        shot2 = true;
      }
    }
  }

  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == 87) {
      dy = 0;
    }

    if (key == 83) {
      dy = 0;
    }

    if (key == 38) {
      fdy = 0;
    }

    if (key == 40) {
      fdy = 0;
    }

    if (key == 70) {

    }

    if (key == 96) {
    }
  }
}
