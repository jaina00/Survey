import model.Question

/**
  * Created by abhishek on 05/06/17.
  */
trait Output {
  def askQuestion(question: Question): Unit = {
    println(question.text)
    println(question.answerType.answerType)
  }
}
