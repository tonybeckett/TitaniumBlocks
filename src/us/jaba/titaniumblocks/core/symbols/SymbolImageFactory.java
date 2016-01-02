/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.symbols;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class SymbolImageFactory extends CoreImageFactory
{
    public SymbolImageFactory(SymbolPainter painter)
    {
        super(painter);
    }

    
    public SymbolPainter getPainter()
    {
        return (SymbolPainter) getBasePainter(); 
    }
    
    
}
