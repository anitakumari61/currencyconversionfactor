FROM eclipse-temurin:11-jre-alpine 
ADD target/currencyconversionfactor-0.0.1-SNAPSHOT.jar currencyconversionfactor.jar
EXPOSE 9002
ENTRYPOINT [ "java", "-jar" , "currencyconversionfactor.jar"]
