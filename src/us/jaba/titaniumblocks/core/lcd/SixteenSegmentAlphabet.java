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
package us.jaba.titaniumblocks.core.lcd;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tbeckett
 */
public enum SixteenSegmentAlphabet
{

    A(new char[]
    {
        'a', 'A'
    }, 1, 2, 3, 7, 8, 9, 10, 14),
    B(new char[]
    {
        'b', 'B'
    }, 1, 2, 5, 7, 9, 12, 14, 15, 16),
    C(new char[]
    {
        'c', 'C'
    }, 1, 2, 3, 10, 15, 16),
    D(new char[]
    {
        'd', 'D'
    }, 1, 2, 5, 7, 12, 14, 15, 16),
    E(new char[]
    {
        'e', 'E'
    }, 1, 2, 3, 8, 9, 10, 15, 16),
    F(new char[]
    {
        'f', 'F'
    }, 1, 2, 3, 8, 10),
    G(new char[]
    {
        'g', 'G'
    }, 1, 2, 3, 9, 10, 14, 15, 16),
    H(new char[]
    {
        'h', 'H'
    }, 3, 7, 8, 9, 10, 14),
    I(new char[]
    {
        'i', 'I'
    }, 1, 2, 5, 12, 15, 16),
    J(new char[]
    {
        'j', 'J'
    }, 7, 10, 14, 15, 16),
    K(new char[]
    {
        'k', 'K'
    }, 3, 6, 8, 10, 13),
    L(new char[]
    {
        'l', 'L'
    }, 3, 10, 15, 16),
    M(new char[]
    {
        'm', 'M'
    }, 3, 4, 6, 7, 10, 14),
    N(new char[]
    {
        'n', 'N'
    }, 3, 4, 7, 10, 13, 14),
    O(new char[]
    {
        'o', 'O'
    }, 1, 2, 3, 7, 10, 14, 15, 16),
    P(new char[]
    {
        'p', 'P'
    }, 1, 2, 3, 6, 8, 10),
    Q(new char[]
    {
        'q', 'Q'
    }, 1, 2, 3, 7, 10, 13, 14, 15, 16),
    R(new char[]
    {
        'r', 'R'
    }, 1, 2, 3, 7, 8, 9, 10, 13),
    S(new char[]
    {
        's', 'S'
    }, 1, 2, 3, 8, 9, 14, 15, 16),
    T(new char[]
    {
        't', 'T'
    }, 1, 2, 5, 12),
    U(new char[]
    {
        'u', 'U'
    }, 3, 7, 10, 14, 15, 16),
    V(new char[]
    {
        'v', 'V'
    }, 3, 6, 10, 11),
    W(new char[]
    {
        'w', 'W'
    }, 3, 7, 10, 11, 13, 14),
    X(new char[]
    {
        'x', 'X'
    }, 4, 6, 11, 13),
    Y(new char[]
    {
        'y', 'Y'
    }, 4, 6, 12),
    Z(new char[]
    {
        'z', 'Z'
    }, 1, 2, 6, 11, 15, 16),
    BLANK(new char[]
    {
        ' '
    }, 0),
    ZERO(new char[]
    {
        '0'
    }, 1, 2, 3, 4, 7, 10, 13, 14, 15, 16),
    ONE(new char[]
    {
        '1'
    }, 7, 14),
    TWO(new char[]
    {
        '2'
    }, 1, 2, 7, 8, 9, 10, 15, 16),
    THREE(new char[]
    {
        '3'
    }, 1, 2, 7, 9, 14, 15, 16),
    FOUR(new char[]
    {
        '4'
    }, 3, 7, 8, 9, 14),
    FIVE(new char[]
    {
        '5'
    }, 1, 2, 3, 8, 13, 15, 16),
    SIX(new char[]
    {
        '6'
    }, 1, 2, 3, 8, 9, 10, 14, 15, 16),
    SEVEN(new char[]
    {
        '7'
    }, 1, 2, 7, 14),
    EIGHT(new char[]
    {
        '8'
    }, 1, 2, 3, 7, 8, 9, 10, 14, 15, 16),
    NINE(new char[]
    {
        '9'
    }, 1, 2, 3, 7, 8, 9, 14, 15, 16),
    QUESTION(new char[]
    {
        '?'
    }, 1, 2, 7, 9, 12),
    EXCLAMATION(new char[]
    {
        '!'
    }, 5, 12);
    private final Integer[] segments;
    private final char[] characters;

    public static final Map<Character, SixteenSegmentAlphabet> MAP;

    static
    {
        MAP = new HashMap<Character, SixteenSegmentAlphabet>(36);
        for (SixteenSegmentAlphabet alfabet : SixteenSegmentAlphabet.values())
        {
            for (char character : alfabet.characters)
            {
                MAP.put(character, alfabet);
            }
        }
    }

    SixteenSegmentAlphabet(char[] characters, Integer... segments)
    {
        this.characters = characters;
        this.segments = segments;
    }

    public Integer[] getSegments()
    {
        return segments;
    }
}
