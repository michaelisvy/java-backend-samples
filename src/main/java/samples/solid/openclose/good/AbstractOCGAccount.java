package samples.solid.openclose.good;

import lombok.Data;

/**
 * OCBCustomer stands for OpenCloseBadCustomer
 * Open/Closed principle: this class is Opened for extensions (abstract) and closed for modifications
 * (it's mandatory for all accounts to have an id, a name and a statement)
 */
@Data
public abstract class AbstractOCGAccount {
    private int id;
    private String name;
    private double statement;

    public AbstractOCGAccount(int id, String name, double statement) {
        this.id = id;
        this.name = name;
        this.statement = statement;
    }

    public abstract double calculateMonthlyInterest();
}
