package us.jaba.titaniumblocks.core.glow;


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
import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.glow.painters.BasicGlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.LCDGlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.LinearGlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.RadialGlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.RadialType1GlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.RadialType2GlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.RadialType3GlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.RadialType4GlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.RadialType5OtherGlowPainter;
import us.jaba.titaniumblocks.core.glow.painters.RadialType5WestGlowPainter;

/**
 *
 * @author tbeckett
 */
public class GlowCoreInfo
{

    public static final Class<?>[] GLOW_MODELS =
    {
        BasicGlowPainter.class,
        LCDGlowPainter.class,
        LinearGlowPainter.class,
        RadialGlowPainter.class,
        RadialType1GlowPainter.class,
        RadialType2GlowPainter.class,
        RadialType3GlowPainter.class,
        RadialType4GlowPainter.class,
        RadialType5OtherGlowPainter.class,
        RadialType5WestGlowPainter.class
    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(GLOW_MODELS);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }
}
