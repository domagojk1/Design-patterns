package adapter;

import constants.FederationLevel;
import constants.RecreationalLevels;
import constants.ProLevels;


/**
 * Created by domagoj on 10/18/16.
 */
public class LevelManager implements Manager {
    private String levelSign;
    private String federation;

    public LevelManager(String levelSign, String federation) {
        this.levelSign = levelSign;
        this.federation = federation;
    }

    @Override
    public FederationLevel getLevel() {
        if (levelSign.startsWith(RecreationalLevels.RECREATIONAL)) {

            switch (federation) {
                case "BSAC":
                    for (FederationLevel l : RecreationalLevels.BSAC) {
                        if (l.getLevelSign().equals(levelSign)) {
                            l.setFederation(federation);
                            return l;
                        }
                    }
                    break;
                case "CMAS":
                    for (FederationLevel l : RecreationalLevels.CMAS) {
                        if (l.getLevelSign().equals(levelSign)) {
                            l.setFederation(federation);
                            return l;
                        }
                    }
                    break;
                case "NAUI":
                    for (FederationLevel l : RecreationalLevels.NAUI) {
                        if (l.getLevelSign().equals(levelSign)) {
                            l.setFederation(federation);
                            return l;
                        }
                    }
                    break;
                case "SSI":
                    for (FederationLevel l : RecreationalLevels.SSI) {
                        if (l.getLevelSign().equals(levelSign)) {
                            l.setFederation(federation);
                            return l;
                        }
                    }
                    break;
                default:
                    System.out.println("Federacija " + federation + " ne postoji.");
                    break;
            }
        }
        else if (levelSign.startsWith(ProLevels.PRO)) {

            switch (federation) {
                case "BSAC":
                    for (FederationLevel l : ProLevels.BSAC) {
                        if (l.getLevelSign().equals(levelSign)) {
                            l.setFederation(federation);
                            return l;
                        }
                    }
                    break;
                case "CMAS":
                    for (FederationLevel l : ProLevels.CMAS) {
                        if (l.getLevelSign().equals(levelSign)) {
                            l.setFederation(federation);
                            return l;
                        }
                    }
                    break;
                case "NAUI":
                    for (FederationLevel l : ProLevels.NAUI) {
                        if (l.getLevelSign().equals(levelSign)) {
                            l.setFederation(federation);
                            return l;
                        }
                    }
                    break;
                case "SSI":
                    for (FederationLevel l : ProLevels.SSI) {
                        if (l.getLevelSign().equals(levelSign)) {
                            l.setFederation(federation);
                            return l;
                        }
                    }
                    break;
                default:
                    System.out.println("Federacija " + federation + " ne postoji.");
                    break;
            }
        }
        else {
            System.out.println("Oznaka " + levelSign + " ne postoji.");
        }

        return null;
    }
}
