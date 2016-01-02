/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.textures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.filters.BrushedMetalFilter;

/**
 *
 * @author tbeckett
 */
public class BrushedMetalTextureImageBuilder extends TextureImageBuilder
{

    BrushedMetalFilter filter;

    private Color brushColor;
    private float shine;
    private float amount;
    private boolean monochrome;
    private int radius;

    public BrushedMetalTextureImageBuilder(Color brushColor, float amount, float shine, boolean monochrome, int radius)
    {
        super(new NullTexturePainter());
        this.brushColor = brushColor;
        this.amount = amount;
        this.monochrome = monochrome;
        this.radius = radius;
        this.shine = shine;
        filter = new BrushedMetalFilter();
    }

    public BrushedMetalTextureImageBuilder(Color brushColor)
    {
        this(brushColor, 0.1f, 0.3f, true, 5);
    }

    public BrushedMetalTextureImageBuilder()
    {
        this(Color.lightGray);
    }

    /**
     * Creates a texture with a brushed metal look. The code originaly comes
     * from Jerry Huxtable. If you don't know his Java image related stuff you
     * have to check out http://huxtable.com/
     *
     * @param result
     * @param dimensions
     */
    @Override
    protected void applyPaint(BufferedImage result, Dimension dimensions)
    {

        filter.setColor(brushColor.getRGB());

        filter.setAmount(amount);
        filter.setMonochrome(monochrome);
        filter.setShine(shine);
        filter.setRadius(radius);

        filter.filter(result, result);
    }

    public Color getBrushColor()
    {
        return brushColor;
    }

    public void setBrushColor(Color brushColor)
    {
        this.brushColor = brushColor;
   
    }

}
