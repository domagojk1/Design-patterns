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
        add(new FederationLevel("I0", "Dive Guide"));
        add(new FederationLevel("I1", "Divemaster"));
        add(new FederationLevel("I2", "Dive Control Specialist"));
        add(new FederationLevel("I3", "Open Water Instructor"));
        add(new FederationLevel("I4", "Advanced Open Water Instructor "));
        add(new FederationLevel("I5", "Divemaster Instructor"));
        add(new FederationLevel("I6", "Dive Control Specialist Instructor"));
        add(new FederationLevel("I7", "Instructor Trainer"));
    }};

    public static final ArrayList<FederationLevel> NAUI = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("I0", "Assistant Instructor"));
        add(new FederationLevel("I2", "Divemaster"));
        add(new FederationLevel("I3", "Instructor"));
        add(new FederationLevel("I7", "Instructor Trainer"));
    }};

    public static final ArrayList<FederationLevel> BSAC = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("I0", "Dive Leader"));
        add(new FederationLevel("I2", "Assistant Open Water Instructor"));
        add(new FederationLevel("I3", "Open Water Instructor"));
        add(new FederationLevel("I4", "Advanced Instructor"));
    }};

    public static final ArrayList<FederationLevel> CMAS = new ArrayList<FederationLevel>() {{
        add(new FederationLevel("I0", "Three Star Diver"));
        add(new FederationLevel("I2", "One Star Instructor"));
        add(new FederationLevel("I3", "Two Star Instructor"));
    }};
}
