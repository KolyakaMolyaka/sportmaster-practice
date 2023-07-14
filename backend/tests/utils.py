def generate_quiz() -> dict:
    """ Вспомогательная функция создания викторины """
    quiz = {
        'title': 'quiz title',
        'description': 'quiz description',
        'category': 'chess',
        'difficulty': 'easy'
    }
    return quiz


def generate_question() -> dict:
    """ Вспомогательная функция создания вопроса"""
    question = {
        'text': 'question text'
    }
    return question


def generate_answer() -> dict:
    """ Вспомогательная функция создания ответа """
    answer = {
        'text': 'answer text',
        'isCorrect': False
    }

    return answer
