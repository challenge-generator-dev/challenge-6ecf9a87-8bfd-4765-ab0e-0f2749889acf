package questions;

import models.Order;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderMatchesExpected implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMatchesExpected.class);

    private final Order expectedOrder;
    private final Order actualOrder;

    public OrderMatchesExpected(Order expectedOrder, Order actualOrder) {
        this.expectedOrder = expectedOrder;
        this.actualOrder = actualOrder;
    }

    public static OrderMatchesExpected withOrders(Order expectedOrder, Order actualOrder) {
        return new OrderMatchesExpected(expectedOrder, actualOrder);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if (expectedOrder == null || actualOrder == null) {
            LOGGER.warn("Una de las ordenes es null - esperada: {}, actual: {}", 
                expectedOrder, actualOrder);
            return false;
        }

        boolean orderIdMatches = expectedOrder.orderId().equals(actualOrder.orderId());
        boolean customerNameMatches = expectedOrder.customerName().equals(actualOrder.customerName());
        boolean productsMatches = expectedOrder.products().equals(actualOrder.products());
        boolean statusMatches = expectedOrder.status().equals(actualOrder.status());

        LOGGER.info("Comparando ordenes - ID: {}, Cliente: {}, Productos: {}, Estado: {}", 
            orderIdMatches, customerNameMatches, productsMatches, statusMatches);

        if (!orderIdMatches) {
            LOGGER.debug("Order ID no coincide - esperado: {}, actual: {}", 
                expectedOrder.orderId(), actualOrder.orderId());
        }
        if (!customerNameMatches) {
            LOGGER.debug("CustomerName no coincide - esperado: {}, actual: {}", 
                expectedOrder.customerName(), actualOrder.customerName());
        }
        if (!productsMatches) {
            LOGGER.debug("Products no coincide - esperado: {}, actual: {}", 
                expectedOrder.products(), actualOrder.products());
        }
        if (!statusMatches) {
            LOGGER.debug("Status no coincide - esperado: {}, actual: {}", 
                expectedOrder.status(), actualOrder.status());
        }

        return orderIdMatches && customerNameMatches && productsMatches && statusMatches;
    }
}