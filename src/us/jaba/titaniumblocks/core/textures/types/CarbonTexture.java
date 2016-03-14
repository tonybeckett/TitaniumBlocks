/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.textures.types;

import us.jaba.titaniumblocks.core.gradients.GradientSupport;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.textures.Texture;

/**
 *
 * @author tbeckett
 */
public class CarbonTexture extends Texture
{

    final float[] RULB_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    final Color[] RULB_COLORS =
    {
        new Color(35, 35, 35, 255),
        new Color(23, 23, 23, 255)
    };

    final float[] RULF_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    final Color[] RULF_COLORS =
    {
        new Color(38, 38, 38, 255),
        new Color(30, 30, 30, 255)
    };

    final float[] RLRB_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    final Color[] RLRB_COLORS =
    {
        new Color(35, 35, 35, 255),
        new Color(23, 23, 23, 255)
    };

    final float[] RLRF_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    final Color[] RLRF_COLORS =
    {
        new Color(38, 38, 38, 255),
        new Color(30, 30, 30, 255)
    };

    final float[] RURB_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    final Color[] RURB_COLORS =
    {
        new Color(48, 48, 48, 255),
        new Color(40, 40, 40, 255)
    };

    final float[] RURF_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    final Color[] RURF_COLORS =
    {
        new Color(53, 53, 53, 255),
        new Color(45, 45, 45, 255)
    };

    final float[] RLLB_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    final Color[] RLLB_COLORS =
    {
        new Color(48, 48, 48, 255),
        new Color(40, 40, 40, 255)
    };

    final float[] RLLF_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    final Color[] RLLF_COLORS =
    {
        new Color(53, 53, 53, 255),
        new Color(45, 45, 45, 255)
    };

    public void setColor(Color gradientStartColor)
    {
        //intentional
    }

    @Override
    public void paint(Graphics2D graphics2D, Dimension dimensions)
    {

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);

        final int resultWidth = (int) dimensions.getWidth();
        final int resultHeight = (int) dimensions.getHeight();

        Rectangle2D rect = new Rectangle2D.Double(resultWidth * 0.0, resultHeight * 0.0, resultWidth * 0.5, resultHeight * 0.5);

        GradientSupport.fillLinearYAxisRect(graphics2D, rect, RULB_FRACTIONS, RULB_COLORS);

//        final Rectangle2D RULB = new Rectangle2D.Double(resultWidth * 0.0, resultHeight * 0.0, resultWidth * 0.5, resultHeight * 0.5);
//        final Point2D RULB_START = new Point2D.Double(0, RULB.getBounds2D().getMinY());
//        final Point2D RULB_STOP = new Point2D.Double(0, RULB.getBounds2D().getMaxY());
//
//        final LinearGradientPaint RULB_GRADIENT = new LinearGradientPaint(RULB_START, RULB_STOP, RULB_FRACTIONS, RULB_COLORS);
//        graphics2D.setPaint(RULB_GRADIENT);
//        graphics2D.fill(RULB);
        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.08333333333333333,
                resultHeight * 0.0,
                resultWidth * 0.3333333333333333,
                resultHeight * 0.4166666666666667,
                RULF_FRACTIONS,
                RULF_COLORS
        );

//        final Rectangle2D RULF = new Rectangle2D.Double(resultWidth * 0.08333333333333333, resultHeight * 0.0, resultWidth * 0.3333333333333333, resultHeight * 0.4166666666666667);
//        final Point2D RULF_START = new Point2D.Double(0, RULF.getBounds2D().getMinY());
//        final Point2D RULF_STOP = new Point2D.Double(0, RULF.getBounds2D().getMaxY());
//
//        final LinearGradientPaint RULF_GRADIENT = new LinearGradientPaint(RULF_START, RULF_STOP, RULF_FRACTIONS, RULF_COLORS);
//        graphics2D.setPaint(RULF_GRADIENT);
//        graphics2D.fill(RULF);
        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.5,
                resultHeight * 0.5,
                resultWidth * 0.5,
                resultHeight * 0.5,
                RLRB_FRACTIONS,
                RLRB_COLORS
        );
//        final Rectangle2D RLRB = new Rectangle2D.Double(resultWidth * 0.5, resultHeight * 0.5, resultWidth * 0.5, resultHeight * 0.5);
//        final Point2D RLRB_START = new Point2D.Double(0, RLRB.getBounds2D().getMinY());
//        final Point2D RLRB_STOP = new Point2D.Double(0, RLRB.getBounds2D().getMaxY());
//
//        final LinearGradientPaint RLRB_GRADIENT = new LinearGradientPaint(RLRB_START, RLRB_STOP, RLRB_FRACTIONS, RLRB_COLORS);
//        graphics2D.setPaint(RLRB_GRADIENT);
//        graphics2D.fill(RLRB);

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.5833333333333334,
                resultHeight * 0.5,
                resultWidth * 0.3333333333333333,
                resultHeight * 0.4166666666666667,
                RLRF_FRACTIONS,
                RLRF_COLORS
        );
