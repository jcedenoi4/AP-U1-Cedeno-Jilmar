# TurnoJusto — AP-U1, Grupo 2

**Universidad Técnica Estatal de Quevedo**  
**Asignatura:** Aplicaciones Distribuidas (ISR-701)  
**Estudiante:** Cedeño Intriago Jilmar Jesús  
**Modalidad:** Individual  
**Fecha:** 23 de noviembre de 2026  
**Estado:** Prototipo en desarrollo (avance parcial; no es una entrega final).

## Descripción

TurnoJusto es un prototipo de atención mediante un coordinador central y ventanillas que se comunican por sockets TCP. El objetivo es entregar números de turno consecutivos sin duplicados y respetar un cupo configurable.

## Estructura del proyecto

```text
AP-U1-Cedeno-Jilmar/
├── src/
│   ├── Coordinador.java
│   ├── Ventanilla.java
│   ├── PruebaCarga.java          (pendiente)
│   └── OrdenTotal.java          (pendiente)
├── config.properties
├── logs/                        (pendiente)
├── docs/
│   ├── img/                     (evidencias pendientes)
│   ├── informe.tex
│   ├── informe.pdf
│   ├── entrega_SGA.tex
│   └── entrega_SGA.pdf
└── README.md
```

Los archivos marcados como pendientes forman parte de la estructura prevista, pero no se afirma que estén implementados.

## Requisitos

- JDK 21.
- IntelliJ IDEA o terminal con `javac` y `java`.
- Una distribución de LaTeX con `pdflatex` para compilar los documentos.

## Configuración

Archivo `config.properties` en la raíz del proyecto:

```properties
cupo=10
token=turno123
host=127.0.0.1
puerto=5000
```

El token mostrado es un valor de prueba local, no una credencial de producción.

## Compilación y ejecución

Desde la raíz del proyecto, en una terminal con Java 21:

```powershell
javac -d out src/Coordinador.java src/Ventanilla.java
```

En una terminal, iniciar primero el coordinador:

```powershell
java -cp out Coordinador
```

Sin detenerlo, abrir otra terminal y ejecutar una ventanilla:

```powershell
java -cp out Ventanilla
```

Para repetir una solicitud, ejecutar de nuevo `Ventanilla` sin reiniciar el coordinador. La implementación actual puede atender las conexiones secuencialmente; todavía no se ha comprobado el funcionamiento concurrente de tres ventanillas independientes.

## Formato de mensajes implementado hasta ahora

La ventanilla envía una línea de texto al coordinador:

```text
TURNO turno123
```

El primer campo es el comando y el segundo es el token. Según la validación, las respuestas previstas son:

```text
FORMATO_INVALIDO
COMANDO_INVALIDO
TOKEN_INVALIDO
TURNO 1
TURNO 2
...
TURNO 10
CUPO_AGOTADO
```

El intercambio inicial `HOLA` / `RECIBIDO` se utilizó como prueba de conectividad. La asignación de turnos se ha trabajado en una versión básica; faltan pruebas completas y evidencia de concurrencia.


## Documentación LaTeX

Desde la carpeta `docs/`:

```powershell
pdflatex informe.tex
pdflatex informe.tex
pdflatex entrega_SGA.tex
pdflatex entrega_SGA.tex
```



## Repositorio

**URL pública:** pendiente de agregar cuando exista el repositorio definitivo.
