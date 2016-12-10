
package adapter;

import constants.FederationLevel;
import constants.RecreationalLevels;
import constants.ProLevels;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by domagoj on 10/18/16.
 */
public class LevelManagerAdapter implements LevelAdapter {
    private LevelManager levelManager;
    private FederationLevel level;
    private String levelSign;
    private String federation;
    private int counter;

    public LevelManagerAdapter(String levelSign, String federation) {
        this.levelSign = levelSign;
        this.federation = federation;
        this.counter = 0;
        levelManager = new LevelManager(levelSign, federation);
    }

    @Override
    public FederationLevel getAdaptedLevel() {
        FederationLevel producedLevel = levelManager.getLevel();
        String levelType = "";

        if (producedLevel == null) {

            if (levelSign.startsWith(RecreationalLevels.RECREATIONAL)) {
                levelType = RecreationalLevels.RECREATIONAL;

                switch (federation) {
                    case "BSAC":
                        producedLevel = getAdaptedLevel(RecreationalLevels.BSAC, levelType, counter);
                        break;
                    case "CMAS":
                        producedLevel = getAdaptedLevel(RecreationalLevels.CMAS, levelType, counter);
                        break;
                    case "NAUI":
                        producedLevel = getAdaptedLevel(RecreationalLevels.NAUI, levelType, counter);
                        break;
                    case "SSI":
                        producedLevel = getAdaptedLevel(RecreationalLevels.SSI, levelType, counter);
                        break;
                    default:
                        System.out.println("Federation is not available.");
                        break;
                }
            } else if (levelSign.startsWith(ProLevels.PRO)) {
                levelType = ProLevels.PRO;

                switch (federation) {
                    case "BSAC":
                        producedLevel = getAdaptedLevel(ProLevels.BSAC, levelType, counter);
                        break;
                    case "CMAS":
                        producedLevel = getAdaptedLevel(ProLevels.CMAS, levelType, counter);
                        break;
                    case "NAUI":
                        producedLevel = getAdaptedLevel(ProLevels.NAUI, levelType, counter);
                        break;
                    case "SSI":
                        producedLevel = getAdaptedLevel(ProLevels.SSI, levelType, counter);
                        break;
                    default:
                        System.out.println("Federation is not available.");
                        break;
                }
            }
        }

        return producedLevel;
    }

    private FederationLevel getAdaptedLevel(ArrayList<FederationLevel> list, String levelType, int counter) {
        int levelNum = getLevelNumber(levelSign);
        Iterator<FederationLevel> it = list.iterator();
        FederationLevel adaptedLevel = null;

        if (it != null) {
            while (it.hasNext() || adaptedLevel == null) {
                int next = levelNum + counter;
                int prev = levelNum - counter;
                String signValue = it.next().getLevelSign();

                if(signValue.equals(levelType + prev)) {
                    adaptedLevel = new FederationLevel(signValue, federation);
                    break;
                }
                else if (signValue.equals(levelType + next)) {
                    adaptedLevel = new FederationLevel(signValue, federation);
                    break;
                }

                if (adaptedLevel == null && !it.hasNext()) {
                    counter = counter + 1;
                    it = list.iterator();
                }
            }
        }

        String sign = adaptedLevel.getLevelSign();

        if (adaptedLevel != null) {
            if (sign.startsWith(ProLevels.PRO)) {
                switch (federation) {
                    case "BSAC":
                        for (FederationLevel level : ProLevels.BSAC) {
                            if (level.getLevelSign().equals(sign)) {
                                adaptedLevel.setAbsoluteLevel(level.getAbsoluteLevel());
                            }
                        }
                        break;
                    case "CMAS":
                        for (FederationLevel level : ProLevels.BSAC) {
                            if (level.getLevelSign().equals(sign)) {
                                adaptedLevel.setAbsoluteLevel(level.getAbsoluteLevel());
                            }
                        }
                        break;
                    case "NAUI":
                        for (FederationLevel level : ProLevels.BSAC) {
                            if (level.getLevelSign().equals(sign)) {
                                adaptedLevel.setAbsoluteLevel(level.getAbsoluteLevel());
                            }
                        }
                        break;
                    case "SSI":
                        for (FederationLevel level : ProLevels.BSAC) {
                            if (level.getLevelSign().equals(sign)) {
                                adaptedLevel.setAbsoluteLevel(level.getAbsoluteLevel());
                            }
                        }
                        break;
                }
            }
            else if (sign.startsWith(RecreationalLevels.RECREATIONAL)) {
                switch (federation) {
                    case "BSAC":
                        for (FederationLevel level : RecreationalLevels.BSAC) {
                            if (level.getLevelSign().equals(sign)) {
                                adaptedLevel.setAbsoluteLevel(level.getAbsoluteLevel());
                            }
                        }
                        break;
                    case "CMAS":
                        for (FederationLevel level : RecreationalLevels.BSAC) {
                            if (level.getLevelSign().equals(sign)) {
                                adaptedLevel.setAbsoluteLevel(level.getAbsoluteLevel());
                            }
                        }
                        break;
                    case "NAUI":
                        for (FederationLevel level : RecreationalLevels.BSAC) {
                            if (level.getLevelSign().equals(sign)) {
                                adaptedLevel.setAbsoluteLevel(level.getAbsoluteLevel());
                            }
                        }
                        break;
                    case "SSI":
                        for (FederationLevel level : RecreationalLevels.BSAC) {
                            if (level.getLevelSign().equals(sign)) {
                                adaptedLevel.setAbsoluteLevel(level.getAbsoluteLevel());
                            }
                        }
                        break;
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
