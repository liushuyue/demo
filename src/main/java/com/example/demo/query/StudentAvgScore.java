package com.example.demo.query;
import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Aggregates.*;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

/**
 * Created by liushuyue on 2018/5/22.
 */
public class StudentAvgScore {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("school");
        MongoCollection<Document> student = database.getCollection("student");
        AggregateIterable<Document> iterable = student.aggregate(Arrays.asList(group("$年级", avg("平均成绩", "$成绩"))));
        printResult(iterable);
    }

    private static void printResult(AggregateIterable<Document> iterable) {
        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }
}
