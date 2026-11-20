# CDI Training

This repository holds the sample application which covers the main concepts of the CDI 4.0 specification.
After working through the tasks one should be able to understand the main concepts of the CDI 4.0 specification and to use the CDI 4.0 concepts in real time applications.

The application is based on the [Jakarta EE 10](https://jakarta.ee/release/10/) ([CDI 4.0](https://jakarta.ee/specifications/cdi/4.0/)) specification and the [WildFly 38.0.1.Final](https://www.wildfly.org/) application server.

## Covered CDI Basics

The following CDI concepts are covered by this example:

1. Injection
2. Scopes
3. Initialization (`@PostConstruct`, `@PreDestroy`)
4. Qualifiers
5. Producer Methods/Fields
6. Interceptors
7. Decorators
8. Events

## CDI Advanced

Additionally, to the CDI basics, this sample application provides implementations with explanations for situations we faced in our projects.

1. **Scopes and Concurrency**  
   How to provide request scoped state when using concurrency where we only can use `@Dependent`, `@ApplicationScoped` beans?
2. **Dynamic Default**  
   How to change the `@Default` of a CDI bean during runtime?
3. **Alternatives**  
   How and when to use `@Alternative` beans?
4. **Specialized**  
   How and when to use `@Specializes` beans, and what differs them from `@Alternative` beans?
5. **Registrar**  
   How to use a registrar to capture asynchronous execution results, which are needed by other parts of the application?
6. **Startup-Event**  
   How to notify the application that the application has started?
7. **Lookup-Factory**  
   How to implement a factory to encapsulate the CDI programmatic bean lookup and how to manage `@Dependent` scoped beans properly?

## Resources

This repository provides the following PDF slides:

- [CDI Introduction](cdi-introduction-v1.3.pdf)  
  An introduction to CDI.
- [CDI Specs](cdi-specifications-v1.0.pdf)  
  A theoretical insight into the CDI specs scopes, interceptors, decorators and events.

The following resources are useful when implementing CDI backed applications:

- [CDI 4.0 Specification](https://jakarta.ee/specifications/cdi/4.0/)  
  The official CDI 4.0 specification of Jakarta EE.

## Used Tools

To get the application running you need the following software installed:

1. [OpenJDK 21](https://jdk.java.net/archive/) (or any Java 21 JDK)
2. [WildFly 38.0.1.Final](https://www.wildfly.org/downloads/) (or run via `mvn wildfly:run`)
3. [Maven 3.9+](https://maven.apache.org/download.cgi)

## Accessing the application

The application can be accessed via `http://localhost:8080/cditraining/api/welcome`.

Follow the instructions to work through the exercises.

> **IMPORTANT:** When running in an IDE the actual port will depend on your configuration.

## Running in an IDE

Refer to the documentation of the IDE of your choice, which must provide integration for WildFly/JBoss servers, for how to set up the project.

## WIKI

See the [WIKI](https://gepardec.github.io/cdi-training/) for the development guidelines and the documentation about the components the application is based on.
