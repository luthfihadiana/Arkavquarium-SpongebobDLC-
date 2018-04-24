package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entitas.*;

import java.awt.image.BufferedImage;
import java.io.*;
public class Arkavgame extends JPanel implements ActionListener{
    private JLabel labelTelor;
    private JLabel labelProvit;
    private akuarium Tank;
    private JLabel winningLabel;
    Timer timer;
    private final String BACKGROUND_IMAGE = "C:/Users/User/Documents/Arkavquarium/Images/Krusty_Krab.png";
    public Arkavgame(){
          Tank = new akuarium();
          timer = new Timer(20 ,this);
          labelTelor = new JLabel("Telor : "+Tank.getPlayer().getTelor());
          labelProvit=  new JLabel("Profit : "+Tank.getPlayer().getUang());
          winningLabel = new JLabel("", SwingConstants.CENTER);
          addKeyListener(new Keyboard());
          addMouseListener(new CustomMouseListener());
          add(labelTelor);
          add(labelProvit);
          add(winningLabel);
          setFocusable(true);
    }
    public String pathGuppyImage(Guppy g){
        long mLapar = 500;
        if(g.getTahap() == 1)
        {
            if(g.getTime() >= mLapar)
            {
                if(g.getArah() == 'r')
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap1_r_hungry.png";
                }
                else
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap1_l_hungry.png";
                }
            }
            else
            {
                if(g.getArah() == 'r')
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap1_r.png";

                }
                else
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap1_l.png";
                }
            }

        }
        else if(g.getTahap() == 2)
        {
            if(g.getTime() >= mLapar)
            {
                if(g.getArah() == 'r')
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap2_r_hungry.png";
                }
                else
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap2_l_hungry.png";
                }
            }
            else
            {
                if(g.getArah() == 'r')
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap2_r.png";

                }
                else
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap2_l.png";
                }
            }
        }
        else
        {
            if(g.getTime() >= mLapar)
            {
                if(g.getArah() == 'r')
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap3_r_hungry.png";
                }
                else
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap3_l_hungry.png";
                }
            }
            else
            {
                if(g.getArah() == 'r')
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap3_r.png";

                }
                else
                {
                    return "C:/Users/User/Documents/Arkavquarium/Images/Tahap3_l.png";
                }
            }
        }
    }
    public String pathPiranhaImage(Piranha p){
        long mLapar = 500;
        if(p.getTime() >= mLapar)
        {
            if(p.getArah() == 'r')
            {
                return "C:/Users/User/Documents/Arkavquarium/Images/Piranha_r_hungry.png";
            }
            else
            {
                return "C:/Users/User/Documents/Arkavquarium/Images/Piranha_l_hungry.png";
            }
        }
        else
        {
            if(p.getArah() == 'r')
            {
                return "C:/Users/User/Documents/Arkavquarium/Images/Piranha_r.png";
            }
            else
            {
                return "C:/Users/User/Documents/Arkavquarium/Images/Piranha_l.png";
            }
        }
    }
    public String pathSiputImage(Siput s){
        if(s.getArah() == 'r')
        {
            return "C:/Users/User/Documents/Arkavquarium/Images/Garry_r.png";
        }
        else
        {
            return "C:/Users/User/Documents/Arkavquarium/Images/Garry_l.png";
        }
    }
    public String pathKoinImage(Koin k ){
        return "C:/Users/User/Documents/Arkavquarium/Images/Koin.png";
    }
    public String pathMakananImage(Makanan m ){
        return  "C:/Users/User/Documents/Arkavquarium/Images/Krabby_Patty.png";
    }
    public BufferedImage readImage(String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
        }
        return img;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(!Tank.isLose()){
            g.drawImage(readImage(BACKGROUND_IMAGE), 0, 0, null);
            labelProvit.setText("Profit : " +Tank.getPlayer().getUang());
            labelTelor.setText("Telor : "+Tank.getPlayer().getTelor());
            winningLabel.setText("");
            drawTank(g);
        }else{
            labelProvit.setText("");
            labelTelor.setText("");
            winningLabel.setText("You lose");
        }


    }
    public void drawTank(Graphics g) {
        ElmtLList<Guppy> p = Tank.getGuppy().getFirst();
        while(p != null){
            g.drawImage(readImage(pathGuppyImage(p.getData())), (int)p.getData().getPos().getX(),(int)p.getData().getPos().getY(), null);
            p = p.getNext();
        }
        ElmtLList<Piranha> q = Tank.getPiranhas().getFirst();
        while(q != null){
            g.drawImage(readImage(pathPiranhaImage(q.getData())), (int)q.getData().getPos().getX(),(int)q.getData().getPos().getY(), null);
            q = q.getNext();
        }
        ElmtLList<Makanan> r = Tank.getFoods().getFirst();
        while(r != null){
            g.drawImage(readImage(pathMakananImage(r.getData())), (int)r.getData().getPos().getX(),(int)r.getData().getPos().getY(), null);
            r = r.getNext();
        }
        ElmtLList<Koin> s = Tank.getCoins().getFirst();
        while(s != null){
            g.drawImage(readImage(pathKoinImage(s.getData())), (int)s.getData().getPos().getX(),(int)s.getData().getPos().getY(), null);
            s = s.getNext();
        }
        g.drawImage(readImage(pathSiputImage(Tank.getSnail())), (int)Tank.getSnail().getPos().getX(),(int)Tank.getSnail().getPos().getY(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Tank.moveAll();
        Tank.makeDead();
        Tank.fixAll();
        repaint();
    }
    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent kEve) {
            int key = kEve.getKeyCode();
            if(key==71){//keypressed = G
                Tank.addGuppy(new Guppy(100,100));
                Tank.getPlayer().buy(10);
            }else if (key == 80){
                Tank.addPiranha(new Piranha(100,100));
                Tank.getPlayer().buy(15);
            }else if(key == 75){
                Tank.addCoin(new Koin(350));
            }else if(key == 84){
                Tank.getPlayer().beliTelor();
                labelTelor.setText("Telor : "+Tank.getPlayer().getTelor());
            }else if(key == 82){
                Tank.resetAkuarium();
            }
        }
    }
    private class CustomMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            Tank.addMakanan(new Makanan(e.getX(),e.getY()));
            Tank.getPlayer().buy(2);
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }
    public static void main(String[] args){
        gameFrame gf = new gameFrame();
        Arkavgame a = new Arkavgame();
        gf.add(a);
        gf.setVisible(true);
        a.timer.start();
    }
}
