package us.jaba.titaniumblocks.core.glow;

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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.filters.SSOrientation;
import static us.jaba.titaniumblocks.core.filters.SSOrientation.WEST;
import us.jaba.titaniumblocks.core.knobs.GaugeType;
import static us.jaba.titaniumblocks.core.knobs.GaugeType.TYPE1;
import static us.jaba.titaniumblocks.core.knobs.GaugeType.TYPE2;
import static us.jaba.titaniumblocks.core.knobs.GaugeType.TYPE3;
import static us.jaba.titaniumblocks.core.knobs.GaugeType.TYPE4;
import static us.jaba.titaniumblocks.core.knobs.GaugeType.TYPE5;
import us.jaba.titaniumblocks.core.color.ColorTools;

/**
 *
 * @author tbeckett
 */
public abstract class AbstractRadialKnobGlowPainter extends GlowPainter
{

    public GaugeType GAUGE_TYPE;
    boolean KNOBS;
    SSOrientation ORIENTATION;

    protected final float[] POST_GLOW_FRACTIONS =
    {
        0.0f,
        0.5f,
        1.0f
    };
    protected final Color[] POST_GLOW_COLORS =
    {
        new Color(0, 0, 0, 0),
        ColorTools.setAlpha(getGlowColor(), 0.0f),
        ColorTools.setAlpha(getGlowColor(), 0.3f)
    };

    protected final float[] CENTER_GLOW_FRACTIONS =
    {
        0.0f,
        0.50f,
        0.98f,
        1.0f
    };
    protected final Color[] CENTER_GLOW_COLORS =
    {
        ColorTools.setAlpha(getGlowColor(), 0.0f),
        ColorTools.setAlpha(getGlowColor(), 0.1f),
        ColorTools.setAlpha(getGlowColor(), 0.2f),
        ColorTools.setAlpha(getGlowColor(), 0.1f)
    };

