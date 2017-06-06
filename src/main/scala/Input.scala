/**
  * Created by abhishek on 05/06/17.
  */
trait Input {
  def getIntInput(): Int = {
    scala.io.StdIn.readInt()
  }
}
