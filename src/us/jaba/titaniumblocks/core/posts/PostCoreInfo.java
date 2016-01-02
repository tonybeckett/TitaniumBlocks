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
package us.jaba.titaniumblocks.core.posts;

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.posts.painters.BigBlackPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.BigBrassPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.BigChromePostPainter;
import us.jaba.titaniumblocks.core.posts.painters.BigCopperPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.BigGoldPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.BigSilverPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.MetalBlackPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.MetalBrassPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.MetalCopperPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.MetalGoldPostPainter;
import us.jaba.titaniumblocks.core.posts.painters.MetalSilverPostPainter;
import us.jaba.titaniumblocks.core.posts.positioned.CenterPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.EastPostFactory;

import us.jaba.titaniumblocks.core.posts.positioned.MaxBottomPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.MaxCenterBottomPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.MaxCenterTopPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.MaxRightPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.MinBottomPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.MinLeftPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.NorthPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.WestPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.SmallMaxRightPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.SmallMinLeftPostFactory;
import us.jaba.titaniumblocks.core.posts.positioned.SouthPostFactory;

/**
 *
 * @author tbeckett
 */
public class PostCoreInfo
{

    public static final Class<?>[] POST_MODELS =
    {
        BigBlackPostPainter.class,
        BigBrassPostPainter.class,
        BigChromePostPainter.class,
        BigCopperPostPainter.class,
        BigGoldPostPainter.class,
        BigSilverPostPainter.class,
        MetalBlackPostPainter.class,
        MetalBrassPostPainter.class,
        MetalCopperPostPainter.class,
        MetalGoldPostPainter.class,
        MetalSilverPostPainter.class
    };

    public static final Class<?>[] POSITIONED_POST_MODELS =
    {
        MaxBottomPostFactory.class,
        SouthPostFactory.class,
        MaxCenterBottomPostFactory.class,
        MaxCenterTopPostFactory.class,
        NorthPostFactory.class,
        MaxRightPostFactory.class,
        MinBottomPostFactory.class,
        MinLeftPostFactory.class,
        SmallMaxRightPostFactory.class,
        SmallMinLeftPostFactory.class,
        EastPostFactory.class,
        CenterPostFactory.class,
        WestPostFactory.class

    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(POST_MODELS);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }

    public static List<Class<?>> getAvailablePositioned()
    {
        return Arrays.asList(POSITIONED_POST_MODELS);
    }

    public static List getInstanceOfPositioned()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailablePositioned());

    }

}
