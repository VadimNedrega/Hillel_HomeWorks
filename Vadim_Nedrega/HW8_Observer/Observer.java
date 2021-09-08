package vadim_nedrega.HW8_Observer;

import java.util.Date;

public interface Observer {
    void updateInfoStopKiln(String alarm, Date stop, String comments);

    void updateInfoStartKiln(String alarm, Date start);
}
