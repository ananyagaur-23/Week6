package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet() {
        return """
               <html>
               <head>
                   <title>Greeting</title>
                   <style>
                       body {
                           display: flex;
                           justify-content: center;
                           align-items: center;
                           height: 100vh;
                           background-color: #f79c9c#4a2d66;
                           font-family: Arial, sans-serif;
                       }
                       h1 {
                           color: #4a2d66;
                           font-size: 5.5em;
                           text-align: center;
                       }
                   </style>
               </head>
               <body>
                   <h1>Greetings Visitor, how are you doing today?</h1>
               </body>
               </html>
               """;
    }
}
