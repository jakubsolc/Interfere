/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfere;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alena
 */
public class Interfere extends JPanel  {

    /**
     * @param args the command line arguments
     */
    
    
    private JFrame fr;
    private JLabel hdrLabel;
    private JLabel statusLabel;
    private Canvas cnv;
    
    public static void main(String[] args) {
   //     JFrame fr = new JFrame();
   //     JFrame fr = new JFrame();
        Interfere my = new Interfere();
                
    //    my.inic();
    //    
    //    fr.add("Center", my);
    //    fr.pack();
    //    fr.setVisible(true);
        //fr.paint();
    }
    
    
    public Interfere()
    {
      fr = new JFrame("Interference");
      fr.setSize(600,400);
 //     fr.setLayout(new FlowLayout());
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   //   setSize(500,350);
      fr.add(this);
      
      hdrLabel = new JLabel("Lejbl");
      statusLabel = new JLabel();        
      statusLabel.setSize(350,100);

 
      cnv = new Canvas();
      cnv.setSize(400,300);
      cnv.setBackground(Color.cyan);
 
   //   add(hdrLabel);
  //    add(statusLabel);
 //     add(cnv);
   //   fr.pack();
      fr.setVisible(true);  
      
      fr.addMouseListener(new MouseListener() {
          @Override
          public void mouseExited (MouseEvent e) {}

          @Override
          public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    poc++;
                    repaint();
                }
          }          

          @Override
          public void mousePressed(MouseEvent e) {}

          @Override
          public void mouseReleased(MouseEvent e) {}

          @Override
          public void mouseEntered(MouseEvent e) {}
      });
    
    }
   
    private  int poc=0;
  
    @Override
    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       g.setColor(Color.RED);
//       setBackground(Color.green);
       setBackground(Color.blue);
      setVisible(true); 
    if (poc%2==0)    kreslipic(g);
    else   kreslilis(g);
       
    }


    public void kreslipic(Graphics g)
    {
   /*     final int NN = 200;
        int fhight = fr.getContentPane().getHeight();
        int fwidth = fr.getContentPane().getWidth();
        double stepVert = fhight / (double)NN;
        double stepHz = fwidth / (double)NN;
   //  setSize(600,400);
     for (int i=1;i<NN;i++)
        {
            g.drawLine(0, 0, fwidth, (int) (stepVert*i));  //h350
            g.drawLine(0, 0, (int) (stepHz*i),fhight);  //h350
        }
       // fr.pack();
     */
        
        int fhight = fr.getContentPane().getHeight();
        int fwidth = fr.getContentPane().getWidth();
        double stepVert = 3 ;
        double stepHz = 4 ;
   //  setSize(600,400);
        int rx = 0;
        while (rx<fwidth)
        {
            g.drawLine(0, 0, rx,fhight);
            rx += stepHz;
        }  
        int ry = 0;
        while (ry<fhight)
        {
            g.drawLine(0, 0, fwidth,ry);
            ry += stepVert;
        }  
                    
        g.drawLine(0, 0, fwidth,fhight);

    }
 
    public void kreslilis(Graphics g)
    {
   /*     final int NN = 200;
        int fhight = fr.getContentPane().getHeight();
        int fwidth = fr.getContentPane().getWidth();
        double stepVert = fhight / (double)NN;
        double stepHz = fwidth / (double)NN;
   //  setSize(600,400);
     for (int i=1;i<NN;i++)
        {
            g.drawLine(0, 0, fwidth, (int) (stepVert*i));  //h350
            g.drawLine(0, 0, (int) (stepHz*i),fhight);  //h350
        }
       // fr.pack();
     */
        final double stepFi = 0.0005;
        int fhight = fr.getContentPane().getHeight();
        int fwidth = fr.getContentPane().getWidth();
        double omega1 = 13 ;
        double omega2 =  16;
        double fimax = omega1*omega2*Math.PI/10;
   //  setSize(600,400);
        double fi = 0;
        int x,y;
        
        g.setColor(Color.yellow);
        while (fi<fimax)
        {
            x = (int) (fwidth*(1.0F + Math.cos(fi*omega1))/2F);
            y = (int) (fhight*(1.0F + Math.sin(fi*omega2))/2F);
      //      g.setColor(new Color((int)(fi*omega1/10f)%255,(int)(fi*omega2/10f)%255,(x+y)%255));
      //      g.setColor(new Color((int)(200),(int)(x*y)%255,(x+y)%255));
             g.drawLine(x, y,x+1,y+1);
            fi += stepFi;
        }  
    }
   
}

