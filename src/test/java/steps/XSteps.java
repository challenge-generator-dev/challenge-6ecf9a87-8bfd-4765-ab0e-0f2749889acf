package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import models.Order;
import tasks.PersistOrder;
import tasks.RetrieveOrder;
import questions.OrderWasPersisted;
import questions.OrderMatchesExpected;
import config.DynamoDBConfig;

import java.util.List;

public class XSteps {

    @Given("{actor} has an order with id {string}, customer {string}, products {string} and status {string}")
    public void actor_has_an_order(Actor actor, String orderId, String customerName, String products, String status) {
        List<String> productList = List.of(products.split(","));
        Order order = new Order(orderId, customerName, productList, status);
        actor.remember("order", order);
    }

    @When("{actor} persists the order")
    public void actor_persists_the_order(Actor actor) {
        Order order = actor.recall("order");
        actor.attemptsTo(PersistOrder.withDetails(order, DynamoDBConfig.dynamoDbClient()));
    }

    @Then("{actor} should see the order was persisted")
    public void actor_should_see_the_order_was_persisted(Actor actor) {
        Order order = actor.recall("order");
        actor.attemptsTo(
            Ensure.that(OrderWasPersisted.forOrder(order.orderId(), DynamoDBConfig.dynamoDbClient())).isTrue()
        );
    }

    @When("{actor} retrieves the order with id {string}")
    public void actor_retrieves_the_order(Actor actor, String orderId) {
        actor.attemptsTo(RetrieveOrder.withId(orderId, DynamoDBConfig.dynamoDbClient()));
    }

    @Then("{actor} should see the order matches the expected details")
    public void actor_should_see_the_order_matches_expected_details(Actor actor) {
        Order expectedOrder = actor.recall("order");
        actor.attemptsTo(
            Ensure.that(OrderMatchesExpected.withOrders(expectedOrder, RetrieveOrder.withId(
                expectedOrder.orderId(), 
                DynamoDBConfig.dynamoDbClient()
            ).execute())).isTrue()
        );
    }
}