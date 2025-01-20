# Proyecto de Automatización de Pruebas con Selenium, Cucumber y ExtentReports

Este proyecto contiene la automatización de pruebas web utilizando **Selenium**, **Cucumber** y **JUnit**. Además, se ha integrado **ExtentReports** para generar reportes visuales de las pruebas.

## Requisitos

Antes de ejecutar el proyecto, asegúrate de tener lo siguiente:

- **Java 11 o superior** instalado.
- **Gradle 7.x o superior** instalado.
- Un IDE compatible con Java, como **IntelliJ IDEA** o **Eclipse** (opcional).
- Conexión a Internet para descargar las dependencias necesarias.

## Dependencias del Proyecto

Este proyecto utiliza las siguientes dependencias:

- **JUnit 5**: Para la ejecución de pruebas.
- **Selenium**: Para la automatización de la interfaz web.
- **Cucumber**: Para la definición de escenarios en formato Gherkin.
- **ExtentReports**: Para generar reportes visuales de las pruebas.

## Instalación

1. Clona el repositorio o descarga el proyecto.

2. Abre el proyecto en tu IDE o editor de texto preferido.

3. Asegúrate de tener las dependencias necesarias en el archivo `build.gradle`.

4. Si no tienes **Gradle** instalado, puedes instalarlo siguiendo la [guía oficial de Gradle](https://gradle.org/install/).

5. Para construir y ejecutar las pruebas, abre una terminal en la raíz del proyecto y ejecuta:

   ```bash
   gradle test