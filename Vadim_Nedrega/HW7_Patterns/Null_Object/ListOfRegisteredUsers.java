package vadim_nedrega.HW7_Patterns.Null_Object;

import java.util.ArrayList;

public class ListOfRegisteredUsers {


    public ArrayList<User> getListOfRegistratedUsers() {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(new RegisteredUser("User " + i));
        }
        return list;
    }
}
