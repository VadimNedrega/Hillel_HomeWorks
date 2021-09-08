package vadim_nedrega.HW14_Refactoring.datastore;

public class User {
    private String fName;
    private String mName;
    private String lName;
    private short age;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Имя: " + getfName() + " "
                + "Фамилия: " + getlName() + " "
                + "Отчество: " + getmName() + " "
                + "Возраст: " + getAge();
    }
}
