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
   //count here
    val wordcount = ...
    
    println("Pair number : ")
    println("The first result : " 
    println("The first 10 results : " )


    // Save the result in an output file
    wordcount.saveAsTextFile("/pathDirectory/wordcount")

    // Now find words which appear more than 4 times
    
    println("Pair number : ");
    println("The first result : " );
    // All the results
    //wordcount.foreach(println)
}


  def main(args: Array[String]) = {

    // create spark  configuration and spark context
    val conf = new SparkConf()
                    .setAppName("Wordcount")
                    .setMaster("local[*]")

    val sc = new SparkContext(conf)

    // load data and create an RDD of string
    val tweets = sc.textFile(pathToFile)
                  
    //wordcount(tweets)

    sc.stop()
  }

}
