package utils;

import builder.Diver;
import constants.ProLevels;
import constants.RecreationalLevels;

import java.util.ArrayList;

/**
 * Created by domagoj on 10/20/16.
 */
public class Helper {

    public static ArrayList<DiveEvent> setDepths(ArrayList<DiveEvent> dives) {
        for (DiveEvent diveEvent : dives) {
            ArrayList<Diver> divers = diveEvent.getDivers();
            int allowedDepth = diveEvent.getSchedule().getMaxDivingDepth();

            for (Diver diver : divers) {
                int diversDepth = getMaxDepth(diver, divers, allowedDepth);
                diver.setDepth(diversDepth);
            }
        }

        return dives;
    }

    private static int getMaxDepth (Diver currentDiver, ArrayList<Diver> divers, int allowedDepth) {
        String currentLevelSign = currentDiver.getLevel().getLevelSign();
        int currentLevel = getLevelNumber(currentLevelSign);
        int depth = 0;

        if (currentLevelSign.startsWith(ProLevels.PRO) || currentLevel >= 3) {
            depth = allowedDepth;
        }
        else {
            for (Diver diver : divers) {
                String levelSign = diver.getLevel().getLevelSign();
                int diverLevel = getLevelNumber(levelSign);

                if (currentLevelSign == levelSign) {
                    depth = RecreationalLevels.DEPTH.get(levelSign);
                }
                else {
                    if (diverLevel > currentLevel) {
                        int nextLevel = diverLevel + 1;

                        if (RecreationalLevels.DEPTH.containsKey(RecreationalLevels.RECREATIONAL + nextLevel)) {
                            depth = RecreationalLevels.DEPTH.get(RecreationalLevels.RECREATIONAL + nextLevel);
                        }
                        else {
                            depth = RecreationalLevels.DEPTH.get(levelSign);
                        }

                        break;
                    }
                }
            }
            //check if selected depth is bigger then allowed
            if (depth > allowedDepth) depth = allowedDepth;
        }

        return depth;
    }

    public static int getLevelNumber (String level) {
        level = level.replaceAll("\\D+","");
        return Integer.parseInt(level);
    }
}
