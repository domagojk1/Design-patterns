package utils;

import builder.Diver;

import java.util.ArrayList;

/**
 * Created by domagoj on 11/14/16.
 */
public class SafetyManager {

    private static int minLevelId;

    public static int getMinLevelId() {
        return minLevelId;
    }

    public static void setMinLevelId(int minLevelId) {
        SafetyManager.minLevelId = minLevelId;
    }

    public static int calculateSafetyLevels(ArrayList<DiveEvent> events) {
        int levelSum = 0;
        int max, min;
        int maxDepth, absLevelDiff;

        for (DiveEvent diveEvent : events) {
            maxDepth = diveEvent.getSchedule().getMaxDivingDepth();

            ArrayList<Diver> divers = diveEvent.getDivers();

            if (divers.size() > 0) {
                max = divers.get(0).getLevel().getAbsoluteLevel();
                min = max;

                for (int i = 1; i < divers.size(); i++) {
                    int absLevel = divers.get(i).getLevel().getAbsoluteLevel();

                    if (absLevel> max) {
                        max = absLevel;
                    }

                    if (absLevel < min) {
                        min = absLevel;
                    }
                }

                absLevelDiff = (max - min) + 1;
                int groupSafetyLevel = maxDepth / absLevelDiff;
                diveEvent.setSafetyLevel(groupSafetyLevel);

                levelSum += groupSafetyLevel;
            }
        }

        setCurrentMin(levelSum);
        return levelSum;
    }

    private static void setCurrentMin (int number) {
        if (minLevelId == 0) setMinLevelId(number);
        else {
            if (number < minLevelId) {
                setMinLevelId(number);
            }
        }
    }
}
