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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import us.jaba.titaniumblocks.core.Images;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.GradientCoreInfo;
import us.jaba.titaniumblocks.core.color.HSLColor;

/**
 *
 * @author tbeckett
 */
public class GradientPaletteViewer extends javax.swing.JFrame
{

    JPanel list = new JPanel();

    private JLabel makeLabel(Color c)
    {
        HSLColor hsl = new HSLColor(c);
//        JLabel jlabel = new JLabel(String.format("(%4.0f,%4.0f,%4.0f)", hsl.getHue(), hsl.getSaturation(), hsl.getLuminance()));
        JLabel jlabel = new JLabel(String.format("(%3.0f,%3.0f,%3.0f)", hsl.getHue(), hsl.getSaturation(), hsl.getLuminance()));

        if (hsl.getLuminance() > 33)
        {
            jlabel.setForeground(ColorPalette.BLACK.brighter());
        } else
        {
            jlabel.setForeground(ColorPalette.WHITE.darker());
        }
        jlabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        jlabel.setBackground(c);
        jlabel.setOpaque(true);
        jlabel.setHorizontalAlignment(JLabel.CENTER);

        return jlabel;
    }

    public GradientPaletteViewer() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        initComponents();

        List<Class<?>> classes = GradientCoreInfo.getAvailableClasses();

        int len = classes.size();
        GridLayout gl = new GridLayout();
        gl.setRows(len + 1);
        list.setLayout(gl);
        HSLColor hsl;

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumns(8);
        panel.setLayout(gridLayout);
        JLabel jlabel = new JLabel("HSL");
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jlabel);
        jlabel = new JLabel("Darkest");
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jlabel);
        jlabel = new JLabel("Dark");
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jlabel);
        jlabel = new JLabel("MediumDark");
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jlabel);
        jlabel = new JLabel("Medium");
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jlabel);
        jlabel = new JLabel("MediumLight");
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jlabel);
        jlabel = new JLabel("Light");
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jlabel);
        jlabel = new JLabel("Lightest");
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(jlabel);
        list.add(panel);

        for (int i = 0; i < len; i++)
        {
            panel = new JPanel();
            gridLayout = new GridLayout();
            gridLayout.setColumns(8);
            panel.setLayout(gridLayout);

            Class<?> aClass = classes.get(i);
            Constructor c = aClass.getConstructor();
            GradientPalette gradientDef = (GradientPalette) c.newInstance();

            jlabel = new JLabel("  " + aClass.getSimpleName().replace("", ""));
            jlabel.setForeground(ColorPalette.BLACK);
//            jlabel.setBackground(ColorPalette.WHITE);
            panel.add(jlabel);

            panel.add(makeLabel(gradientDef.getDarkest()));
            panel.add(makeLabel(gradientDef.getDark()));
            panel.add(makeLabel(gradientDef.getMediumDark()));
            panel.add(makeLabel(gradientDef.getMedium()));
            panel.add(makeLabel(gradientDef.getMediumLight()));
            panel.add(makeLabel(gradientDef.getLight()));
            panel.add(makeLabel(gradientDef.getLightest()));

            list.add(panel);
        }

        add(list);
//        this.setIconImage(Images.titaniumblocks16);
        this.setSize(new Dimension(900, 800));
    }

    private void initComponents()
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TitaniumBlocks - GradientPaletteViewer");
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
            java.util.logging.Logger.getLogger(GradientPaletteViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GradientPaletteViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GradientPaletteViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GradientPaletteViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new GradientPaletteViewer().setVisible(true);
                } catch (NoSuchMethodException ex)
                {
                    Logger.getLogger(GradientPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex)
                {
                    Logger.getLogger(GradientPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex)
                {
                    Logger.getLogger(GradientPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex)
                {
                    Logger.getLogger(GradientPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex)
                {
                    Logger.getLogger(GradientPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
