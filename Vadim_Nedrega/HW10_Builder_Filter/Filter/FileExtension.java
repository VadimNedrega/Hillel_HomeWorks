package vadim_nedrega.HW10_Builder_Filter.Filter;

import java.io.File;
import java.io.FileFilter;
import java.util.Set;

public abstract class FileExtension implements FileFilter {
    private final Set<String> extensionSet;

    public FileExtension(Set<String> extensionSet) {
        this.extensionSet = extensionSet;
    }

    public Set<String> getExtensionSet() {
        return extensionSet;
    }

    @Override
    public boolean accept(File pathname) {
        if (pathname == null || pathname.isDirectory()) {
            return false;
        }
        String extName = extensionSet(pathname.getName());
        return getExtensionSet().contains(extName);
    }

    private String extensionSet(String pathname) {
        String path = pathname.toLowerCase();
        int extIndex = path.lastIndexOf(".");
        return path.substring(extIndex + 1);
    }
}
