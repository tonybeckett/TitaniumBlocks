/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.tickmarks.ticks;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class RadialTickImageFactory extends CoreImageFactory
{

    public RadialTickImageFactory(RadialTickModel painter)
    {
        super(painter);
    }

    @Override
    public RadialTickModel getPainter()
    {
        return (RadialTickModel) super.getPainter();
    }

}
