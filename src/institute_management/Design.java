/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institute_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author pasindu hathurushigh
 */
public class Design {
     public Image getIconImage() {
        ImageIcon img = new ImageIcon("src/com/institute/images/logo.png");
        return img.getImage();
    }
    
    public void tableDesign(JTable table){
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setFont(new Font("sans-serif", 1, 12));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setBackground(Color.DARK_GRAY);
        
    }
    
    public ImageIcon getSuccessIcon() {
        ImageIcon img = new ImageIcon("src/com/institute/images/success.png");
        return img;
    }
    
    public ImageIcon getDeleteSuccessIcon() {
        ImageIcon img = new ImageIcon("src/com/institute/images/success_delete.png");
        return img;
    }
    
    public ImageIcon getWarningIcon() {
        ImageIcon img = new ImageIcon("src/com/institute/images/warning.png");
        return img;
    }
    
    public ImageIcon getQuestionIcon() {
        ImageIcon img = new ImageIcon("src/com/institute/images/question.png");
        return img;
    }
    
    public ImageIcon getErrorIcon() {
        ImageIcon img = new ImageIcon("src/com/institute/images/error.png");
        return img;
    }
    
    /*
        Dates ****-01-01 --> ****-01-10 is a new year
    */
}
