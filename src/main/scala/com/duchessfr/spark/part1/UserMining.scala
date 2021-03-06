package com.duchessfr.spark.part1

import com.duchessfr.spark.utils.TweetUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._
import com.duchessfr.spark.utils.TweetUtils._

object UserMining extends App{
  
 val data = "data/reduced-tweets.txt";

  // create spark  configuration and spark context
  val conf = new SparkConf()
    .setAppName("HashTagMining")
    .setMaster("local[*]")

  val sc = new SparkContext(conf)

 // Load the data  and parse it into a Tweet. Look at the Tweet Objetc in the TweetUtils class.
  val tweets = sc.textFile(data)
                           .mapPartitions(TweetUtils.parseFromJson(_))
                           .cache

 
  // 1. Find all the tweets by user


  // 2. Find how many tweets each user has, and find Top 10 people which the most tweets
  

}
