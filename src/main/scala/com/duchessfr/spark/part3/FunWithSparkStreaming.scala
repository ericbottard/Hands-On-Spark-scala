package com.duchessfr.spark.part4

import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.StreamingContext._


object FunWithSparkStreaming extends App{

    val CONSUMER_KEY = "";
    val CONSUMER_SECRET = "";
    val ACCESS_TOKEN = "";
    val ACCESS_TOKEN_SECRET = "";

    System.setProperty("twitter4j.oauth.consumerKey", CONSUMER_KEY)
    System.setProperty("twitter4j.oauth.consumerSecret", CONSUMER_SECRET)
    System.setProperty("twitter4j.oauth.accessToken", ACCESS_TOKEN)
    System.setProperty("twitter4j.oauth.accessTokenSecret", ACCESS_TOKEN_SECRET)



    val conf = new SparkConf()
      .setAppName("HashTagMining")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(50))

    //Here we start a stream of tweets
    val stream = TwitterUtils.createStream(ssc, None, Array[String]())

    //Your turn ...

    ///For each tweet in the stream filter out all the hashtags
    //  stream is just an RDD so you can do all the operation you did in the first part of the hands-on

    //val hashTags = stream.flatMap ...

    //Now here, find the 30 most popular hashtags in a 30 seconds window 
    // Look at the reduceByKeyAndWindow function in the spark doc ... it should like this :
                      

    // Now that we have our top30 we can print them out....
  


}
