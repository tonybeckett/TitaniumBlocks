/*
 * Copyright (c) 2015, Tony Beckett
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * The names of its contributors may not be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package us.jaba.titaniumblocks.core.pointers;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.Serializable;
import us.jaba.titaniumblocks.core.CoreBean;
import us.jaba.titaniumblocks.core.color.GradientPalette;

/**
 *
 * @author tbeckett
 */
public abstract class Pointer extends CoreBean implements Serializable
{

    protected boolean shadowActive;

    private boolean shadowChanged = true;

    public void copy(Pointer p)
    {
        //intentional
    }

  
    public abstract void setPrimaryColor(GradientPalette pointerColor);

    public abstract void setFrontScale(us.jaba.titaniumblocks.core.Scale scale);

    public abstract void setTailScale(us.jaba.titaniumblocks.core.Scale scale);

    public boolean isShadowActive()
    {
        return shadowActive;
    }

    public void setShadowActive(boolean shadowActive)
    {
        this.shadowActive = shadowActive;
        changed();
    }

    public void paintShadow(Graphics2D graphics, Dimension dimensions)
    {
        shadowChanged = false;
    }

    public boolean hasShadowChanged()
    {
        return shadowChanged;
    }

    @Override
    protected void setChanged(boolean state)
    {
        super.setChanged(state); 
        shadowChanged = state;
    }

    @Override
    protected void changed()
    {
        super.setChanged(true);
        shadowChanged = true;
    }
    
    
}
