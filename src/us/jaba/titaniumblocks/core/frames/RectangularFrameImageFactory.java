/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.frames;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class RectangularFrameImageFactory extends CoreImageFactory
{

    public RectangularFrameImageFactory(RectangularFrame painter)
    {
        super(painter);
    }

    public RectangularFrame getPainter()
    {
        return (RectangularFrame) super.getPainter();
    }

}
