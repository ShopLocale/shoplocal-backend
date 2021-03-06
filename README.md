# trini

UML Ref. https://lucid.app/lucidchart/b611fed6-e4f6-4b2a-abb9-127aacdc8ebb/edit?page=0_0#

Google Doc Ref. https://docs.google.com/document/d/1pVFoGhNqNvAy361JCAAR8zNfrH-wlIfCLGGGN0lVX9k/edit?ts=5fdf7786

## Development setup
### Start the DB
```
cd docker
sudo docker-compose up -d
```
(Create trini db if not exists)
```
sudo docker exec -it shoplocal_trini_1 /bin/bash
mysql -u root -p
CREATE DATABASE IF NOT EXISTS trini;
```
Change application yaml for the very first application run to populate data from import.sql
```
ddl-auto=create
```

## Sample cURL
```
curl --location --request GET 'http://localhost:8080/shop-management/v1/shop/?latitude=28.95&longitude=77.75&pinCode=250004'
```
## Dump for sample data population for development
```
mysqldump -u root -p --port=3307 --protocol=tcp --host=localhost trini --extended-insert=FALSE --no-create-info > import.sql
```
#### Products
```
mysqldump -u root -p --port=3307 --protocol=tcp --host=localhost trini products --extended-insert=FALSE --no-create-info > import.sql
```