![Screenshot_11](https://user-images.githubusercontent.com/100701583/209477400-cfb93d16-ce3b-4601-a0ba-8426c7d0c166.png)

Merhaba öncelikle başvurumu değerlendirmeye aldığınız için çok teşekkür ederim...

Projeyi mailinizden yaklaşık 10 gün sonra gönderiyorum. Benim için çok şey öğrendiğim
uzun uzun calıstığım güzel bir süreçti. Değerlendirme ve sürecin sonu ne olur bilemem 
ama bu proje bana çok şey kattı. 

Docker ile dockerhub yüklemesinde çözemediğim bir sorun yaşadım.Gerçekten bayaa uğraştım 
ama çözemedim. Bu yüzden size docker ile calısırken videosunu çektim. Dockerfile ve
docker-compose dosyalarını da projeye ekledim. Bununla birlikte uygulamanın bütün özelliklerini 
de göstermiş oldum. Calısırken bilgi aldığım kaynakları en alta ekleyeceğim. 

Projenin kullanım videosu :  

https://www.youtube.com/watch?v=XFMJixp9fjo&feature=youtu.be

Proje detaylarına geçersek...

-React 

-Maven

-Spring Boot

-JPA 

-Docker

-Bootstrap 4 

-PostgreSQL 

-Swagger 

Teknolojilerini kullandım. 

Spring Boot : 8888 portuna ayarlı

React : 3000 portuna ayarlı 

PostgreSQL : 5432 portuna ayarlı 


Projeyi çalıştırmak için PG admin ile application.properties içindeki database ismini kullanarak
database oluşturun. Spring boot uygulamasını intellij idea ile calıştırın. React kısmını vscode içinde
önce "npm i" sonra "npm start" komutlarını terminale girerek çalıştırın kullanıma hazır olacaksınız. 
"http://localhost:3000/" bu linke tarayıcınızdan girdiğiniz zaman ana ekranı göreceksiniz.

!! Bilgisayarınızdaki postgres kullanıcı adı ve şifresini projeye eklemeyi unutmayın lütfen.

Teknik seçimlerim ve gerekçelerim:
Teknik bir dökümantasyon ve postman'e gerek kalmadan test edebilmek adına swagger ile dökümantasyon
oluşturdum aşadığıdaki linkten erişebilirsiniz. 

http://localhost:8888/swagger-ui/index.html 


Öncelikle başlangıçta spring-boot 3 ile geliştirmeye başladım ama swagger ve modelmapper uyumluluk sorunu
oluşturuğu için spring 2.7.x sürümüne geçtim. 

Rapor ve laborant tutmak için DTO-ENTITY arasında ModelMapper kullandım bu sayede her entity ile ilgili 
açmak istemediğim değişken olursa buna ulaşıma engel olmuş oldum. 
Bu projede spesifik olarak kapalı kalan bir şey yok. Ama geliştirmeye açık olması için bunu bu şekilde
tercih ettim. ModelMapper ne derseniz dto ile gelen veriyi entitymiş gibi ceviriyor bunu yaparken entity 
içinde bulunan her şeyi sizden beklemiyor sizin verdiğiniz kadarıyla bir nesne oluşturuyor. 

Date verisini sistem saatinden otomatik olarak çekiyorum ama gerekli görünürse diye update kısmından
düzenleme yapılabilir şekilde calışıyor.

Raporların photo verisini url olarak tutmak istedim bu şekilde başka bir depolama kaynağından url alarak 
kolayca eklenebiliyor. 

Bu aşamadan sonra her raporun laborantı ve her laborantın raporu olduğu için nesne oluştururken sonsuz bir
döngü oluşuyordu. Bunun önüne geçmek için dto içinde laborant yerine laborantid tuttum ve rapor oluştururken
report service içinde gelen dtodaki laborantid ile laborantreporsitoryden sorgulama yapıp uygun laborantı 
bulup bunu eklemesini istedim. Bu sayede bu döngüyü kırmış oldum. Aslında bunu laborantHospitalNumber ile 
yapmayı düşündüm ama modelmapper bu isimlendirmeyle calışmadığı için id ile çözdüm. 

React kısmındaki Laborant görme menüsünden istediğiniz laborantın id ile rapor oluşturursanız otomatikmen 
o kişinin raporlarına ekleniyor. Bunun için gerekli sql bağlantılarını entity classları içinde bulabilirsiniz.

Arayüzü React ve Bootstrap 4 kullanarak yaptım. Örnek fotoğrafları ekliyorum: 
![Screenshot_5](https://user-images.githubusercontent.com/100701583/209467854-7ae82d5d-562f-46fe-9ba9-e9c7d380d981.png)

![Screenshot_6](https://user-images.githubusercontent.com/100701583/209467856-ea68ff9e-f0af-46fc-9b5c-904f0987eccd.png)

![Screenshot_7](https://user-images.githubusercontent.com/100701583/209467857-0f06fe71-a3a6-4d03-8984-73cb39b1bce9.png)

![Screenshot_8](https://user-images.githubusercontent.com/100701583/209467866-f8c66418-668a-4a7a-a1d8-b31cd0896b80.png)

![Screenshot_9](https://user-images.githubusercontent.com/100701583/209467867-1ffe6763-197d-4ad5-9036-2283edd4f8b3.png)

![Screenshot_10](https://user-images.githubusercontent.com/100701583/209467868-b52a3cf5-bde6-4576-a014-59f259008f03.png)



Unit testleri ekledim. Doğru calıştığını gördüm gerekli fotoğrafları ekliyorum:

![Screenshot_1](https://user-images.githubusercontent.com/100701583/209467625-87758d85-efb3-4671-98d1-8c79d66fa914.png)

![Screenshot_2](https://user-images.githubusercontent.com/100701583/209467627-4ee65197-d02b-48c5-b81d-045c4b389fc0.png)

![Screenshot_3](https://user-images.githubusercontent.com/100701583/209467628-aef20b3c-f876-4586-b79e-b2b740ec40cc.png)

![Screenshot_4](https://user-images.githubusercontent.com/100701583/209467629-78890e5b-4833-43ca-bd3b-01c0380819ec.png)


Kullandığım kaynaklar...

https://www.youtube.com/watch?v=hglfkhhBI14

https://www.youtube.com/watch?v=g5oI0sIUmB0

https://www.youtube.com/watch?v=6CrpncmMivM

https://www.youtube.com/watch?v=zBcqyUBOXr4&t=629s

https://www.youtube.com/watch?v=XkVpb_8IPUM&t=10862s

https://www.youtube.com/watch?v=GLmxlpMGA90&t=4660s

https://www.baeldung.com/spring-boot-thymeleaf-image-upload

https://stackoverflow.com/search?q=bidirectional+relationship+spring+boot+one+to+many

https://stackoverflow.com/questions/53019285/how-to-set-parentid-in-child-entity-of-one-to-many-mapping-using-spring-boot-dat

https://spring.io/blog/2021/09/22/spring-data-jdbc-how-do-i-make-bidirectional-relationships

https://www.baeldung.com/spring-boot-formatting-json-dates

Ve cok sayıda stackoverflow sayfası... 



Buraya kadar okuduğunuz için çok teşekkür ederim...

~Mustafa KARACUKUR
