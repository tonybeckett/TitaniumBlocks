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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.Images;
import us.jaba.titaniumblocks.core.color.ColorPalette;

/**
 *
 * @author tbeckett
 */
public class ColorPaletteViewer extends javax.swing.JFrame
{

    JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    JPanel list = new JPanel();

    /**
     *
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public ColorPaletteViewer() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        initComponents();

        this.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        List<Field> al = CoreInfoSupport.getStaticFields(ColorPalette.class);
//        List<String> al = ColorPalette.getColorNamesByHue();
//        Set keys = m.keySet();
//        int len = keys.size();
//        ArrayList<String> alk = new ArrayList(keys);
//        Collections.sort(alk);
        int len = al.size();
        GridLayout gl = new GridLayout();
        gl.setRows(len);
        list.setLayout(gl);
        Dimension dim = new Dimension(18, 18);
        for (int i = 0; i < len; i++)
        {
            JPanel panel = new JPanel();
//            panel.setBorder(new LineBorder(ColorPalette.BLACK, 1));
            panel.setLayout(new BorderLayout());

            Color c = (Color) al.get(i).get(i);
            JLabel jlabel = new JLabel();
            jlabel.setText(String.format(" %-20s  %3d,%3d,%3d", al.get(i).getName(), c.getRed(), c.getGreen(), c.getBlue()));
            jlabel.setIcon(new ImageIcon(Images.titaniumblocks16));
            jlabel.setForeground(new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue())); //c.darker().darker());
            jlabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
            jlabel.setBackground(c);
            panel.setBackground(c);
            panel.add(jlabel, BorderLayout.WEST);
//            System.out.println("     public static final Color "+alk.get(i).replace(" ", "")+" = new Color(" + String.format("%d,%d,%d",c.getRed(),c.getGreen(),c.getBlue() )+");");
            list.add(panel);
        }
        jScrollPane1.setViewportView(list);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
        JLabel jlabel = new JLabel();
        jlabel.setText("  Thanks to Chirag Mehta.");
        add(jlabel, BorderLayout.SOUTH);
        this.setIconImage(Images.titaniumblocks16);
        this.setSize(new Dimension(460, 800));
    }

    private void initComponents()
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TitaniumBlocks - ColorPaletteViewer");
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
            java.util.logging.Logger.getLogger(ColorPaletteViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ColorPaletteViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ColorPaletteViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ColorPaletteViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new ColorPaletteViewer().setVisible(true);
                } catch (NoSuchMethodException ex)
                {
                    Logger.getLogger(ColorPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex)
                {
                    Logger.getLogger(ColorPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex)
                {
                    Logger.getLogger(ColorPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex)
                {
                    Logger.getLogger(ColorPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex)
                {
                    Logger.getLogger(ColorPaletteViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
