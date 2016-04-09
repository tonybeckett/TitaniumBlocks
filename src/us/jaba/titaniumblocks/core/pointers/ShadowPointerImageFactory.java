
package us.jaba.titaniumblocks.core.pointers;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.CoreImageFactory;
import us.jaba.titaniumblocks.core.CoreBean;
import us.jaba.titaniumblocks.core.image.ImageSupport;

/**
 *
 * @author tbeckett
 */
public class ShadowPointerImageFactory extends CoreImageFactory
{

    public ShadowPointerImageFactory(CoreBean painter)
    {
        super(painter);
    }

  

    protected void applyShadow(BufferedImage result, Dimension dimensions)
    {
        final Graphics2D graphics2D = result.createGraphics();

        if (this.getPainter() != null && this.getPainter().isShadowActive())
        {
            this.getPainter().paintShadow(graphics2D, dimensions);
            graphics2D.dispose();
        }
    }

    @Override
    public Pointer getPainter()
    {
        return (Pointer) super.getPainter();  
    }

    @Override
    public BufferedImage build(Dimension dimensions)
    {
        if (!ImageSupport.isValidSize(dimensions.width, dimensions.height))
        {
            return ImageSupport.DEFAULT_SMALL_IMAGE;
        }

        if (this.getPainter() != null && this.getPainter().hasShadowChanged())
        {
            result = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);

            applyShadow(result, dimensions);
        }

        return result;
    }

}
