package adapter;

/**
 * Created by domagoj on 10/18/16.
 */
public class Level {
    private String federation;
    private String levelSign;

    public Level(String federation, String levelSign) {
        this.federation = federation;
        this.levelSign = levelSign;
    }

    public String getFederation() {
        return federation;
    }

    public void setFederation(String federation) {
        this.federation = federation;
    }

    public String getLevelSign() {
        return levelSign;
    }

    public void setLevelSign(String levelSign) {
        this.levelSign = levelSign;
    }
}
