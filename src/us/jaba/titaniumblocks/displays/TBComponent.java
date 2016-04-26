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
package us.jaba.titaniumblocks.displays;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.Serializable;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.frames.BasicFrame;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.tickmarks.marks.Tickmark;

/**
 *
 * @author tbeckett
 */
public interface TBComponent extends Serializable
{

    Pointer getPointer();
    void setPointer(Pointer pointer);

    Tickmark getTickmarks();
    void setTickmarks(Tickmark tm);

    Backdrop getBackdrop();
    void setBackdrop(Backdrop backdrop);

    Post getCenterPost();
    void setCenterPost(Post post);

    BasicFrame getFrame();
    void setFrame(BasicFrame Frame);

    void setFrontCover(Frontcover frontcover);
    Frontcover getFrontCover();

    public Text getText1();
    public void setText1(Text titleText);

    public void setSize(Dimension d);
    public Dimension getSize();
    
    public void paint(Graphics2D graphics2D, Dimension dimension);

    public void setChanged();

}
