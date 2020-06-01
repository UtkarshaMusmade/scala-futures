import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success}

object ScalaFuture2 extends App {

  def divide(a: Int, b: Int) = Future {
    println("Hi")
    Thread.sleep(100)
    a / b
  }

  divide(4, 0).onComplete {
    case Success(r) =>  println("Using On comlete"+r)
    case Failure(exception) => println(exception)
  }


  Thread.sleep(1000)
}
