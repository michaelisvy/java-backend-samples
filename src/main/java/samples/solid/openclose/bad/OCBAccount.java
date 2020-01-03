package samples.solid.openclose.bad;

import lombok.Data;

/**
 * OCBAccount stands for OCBAccount
 */
@Data
public class OCBAccount {
    private double PERSONAL_ACCOUNT_RATE = 0.03 / 12;
    private double MEDIUM_COMPANY_RATE = 0.01 / 12;

    private int id;
    private String name;
    private double statement;
    private AccountType accountType;

    public OCBAccount(int id, String name, double statement, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.statement = statement;
        this.accountType = accountType;
    }

    public double calculateMonthlyInterest() {
        if (accountType.equals(AccountType.PERSONAL_ACCOUNT)) {
            return PERSONAL_ACCOUNT_RATE * this.statement;
        } else if (accountType.equals(AccountType.SMALL_COMPANY)) {
            return 0;
        } else { // Medium company
            return MEDIUM_COMPANY_RATE * this.statement;
        }
        // if we had applied the Open/Closed principle, class would be Opened for extensions and Closed for modifications
        // that's not the case here: everything is at the same place so everything is opened for modifications.

        // also, that won't scale for more complex business rules
        // Example: Personal accounts have $5 monthly credit if they have setup a Giro transfer from their account
        // they have an additional $20 if they spend over $500 in credit card
        // etc
    }
}
