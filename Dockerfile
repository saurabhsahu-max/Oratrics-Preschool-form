FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# ✅ give permission to mvnw
RUN chmod +x mvnw

# build project
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/*.jar"]
