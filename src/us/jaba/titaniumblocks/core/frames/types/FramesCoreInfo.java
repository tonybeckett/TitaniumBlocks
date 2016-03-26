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
package us.jaba.titaniumblocks.core.frames.types;

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.frames.types.rectangular.AnthraciteLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.BlackMetalLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.BrassLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.ChromeLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.GlossyMetalLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.GoldLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.MetalLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.NullLinearlFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.ShinyMetalLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.SilverLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.SteelLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.TiltedBlackLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.rectangular.TiltedGrayLinearFrame;
import us.jaba.titaniumblocks.core.frames.types.round.AnthraciteRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.BasicRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.BlackMetalRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.BrassRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.ChromeRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.GlossyMetalRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.GoldRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.MetalRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.NullRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.ShinyMetalRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.SilverRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.SteelRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.TiltedBlackRoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.TiltedGrayRoundFrame;

/**
 *
 * @author tbeckett
 */
public class FramesCoreInfo
{

    public static final Class<?>[] ROUND_MODELS =
    {
        AnthraciteRoundFrame.class,
        BasicRoundFrame.class,
        BlackMetalRoundFrame.class,
        BrassRoundFrame.class,
        ChromeRoundFrame.class,
        GlossyMetalRoundFrame.class,
        GoldRoundFrame.class,
        MetalRoundFrame.class,
        NullRoundFrame.class,
        ShinyMetalRoundFrame.class,
        SilverRoundFrame.class,
        SteelRoundFrame.class,
        TiltedBlackRoundFrame.class,
        TiltedGrayRoundFrame.class
    };

    public static final Class<?>[] RECTANGUALR_MODELS =
    {
        AnthraciteLinearFrame.class,
        BlackMetalLinearFrame.class,
        BrassLinearFrame.class,
        ChromeLinearFrame.class,
        GlossyMetalLinearFrame.class,
        GoldLinearFrame.class,
        MetalLinearFrame.class,
        NullLinearlFrame.class,
        ShinyMetalLinearFrame.class,
        SilverLinearFrame.class,
        SteelLinearFrame.class,
        TiltedBlackLinearFrame.class,
        TiltedGrayLinearFrame.class
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

    public static List getInstanceOfEachRound()
    {
        return CoreInfoSupport.getInstanceOfEach(getRoundClasses());
    }
    
    public static List getInstanceOfEachRectangular()
    {
        return CoreInfoSupport.getInstanceOfEach(getRectangularClasses());
    }

}
