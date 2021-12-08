/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme1;

/**
 *
 * @author Oğuzhan
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.TimerTask;
import javafx.scene.Node;
import javax.swing.*;

public class Goruntu extends JPanel implements ActionListener {

	private Timer timer;
        static int sayac =0;
	public Map m;
	private Oyuncu o;
        private Düsman d;
        private Düsman1 d1;
	private boolean win = false;
        private boolean lose =true;
	private String Message = " ";
	private Font font = new Font("Serif", Font.BOLD, 48);
        private int puan = 0;
         private final java.util.List<Integer> path = new ArrayList<Integer>();
         private int pathIndex;
         public Altın altın;
         public Mantar mantar;
         private int[][] harita = new int[15][12];
         private int[][] yol = new int[100][2];
         public int end = 0, mesafe = 0, YolCizim = 0;
          private int HedefX = 0, HedefY = 0;

	public Goruntu() {
		o = new Oyuncu();
                d = new Düsman();
                d1 = new Düsman1();
		m = new Map();
		addKeyListener(new Al());
		setFocusable(true);
		timer = new Timer(10, this);
		timer.start();
                altın = new Altın();
                mantar = new Mantar();
              AltınTopla();
              MantarTopla();
	}

	public void actionPerformed(ActionEvent e) {

		if (m.getMap(o.getTileX(), o.getTileY()).equals("9")) {
			Message = "Kazandınız";
			win = true;
		}
                if(puan == -10 || puan == -20){
                    Message = "Kaybettiniz";
                    lose = false;
                }
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
                Color color = null;
		if (!win && lose) {
			for (int y = 0; y < m.Map.length; y++) {
				for (int x = 0; x < m.Map[0].length(); x++) {             
                                    
					if (m.getMap(x, y).equals("9")){
						g.drawImage(m.getSirine(), x * 30, y * 30, null);
                                        }
                                    
					if (m.getMap(x, y).equals("1")) {
                                            g.setColor(Color.WHITE);
                                            g.fillRect(30*x, 30*y, 30, 30);
                                            g.drawRect(30*x, 30*y, 30, 30); 
                                            g.setColor(color);                         
                                            g.setColor(Color.BLACK);
                                            

					}

					if (m.getMap(x, y).equals("0")) {
                                            g.setColor(Color.BLACK);
                                            g.fillRect(30*x, 30*y, 30, 30);
                                            g.drawRect(30*x, 30*y, 30, 30); 
                                            

					}
                                        
                                        for(int i=1; i<d.mesafe; i++) {
                                            if(d.yol[i][0] == x && d.yol[i][1] == y) {
                                                g.setColor(Color.RED);
                                                g.fillRect(30*x, 30*y, 30, 30);
                                            }
                                        }
                                        
                                        for(int i=1; i<d1.mesafe;i++) {
                                    if(d1.yol[i][0] == x && d1.yol[i][1] == y) {
                                        g.setColor(Color.BLUE);
                                        g.fillRect(30*x, 30*y, 30, 30);
                                    }
                                }
                                        
                                        g.drawRect(30*x, 30*y, 30, 30); 
                                        
                                         g.setColor(color);                         
                                            g.setColor(Color.BLACK);
                                         
				}
			}
                        
                        int pathX=o.getTileX();
                        int pathY=o.getTileY();
			g.drawImage(o.getOyuncu(), pathX * 30, pathY * 30,null);  
                        int pathx=d.getTilex();
                        int pathy=d.getTiley();
                        int pathx1=d1.getTilex();
                        int pathy1=d1.getTiley();
                        g.drawImage(d.getDüsman(), pathx*30, pathy*30,30,30, null);
                        g.drawImage(d1.getDüsman1(), pathx1*30, pathy1*30,30,30, null);
                        g.drawImage(altın.getCoin(), altın.getAx()*30, altın.getAy()*30,30,30, null);
                        g.drawImage(mantar.getMantar(), mantar.getAx()*30, mantar.getAy()*30,30,30, null);
                        

		}
		if (win) {
			g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString(Message, 120, 220);
		}   
                if(!lose) {
                    g.setColor(Color.BLACK);
	            g.setFont(font);
		    g.drawString(Message, 120, 220);
                }    
                
	}
        

	public class Al extends KeyAdapter {
            
            

		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode();
                        
			if (keycode == KeyEvent.VK_W) {
				if (!m.getMap(o.getTileX(), o.getTileY() - 1).equals("0") && o.getTileY()>0) {
					o.degis(0, -1);
                                        d.KisaYol(1, o.getTileX(), o.getTileY(), m);
                                        d1.KisaYol(2, o.getTileX(), o.getTileY(), m);
                                }
                                
                                 if(o.getTileX() == altın.getAx() && o.getTileY() == altın.getAy()){
                            puan+=10;
                            System.out.println("puan:"+puan);  
                        }
                                 if(o.getTileX() == mantar.getAx() && o.getTileY() == mantar.getAy()){
                            puan+=20;
                            System.out.println("puan:"+puan);
                        }
                                 if(d.getTilex() == o.getTileX() && d.getTiley() == o.getTileY()){
                                puan -=20;
                                System.out.println("puan:"+puan);
                            }
                                 if(d1.getTilex() == o.getTileX() && d1.getTiley() == o.getTileY()){
                                puan -=10;
                                System.out.println("puan:"+puan);
                            }
                             
			}
                        
			if (keycode == KeyEvent.VK_S) {
				if (!m.getMap(o.getTileX(), o.getTileY() + 1).equals("0") && o.getTileY()<12) {
					o.degis(0, 1);
                                        d.KisaYol(1, o.getTileX(), o.getTileY(), m);
                                        d1.KisaYol(2, o.getTileX(), o.getTileY(), m);
                                }
                                 if(o.getTileX() == altın.getAx() && o.getTileY() == altın.getAy()){
                            puan+=10;
                            System.out.println("puan:"+puan);  
                        }
                                 if(o.getTileX() == mantar.getAx() && o.getTileY() == mantar.getAy()){
                            puan+=20;
                            System.out.println("puan:"+puan);  
                        }
                                 if(d.getTilex() == o.getTileX() && d.getTiley() == o.getTileY()){
                                puan -=20;
                                System.out.println("puan:"+puan);
                            }
                                 if(d1.getTilex() == o.getTileX() && d1.getTiley() == o.getTileY()){
                                puan -=10;
                                System.out.println("puan:"+puan);
                            }
                           
			}
                        
			if (keycode == KeyEvent.VK_A) {
				if (!m.getMap(o.getTileX() - 1, o.getTileY()).equals("0") && o.getTileY()>0) {
					o.degis(-1, 0);
                                        d.KisaYol(1, o.getTileX(), o.getTileY(), m);
                                        d1.KisaYol(2, o.getTileX(), o.getTileY(), m);
                                }
                                 if(o.getTileX() == altın.getAx() && o.getTileY() == altın.getAy()){
                            puan+=10;
                            System.out.println("puan:"+puan);  
                        }
                                 if(o.getTileX() == mantar.getAx() && o.getTileY() == mantar.getAy()){
                            puan+=20;
                            System.out.println("puan:"+puan);  
                        }
                                 if(d.getTilex() == o.getTileX() && d.getTiley() == o.getTileY()){
                                puan -=20;
                                System.out.println("puan:"+puan);
                            }
                                 if(d1.getTilex() == o.getTileX() && d1.getTiley() == o.getTileY()){
                                puan -=10;
                                System.out.println("puan:"+puan);
                            }
			}
                        
			if (keycode == KeyEvent.VK_D) {
				if (!m.getMap(o.getTileX() + 1, o.getTileY()).equals("0") && o.getTileY()<14) {
					o.degis(1, 0);
                                        d.KisaYol(1, o.getTileX(), o.getTileY(), m);
                                        d1.KisaYol(2, o.getTileX(), o.getTileY(), m);
                                }
                                 if(o.getTileX() == altın.getAx() && o.getTileY() == altın.getAy()){
                            puan+=10;
                            System.out.println("puan:"+puan);  
                        }
                                 if(o.getTileX() == mantar.getAx() && o.getTileY() == mantar.getAy()){
                            puan+=20;
                            System.out.println("puan:"+puan);  
                        }
                                 if(d.getTilex() == o.getTileX() && d.getTiley() == o.getTileY()){
                                puan -=20;
                                System.out.println("puan:"+puan);
                            }
                                 if(d1.getTilex() == o.getTileX() && d1.getTiley() == o.getTileY()){
                                puan -=10;
                                System.out.println("puan:"+puan);
                            }
			}
                                   
		}
                

		public void keyReleased(KeyEvent e) {
			
		}

		public void keyTyped(KeyEvent e) {
			
		}        
               
	}
        
        public void AltınTopla(){

            
    java.util.Timer tmer2= new java.util.Timer();
    TimerTask arttır=new TimerTask() {
        
        @Override
        public void run() {
            Random rand2= new Random();
            int x1 = rand2.nextInt(10)+1;
            int y1 = rand2.nextInt(8)+1;
            if (!m.getMap(x1 + 0, y1 + 0).equals("0"))
                altın.move2(x1 + 0, y1 + 0);
        }

    };
    tmer2.schedule(arttır,0,5000);


}
        
        public void MantarTopla(){

            
    java.util.Timer tmer3= new java.util.Timer();
    TimerTask arttır1=new TimerTask() {
        
        @Override
        public void run() {
            Random rand2= new Random();
            int x1 = rand2.nextInt(10)+1;
            int y1 = rand2.nextInt(8)+1;
            if (!m.getMap(x1 + 0, y1 + 0).equals("0"))
                mantar.move2(x1 + 0, y1 + 0);
        }

    };
    tmer3.schedule(arttır1,0,5500);


}
        
        
}