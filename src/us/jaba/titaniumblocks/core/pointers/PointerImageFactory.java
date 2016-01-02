
package us.jaba.titaniumblocks.core.pointers;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class PointerImageFactory extends CoreImageFactory
{

    public PointerImageFactory(PointerPainter painter)
    {
        super(painter);
    }

    public PointerPainter getPainter()
    {
        return (PointerPainter) super.getBasePainter();
    }

}
