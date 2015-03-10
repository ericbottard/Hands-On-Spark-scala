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
  
  
  //This is a toy exercice to get you to know some spark basics
  // use the spark shell for this.

  val pathToFile = "data/reduced-tweets.txt"

  def main(args: Array[String]) = {

    // create spark  configuration and spark context
    val conf = new SparkConf()
                    .setAppName("Wordcount")
                    .setMaster("local[*]")

    val sc = new SparkContext(conf)

    // load data and create an RDD of string
    val tweets = sc.textFile(pathToFile)
            

  }

}
