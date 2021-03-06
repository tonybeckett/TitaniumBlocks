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
package us.jaba.titaniumblocks.core;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author tbeckett
 */
public class Images
{

    public static final String TITANIUMBLOCKS_16x16_FILENAME = "/us/jaba/titaniumblocks/core/resources/titaniumblocks-16.png";
    public static final String TITANIUMBLOCKS_32_FILENAME = "/us/jaba/titaniumblocks/core/resources/titaniumblocks-32.png";
    public static final String TITANIUMBLOCKS_64_FILENAME = "/us/jaba/titaniumblocks/core/resources/titaniumblocks-64.png";
    public static final String TITANIUMBLOCKS_128_FILENAME = "/us/jaba/titaniumblocks/core/resources/titaniumblocks-128.png";

    public static final Image titaniumblocks16 = Toolkit.getDefaultToolkit().getImage(Images.class.getResource(TITANIUMBLOCKS_16x16_FILENAME));
    public static final Image titaniumblocks32 = Toolkit.getDefaultToolkit().getImage(Images.class.getResource(TITANIUMBLOCKS_32_FILENAME));
    public static final Image titaniumblocks64 = Toolkit.getDefaultToolkit().getImage(Images.class.getResource(TITANIUMBLOCKS_64_FILENAME));
    public static final Image titaniumblocks128 = Toolkit.getDefaultToolkit().getImage(Images.class.getResource(TITANIUMBLOCKS_128_FILENAME));

}
