
package us.jaba.titaniumblocks.core.pointers;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.CoreImageFactory;
import us.jaba.titaniumblocks.core.CoreModel;
import us.jaba.titaniumblocks.core.image.ImageSupport;

/**
 *
 * @author tbeckett
 */
public class ShadowPointerImageFactory extends CoreImageFactory
{

    public ShadowPointerImageFactory(CoreModel painter)
    {
        super(painter);
    }

  

    protected void applyShadow(BufferedImage result, Dimension dimensions)
    {
        final Graphics2D graphics2D = result.createGraphics();

        if (this.getTickmark() != null)
        {
            this.getTickmark().paintShadow(graphics2D, dimensions);
            graphics2D.dispose();
        }
    }

    @Override
    public Pointer getTickmark()
    {
        return (Pointer) super.getTickmark();  
    }

    @Override
    public BufferedImage build(Dimension dimensions)
    {
        if (!ImageSupport.isValidSize(dimensions.width, dimensions.height))
        {
            return ImageSupport.DEFAULT_SMALL_IMAGE;
        }

        if (this.getTickmark() != null && this.getTickmark().hasShadowChanged())
        {
            result = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);

            applyShadow(result, dimensions);
        }

        return result;
    }

}
