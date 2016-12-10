package constants;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by domagoj on 10/18/16.
 */
public class RecreationalLevels {
    public static final String RECREATIONAL = "R";

    public static final Map<String,Integer> DEPTH = new LinkedHashMap<String,Integer>() {{
        put("R0", 10);
        put("R1", 20);
        put("R2", 30);
        put("R3", 40);
        put("R4", 40);
        put("R5", 40);
    }};

    public static final ArrayList<FederationLevel> BSAC = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("R1", "Ocean Diver"));
        add(new FederationLevel("R2", "Ocean Diver"));
        add(new FederationLevel("R3", "Sports Diver"));
        add(new FederationLevel("R4", "Sports Diver"));
    }};

    public static final ArrayList<FederationLevel> CMAS = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("R1", "One Star Diver"));
        add(new FederationLevel("R2", "One Star Diver"));
        add(new FederationLevel("R3", "Two Star Diver"));
        add(new FederationLevel("R4", "Two Star Diver"));
    }};

    public static final ArrayList<FederationLevel> NAUI = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("R1", "Scuba Diver"));
        add(new FederationLevel("R2", "Advanced Scuba Diver"));
        add(new FederationLevel("R3", "Scuba Rescue Diver"));
        add(new FederationLevel("R4", "Master Scuba Diver"));
    }};

    public static final ArrayList<FederationLevel> SSI = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("R0", "Scuba Diver"));
        add(new FederationLevel("R1", "Open Water Diver"));
        add(new FederationLevel("R2", "Advanced Adventure"));
        add(new FederationLevel("R3", "Diver Stress & Rescue"));
        add(new FederationLevel("R4", "Advanced Open Water Diver"));
        add(new FederationLevel("R5", "Master Diver"));
    }};
}
