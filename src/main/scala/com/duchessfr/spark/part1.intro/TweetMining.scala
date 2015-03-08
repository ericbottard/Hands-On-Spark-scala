package com.duchessfr.spark.part1

import org.apache.spark.{SparkConf, SparkContext}

object TweetMining {

  val pathToFile = "data/reduced-tweets.txt";

  def replaceEbyOne(sc: SparkContext) {
    val data = sc.textFile(pathToFile);

    // replace all characters "e" of the file by "2"
    val result = data.map(word => word.replace("e", "2"))

    // print all the results

    result.foreach(println);
  }

  def groupWordsBylength(sc: SparkContext) {
    val data = sc.textFile(pathToFile)
                 .flatMap(line => line.split(" "));

    // group words by their length
    val result = data.groupBy(x => x.length)

    // print all the results
    result.foreach(println);
  }

  def main(args: Array[String]) = {
    // create conf and spark context
    val conf = new SparkConf()
        .setAppName("Text Mining")
        .setMaster("local[*]")

    val sc = new SparkContext(conf)

    replaceEbyOne(sc);

    groupWordsBylength(sc);

    sc.stop();
  }
}
