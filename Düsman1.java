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
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author burakdursun
 */
public class Düsman1 {
    private int tilex,tiley;
    private Image düsman1;
    
    private int[][] harita = new int[15][12];
    public int[][] yol = new int[100][2];
    int mesafe = 0;
    
    
    public Düsman1() {
        ImageIcon img = new ImageIcon("C://Users//Oğuzhan//Desktop//aaa//azman.png");
        düsman1=img.getImage();
        
        tilex=10;
        tiley=0;
       
        
    }
    public Image getDüsman1(){
        return düsman1;
    }

  
    public int getTilex() {
        return tilex;
    }

    public int getTiley() {
        return tiley;
    }
    
    public void degis1(int dx,int dy){
        
        tilex+=dx;
        tiley+=dy;
        
    }
    
        public void KisaYol(int Adim, int HedefX, int HedefY, Map map) {
        for (int adim = 0; adim < Adim; adim++) {

            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 12; y++) {
                    harita[x][y] = 800;
                }
            }
            harita[getTilex()][getTiley()] = 0;
            
            YolSec(getTilex() - 1, getTiley(), 1, 1,map);
            YolSec(getTilex() + 1, getTiley(), 1, 1,map);
            YolSec(getTilex(), getTiley() - 1, 1, 1,map);
            YolSec(getTilex(), getTiley() + 1, 1, 1,map);
            

          

            mesafe = harita[HedefX][HedefY];
            yol[mesafe][0] = HedefX;
            yol[mesafe][1] = HedefY;
            for (int i = mesafe - 1; i > -1; i--) {
                if (harita[yol[i + 1][0] + 1][yol[i + 1][1]] == i) {
                    yol[i][0] = yol[i + 1][0] + 1;
                    yol[i][1] = yol[i + 1][1];
                } else if (harita[yol[i + 1][0] - 1][yol[i + 1][1]] == i) {
                    yol[i][0] = yol[i + 1][0] - 1;
                    yol[i][1] = yol[i + 1][1];
                } else if (harita[yol[i + 1][0]][yol[i + 1][1] + 1] == i) {
                    yol[i][0] = yol[i + 1][0];
                    yol[i][1] = yol[i + 1][1] + 1;
                } else if (harita[yol[i + 1][0]][yol[i + 1][1] - 1] == i) {
                    yol[i][0] = yol[i + 1][0];
                    yol[i][1] = yol[i + 1][1] - 1;
                }
            }

            degis1(yol[1][0] - getTilex(), yol[1][1] - getTiley());
           

        }

    }

    public void YolSec(int Xdeger, int Ydeger, int mesafe, int karakter, Map m) {
        if ((Xdeger > -1) && (Ydeger > -1) && (Xdeger < 14) && (Ydeger < 11)) {
            if (karakter == 1) {  
                if ((m.getMap(Xdeger, Ydeger).equals("1")) && (harita[Xdeger][Ydeger] > mesafe)) {
                    harita[Xdeger][Ydeger] = mesafe;
                    YolSec(Xdeger - 1, Ydeger, mesafe + 1, karakter,m);
                    YolSec(Xdeger + 1, Ydeger, mesafe + 1, karakter,m);
                    YolSec(Xdeger, Ydeger - 1, mesafe + 1, karakter,m);
                    YolSec(Xdeger, Ydeger + 1, mesafe + 1, karakter,m);
                }

            }
        }

    }
}