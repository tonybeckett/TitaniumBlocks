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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import us.jaba.titaniumblocks.core.Images;
import us.jaba.titaniumblocks.core.backdrop.BackdropCoreInfo;
import us.jaba.titaniumblocks.core.backdrop.colormodel.BackdropColorModel;
import us.jaba.titaniumblocks.core.color.ColorPalette;

/**
 *
 * @author tbeckett
 */
public class BackgroundColorModelViewer extends javax.swing.JFrame
{

    JPanel list = new JPanel();

    /**
     * Creates new form AirCompassDemo
     */
    public BackgroundColorModelViewer() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        initComponents();

        List<Class<?>> classes = BackdropCoreInfo.getColorClasses();//ClassFinder.find("us.jaba.titaniumblocks.core.backdrop.colormodel.colors");

        int len = classes.size();
        GridLayout gl = new GridLayout();
        gl.setRows(len);
        list.setLayout(gl);

        for (int i = 0; i < len; i++)
        {
            JPanel panel = new JPanel();
            GridLayout gridLayout = new GridLayout();
            gridLayout.setColumns(6);
            panel.setLayout(gridLayout);
//            panel.setBackground(ColorPalette.WHITE);

            Class<?> aClass = classes.get(i);
            Constructor c = aClass.getConstructor();
            BackdropColorModel bcm = (BackdropColorModel) c.newInstance();

            JLabel jlabel = new JLabel(aClass.getSimpleName().replace("BModel", ""));
            jlabel.setForeground(ColorPalette.BLACK);
//            jlabel.setBackground(ColorPalette.WHITE);
            panel.add(jlabel);

            jlabel = new JLabel("START");
            jlabel.setForeground(ColorPalette.GRAY);
            jlabel.setBackground(bcm.getGradientStartColor());
            jlabel.setOpaque(true);
            jlabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(jlabel);

            jlabel = new JLabel("CENTER");
            jlabel.setForeground(ColorPalette.GRAY);
            jlabel.setBackground(bcm.getGradientFractionColor());
            jlabel.setOpaque(true);
            jlabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(jlabel);

            jlabel = new JLabel("STOP");
            jlabel.setForeground(ColorPalette.GRAY);
            jlabel.setBackground(bcm.getGradientStopColor());
            jlabel.setOpaque(true);
            jlabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(jlabel);

            jlabel = new JLabel("LABEL");
            jlabel.setForeground(ColorPalette.GRAY);
            jlabel.setBackground(bcm.getLabelColor());
            jlabel.setOpaque(true);
            jlabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(jlabel);

            jlabel = new JLabel("SYMBOL");
            jlabel.setForeground(ColorPalette.GRAY);
            jlabel.setBackground(bcm.getSymbolColor());
            jlabel.setOpaque(true);
            jlabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(jlabel);

            list.add(panel);
        }

        add(list);
 //       this.setIconImage(Images.titaniumblocks32);
        this.setSize(new Dimension(400, 800));
    }

    private void initComponents()
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TitaniumBlocks - BackgroundColorModelViewer");
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
            java.util.logging.Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                    new BackgroundColorModelViewer().setVisible(true);
                } catch (NoSuchMethodException ex)
                {
                    Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex)
                {
                    Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex)
                {
                    Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex)
                {
                    Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex)
                {
                    Logger.getLogger(BackgroundColorModelViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
