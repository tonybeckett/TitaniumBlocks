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

import us.jaba.titaniumblocks.swing.BasicVerticalViewer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.List;
import us.jaba.titaniumblocks.core.bargraph.leds.LedModel;
import us.jaba.titaniumblocks.core.bargraph.track.TrackImageFactory;
import us.jaba.titaniumblocks.core.bargraph.track.TrackModel;
import us.jaba.titaniumblocks.core.bargraph.track.BargraphTrackCoreInfo;
import us.jaba.titaniumblocks.core.color.ColorPalette;

/**
 *
 * @author tbeckett
 */
public class LedBargraphTrackViewer extends BasicVerticalViewer
{

    public LedBargraphTrackViewer()
    {
        backgroundColor = ColorPalette.GRAY;
        foregroundColor = ColorPalette.BLACK;
        List i = BargraphTrackCoreInfo.getInstanceOfEach();
         
        init("LedTackViewer", new Dimension(250, 250), i);

    }

    @Override
    protected String getClassNameFromInstance(Object o)
    {
        String s = null;
        if (o instanceof LedModel)
        {
            TrackModel pp = (TrackModel) o;
            s = pp.getClass().getSimpleName().replace("", "");
        }
        return s;
    }

    @Override
    protected BufferedImage getImageFromInstance(Object next, Dimension dim)
    {
        TrackModel pp = (TrackModel) next;
       
        return new TrackImageFactory(pp).build(dim);
    }

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
            java.util.logging.Logger.getLogger(LedBargraphTrackViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(LedBargraphTrackViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(LedBargraphTrackViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(LedBargraphTrackViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
      
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {

                new LedBargraphTrackViewer().setVisible(true);

            }
        });
    }

}
