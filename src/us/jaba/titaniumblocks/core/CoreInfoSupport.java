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

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import us.jaba.titaniumblocks.core.utils.ClassFinder;

/**
 *
 * @author tbeckett
 */
public class CoreInfoSupport
{

    public static final String TITANIUM_BLOCKS = "Titanium Blocks";
    public static final String RECTANGULAR_MODEL = "rectangular";
    public static final String ROUND_MODEL = "round";

    public static List<Class<?>> getAllModelClasses(Class c)
    {
        List<Class<?>> classes = ClassFinder.find(c.getPackage().getName() + "." + CoreInfoSupport.RECTANGULAR_MODEL);
        List<Class<?>> rclasses = ClassFinder.find(c.getPackage().getName() + "." + CoreInfoSupport.ROUND_MODEL);

        classes.addAll(rclasses);

        return classes;
    }

    public static List<Object> getInstanceOfEach(List<Class<?>> classes)
    {
        ArrayList la = new ArrayList();

        Iterator<Class<?>> i = classes.iterator();
        while (i.hasNext())
        {
            Class<?> aClass = i.next();
            Constructor c;
            try
            {
                c = aClass.getConstructor();
                Object instance = c.newInstance();
                la.add(instance);
            } catch (NoSuchMethodException ex)
            {
                Logger.getLogger(CoreInfoSupport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex)
            {
                Logger.getLogger(CoreInfoSupport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex)
            {
                Logger.getLogger(CoreInfoSupport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex)
            {
                Logger.getLogger(CoreInfoSupport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex)
            {
                Logger.getLogger(CoreInfoSupport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex)
            {
                Logger.getLogger(CoreInfoSupport.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return la;
    }

    public static List<Class<?>> getListClasses(String path, String[] classNames)
    {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ArrayList<Class<?>> al = new ArrayList();
        for (String s : classNames)
        {
            try
            {
                Class<?> c = classLoader.loadClass(path+"."+s);
                al.add(c);
            } catch (Exception exp)
            {

            }

        }
        return al;
    }

    public static List<Class<?>> getRadialPainterClasses(Class<?> aClass)
    {

        return ClassFinder.find(aClass.getPackage().getName() + "." + CoreInfoSupport.ROUND_MODEL);
    }

    public static List<Class<?>> getLinearPainterClasses(Class<?> aClass)
    {
        return ClassFinder.find(aClass.getPackage().getName() + "." + CoreInfoSupport.RECTANGULAR_MODEL);
    }

    public static List<Class<?>> getModelsClasses(Class<?> aClass)
    {

        return ClassFinder.find(aClass.getPackage().getName() + ".models");
    }

    public static List<Class<?>> getRectangularPainterClasses(Class<?> aClass)
    {
        return ClassFinder.find(aClass.getPackage().getName() + ".rectangular");
    }

    public static List<Class<?>> getRoundPainterClasses(Class<?> aClass)
    {

        return ClassFinder.find(aClass.getPackage().getName() + ".round");
    }

    public static List<Field> getStaticFields(Class<?> aClass)
    {
        Field[] declaredFields = aClass.getDeclaredFields();
        List<Field> staticFields = new ArrayList();
        for (Field field : declaredFields)
        {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers()))
            {
                staticFields.add(field);
            }
        }
        return staticFields;
    }
}
