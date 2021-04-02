package entities;

public class Savings extends BankAccount {

    public final double DEPOSIT_DISCOUNT = 2000;
    public final double ANNUAL_INTEREST_RATE = 0.01;

    @Override
    public double getDepositDiscount() {
        return this.DEPOSIT_DISCOUNT;
    }

    /**
     * Calcula el porcentaje de intereses y los deposita en la cuenta sin ningun descuento.
     * <br><br>
     * @return el porcentaje depositado en la cuenta.
     */
    public double depositMontlyInterest() throws Exception {

        double MontlyInterest = super.getBalance()*ANNUAL_INTEREST_RATE;
        super.setBalance(super.getBalance()+MontlyInterest);


        return MontlyInterest;
    }

}
