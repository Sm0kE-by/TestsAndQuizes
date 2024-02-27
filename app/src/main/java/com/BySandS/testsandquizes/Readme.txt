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



