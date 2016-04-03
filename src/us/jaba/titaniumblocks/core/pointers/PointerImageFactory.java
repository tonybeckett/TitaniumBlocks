
package us.jaba.titaniumblocks.core.pointers;

import us.jaba.titaniumblocks.core.CoreImageFactory;

/**
 *
 * @author tbeckett
 */
public class PointerImageFactory extends CoreImageFactory
{

    public PointerImageFactory()
    {
        this(new NullPointer());
    }

    public PointerImageFactory(Pointer painter)
    {
        super(painter);
    }

    @Override
    public Pointer getPainter()
    {
        return (Pointer) super.getPainter();
    }

}
