# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/PersistOrderTest.java` — La fase "Automatización de la Escritura de Pedidos" (f2) practica PersistOrderTest aqui: este archivo es el ejercicio (blueprint).
- `src/main/java/RetrieveOrderTest.java` — La fase "Automatización de la Lectura de Pedidos" (f3) practica RetrieveOrderTest aqui: este archivo es el ejercicio (blueprint).
- `src/main/java/config/DynamoDBConfig.java` — La fase "Configuración del Entorno de Pruebas" ya venia resuelta por el codigo base: este archivo pasa a ser el ejercicio.

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | testing | Automatizador | - |
| `infra-local` | (raiz) | support | infra | Compose local | DynamoDB |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Herramientas

- **Java**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Java Selenium**: Tecnologia del perfil del candidato: el reto se resuelve con ella.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Imports sin uso — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos:

- `src/main/java/PersistOrderTest.java` — `OrderMatchesExpected`
- `src/main/java/PersistOrderTest.java` — `OrderWasPersisted`
- `src/main/java/PersistOrderTest.java` — `PersistOrder`
- `src/main/java/PersistOrderTest.java` — `RetrieveOrder`
- `src/main/java/RetrieveOrderTest.java` — `OrderMatchesExpected`
- `src/main/java/RetrieveOrderTest.java` — `OrderWasPersisted`
- `src/main/java/RetrieveOrderTest.java` — `PersistOrder`
- `src/main/java/RetrieveOrderTest.java` — `RetrieveOrder`

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Tecnología Java Selenium, Advanced L2

### Brecha de conocimiento
Automatizar pruebas de integracion sobre una tabla DynamoDB

### Misión / candidato
Cubrir el flujo de persistencia de pedidos

### Reto
- Tema: Automatizacion de pruebas de integracion contra DynamoDB
- Seniority: advanced-l2
- Tipo: practical
- Título: Automatización de Pruebas de Integración con DynamoDB
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del Entorno de Pruebas — objetivo: Configurar el entorno de pruebas para interactuar con DynamoDB. — entregable (NO resolver): Configuración de pruebas lista para interactuar con DynamoDB.
- Fase 2: Automatización de la Escritura de Pedidos — objetivo: Automatizar la escritura de pedidos en DynamoDB. — entregable (NO resolver): Prueba automatizada que escribe y verifica un pedido en DynamoDB.
- Fase 3: Automatización de la Lectura de Pedidos — objetivo: Automatizar la lectura de pedidos desde DynamoDB. — entregable (NO resolver): Prueba automatizada que lee y verifica un pedido en DynamoDB.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: src/test/java/steps/XSteps.java ===
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

// === ARCHIVO: src/test/java/runners/RunCucumberTest.java ===
package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    }
)
public class RunCucumberTest {
}

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.34.9</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>3.9.8</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>3.9.8</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-junit5</artifactId>
            <version>3.9.8</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay</artifactId>
            <version>3.9.8</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>junit-jupiter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>localstack</artifactId>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>testcontainers</artifactId>
        </dependency>
        <dependency>
            <groupId>software.amazon.awssdk</groupId>
            <artifactId>dynamodb</artifactId>
            <version>2.59.2</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/config/DynamoDBConfig.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package config;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.net.URI;

public class DynamoDBConfig {

    private static final String LOCAL_ENDPOINT = "http://localhost:4566";
    private static final String REGION = "us-east-1";
    private static final String ACCESS_KEY = "fakeAccessKey";
    private static final String SECRET_KEY = "fakeSecretKey";

    public DynamoDbClient dynamoDbClient() {
      throw new UnsupportedOperationException("TODO(reto): dynamoDbClient");
    }
}

// === ARCHIVO: src/main/java/config/DynamoDBLocalSetup.java ===
package config;

import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.List;

@Testcontainers
public class DynamoDBLocalSetup {

    private static final String TABLE_NAME = "Orders";
    private static final String PARTITION_KEY = "orderId";

    @Container
    public static LocalStackContainer localStack = new LocalStackContainer(DockerImageName.parse("localstack/localstack:3.0"))
            .withServices(LocalStackContainer.Service.DYNAMODB);

