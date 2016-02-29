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
package us.jaba.titaniumblocks.core.backdrop;

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.AntiqueBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BeigeBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BlackBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BlueBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BrassBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BronzeBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BrownBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BrushedMetalBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.CarbonBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.ChromeBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.CopperBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.CyanBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.DarkGrayBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.GoldBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.GreenBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.LightGrayBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.LinenBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.MagentaBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.MudBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.NoisyPlasticBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.PunchedSheetBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.RedBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.SatinGrayBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.StainlessBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.StainlessGrindedBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.TransparentBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.WhiteBModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.YellowBModel;

/**
 *
 * @author tbeckett
 */
public class BackdropCoreInfo
{

    public static final Class<?>[] BACKDROP_COLORS =
    {
        AntiqueBModel.class,
        BeigeBModel.class,
        BlackBModel.class,
        BlueBModel.class,
        BrassBModel.class,
        BronzeBModel.class,
        BrownBModel.class,
        BrushedMetalBModel.class,
        CarbonBModel.class,
        ChromeBModel.class,
        CopperBModel.class,
        CyanBModel.class,
        DarkGrayBModel.class,
        GoldBModel.class,
        GreenBModel.class,
        LightGrayBModel.class,
        LinenBModel.class,
        MagentaBModel.class,
        MudBModel.class,
        NoisyPlasticBModel.class,
        PunchedSheetBModel.class,
        RedBModel.class,
        SatinGrayBModel.class,
        StainlessBModel.class,
        StainlessGrindedBModel.class,
        TransparentBModel.class,
        WhiteBModel.class,
        YellowBModel.class
    };

    public static final Class<?>[] RECT_BACKDROP_MODELS =
    {
        us.jaba.titaniumblocks.core.backdrop.types.rectangular.BrushedMetalBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.rectangular.CarbonBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.rectangular.LinenBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.rectangular.NoisyPlasticBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.rectangular.NullBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.rectangular.PunchedSteelBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.rectangular.StainlessBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.rectangular.StainlessGrindedBackdrop.class
    };

    public static final Class<?>[] ROUND_BACKDROP_MODELS =
    {
        us.jaba.titaniumblocks.core.backdrop.types.round.BrushedMetalBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.round.CarbonBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.round.LinenBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.round.NoisyPlasticBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.round.NullBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.round.PunchedSteelBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.round.StainlessBackdrop.class,
        us.jaba.titaniumblocks.core.backdrop.types.round.StainlessGrindedBackdrop.class
    };

    public static List<Class<?>> getAvailableClasses()
    {
        List l = Arrays.asList(RECT_BACKDROP_MODELS);
        l.addAll(Arrays.asList(ROUND_BACKDROP_MODELS));
        return l;
    }

    public static List<Class<?>> getColorClasses()
    {
        return Arrays.asList(BACKDROP_COLORS);
    }

    public static List<Class<?>> getRoundModelClasses()
    {
        return Arrays.asList(ROUND_BACKDROP_MODELS);
    }

    public static List<Class<?>> getRectangularModelClasses()
    {
        return Arrays.asList(RECT_BACKDROP_MODELS);
    }

    public static List getInstanceOfColors()
    {
        return CoreInfoSupport.getInstanceOfEach(getColorClasses());

    }

    public static List getInstanceOfModels()
    {
        List l = CoreInfoSupport.getInstanceOfEach(getRoundModelClasses());
        l.addAll(CoreInfoSupport.getInstanceOfEach(getRectangularModelClasses()));
        return l;
    }

    public static List getInstanceOfRound()
    {
        return CoreInfoSupport.getInstanceOfEach(getRoundModelClasses());
    }
}
