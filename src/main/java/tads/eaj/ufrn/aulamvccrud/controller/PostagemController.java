package tads.eaj.ufrn.aulamvccrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tads.eaj.ufrn.aulamvccrud.model.Postagem;
import tads.eaj.ufrn.aulamvccrud.service.PostagemService;

import java.util.List;

@Controller
public class PostagemController {

    PostagemService service;

    public PostagemController(PostagemService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Postagem p = new Postagem(0, "teste", "teste", "teste", "teste");
        service.save(p);

        List<Postagem> postagemList = service.findAll();
        model.addAttribute("postagemList", postagemList);

        return "index.html";
    }
}



