#### Start up
1. docker compose up the postgresql database and pgadmin
   ``` 
   cd ./ 
   docker compose up
   ```

2. docker compose up the backend service 
   ```
   cd ./docker-compose-backend 
   docker compose up
   ```

3. When deploy with docker, we should check how many Vmmem consume at the time, and check it in ./USER/.wslconfig


#### Front End Vue.js Project
   - https://github.com/adrianwudev/driver-helper-vue
#### WinForm Uploader Project
   - https://github.com/adrianwudev/driver-helper-donet