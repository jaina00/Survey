package model

/**
  * Created by abhishek on 06/06/17.
  */
case class Question(text: String, answerType: AnswerType)

object Question{
  val nameQuestion = Question("What's your name?", FreeTextType())
  val driverLicenseQuestion = Question("Do you have a driving license?", BooleanType())
  val petNameQuestion = Question("Enter your pet's name please?", FreeTextType())
  val ageQuestion = Question("How old are you?", FreeTextType())

}