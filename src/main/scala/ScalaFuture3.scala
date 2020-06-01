import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
//Combining future example
//
object Main extends App {

  def job(n: Int) = Future {
    Thread.sleep(1000)
    println(n)
    n + 1
  }

  val f = for {
    f1 <- job(1)
    f2 <- job(f1)
    f3 <- job(f2)
    f4 <- job(f3)
    f5 <- job(f4)
  } yield List(f1, f2, f3, f4, f5)
  f.map(z => println(s"Done. sum is :"+z.sum))

  // this method  will execute job asynchronously
  Future.sequence(List(job(1),job(2))).map{
    list => println("Using sequence"+list.sum)
  }
  Thread.sleep(6000)

}