package com.duchessfr.spark.part2

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.sql._


object FunWithSparkSQL extends App{


//Create a SQL Context

val sqx = new SQLContext(sparkContext)

//Load  the data as a JSON FILE
val rawTweets = sqx.jsonFile("data/tweet-data.json").cache

//Register the json data as tweetTable
rawTweets.registerTempTable("tweetTable")

//Now We print the schema that Spark SQL inferred by going through al json data file.
// Take a look at the schema to see how it is structured
rawTweets.printSchema


//Now Let's query the data

//Find all the mentioned users
val users = sqx.sql("SELECT DISTINCT user.screen_name FROM tweetTable ")//.count
                
users.take(10).foreach(println)


//// Find how many tweets each user has
val countTweetsByUsers = sqx.sql (
            "SELECT DISTINCT user.screen_name, COUNT(*) as cnt FROM tweetTable GROUP BY user ORDER BY cnt  DESC ")

countTweetsByUsers.take(100).foreach(println)


// Find the most tweeted languages ....
val languagesInTweets = sqx.sql(
          "SELECT lang, COUNT(*) as cnt FROM tweetTable GROUP BY lang ORDER BY cnt DESC LIMIT 25" )

languagesInTweets.take(10).foreach(println)


// For more advanced stuff like querying the depply nested data, you can use Hive inner UDFS by
// instanciating the HiveCtx.
// There is mor einto SPark SQL  ... Try it out.


}
