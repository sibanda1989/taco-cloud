# taco-cloud


## Docker-commands
Listing some commands for docker and cassandra for the project
```
docker run --name taco-cassandra \
--network cassandra-net \
-p 9042:9042 \
-d cassandra:latest
```
This pulls the latest image for cassandra,

```
docker run -it --network cassandra-net --rm cassandra cqlsh taco-cassandra
```
Opens an interactive cassandra query language (cql) shell

```
create keyspace tacocloud with replication={'class':'SimpleStrategy', 'replication_factor':1} and durable_writes=true;
```
will create a keyspace within cassandra named tacocloud with a simple replication and durable writes.
