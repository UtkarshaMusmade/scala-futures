import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.collection.mutable.ListBuffer
object ScalaFuture extends App{

  def add(a:Int,b:Int) = Future{
    println("Hi")
    Thread.sleep(100)
    println("Hello")
    a+b
  }
  add(2,3)
  add(4,5)
  Thread.sleep(1000)
}
