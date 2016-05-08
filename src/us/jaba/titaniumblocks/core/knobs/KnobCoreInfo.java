package us.jaba.titaniumblocks.core.knobs;


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
import us.jaba.titaniumblocks.core.knobs.painter.BigBlackKnob;
import us.jaba.titaniumblocks.core.knobs.painter.BigBrassKnob;
import us.jaba.titaniumblocks.core.knobs.painter.BigChromeKnob;
import us.jaba.titaniumblocks.core.knobs.painter.BigSilverKnob;
import us.jaba.titaniumblocks.core.knobs.painter.BlackMetalKnob;
import us.jaba.titaniumblocks.core.knobs.painter.BrassMetalKnob;
import us.jaba.titaniumblocks.core.knobs.painter.SilverMetalKnob;
import us.jaba.titaniumblocks.core.knobs.painter.SmallBlackKnob;
import us.jaba.titaniumblocks.core.knobs.painter.SmallBrassKnob;
import us.jaba.titaniumblocks.core.knobs.painter.SmallCopperKnob;
import us.jaba.titaniumblocks.core.knobs.painter.SmallNickelKnob;
import us.jaba.titaniumblocks.core.knobs.painter.SmallSilverKnob;
import us.jaba.titaniumblocks.core.knobs.painter.SmallWhiteKnob;

/**
 *
 * @author tbeckett
 */
public class KnobCoreInfo
{

    public static final Class<?>[] KNOB_MODELS =
    {
        BigBlackKnob.class,
        BigBrassKnob.class,
        BigChromeKnob.class,
        BigSilverKnob.class,
        BlackMetalKnob.class,
        BrassMetalKnob.class,
        SilverMetalKnob.class,
        SmallBlackKnob.class,
        SmallBrassKnob.class,
        SmallCopperKnob.class,
        SmallNickelKnob.class,
        SmallSilverKnob.class,
        SmallWhiteKnob.class
    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(KNOB_MODELS);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }
}
