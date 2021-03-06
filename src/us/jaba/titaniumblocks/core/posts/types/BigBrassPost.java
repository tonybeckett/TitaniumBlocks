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
package us.jaba.titaniumblocks.core.posts.types;

import us.jaba.titaniumblocks.core.posts.GradientBigPost;
import java.awt.Color;

/**
 *
 * @author tbeckett
 */
public class BigBrassPost extends GradientBigPost
{

    public BigBrassPost()
    {
        super(new Color[]
        {
            new Color(143, 117, 80, 255),
            new Color(100, 76, 49, 255)
        }, new Color[]
        {
            new Color(98, 75, 49, 255),
            new Color(149, 109, 54, 255)
        }, new Color[]
        {
            new Color(147, 108, 54, 255),
            new Color(82, 66, 50, 255),
            new Color(147, 108, 54, 255)
        }, new Color[]
        {
            new Color(223, 208, 174, 255),
            new Color(159, 136, 104, 255),
            new Color(122, 94, 62, 255),
            new Color(159, 136, 104, 255),
            new Color(223, 208, 174, 255)
        });
    }

}
