import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object ScalaFuture5 extends App {
  var s = "THIS IS A STRING"
  val f0 = Future { 0 }
  val f1 = Future { 1 }
  val fx = Seq(f0,f1)
  fx.map {
    seq => seq.map {  i =>
      println("BEFORE ---> " + s)
      if (i == 0)
        s = s.replace ( "T", "@")
      else
        s = s.replace ("I", "#")
      println("AFTER ---> " + s)
    }
  }
  Thread.sleep(5000)
}