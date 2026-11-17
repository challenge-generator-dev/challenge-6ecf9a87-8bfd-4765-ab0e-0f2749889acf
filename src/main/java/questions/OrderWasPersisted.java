package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import java.util.Map;

public class OrderWasPersisted implements Question<Boolean> {

    private final String orderId;
    private final DynamoDbClient dynamoDbClient;
    private static final String TABLE_NAME = "Orders";

    public OrderWasPersisted(String orderId, DynamoDbClient dynamoDbClient) {
        this.orderId = orderId;
        this.dynamoDbClient = dynamoDbClient;
    }

    public static OrderWasPersisted forOrder(String orderId, DynamoDbClient dynamoDbClient) {
        return new OrderWasPersisted(orderId, dynamoDbClient);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(Map.of("orderId", AttributeValue.builder().s(orderId).build()))
                .build();

        return dynamoDbClient.getItem(request).item() != null;
    }
}