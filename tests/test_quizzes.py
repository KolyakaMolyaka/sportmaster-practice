import requests
from utils import generate_quiz


PORT = 8080
URL = f'http://127.0.0.1:{PORT}/quizzes'


class TestQuizzes:

    """ Тестирование GET запросов """
    @staticmethod
    def test_get_quizzes_200_ok():
        response = requests.get(URL)
        if response.status_code == 200:
            assert len(response.json()) > 0, 'Не возвращен массив викторин при статусе ответа 200, ожидался массив викторин'

    @staticmethod
    def test_get_quizzes_404_not_found():
        response = requests.get(URL)
        if response.status_code == 404:
            try: 
                # так как статус говорит об отсутствии викторин
                # должно быть возбуждено исключение
                response.json()
            except:
                # если исключение было возбуждено, то
                # блок else не будет отработан
                # тест считается пройденным
                pass
            else:
                raise 'Возвращен JSON при статусе ответа 404, ожидалось отсутствие тела ответа'
   
    """ Тестирование POST запросов """

    @staticmethod
    def test_post_quizz_200_ok():
        response = requests.post(URL, json=generate_quiz())
        assert response.status_code == 200, 'Создание викторины должно возвращать статус 200, ожидался статус 200'

    @staticmethod
    def test_post_quizz_new_quiz_created_successfully():
        response = requests.post(URL, json=generate_quiz())
        new_quiz = response.json()

        assert new_quiz.get('id') is not None, 'У созданной викторины нет поля ID, ожидалось присутсвие поля ID'
        assert new_quiz.get('title') is not None, 'У созданной викторины нет поля title, ожидалось присутсвие поля title'
        assert new_quiz.get('description') is not None, 'У созданной викторины нет поля description, ожидалось присутсвие поля description'
        assert new_quiz.get('category') is not None, 'У созданной викторины нет поля category, ожидалось присутсвие поля category'
        assert new_quiz.get('created_at') is not None, 'У созданной викторины нет поля created_at, ожидалось присутсвие поля created_at'

    """ Тестирование DELETE запросов """

    @staticmethod
    def test_delete_quiz_200_ok():
        # создание викторины
        new_quiz_response = requests.post(URL, json=generate_quiz())
        assert new_quiz_response.status_code == 200, 'Не удалось создать викторину, ожидался код ответа 200'
        new_quiz = new_quiz_response.json()

        # удаление викторины
        response = requests.delete(URL + f'/{new_quiz["id"]}')
        assert response.status_code == 200, 'Успешное удаление возвращает статус 200, ожидался статус 200'

    @staticmethod
    def test_delete_quiz_404_not_found():
        # удаление несуществующей викторины
        # т.к. id - неотрицательное число, 
        # то удаление викторины с id < 0 должно вернуть 404 статус
        invalid_id = -1

        response = requests.delete(URL + f'/{invalid_id}')
        assert response.status_code == 404, 'Удаление несуществующей викторины должно вернуть статус 404, ожидался статус ответа 404'

    """Тестирование PUT запросов """

    @staticmethod
    def test_put_quiz_404_not_found():
        invalid_id = -1
        response = requests.put(URL + f'/{invalid_id}', json=generate_quiz())
        assert response.status_code == 404, 'Обновление несуществующей викторины должно вернуть статус 404, ожидался статус ответа 404'

    @staticmethod
    def test_put_quiz_200_ok():
        prev_quiz = generate_quiz() # создание викторины
        prev_quiz_response = requests.post(URL, json=prev_quiz) # отправка викторины на сервер
        assert prev_quiz_response.status_code == 200, 'Не удалось добавить викторину, ожидался статус ответа 200'
        prev_quiz = prev_quiz_response.json() # сервер возвращает более подробную инфомрацию о новой викторине (например: id, created_at)

        new_quiz_response = requests.put(URL + f'/{prev_quiz["id"]}', json=prev_quiz)
        assert new_quiz_response.status_code == 200, 'Не удалось обновить викторину, ожидался статус ответа 200'
    
    @staticmethod
    def test_put_quiz_successfully_updated():
        prev_quiz = generate_quiz() # создание викторины
        prev_quiz_response = requests.post(URL, json=prev_quiz) # отправка викторины на сервер
        assert prev_quiz_response.status_code == 200, 'Не удалось добавить викторину, ожидался статус ответа 200'
        prev_quiz = prev_quiz_response.json() # сервер возвращает более подробную инфомрацию о новой викторине (например: id, created_at)

        new_quiz = {k: str(v) + '_' for k,v in generate_quiz().items()} # создание новой викторины с постфиксом '_'

        new_quiz_response = requests.put(URL + f'/{prev_quiz["id"]}', json=new_quiz) # обновление викторины
        updated_quiz = new_quiz_response.json() # получение новой обновленной викторины для сравнения

        assert new_quiz_response.status_code == 200, 'Не удалось обновить викторину, ожидался статус ответа 200'

        assert prev_quiz['id'] == updated_quiz['id'], 'Обновленная викторина имеет id отличный от ранее загруженной, ожидалось совпадение полей id созданной и обновленной викторин'
        assert new_quiz['title'] == updated_quiz['title'], 'Не было изменено свойство title, ожидалось обновление свойства title у викторины'
        assert new_quiz['description'] == updated_quiz['description'], 'Не было изменено свойство description, ожидалось обновление свойства description у викторины'
        assert new_quiz['category'] == updated_quiz['category'], 'Не было изменено свойство category, ожидалось обновление свойства category у викторины'
        assert new_quiz['difficulty'] == updated_quiz['difficulty'], 'Не было изменено свойство difficulty, ожидалось обновление свойства difficulty у викторины'
        assert prev_quiz['created_at'] == updated_quiz['created_at'], 'Было изменено свойсво created_at, ожидалось, что обновленная викторина будет иметь постоянную дату создания (т.е. ее нельзя обновить)'
 
            
    """ Полезные фунции для тестирования """

    
if __name__ == '__main__':
    # запуск тестов
    TestQuizzes.test_get_quizzes_200_ok()
    TestQuizzes.test_get_quizzes_404_not_found()
    TestQuizzes.test_post_quizz_200_ok()
    TestQuizzes.test_post_quizz_new_quiz_created_successfully()
    TestQuizzes.test_delete_quiz_200_ok()
    TestQuizzes.test_delete_quiz_404_not_found()
    TestQuizzes.test_put_quiz_404_not_found()
    TestQuizzes.test_put_quiz_200_ok()
    TestQuizzes.test_put_quiz_successfully_updated()
    print('Тесты пройдены')