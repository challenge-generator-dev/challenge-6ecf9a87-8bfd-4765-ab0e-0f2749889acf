package tasks;

import models.Order;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RetrieveOrder implements Task {

    private final String orderId;
    private final DynamoDbClient dynamoDbClient;
    private static final String TABLE_NAME = "Orders";

    public RetrieveOrder(String orderId, DynamoDbClient dynamoDbClient) {
        this.orderId = orderId;
        this.dynamoDbClient = dynamoDbClient;
    }

    public static RetrieveOrder withId(String orderId, DynamoDbClient dynamoDbClient) {
        return Tasks.instrumented(RetrieveOrder.class, orderId, dynamoDbClient);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // This task is designed to retrieve the order, but the actual retrieval is handled by questions.
        // The performAs method is intentionally left empty as the retrieval logic is encapsulated in questions.
    }

    public Order execute() {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(Map.of("orderId", AttributeValue.builder().s(orderId).build()))
                .build();

        Map<String, AttributeValue> item = dynamoDbClient.getItem(request).item();
        if (item == null || item.isEmpty()) {
            return null;
        }

        return new Order(
                item.get("orderId").s(),
                item.get("customerName").s(),
                item.get("products").ss(),
                item.get("status").s()
        );
    }
}