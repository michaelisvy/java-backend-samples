package samples.solid.openclose.good;

/**
 * OCGPersonalAccount stands for OpenCloseGoodPersonalAccount
 */
public class OCGMediumCompanyAccount extends AbstractOCGAccount{
    private double ACCOUNT_RATE = 0.01 / 12;

    public OCGMediumCompanyAccount(int id, String name, double statement) {
        super(id, name, statement);
    }


    public double calculateMonthlyInterest() {
        return ACCOUNT_RATE * this.getStatement();
    }
}
