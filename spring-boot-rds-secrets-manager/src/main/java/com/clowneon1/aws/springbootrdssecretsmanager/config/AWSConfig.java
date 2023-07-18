package com.clowneon1.aws.springbootrdssecretsmanager.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.clowneon1.aws.springbootrdssecretsmanager.model.AwsSecrets;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AWSConfig {


    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secrets-key}")
    private String secretKey;

    private Gson gson = new Gson();

    @Bean
    public DataSource dataSource(){
        AwsSecrets secrets = getSecret();
        return DataSourceBuilder.create()
//                .driverClassName("") this is not required now
                .url("jdbc:" + secrets.getEngine() + "://" + secrets.getHost() + ":" + secrets.getPort() + "/books")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
    }

    public AwsSecrets getSecret() {

        String secretName = "database3-books";
        String region = "ap-south-1";

        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();

        String secret;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(secretName);
        GetSecretValueResult result;

        try{
            result = client.getSecretValue(getSecretValueRequest);
        }catch (Exception e){
            throw e;
        }
        if(result.getSecretString() != null){
            secret = result.getSecretString();
            return gson.fromJson(secret, AwsSecrets.class);
        }

        return null;
    }
}
