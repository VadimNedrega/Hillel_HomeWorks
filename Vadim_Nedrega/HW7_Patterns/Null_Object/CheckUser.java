package vadim_nedrega.HW7_Patterns.Null_Object;

import java.io.IOException;
import java.util.ArrayList;

public class CheckUser {

    private ListOfRegisteredUsers listOfRegisteredUsers = new ListOfRegisteredUsers();
    private ArrayList<User> list = listOfRegisteredUsers.getListOfRegistratedUsers();

    public CheckUser() throws IOException {

    }

    public User getUser(String name) {
        for (User user : list) {
            if (name.equals(user.toString())) {
                user.searchWebSite();
                return user;
            }
        }
        User user = new Guest();
        user.searchWebSite();
        return new Guest();
    }

}