    /**
     * Returns an image that simulates a glowing ring which could be used to
     * visualize a state of the gauge by a color. The LED might be too small if
     * you are not in front of the screen and so one could see the current state
     * more easy.
     *
     *
     * @return an image that simulates a glowing ring
     */
//    public BufferedImage createRadialGlow(final int width, final Color GLOW_COLOR, final boolean ON, final GaugeType GAUGE_TYPE, final boolean KNOBS, final SSOrientation ORIENTATION) {
//        if (width <= 0) {
//            return null;
//        }
//
//        // Take image from cache instead of creating a new one if parameters are the same as last time
//        if (radWidth == width && radGlowColor.equals(GLOW_COLOR) && radOn == ON && radGaugeType == GAUGE_TYPE && radKnobs == KNOBS && radOrientation == ORIENTATION) {
//            return radGlowImage;
//        }
//
//        radGlowImage.flush();
//        radGlowImage = UTIL.createImage(width, width, Transparency.TRANSLUCENT);
//        final Graphics2D graphics = radGlowImage.createGraphics();
    @Override
    public void paint(final Graphics2D graphics, final Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final Area GLOWRING = new Area(new Ellipse2D.Double(imageWidth * 0.0841121495, imageWidth * 0.0841121495, imageWidth * 0.8317757009, imageWidth * 0.8317757009));
        final Area TMP_RING = new Area(new Ellipse2D.Double(imageWidth * 0.1074766355, imageWidth * 0.1074766355, imageWidth * 0.785046729, imageWidth * 0.785046729));
        GLOWRING.subtract(TMP_RING);

        graphics.setColor(this.getGlowColor());
        if (!isActive())
        {
            final Point2D GLOWRING_OFF_START = new Point2D.Double(0, GLOWRING.getBounds2D().getMinY());
            final Point2D GLOWRING_OFF_STOP = new Point2D.Double(0, GLOWRING.getBounds2D().getMaxY());
            final float[] GLOWRING_OFF_FRACTIONS =
            {
                0.0f,
                0.17f,
                0.33f,
                0.34f,
                0.63f,
                0.64f,
                0.83f,
                1.0f
            };
            final Color[] GLOWRING_OFF_COLORS =
            {
                new Color(204, 204, 204, 102),
                new Color(153, 153, 153, 102),
                new Color(252, 252, 252, 102),
                new Color(255, 255, 255, 102),
                new Color(204, 204, 204, 102),
                new Color(203, 203, 203, 102),
                new Color(153, 153, 153, 102),
                new Color(255, 255, 255, 102)
            };
            final LinearGradientPaint GLOWRING_OFF_GRADIENT = new LinearGradientPaint(GLOWRING_OFF_START, GLOWRING_OFF_STOP, GLOWRING_OFF_FRACTIONS, GLOWRING_OFF_COLORS);
            graphics.setPaint(GLOWRING_OFF_GRADIENT);
            graphics.fill(GLOWRING);
        } else
        {
            final Point2D GLOWRING_ON_CENTER = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
            final float[] GLOWRING_ON_FRACTIONS =
            {
                0.0f,
                0.8999999f,
                0.9f,
                0.95f,
                1.0f
            };
            final Color[] GLOWRING_ON_COLORS =
            {
                ColorTools.setAlpha(getGlowColor(), 0.6f),
                ColorTools.setAlpha(getGlowColor(), 0.6f),
                ColorTools.setSaturation(getGlowColor(), 0.6f),
                getGlowColor(),
                ColorTools.setSaturation(getGlowColor(), 0.6f),
            };
            final Paint GLOWRING_ON_GRADIENT = new RadialGradientPaint(GLOWRING_ON_CENTER, (float) (0.4158878504672897 * imageWidth), GLOWRING_ON_FRACTIONS, GLOWRING_ON_COLORS);
            graphics.setPaint(GLOWRING_ON_GRADIENT);

            final BufferedImage CLIP_IMAGE_GLOWRING_ON;
//            CLIP_IMAGE_GLOWRING_ON = Shadow.INSTANCE.createSoftClipImage((Shape) GLOWRING, GLOWRING_ON_GRADIENT);

            graphics.translate(-16, -16);
//            graphics.drawImage(Shadow.INSTANCE.createDropShadow(CLIP_IMAGE_GLOWRING_ON, 0, 1.0f, 15, 315, getGlowColor()), GLOWRING.getBounds().x + 1, GLOWRING.getBounds().y + 1, null);
            graphics.translate(16, 16);

            paintGlow(graphics, dimensions);

           
        }

        // add a little highlight lower right
        final Area GLOWRING_HL = new Area(new Arc2D.Double(imageWidth * 0.0841121495, imageWidth * 0.0841121495, imageWidth * 0.8317757009, imageWidth * 0.8317757009, 270, 114, Arc2D.PIE));
        GLOWRING_HL.subtract(TMP_RING);

        final Point2D GLOWRING_HL_LOWERRIGHT_CENTER = new Point2D.Double((0.7336448598130841 * imageWidth), (0.8364485981308412 * imageHeight));
        final float[] GLOWRING_HL_LOWERRIGHT_FRACTIONS =
        {
            0.0f,
            1.0f
        };
        final Color[] GLOWRING_HL_LOWERRIGHT_COLORS =
        {
            new Color(255, 255, 255, 140),
            new Color(255, 255, 255, 0)
        };
        final Paint GLOWRING_HL_LOWERRIGHT_GRADIENT = new RadialGradientPaint(GLOWRING_HL_LOWERRIGHT_CENTER, (float) (0.23598130841121495 * imageWidth), GLOWRING_HL_LOWERRIGHT_FRACTIONS, GLOWRING_HL_LOWERRIGHT_COLORS);
        graphics.setPaint(GLOWRING_HL_LOWERRIGHT_GRADIENT);
        graphics.fill(GLOWRING_HL);

        graphics.dispose();
    }


    protected abstract void paintGlow(Graphics2D graphics, Dimension dimensions);

}
