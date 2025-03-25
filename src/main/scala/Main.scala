package com.kwame.tutoriial

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{DataFrame, SparkSession}


object Main {
  def main(args :
           Array[String]): Unit = {
    val spark  = SparkSession.builder()
      .appName("SparkTutorial")
      .master("local[*]")
      .getOrCreate()

    val df:DataFrame = spark.read
      .option("header",value = true)
      .option("inferSchema", value = true) // Infer different data types in our dataframe. Schema closely matches the data in the dataframe
      .csv("./data/AAPL.csv")

    df.show() // print the first 20 rows of the dataframe
    df.printSchema()

    df.select("Date", "Open", "Close").show()  // Select specific columns with the select API

    val dataColumn = df("Date") // Getting a column from a dataframe

//    df.select(dataColumn).show() // Select(col: Columns*) using the columns

//    df.select(col("Date")).show()

    import spark.implicits._
    val columnDollar = $"Close" // Gets the column "close"

    df.select(col("Date"), $"Open", df("Close")).show() // These are the multiple ways to reference column


  }
}