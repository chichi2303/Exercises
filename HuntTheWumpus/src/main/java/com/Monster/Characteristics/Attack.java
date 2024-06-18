package com.Monster.Characteristics;

import com.Monster.Models.Player;
import com.Monster.Models.Monster;
import com.Monster.Models.Map;

public interface Attack {

  boolean attackWumpus(Player player, Map map, Monster monster);
}
