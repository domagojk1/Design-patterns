package constants;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by domagoj on 10/18/16.
 */
public class ProLevels {
    public static final String PRO = "I";

    public static final Map<String,Integer> DEPTH = new LinkedHashMap<String,Integer>() {{
        put("I", 40);
    }};

    public static final ArrayList<FederationLevel> SSI = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("I0", "Dive Guide", 6));
        add(new FederationLevel("I1", "Divemaster", 7));
        add(new FederationLevel("I2", "Dive Control Specialist", 8));
        add(new FederationLevel("I3", "Open Water Instructor", 9));
        add(new FederationLevel("I4", "Advanced Open Water Instructor", 10));
        add(new FederationLevel("I5", "Divemaster Instructor", 11));
        add(new FederationLevel("I6", "Dive Control Specialist Instructor", 12));
        add(new FederationLevel("I7", "Instructor Trainer", 13));
    }};

    public static final ArrayList<FederationLevel> NAUI = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("I0", "Assistant Instructor", 6));
        add(new FederationLevel("I2", "Divemaster", 8));
        add(new FederationLevel("I3", "Instructor", 9));
        add(new FederationLevel("I7", "Instructor Trainer", 13));
    }};

    public static final ArrayList<FederationLevel> BSAC = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("I0", "Dive Leader", 6));
        add(new FederationLevel("I2", "Assistant Open Water Instructor", 8));
        add(new FederationLevel("I3", "Open Water Instructor", 9));
        add(new FederationLevel("I4", "Advanced Instructor", 10));
    }};

    public static final ArrayList<FederationLevel> CMAS = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("I0", "Three Star Diver", 6));
        add(new FederationLevel("I2", "One Star Instructor", 8));
        add(new FederationLevel("I3", "Two Star Instructor", 9));
    }};
}
