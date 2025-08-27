package coffeemanager.domain.discount.condition;

import coffeemanager.domain.order.Order;

public class OrderPriceCondition implements DiscountCondition{

    private final int min;
    private final int max;

    /***
     *
     * @param min : 할인을 위한 주문금액의 최소 범위값
     * @param max : 할인을 위한 주문금액의 최대 범위값
     */
    public OrderPriceCondition(int min, int max) {

        if(min < 0 || max < 0 || max <= min){
            throw new IllegalArgumentException("min과 max의 값을 다시 확인하십시오.");
        }
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isSatisfied(Order order) {
        return order.getOrderPrice() >= min && order.getOrderPrice() < max;
    }
}
