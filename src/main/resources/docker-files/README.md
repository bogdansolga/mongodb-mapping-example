1. Run just once (after installing Docker): 
`docker volume create mongodb-data && docker volume create mq-data`

2. To start and stop the apps:
  - Mac:
    - start: `docker-compose --project-name orchestrator --env-file mac.env up --detach`
    - stop:  `docker-compose --project-name orchestrator --env-file mac.env down`
    
  - Win:
    - start: `docker-compose --project-name orchestrator --env-file win.env up --detach`
    - stop:  `docker-compose --project-name orchestrator --env-file win.env down`

3. If you want to check the containers state: `docker-compose ps`