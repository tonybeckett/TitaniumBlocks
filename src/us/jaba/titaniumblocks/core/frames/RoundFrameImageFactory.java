/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.frames;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class RoundFrameImageFactory extends CoreImageFactory
{

    public RoundFrameImageFactory(RoundFrame painter)
    {
        super(painter);
    }

   
    public RoundFrame getRoundFrame()
    {
        return (RoundFrame) super.getTickmark();
    }

    @Override
    protected void applyPaint(BufferedImage result, Dimension dimensions)
    {
         System.out.println(dimensions.toString());
        super.applyPaint(result, dimensions); //To change body of generated methods, choose Tools | Templates.
    }

    

}
