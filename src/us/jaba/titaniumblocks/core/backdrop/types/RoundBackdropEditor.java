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
package us.jaba.titaniumblocks.core.backdrop.types;

import java.awt.Component;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditorSupport;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import us.jaba.titaniumblocks.core.backdrop.types.round.NullBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.BasicBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.BrushedMetalBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.CarbonBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.LinenBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.NoisyPlasticBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.PunchedSteelBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.StainlessBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.StainlessGrindedBackdrop;

/**
 *
 * @author tbeckett
 */
public class RoundBackdropEditor extends PropertyEditorSupport
{

    Map<String, Backdrop> m = new HashMap();
    ArrayList<String> al = new ArrayList();

    public static final Class<?>[] ROUND_BACKDROPS =
    {
        BasicBackdrop.class,
        BrushedMetalBackdrop.class,
        CarbonBackdrop.class,
        LinenBackdrop.class,
        NoisyPlasticBackdrop.class,
        NullBackdrop.class,
        PunchedSteelBackdrop.class,
        StainlessBackdrop.class,
        StainlessGrindedBackdrop.class
    };

    public RoundBackdropEditor()
    {
        for (Class<?> b : ROUND_BACKDROPS)
        {
            try
            {
                String name = b.getClass().getSimpleName();
                Constructor c = b.getConstructor();

                m.put(name, (Backdrop) c.newInstance());
                al.add(name);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
            {
                Logger.getLogger(RoundBackdropEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Collections.sort(al);
    }

    private int selected = 0;

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        // intentional
    }

    @Override
    public String getAsText()
    {
        return al.get(selected);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        selected = al.indexOf(text);
    }

//    @Override
//    public Component getCustomEditor()
//    {
//        return null;
//    }
//
//    @Override
//    public String getJavaInitializationString()
//    {
//        return null;
//    }
//
    @Override    
    public String[] getTags()
    {
        return (String[]) al.toArray();
    }

//    @Override
//    public String[] getTags()
//    {
//        return null;
//    }
    @Override
    public Object getValue()
    {
        return m.get(al.get(selected));
    }

    @Override
    public void setValue(Object value)
    {
        for (String s : m.keySet())
        {
            if (m.get(s).equals(value))
            {
                selected = al.indexOf(s);
            }
        }
    }

    @Override
    public Component getCustomEditor()
    {
        return new JLabel("I want to be a custom editor");
    }

    @Override
    public boolean supportsCustomEditor()
    {
        return true;
    }
//    @Override
//    public boolean isPaintable()
//    {
//        return false;
//    }
//
//    @Override
//    public void paintValue(Graphics gfx, Rectangle box)
//    {
//
//    }
//
//    @Override
//    public void removePropertyChangeListener(PropertyChangeListener listener)
//    {
//
//    }
//
//    @Override
//    public boolean supportsCustomEditor()
//    {
//        return false;
//    }

}
