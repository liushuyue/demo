package com.example.utils;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

/**
 * Created by liushuyue on 2018/5/22.
 */
public class MongoManager {

    private final static String HOST = "localhost";// 端口
    private final static int PORT = 27017;// 端口
    private final static int POOLSIZE = 100;// 连接数量
    private final static int BLOCKSIZE = 100; // 等待队列长度
    private static Mongo mongo = null;
    private  static MongoClient mongoClient=null;


    private MongoManager() { }

    static {
        initDBPrompties();
    }

    public static MongoDatabase getDB(String dbName) {
        return mongoClient.getDatabase(dbName);

    }

    /**
     * 初始化连接池
     */
    private static void initDBPrompties() {
        // 其他参数根据实际情况进行添加
        try {
            mongoClient =new MongoClient(HOST,PORT);
            //   mongo = new Mongo(HOST, PORT);

            MongoClientOptions.Builder builder=new MongoClientOptions.Builder();
            builder.connectionsPerHost(POOLSIZE);
            builder.threadsAllowedToBlockForConnectionMultiplier(BLOCKSIZE);
            MongoClientOptions pos=builder.build();

            //   MongoOptions opt = mongo.getMongoOptions();
            //   opt.connectionsPerHost = POOLSIZE;
            //   opt.threadsAllowedToBlockForConnectionMultiplier = BLOCKSIZE;
        }
        catch (MongoException e) {

        }
    }
}
