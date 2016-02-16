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
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.WhiteBModel;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.frames.RoundFrame;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.knobs.KnobPainter;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.led.Led;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;
import us.jaba.titaniumblocks.swing.Antimate;
import us.jaba.titaniumblocks.swing.panels.round.SingleRoundPanel;

/**
 *
 * @author tbeckett
 */
public class SingleRoundDemo extends javax.swing.JFrame
{

    final SingleRoundPanel panel;

    /**
     * Creates new form DisplaySingleDemo
     */
    public SingleRoundDemo(CircularLayout cl)
    {
        initComponents();

       
        panel = new SingleRoundPanel(cl);

        panel.getGauge().getValueText().setColor(ColorPalette.ALMOND);
        panel.getGauge().getBackdrop().setBackgroundColor(new WhiteBModel());
        panel.init(100, 100);
        add(panel, BorderLayout.CENTER);
        this.setSize(new Dimension(500, 500 + 22)); // swing window heading removes 22 height

        Antimate antimate = new Antimate(100.0)
        {
            @Override
            public void update(double d)
            {
                panel.setValueAnimated(d);
            }
        };

        new Thread(antimate).start();

    }

    public void setBackdropPainter(Backdrop painter)
    {
        panel.setBackdropPainter(painter);
    }

    public void setFramePainter(RoundFrame linearFramePainter)
    {
        panel.setFrame(linearFramePainter);
    }

    public void setColor(Color c)
    {
        panel.setColor(c);
    }

    public void setPointerGradient(GradientPalette cp)
    {
        panel.setPointerGradient(cp);
    }

    public void setPanelTitle(String string)
    {
        super.setTitle(string);
    }

    protected void setTickmarks(AbstractRadialTickmark tickmarks)
    {
        panel.setTickmarks(tickmarks);
    }
    
    @Override
    public void setTitle(String string)
    {
        panel.setTitle(string);
       
    }

    public void setUnits(String units)
    {
        panel.setUnits(units);
    }

    public void setCenterPostPainter(Post postPainter)
    {
        panel.setCenterPostPainter(postPainter);
    }

    public void setSmallKnobsPainter(KnobPainter startPainter, KnobPainter endPainter)
    {
        panel.setSmallKnobsPainter(startPainter, endPainter);
    }

    public void setPointerPainter(Pointer pointerPainter, Pointer shadowPainter)
    {
        panel.setPointerPainter(pointerPainter, shadowPainter);
    }

    public void setLedPainter(Led ledPainter)
    {
        panel.setLedPainter(ledPainter);
    }

    public void setFrontCoverPainter(Frontcover foregroundPainter)
    {
        panel.setFrontCoverPainter(foregroundPainter);
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
        getContentPane().setLayout(new java.awt.GridLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
