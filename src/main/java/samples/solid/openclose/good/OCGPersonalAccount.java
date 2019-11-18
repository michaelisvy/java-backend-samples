package samples.solid.openclose.good;

import lombok.Data;
import samples.solid.openclose.bad.AccountType;

/**
 * OCGPersonalAccount stands for OpenCloseGoodPersonalAccount
 */
public class OCGPersonalAccount extends AbstractOCGAccount{
    private double PERSONAL_ACCOUNT_RATE = 0.03 / 12;

    public OCGPersonalAccount(int id, String name, double statement) {
        super(id, name, statement);
    }


    public double calculateMonthlyInterest() {
       return PERSONAL_ACCOUNT_RATE * this.getStatement();
    }
}
