# Automatización de Pruebas de Integración con DynamoDB

El sistema de gestión de pedidos utiliza una tabla DynamoDB para almacenar información de pedidos. El objetivo es automatizar pruebas de integración que validen la lectura y escritura de datos en esta tabla. Los pedidos tienen atributos como ID, nombre del cliente, productos y estado. La tabla debe manejar volúmenes pico de 10,000 pedidos por hora con una disponibilidad del 99.9%.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Automatizacion de pruebas de integracion contra DynamoDB |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Configuración del Entorno de Pruebas

**Objetivo:** Configurar el entorno de pruebas para interactuar con DynamoDB.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configura el proyecto Java para usar Serenity BDD y el patrón Screenplay.
- Establece una conexión con una instancia de DynamoDB local o en la nube.
- Crea una tabla DynamoDB con los atributos necesarios para almacenar pedidos.

**Entregable:** Configuración de pruebas lista para interactuar con DynamoDB.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa la documentación de Serenity BDD y el patrón Screenplay para entender su uso.
- Explora las opciones de configuración de DynamoDB para asegurar una conexión estable.

</details>

### Fase 2: Automatización de la Escritura de Pedidos

**Objetivo:** Automatizar la escritura de pedidos en DynamoDB.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Escribe una prueba que cree un nuevo pedido y lo almacene en DynamoDB.
- Usa esperas explícitas en lugar de Thread.sleep para manejar la latencia de la escritura.
- Verifica que el pedido se ha almacenado correctamente.

**Entregable:** Prueba automatizada que escribe y verifica un pedido en DynamoDB.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa la documentación de DynamoDB para entender cómo realizar operaciones de escritura.
- Explora las opciones de esperas explícitas en Serenity BDD.

</details>

### Fase 3: Automatización de la Lectura de Pedidos

**Objetivo:** Automatizar la lectura de pedidos desde DynamoDB.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Escribe una prueba que lea un pedido almacenado en DynamoDB.
- Verifica que los datos del pedido leídos coincidan con los almacenados.
- Maneja posibles errores de lectura, como pedidos no encontrados.

**Entregable:** Prueba automatizada que lee y verifica un pedido en DynamoDB.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa la documentación de DynamoDB para entender cómo realizar operaciones de lectura.
- Explora las opciones de manejo de errores en Serenity BDD.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Serenity BDD y cómo se usa en este reto?
- **paraQueSirve**: ¿Para qué sirve el patrón Screenplay en este contexto?
- **comoSeUsa**: ¿Cómo se usan las esperas explícitas en lugar de Thread.sleep?
- **erroresComunes**: ¿Cuáles son los errores comunes al escribir y leer en DynamoDB y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la configuración del entorno de pruebas y la elección de esperas explícitas?

## Criterios de Evaluacion

- Configuración del entorno de pruebas con Serenity BDD y el patrón Screenplay.
- Uso de esperas explícitas en lugar de Thread.sleep.
- Automatización de la escritura de pedidos en DynamoDB.
- Automatización de la lectura de pedidos desde DynamoDB.
- Manejo de errores comunes al escribir y leer en DynamoDB.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

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

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
