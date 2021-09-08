package vadim_nedrega.HW21_ClassLoader.FileModuleLoader;

import vadim_nedrega.HW21_ClassLoader.ModuleLoaderInterface.ModuleLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class FileModuleLoader extends ClassLoader implements ModuleLoader {
    private final String directory;

    public FileModuleLoader(String directory) {
        this.directory = directory;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] b = new byte[0];
        try {
            b = getClassByteArr(className);
        } catch (FileModuleExceptions fileModuleExceptions) {
            fileModuleExceptions.printStackTrace();
        }
        return defineClass(className, b, 0, b.length);
    }

    @Override
    public byte[] getClassByteArr(String className) throws FileModuleExceptions {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(
                className.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ((nextValue = inStream.read()) != -1) {
                bStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = bStream.toByteArray();
        try {
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
