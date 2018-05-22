package com.example.demo.query;

import com.example.utils.MongoManager;
import com.mongodb.AggregationOutput;
import com.mongodb.Block;
import com.mongodb.Cursor;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.BsonField;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;

/**
 * Created by liushuyue on 2018/5/22.
 */
public class ShowSumOfPersonByGrade {

    public static void main(String[] args) {
        MongoDatabase mongoDatabase=MongoManager.getDB("school");
        MongoCollection mongoCollection=mongoDatabase.getCollection("student");
        //List<Document> list =new ArrayList<Document>();
        AggregateIterable<Document> iterable= mongoCollection.aggregate(Arrays.asList(match(
                eq("年级","五年级")),group("$班级",sum("count",1))));
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.print(document);
            }
        });





    }
}
