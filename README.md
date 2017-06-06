# Survey
use 'sbt run' in terminal to start the application.

use 'sbt test' to run tests.

Assumptions:
Age should be between 0 and 120. If user gives incorrect age, then would be prompted to enter it again.

I have created a trait SurveyTrait and an object Survey. SurveyTrait is having the main method and 2 dependencies (input and output).

This design helped me ensuring that the side effect (console i/p and println) is not in the main trait.
And when testing, I was able to mock these dependencies.