package com.duchessfr.spark.part1.intro

import org.apache.spark.{SparkContext, SparkConf}


object HashTagMining {

  // Find all the hashtags mentioned in all the tweets set
  def mentionedHashtags(tweets: RDD[Tweet]) = {
      val pattern ="""#(\w+)""".r

      val tags = tweets.flatMap (tweet => pattern findAllIn tweet.text)



  }
  // Count how many times each hashtag is mentioned
  def hashtagsCount(tweets : RDD[Tweet]) = {

    val tags =mentionedHashtags(tweets).map (tag => (tag, 1))
                                      .reduceByKey(_ + _)

  }


  // Find the 10 most popular Hashtags

  def top10HashTags (tweets :RDD[Tweet], n : Int) ={

    mentionedHashTags(tweets).sortBy(_._2,false)
                             .take(n)

  }

  def main(args: Array[String]) = {
    // create conf and spark context
    val conf = new SparkConf()
      .setAppName("HashTagMining")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)

    val tweets = sparkContext.textFile("data/reduced-tweets.txt")
                             .mapPartitions(TweetUtils.parseFromJson(_))
                             .cache

  }

}
