package com.duchessfr.spark.part1

import com.duchessfr.spark.utils.TweetUtils
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._
import com.duchessfr.spark.utils.TweetUtils._

object HashTagMining {

  // Find all the hashtags mentioned in all the tweets set
 
 
  // Count how many times each hashtag is mentioned
 

  // Find the 10 most popular Hashtags

 

  def main(args: Array[String]) = {
    // create conf and spark context
    val conf = new SparkConf()
      .setAppName("HashTagMining")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)

    val tweets = sc.textFile("data/reduced-tweets.txt")
                             .mapPartitions(TweetUtils.parseFromJson(_))
                             .cache

  }

}
