# Hibernate Examples

In this repository you will see a set of hibernate examples.


## List of Examples


### Mapping

* OneToOne - Bidirectional
* OneToOne - Unidirectional
* ManyToOne - Bidirectional
* ManyToOne - Unidirectional
* OneToMany - Unidirectional
* ManyToMany - Bidirectional
* ManyToMany - Unidirectional
* Large Objects - Blob and Clob
* Enumeration
* Embeddable and Embedded

### Miscellaneous

* Comment on SQL Statements
* Attribute Converter
* Data Transfer Objects


## Database Configuration

Most of examples in this repository use PostgreSQL 9.6 if you have docker installed just run the command below to setup your database.

```
docker run \
    --name hibernate-examples-postgres \
    --env 'POSTGRES_DB=hibernate-examples-database' \
    --env 'POSTGRES_USER=hibernate-examples-user' \
    --env 'POSTGRES_PASSWORD=hibernate-examples-password' \
    --detach \
    --publish 5432:5432 \
    postgres:9.6.18-alpine
```
