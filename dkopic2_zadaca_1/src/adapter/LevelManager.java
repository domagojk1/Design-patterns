package adapter;

import constants.FederationLevel;
import constants.RecreationalLevels;
import constants.ProLevels;


/**
 * Created by domagoj on 10/18/16.
 */
public class LevelManager implements Manager {
    private Level level;

    public LevelManager(Level level) {
        this.level = level;
    }

    @Override
    public Level getLevel() {
        boolean exists = false;

        if (level.getLevelSign().startsWith(RecreationalLevels.RECREATIONAL)) {

            switch (level.getFederation()) {
                case "BSAC":
                    for (FederationLevel l : RecreationalLevels.BSAC) {
                        if (l.equals(level.getLevelSign())) {
                            exists = true;
                        }
                    }
                    break;
                case "CMAS":
                    for (FederationLevel l : RecreationalLevels.CMAS) {
                        if (l.equals(level.getLevelSign())) {
                            exists = true;
                        }
                    }
                    break;
                case "NAUI":
                    for (FederationLevel l : RecreationalLevels.NAUI) {
                        if (l.equals(level.getLevelSign())) {
                            exists = true;
                        }
                    }
                    break;
                case "SSI":
                    for (FederationLevel l : RecreationalLevels.SSI) {
                        if (l.equals(level.getLevelSign())) {
                            exists = true;
                        }
                    }
                    break;
                default:
                    System.out.println("Federacija " + level.getFederation() + " ne postoji.");
                    break;
            }
        }
        else if (level.getLevelSign().startsWith(ProLevels.PRO)) {

            switch (level.getFederation()) {
                case "BSAC":
                    for (FederationLevel l : ProLevels.BSAC) {
                        if (l.equals(level.getLevelSign())) {
                            exists = true;
                        }
                    }
                    break;
                case "CMAS":
                    for (FederationLevel l : ProLevels.CMAS) {
                        if (l.equals(level.getLevelSign())) {
                            exists = true;
                        }
                    }
                    break;
                case "NAUI":
                    for (FederationLevel l : ProLevels.NAUI) {
                        if (l.equals(level.getLevelSign())) {
                            exists = true;
                        }
                    }
                    break;
                case "SSI":
                    for (FederationLevel l : ProLevels.SSI) {
                        if (l.equals(level.getLevelSign())) {
                            exists = true;
                        }
                    }
                    break;
                default:
                    System.out.println("Federacija " + level.getFederation() + " ne postoji.");
                    break;
            }
        }
        else {
            System.out.println("Oznaka " + level.getLevelSign() + " ne postoji.");
        }

        if (exists) {
            return this.level;
        }
        else {
            return null;
        }
    }
}
