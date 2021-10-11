package com.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("")
    public String showHomePage(){
    	System.out.println("main controller");
        return "index";
    }

}
//Este controlador e responsavel por renderizar view index.
/*
 O funcionamento consiste em cirar esta class IndexController com o anotation @Controller que vai importar o Controller da boblioteca do spring boot
 Colocando o anotation @GerMapping uma biblioteca do spring que vai mapear rotas que é responsavel por definir as rotas.
 Depois contrua um metodo do tipo String com seu nome que vai retornar uma view Index que esta localizada em resources templates.
*/