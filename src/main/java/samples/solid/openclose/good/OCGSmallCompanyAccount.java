package samples.solid.openclose.good;

/**
 * OCGPersonalAccount stands for OpenCloseGoodPersonalAccount
 */
public class OCGSmallCompanyAccount extends AbstractOCGAccount {
    public OCGSmallCompanyAccount(int id, String name, double statement) {
        super(id, name, statement);
    }


    public double calculateMonthlyInterest() {
        return 0;
    }
}
