
package us.jaba.titaniumblocks.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author unknown 
 */
public final class ClassFinder
{

    private final static char DOT = '.';
    private final static char SLASH = '/';
    private final static String CLASS_SUFFIX = ".class";
    private final static String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the given '%s' package exists?";

    public final static List<Class<?>> find(final String scannedPackage)
    {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final String scannedPath = scannedPackage.replace(DOT, SLASH);
         Enumeration<URL> resources = null;
        try
        {
            resources = classLoader.getResources(scannedPath);
        } catch (IOException e)
        {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage), e);
        } catch (Exception e)
        {
            
        }
        
        final List<Class<?>> classes = new LinkedList<>();
        while (resources.hasMoreElements())
        {
            final File file = new File(resources.nextElement().getFile());
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }

    private static List<Class<?>> find(final File file, final String scannedPackage)
    {
        final List<Class<?>> classes = new LinkedList<>();
        if (file.isDirectory())
        {
            for (File nestedFile : file.listFiles())
            {
                classes.addAll(find(nestedFile, scannedPackage));
            }
            //File names with the $1, $2 holds the anonymous inner classes, we are not interested on them. 
        } else if (file.getName().endsWith(CLASS_SUFFIX) && !file.getName().contains("$"))
        {

            final int beginIndex = 0;
            final int endIndex = file.getName().length() - CLASS_SUFFIX.length();
            final String className = file.getName().substring(beginIndex, endIndex);
            try
            {
                final String resource = scannedPackage + DOT + className;
                Class<?> c = ClassFinder.class.getClassLoader().loadClass(className);
//                Class<?> c = Class.forName(resource);
                classes.add(c);
            } catch (ClassNotFoundException ignore)
            {
            } catch (Exception exp)
            {
                exp.printStackTrace();
            }
        }
        return classes;
    }

   

}
