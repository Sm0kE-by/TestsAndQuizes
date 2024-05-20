Необходимо исправить:
1. Category_item_fragment - русский текст налазит друг на друга
2. CategoryDbEntity - не используется пока!!!
3. addSubcategories() в SubcategoriesFragmentViewModel добавить статистику и категорию(из ресурсов)
4. Я подключил БД, но надо разобраться как сделать так чтоб при обновлении БД статистика сохранялась
5. Лучший результат - добавить знак процентов
6. Довешать проверок на методы!!!
7. УБРАТЬ ВСЕ НЕИСПОЛЬЗОВАННЫЕ ЗАВИСИМОСТИ ВО ВСЕХ КЛАССАХ!!!
8. Проверить перезапись и автообновление LiveData
9. Раскинуть проверки иф/элс
10. РАСКИДАТЬ ПРАВИЛЬНО ВСЕ ФУНКЦИИ ПО ЖИЗНЕНЫМ ЦИКЛАМ АКТИВИТИ И ФРАГМЕНТОВ!!!!!!!!!!!!!!!!!!!
11. statistic_subcategory используется NAME_SUBCATEGORY -> надо изменить на ID!!!!!!
12. DifficultyFragmentViewModel - заменить инициализацию и разобраться с viewModelScope.launch(Dispatchers.IO)!!!!!!!!!!!!!!!!
13. Обернуть в LiveDate данные из TestFragmentViewModel!!!!!!!!!!!!!
14. androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") - в data слое можно удалить
15. <manifest package="com.BySandS.data"/> в data слое добавил вручную, а должно было само создать, оставлять или нет
16. !!!!!    @Update
        fun saveStatistic(statisticModel: StatisticsDbEntity): Boolean
        Нельзя вернуть Boolean, только ИНТ, сделать проверку через ИНТ!!!!
17. data Class StatisticModel - переменные типа VAR!!!!!!!!!!!!
18. Переходы между фрагментами: Bundle передает объект который находиться в Object - НАДО ПЕРЕНЕСТИ В KOIN!!!!
19. Модель subcategory в АПП использует не все переменные, возможно надо сделать отдельную модельку

20. <---=== DATABASE UPDATE ===--->
 - добавить в сабкатегории статистику хардкор режима
 - исправить название стобца -> difficulti_lexel_id
 - добавить в таблицу количество вопросов столбец для хардкор режима
quantity_of_questions_id -> quantity_of_questions

 <---=== DATABASE CLOSE ===--->

 21. SubcategoryModel в Difficulty fragment используется не все поля, возможно надо сделать отдельную модель
 22. SubcategoryModel слежу за двумя объектами, возможно их надо объединить в медиатор
 23. В ресурсах возможно можно поменять строки со вставкой данных через %s
 24. GetHintDialogFragment - заменить SimpleDateFormat - на DataTime

 25. allDate UseCase -> else заполнить обработку ошибки!
 26. Загрузка аватарок в RCV надо чтоб грузило не весь список!
