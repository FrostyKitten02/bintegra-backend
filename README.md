# Bintergra-backend for "Samopostrežni portla"

## Project setup
1. Install liferay plugin, if you are using intelij
2. Run bundleinit on project, this will create bundles folder, if you are in intelij u can do this by right clicking on root of the project and selecting liferay plugin and bindleinit option
3. After that a run config will be created, if not you just have to run tomcat server in bundles folder located in bundles/tomcaat-[version], make sure you are using java 8 or 11
4. If you want to add modules you have to create new maven project in modules folder, for more info go see liferay documentation on modules



## Modifiying modules
### Mddel (module)
1. Modifying anything in this will require you to run service builder plugin
2. After that you will need to install it and copy jar file into deploy folder in bundles folder
3. This will redeploy your module

### Headless-rest (module)
1. After changing anything in this module you have repeat steps 2 and 3 from above
