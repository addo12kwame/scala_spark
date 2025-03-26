# First spark application
- [ ] Download example data from kaggle **
- [ ] Instantiate a standalone SparkSession
- [ ] Read CSV file with Options
- [ ] Show DataFrame
- [ ] Add JVM option `--add-exports java.base/sun.nio.ch=All-UNNAMED`
# Second
- [ ] Inspect the schema `.printSchema()`
- [ ] Find documentation for data types
- [ ] CSV source option `inferSchema

# Third Dataset API
- [ ] The dataset API defines a DSL (domain specific language, declarative, not using scala functions)
- [ ] Thats how we tell Spark what to do
- [ ] Inspect Spark API within IDE
- [ ] `type DataFrame - Dataset[Row]`
- [ ] `Row` is a generic object (untyped view)

# Fourth DSL (i) Referencing columns
- [ ] Mostly when using the API, we work with Columns `col("a") + 5`
- [ ] Ways of referencing columns: String, apply, col, $ (implicits)
- [ ] Not necessarily bound to dataframe

# Fifth DSL (ii) Columns Functions
- [ ] The `Column` class
- [ ] Functions on columns: `===`, `cast`, `<`, `+`
- [ ] Reading the reference

# Sixth DSL (iii) `sql.functions`
- [ ] `col`,`lit`, `concat` 

# Seventh DSL (iv) Expressions
- Write SQL expressions as strings, which will be interpreted at runtime (no compiler safety)

