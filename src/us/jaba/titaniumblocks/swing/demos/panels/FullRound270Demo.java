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

import java.awt.Color;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.areas.AreaList;
import us.jaba.titaniumblocks.core.areas.types.round.BasicRadialArea;
import us.jaba.titaniumblocks.core.backdrop.types.round.NoisyPlasticBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlue;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureMagenta;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureOrange;
import us.jaba.titaniumblocks.core.frames.types.round.BlackMetalRoundFrame;
import us.jaba.titaniumblocks.core.frontcover.types.round.NullFrontcover;
import us.jaba.titaniumblocks.core.glow.types.RadialGlow;
import us.jaba.titaniumblocks.core.knobs.painter.BrassMetalKnob;
import us.jaba.titaniumblocks.core.knobs.painter.SmallWhiteKnob;
import us.jaba.titaniumblocks.core.layout.CircularTwoPostLayout;
import us.jaba.titaniumblocks.core.led.types.RoundDialLed;
import us.jaba.titaniumblocks.core.markers.types.BasicMarker;
import us.jaba.titaniumblocks.core.markers.types.BasicThreshold;
import us.jaba.titaniumblocks.core.math.Angle;
import us.jaba.titaniumblocks.core.math.CoordinateDefs.Direction;
import us.jaba.titaniumblocks.core.posts.types.MetalBlackPost;
import us.jaba.titaniumblocks.core.sections.SectionList;
import us.jaba.titaniumblocks.core.sections.types.round.BasicRadialSection;

/**
 *
 * @author tbeckett
 */
public class FullRound270Demo extends FullRoundDemo
{

    /**
     * Creates new form DisplaySingleDemo
     */
    public FullRound270Demo()
    {

        super(new CircularTwoPostLayout(225, 135, Direction.CLOCKWISE, 0.95f, 220, 140));
//        super(new CircularTwoPostLayout(225, 315, Direction.CLOCKWISE, 0.95f, 230, 310));
        setTitle("270");
        setPanelTitle("SingleRound270Demo");
        this.setFrame(new BlackMetalRoundFrame());
        NoisyPlasticBackdrop bp = new NoisyPlasticBackdrop();

//        this.setBackdrop(bp);
        this.setCenterPost(new MetalBlackPost());
//        this.setSmallKnobsPainter( new SmallWhiteKnobPainter(), new SmallWhiteKnobPainter());
//        this.setColor(ColorPalette.DARKBLUE);
//        this.setPointerPainter(new DualLinesPointer(), new DualLinesShadow());
//        this.setPointerGradient( new PureRed());
        this.panel.setFrontCover(new NullFrontcover());

        this.setUnits("degrees");
//        this.setLedPainter(new NullLed());

        SectionList sl = new SectionList();

        sl.add(new BasicRadialSection(225.0, 345.0, Color.GREEN, 0.85, 0.925));
        sl.add(new BasicRadialSection(345.0, 65.0, Color.YELLOW, 0.85, 0.925));
        sl.add(new BasicRadialSection(65.0, 135.0, Color.RED, 0.85, 0.925));
        this.panel.setSectionList(sl);

        AreaList al = new AreaList();
        BasicRadialArea bra = new BasicRadialArea(65.0, 135.0, Color.RED, 0.85);
        bra.setOpacity(0.18f);
        al.add(bra);
        this.panel.setAreaList(al);

        this.panel.setLed1(new RoundDialLed());

        RoundDialLed rdl = new RoundDialLed();
        rdl.setAngle(new Angle(285.0));
        this.panel.setLed2(rdl);

        BrassMetalKnob knob = new BrassMetalKnob();
        knob.setAngle(new Angle(140.0));
        knob.setRadiusAdjust(new Scale(0.9));
        this.panel.setKnob1(knob);

        SmallWhiteKnob bknob = new SmallWhiteKnob();
        bknob.setAngle(new Angle(220.0));
        bknob.setRadiusAdjust(new Scale(0.9));
        this.panel.setKnob2(bknob);

        BasicMarker bm = new BasicMarker();
//        bm.setThreeD(true);
        bm.setColor(new PureBlue());
        bm.setOutlineColor(ColorPalette.WHITE);
        bm.setShowOutline(true);
        this.panel.setMarker1(bm);
        this.panel.setMarker1Value(60.0);

        bm = new BasicMarker();
        bm.setThreeD(true);
        bm.setColor(new PureMagenta());
        this.panel.setMarker2(bm);
        this.panel.setMarker2Value(65.0);

        BasicThreshold bt = new BasicThreshold();
        bt.setThreeD(true);
        bt.setColor(new PureOrange());
        this.panel.setThreshold(bt);
        this.panel.setThresholdValue(20.0);
        
        RadialGlow rg = new RadialGlow();
 //       rg.setActive(true);
        this.panel.setGlow(rg);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FullRound270Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FullRound270Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FullRound270Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FullRound270Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FullRound270Demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
