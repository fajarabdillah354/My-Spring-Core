package my.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringApplication {

	//kita bisa menggunakan plugin untuk menjalankan SpringBootApplication melalui terminal dengan perintah mvn spring-boot:run

	//dengan syarat hanya boleh 1 main class saja, jika ada banyak maka akan error

	//ini hanya untuk mode development, jika di production kita harus buat distribuation filenya

	/** Distribution File
	 * SpringBoot plugin juga sudah menyediakan cara membuat distribution file aplikasi kita
	 * plugin ini akan mendeteksi main class di project kita, lalu membundle aplikasi kita berserta dependency yang dibutuhkan dalam 1 file jar
	 * pastikan hanya terdapat satu main class, karena jika lebih dari satu, maka SpringBoot plugin akan melakukan komplen
	 * kita cukup gunakan perintah Maven : mvn package
	 * secara otomatis akan terbuat single jar applicationc
	 * setelah itu pada target/ akan ada hasil jar filenya
	 * untuk mengakses jar filenya kita bisa menggunakan perintah java -jar target/<nameJarFile.jar
	 */


//	public static void main(String[] args) {
//		SpringApplication.run(MySpringApplication.class, args);
//	}

}
