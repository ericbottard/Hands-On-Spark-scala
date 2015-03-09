# Spark-HandsOn
In this Hands-On, we are going to show how you can use Apache Spark and some components of it ecosystem for data processing.
This workshop is split in four parts. We will use a dataset that consists of tweets containing just a few fields like id, user, text, country and place.


In the first one, you will play with the Spark API for basic operations like counting, filtering, aggregating.

After that, you will get to know Spark SQL to query structured data (here in json) using SQL.

In the third part, you will use Spark Streaming and the twitter streaming API to analyse a live stream of Tweets.

To finish we will build a simple model to identify the language in a text. For that you will use MLLib.

Let's go and have fun !

## Prerequisites
- download Spark binaries
- sbt
- IDE

## Use the Spark shell
The Spark shell is very useful for interactive analysis. For example you can use it when you want testing or play with the API.
Just launch it with the following command (for the Scala shell) :

`spark-shell`

# Some links
Apache Spark <https://spark.apache.org>

Ampcamp <http://ampcamp.berkeley.edu/>

Spark via Databricks <http://databricks.gitbooks.io/databricks-spark-reference-applications/>

Talks 

- <https://speakerdeck.com/nivdul/lightning-fast-machine-learning-with-spark>
- <https://speakerdeck.com/samklr/scalable-machine-learning-with-spark>
