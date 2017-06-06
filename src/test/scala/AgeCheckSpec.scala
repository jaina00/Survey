import model.Question
import org.mockito.Mockito._
import org.scalatest.{BeforeAndAfterEach, WordSpec}
import org.scalatest.mockito._

/**
  * Created by abhishek on 05/06/17.
  */
class SurveySpec extends WordSpec
  with MockitoSugar
  with BeforeAndAfterEach {

  val mockOutput = mock[Output]
  val mockInput = mock[Input]

  override def afterEach(): Unit = {
    reset(mockOutput)
    reset(mockInput)
  }


  val ageCheck = new SurveyTrait {
    override val output: Output = mockOutput
    override val input: Input = mockInput
  }

  "Age Check" should {
    "ensure that if age is 20, asked for driver license" in {
      when(mockInput.getIntInput()).thenReturn(20)
      ageCheck.main(Array.empty)

      verify(mockOutput).askQuestion(Question.name)
      verify(mockOutput).askQuestion(Question.age)
      verify(mockOutput).askQuestion(Question.driverLicense)
    }

    "ensure that if age is 15, asked for pet's name" in {
      when(mockInput.getIntInput()).thenReturn(15)
      ageCheck.main(Array.empty)

      verify(mockOutput).askQuestion(Question.name)
      verify(mockOutput).askQuestion(Question.age)
      verify(mockOutput).askQuestion(Question.petName)
    }

    "ensure that age is asked again, if entered invalid. And asked for driving license when age is 50" in {
      when(mockInput.getIntInput())
        .thenThrow(new RuntimeException())
        .thenReturn(50)

      ageCheck.main(Array.empty)

      verify(mockOutput).askQuestion(Question.name)
      verify(mockOutput, times(2)).askQuestion(Question.age)
      verify(mockOutput).askQuestion(Question.driverLicense)

    }

    "ensure that age is asked again, if entered invalid. And asked for pet's name  when age is 12" in {
      when(mockInput.getIntInput())
        .thenThrow(new RuntimeException())
        .thenReturn(12)

      ageCheck.main(Array.empty)

      verify(mockOutput).askQuestion(Question.name)
      verify(mockOutput, times(2)).askQuestion(Question.age)
      verify(mockOutput).askQuestion(Question.petName)
    }

    "ensure that age is asked twice, if entered -1. And asked for pet's name  when age is 12" in {
      when(mockInput.getIntInput())
        .thenReturn(-1)
        .thenReturn(12)

      ageCheck.main(Array.empty)

      verify(mockOutput).askQuestion(Question.name)
      verify(mockOutput, times(2)).askQuestion(Question.age)
      verify(mockOutput).askQuestion(Question.petName)
    }

    "ensure that age is asked twice, if entered 130. And asked for pet's name  when age is 12" in {
      when(mockInput.getIntInput())
        .thenReturn(130)
        .thenReturn(12)

      ageCheck.main(Array.empty)

      verify(mockOutput).askQuestion(Question.name)
      verify(mockOutput, times(2)).askQuestion(Question.age)
      verify(mockOutput).askQuestion(Question.petName)
    }

  }
}
