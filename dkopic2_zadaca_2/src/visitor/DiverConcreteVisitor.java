package visitor;

import builder.Diver;

/**
 * Created by domagoj on 11/19/16.
 */
public class DiverConcreteVisitor implements DiverVisitor {
    private String federationName;
    private int numberOfDivers;
    private int sumDepth;

    public DiverConcreteVisitor(String federationName) {
        this.federationName = federationName;
    }

    public int getNumberOfDivers() {
        return numberOfDivers;
    }

    public int getAverageDiverDepth() {
        return this.sumDepth / this.numberOfDivers;
    }

    @Override
    public void visitFederation(Diver diver) { 
        if (diver.getLevel().getFederation().equals(federationName)) {
            sumDepth += diver.getDepth();
            this.numberOfDivers ++;
        }
       
    }
}
