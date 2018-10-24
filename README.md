# person-event-processor
kafka-poc person-service : Spring Boot service to consume PersonEvents from Kafka and update the People Database
Consumes the person event, 
saves the event in its event table as unprocessed.
calls the person-service api to get the person if necessary (not necessary for delete events)
then creates/updates/deletes the proper record in the People table to match.
update its event table to indicate the event has been processed.
