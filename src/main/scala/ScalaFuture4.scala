import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object TestFutures extends App {
var a=0
  val read = Future{println("reading..............");a}
  val write = Future{println("writing..............");a+1}

  read.map{
    r=>println(r)
  }

  write.map{
    r=>println(r)
  }

  Thread.sleep(5000)
  println(a)
}