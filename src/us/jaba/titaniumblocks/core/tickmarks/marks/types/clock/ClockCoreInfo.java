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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.clock;

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.BasicClock;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.NumbersOut;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.ClockNumbersTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.ClockTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.DashAndCircles;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.DashCirclesTicks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.DotsAndCircles;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.FourNumbersCircleTicks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.FourNumbersTicks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.NullClock;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.Numbers;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.NumbersCirclesDash;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.NumbersInCircle;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.NumbersInDoubleCircle;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.OnlyTicksOn30;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.RomanNumbers;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.RomanNumbersDoubleCircle;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.RomanNumbersTicks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.SixNumbersTicks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.TwoBigNumbersTicks;

/**
 *
 * @author tbeckett
 */
public class ClockCoreInfo
{

    public static final Class<?>[] CLOCKMARK_CLASSES =
    {
        BasicClock.class,
        ClockTickmarks.class,
        ClockNumbersTickmarks.class,
        DashAndCircles.class,
        DotsAndCircles.class,
        DashCirclesTicks.class,
        FourNumbersCircleTicks.class,
        FourNumbersTicks.class,
        NullClock.class,
        Numbers.class,
        NumbersCirclesDash.class,
        NumbersOut.class,
        NumbersInCircle.class,
        NumbersInDoubleCircle.class,
        OnlyTicksOn30.class,
        RomanNumbers.class,
        RomanNumbersTicks.class,
        SixNumbersTicks.class,
        TwoBigNumbersTicks.class,
        RomanNumbersDoubleCircle.class
        
    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(CLOCKMARK_CLASSES);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }
}
