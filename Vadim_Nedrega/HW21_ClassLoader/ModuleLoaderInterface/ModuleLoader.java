package vadim_nedrega.HW21_ClassLoader.ModuleLoaderInterface;

import vadim_nedrega.HW21_ClassLoader.FileModuleLoader.FileModuleExceptions;

public interface ModuleLoader {
    Class<?> findClass(String className) throws ClassNotFoundException;

    byte[] getClassByteArr(String className) throws FileModuleExceptions;
}
