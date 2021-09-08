package vadim_nedrega.HW14_Refactoring;

import vadim_nedrega.HW14_Refactoring.datastore.DataStore;
import vadim_nedrega.HW14_Refactoring.datastore.DataStoreException;
import vadim_nedrega.HW14_Refactoring.datastore.FileDataStore;
import vadim_nedrega.HW14_Refactoring.datastore.User;

import java.util.List;

public class Program_14_01 {
    public static void main(String[] args) throws DataStoreException {
        DataStore<User> dataStore = new FileDataStore<>("D:\\Обучение IT\\Java Elementary\\Test\\SomeFile.json", User.class);
        User user = new User();
        user.setfName("fName_01");
        user.setmName("mName_01");
        user.setlName("lName_01");
        user.setAge((short) 42);

        User user2 = new User();
        user2.setfName("fName_02");
        user2.setmName("mName_02");
        user2.setlName("lName_02");
        user2.setAge((short) 73);

        dataStore.save(List.of(user, user2));

        System.out.println(dataStore.load());
    }
}
