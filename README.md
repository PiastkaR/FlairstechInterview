## Flairstech Interview Application 
Please make sure you have docker installed on your pc.\
Please go to folder src/main/docker and run app with: 'docker-compose up'.\
Docker container is exposed on localhost port 8080.\
DB and app should run one after another in containers.

*Resulting endpoint is under http://localhost:8080/numberSource/id=1, GET \
*Application is also runnable via spring-boot. Before you run it in your IDE, please run 'docker run -d -p 5432:5432 ghusta/postgres-world-db:2.5', to run DB.  
