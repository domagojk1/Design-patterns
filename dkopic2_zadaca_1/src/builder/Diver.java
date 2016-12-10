package builder;

import adapter.Level;
import adapter.LevelManagerAdapter;
import adapter.Manager;
import constants.ProLevels;
import constants.RecreationalLevels;

/**
 * POJO Diver
 */
public class Diver implements Comparable<Diver>, Cloneable {
    private String name;
    private Level level;
    private String dateOfBirth;
    private int depth;

    private Diver(DiverBuilder diverBuilder) {
        this.name = diverBuilder.name;
        this.level = diverBuilder.level;
        this.dateOfBirth = diverBuilder.dateOfBirth;
        this.depth = diverBuilder.depth;
    }
    
    private Diver() {
        
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
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
    
    /**
     * Builder class
     */
    public static class DiverBuilder {
        private String name;
        private Level level;
        private String dateOfBirth;
        private String line;
        private int depth;

        public DiverBuilder(String line) {
            this.line = line;
        }

        public Diver build() {
            String[] parts = line.split(";");

            if (parts.length == 4) {
                name = parts[0];
                dateOfBirth = parts[3];

                Manager levelManager = new LevelManagerAdapter(new Level(parts[1], parts[2]));
                level = levelManager.getLevel();
                return new Diver(this);
            }

            return null;
        }
    }
}
