/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.disabled;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

/**
 *
 * @author tbeckett
 */
public final class NullDisabledImageFactory extends DisabledImageFactory
{
    public NullDisabledImageFactory(DisabledPainter painter)
    {
        super(painter);
    }

    @Override
    public BufferedImage build(Dimension dimensions)
    {
        return DEFAULT_NULL_IMAGE;
    }
    
    
}
