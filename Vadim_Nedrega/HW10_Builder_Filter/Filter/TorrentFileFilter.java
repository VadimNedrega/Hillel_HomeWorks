package vadim_nedrega.HW10_Builder_Filter.Filter;

import java.util.Set;

public class TorrentFileFilter extends FileExtension {
    public TorrentFileFilter() {
        super(Set.of("torrent"));
    }
}
