import org.apache.spark.{SparkConf,SparkContext}

object group{
  def main(args: Array[String]): Unit ={
    System.setProperty("hadoop.home.dir","C:\\Users\\Koppu\\Downloads\\hadoop-2.7.7\\hadoop-2.7.7")
    val conf = new SparkConf().setAppName("group by example").setMaster("local").set("spark.driver.host","localhost")
    val sc = new SparkContext(conf)
    val f=sc.textFile("C:\\Users\\Koppu\\OneDrive\\Desktop\\UMKC\\Big data applications\\Tutorial source codes\\CS5542-Tutorial2-SparkSourceCode\\Spark WordCount\\input")
    val wc=f.flatMap(line=>{line.split(" ")})
    val out=wc.groupBy(word=>word.charAt(0))
    out.foreach(println)
  }
}
