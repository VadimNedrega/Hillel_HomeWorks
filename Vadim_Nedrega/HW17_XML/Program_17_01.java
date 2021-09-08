package vadim_nedrega.HW17_XML;

import vadim_nedrega.HW17_XML.XMLDataStore.DataStore;
import vadim_nedrega.HW17_XML.XMLDataStore.Player;
import vadim_nedrega.HW17_XML.XMLDataStore.XMLPlayerDataStore;

import java.util.List;

public class Program_17_01 {
    public static void main(String[] args) {
        DataStore<Player> dataStore = new XMLPlayerDataStore<>("vadim_nedrega/HW17_XML/XMLDataStore/player.xml");

        Player player = new Player("Vasja", 18, true);
        Player player1 = new Player("John", 23, false);
        Player player2 = new Player("Marusja", 27, true);

        dataStore.save(List.of(player, player1, player2));
        System.out.println(dataStore.load());
    }
}
