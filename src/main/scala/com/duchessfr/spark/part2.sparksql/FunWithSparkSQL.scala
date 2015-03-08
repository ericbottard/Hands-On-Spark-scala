package com.duchessfr.spark.part2

object FunWithSparkSQL {

  /// Fun exercise ... Building an inverted index of hashtags
/**
An inverted is the data structure used to build search engines.
How does it work?
Assuming #spark is an hashtag that appears in tweet1, tweet3,tweet39
our inverted index is a Map (or HashMap) that contains a (key, value) pairs
as (#spark, Seq(tweet1,tweet3, tweet39)).

**/
def invertedIndex( tweets : RDD[Tweet])  = {
  val invertedIndex = tweets.flatMap (tweet =>
                               val ht = pattern findAllIn tweet.text
                               ht.map (ht => (ht, tweet))
                                 )
                            .groupByKey()      //expensive shuffle
                            .collectAsMap      //even more expensive ops


}


invertedIndex.take(3).foreach(println)

}
