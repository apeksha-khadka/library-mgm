environments:
	docker-compose -f docker/docker-compose.yml up
remove-env:
	docker-compose -f docker/docker-compose.yml down