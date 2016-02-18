/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.led;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class LedImageFactory extends CoreImageFactory
{
    public LedImageFactory(Led painter)
    {
        super(painter);
    }

    public Led getTickmark()
    {
        return (Led) super.getTickmark();  
    }
    
    
}