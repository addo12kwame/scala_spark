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
      .csv("./data/AAPL.csv")

    df.show()
  }
}