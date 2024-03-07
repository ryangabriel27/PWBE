package webapp.newsletterjdbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.newsletterjdbc.connection.IndexDAO;

public class LoginController {
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");

        new IndexDAO().criaTabela(); // Cria a tabela no banco de dados
        String mensagem = "Olá, seja bem-vinda(o)!";
        mv.addObject("msg", mensagem);

        return mv;
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public ModelAndView enviarEmailBanco(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        ModelAndView mv = new ModelAndView("index");
        new IndexDAO().autenticar(email, senha);
        return mv;
    }

}
