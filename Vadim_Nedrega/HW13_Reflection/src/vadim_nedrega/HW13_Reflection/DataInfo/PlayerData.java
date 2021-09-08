package vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.DataInfo;

import vadim_nedrega.HW13_Reflection.src.vadim_nedrega.HW13_Reflection.Player.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlayerData implements Data<Player> {

    private final Map<Player, Integer> playerData = new HashMap<>();
    private final String CLASS_NAME = "Player Data";

    public PlayerData() {
        for (int i = 0; i < 5; i++) {
            Player player = new Player();
            player.setName("Player_" + i);
            player.setId(i + 100);
            playerData.put(player, i);
        }
    }

    @Override
    public String getName() {
        return CLASS_NAME;
    }

    @Override
    public Map<Player, Integer> getData() {
        return this.playerData;
    }


    @Override
    public void setData(Map<Player, Integer> dataMap) {
        playerData.clear();
        playerData.putAll(dataMap);
    }


    @Override
    public void addData(Map<Player, Integer> dataMap) {
        playerData.putAll(dataMap);
    }

    public Player findPlayerByName(String name) throws DataInfoExceptions {
        Player result = null;
        Set<String> playerName = new HashSet<>();
        for (Map.Entry<Player, Integer> entry : playerData.entrySet()) {
            Player key = entry.getKey();
            playerName.add(key.getName());
            if (key.getName().equals(name)) {
                result = key;
                break;
            }
        }
        if (!playerName.contains(name)) throw new DataInfoExceptions("No one player had been found" +
                "with this name");
        return result;
    }
}
