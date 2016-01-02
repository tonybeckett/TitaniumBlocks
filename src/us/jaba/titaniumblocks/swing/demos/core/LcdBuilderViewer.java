/*
 * Copyright (c) 2015, Tony Beckett
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * The names of its contributors may not be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package us.jaba.titaniumblocks.swing.demos.core;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.SatinGrayBModel;
import us.jaba.titaniumblocks.core.lcd.LinearLcdImageFactory;
import us.jaba.titaniumblocks.core.lcd.painters.LinearLcdPainter;

/**
 *
 * @author tbeckett
 */
public class LcdBuilderViewer extends javax.swing.JFrame
{
    public LcdBuilderViewer()
    {
        initComponents();
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumns(3);
        panel.setLayout(gridLayout);
        
        LinearLcdImageFactory lib = new LinearLcdImageFactory(new LinearLcdPainter());
       
        BufferedImage im = lib.build(new Dimension(200, 100));
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(im));
        panel.add(label);

//        TextureImageBuilder ct = new TextureImageBuilder(new CarbonTexturePainter());
//        im = ct.build(new Dimension(200, 200));
        lib.getPainter().setDisabled(true);
        lib.getPainter().getBackgroundImageBuilder().getPainter().setBackgroundColorModel(new SatinGrayBModel());
        
        im = lib.build(new Dimension(250, 150));
        label = new JLabel();
        label.setIcon(new ImageIcon(im));
        panel.add(label);
        
        lib.getPainter().getLinearFrameImageBuilder().getPainter().setFrameThickness(6);
        
        im = lib.build(new Dimension(250, 125));
        label = new JLabel();
        label.setIcon(new ImageIcon(im));
        panel.add(label);
        
//        RadialIndicatorBuilder rlib = new RadialIndicatorBuilder();
//        
//        im = rlib.getImage(new Dimension(100, 100));
//        label = new JLabel();
//        label.setIcon(new ImageIcon(im));
//        panel.add(label);
//        
//        rlib.setOn(true);
//        im = rlib.getImage(new Dimension(100, 100));
//        label = new JLabel();
//        label.setIcon(new ImageIcon(im));
//        panel.add(label);
//        
//        rlib.getSymbolOnImageBuilder().getPainter().setGlowEnabled(true);
//        im = rlib.getImage(new Dimension(100, 100));
//        label = new JLabel();
//        label.setIcon(new ImageIcon(im));
//        panel.add(label);
        
        add(panel);
        this.setSize(new Dimension(800, 400));
        
        setTitle("TitaniumBlocks - LcdBuilderViewer");
    }
    
    private void initComponents()
    {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        pack();
    }// 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(LcdBuilderViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(LcdBuilderViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(LcdBuilderViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(LcdBuilderViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new LcdBuilderViewer().setVisible(true);
            }
        });
    }
    
}
