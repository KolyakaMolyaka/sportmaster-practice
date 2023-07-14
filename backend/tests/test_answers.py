import requests
from utils import generate_quiz, generate_question, generate_answer


PORT = 8080
QUIZ_URL = f'http://127.0.0.1:{PORT}/quizzes'
QUESTION_URL = f'http://127.0.0.1:{PORT}/questions'


class TestAnswers:

    """ Тестирование GET запросов """
    @staticmethod
    def test_get_answer_200_ok():

        # создание викторины
        response = requests.post(QUIZ_URL, json=generate_quiz())
        quiz_id = response.json()['id']
        assert response.status_code == 200, 'Не удалось создать викторину на сервере, ожидался ответс со статусом 200 - успех'

        # создание вопроса
        response = requests.post(QUIZ_URL + f'/{quiz_id}' + '/questions', json=generate_question())
        assert response.status_code == 200, 'Не удалось создать вопрос на сервере, ожидался ответс со статусом 200 - успех'

        question_id = response.json()['id']
        
        # создание ответа на вопрос 

        response = requests.post(QUESTION_URL + f'/{question_id}' + '/answers', json=generate_answer())
        answer_id = response.json()['id']
        assert response.status_code == 200, 'Не удалось создать ответ на вопрос на сервере, ожидался статус ответа 200 - успех'

        response = requests.get(QUESTION_URL + f'/{question_id}' + '/answers' + f'/{answer_id}')
        assert response.status_code == 200, 'Не п олучить получить ответ на вопрос викторины, ожидался статус ответа 200'
 
    """ Тестирование POST запросов """
    @staticmethod
    def test_post_answer_200_ok():

        # создание викторины
        response = requests.post(QUIZ_URL, json=generate_quiz())
        quiz_id = response.json()['id']
        assert response.status_code == 200, 'Не удалось создать викторину на сервере, ожидался ответс со статусом 200 - успех'

        # создание вопроса
        response = requests.post(QUIZ_URL + f'/{quiz_id}' + '/questions', json=generate_question())
        assert response.status_code == 200, 'Не удалось создать вопрос на сервере, ожидался ответс со статусом 200 - успех'

        question_id = response.json()['id']
        
        # создание ответа на вопрос 

        response = requests.post(QUESTION_URL + f'/{question_id}' + '/answers', json=generate_answer())
        answer_id = response.json()['id']
        assert response.status_code == 200, 'Не удалось создать ответ на вопрос на сервере, ожидался статус ответа 200 - успех'

    """ Тестирование DELETE запросов """
    @staticmethod
    def test_delete_answer_200_ok():

        # создание викторины
        response = requests.post(QUIZ_URL, json=generate_quiz())
        quiz_id = response.json()['id']
        assert response.status_code == 200, 'Не удалось создать викторину на сервере, ожидался ответс со статусом 200 - успех'

        # создание вопроса
        response = requests.post(QUIZ_URL + f'/{quiz_id}' + '/questions', json=generate_question())
        assert response.status_code == 200, 'Не удалось создать вопрос на сервере, ожидался ответс со статусом 200 - успех'

        question_id = response.json()['id']
        
        # создание ответа на вопрос 

        response = requests.post(QUESTION_URL + f'/{question_id}' + '/answers', json=generate_answer())
        answer_id = response.json()['id']
        assert response.status_code == 200, 'Не удалось создать ответ на вопрос на сервере, ожидался статус ответа 200 - успех'

        # удаление вопроса с сервера
        response = requests.delete(QUESTION_URL + f'/{question_id}' + '/answers' + f'/{answer_id}')
        assert response.status_code == 202, 'Не удалось удалить ответ на вопрос на сервере, ожидался статус ответа 202 - принят на обработку'



    """ Тестирование PUT запросов """
    @staticmethod
    def test_put_answer_200_ok():

        # создание викторины
        response = requests.post(QUIZ_URL, json=generate_quiz())
        quiz_id = response.json()['id']
        assert response.status_code == 200, 'Не удалось создать викторину на сервере, ожидался ответс со статусом 200 - успех'

        # создание вопроса
        response = requests.post(QUIZ_URL + f'/{quiz_id}' + '/questions', json=generate_question())
        assert response.status_code == 200, 'Не удалось создать вопрос на сервере, ожидался ответс со статусом 200 - успех'

        question_id = response.json()['id']
        
        # создание ответа на вопрос 
        response = requests.post(QUESTION_URL + f'/{question_id}' + '/answers', json=generate_answer())
        answer_id = response.json()['id']
        assert response.status_code == 200, 'Не удалось создать ответ на вопрос на сервере, ожидался статус ответа 200 - успех'

        # удаление вопроса с сервера
        new_answer = { k: v + '_' for k, v in generate_answer().items() if k != 'isCorrect'}
        response = requests.put(QUESTION_URL + f'/{question_id}' + '/answers' + f'/{answer_id}', json=new_answer)
        assert response.status_code == 200, 'Не удалось обновить ответ на вопрос на сервере, ожидался статус ответа 202 - принят на обработку'



    
if __name__ == '__main__':
    # запуск тестов
    TestAnswers.test_get_answer_200_ok()
    TestAnswers.test_post_answer_200_ok()
    TestAnswers.test_delete_answer_200_ok()
    TestAnswers.test_put_answer_200_ok()
    print('Тесты пройдены')