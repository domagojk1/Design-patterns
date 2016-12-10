
package adapter;

import constants.FederationLevel;
import constants.RecreationalLevels;
import constants.ProLevels;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by domagoj on 10/18/16.
 */
public class LevelManagerAdapter implements Manager {
    private LevelManager levelManager;
    private Level level;
    private int counter;

    public LevelManagerAdapter(Level level) {
        this.level = level;
        this.counter = 0;
        levelManager = new LevelManager(level);
    }

    @Override
    public Level getLevel() {
        Level producedLevel = levelManager.getLevel();
        String levelType = "";

        if (producedLevel == null) {

            if (level.getLevelSign().startsWith(RecreationalLevels.RECREATIONAL)) {
                levelType = RecreationalLevels.RECREATIONAL;

                switch (level.getFederation()) {
                    case "BSAC":
                        producedLevel = getAdaptedLevel(RecreationalLevels.BSAC, level, levelType, counter);
                        break;
                    case "CMAS":
                        producedLevel = getAdaptedLevel(RecreationalLevels.CMAS, level, levelType, counter);
                        break;
                    case "NAUI":
                        producedLevel = getAdaptedLevel(RecreationalLevels.NAUI, level, levelType, counter);
                        break;
                    case "SSI":
                        producedLevel = getAdaptedLevel(RecreationalLevels.SSI, level, levelType, counter);
                        break;
                    default:
                        System.out.println("Federation is not available.");
                        break;
                }
            } else if (level.getLevelSign().startsWith(ProLevels.PRO)) {
                levelType = ProLevels.PRO;

                switch (level.getFederation()) {
                    case "BSAC":
                        producedLevel = getAdaptedLevel(ProLevels.BSAC, level, levelType, counter);
                        break;
                    case "CMAS":
                        producedLevel = getAdaptedLevel(ProLevels.CMAS, level, levelType, counter);
                        break;
                    case "NAUI":
                        producedLevel = getAdaptedLevel(ProLevels.NAUI, level, levelType, counter);
                        break;
                    case "SSI":
                        producedLevel = getAdaptedLevel(ProLevels.SSI, level, levelType, counter);
                        break;
                    default:
                        System.out.println("Federation is not available.");
                        break;
                }
            }
        }

        return producedLevel;
    }

    private Level getAdaptedLevel(ArrayList<FederationLevel> list, Level level, String levelType, int counter) {
        int levelNum = getLevelNumber(level.getLevelSign());
        Iterator<FederationLevel> it = list.iterator();
        Level adaptedLevel = null;

        if (it != null) {
            while (it.hasNext() || adaptedLevel == null) {
                int next = levelNum + counter;
                int prev = levelNum - counter;
                String value = it.next().getSign();

                if(value.equals(levelType + prev)) {
                    adaptedLevel = new Level(level.getFederation(), value);
                    break;
                }
                else if (value.equals(levelType + next)) {
                    adaptedLevel = new Level(level.getFederation(), value);
                    break;
                }

                if (adaptedLevel == null && !it.hasNext()) {
                    counter = counter + 1;
                    it = list.iterator();
                }
            }
        }

        return adaptedLevel;
    }

    private int getLevelNumber (String level) {
        level = level.replaceAll("\\D+","");
        return Integer.parseInt(level);
    }
}
