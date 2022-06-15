/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.toolsmanager2.utils;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Diego Ramirez
 */
public class Utils {
    public static void showHidePassword(javax.swing.JPasswordField pwsField, boolean show) {
        if (show) {
            pwsField.setEchoChar((char) 0);    
        } else {
            pwsField.setEchoChar((char) '*');
        }
    }
    
    public static void errorMessage(String message)
    {
        System.err.println(message);
                JOptionPane.showMessageDialog(null,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public static void infoMessage(String message)
    {
        System.err.println(message);
                JOptionPane.showMessageDialog(null,
                message,
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void warningMessage(String message)
    {
        System.err.println(message);
                JOptionPane.showMessageDialog(null,
                message,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    
    public static ImageIcon resizeImageIcon1 (BufferedImage originalImage, int desiredWidth, int desiredHeight) {
        int newHeight = 0;    
        int newWidth = 0;
        float aspectRatio = (float)originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() > originalImage.getHeight()) {
            newWidth = desiredWidth;
            newHeight = Math.round( desiredWidth / aspectRatio);                
        }
        else {
            newHeight = desiredHeight;
            newWidth = Math.round(desiredHeight * aspectRatio);
        }
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        outputImage.getGraphics().drawImage(resultingImage,0,0, null);
        ImageIcon imageIcon = new ImageIcon(outputImage);
        return imageIcon;
    }
    
    public static ImageIcon resizeImageIcon2(String image, int desiredWidth, int desiredHeight) {
    int newHeight = 0;
    int newWidth = 0;
    BufferedImage originalBufferedImage = null;
    ImageIcon icon = null;

    try {
    originalBufferedImage = ImageIO.read(new URL("https://spdvisa.blob.core.windows.net/eines/"+ image));
    float aspectRatio = (float) originalBufferedImage.getWidth() / originalBufferedImage.getHeight();
    if (originalBufferedImage.getWidth() > originalBufferedImage.getHeight()) {
    newWidth = desiredWidth;
    newHeight = Math.round(desiredWidth / aspectRatio);
    } else {
    newHeight = desiredHeight;
    newWidth = Math.round(desiredHeight * aspectRatio);
    }
    BufferedImage resultingImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics2D = resultingImage.createGraphics();
    graphics2D.drawImage(originalBufferedImage, 0, 0, newWidth, newHeight, null);
    graphics2D.dispose();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(resultingImage, "png", baos);
    icon = new ImageIcon(baos.toByteArray());

    baos.close();

    } catch (IOException ex) {
    Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
    }

    return icon;
    }
    

}
