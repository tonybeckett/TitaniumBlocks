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
package us.jaba.titaniumblocks.core.symbols;

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import static us.jaba.titaniumblocks.core.led.LedCoreInfo.LED_MODELS;
import us.jaba.titaniumblocks.core.symbols.painters.ABS;
import us.jaba.titaniumblocks.core.symbols.painters.AirConditioning;
import us.jaba.titaniumblocks.core.symbols.painters.Airbag;
import us.jaba.titaniumblocks.core.symbols.painters.ArrowEast;
import us.jaba.titaniumblocks.core.symbols.painters.ArrowNorth;
import us.jaba.titaniumblocks.core.symbols.painters.ArrowNorthEast;
import us.jaba.titaniumblocks.core.symbols.painters.ArrowNorthWest;
import us.jaba.titaniumblocks.core.symbols.painters.ArrowSouth;
import us.jaba.titaniumblocks.core.symbols.painters.ArrowSouthEast;
import us.jaba.titaniumblocks.core.symbols.painters.ArrowSouthWest;
import us.jaba.titaniumblocks.core.symbols.painters.ArrowWest;
import us.jaba.titaniumblocks.core.symbols.painters.Attention;
import us.jaba.titaniumblocks.core.symbols.painters.Battery;
import us.jaba.titaniumblocks.core.symbols.painters.Break;
import us.jaba.titaniumblocks.core.symbols.painters.ESP;
import us.jaba.titaniumblocks.core.symbols.painters.Engine;
import us.jaba.titaniumblocks.core.symbols.painters.FogLight;
import us.jaba.titaniumblocks.core.symbols.painters.Fuel;
import us.jaba.titaniumblocks.core.symbols.painters.Glaze;
import us.jaba.titaniumblocks.core.symbols.painters.HighBeamLight;
import us.jaba.titaniumblocks.core.symbols.painters.Horn;
import us.jaba.titaniumblocks.core.symbols.painters.LowBeamLight;
import us.jaba.titaniumblocks.core.symbols.painters.Oil;
import us.jaba.titaniumblocks.core.symbols.painters.Seatbelt;
import us.jaba.titaniumblocks.core.symbols.painters.Slickness;
import us.jaba.titaniumblocks.core.symbols.painters.Temperature;
import us.jaba.titaniumblocks.core.symbols.painters.TurnLight;
import us.jaba.titaniumblocks.core.symbols.painters.Wiper;
import us.jaba.titaniumblocks.core.utils.ClassFinder;

/**
 *
 * @author tbeckett
 */
public class SymbolCoreInfo
{

    public static final Class<?>[] SYMBOLS_MODELS =
    {
        ABS.class,
        Airbag.class,
        AirConditioning.class,
        ArrowEast.class,
        ArrowNorth.class,
        ArrowNorthEast.class,
        ArrowNorthWest.class,
        ArrowSouth.class,
        ArrowSouthEast.class,
        ArrowSouthWest.class,
        ArrowWest.class,
        Attention.class,
        Battery.class,
        Break.class,
        Engine.class,
        ESP.class,
        FogLight.class,
        Fuel.class,
        Glaze.class,
        HighBeamLight.class,
        Horn.class,
        LowBeamLight.class,
        Oil.class,
        Seatbelt.class,
        Slickness.class,
        Temperature.class,
        TurnLight.class,
        Wiper.class,
    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(SYMBOLS_MODELS);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }
}
