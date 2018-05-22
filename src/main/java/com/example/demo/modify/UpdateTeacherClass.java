package com.example.demo.modify;

import com.example.utils.MongoManager;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Updates.*;

/**
 * Created by liushuyue on 2018/5/22.
 */
public class UpdateTeacherClass {
    public static void main(String[] args) {
        MongoDatabase mongoDatabase= MongoManager.getDB("school");
        MongoCollection mongoCollection=mongoDatabase.getCollection("teacher");
        mongoCollection.updateOne(new Document("教师编号","5"),set("班级", Arrays.asList("三年级一班")));
    }
}
