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
import java.awt.Color;
import javax.swing.*;

public class Maze {

    
    public static void main(String[] args) {
        new Maze();
    }

    public Maze() {
        
        JFrame f=new JFrame();

        f.setTitle("Şirinler Labirent Oyunu");
        f.add(new Goruntu());
        f.setSize(435, 460);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       
        
    }
    
    
}
