/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.glow;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class GlowImageFactory extends CoreImageFactory
{

    public GlowImageFactory(GlowPainter painter)
    {
        super(painter);
    }

 
    public GlowPainter getPainter()
    {
        return (GlowPainter) super.getBasePainter(); 
    }
    
}

