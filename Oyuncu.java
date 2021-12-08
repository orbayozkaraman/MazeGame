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

public class Oyuncu {
	private int tileX, tileY;
	private Image oyuncu;

	public Oyuncu() {
		ImageIcon img = new ImageIcon("C://Users//Oğuzhan//Desktop//aaa//tembel.png");
		oyuncu = img.getImage();
           
		tileX = 6;
		tileY = 5;
                
	}

	public Image getOyuncu() {
		return oyuncu;
	}

	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}
        

	public void degis(int dx, int dy)
	{
		tileX += dx;
		tileY += dy;              
	}
}