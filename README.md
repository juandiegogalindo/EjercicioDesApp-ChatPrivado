# EjercicioDesApp - Chat Privado

## 1. Nombre del Proyecto

**EjercicioDesApp - Chat Privado**

Proyecto académico orientado al desarrollo de una aplicación de chat con comunicación privada entre usuarios implementada en **Java**.

## 2. Características

Este ejercicio incluye:

- Implementación de una aplicación de chat básico que permite interacción entre dos participantes.
- Comunicación estructurada mediante entrada y salida de mensajes en consola o interfaz básica.
- Lógica de intercambio de mensajes enfocado en comunicación privada.
- Uso de estructuras de control y métodos para gestionar el flujo de mensajes y la interacción entre usuarios.
- Código organizado en paquetes compatibles con compilación y ejecución mediante Ant/IDE. :contentReference[oaicite:1]{index=1}

## 3. Instalación

### Requisitos Previos

1. **Java JDK 8 o superior** instalado.
2. **Git** para clonar el repositorio.
3. IDE recomendado: **NetBeans**, **Eclipse** o **IntelliJ IDEA**.

### Pasos de Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/juandiegogalindo/EjercicioDesApp-ChatPrivado.git
```
2. Abrir el proyecto en tu IDE.

3. Compilar y ejecutar la aplicación desde el IDE o mediante Ant:
```bash
ant compile
ant run
```

## 4. Tecnologías Utilizadas

1. Java – Lenguaje de programación principal para la lógica del chat.
2. Apache Ant – Herramienta de construcción y ejecución del proyecto.
3. Git / GitHub – Control de versiones y alojamiento del código.
4. IDE Java – Entorno de desarrollo para edición y ejecución.

## 5. Teoría del Juego en Base a la Programación

El ejercicio de Chat Privado recae en los fundamentos de la comunicación entre entidades en sistemas informáticos, implementando un modelo básico de interacción:
1. Estado de comunicación:
El sistema define participantes que se comunican mediante mensajes, estableciendo sender (remitente) y receiver (destinatario) en cada ciclo de interacción.
2. Control de flujo:
Se implementan estructuras de control para gestionar el envío y recepción de mensajes, posibilitando secuencias condicionales y repetitivas según las acciones del usuario.
3. Entrada y salida de datos:
La lectura de mensajes utiliza un flujo de entrada estándar (por ejemplo consola) y la salida de los mensajes se muestra al usuario, simulando un chat entre dos partes.
4. Modularidad:
La lógica se organiza en métodos o clases que abstraen el envío y recepción de mensajes, favoreciendo la reutilización y mantenimiento del código.

Este ejercicio refuerza conceptos de programación orientada a objetos, manejo de entrada/salida, control de flujo y estructuración lógica de procesos de comunicación.
