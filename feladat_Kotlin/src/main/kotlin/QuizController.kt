import java.io.File
class QuizController(){

    val questions: MutableList<Question> = mutableListOf()

    init {
        var answer = arrayListOf<String>()
        var text = " "
        var question : Question = Question()
        var i = 5

        File("questions.txt").forEachLine {
            when {
                i % 5 == 0 -> text = it
                else -> answer.add(it)
            }
            i++

            if (i % 5 == 0)
            {
                question = Question(text,answer)
                questions.add(question)
                answer = arrayListOf()
            }
        }

    }

    fun doQuiz(element: Int) : Unit
    {
        val arrayQ = randomizeQuestions()

        var k1 = 0; var k2 = 0
        var answer: String?
        var summa = 0

        while(k1 < element)
        {
            println(questions.get(arrayQ[k1]-1).text)

            val array = 1..4
            val arrayA = array.shuffled()

            while(k2 < 4)
            {
                println("${k2+1}.) ${questions.get(arrayQ[k1]-1).answers.get(arrayA[k2]-1)}")
                k2++
            }
            k2 = 0
            answer = readLine()
            var nb = answer?.toInt()

            val myAnswer = questions.get(arrayQ[k1]-1).answers.get(arrayA[nb!! -1]-1)
            val correct = questions.get(arrayQ[k1]-1).answers.get(3)

            if(myAnswer.equals(correct))
            {
                summa++
            }

            k1++
        }

        println("Correct answers/Total number of answers: $summa/$element")
    }

    fun randomizeQuestions() : List<Int>
    {
        val list = 1..questions.size
        val i = list.shuffled()
        return i
    }
}

fun toString(myQuestion: QuizController) {
    for(i in myQuestion.questions)
    {
        println(i.text)
        println(i.answers)
    }
}