# Spark-HandsOn
In this Hands-On, we will see how you can use Apache Spark and some components of it ecosystem for data processing.
This workshop is split in four parts. We will use a dataset that consists of tweets containing just a few fields like id, user, text, country and place.

Here is the [Hands-On presentation](http://www.slideshare.net/slideshow/embed_code/45631408) !

In the first one, you will play with the Spark API for basic operations like counting, filtering, aggregating.
After that, you will get to know Spark SQL to query structured data (here in json) using SQL.
In the third part, you will use Spark Streaming and the twitter streaming API to analyse a live stream of Tweets.
To finish we will build a simple model to identify the language in a text. For that you will use MLLib.

Let's go and have fun !

## Prerequisites
- Download Spark binaries : 
      http://spark.apache.com/downloads.html
      http://wwwftp.ciril.fr/pub/apache/spark/spark-1.2.1/spark-1.2.1-bin-hadoop1.tgz
- IDE of your choice. (Intellij IDEA is recommended)

## Use the Spark shell
The Spark shell is very useful for interactive analysis. For example you can use it when you want to test an idea or just play with the API.
To start the spark shell :
 Go to the folder where you decompressed the spark binaries, and type : 
`bin/spark-shell`

## Twitter Credentials
In the workshop, we will use at some point the Twitter Streaming API. To be able to read the firehose, you will need to create an app at http://apps.twitter.com , and get your credentials.


# Some links
- [Apache Spark](https://spark.apache.org)
- [Ampcamp](http://ampcamp.berkeley.edu/)
- [Spark via Databricks](http://databricks.gitbooks.io/databricks-spark-reference-applications/)

And Talks 

- [Lightning fast Machine Learning with Spark](https://speakerdeck.com/nivdul/lightning-fast-machine-learning-with-spark)
- [Scalable Machine Learning with Spark](https://speakerdeck.com/samklr/scalable-machine-learning-with-spark)
