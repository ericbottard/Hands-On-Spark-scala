package com.duchessfr.spark.part1

import org.apache.spark.{SparkConf, SparkContext}

object TweetMining {

  val pathToFile = "data/reduced-tweets.txt";


  def main(args: Array[String]) = {
    // create conf and spark context
    val conf = new SparkConf()
        .setAppName("TweetMining")
        .setMaster("local[*]")

    val sc = new SparkContext(conf)

    
    sc.stop();
  }
}
