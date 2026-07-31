# DesarrolloApliaciones - Chat Privado

## 1. Nombre del Proyecto

**Chat Privado (EjercicioDesApp)**

Proyecto académico de la asignatura Desarrollo de Aplicaciones que implementa un **chat punto a punto (P2P) con interfaz gráfica en Java**, donde cada instancia de la aplicación actúa simultáneamente como **servidor** (escuchando mensajes entrantes) y como **cliente** (enviando mensajes a la IP y puerto del otro participante) usando **sockets TCP**.

## 2. Características

- Interfaz gráfica construida con **Swing** para ingresar IP, puerto local, puerto destino y nickname.
- Comunicación **bidireccional** entre dos instancias de la aplicación mediante `Socket` y `ServerSocket`.
- Cada instancia levanta un **hilo (`Thread`)** independiente que queda escuchando conexiones entrantes en el puerto local, sin bloquear la interfaz gráfica.
- Envío de mensajes en tiempo real, identificados con el nickname del remitente.
- Historial de conversación visible en un área de texto (`JTextArea`) dentro de un panel con scroll.
- Arquitectura separada en tres capas: interfaz gráfica, controlador y lógica de red (similar a un patrón MVC simplificado).

## 3. Instalación

### Requisitos Previos

1. **Java JDK 11 o superior** instalado.
2. **Git** para clonar el repositorio.
3. IDE recomendado: **NetBeans** (el proyecto está configurado con Apache Ant).

### Pasos de Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/juandiegogalindo/DesarrolloApliaciones-ChatPrivado.git
```
2. Abrir el proyecto en NetBeans (o importar como proyecto Ant en tu IDE de preferencia).

3. Compilar y ejecutar desde el IDE, o mediante Ant:
```bash
ant compile
ant run
```

### Cómo usar el chat

Para probar la comunicación necesitas **dos instancias** de la aplicación corriendo (en el mismo equipo o en equipos distintos dentro de la misma red):

1. En cada instancia, ingresa la IP del otro participante y un nickname.
2. Al pulsar "Conectar", se te pedirá el **puerto del otro cliente** (puerto destino) y el **puerto en el que tú vas a escuchar** (puerto local). Estos valores deben cruzarse entre las dos instancias: el puerto destino de una debe ser el puerto local de la otra, y viceversa.
3. Una vez conectados, el botón "Enviar" se habilita y los mensajes escritos se transmiten por el socket hacia el otro cliente.

## 4. Tecnologías Utilizadas

1. **Java 11** – Lenguaje principal, con `java.net.Socket` y `java.net.ServerSocket` para la comunicación TCP.
2. **Swing** – Construcción de la interfaz gráfica (`JFrame`, `JPanel`, `JTextArea`, etc.).
3. **Apache Ant** – Herramienta de construcción y ejecución del proyecto (gestionado por NetBeans).
4. **Git / GitHub** – Control de versiones y alojamiento del código.

## 5. Fundamento Teórico

El proyecto se apoya en los siguientes conceptos:

1. **Comunicación cliente-servidor con sockets TCP:** cada instancia de la aplicación abre un `ServerSocket` que escucha en un puerto local (rol servidor) y, al enviar un mensaje, crea un `Socket` hacia la IP/puerto del destinatario (rol cliente). Esto convierte a cada participante en un nodo "peer" dentro de la conexión.
2. **Concurrencia con hilos (`Thread`/`Runnable`):** la clase `HelloSocket` implementa `Runnable`, y su método `run()` se ejecuta en un hilo aparte. Esto es indispensable porque `serverSocket.accept()` es una llamada **bloqueante**: si se ejecutara en el hilo principal, la interfaz gráfica se congelaría mientras espera una conexión entrante.
3. **Flujos de datos (`DataInputStream`/`DataOutputStream`):** se usan para serializar y leer cadenas de texto (`writeUTF`/`readUTF`) directamente sobre el flujo del socket.
4. **Patrón MVC simplificado:** `InterfazApp` y `PanelDatos` conforman la vista, `Controlador` actúa como intermediario, y `HelloSocket` encapsula la lógica de red (modelo/lógica de negocio).

## 6. Estructura del Proyecto

```
DesarrolloApliaciones-ChatPrivado/
├── build.xml                      # Script de construcción Ant
├── manifest.mf                    # Manifiesto del JAR (clase principal se agrega en build)
├── nbproject/                     # Configuración interna de NetBeans
└── src/
    ├── interfaz/
    │   ├── InterfazApp.java       # Ventana principal (JFrame), punto de entrada (main)
    │   └── PanelDatos.java        # Panel con los campos de conexión, chat y botones
    ├── Controlador/
    │   └── Controlador.java       # Intermediario entre la interfaz y la capa de red
    └── mundo/
        └── HelloSocket.java       # Lógica de sockets: servidor (hilo) y envío de mensajes
```

**Clase principal:** `interfaz.InterfazApp`

## 7. Autor
**Juan Diego Galindo**
Estudiante de Ingeniería de Sistemas - Quinto Semestre
 
- GitHub: [Juan Diego Galindo](https://github.com/juandiegogalindo)
- LinkedIn: [Juan Diego Galindo Montenegro](https://linkedin.com/in/jdgalindo6)
