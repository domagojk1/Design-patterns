package visitor;

import builder.Diver;

/**
 * Created by domagoj on 11/19/16.
 */
public interface DiverVisitor {
    void visitFederation(Diver diver);
}
