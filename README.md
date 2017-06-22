# Adresboek

Adresboek voor Scrum/Git

## Git

Eerste keer git setup:

    git config --global user.name "John Doe"
    git config --global user.email johndoe@example.com

    
## MySql driver
    
Download MariaDB JDBC driver van

<https://downloads.mariadb.com/Connectors/java/connector-java-2.0.2/mariadb-java-client-2.0.2.jar> 

en zet deze in de ```lib``` directory.


## MySql database

Aanmaken van database en user gaat met het script in

    sql/dbinit.sql
   
# Dit project gebruiken in Eclipse
## Versie Neon.3
1. File>Import
2. Selecteer "Projects form Git"
3. Kies "Clone URI"
4. Vul in bij URI: https://github.com/ErikMast/adresboek.git
5. Bij User je eigen GitHub account (en daaronder je eigen password natuurlijk)
6. Klik 2x op Next 
7. Kies in het Local Destination scherm waar je het project neer wilt zetten
8. Kies weer Next
9. Controleer of "Import using New Project Wizard" geselecteerd is
10. Kies "Finish"

11. In de Wizard kies je voor "Java project"
12. Als project name vul je "adresboek"
13. Klik op "Finish"

Mocht je project niet werken vanwege "No suitable driver found" :
1. Klik op het project met rechts en open de Properties
2. Kies Java Build Path, en het tabblad Libraries
3. Kies "Add External Jar" en kies de jar die kunt downloaden via de link hierboven en daarna op een slimme plek hebt neergezet.

Vervolgens kun je project starten.

#Taiga integratie
Als je in een commit TG-123 toevoegt zal de commit ook in Taiga zichtbaar zijn (zegt de handleiding)

    
