/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.pointers;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.image.ImageSupport;


/**
 *
 * @author tbeckett
 */
public class ShadowPointerImageFactory
{

    PointerPainter painter = null;

    public ShadowPointerImageFactory()
    {

    }

    public ShadowPointerImageFactory(PointerPainter painter)
    {
        this.painter = painter;
    }

    protected void applyPaint(BufferedImage result, Dimension dimensions)
    {
        final Graphics2D graphics2D = result.createGraphics();

        if (painter != null)
        {
            painter.paint(graphics2D, dimensions);
        }
    }

    public BufferedImage build(Dimension dimensions)
    {
        if (!ImageSupport.isValidSize(dimensions.width, dimensions.height))
        {
            return ImageSupport.defaultSmallImage;
        }
        final BufferedImage result = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);

        applyPaint(result, dimensions);

        return result;
    }
//    private BufferedImage bufferedImage = ImageSupport.createImage(1, 1, Transparency.TRANSLUCENT);
//
//    private Dimension savedDimension = null;
//
//    public BufferedImage getBufferedImage()
//    {
//        return bufferedImage;
//    }
//
//    public void setBufferedImage(BufferedImage bufferedImage)
//    {
//        this.bufferedImage = bufferedImage;
//    }
//
//    protected void createKnob(final BufferedImage image, final Dimension dimension)
//    {
//
//    }
//
//    public BufferedImage create(final Dimension dimension)
//    {
//        if (!ImageSupport.isValidDim(dimension))
//        {
//            return ImageSupport.defaultSmallImage;
//        }
////        if (hasNotChanged(dimension, getModel()))
////        {
////            return getBufferedImage();
////        }
//
//        getBufferedImage().flush();
//        setBufferedImage(ImageSupport.createImage(SIZE, SIZE, Transparency.TRANSLUCENT));
//        createKnob(getBufferedImage(), dimension);
//        //        // Buffer current values
//        //        sizeBuffer = SIZE;
//        //        knobStyleBuffer = KNOB_STYLE;
//
//        return getBufferedImage();
//    }

//
//    private boolean hasNotChanged(Dimension dimension, BasicKnobModel model)
//    {
//        boolean answer = false;
//
//        if (dimension.equals(savedDimension) && model.equals(savedModel))
//        {
//            answer = true;
//        }
//        return answer;
//    }
//
//    protected void cacheSave(Dimension dimension, BasicKnobModel model)
//    {
//        this.savedModel = model;
//        this.savedDimension = dimension;
//    }
}
