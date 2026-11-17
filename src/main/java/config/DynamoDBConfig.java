// TODO(reto): archivo stubbeado; implementa los cuerpos.
package config;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.net.URI;

public class DynamoDBConfig {

    private static final String LOCAL_ENDPOINT = "http://localhost:4566";
    private static final String REGION = "us-east-1";
    private static final String ACCESS_KEY = "fakeAccessKey";
    private static final String SECRET_KEY = "fakeSecretKey";

    public DynamoDbClient dynamoDbClient() {
      throw new UnsupportedOperationException("TODO(reto): dynamoDbClient");
    }
}