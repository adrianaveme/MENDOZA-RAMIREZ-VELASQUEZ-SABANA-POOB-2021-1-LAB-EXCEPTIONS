package entities;

public class Checking extends BankAccount {

    @Override
    public double getDepositDiscount() {
        return 0;
    }

    /**
     * Calcula el porcentaje de intereses y los deposita en la cuenta sin ningñun descuento.
     * <br><br>
     * @return el porcentaje depositado en la cuenta.
     */

    public boolean processCheck(Check check){
        return false;
    }

}
