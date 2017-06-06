package model

/**
  * Created by abhishek on 06/06/17.
  */
case class Question(text: String, answerType: AnswerType)

object Question{
  val name = Question("What's your name?", FreeTextType())
  val driverLicense = Question("Do you have a driving license?", BooleanType())
  val petName = Question("Enter your pet's name please?", FreeTextType())
  val age = Question("How old are you?", FreeTextType())

}