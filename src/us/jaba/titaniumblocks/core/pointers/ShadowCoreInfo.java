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
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type10ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type11ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type12ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type13ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type14ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type15ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type1ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type2ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type3ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type4ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type5ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type6ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type7ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type8ShadowPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type9ShadowPointerPainter;

/**
 *
 * @author tbeckett
 */
public class ShadowCoreInfo
{
    public static final Class<?>[] SHADOW_MODELS =
    {
        Type1ShadowPointerPainter.class,
        Type2ShadowPointerPainter.class,
        Type3ShadowPointerPainter.class,
        Type4ShadowPointerPainter.class,
        Type5ShadowPointerPainter.class,
        Type6ShadowPointerPainter.class,
        Type7ShadowPointerPainter.class,
        Type8ShadowPointerPainter.class,
        Type9ShadowPointerPainter.class,
        Type10ShadowPointerPainter.class,
        Type11ShadowPointerPainter.class,
        Type12ShadowPointerPainter.class,
        Type13ShadowPointerPainter.class,
        Type14ShadowPointerPainter.class,
        Type15ShadowPointerPainter.class,
         
    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(SHADOW_MODELS);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }
}
