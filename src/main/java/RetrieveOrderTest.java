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

public class RetrieveOrderTest {

    private static DynamoDbClient dynamoDbClient;
    private static Actor tester;

    @BeforeAll
    static void setup() {
        dynamoDbClient = new DynamoDBConfig().dynamoDbClient();
        tester = Actor.named("Tester");
        tester.can(BrowseTheWeb.with(new ChromeDriver()));
    }

    @Test
    void shouldRetrieveExistingOrder() {
        // TODO(reto): Implementar prueba de lectura de pedido existente
        // El test debe:
        // 1. Primero persistir un pedido conocido
        // 2. Recuperar el pedido usando RetrieveOrder.withId(orderId, dynamoDbClient)
        // 3. Verificar que el pedido recuperado no es null
        // 4. Comparar los datos del pedido recuperado con el original
    }

    @Test
    void shouldReturnNullForNonExistentOrder() {
        // TODO(reto): Verificar comportamiento con pedido inexistente
        // El test debe:
        // 1. Intentar recuperar un pedido con ID inexistente
        // 2. Verificar que el resultado es null o maneja el caso apropiadamente
    }
}