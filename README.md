## Framework Test UI Web Menggunakan Java, Cucumber, Selenium, dan Gradle

### Tujuan Project
Tujuan dari project ini adalah melakukan pengujian user interface berdasarkan user behaviour dengan berbagai skenario meliputi positive, negative, dan boundary test pada web https://www.saucedemo.com.

### Persiapan dan Konfigurasi Project
Berikut adalah langkah yang dilakukan dalam menyiapkan project,
1. Install Java Development Kit (JDK) dan pastikan JDK terbaru sudah terpasang di sistem.
2. Install Gradle pada sistem. Pada project ini menggunakan Gradle Wrapper.
3. Buat proyek Gradle baru untuk proyek testing UI web. Hal ini dapat dilakukan menggunakan perintah `gradle init` untuk membuat proyek Gradle baru.
4. Tambahkan dependensi Selenium WebDriver dan Cucumber ke file build.gradle. Pada project ini, dependensi yang digunakan adalah sebagai berikut:
```
dependencies {
    implementation 'org.seleniumhq.selenium:selenium-java:4.9.0'
    implementation 'io.github.bonigarcia:webdrivermanager:5.3.2'

    implementation 'io.cucumber:cucumber-java:7.11.2'
    testImplementation 'io.cucumber:cucumber-junit:7.11.2'

    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
}
```
5. Buat file *.feature yang berisi skenario pengujian. 
6. Buat direktori "stepdef" untuk menampung file step definition yang sesuai dengan setiap skenario dalam file *.feature.
7. Implementasikan page object model untuk memisahkan kode pengujian dari kode UI yang memungkinkan pengujian menjadi lebih mudah dan teratur. Dalam POM, setiap halaman di situs web diwakili oleh sebuah objek yang terdiri dari elemen UI dan metode-metode yang menjalankan action pada elemen-elemen tersebut.
8. Buat cucumber task pada file build.gradle, contohnya dapat dilihat sebagai berikut:
```
def tags = (findProperty('tags') == null) ? 'not @exclude' : findProperty('tags') + ' and not @exclude'

task cucumber() {
    description("Running Cucumber Test")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/index.html',
                    '--plugin', 'pretty',
                    '--glue', 'com.fajarb',
                    '--tags', "${tags}",
                    'src/test/resources'
            ]
        }
    }
}
```
9. Jalankan test.

### Cara Menjalankan Pengujian
Akses pada terminal lalu jalankan perintah berikut,
```zsh
./gradlew cucumber
```