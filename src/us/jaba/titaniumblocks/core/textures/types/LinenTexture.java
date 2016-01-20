/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.textures.types;

import us.jaba.titaniumblocks.core.image.ImageSupport;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.filters.LinenFilter;
import us.jaba.titaniumblocks.core.filters.SSOrientation;
import us.jaba.titaniumblocks.core.textures.Texture;

/**
 *
 * @author tbeckett
 */
public class LinenTexture extends Texture
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

    public LinenTexture()
    {
        brushColor = ColorPalette.GRAY.brighter();
    }

    public LinenTexture(Color brushColor)
    {
        this.brushColor = brushColor;
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

        final BufferedImage IMAGE1 = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);
        final BufferedImage IMAGE2 = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);

        LinenFilter linenBrush = new LinenFilter();

        linenBrush.setColor(brushColor.getRGB());

        final AlphaComposite COMPOSITE = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        linenBrush.setShine(0.25f);
        linenBrush.setAmount(0.65f);
        linenBrush.setRadius(60);

        graphics.drawImage(linenBrush.filter(IMAGE1, IMAGE1), 0, 0, null);
        graphics.setComposite(COMPOSITE);

        linenBrush.setOrientation(SSOrientation.VERTICAL);
        linenBrush.setAmount(0.7f);
        linenBrush.setRadius(55);

        graphics.drawImage(linenBrush.filter(IMAGE2, IMAGE2), 0, 0, null);
        graphics.dispose();

    }

}
