/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme1;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Oğuzhan
 */
public class Altın {
    
    private int Ax, Ay;
    private Image coin;

	public Altın() {
		ImageIcon img = new ImageIcon("C://Users//Oğuzhan//Desktop//aaa//puan.png");
		coin = img.getImage();
                
		Ax = -1;
		Ay = -1;
                
	}

	public Image getCoin() {
		return coin;
	}

	public int getAx() {
		return Ax;
	}

	public int getAy() {
		return Ay;
	}
        

	public void move2(int dx, int dy)
	{
		Ax = dx;
		Ay = dy;  
	}
}
