package com.duchessfr.spark.part1

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._
import com.duchessfr.spark.utils.TweetUtils
import com.duchessfr.spark.utils.TweetUtils._


object TweetMining {

  val data = "data/reduced-tweets.txt";

  // Find all the people mentioned on the tweets 


  // Find every people mentioned on tweet and count how many times they are mentioned


  // Find the 10 most mentioned people



  def main(args: Array[String]) = {
    // create conf and spark context
    val conf = new SparkConf()
        .setAppName("Text Mining")
        .setMaster("local[*]")

    val sc = new SparkContext(conf)


  }
}
