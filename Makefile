start:
	docker-compose -f local/docker-compose.yaml up -d --force-recreate

init_db:
	PGPASSWORD=password psql -h 127.0.0.1 -U root -d main -a -f src/main/resources/db.sql