package vadim_nedrega.HW18_Serialization;

import vadim_nedrega.HW18_Serialization.Objects.FootballManager;
import vadim_nedrega.HW18_Serialization.Objects.FootballPlayer;
import vadim_nedrega.HW18_Serialization.Objects.Nationality;
import vadim_nedrega.HW18_Serialization.Objects.SportManager;

import java.io.*;

public class Program_18_01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("vadim_nedrega/HW18_Serialization/Program_18_01.txt");

        OutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        InputStream inputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(inputStream);

        FootballPlayer sadio = new FootballPlayer("Sadio Mane", 26, false, "forward");
        SportManager valery = new SportManager("Валерий Викторович", 53, "Pobeda");
        FootballManager yurgen = new FootballManager("Yurgen Klopp", 52, "Liverpool",
                Nationality.German, sadio, "Mendesh");

        oos.writeObject(sadio);
        oos.writeObject(valery);
        oos.writeObject(yurgen);

        System.out.println(sadio + "\n" + valery + "\n" + yurgen);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        FootballPlayer restoredPlayer = (FootballPlayer) ois.readObject();
        SportManager restoredSportManager = (SportManager) ois.readObject();
        FootballManager restoredFootballManager = (FootballManager) ois.readObject();

        System.out.println(restoredPlayer + "\n" + restoredSportManager + "\n" + restoredFootballManager);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(restoredPlayer.equals(sadio) + "\n"
                + restoredSportManager.equals(valery) + "\n"
                + restoredFootballManager.equals(yurgen));


    }
}
