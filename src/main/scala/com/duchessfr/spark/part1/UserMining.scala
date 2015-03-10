package com.duchessfr.spark.part1

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._
import com.duchessfr.spark.part1.intro.util._

object UserMining extends App{
  
 val data = "data/reduced-tweets.txt";

  // create spark  configuration and spark context
  val conf = new SparkConf()
    .setAppName("HashTagMining")
    .setMaster("local[*]")

  val sc = new SparkContext(conf)

 // Load the data  and parse it into a Tweet. Look at the Tweet Objetc in the TweetUtils class.
  val tweets = sparkContext.textFile(data)
                           .mapPartitions(TweetUtils.parseFromJson(_))
                           .cache

 
  // Find all the tweets by user
 

    // Find how many tweets each user has, and find Top 10 people which the most tweets
  

}