//        final Rectangle2D RLRF = new Rectangle2D.Double(resultWidth * 0.5833333333333334, resultHeight * 0.5, resultWidth * 0.3333333333333333, resultHeight * 0.4166666666666667);
//        final Point2D RLRF_START = new Point2D.Double(0, RLRF.getBounds2D().getMinY());
//        final Point2D RLRF_STOP = new Point2D.Double(0, RLRF.getBounds2D().getMaxY());
//
//        final LinearGradientPaint RLRF_GRADIENT = new LinearGradientPaint(RLRF_START, RLRF_STOP, RLRF_FRACTIONS, RLRF_COLORS);
//        graphics2D.setPaint(RLRF_GRADIENT);
//        graphics2D.fill(RLRF);

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.5,
                resultHeight * 0.0,
                resultWidth * 0.5,
                resultHeight * 0.5,
                RURB_FRACTIONS,
                RURB_COLORS
        );
//        final Rectangle2D RURB = new Rectangle2D.Double(resultWidth * 0.5, resultHeight * 0.0, resultWidth * 0.5, resultHeight * 0.5);
//        final Point2D RURB_START = new Point2D.Double(0, RURB.getBounds2D().getMinY());
//        final Point2D RURB_STOP = new Point2D.Double(0, RURB.getBounds2D().getMaxY());
//
//        final LinearGradientPaint RURB_GRADIENT = new LinearGradientPaint(RURB_START, RURB_STOP, RURB_FRACTIONS, RURB_COLORS);
//        graphics2D.setPaint(RURB_GRADIENT);
//        graphics2D.fill(RURB);

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.5833333333333334,
                resultHeight * 0.08333333333333333,
                resultWidth * 0.3333333333333333,
                resultHeight * 0.4166666666666667,
                RURF_FRACTIONS,
                RURF_COLORS
        );
//        final Rectangle2D RURF = new Rectangle2D.Double(resultWidth * 0.5833333333333334, resultHeight * 0.08333333333333333, resultWidth * 0.3333333333333333, resultHeight * 0.4166666666666667);
//        final Point2D RURF_START = new Point2D.Double(0, RURF.getBounds2D().getMinY());
//        final Point2D RURF_STOP = new Point2D.Double(0, RURF.getBounds2D().getMaxY());
//
//        final LinearGradientPaint RURF_GRADIENT = new LinearGradientPaint(RURF_START, RURF_STOP, RURF_FRACTIONS, RURF_COLORS);
//        graphics2D.setPaint(RURF_GRADIENT);
//        graphics2D.fill(RURF);

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.0,
                resultHeight * 0.5,
                resultWidth * 0.5,
                resultHeight * 0.5,
                RLLB_FRACTIONS,
                RLLB_COLORS
        );
//        final Rectangle2D RLLB = new Rectangle2D.Double(resultWidth * 0.0, resultHeight * 0.5, resultWidth * 0.5, resultHeight * 0.5);
//        final Point2D RLLB_START = new Point2D.Double(0, RLLB.getBounds2D().getMinY());
//        final Point2D RLLB_STOP = new Point2D.Double(0, RLLB.getBounds2D().getMaxY());
//
//        final LinearGradientPaint RLLB_GRADIENT = new LinearGradientPaint(RLLB_START, RLLB_STOP, RLLB_FRACTIONS, RLLB_COLORS);
//        graphics2D.setPaint(RLLB_GRADIENT);
//        graphics2D.fill(RLLB);

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.08333333333333333,
                resultHeight * 0.5833333333333334,
                resultWidth * 0.3333333333333333,
                resultHeight * 0.4166666666666667,
                RLLF_FRACTIONS,
                RLLF_COLORS
        );
//        final Rectangle2D RLLF = new Rectangle2D.Double(resultWidth * 0.08333333333333333, resultHeight * 0.5833333333333334, resultWidth * 0.3333333333333333, resultHeight * 0.4166666666666667);
//        final Point2D RLLF_START = new Point2D.Double(0, RLLF.getBounds2D().getMinY());
//        final Point2D RLLF_STOP = new Point2D.Double(0, RLLF.getBounds2D().getMaxY());
//
//        final LinearGradientPaint RLLF_GRADIENT = new LinearGradientPaint(RLLF_START, RLLF_STOP, RLLF_FRACTIONS, RLLF_COLORS);
//        graphics2D.setPaint(RLLF_GRADIENT);
//        graphics2D.fill(RLLF);

        graphics2D.dispose();

    }

}
