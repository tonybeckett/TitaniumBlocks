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
public final class ResourceFinder
{

    private final static char DOT = '.';
    private final static char SLASH = '/';

    private final static String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the given '%s' package exists?";

    public final static List<String> find(final String scannedPackage)
    {
        final List<String> files = new LinkedList<String>();
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final String scannedPath = scannedPackage.replace(DOT, SLASH);
        final Enumeration<URL> resources;
        try
        {
            resources = classLoader.getResources(scannedPath);
        } catch (IOException e)
        {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage), e);
        }
        final List<Class<?>> classes = new LinkedList<Class<?>>();
        while (resources.hasMoreElements())
        {
            final File file = new File(resources.nextElement().getFile());
            files.addAll(find(file, scannedPackage));
        }
        return files;

    }

    private final static List<String> find(final File file, final String scannedPackage)
    {
        final List<String> files = new LinkedList<String>();
        if (file.isDirectory())
        {
            for (File nestedFile : file.listFiles())
            {
                files.add(nestedFile.getName());
            }

        }
        return files;
    }

}
