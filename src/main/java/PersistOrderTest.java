package integration;

import config.DynamoDBConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import questions.OrderMatchesExpected;
import questions.OrderWasPersisted;
import tasks.PersistOrder;
import tasks.RetrieveOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.is;

public class PersistOrderTest {

    private static DynamoDbClient dynamoDbClient;
    private static Actor tester;

    @BeforeAll
    static void setup() {
        dynamoDbClient = new DynamoDBConfig().dynamoDbClient();
        tester = Actor.named("Tester");
        tester.can(BrowseTheWeb.with(new ChromeDriver()));
    }

    @Test
    void shouldPersistOrderSuccessfully() {
        // TODO(reto): Implementar prueba de escritura de pedido en DynamoDB
        // El test debe:
        // 1. Crear un objeto Order con datos de prueba
        // 2. Usar PersistOrder.withDetails(order, dynamoDbClient).performAs(tester)
        // 3. Verificar que el pedido fue persistido usando OrderWasPersisted.forOrder(orderId, dynamoDbClient)
        // 4. Afirmar que el resultado es true
    }

    @Test
    void shouldVerifyPersistedOrderData() {
        // TODO(reto): Verificar que los datos persistidos coinciden con los originales
        // El test debe:
        // 1. Crear un pedido con datos conocidos
        // 2. Persistir el pedido
        // 3. Recuperar el pedido usando RetrieveOrder.withId(orderId, dynamoDbClient)
        // 4. Comparar los datos usando OrderMatchesExpected.withOrders(expected, actual)
    }
}