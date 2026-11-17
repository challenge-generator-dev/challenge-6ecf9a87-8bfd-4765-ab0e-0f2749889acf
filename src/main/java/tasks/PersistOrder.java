package tasks;

import models.Order;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PersistOrder implements Task {

    private final Order order;
    private final DynamoDbClient dynamoDbClient;
    private static final String TABLE_NAME = "Orders";

    public PersistOrder(Order order, DynamoDbClient dynamoDbClient) {
        this.order = order;
        this.dynamoDbClient = dynamoDbClient;
    }

    public static PersistOrder withDetails(Order order, DynamoDbClient dynamoDbClient) {
        return Tasks.instrumented(PersistOrder.class, order, dynamoDbClient);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, AttributeValue> itemValues = new HashMap<>();
        itemValues.put("orderId", AttributeValue.builder().s(order.orderId()).build());
        itemValues.put("customerName", AttributeValue.builder().s(order.customerName()).build());
        itemValues.put("products", AttributeValue.builder().ss(order.products()).build());
        itemValues.put("status", AttributeValue.builder().s(order.status()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(TABLE_NAME)
                .item(itemValues)
                .build();

        dynamoDbClient.putItem(request);
    }
}