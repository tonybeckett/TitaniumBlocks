
package us.jaba.titaniumblocks.core.pointers;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class PointerImageFactory extends CoreImageFactory
{

    public PointerImageFactory(Pointer painter)
    {
        super(painter);
    }

    public Pointer getPainter()
    {
        return (Pointer) super.getBasePainter();
    }

}
