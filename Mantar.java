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
public class Mantar {
    
    private int Ax, Ay;
	private Image mantar;

	public Mantar() {
		ImageIcon img = new ImageIcon("C://Users//Oğuzhan//Desktop//aaa//mantar.png");
		mantar = img.getImage();
                

		Ax = -1;
		Ay = -1;
                
                

	}

	public Image getMantar() {
		return mantar;
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
