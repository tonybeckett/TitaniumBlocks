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
package us.jaba.titaniumblocks.swing.demos.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.frames.RoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.NullRoundFrame;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.swing.Antimate;
import us.jaba.titaniumblocks.swing.panels.round.ClockPanel;

/**
 *
 * @author tbeckett
 */
public class ClockDemo extends javax.swing.JFrame
{

    final ClockPanel panel;

    /**
     * Creates new form DisplaySingleDemo
     */
    public ClockDemo()
    {
        initComponents();

        panel = new ClockPanel(ColorPalette.WHITE);
        panel.setBackground(ColorPalette.WHITE);
        panel.setRoundFrame(new NullRoundFrame());
        
        panel.init(100, 100);
        add(panel, BorderLayout.CENTER);
        this.setSize(new Dimension(500, 500 + 22)); 
        this.setTitle("ClockDemo");
//       this.setIconImage(Images.titaniumblocks128);
        Antimate antimate = new Antimate(100.0, 0.1f)
        {
            @Override
            public void update(double d)
            {
               Calendar cal = Calendar.getInstance();
//                Date t = new Date();
                 
//                panel.setValueAnimated(t.getHours(),t.getMinutes(),t.getSeconds());
  

                 
                panel.setValueAnimated(cal.get(Calendar.HOUR) , cal.get(Calendar.MINUTE) , cal.get(Calendar.SECOND));
            }
        };

        new Thread(antimate).start();

    }

    public void setBackdrop(Backdrop painter)
    {
        panel.setBackdrop(painter);
    }

    public void setRoundFrame(RoundFrame linearFramePainter)
    {
        panel.setRoundFrame(linearFramePainter);
    }

    public void setColor(Color c)
    {
        panel.setColor(c);
    }

    public void setPointerGradient(GradientPalette cp)
    {
        panel.setPointerGradient(cp);
    }

   

     
    public void setCenterPost(Post postPainter)
    {
        panel.setCenterPost(postPainter);
    }

   

    public void setPointer(Pointer pointerPainter, Pointer shadowPainter)
    {
        panel.setPointer(pointerPainter, shadowPainter);
    }

     

    public void setFrontCover(Frontcover foregroundPainter)
    {
        panel.setFrontCover(foregroundPainter);
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

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
            java.util.logging.Logger.getLogger(SingleLineGaugeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SingleLineGaugeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SingleLineGaugeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SingleLineGaugeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ClockDemo().setVisible(true);
            }
        });
    }
}
