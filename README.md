docker pull mysql/mysql-server
docker run --name mysql -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=fcnfs -p 3306:3306 -d mysql/mysql-server
docker exec -it mysql mysql -uroot -p
