# Generest

Generic rest to store stuff in memory

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

- JDK

### Installing

```
./mvnw clean install
```
should install dependencies

### Development
```
./mvnw spring-boot:run
```

## Deployment

```
./mvnw clean package spring-boot:repackage -P beanstalk
```
