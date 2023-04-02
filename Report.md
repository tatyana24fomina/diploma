К данному сервису написано 14 тест-кейсов, вкючая запросы в базу. 
85 процентов тестов прошли успешно. Два теста (15 процентов от общего количества) упали:
TravelServiceTest. shouldBuyingATourInCreditWithDeclinedCard()
TravelServiceTest. shouldBuyingATourWithDeclinedCard(). 
По данной ошибке заведена бага. Ожидаем, что при использовании отклоненной карты, оплата отклонится, однако видим сообщение об успешной оплате.
![image](https://user-images.githubusercontent.com/83873443/227244942-6b1ce74e-51dd-4f36-ba48-a705c6956884.png)
