/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core;

import us.jaba.titaniumblocks.core.image.ImageSupport;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 *
 * @author tbeckett
 */
public class CoreImageFactory
{
    protected static final BufferedImage DEFAULT_NULL_IMAGE = ImageSupport.defaultSmallImage;
    private Painter painter = null;
    private BufferedImage backgroundImage = null;
    public BufferedImage result;

    public CoreImageFactory()
    {

    }

    protected CoreImageFactory(Painter painter)
    {
        this.painter = painter;
        result = ImageSupport.defaultSmallImage;
    }

    protected void applyPaint(BufferedImage result, Dimension dimensions)
    {
        final Graphics2D graphics2D = result.createGraphics();

        if (painter != null)
        {
            painter.paint(graphics2D, dimensions);
            graphics2D.dispose();
        }

        if (backgroundImage != null)
        {
            final Graphics2D graphics = backgroundImage.createGraphics();
            graphics.drawImage(result, 0, 0, null);
            graphics.dispose();
        }
    }

    public BufferedImage build(Dimension dimensions)
    {
        if (!ImageSupport.isValidSize(dimensions.width, dimensions.height))
        {
            return ImageSupport.defaultSmallImage;
        }
        if (painter != null && painter.hasChanged())
        {
            result = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);

            applyPaint(result, dimensions);
        }
        return result;
    }

    protected Painter getBasePainter()
    {
        return painter;
    }

    public void setBackgroundImage(BufferedImage backgroundImage)
    {
        this.backgroundImage = backgroundImage;
    }

    public BufferedImage getBackgroundImage()
    {
        return backgroundImage;
    }

}
