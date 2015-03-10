package com.duchessfr.spark.part4

import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.twitter._
import org.apache.spark.streaming.StreamingContext._


object FunWithSparkStreaming extends App{



    val CONSUMER_KEY = "pbKtClp9d5VJgze55Ye9vgFU1";
    val CONSUMER_SECRET = "waNzIlFpxgV34ffpwqhBfxYS32JKVaF4QmfzF4okjgmTDhTijM";
    val ACCESS_TOKEN = "17257535-2MITVNwKdhdsEVRUB86ga3MtlJZL4u2aoNxOiFvTg";
    val ACCESS_TOKEN_SECRET = "eqx5sJHXgKLhRPR7XTuixXlRJevq9zpyT67UZ1mChwuGN";

    System.setProperty("twitter4j.oauth.consumerKey", CONSUMER_KEY)
    System.setProperty("twitter4j.oauth.consumerSecret", CONSUMER_SECRET)
    System.setProperty("twitter4j.oauth.accessToken", ACCESS_TOKEN)
    System.setProperty("twitter4j.oauth.accessTokenSecret", ACCESS_TOKEN_SECRET)



    val conf = new SparkConf()
      .setAppName("HashTagMining")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(50))
    val stream = TwitterUtils.createStream(ssc, None, Array[String]())

    val hashTags = stream.flatMap(status =>
                    status.getText.split(" ").filter(_.startsWith("#"))
                    )

    val topCounts30 = hashTags.map((_, 1)).
                              .reduceByKeyAndWindow(_ + _, Seconds(30))
                              .map{case (topic, count) => (count, topic)}
                              .transform(_.sortByKey(false))


    topCounts30.foreachRDD(rdd => {
        val topList = rdd.take(10).toList
        val r = topList.map{case (count, tag) => println(s"$tag: $count")}
          })












}
