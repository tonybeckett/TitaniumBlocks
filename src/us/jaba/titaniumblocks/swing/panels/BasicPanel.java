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
package us.jaba.titaniumblocks.swing.panels;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JComponent;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.frames.BasicFrame;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.text.types.TitleText;
import us.jaba.titaniumblocks.core.tickmarks.marks.Tickmark;
import us.jaba.titaniumblocks.displays.TBComponent;

/**
 *
 * @author tbeckett
 */
public  class BasicPanel extends JComponent implements TBPanel
{

    protected final Rectangle DEFAULT_SIZE = new Rectangle(0, 0, 128, 48);
    private Rectangle currentSize = DEFAULT_SIZE;
    protected TBComponent tbComponent;
    protected final transient ComponentListener componentListener = new ComponentAdapter()
    {
        @Override
        public void componentResized(ComponentEvent event)
        {
            Container parent = getParent();
            if (getWidth() < getMinimumSize().width && getHeight() < getMinimumSize().height)
            {
                if (parent != null && getParent().getLayout() == null)
                {
                    setSize(getMinimumSize());
                } else
                {
                    setPreferredSize(getMinimumSize());
                }
            }
            if (parent != null && getParent().getLayout() == null)
            {
                setSize(getWidth(), getHeight());
            } else
            {
                int min = Math.min(getWidth(), getHeight());
                setPreferredSize(new Dimension(min, min));
            }
            init(getWidth(), getHeight());
        }
    };

    public BasicPanel(TBComponent component)
    {
        tbComponent = component;
    }

    public TBComponent getTBComponent()
    {
        return tbComponent;
    }

    public void setTBComponent(TBComponent component)
    {
        tbComponent = component;
    }

    public void init(int width, int height)
    {
        currentSize = new Rectangle(width, height);
    }

    @Override
    public void setSize(Dimension d)
    {
        super.setSize(d);

        tbComponent.setSize(d);
    }

    @Override
    public void setPreferredSize(Dimension preferredSize)
    {
        if (preferredSize != this.getPreferredSize())
        {
            tbComponent.setChanged();
        }
        super.setPreferredSize(preferredSize);
        tbComponent.setSize(preferredSize);
        invalidate();
        repaint();
    }

    protected Rectangle getInnerBounds()
    {
        return currentSize;
    }

    @Override
    public Backdrop getBackdrop()
    {
        return tbComponent.getBackdrop();
    }

    @Override
    public void setBackdrop(Backdrop painter)
    {
        tbComponent.setBackdrop(painter);
    }

    @Override
    public void setFrame(BasicFrame frame)
    {
        tbComponent.setFrame(frame);
    }

    @Override
    public void setFrontCover(Frontcover foregroundPainter)
    {
        tbComponent.setFrontCover(foregroundPainter);
    }

    @Override
    public Tickmark getTickmarks()
    {
        return tbComponent.getTickmarks();
    }

    @Override
    public void setTickmarks(Tickmark tm)
    {
        tbComponent.setTickmarks(tm);
    }

    @Override
    public void setCenterPost(Post postPainter)
    {
        tbComponent.setCenterPost(postPainter);
    }

    @Override
    public TitleText getTitleText()
    {
        return tbComponent.getTitleText();
    }

    @Override
    public void setTitleText(TitleText titleText)
    {
        tbComponent.setTitleText(titleText);
    }

    @Override
    public Post getCenterPost()
    {
        return tbComponent.getCenterPost();
    }

    @Override
    public BasicFrame getFrame()
    {
       return tbComponent.getFrame();
    }

    @Override
    public Frontcover getFrontCover()
    {
        return tbComponent.getFrontCover();
    }

    @Override
    public Pointer getPointer()
    {
        return tbComponent.getPointer();
    }

    @Override
    public void setPointer(Pointer pointer)
    {
        tbComponent.setPointer(pointer);
    }

    @Override
    public void paint(Graphics2D graphics2D)
    {
        
    }

   
    @Override
    public void setChanged()
    {
        tbComponent.setChanged();
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        super.paint(g);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        tbComponent.paint((Graphics2D) g, new Dimension(getWidth(), getHeight()));
    }

}
