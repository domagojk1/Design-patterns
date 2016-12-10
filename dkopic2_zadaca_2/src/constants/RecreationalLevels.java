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
        put("R0", 0);
        put("R1", 10);
        put("R2", 20);
        put("R3", 30);
        put("R4", 40);
        put("R5", 40);
    }};

    public static final ArrayList<FederationLevel> BSAC = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("R1", "Ocean Diver", 1));
        add(new FederationLevel("R2", "Ocean Diver", 2));
        add(new FederationLevel("R3", "Sports Diver", 3));
        add(new FederationLevel("R4", "Sports Diver", 4));
    }};

    public static final ArrayList<FederationLevel> CMAS = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("R1", "One Star Diver", 1));
        add(new FederationLevel("R2", "One Star Diver", 2));
        add(new FederationLevel("R3", "Two Star Diver", 3));
        add(new FederationLevel("R4", "Two Star Diver", 4));
    }};

    public static final ArrayList<FederationLevel> NAUI = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("R1", "Scuba Diver", 1));
        add(new FederationLevel("R2", "Advanced Scuba Diver", 2));
        add(new FederationLevel("R3", "Scuba Rescue Diver", 3));
        add(new FederationLevel("R4", "Master Scuba Diver", 4));
    }};

    public static final ArrayList<FederationLevel> SSI = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("R0", "Scuba Diver", 0));
        add(new FederationLevel("R1", "Open Water Diver", 1));
        add(new FederationLevel("R2", "Advanced Adventure", 2));
        add(new FederationLevel("R3", "Diver Stress & Rescue", 3));
        add(new FederationLevel("R4", "Advanced Open Water Diver", 4));
        add(new FederationLevel("R5", "Master Diver", 5));
    }};
}
