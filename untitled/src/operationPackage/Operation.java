package operationPackage;

import java.io.Serializable;

public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int nb1;
    private final int nb2;
    private final String operateur;

    public Operation(int nb1, int nb2, String operateur) {
        this.nb1 = nb1;
        this.nb2 = nb2;
        this.operateur = operateur;
    }

    public int getNb1() { return nb1; }
    public int getNb2() { return nb2; }
    public String getOperateur() { return operateur; }
}