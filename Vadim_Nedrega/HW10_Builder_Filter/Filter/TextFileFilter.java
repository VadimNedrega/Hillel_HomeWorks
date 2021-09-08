package vadim_nedrega.HW10_Builder_Filter.Filter;

import java.util.Set;

public class TextFileFilter extends FileExtension {
    public TextFileFilter() {
        super(Set.of("txt", "rtf", "doc", "docx", "fb2"));
    }
}
