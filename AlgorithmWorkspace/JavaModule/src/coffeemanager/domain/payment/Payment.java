package coffeemanager.domain.payment;

import coffeemanager.domain.discount.policy.DiscountPolicy;
import coffeemanager.domain.order.Order;
import coffeemanager.domain.account.Account;

public class Payment {

    private Order order;
    private int paymentPrice;
    private DiscountPolicy discountPolicy;

    public Payment(Order order, DiscountPolicy discountPolicy) {
        this.order = order;
        this.paymentPrice = order.getOrderPrice();
        this.paymentPrice = discountPolicy.calculatePaymentPrice(order);
    }

    public Order getOrder() {
        return order;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public void proceed() {
        Account account = Account.getInstance();
        account.registSales(paymentPrice);
    }
}
