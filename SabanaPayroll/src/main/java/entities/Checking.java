package entities;

import java.time.LocalDate;

public class Checking extends BankAccount {

    public final double DEPOSIT_DISCOUNT = 5000;

    @Override
    public double getDepositDiscount() {

        return this.DEPOSIT_DISCOUNT;
    }

    /**
     * Calcula el porcentaje de intereses y los deposita en la cuenta sin ningñun descuento.
     * <br><br>
     * @return el porcentaje depositado en la cuenta.
     */

    public boolean processCheck(Check check) throws Exception {

        boolean result = false;

        if ((check.getExpirationDate()).isAfter(LocalDate.now())){

            super.setBalance(check.getAmount() -getDepositDiscount());
            result = true;
        }

        return result;
    }
}
