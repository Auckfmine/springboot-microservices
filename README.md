# Project Module : Devops
## Les Outils Utilisé dans notre project 
### DEV
#### backend
-  springboot microservices
-  spring-cloud (eureka discovery server)
-  zipkins
-  spring-cloud API-GATEWAY
-  Junit
-  Lombok
#### frontend
- angular
- nginx (routage dynamic + reverse-proxy + load-balancer)
##### base de donnés
- MySQL
- PostgreSQL
- MongoDB
- redis
NB: on a utilisé une variété de solution de bd pour bien profiter de notres architecture microservice .
### OPS
#### version control (GIT)
- github
#### CI 
- jenkins
#### IAC
- terraform
- ansible
#### Infrastructure
- Vagrant
##### contenarisation
- docker
##### orchestration des conteneurs
- docker-compose
##### container/artifact registry
- nexus
# TODO
- [x] transformer le project on microservice
- [x] exposer tous les service en un seul api gateway avec routage dynamique(localhost:9191)
- [ ] developer les test unitaire de chaque service
- [x] dockerizer tous les services
- [ ] creation des resource docker avec terraform
- [ ] automatisation des configuration avec Ansible
- [ ] implementation d'une chaine ci/cd 


