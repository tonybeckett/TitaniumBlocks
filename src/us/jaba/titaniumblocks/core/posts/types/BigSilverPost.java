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
public class BigSilverPost extends GradientBigPost
{

    public BigSilverPost()
    {
        super(new Color[]
        {
            new Color(152, 152, 152, 255),
            new Color(118, 121, 126, 255)
        }, new Color[]
        {
            new Color(118, 121, 126, 255),
            new Color(191, 191, 191, 255)
        }, new Color[]
        {
            new Color(191, 191, 191, 255),
            new Color(116, 116, 116, 255),
            new Color(143, 144, 146, 255)
        }, new Color[]
        {
            new Color(215, 215, 215, 255),
            new Color(139, 142, 145, 255),
            new Color(100, 100, 100, 255),
            new Color(139, 142, 145, 255),
            new Color(215, 215, 215, 255)
        });
    }

}
