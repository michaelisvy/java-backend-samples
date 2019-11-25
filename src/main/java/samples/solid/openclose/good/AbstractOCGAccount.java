package samples.solid.openclose.good;

import lombok.Data;

/**
 * OCBCustomer stands for OpenCloseBadCustomer
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
