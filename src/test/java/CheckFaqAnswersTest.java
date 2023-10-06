
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import static constants.Answers.*;


@RunWith(Parameterized.class)
    public class CheckFaqAnswersTest extends BaseTest {

    private final String answer;

        private final int questionNumber;
        private final boolean expectedResult;

        public CheckFaqAnswersTest(int questionNumber, String answer, boolean expectedResult) {
            this.answer = answer;
            this.expectedResult = expectedResult;
            this.questionNumber = questionNumber;
        }

        // Тестовые данные
        @Parameterized.Parameters
        public static Object[][] getCredentials() {

            return new Object[][]{
                    {1, ANSWER_ONE, true},
                    {2, ANSWER_TWO, true},
                    {3, ANSWER_THREE, true},
                    {4, ANSWER_FOUR, true},
                    {5, ANSWER_FIVE, true},
                    {6, ANSWER_SIX, true},
                    {7, ANSWER_SEVEN, true},
                    {8, ANSWER_EIGHT, true},
            };
        }

        @Test
        public void checkFaqStatusTest() {
            MainPage mainPage = new MainPage(driver);
            mainPage.faqQuestionClick(questionNumber-1);
            Assert.assertEquals(expectedResult,mainPage.checkFaqAnswer(answer));

        }
    }
