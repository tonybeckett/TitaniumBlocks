/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.knobs;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class KnobImageFactory extends CoreImageFactory
{

    public KnobImageFactory(KnobPainter painter)
    {
        super(painter);
    }

    @Override
    public KnobPainter getPainter()
    {
        return (KnobPainter) super.getPainter();
    }

}
