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
package us.jaba.titaniumblocks.core.frames.effects;

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.frames.effects.rectangular.LinearBulgeEffectPainter;
import us.jaba.titaniumblocks.core.frames.effects.rectangular.LinearConeEffectPainter;
import us.jaba.titaniumblocks.core.frames.effects.rectangular.LinearInnerEffectPainter;
import us.jaba.titaniumblocks.core.frames.effects.rectangular.LinearTorusEffectPainter;
import us.jaba.titaniumblocks.core.frames.effects.rectangular.NoEffectPainter;
import us.jaba.titaniumblocks.core.frames.effects.round.RadialBulgeEffectPainter;
import us.jaba.titaniumblocks.core.frames.effects.round.RadialConeEffectPainter;
import us.jaba.titaniumblocks.core.frames.effects.round.RadialInnerEffectPainter;
import us.jaba.titaniumblocks.core.frames.effects.round.RadialTorusEffectPainter;

/**
 *
 * @author tbeckett
 */
public class EffectCoreInfo
{

    public static final Class<?>[] RECTANGUALR_MODELS =
    {
        LinearBulgeEffectPainter.class,
        LinearConeEffectPainter.class,
        LinearInnerEffectPainter.class,
        LinearTorusEffectPainter.class,
        NoEffectPainter.class
    };

    public static final Class<?>[] ROUND_MODELS =
    {
        RadialBulgeEffectPainter.class,
        RadialConeEffectPainter.class,
        RadialInnerEffectPainter.class,
        RadialTorusEffectPainter.class
    };

    public static List<Class<?>> getRoundClasses()
    {
        return Arrays.asList(ROUND_MODELS);
    }

    public static List<Class<?>> getRectangularClasses()
    {
        return Arrays.asList(RECTANGUALR_MODELS);
    }

    public static List<Class<?>> getAvailableClasses()
    {
        List l = getRoundClasses();
        l.addAll(getRectangularClasses());

        return l;
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }
}
