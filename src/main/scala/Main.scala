package com.kwame.tutoriial

import org.apache.spark.sql.functions.{col, concat, lit}
import org.apache.spark.sql.types.StringType
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

    // Fourth
    val column = df("Open")

    val newColumn = (column + (2.0)).as("IncreasedBy2") // Increase all the values in the column by 2 and using "as" to give the column a better name1
    df.select(newColumn).show

    val columnString = column.cast(StringType)
    df.select(column,newColumn,columnString)
      .filter(newColumn > 2)
      .filter(newColumn > column)
      .filter(newColumn === column) // Using == will be comparing two objects, === will be comparing columns
      .show()
    val colHelloWord = lit("Hello World") // Creating a column with "hello World" only

    /*
       concat function
       Concatenating two columns:
       if you "1" and "2" in specific columns it becomes "12"
       Same applies to every row in the two columns
     */
    val togetherCol = concat(colHelloWord,column)
    df.select(togetherCol).show()

    val sqlExpr = new SqlExpression()
    sqlExpr.workingWithSqlExpr(df)

    /*
     * df.selectExpr method
     * Get a df using sql string expressions
     */
    df.selectExpr("cast(Date as string)", "Open  + 10","current_timestamp()").show

    /*
     * We can use the spark session to run sql queries through spark sql
     * First we register the dataframe so that it becomes visible in spark
     * We do that by creating the tempView with a name and use the same name on the sparkSession
     * Not recommended
     */
    df.createTempView("tempView")
    spark.sql("Select * from tempView").show()


  }
}