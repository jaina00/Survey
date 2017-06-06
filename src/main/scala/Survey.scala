import model.{Age, Question}

import scala.util.{Failure, Success, Try}

/**
  * Created by abhishek on 05/06/17.
  */

trait SurveyTrait {
  val output: Output
  val input: Input

  def main(args: Array[String]): Unit = {
    output.askQuestion(Question.name)
    output.askQuestion(Question.age)

    val age = getAgeFromPrompt

    age match {
      case x if x < Age.decisionAge =>
        output.askQuestion(Question.petName)
      case _ =>
        output.askQuestion(Question.driverLicense)
    }
  }

  private def getAgeFromPrompt: Int = {
    Try {
      input.getIntInput()
    } match {
      case Success(age) => age match {
        case x if x > Age.minAge && x < Age.maxAge => x
        case _ => output.askQuestion(Question.age)
          getAgeFromPrompt
      }
      case Failure(_) =>
        output.askQuestion(Question.age)
        getAgeFromPrompt
    }
  }
}

object Survey extends SurveyTrait {
  val output: Output = new Output {}
  val input: Input = new Input {}
}