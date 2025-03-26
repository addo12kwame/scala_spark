package com.kwame.tutoriial

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{current_timestamp, expr}
import org.apache.spark.sql.types.StringType

class SqlExpression {

  def workingWithSqlExpr(df: DataFrame):Unit = {
    /*
      Using the expr() from sql.function.expr to write create a timestamp column
      Using the current_timestamp() function to get a timestamp column also
      We also use the "as" to give it a new alias
      NB::::: Expr doesn't have compiler safety. It is easy to make a mistake with the string expression


     */
      val timeStampColumn = expr("cast(current_timestamp() as string) as TimestampExpr")
      val funcTimeStampCol = current_timestamp().cast(StringType).as("TimestampFunction")

      df.select(timeStampColumn,funcTimeStampCol).show()
  }

}
