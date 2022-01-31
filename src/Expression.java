public class Expression {
    private Expression leftBranch;
    private Expression rightBranch;
    private Expression parent;
    private final String variable;
    private Operation operation;
    private String notsign;

    public Expression(Expression leftBranch, Expression rightBranch, Expression parent, String variable, Operation operation, String notsign) {
        this.leftBranch = leftBranch;
        this.rightBranch = rightBranch;
        this.parent = parent;
        this.variable = variable;
        this.operation = operation;
        this.notsign = notsign;
    }

    public Expression() {
        this.leftBranch = null;
        this.rightBranch = null;
        this.parent = null;
        this.variable = null;
        this.operation = null;
        this.notsign = null;
    }

    public void setnotsign(String notsign) {
        this.notsign = notsign;
    }

    public enum Operation {
        AND, OR, IMPL, VAR, SKOBKA, ROOT
    }

    public String toString() {
        StringBuilder result = new StringBuilder("");
        int notsignlength = notsign.length();
        if (notsignlength == 0) {
            switch (operation) {
                case OR:
                    result.append("(|,").append(leftBranch != null ? leftBranch.toString() : "").append(",").append(rightBranch != null ? rightBranch.toString() : "").append(")");
                    break;
                case AND:
                    result.append("(&,").append(leftBranch != null ? leftBranch.toString() : "").append(",").append(rightBranch != null ? rightBranch.toString() : "").append(")");
                    break;
                case IMPL:
                    result.append("(->,").append(leftBranch != null ? leftBranch.toString() : "").append(",").append(rightBranch != null ? rightBranch.toString() : "").append(")");
                    break;
                case SKOBKA:
                    result.append(leftBranch != null ? leftBranch.toString() : "");
                    break;
                case VAR:
                    result.append(variable);
                    break;
            }
        } else {
            for (int i = 0; i < notsignlength; i++) {
                result.append("(!");
            }

            switch (operation) {
                case SKOBKA:
                    result.append(leftBranch != null ? leftBranch.toString() : "");
                    break;
                case VAR:
                    result.append(variable);
                    break;
            }

            for (int i = 0; i < notsignlength; i++) {
                result.append(")");
            }
        }

        return result.toString();
    }

    public Operation getOperation() {
        return operation;
    }

    public Expression getLeftBranch() {
        return leftBranch;
    }

    public Expression getParent() {
        return parent;
    }

    public Expression getRightBranch() {
        return rightBranch;
    }

    public String getnotsign() {
        return notsign;
    }

    public String getVariable() {
        return variable;
    }

    public void setParent(Expression parent) {
        this.parent = parent;
    }

    public void setLeftBranch(Expression leftBranch) {
        this.leftBranch = leftBranch;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setRightBranch(Expression rightBranch) {
        this.rightBranch = rightBranch;
    }
}