    public static void createTable(DynamoDbClient dynamoDbClient) {
        try {
            CreateTableRequest request = CreateTableRequest.builder()
                    .tableName(TABLE_NAME)
                    .keySchema(KeySchemaElement.builder()
                            .attributeName(PARTITION_KEY)
                            .keyType(KeyType.HASH)
                            .build())
                    .attributeDefinitions(AttributeDefinition.builder()
                            .attributeName(PARTITION_KEY)
                            .attributeType(ScalarAttributeType.S)
                            .build())
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L)
                            .writeCapacityUnits(5L)
                            .build())
                    .build();

            dynamoDbClient.createTable(request);
        } catch (ResourceInUseException e) {
            // Table already exists
        }
    }
}

// === ARCHIVO: src/main/java/models/Order.java ===
package models;

import java.util.List;
import java.util.Objects;

public record Order(
        String orderId,
        String customerName,
        List<String> products,
        String status) {

    public Order {
        Objects.requireNonNull(orderId, "Order ID cannot be null");
        Objects.requireNonNull(customerName, "Customer name cannot be null");
        Objects.requireNonNull(products, "Products list cannot be null");
        Objects.requireNonNull(status, "Status cannot be null");
    }
}

// === ARCHIVO: src/main/java/tasks/PersistOrder.java ===
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

// === ARCHIVO: src/main/java/questions/OrderWasPersisted.java ===
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

// === ARCHIVO: src/main/java/tasks/RetrieveOrder.java ===
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

// === ARCHIVO: src/main/java/questions/OrderMatchesExpected.java ===
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

// === ARCHIVO: src/main/java/PersistOrderTest.java ===
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

// === ARCHIVO: src/main/java/RetrieveOrderTest.java ===
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

// === ARCHIVO: docker-compose.yml ===
# Infraestructura local del reto. SOLO desarrollo: credenciales de ejemplo (local-dev-only), puertos en loopback.
# Levantar: docker compose up -d --wait
name: infra-local
services:
  dynamodb-local:
    image: "amazon/dynamodb-local:2.5.2"
    command: ["-jar","DynamoDBLocal.jar","-sharedDb","-inMemory"]
    ports:
      - "127.0.0.1:8000:8000"
    healthcheck:
      test: ["CMD-SHELL","bash -c ':> /dev/tcp/127.0.0.1/8000' || exit 1"]
      interval: 10s
      timeout: 5s
      retries: 10
      start_period: 5s


// === ARCHIVO: infra-local/README.md ===
# Infraestructura local

Servicios de soporte para el reto, definidos en `docker-compose.yml` (raiz del repo).

```bash
docker compose up -d --wait
```

| Servicio | Imagen | Puertos (host) |
|---|---|---|
| DynamoDB Local | `amazon/dynamodb-local:2.5.2` | 8000 |

Credenciales: solo de desarrollo local (`local-dev-only`, `local`). No son secretos ni deben reutilizarse.
Los scripts de `infra-local/` (tablas, topics) se ejecutan con el compose en estado healthy.

Tablas de DynamoDB: `Orders` (pk `id`).


// === ARCHIVO: infra-local/dynamodb/create-tables.sh ===
#!/usr/bin/env bash
# Crea las tablas en DynamoDB Local (idempotente). Credenciales dummy: DynamoDB Local no valida firmas.
set -euo pipefail

export AWS_ACCESS_KEY_ID=local
export AWS_SECRET_ACCESS_KEY=local
export AWS_REGION=us-east-1
ENDPOINT="${DYNAMODB_ENDPOINT:-http://localhost:8000}"

create_table() {
  local name="$1" pk="$2" sk="${3:-}"
  if aws dynamodb describe-table --table-name "$name" --endpoint-url "$ENDPOINT" >/dev/null 2>&1; then
    echo "Tabla $name ya existe"
    return
  fi
  local attrs="AttributeName=$pk,AttributeType=S"
  local keys="AttributeName=$pk,KeyType=HASH"
  if [ -n "$sk" ]; then
    attrs="$attrs AttributeName=$sk,AttributeType=S"
    keys="$keys AttributeName=$sk,KeyType=RANGE"
  fi
  # shellcheck disable=SC2086
  aws dynamodb create-table --table-name "$name" --attribute-definitions $attrs --key-schema $keys \
    --billing-mode PAY_PER_REQUEST --endpoint-url "$ENDPOINT" >/dev/null
  echo "Tabla $name creada"
}

create_table "Orders" "id"

```
