/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.textures.painters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.gradients.GradientSupport;
import us.jaba.titaniumblocks.core.textures.TexturePainter;

/**
 *
 * @author tbeckett
 */
public class PunchedSheetTexturePainter extends TexturePainter
{

    private Color brushColor;

    public Color getBrushColor()
    {
        return brushColor;
    }

    public void setBrushColor(Color brushColor)
    {
        this.brushColor = brushColor;
    }

    public PunchedSheetTexturePainter()
    {
        brushColor = new Color(0x1D2123);
    }

    public PunchedSheetTexturePainter(Color brushColor)
    {
        this.brushColor = brushColor;
    }

    static final float[] FRACTIONS =
    {
        0.0f,
        1.0f
    };
    static final Color[] COLORS =
    {
        new Color(0, 0, 0, 255),
        new Color(68, 68, 68, 255)
    };

    @Override
    public void paint(Graphics2D graphics2D, Dimension dimensions)
    {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int resultWidth = (int) dimensions.getWidth();
        final int resultHeight = (int) dimensions.getHeight();

        final Rectangle2D rect = new Rectangle2D.Double(0.0, 0.0, resultWidth, resultHeight);
        graphics2D.setColor(brushColor);
        graphics2D.fill(rect);

        //final Color DARK = new Color(0x050506);
        final Color darkColor = brushColor.darker().darker();

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.0,
                resultHeight * 0.06666667014360428,
                resultWidth * 0.4000000059604645,
                resultHeight * 0.4000000059604645,
                FRACTIONS,
                COLORS
        );
//        final Ellipse2D ULB = new Ellipse2D.Double(imageWidth * 0.0, imageHeight * 0.06666667014360428, imageWidth * 0.4000000059604645, imageHeight * 0.4000000059604645);
//        final Point2D ULB_START = new Point2D.Double(0, ULB.getBounds2D().getMinY());
//        final Point2D ULB_STOP = new Point2D.Double(0, ULB.getBounds2D().getMaxY());
//        final LinearGradientPaint ULB_GRADIENT = new LinearGradientPaint(ULB_START, ULB_STOP, FRACTIONS, COLORS);
//        graphics2D.setPaint(ULB_GRADIENT);
//        graphics2D.fill(ULB);

        final Ellipse2D ULF = new Ellipse2D.Double(resultWidth * 0.0,
                resultHeight * 0.0,
                resultWidth * 0.4000000059604645,
                resultHeight * 0.4000000059604645);
        graphics2D.setColor(darkColor);
        graphics2D.fill(ULF);

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.46666666865348816,
                resultHeight * 0.5333333611488342,
                resultWidth * 0.4000000059604645,
                resultHeight * 0.3999999761581421,
                FRACTIONS,
                COLORS
        );
//        final Ellipse2D LRB = new Ellipse2D.Double(resultWidth * 0.46666666865348816, resultHeight * 0.5333333611488342, resultWidth * 0.4000000059604645, resultHeight * 0.3999999761581421);
//        final Point2D LRB_START = new Point2D.Double(0, LRB.getBounds2D().getMinY());
//        final Point2D LRB_STOP = new Point2D.Double(0, LRB.getBounds2D().getMaxY());
//        final LinearGradientPaint LRB_GRADIENT = new LinearGradientPaint(LRB_START, LRB_STOP, FRACTIONS, COLORS);
//        graphics2D.setPaint(LRB_GRADIENT);
//        graphics2D.fill(LRB);

        final Ellipse2D LRF = new Ellipse2D.Double(resultWidth * 0.46666666865348816,
                resultHeight * 0.46666666865348816,
                resultWidth * 0.4000000059604645,
                resultHeight * 0.4000000059604645);
        graphics2D.setColor(darkColor);
        graphics2D.fill(LRF);

        graphics2D.dispose();

    }

}
