package com.duchessfr.spark.part1.intro

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
  def findAllTweetsByUsers (tweets :RDD[Tweet])={
      tweets.groupBy(_.user)
  }

    // Find how many tweets each user has
  def nbTweetByUsers (tweets: RDD[Tweet]) = {
      tweets.map(tweet => (tweet.user, 1))
            .reduceByKey(_+_)

      //Top 10 twitterers
      val top10 = nbTweetsPerUser.sortBy(_._2,false).take(10)
      //or
      val top10bis = nbTweetsPerUser.top(10)((Ordering.by(m => m._2)))
  }

}
