package student.constraints;

import student.Assignment;

import java.util.Collection;
import java.util.stream.Collectors;

public final class OrConstraint extends LogicalConstraint {

    OrConstraint(Collection<ConstraintBase> constraints){
        super(constraints);
    }

    @Override
    public boolean evaluate(Assignment assignment) {
        for(ConstraintBase constraint : this.children){
            if(constraint.evaluate(assignment))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "(" + this.children.stream().map(x->x.toString()).collect(Collectors.joining(" || ")) + ")";
    }
}
