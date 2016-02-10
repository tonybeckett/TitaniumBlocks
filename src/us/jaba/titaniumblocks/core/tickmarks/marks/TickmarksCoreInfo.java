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
package us.jaba.titaniumblocks.core.tickmarks.marks;

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.rectangular.HorizontalLinearTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.rectangular.HorizontalLogTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.rectangular.VerticalLinearTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.rectangular.VerticalLogTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.BasicClockTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.ClockNumbersTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.ClockTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.CompassTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.LevelTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.RLogMajMedMinorTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.RLogMajMinorTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.RNormalMajMedMinorTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.RNormalMajMinorTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.StopwatchSmallTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.StopwatchTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.WindDirectionTickmarks;

/**
 *
 * @author tbeckett
 */
public class TickmarksCoreInfo
{

    public static final Class<?>[] TICKMARK_CLASSES =
    {
        BasicClockTickmarks.class,
        ClockTickmarks.class,
        ClockNumbersTickmarks.class,
        CompassTickmarks.class,
        HorizontalLinearTickmark.class,
        HorizontalLogTickmark.class,
        LevelTickmarks.class,
        VerticalLinearTickmark.class,
        VerticalLogTickmark.class,
        RLogMajMedMinorTickmark.class,
        RLogMajMinorTickmark.class,
        RNormalMajMedMinorTickmark.class,
        RNormalMajMinorTickmark.class,
        StopwatchTickmarks.class,
        StopwatchSmallTickmarks.class,
        WindDirectionTickmarks.class
    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(TICKMARK_CLASSES);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }
}
