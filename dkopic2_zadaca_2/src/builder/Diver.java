package builder;

import adapter.LevelManagerAdapter;
import constants.FederationLevel;
import constants.ProLevels;
import constants.RecreationalLevels;
import visitor.DiverElement;
import visitor.DiverVisitor;

/**
 * POJO Diver
 */
public class Diver implements Comparable<Diver>, DiverElement {
    private String name;
    private FederationLevel level;
    private String dateOfBirth;
    private int depth;

    public Diver() {
    }

    protected Diver(DiverBuilder diverBuilder) {
        this.name = diverBuilder.name;
        this.level = diverBuilder.level;
        this.dateOfBirth = diverBuilder.dateOfBirth;
        this.depth = diverBuilder.depth;
    }

    public String getName() {
        return name;
    }

    public FederationLevel getLevel() {
        return level;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public int compareTo(Diver other) {
        return level.getLevelSign().compareTo(other.getLevel().getLevelSign());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Diver diver = new Diver();
        diver.name = this.name;
        diver.depth = this.depth;
        diver.level = this.level;
        diver.dateOfBirth = this.dateOfBirth;
        return diver;
    }

    @Override
    public void accept(DiverVisitor visitor) {
        visitor.visitFederation(this);
    }

    /**
     * Builder class
     */
    public static class DiverBuilder {
        private String name;
        private FederationLevel level;
        private String dateOfBirth;
        private String line;
        private int depth;

        private String parts[];

        public DiverBuilder(String line) {
            this.line = line;
            parts = line.split(";");
        }

        public DiverBuilder setLevel() {
            String levelSign = parts[2];
            String federation = parts[1];

            LevelManagerAdapter adapter = new LevelManagerAdapter(levelSign, federation);
            level = adapter.getAdaptedLevel();

            if (levelSign.startsWith(RecreationalLevels.RECREATIONAL)) {
                depth = RecreationalLevels.DEPTH.get(levelSign);
            }
            else if (levelSign.startsWith(ProLevels.PRO)) {
                depth = ProLevels.DEPTH.get(ProLevels.PRO);
            }

            return this;
        }

        public DiverBuilder setName() {
            name = parts[0];
            return this;
        }

        public DiverBuilder setDOB() {
            dateOfBirth = parts[3];
            return this;
        }

        public Diver build() {
            return new Diver(this);
        }
    }
}
