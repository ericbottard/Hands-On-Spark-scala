package com.duchessfr.spark.part2

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.sql._


object FunWithSparkSQL extends App{


  val conf = new SparkConf()
      .setAppName("HashTagMining")
      .setMaster("local[*]")

  val sc = new SparkContext(conf)
  //Create a SQL Context

  val sqx = new SQLContext(sc)

  //Load  the data as a JSON FILE

  val rawTweets = sqx.jsonFile("data/tweet-data.json")
                     .cache

  //Register the json data as tweetTable
  rawTweets.registerTempTable("tweetTable")

  //Now We print the schema that Spark SQL inferred by going through al json data file.
  // Take a look at the schema to see how it is structured
  rawTweets.printSchema


  //Now Let's query the data
  // Add the miising SQL Queries

  //Find all the mentioned users
  val users = sqx.sql(" ")//.count

  users.take(10).foreach(println)


  //// Find how many tweets each user has
  val countTweetsByUsers = sqx.sql ("").collect

  countTweetsByUsers.take(10).foreach(println)


  // Find the most tweeted languages ....
  val languagesInTweets = sqx.sql("").collect

  languagesInTweets.take(10).foreach(println)


  // For more advanced stuff like querying the depply nested data, you can use Hive inner UDFS by
  // instanciating the HiveCtx.
  // There is mor einto SPark SQL  ... Try it out.


}