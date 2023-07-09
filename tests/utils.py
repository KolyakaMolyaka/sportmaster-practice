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

