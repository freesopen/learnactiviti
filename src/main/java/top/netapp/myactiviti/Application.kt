package top.netapp.myactiviti

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [ org.activiti.spring.boot.SecurityAutoConfiguration::class
//    ,org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration::class
])
//@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
