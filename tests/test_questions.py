import requests
from utils import generate_quiz, generate_question


PORT = 8080
URL = f'http://127.0.0.1:{PORT}/quizzes'
QUESTIONS_URL = f'http://127.0.0.1:{PORT}/questions'

class TestQuestions:

    """ Вспомогательные функции """
    @staticmethod
    def send_quiz_to_the_server() -> dict:
        # отправка новой викторины на сервер
        sent_quiz_response = requests.post(URL, json=generate_quiz())
        assert sent_quiz_response.status_code == 200, 'Не удалось отправить викторину на сервер, ожидался статус ответа 200'
        sent_quiz = sent_quiz_response.json()
        return sent_quiz

    """ Тестирование GET запросов """

    @staticmethod
    def test_get_questions_404_not_found():
        sent_quiz = TestQuestions.send_quiz_to_the_server()
        # получение вопросов у викторины
        response = requests.get(URL + f'/{sent_quiz["id"]}' + '/questions')
        # print(response.status_code, response.json())
        assert response.status_code == 404, 'Викторина имеет вопросы, ожидался статус 404 - вопросов не найдено'

    @staticmethod
    def test_get_questions_200_ok():
        # отправка новой викторины на сервер
        sent_quiz = TestQuestions.send_quiz_to_the_server()

        # отправка вопроса, привязанного к викторине на сервер
        response = requests.post(URL + f'/{sent_quiz["id"]}' + '/questions', json=generate_question())
        assert response.status_code == 200, 'Вопрос не был загружен на сервер, ожидался статуст ответа 200'

        # получение вопроса с сервера
        response = requests.get(URL + f'/{sent_quiz["id"]}' + '/questions')
        assert response.status_code == 200, 'Статус ответа получения вопроса у викторины должен быть 200, ожидался статус ответа 200'

    """ Тестирование POST запросов"""

    @staticmethod 
    def test_post_question_200_ok():
        # отправка новой викторины на сервер
        sent_quiz = TestQuestions.send_quiz_to_the_server()

        # отправка вопроса, привязанного к викторине на сервер
        response = requests.post(URL + f'/{sent_quiz["id"]}' + '/questions', json=generate_question())
        assert response.status_code == 200, 'Вопрос не был загружен на сервер, ожидался статуст ответа 200'
    
    @staticmethod
    def test_post_question_created_successfully():
        # отправка новой викторины на сервер
        sent_quiz = TestQuestions.send_quiz_to_the_server()

        # отправка вопроса, привязанного к викторине на сервер
        created_question = requests.post(URL + f'/{sent_quiz["id"]}' + '/questions', json=generate_question()).json()
        
        assert 'id' in created_question, 'Отсутствует поле id у созданного вопроса, ожидалось присутствие поля id'
        assert 'text' in created_question, 'Отсутствует поле text у созданного вопроса, ожидалось присутствие поля text'
        assert 'answers' in created_question, 'Отсутствует поле answers у созданного вопроса, ожидалось присутствие поля answers'

    """ Тестирование PUT запросов """

    @staticmethod
    def test_put_question_200_ok():
        # отправка новой викторины на сервер
        sent_quiz = TestQuestions.send_quiz_to_the_server()

        # отправка вопроса, привязанного к викторине на сервер
        created_question = requests.post(URL + f'/{sent_quiz["id"]}' + '/questions', json=generate_question()).json()

        # обновление ранее созданного вопроса
        response = requests.put(QUESTIONS_URL + f'/{created_question["id"]}', json=generate_question())
        assert response.status_code == 200, 'Не удалось обновить существующий вопрос, ожидался статус ответа 200'

    @staticmethod
    def test_put_question_404_not_found():
        # отправка новой викторины на сервер
        sent_quiz = TestQuestions.send_quiz_to_the_server()

        # отправка запроса на обновление несуществующего вопроса
        invalid_question_id = -1
        response = requests.put(QUESTIONS_URL + f'/{invalid_question_id}', json=generate_question())
        assert response.status_code == 404, 'Ожидалось отсутствие вопросов у викторины, требуется статус 404 - не найдено'
    

    """ Тестирование DELETE запросов """

    @staticmethod
    def test_delete_question_404_not_found():
        # отправка новой викторины на сервер
        sent_quiz = TestQuestions.send_quiz_to_the_server()

        # отправка запроса на обновление несуществующего вопроса
        invalid_question_id = -1
        response = requests.delete(QUESTIONS_URL + f'/{invalid_question_id}', json=generate_question())
        assert response.status_code == 404, 'Удаление несуществующего вопроса должно возвращать статус 404, ожидался статус 404 - вопрос не найден'

    @staticmethod
    def test_delete_question_200_ok():
        # отправка нового вопроса на сервер
        sent_quiz = TestQuestions.send_quiz_to_the_server()
        sent_question = requests.post(URL + f'/{sent_quiz["id"]}' + '/questions', json=generate_question()).json()

        response = requests.delete(QUESTIONS_URL + f'/{sent_question["id"]}')
        assert response.status_code == 200, 'Вопрос не был удален, ожидался статус 200 - вопрос удален'


if __name__ == '__main__':
    TestQuestions.test_get_questions_404_not_found()
    TestQuestions.test_get_questions_200_ok()
    TestQuestions.test_post_question_200_ok()
    TestQuestions.test_post_question_created_successfully()
    TestQuestions.test_put_question_200_ok()
    TestQuestions.test_put_question_404_not_found()
    TestQuestions.test_delete_question_404_not_found()
    TestQuestions.test_delete_question_200_ok()
    print('Тесты пройдены')