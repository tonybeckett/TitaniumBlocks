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

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.pointers.types.CometPointer;
import us.jaba.titaniumblocks.core.pointers.types.DualLinesPointer;
import us.jaba.titaniumblocks.core.pointers.types.LinePointer;
import us.jaba.titaniumblocks.core.pointers.types.MonumentPointer;
import us.jaba.titaniumblocks.core.pointers.types.Pencil2Pointer;
import us.jaba.titaniumblocks.core.pointers.types.PencilPointer;
import us.jaba.titaniumblocks.core.pointers.types.TaperedDualLinePointer;
import us.jaba.titaniumblocks.core.pointers.types.ArrowHeadPointer;
import us.jaba.titaniumblocks.core.pointers.types.CircleOrbitPointer;
import us.jaba.titaniumblocks.core.pointers.types.CompassPointer;
import us.jaba.titaniumblocks.core.pointers.types.DiamondPointer;
import us.jaba.titaniumblocks.core.pointers.types.LineWithPaddleTailPointer;
import us.jaba.titaniumblocks.core.pointers.types.OutLinePointer;
import us.jaba.titaniumblocks.core.pointers.types.PaddlePointer;
import us.jaba.titaniumblocks.core.pointers.types.RoundedDashPointer;
import us.jaba.titaniumblocks.core.pointers.types.TaperedPointer;
import us.jaba.titaniumblocks.core.pointers.types.TaperedRoundedTailPointer;
import us.jaba.titaniumblocks.core.pointers.types.TaperedThickFlatPointer;
import us.jaba.titaniumblocks.core.pointers.types.TaperedThickPointer;
import us.jaba.titaniumblocks.core.pointers.types.ThickLinePointer;
import us.jaba.titaniumblocks.core.pointers.types.ThickRoundedDashPointer;
import us.jaba.titaniumblocks.core.pointers.types.ThinLineCircleTipPointer;
import us.jaba.titaniumblocks.core.pointers.types.ThinLinePointer;
import us.jaba.titaniumblocks.core.pointers.types.ThinRoundedDashPointer;
import us.jaba.titaniumblocks.core.pointers.types.WideTaperedPointPointer;

/**
 *
 * @author tbeckett
 */
public class PointerCoreInfo
{

    public static final Class<?>[] POINTER_MODELS =
    {
        ArrowHeadPointer.class,
        CircleOrbitPointer.class,
        CometPointer.class,
        CompassPointer.class,
        DiamondPointer.class,
        DualLinesPointer.class,
        LinePointer.class,
        LineWithPaddleTailPointer.class,
        MonumentPointer.class,
        NullPointer.class,
        OutLinePointer.class,
        PaddlePointer.class,
        Pencil2Pointer.class,
        PencilPointer.class,
        RoundedDashPointer.class,
        TaperedDualLinePointer.class,
        TaperedPointer.class,
        TaperedRoundedTailPointer.class,
        TaperedThickFlatPointer.class,
        TaperedThickPointer.class,
        ThickLinePointer.class,
        ThickRoundedDashPointer.class,
        ThinLineCircleTipPointer.class,
        ThinLinePointer.class,
        ThinRoundedDashPointer.class,
        WideTaperedPointPointer.class
    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(POINTER_MODELS);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }
}
