package visitor;

/**
 * Created by domagoj on 11/19/16.
 */
public interface DiverElement {
    void accept(DiverVisitor visitor);
}
