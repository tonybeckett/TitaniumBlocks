/*
 * Copyright (c) 2012, Gerrit Grunwald
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


/**
 *
 * @author hansolo
 */
public enum SSPostPosition
{

    MAX_CENTER_TOP,
    MAX_RIGHT,
    MIN_BOTTOM,
    MAX_BOTTOM,
    MAX_CENTER_BOTTOM,
    LOWER_CENTER,
    MIN_LEFT,
    CENTER,
    SMALL_GAUGE_MAX_RIGHT,
    SMALL_GAUGE_MIN_LEFT
}

//        final BufferedImage SINGLE_POST = create_KNOB_Image((int) Math.ceil(WIDTH * 0.03738316893577576), KnobType.SMALL_STD_KNOB, getModel().getKnobStyle());
//   // Draw min bottom
//        if (postPositionList.contains(PostPosition.MIN_BOTTOM)) {
//            G2.drawImage(SINGLE_POST, (int) (IMAGE_WIDTH * 0.336448609828949), (int) (IMAGE_HEIGHT * 0.8037382960319519), null);
//        }
//
//        // Draw max bottom post
//        if (postPositionList.contains(PostPosition.MAX_BOTTOM)) {
//            G2.drawImage(SINGLE_POST, (int) (IMAGE_WIDTH * 0.6261682510375977), (int) (IMAGE_HEIGHT * 0.8037382960319519), null);
//        }
//
//        // Draw min center bottom post
//        if (postPositionList.contains(PostPosition.MAX_CENTER_BOTTOM)) {
//            G2.drawImage(SINGLE_POST, (int) (IMAGE_WIDTH * 0.5233644843101501), (int) (IMAGE_HEIGHT * 0.8317757248878479), null);
//        }
//
//        // Draw max center top post
//        if (postPositionList.contains(PostPosition.MAX_CENTER_TOP)) {
//            G2.drawImage(SINGLE_POST, (int) (IMAGE_WIDTH * 0.5233644843101501), (int) (IMAGE_HEIGHT * 0.13084112107753754), null);
//        }
//
//        // Draw max right post
//        if (postPositionList.contains(PostPosition.MAX_RIGHT)) {
//            G2.drawImage(SINGLE_POST, (int) (IMAGE_WIDTH * 0.8317757248878479), (int) (IMAGE_HEIGHT * 0.514018714427948), null);
//        }
//
//        // Draw min left post
//        if (postPositionList.contains(PostPosition.MIN_LEFT)) {
//            G2.drawImage(SINGLE_POST, (int) (IMAGE_WIDTH * 0.13084112107753754), (int) (IMAGE_HEIGHT * 0.514018714427948), null);
//        }
//
//        // Draw radialvertical gauge right post
//        if (postPositionList.contains(PostPosition.SMALL_GAUGE_MAX_RIGHT)) {
//            switch (getOrientation()) {
//                case WEST:
//                    KNOB_CENTER.setLocation(IMAGE_WIDTH * 0.7803738117218018 + SINGLE_POST.getWidth() / 2.0, IMAGE_HEIGHT * 0.44859811663627625 + SINGLE_POST.getHeight() / 2.0);
//                    G2.rotate(Math.PI / 2, KNOB_CENTER.getX(), KNOB_CENTER.getY());
//                    break;
//            }
//            G2.drawImage(SINGLE_POST, (int) (IMAGE_WIDTH * 0.7803738117218018), (int) (IMAGE_HEIGHT * 0.44859811663627625), null);
//            G2.setTransform(OLD_TRANSFORM);
//        }
//
//        // Draw radialvertical gauge left post
//        if (postPositionList.contains(PostPosition.SMALL_GAUGE_MIN_LEFT)) {
//            switch (getOrientation()) {
//                case WEST:
//                    KNOB_CENTER.setLocation(IMAGE_WIDTH * 0.1822429895401001 + SINGLE_POST.getWidth() / 2.0, IMAGE_HEIGHT * 0.44859811663627625 + SINGLE_POST.getHeight() / 2.0);
//                    G2.rotate(Math.PI / 2, KNOB_CENTER.getX(), KNOB_CENTER.getY());
//                    break;
//            }
//            G2.drawImage(SINGLE_POST, (int) (IMAGE_WIDTH * 0.1822429895401001), (int) (IMAGE_HEIGHT * 0.44859811663627625), null);
//            G2.setTransform(OLD_TRANSFORM);
//        }
