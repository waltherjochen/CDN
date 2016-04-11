# CDN

## Cassandra Setup

```bash
$ docker run -d --name cassandra1 prismacon/ds-db start
$ docker run -d --name cassandra2 --link cassandra1:seed prismacon/ds-db start seed
$ docker run -d --name cassandra3 --link cassandra1:seed prismacon/ds-db start seed
$ docker run -it --rm --net container:cassandra1 prismacon/ds-db nodetool status
$ docker run -it --rm --net container:cassandra1 prismacon/ds-db seed
```

## Tomcat Setup

```bash
$ docker run --rm prismacon/ds-server
$ docker run --rm prismacon/ds-server
```
Get the addresses of the Tomcat servers:

```bash
$ docker ps -a
$ docker inspect <tomcat container 1> | grep IPAddress
$ docker inspect <tomcat container 2> | grep IPAddress
```

Usually `172.17.0.5:8080` and `172.17.0.6:8080`. You should be able to point your browser to [http://172.17.0.5:8080](http://172.17.0.5:8080) and [http://172.17.0.6:8080](http://172.17.0.6:8080) and see the pizza shop page.

## nginx Setup
```bash
$ docker run --rm prismacon/ds-lb
```
It will balance the load based on the round-robin strategy between 172.17.0.5:8080 and 172.17.0.6:8080.

Nginx should be usually accessible on [http://172.17.0.7](http://172.17.0.7).

## Login data

* username: user1, password: pass1
* username: user2, password: pass2
