package com.duchessfr.spark.part1

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import com.duchessfr.spark.utils._

/**
 *  Count how much each word appears in a file and make some operation on the result
 */
object Wordcount {

  val pathToFile = "data/reduced-tweets.txt"

  def wordcount(tweets: RDD) = {

    val wordcount = tweets.flatMap(line => line.split(" "))
                          .map(word => (word, 1))
                        .reduceByKey( _ + _)

    println("Pair number : " + wordcount.count())
    println("The first result : " + wordcount.first())
    println("The first 10 results : " + wordcount.first())


    // Save the result in an output file
    wordcount.saveAsTextFile("/pathDirectory/wordcount")

    // Now find words which appear more than 4 times
    val filter = wordcount.filter(pair => pair._2 >= 4)

    println("Pair number : " + filter.count());
    println("The first result : " +  filter.first());
    // All the results
    wordcount.foreach(println)
}


  def main(args: Array[String]) = {

    // create spark  configuration and spark context
    val conf = new SparkConf()
                    .setAppName("Wordcount")
                    .setMaster("local[*]")

    val sc = new SparkContext(conf)

    // load data and create an RDD of string
    val tweets = sc.textFile(pathToFile)
                   .mapPartitions(line => parseFromJson(_))
                   .cache()

    //wordcount(tweets)

    sc.stop()
  }

}
