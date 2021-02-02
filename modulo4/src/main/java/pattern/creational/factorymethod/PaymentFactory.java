package pattern.creational.factorymethod;

/**
 * Factory Method. Esta clase contiene la responsabilidad de crear los objetos
 * de una familia. Abstrae al desarrollador de saber cómo son creados y se
 * aprovecha el polimorfismo.
 */
public class PaymentFactory {

    public static Payment createPayment(PaymentType paymentType) {
        switch (paymentType) {
            case CASH:
                return new Cash();
            case CREDIT_CARD:
                return new CreditCard();
            default:
                return null;
        }
    }
}
