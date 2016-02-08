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
public class RoundFrameImageFactory extends CoreImageFactory
{

    public RoundFrameImageFactory(RoundFrame painter)
    {
        super(painter);
    }

    @Override
    public RoundFrame getPainter()
    {
        return (RoundFrame) super.getPainter();
    }

}
