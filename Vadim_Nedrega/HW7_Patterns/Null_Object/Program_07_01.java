package vadim_nedrega.HW7_Patterns.Null_Object;

import vadim_nedrega.HW7_Patterns.Null_Object.CheckUser;

import java.io.IOException;

public class Program_07_01 {
    public static void main(String[] args) throws IOException {
        CheckUser check = new CheckUser();
        check.getUser("User 1");
        check.getUser("User 2");
        check.getUser("Я тут первый раз");

    }
}
