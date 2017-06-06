package model

/**
  * Created by abhishek on 06/06/17.
  */
sealed trait AnswerType{
  val answerType: String
}

case class FreeTextType(answerType: String = "Free Text") extends AnswerType

case class BooleanType(answerType: String = "Boolean") extends AnswerType
