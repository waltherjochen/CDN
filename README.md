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
$ docker run -d prismacon/ds-server
$ docker run -d prismacon/ds-server
```
Get the address of the Tomcat server:

```bash
$ docker ps -a
$ docker inspect <tomcat container> | grep IPA
```

Point your browser to http://<address>:8080/CDN


## Login data

* username: user1, password: pass1
* username: user2, password: pass2
