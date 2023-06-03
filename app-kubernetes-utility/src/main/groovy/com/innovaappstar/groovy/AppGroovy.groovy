package com.innovaappstar.groovy

public class AppGroovy {

    static String main(String message){
        def pwdCommand = "pwd".execute().text
        def lsCommand = "ls -l".execute().text
        return "hola " + message
    }
}
