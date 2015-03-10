package com.duchessfr.spark.part1

import com.duchessfr.spark.utils.TweetUtils._

import org.apache.spark.{SparkContext, SparkConf}

import scala.collection.Seq
import scala.collection.Seq
import scala.collection.immutable.Seq

object OptionalInvertedIndex {

  /**
   *  [Optional]
   *
   *  Buildind a hashtag search engine   *
   *  The goal is to build an inverted index. An inverted is the data
   *  structure  used to build search engines.
   *  How does it work?
   *
   *  Assuming #spark is an hashtag that appears in tweet1, tweet3, tweet39.
   *  Our inverted index is a Map (or HashMap) that contains a
   *  (key, value) pair as (#spark, List(tweet1,tweet3, tweet39)).
   *
   */

  def invertedIndex (tweets : RDD[Tweet]) : Map[String,List[Tweet]] = {
    
            tweets.flatMap (tweet =>                                  
                              val ht = pattern findAllIn tweet.text
                              ht.map (ht => (ht, tweet))
                            )
                   .groupByKey()      //expensive shuffle
                   .collectAsMap      //even more expensive ops

  }

  // create spark  configuration and spark context
  val conf = new SparkConf()
    .setAppName("HashTagMining")
    .setMaster("local[*]")

  val sc = new SparkContext(conf)

  val tweets = sparkContext.textFile("data/reduced-tweets.txt")
                           .mapPartitions(TweetUtils.parseFromJson(_))
                           .cache

  //Let's try it out
  val invertedIdx = invertedIndex(tweets)
  invertedIndex.take(3).foreach(println)

  invertedIndex.get(("#Madrid"))   //Put your own hashtags contained in the data

// Keep the fun going on
/*
 (optional) : Modify your code to index all the words in the tweets,
and track how many times each word appears in every tweet : your result should look likeHashMap<word,
List <(tweet, n)> >. where n is the number of time word appears in tweet.
#: Make it cooler .. and remove stopwords : la, le, des, du , ........
# Even more fun :
Find hashtags co occurrence .. Find all the pairs of hashtags (tag1, tag2)
that are tweeted together with the tweet containing them.
Bonus . count how many times they show up together. results should be an
RDD <((String, String),nn List<Tweet>)> ....
**/

}