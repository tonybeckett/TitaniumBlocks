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
public class LinearTickImageFactory extends CoreImageFactory
{

    public LinearTickImageFactory(LinearTickModel painter)
    {
        super(painter);
    }

    public LinearTickModel getTickmark()
    {
        return (LinearTickModel) super.getTickmark();
    }

}
