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

import java.beans.*;

/**
 *
 * @author tbeckett
 */
public class ClockPanelBeanInfo extends SimpleBeanInfo
{

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor
        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_actionMap = 1;
    private static final int PROPERTY_alignmentX = 2;
    private static final int PROPERTY_alignmentY = 3;
    private static final int PROPERTY_ancestorListeners = 4;
    private static final int PROPERTY_autoscrolls = 5;
    private static final int PROPERTY_backdrop = 6;
    private static final int PROPERTY_background = 7;
    private static final int PROPERTY_backgroundSet = 8;
    private static final int PROPERTY_baselineResizeBehavior = 9;
    private static final int PROPERTY_border = 10;
    private static final int PROPERTY_bounds = 11;
    private static final int PROPERTY_centerPost = 12;
    private static final int PROPERTY_colorModel = 13;
    private static final int PROPERTY_component = 14;
    private static final int PROPERTY_componentCount = 15;
    private static final int PROPERTY_componentListeners = 16;
    private static final int PROPERTY_componentOrientation = 17;
    private static final int PROPERTY_componentPopupMenu = 18;
    private static final int PROPERTY_components = 19;
    private static final int PROPERTY_containerListeners = 20;
    private static final int PROPERTY_cursor = 21;
    private static final int PROPERTY_cursorSet = 22;
    private static final int PROPERTY_debugGraphicsOptions = 23;
    private static final int PROPERTY_displayable = 24;
    private static final int PROPERTY_doubleBuffered = 25;
    private static final int PROPERTY_dropTarget = 26;
    private static final int PROPERTY_enabled = 27;
    private static final int PROPERTY_focusable = 28;
    private static final int PROPERTY_focusCycleRoot = 29;
    private static final int PROPERTY_focusCycleRootAncestor = 30;
    private static final int PROPERTY_focusListeners = 31;
    private static final int PROPERTY_focusOwner = 32;
    private static final int PROPERTY_focusTraversable = 33;
    private static final int PROPERTY_focusTraversalKeys = 34;
    private static final int PROPERTY_focusTraversalKeysEnabled = 35;
    private static final int PROPERTY_focusTraversalPolicy = 36;
    private static final int PROPERTY_focusTraversalPolicyProvider = 37;
    private static final int PROPERTY_focusTraversalPolicySet = 38;
    private static final int PROPERTY_font = 39;
    private static final int PROPERTY_fontSet = 40;
    private static final int PROPERTY_foreground = 41;
    private static final int PROPERTY_foregroundSet = 42;
    private static final int PROPERTY_frame = 43;
    private static final int PROPERTY_frontCover = 44;
    private static final int PROPERTY_graphics = 45;
    private static final int PROPERTY_graphicsConfiguration = 46;
    private static final int PROPERTY_height = 47;
    private static final int PROPERTY_hierarchyBoundsListeners = 48;
    private static final int PROPERTY_hierarchyListeners = 49;
    private static final int PROPERTY_hour = 50;
    private static final int PROPERTY_hoursPointer = 51;
    private static final int PROPERTY_ignoreRepaint = 52;
    private static final int PROPERTY_inheritsPopupMenu = 53;
    private static final int PROPERTY_inputContext = 54;
    private static final int PROPERTY_inputMap = 55;
    private static final int PROPERTY_inputMethodListeners = 56;
    private static final int PROPERTY_inputMethodRequests = 57;
    private static final int PROPERTY_inputVerifier = 58;
    private static final int PROPERTY_insets = 59;
    private static final int PROPERTY_keyListeners = 60;
    private static final int PROPERTY_layout = 61;
    private static final int PROPERTY_lightweight = 62;
    private static final int PROPERTY_locale = 63;
    private static final int PROPERTY_location = 64;
    private static final int PROPERTY_locationOnScreen = 65;
    private static final int PROPERTY_managingFocus = 66;
    private static final int PROPERTY_maximumSize = 67;
    private static final int PROPERTY_maximumSizeSet = 68;
    private static final int PROPERTY_minimumSize = 69;
    private static final int PROPERTY_minimumSizeSet = 70;
    private static final int PROPERTY_minute = 71;
    private static final int PROPERTY_minutesPointer = 72;
    private static final int PROPERTY_mouseListeners = 73;
    private static final int PROPERTY_mouseMotionListeners = 74;
    private static final int PROPERTY_mousePosition = 75;
    private static final int PROPERTY_mouseWheelListeners = 76;
    private static final int PROPERTY_name = 77;
    private static final int PROPERTY_nextFocusableComponent = 78;
    private static final int PROPERTY_opaque = 79;
    private static final int PROPERTY_optimizedDrawingEnabled = 80;
    private static final int PROPERTY_paintingForPrint = 81;
    private static final int PROPERTY_paintingTile = 82;
    private static final int PROPERTY_parent = 83;
    private static final int PROPERTY_peer = 84;
    private static final int PROPERTY_pointer = 85;
    private static final int PROPERTY_preferredSize = 86;
    private static final int PROPERTY_preferredSizeSet = 87;
    private static final int PROPERTY_propertyChangeListeners = 88;
    private static final int PROPERTY_registeredKeyStrokes = 89;
    private static final int PROPERTY_requestFocusEnabled = 90;
    private static final int PROPERTY_rootPane = 91;
    private static final int PROPERTY_second = 92;
    private static final int PROPERTY_secondsPointer = 93;
    private static final int PROPERTY_showing = 94;
    private static final int PROPERTY_size = 95;
    private static final int PROPERTY_TBComponent = 96;
    private static final int PROPERTY_tickmarks = 97;
    private static final int PROPERTY_titleText = 98;
    private static final int PROPERTY_toolkit = 99;
    private static final int PROPERTY_toolTipText = 100;
    private static final int PROPERTY_topLevelAncestor = 101;
    private static final int PROPERTY_transferHandler = 102;
    private static final int PROPERTY_treeLock = 103;
    private static final int PROPERTY_UIClassID = 104;
    private static final int PROPERTY_valid = 105;
    private static final int PROPERTY_validateRoot = 106;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 107;
    private static final int PROPERTY_vetoableChangeListeners = 108;
    private static final int PROPERTY_visible = 109;
    private static final int PROPERTY_visibleRect = 110;
    private static final int PROPERTY_width = 111;
    private static final int PROPERTY_x = 112;
    private static final int PROPERTY_y = 113;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[114];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_backdrop] = new PropertyDescriptor ( "backdrop", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getBackdrop", "setBackdrop" ); // NOI18N
            properties[PROPERTY_backdrop].setPreferred ( true );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_centerPost] = new PropertyDescriptor ( "centerPost", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getCenterPost", "setCenterPost" ); // NOI18N
            properties[PROPERTY_centerPost].setPreferred ( true );
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_frame] = new PropertyDescriptor ( "frame", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getFrame", "setFrame" ); // NOI18N
            properties[PROPERTY_frame].setPreferred ( true );
            properties[PROPERTY_frontCover] = new PropertyDescriptor ( "frontCover", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getFrontCover", "setFrontCover" ); // NOI18N
            properties[PROPERTY_frontCover].setPreferred ( true );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_hour] = new PropertyDescriptor ( "hour", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, null, "setHour" ); // NOI18N
            properties[PROPERTY_hoursPointer] = new PropertyDescriptor ( "hoursPointer", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getHoursPointer", "setHoursPointer" ); // NOI18N
            properties[PROPERTY_hoursPointer].setPreferred ( true );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_minute] = new PropertyDescriptor ( "minute", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, null, "setMinute" ); // NOI18N
            properties[PROPERTY_minutesPointer] = new PropertyDescriptor ( "minutesPointer", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getMinutesPointer", "setMinutesPointer" ); // NOI18N
            properties[PROPERTY_minutesPointer].setPreferred ( true );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getParent", null ); // NOI18N
            properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getPeer", null ); // NOI18N
            properties[PROPERTY_pointer] = new PropertyDescriptor ( "pointer", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getPointer", "setPointer" ); // NOI18N
            properties[PROPERTY_pointer].setPreferred ( true );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_second] = new PropertyDescriptor ( "second", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, null, "setSecond" ); // NOI18N
            properties[PROPERTY_secondsPointer] = new PropertyDescriptor ( "secondsPointer", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getSecondsPointer", "setSecondsPointer" ); // NOI18N
            properties[PROPERTY_secondsPointer].setPreferred ( true );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_TBComponent] = new PropertyDescriptor ( "TBComponent", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getTBComponent", "setTBComponent" ); // NOI18N
            properties[PROPERTY_tickmarks] = new PropertyDescriptor ( "tickmarks", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getTickmarks", "setTickmarks" ); // NOI18N
            properties[PROPERTY_titleText] = new PropertyDescriptor ( "titleText", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getTitleText", "setTitleText" ); // NOI18N
            properties[PROPERTY_titleText].setPreferred ( true );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isValid", null ); // NOI18N
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getX", null ); // NOI18N
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "getY", null ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties
        // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_ancestorListener = 0;
    private static final int EVENT_componentListener = 1;
    private static final int EVENT_containerListener = 2;
    private static final int EVENT_focusListener = 3;
    private static final int EVENT_hierarchyBoundsListener = 4;
    private static final int EVENT_hierarchyListener = 5;
    private static final int EVENT_inputMethodListener = 6;
    private static final int EVENT_keyListener = 7;
    private static final int EVENT_mouseListener = 8;
    private static final int EVENT_mouseMotionListener = 9;
    private static final int EVENT_mouseWheelListener = 10;
    private static final int EVENT_propertyChangeListener = 11;
    private static final int EVENT_vetoableChangeListener = 12;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[13];
    
        try {
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( us.jaba.titaniumblocks.swing.panels.ClockPanel.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events
        // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events

    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_addPropertyChangeListener0 = 0;
    private static final int METHOD_applyComponentOrientation1 = 1;
    private static final int METHOD_areFocusTraversalKeysSet2 = 2;
    private static final int METHOD_bounds3 = 3;
    private static final int METHOD_checkImage4 = 4;
    private static final int METHOD_checkImage5 = 5;
    private static final int METHOD_computeVisibleRect6 = 6;
    private static final int METHOD_contains7 = 7;
    private static final int METHOD_contains8 = 8;
    private static final int METHOD_countComponents9 = 9;
    private static final int METHOD_createImage10 = 10;
    private static final int METHOD_createImage11 = 11;
    private static final int METHOD_createToolTip12 = 12;
    private static final int METHOD_createVolatileImage13 = 13;
    private static final int METHOD_createVolatileImage14 = 14;
    private static final int METHOD_deliverEvent15 = 15;
    private static final int METHOD_disable16 = 16;
    private static final int METHOD_dispatchEvent17 = 17;
    private static final int METHOD_doLayout18 = 18;
    private static final int METHOD_enable19 = 19;
    private static final int METHOD_enable20 = 20;
    private static final int METHOD_enableInputMethods21 = 21;
    private static final int METHOD_findComponentAt22 = 22;
    private static final int METHOD_findComponentAt23 = 23;
    private static final int METHOD_firePropertyChange24 = 24;
    private static final int METHOD_firePropertyChange25 = 25;
    private static final int METHOD_firePropertyChange26 = 26;
    private static final int METHOD_firePropertyChange27 = 27;
    private static final int METHOD_firePropertyChange28 = 28;
    private static final int METHOD_firePropertyChange29 = 29;
    private static final int METHOD_firePropertyChange30 = 30;
    private static final int METHOD_firePropertyChange31 = 31;
    private static final int METHOD_getActionForKeyStroke32 = 32;
    private static final int METHOD_getBaseline33 = 33;
    private static final int METHOD_getBounds34 = 34;
    private static final int METHOD_getClientProperty35 = 35;
    private static final int METHOD_getComponentAt36 = 36;
    private static final int METHOD_getComponentAt37 = 37;
    private static final int METHOD_getComponentZOrder38 = 38;
    private static final int METHOD_getConditionForKeyStroke39 = 39;
    private static final int METHOD_getDefaultLocale40 = 40;
    private static final int METHOD_getFocusTraversalKeys41 = 41;
    private static final int METHOD_getFontMetrics42 = 42;
    private static final int METHOD_getInsets43 = 43;
    private static final int METHOD_getListeners44 = 44;
    private static final int METHOD_getLocation45 = 45;
    private static final int METHOD_getMousePosition46 = 46;
    private static final int METHOD_getPopupLocation47 = 47;
    private static final int METHOD_getPropertyChangeListeners48 = 48;
    private static final int METHOD_getSize49 = 49;
    private static final int METHOD_getToolTipLocation50 = 50;
    private static final int METHOD_getToolTipText51 = 51;
    private static final int METHOD_gotFocus52 = 52;
    private static final int METHOD_grabFocus53 = 53;
    private static final int METHOD_handleEvent54 = 54;
    private static final int METHOD_hasFocus55 = 55;
    private static final int METHOD_hide56 = 56;
    private static final int METHOD_imageUpdate57 = 57;
    private static final int METHOD_init58 = 58;
    private static final int METHOD_insets59 = 59;
    private static final int METHOD_inside60 = 60;
    private static final int METHOD_invalidate61 = 61;
    private static final int METHOD_isAncestorOf62 = 62;
    private static final int METHOD_isFocusCycleRoot63 = 63;
    private static final int METHOD_isLightweightComponent64 = 64;
    private static final int METHOD_keyDown65 = 65;
    private static final int METHOD_keyUp66 = 66;
    private static final int METHOD_layout67 = 67;
    private static final int METHOD_list68 = 68;
    private static final int METHOD_list69 = 69;
    private static final int METHOD_list70 = 70;
    private static final int METHOD_list71 = 71;
    private static final int METHOD_list72 = 72;
    private static final int METHOD_locate73 = 73;
    private static final int METHOD_location74 = 74;
    private static final int METHOD_lostFocus75 = 75;
    private static final int METHOD_minimumSize76 = 76;
    private static final int METHOD_mouseDown77 = 77;
    private static final int METHOD_mouseDrag78 = 78;
    private static final int METHOD_mouseEnter79 = 79;
    private static final int METHOD_mouseExit80 = 80;
    private static final int METHOD_mouseMove81 = 81;
    private static final int METHOD_mouseUp82 = 82;
    private static final int METHOD_move83 = 83;
    private static final int METHOD_nextFocus84 = 84;
    private static final int METHOD_paint85 = 85;
    private static final int METHOD_paint86 = 86;
    private static final int METHOD_paintAll87 = 87;
    private static final int METHOD_paintComponents88 = 88;
    private static final int METHOD_paintImmediately89 = 89;
    private static final int METHOD_paintImmediately90 = 90;
    private static final int METHOD_postEvent91 = 91;
    private static final int METHOD_preferredSize92 = 92;
    private static final int METHOD_prepareImage93 = 93;
    private static final int METHOD_prepareImage94 = 94;
    private static final int METHOD_print95 = 95;
    private static final int METHOD_printAll96 = 96;
    private static final int METHOD_printComponents97 = 97;
    private static final int METHOD_putClientProperty98 = 98;
    private static final int METHOD_registerKeyboardAction99 = 99;
    private static final int METHOD_registerKeyboardAction100 = 100;
    private static final int METHOD_remove101 = 101;
    private static final int METHOD_remove102 = 102;
    private static final int METHOD_remove103 = 103;
    private static final int METHOD_removeAll104 = 104;
    private static final int METHOD_removeNotify105 = 105;
    private static final int METHOD_removePropertyChangeListener106 = 106;
    private static final int METHOD_repaint107 = 107;
    private static final int METHOD_repaint108 = 108;
    private static final int METHOD_repaint109 = 109;
    private static final int METHOD_repaint110 = 110;
    private static final int METHOD_repaint111 = 111;
    private static final int METHOD_requestDefaultFocus112 = 112;
    private static final int METHOD_requestFocus113 = 113;
    private static final int METHOD_requestFocus114 = 114;
    private static final int METHOD_requestFocusInWindow115 = 115;
    private static final int METHOD_resetKeyboardActions116 = 116;
    private static final int METHOD_reshape117 = 117;
    private static final int METHOD_resize118 = 118;
    private static final int METHOD_resize119 = 119;
    private static final int METHOD_revalidate120 = 120;
    private static final int METHOD_scrollRectToVisible121 = 121;
    private static final int METHOD_setBounds122 = 122;
    private static final int METHOD_setChanged123 = 123;
    private static final int METHOD_setComponentZOrder124 = 124;
    private static final int METHOD_setDefaultLocale125 = 125;
    private static final int METHOD_setValueAnimated126 = 126;
    private static final int METHOD_show127 = 127;
    private static final int METHOD_show128 = 128;
    private static final int METHOD_size129 = 129;
    private static final int METHOD_toString130 = 130;
    private static final int METHOD_transferFocus131 = 131;
    private static final int METHOD_transferFocusBackward132 = 132;
    private static final int METHOD_transferFocusDownCycle133 = 133;
    private static final int METHOD_transferFocusUpCycle134 = 134;
    private static final int METHOD_unregisterKeyboardAction135 = 135;
    private static final int METHOD_update136 = 136;
    private static final int METHOD_updateUI137 = 137;
    private static final int METHOD_validate138 = 138;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[139];
    
        try {
            methods[METHOD_addPropertyChangeListener0] = new MethodDescriptor(java.awt.Container.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_addPropertyChangeListener0].setDisplayName ( "" );
            methods[METHOD_applyComponentOrientation1] = new MethodDescriptor(java.awt.Container.class.getMethod("applyComponentOrientation", new Class[] {java.awt.ComponentOrientation.class})); // NOI18N
            methods[METHOD_applyComponentOrientation1].setDisplayName ( "" );
            methods[METHOD_areFocusTraversalKeysSet2] = new MethodDescriptor(java.awt.Container.class.getMethod("areFocusTraversalKeysSet", new Class[] {int.class})); // NOI18N
            methods[METHOD_areFocusTraversalKeysSet2].setDisplayName ( "" );
            methods[METHOD_bounds3] = new MethodDescriptor(java.awt.Component.class.getMethod("bounds", new Class[] {})); // NOI18N
            methods[METHOD_bounds3].setDisplayName ( "" );
            methods[METHOD_checkImage4] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage4].setDisplayName ( "" );
            methods[METHOD_checkImage5] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage5].setDisplayName ( "" );
            methods[METHOD_computeVisibleRect6] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_computeVisibleRect6].setDisplayName ( "" );
            methods[METHOD_contains7] = new MethodDescriptor(java.awt.Component.class.getMethod("contains", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_contains7].setDisplayName ( "" );
            methods[METHOD_contains8] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("contains", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_contains8].setDisplayName ( "" );
            methods[METHOD_countComponents9] = new MethodDescriptor(java.awt.Container.class.getMethod("countComponents", new Class[] {})); // NOI18N
            methods[METHOD_countComponents9].setDisplayName ( "" );
            methods[METHOD_createImage10] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class})); // NOI18N
            methods[METHOD_createImage10].setDisplayName ( "" );
            methods[METHOD_createImage11] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createImage11].setDisplayName ( "" );
            methods[METHOD_createToolTip12] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("createToolTip", new Class[] {})); // NOI18N
            methods[METHOD_createToolTip12].setDisplayName ( "" );
            methods[METHOD_createVolatileImage13] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createVolatileImage13].setDisplayName ( "" );
            methods[METHOD_createVolatileImage14] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class, java.awt.ImageCapabilities.class})); // NOI18N
            methods[METHOD_createVolatileImage14].setDisplayName ( "" );
            methods[METHOD_deliverEvent15] = new MethodDescriptor(java.awt.Container.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_deliverEvent15].setDisplayName ( "" );
            methods[METHOD_disable16] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("disable", new Class[] {})); // NOI18N
            methods[METHOD_disable16].setDisplayName ( "" );
            methods[METHOD_dispatchEvent17] = new MethodDescriptor(java.awt.Component.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class})); // NOI18N
            methods[METHOD_dispatchEvent17].setDisplayName ( "" );
            methods[METHOD_doLayout18] = new MethodDescriptor(java.awt.Container.class.getMethod("doLayout", new Class[] {})); // NOI18N
            methods[METHOD_doLayout18].setDisplayName ( "" );
            methods[METHOD_enable19] = new MethodDescriptor(java.awt.Component.class.getMethod("enable", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enable19].setDisplayName ( "" );
            methods[METHOD_enable20] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("enable", new Class[] {})); // NOI18N
            methods[METHOD_enable20].setDisplayName ( "" );
            methods[METHOD_enableInputMethods21] = new MethodDescriptor(java.awt.Component.class.getMethod("enableInputMethods", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enableInputMethods21].setDisplayName ( "" );
            methods[METHOD_findComponentAt22] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_findComponentAt22].setDisplayName ( "" );
            methods[METHOD_findComponentAt23] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_findComponentAt23].setDisplayName ( "" );
            methods[METHOD_firePropertyChange24] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, byte.class, byte.class})); // NOI18N
            methods[METHOD_firePropertyChange24].setDisplayName ( "" );
            methods[METHOD_firePropertyChange25] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, short.class, short.class})); // NOI18N
            methods[METHOD_firePropertyChange25].setDisplayName ( "" );
            methods[METHOD_firePropertyChange26] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, long.class, long.class})); // NOI18N
            methods[METHOD_firePropertyChange26].setDisplayName ( "" );
            methods[METHOD_firePropertyChange27] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, float.class, float.class})); // NOI18N
            methods[METHOD_firePropertyChange27].setDisplayName ( "" );
            methods[METHOD_firePropertyChange28] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, double.class, double.class})); // NOI18N
            methods[METHOD_firePropertyChange28].setDisplayName ( "" );
            methods[METHOD_firePropertyChange29] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, boolean.class, boolean.class})); // NOI18N
            methods[METHOD_firePropertyChange29].setDisplayName ( "" );
            methods[METHOD_firePropertyChange30] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, int.class, int.class})); // NOI18N
            methods[METHOD_firePropertyChange30].setDisplayName ( "" );
            methods[METHOD_firePropertyChange31] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, char.class, char.class})); // NOI18N
            methods[METHOD_firePropertyChange31].setDisplayName ( "" );
            methods[METHOD_getActionForKeyStroke32] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_getActionForKeyStroke32].setDisplayName ( "" );
            methods[METHOD_getBaseline33] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getBaseline", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getBaseline33].setDisplayName ( "" );
            methods[METHOD_getBounds34] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_getBounds34].setDisplayName ( "" );
            methods[METHOD_getClientProperty35] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class})); // NOI18N
            methods[METHOD_getClientProperty35].setDisplayName ( "" );
            methods[METHOD_getComponentAt36] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getComponentAt36].setDisplayName ( "" );
            methods[METHOD_getComponentAt37] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getComponentAt37].setDisplayName ( "" );
            methods[METHOD_getComponentZOrder38] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentZOrder", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_getComponentZOrder38].setDisplayName ( "" );
            methods[METHOD_getConditionForKeyStroke39] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_getConditionForKeyStroke39].setDisplayName ( "" );
            methods[METHOD_getDefaultLocale40] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getDefaultLocale", new Class[] {})); // NOI18N
            methods[METHOD_getDefaultLocale40].setDisplayName ( "" );
            methods[METHOD_getFocusTraversalKeys41] = new MethodDescriptor(java.awt.Container.class.getMethod("getFocusTraversalKeys", new Class[] {int.class})); // NOI18N
            methods[METHOD_getFocusTraversalKeys41].setDisplayName ( "" );
            methods[METHOD_getFontMetrics42] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class})); // NOI18N
            methods[METHOD_getFontMetrics42].setDisplayName ( "" );
            methods[METHOD_getInsets43] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getInsets", new Class[] {java.awt.Insets.class})); // NOI18N
            methods[METHOD_getInsets43].setDisplayName ( "" );
            methods[METHOD_getListeners44] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getListeners", new Class[] {java.lang.Class.class})); // NOI18N
            methods[METHOD_getListeners44].setDisplayName ( "" );
            methods[METHOD_getLocation45] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getLocation", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getLocation45].setDisplayName ( "" );
            methods[METHOD_getMousePosition46] = new MethodDescriptor(java.awt.Container.class.getMethod("getMousePosition", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_getMousePosition46].setDisplayName ( "" );
            methods[METHOD_getPopupLocation47] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getPopupLocation", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getPopupLocation47].setDisplayName ( "" );
            methods[METHOD_getPropertyChangeListeners48] = new MethodDescriptor(java.awt.Component.class.getMethod("getPropertyChangeListeners", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_getPropertyChangeListeners48].setDisplayName ( "" );
            methods[METHOD_getSize49] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getSize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_getSize49].setDisplayName ( "" );
            methods[METHOD_getToolTipLocation50] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getToolTipLocation50].setDisplayName ( "" );
            methods[METHOD_getToolTipText51] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getToolTipText51].setDisplayName ( "" );
            methods[METHOD_gotFocus52] = new MethodDescriptor(java.awt.Component.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_gotFocus52].setDisplayName ( "" );
            methods[METHOD_grabFocus53] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("grabFocus", new Class[] {})); // NOI18N
            methods[METHOD_grabFocus53].setDisplayName ( "" );
            methods[METHOD_handleEvent54] = new MethodDescriptor(java.awt.Component.class.getMethod("handleEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_handleEvent54].setDisplayName ( "" );
            methods[METHOD_hasFocus55] = new MethodDescriptor(java.awt.Component.class.getMethod("hasFocus", new Class[] {})); // NOI18N
            methods[METHOD_hasFocus55].setDisplayName ( "" );
            methods[METHOD_hide56] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("hide", new Class[] {})); // NOI18N
            methods[METHOD_hide56].setDisplayName ( "" );
            methods[METHOD_imageUpdate57] = new MethodDescriptor(java.awt.Component.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, int.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_imageUpdate57].setDisplayName ( "" );
            methods[METHOD_init58] = new MethodDescriptor(us.jaba.titaniumblocks.swing.panels.BasicPanel.class.getMethod("init", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_init58].setDisplayName ( "" );
            methods[METHOD_insets59] = new MethodDescriptor(java.awt.Container.class.getMethod("insets", new Class[] {})); // NOI18N
            methods[METHOD_insets59].setDisplayName ( "" );
            methods[METHOD_inside60] = new MethodDescriptor(java.awt.Component.class.getMethod("inside", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_inside60].setDisplayName ( "" );
            methods[METHOD_invalidate61] = new MethodDescriptor(java.awt.Container.class.getMethod("invalidate", new Class[] {})); // NOI18N
            methods[METHOD_invalidate61].setDisplayName ( "" );
            methods[METHOD_isAncestorOf62] = new MethodDescriptor(java.awt.Container.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isAncestorOf62].setDisplayName ( "" );
            methods[METHOD_isFocusCycleRoot63] = new MethodDescriptor(java.awt.Container.class.getMethod("isFocusCycleRoot", new Class[] {java.awt.Container.class})); // NOI18N
            methods[METHOD_isFocusCycleRoot63].setDisplayName ( "" );
            methods[METHOD_isLightweightComponent64] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isLightweightComponent64].setDisplayName ( "" );
            methods[METHOD_keyDown65] = new MethodDescriptor(java.awt.Component.class.getMethod("keyDown", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyDown65].setDisplayName ( "" );
            methods[METHOD_keyUp66] = new MethodDescriptor(java.awt.Component.class.getMethod("keyUp", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyUp66].setDisplayName ( "" );
            methods[METHOD_layout67] = new MethodDescriptor(java.awt.Container.class.getMethod("layout", new Class[] {})); // NOI18N
            methods[METHOD_layout67].setDisplayName ( "" );
            methods[METHOD_list68] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {})); // NOI18N
            methods[METHOD_list68].setDisplayName ( "" );
            methods[METHOD_list69] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintStream.class})); // NOI18N
            methods[METHOD_list69].setDisplayName ( "" );
            methods[METHOD_list70] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintWriter.class})); // NOI18N
            methods[METHOD_list70].setDisplayName ( "" );
            methods[METHOD_list71] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintStream.class, int.class})); // NOI18N
            methods[METHOD_list71].setDisplayName ( "" );
            methods[METHOD_list72] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintWriter.class, int.class})); // NOI18N
            methods[METHOD_list72].setDisplayName ( "" );
            methods[METHOD_locate73] = new MethodDescriptor(java.awt.Container.class.getMethod("locate", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_locate73].setDisplayName ( "" );
            methods[METHOD_location74] = new MethodDescriptor(java.awt.Component.class.getMethod("location", new Class[] {})); // NOI18N
            methods[METHOD_location74].setDisplayName ( "" );
            methods[METHOD_lostFocus75] = new MethodDescriptor(java.awt.Component.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_lostFocus75].setDisplayName ( "" );
            methods[METHOD_minimumSize76] = new MethodDescriptor(java.awt.Container.class.getMethod("minimumSize", new Class[] {})); // NOI18N
            methods[METHOD_minimumSize76].setDisplayName ( "" );
            methods[METHOD_mouseDown77] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDown77].setDisplayName ( "" );
            methods[METHOD_mouseDrag78] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDrag78].setDisplayName ( "" );
            methods[METHOD_mouseEnter79] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseEnter79].setDisplayName ( "" );
            methods[METHOD_mouseExit80] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseExit80].setDisplayName ( "" );
            methods[METHOD_mouseMove81] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseMove81].setDisplayName ( "" );
            methods[METHOD_mouseUp82] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseUp82].setDisplayName ( "" );
            methods[METHOD_move83] = new MethodDescriptor(java.awt.Component.class.getMethod("move", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_move83].setDisplayName ( "" );
            methods[METHOD_nextFocus84] = new MethodDescriptor(java.awt.Component.class.getMethod("nextFocus", new Class[] {})); // NOI18N
            methods[METHOD_nextFocus84].setDisplayName ( "" );
            methods[METHOD_paint85] = new MethodDescriptor(us.jaba.titaniumblocks.swing.panels.BasicPanel.class.getMethod("paint", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paint85].setDisplayName ( "" );
            methods[METHOD_paint86] = new MethodDescriptor(us.jaba.titaniumblocks.swing.panels.ClockPanel.class.getMethod("paint", new Class[] {java.awt.Graphics2D.class})); // NOI18N
            methods[METHOD_paint86].setDisplayName ( "" );
            methods[METHOD_paintAll87] = new MethodDescriptor(java.awt.Component.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintAll87].setDisplayName ( "" );
            methods[METHOD_paintComponents88] = new MethodDescriptor(java.awt.Container.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintComponents88].setDisplayName ( "" );
            methods[METHOD_paintImmediately89] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paintImmediately", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_paintImmediately89].setDisplayName ( "" );
            methods[METHOD_paintImmediately90] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paintImmediately", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_paintImmediately90].setDisplayName ( "" );
            methods[METHOD_postEvent91] = new MethodDescriptor(java.awt.Component.class.getMethod("postEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_postEvent91].setDisplayName ( "" );
            methods[METHOD_preferredSize92] = new MethodDescriptor(java.awt.Container.class.getMethod("preferredSize", new Class[] {})); // NOI18N
            methods[METHOD_preferredSize92].setDisplayName ( "" );
            methods[METHOD_prepareImage93] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage93].setDisplayName ( "" );
            methods[METHOD_prepareImage94] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage94].setDisplayName ( "" );
            methods[METHOD_print95] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("print", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_print95].setDisplayName ( "" );
            methods[METHOD_printAll96] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("printAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printAll96].setDisplayName ( "" );
            methods[METHOD_printComponents97] = new MethodDescriptor(java.awt.Container.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printComponents97].setDisplayName ( "" );
            methods[METHOD_putClientProperty98] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_putClientProperty98].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction99] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, int.class})); // NOI18N
            methods[METHOD_registerKeyboardAction99].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction100] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, javax.swing.KeyStroke.class, int.class})); // NOI18N
            methods[METHOD_registerKeyboardAction100].setDisplayName ( "" );
            methods[METHOD_remove101] = new MethodDescriptor(java.awt.Component.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class})); // NOI18N
            methods[METHOD_remove101].setDisplayName ( "" );
            methods[METHOD_remove102] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {int.class})); // NOI18N
            methods[METHOD_remove102].setDisplayName ( "" );
            methods[METHOD_remove103] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_remove103].setDisplayName ( "" );
            methods[METHOD_removeAll104] = new MethodDescriptor(java.awt.Container.class.getMethod("removeAll", new Class[] {})); // NOI18N
            methods[METHOD_removeAll104].setDisplayName ( "" );
            methods[METHOD_removeNotify105] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("removeNotify", new Class[] {})); // NOI18N
            methods[METHOD_removeNotify105].setDisplayName ( "" );
            methods[METHOD_removePropertyChangeListener106] = new MethodDescriptor(java.awt.Component.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_removePropertyChangeListener106].setDisplayName ( "" );
            methods[METHOD_repaint107] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {})); // NOI18N
            methods[METHOD_repaint107].setDisplayName ( "" );
            methods[METHOD_repaint108] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {long.class})); // NOI18N
            methods[METHOD_repaint108].setDisplayName ( "" );
            methods[METHOD_repaint109] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint109].setDisplayName ( "" );
            methods[METHOD_repaint110] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("repaint", new Class[] {long.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint110].setDisplayName ( "" );
            methods[METHOD_repaint111] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("repaint", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_repaint111].setDisplayName ( "" );
            methods[METHOD_requestDefaultFocus112] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestDefaultFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestDefaultFocus112].setDisplayName ( "" );
            methods[METHOD_requestFocus113] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestFocus113].setDisplayName ( "" );
            methods[METHOD_requestFocus114] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocus", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_requestFocus114].setDisplayName ( "" );
            methods[METHOD_requestFocusInWindow115] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocusInWindow", new Class[] {})); // NOI18N
            methods[METHOD_requestFocusInWindow115].setDisplayName ( "" );
            methods[METHOD_resetKeyboardActions116] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("resetKeyboardActions", new Class[] {})); // NOI18N
            methods[METHOD_resetKeyboardActions116].setDisplayName ( "" );
            methods[METHOD_reshape117] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("reshape", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_reshape117].setDisplayName ( "" );
            methods[METHOD_resize118] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_resize118].setDisplayName ( "" );
            methods[METHOD_resize119] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_resize119].setDisplayName ( "" );
            methods[METHOD_revalidate120] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("revalidate", new Class[] {})); // NOI18N
            methods[METHOD_revalidate120].setDisplayName ( "" );
            methods[METHOD_scrollRectToVisible121] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_scrollRectToVisible121].setDisplayName ( "" );
            methods[METHOD_setBounds122] = new MethodDescriptor(java.awt.Component.class.getMethod("setBounds", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_setBounds122].setDisplayName ( "" );
            methods[METHOD_setChanged123] = new MethodDescriptor(us.jaba.titaniumblocks.swing.panels.BasicPanel.class.getMethod("setChanged", new Class[] {})); // NOI18N
            methods[METHOD_setChanged123].setDisplayName ( "" );
            methods[METHOD_setComponentZOrder124] = new MethodDescriptor(java.awt.Container.class.getMethod("setComponentZOrder", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_setComponentZOrder124].setDisplayName ( "" );
            methods[METHOD_setDefaultLocale125] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("setDefaultLocale", new Class[] {java.util.Locale.class})); // NOI18N
            methods[METHOD_setDefaultLocale125].setDisplayName ( "" );
            methods[METHOD_setValueAnimated126] = new MethodDescriptor(us.jaba.titaniumblocks.swing.panels.ClockPanel.class.getMethod("setValueAnimated", new Class[] {double.class, double.class, double.class})); // NOI18N
            methods[METHOD_setValueAnimated126].setDisplayName ( "" );
            methods[METHOD_show127] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {})); // NOI18N
            methods[METHOD_show127].setDisplayName ( "" );
            methods[METHOD_show128] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_show128].setDisplayName ( "" );
            methods[METHOD_size129] = new MethodDescriptor(java.awt.Component.class.getMethod("size", new Class[] {})); // NOI18N
            methods[METHOD_size129].setDisplayName ( "" );
            methods[METHOD_toString130] = new MethodDescriptor(java.awt.Component.class.getMethod("toString", new Class[] {})); // NOI18N
            methods[METHOD_toString130].setDisplayName ( "" );
            methods[METHOD_transferFocus131] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocus", new Class[] {})); // NOI18N
            methods[METHOD_transferFocus131].setDisplayName ( "" );
            methods[METHOD_transferFocusBackward132] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusBackward", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusBackward132].setDisplayName ( "" );
            methods[METHOD_transferFocusDownCycle133] = new MethodDescriptor(java.awt.Container.class.getMethod("transferFocusDownCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusDownCycle133].setDisplayName ( "" );
            methods[METHOD_transferFocusUpCycle134] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusUpCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusUpCycle134].setDisplayName ( "" );
            methods[METHOD_unregisterKeyboardAction135] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_unregisterKeyboardAction135].setDisplayName ( "" );
            methods[METHOD_update136] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("update", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_update136].setDisplayName ( "" );
            methods[METHOD_updateUI137] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("updateUI", new Class[] {})); // NOI18N
            methods[METHOD_updateUI137].setDisplayName ( "" );
            methods[METHOD_validate138] = new MethodDescriptor(java.awt.Container.class.getMethod("validate", new Class[] {})); // NOI18N
            methods[METHOD_validate138].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods
        // Here you can add code for customizing the methods array.

        return methods;     }//GEN-LAST:Methods

    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons

    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx


//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.

//GEN-LAST:Superclass
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor()
    {
        return getBdescriptor();
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will belong
     * to the IndexedPropertyDescriptor subclass of PropertyDescriptor. A client
     * of getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors()
    {
        return getPdescriptor();
    }

    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors()
    {
        return getEdescriptor();
    }

    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors()
    {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors.
     * <P>
     * Returns -1 if there is no default property.
     */
    @Override
    public int getDefaultPropertyIndex()
    {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors.
     * <P>
     * Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex()
    {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from this
     * method.
     * <p>
     * There are four possible flavors of icons (16x16 color, 32x32 color, 16x16
     * mono, 32x32 mono). If a bean choses to only support a single icon we
     * recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background so they can be
     * rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind)
    {
        switch (iconKind)
        {
            case ICON_COLOR_16x16:
                if (iconNameC16 == null)
                {
                    return null;
                } else
                {
                    if (iconColor16 == null)
                    {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null)
                {
                    return null;
                } else
                {
                    if (iconColor32 == null)
                    {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null)
                {
                    return null;
                } else
                {
                    if (iconMono16 == null)
                    {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null)
                {
                    return null;
                } else
                {
                    if (iconMono32 == null)
                    {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
    
}
