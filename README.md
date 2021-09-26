```sh
docker pull mysql/mysql-server
docker run --name mysql -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=fcnfs -p 3306:3306 -d mysql/mysql-server
docker exec -it mysql mysql -uroot -p
```

# Documentação

### Postman

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/7925953-1dc0aba9-a10d-4234-bf46-fd0dc43966d4?action=collection%2Ffork&collection-url=entityId%3D7925953-1dc0aba9-a10d-4234-bf46-fd0dc43966d4%26entityType%3Dcollection%26workspaceId%3Df8deb6c2-d9f9-4f0c-ac15-f1136320656a)
