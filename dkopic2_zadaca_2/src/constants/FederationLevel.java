package constants;

/**
 * Created by domagoj on 10/19/16.
 */
public class FederationLevel {
    private String levelSign;
    private String federation;
    private int absoluteLevel;

    public FederationLevel(String sign, String name) {
        this.levelSign = sign;
        this.federation = name;
    }

    public FederationLevel(String levelSign, String federation, int absoluteLevel) {
        this.levelSign = levelSign;
        this.federation = federation;
        this.absoluteLevel = absoluteLevel;
    }

    public String getLevelSign() {
        return levelSign;
    }

    public void setLevelSign(String levelSign) {
        this.levelSign = levelSign;
    }

    public String getFederation() {
        return federation;
    }

    public void setFederation(String federation) {
        this.federation = federation;
    }

    public int getAbsoluteLevel() {
        return absoluteLevel;
    }

    public void setAbsoluteLevel(int absoluteLevel) {
        this.absoluteLevel = absoluteLevel;
    }
}
