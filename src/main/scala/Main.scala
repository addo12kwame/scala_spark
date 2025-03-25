package com.kwame.tutoriial

import org.apache.spark.sql.SparkSession


object Main {
  def main(args :Array[String]): Unit = {
    val spark  = SparkSession.builder()
      .appName("SparkTutorial")
      .master("local[*]")
      .getOrCreate()

    val df = spark.read
      .option("header",value = true)
      .option("inferSchema", value = true) // Infer different data types in our dataframe. Schema closely matches the data in the dataframe
      .csv("./data/AAPL.csv")

    df.show() // print the first 20 rows of the dataframe
    df.printSchema()
  }
}