package constants;

/**
 * Created by domagoj on 10/19/16.
 */
public class FederationLevel {
    private String sign;
    private String name;

    public FederationLevel(String sign, String name) {
        this.sign = sign;
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
