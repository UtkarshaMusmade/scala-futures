import ScalaFuture2.divide

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FutureErrorHandling extends App{
 val future =Future {"abc".toInt}


  future.onComplete {
    case Success(r) =>  println("Using On comlete"+r)
    case Failure(exception) => println(exception)
  }


  val input = "500"
  case class NumberTooLarge() extends Throwable()
  val f = for {
    f1 <- Future{ input.toInt }
    f2 <- if (f1 > 100) {
      Future.failed(NumberTooLarge())
    } else {
      Future.successful(f1)
    }
  } yield f2
  f map(println) recover {case e => e.printStackTrace()}

  Thread.sleep(100)
}
