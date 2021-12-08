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
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;
import java.awt.*;

public class Map {

	private Scanner m;
	public String Map[] = new String[11];
	public Image grass, puan, wall,sirine,gargamel,azman;

	public Map() {
		ImageIcon img = new ImageIcon("C://Users//Oğuzhan//Desktop//aaa//puan.png");
		puan = img.getImage();
                img = new ImageIcon("C://Users//Oğuzhan//Desktop//aaa//sirine.png");
		sirine = img.getImage();
                img  = new ImageIcon("C://Users//Oğuzhan//Desktop//aaa//gargamel.png");
		gargamel = img.getImage();
                img  = new ImageIcon("C://Users//Oğuzhan//Desktop//aaa//azman.png");
		azman = img.getImage();

		openFile();
		readFile();
		closeFile();
	}


	public Image getPuan() {
		return puan;
	}
        
        public Image getSirine() {
		return sirine;
	}
        
        public Image getGargamel() {
		return gargamel;
	}
        
         public Image getAzman() {
		return azman;
	}

	public String getMap(int x, int y) {
		String index = Map[y].substring(x, x + 1);
		return index;

	}

	public void openFile() {
		try {
			m = new Scanner(new File("C://Users//Oğuzhan//Desktop//aaa//maze1.txt"));
		} catch (Exception e) {
			System.out.println("error harita yok");
		}
	}

	public void readFile() {
		while (m.hasNext()) {
			for (int i = 0; i < 11; i++) {
				Map[i] = m.next();
                                System.out.println(Map[i]);
			}
		}
	}

	public void closeFile() {
		m.close();
	}
}
