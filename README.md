Spring-Hibernate-template
=========================

Its a work in progress and expected to add more features to it.


### Project Setup
1. ```git clone``` this repository.
2. From the clone root run ```mvn install```
3. Create a new project directory ```/projects/new_sample```
4. Run the generate command ```mvn archetype:generate -DarchetypeCatalog=local.``` Local tells maven to look to the local repo for all archetypes and present with a list to pick one.
5. Enter the required parameters and the project is created.
6. cd into the project directory and run ```mvn jetty:run```.

### TODOs
Contributions and ideas are welcome. These are some ideas we would like to implement.

1. Remote install on local ```maven:archetype -DarchetypeRepository=path_to_maven_repo_with_archetype_jar```
2. Add Deployment Script for Beanstalk
3. Add ```PMD,CheckStyle``` guidlines to follow best practices
