document.getElementById('login-form').addEventListener('submit', function(e) {
    e.preventDefault(); // Предотвращаем отправку формы

    // Получаем значения полей ввода
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Проверяем правильность введенных данных
    if (username === "admin" && password === "password") {
        // Если данные верны, перенаправляем пользователя на другую страницу
        window.location.href = "welcome.html";
    } else {
        // Если данные неверны, выводим сообщение об ошибке
        document.getElementById('error-message').textContent = "Неверное имя пользователя или пароль.";
    }
});