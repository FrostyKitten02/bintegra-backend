# Bintergra-backend for "Samopostrežni portla"

## Project setup
1. Install liferay plugin, if you are using Intellij.
2. Run initBundle on project, this will create bundles folder, if you are in Intellij you can do this by right clicking on root of the project and selecting liferay plugin and initBundle option.
3. Go to project structure and make sure that you are using JDK 8 or 11.
4. After that a run config will be created, otherwise you have to run tomcat server in bundles folder located in bundles/tomcaat-[version], again make sure you are using java 8 or 11.
5. If you want to add modules you have to create new maven project in modules folder, for more info go see liferay documentation on modules.


## Modifiying and deploying modules
### Model (module) and Headless-rest (module)
1. Firstly deploy the model module and then Headless-rest (for Headless-rest skip part 2).
2. Modifying anything in the Model module will require you to run service builder plugin.
3. After that you will need to install the module (mvn install in the module root). Or in Intellij you can navigate to maven -> modules -> lifecycle -> install. Jar file will be located in the target folder (located in the root of the module).
4. Copy the jar file and paste it in the deploy folder located root folder -> bundles -> deploy.
5. If the modules were deployed correctly, logs should go from processing to STARTED.
6. This will redeploy your module.

Connection to database is in the portal-ext.properties. You can change it to your liking (make sure you include all the neccessary db connectors).

## Liferay localhost:8080
1. To access the Liferay UI go to localhost:8080.
2. Navigate to sign in: username: test@liferay.com, password: test. You can proceed to change password to your liking. If you can't sign in try opening another browser -  Liferay has problems with sign in on Opera - instead use Edge.

### Docker 
Run docker-compose.yml file in the folder. Custom images are uploaded to afridau/afridau repository on Docker Hub - with tags bintegrareact and bintegrabackend.
1. Firstly you need Docker installed - install Docker.
2. Go to the root folder of the file and run " docker compose . "
3. You should see a container in the Containers.
4. Run the images.
Make sure you don't have ports 8080, 8009, 11311, 8000 binded - if you have kill the processes on those ports.

Authors: Alen Fridau, Klara Kebrič
