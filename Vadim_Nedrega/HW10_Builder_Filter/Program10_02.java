package vadim_nedrega.HW10_Builder_Filter;

import vadim_nedrega.HW10_Builder_Filter.Filter.TextFileFilter;
import vadim_nedrega.HW10_Builder_Filter.Filter.TorrentFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program10_02 {
    private static final List<FileFilter> FILE_FILTER_LIST = new ArrayList<>();

    static {
        FILE_FILTER_LIST.add(new TextFileFilter());
        FILE_FILTER_LIST.add(new TorrentFileFilter());
    }

    public static void main(String[] args) {
        File file = new File("d:\\Загрузки\\");
        Set<File> fileSet = new HashSet<>();
        for (FileFilter fileFilter : FILE_FILTER_LIST) {
            File[] files = file.listFiles(fileFilter);
            if (files != null) {
                fileSet.addAll(Set.of(files));
            }
        }
        System.out.println(fileSet);

    }
}
