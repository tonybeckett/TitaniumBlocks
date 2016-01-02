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
package us.jaba.titaniumblocks.core.frontcover;

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.frontcover.models.rectangular.BasicLinearFrontcoverModel;
import us.jaba.titaniumblocks.core.frontcover.models.rectangular.NullFrontcoverModel;
import us.jaba.titaniumblocks.core.frontcover.models.round.BasicRadialForegroundPainter;
import us.jaba.titaniumblocks.core.frontcover.models.round.NWThirdRadialForegroundPainter;
import us.jaba.titaniumblocks.core.frontcover.models.round.TopHalfCurvedRadialForegroundPainter;
import us.jaba.titaniumblocks.core.frontcover.models.round.TopHalfRadialForegroundPainter;
import us.jaba.titaniumblocks.core.frontcover.models.round.TopThirdRadialForegroundPainter;
import us.jaba.titaniumblocks.core.frontcover.models.round.WestReflectiveRadialForegroundPainter;

/**
 *
 * @author tbeckett
 */
public class FrontcoverCoreInfo
{

    public static final Class<?>[] ROUND_MODELS =
    {
        BasicRadialForegroundPainter.class,
        NWThirdRadialForegroundPainter.class,
        TopHalfCurvedRadialForegroundPainter.class,
        TopHalfRadialForegroundPainter.class,
        TopThirdRadialForegroundPainter.class,
        WestReflectiveRadialForegroundPainter.class
    };

    public static final Class<?>[] RECT_MODELS =
    {
        BasicLinearFrontcoverModel.class,
        NullFrontcoverModel.class
    };

    public static List<Class<?>> getRoundModelClasses()
    {
        return Arrays.asList(ROUND_MODELS);
    }

    public static List<Class<?>> getRectangularModelClasses()
    {
        return Arrays.asList( RECT_MODELS);
    }

    public static List getInstanceOfModels()
    {
        List l = CoreInfoSupport.getInstanceOfEach(getRoundModelClasses());
        l.addAll(CoreInfoSupport.getInstanceOfEach(getRectangularModelClasses()));
        return l;
    }

}
