import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

public class Main extends JFrame {


    public Main() {
        JFrame frame = new JFrame();
        frame.add(new MyPanel());
        frame.setTitle("2D Game");
        frame.setSize(800, 635);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false); 

    }

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new Main();
                
        File file = new File("song.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
            
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
         
    }
}