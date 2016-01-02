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
package us.jaba.titaniumblocks.core.led;

import java.awt.Color;

/**
 *
 * @author tbeckett
 */
public class LedColor
{

    public final Color Inner1On;
    public final Color Inner2On;
    public final Color OuterOn;
    public final Color Corona;
    public final Color Inner1Off;
    public final Color Inner2Off;
    public final Color OuterOff;

    public LedColor(Color Inner1On, Color Inner2On, Color OuterOn, Color Corona, Color Inner1Off, Color Inner2Off, Color OuterOff)
    {
        this.Inner1On = Inner1On;
        this.Inner2On = Inner2On;
        this.OuterOn = OuterOn;
        this.Corona = Corona;
        this.Inner1Off = Inner1Off;
        this.Inner2Off = Inner2Off;
        this.OuterOff = OuterOff;
    }

    public Color getInner1On()
    {
        return Inner1On;
    }

    public Color getInner2On()
    {
        return Inner2On;
    }

    public Color getOuterOn()
    {
        return OuterOn;
    }

    public Color getCorona()
    {
        return Corona;
    }

    public Color getInner1Off()
    {
        return Inner1Off;
    }

    public Color getInner2Off()
    {
        return Inner2Off;
    }

    public Color getOuterOff()
    {
        return OuterOff;
    }

}
