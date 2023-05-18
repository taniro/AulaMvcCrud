package tads.eaj.ufrn.aulamvccrud.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.aulamvccrud.model.Postagem;
import tads.eaj.ufrn.aulamvccrud.service.PostagemService;

import java.util.List;
import java.util.Optional;

@Controller
public class PostagemController {

    PostagemService service;

    public PostagemController(PostagemService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String getIndex(Model model){

        List<Postagem> postagemList = service.findAll();
        model.addAttribute("postagemList", postagemList);
        model.addAttribute("estiloUser", "estilos.css");
        return "index.html";
    }

    @GetMapping("/cadastrarPage")
    public String getCadastrarPage(Model model){
        Postagem p = new Postagem();
        model.addAttribute("postagem", p);
        return "cadastrarPage";
    }

    @PostMapping("/doSalvar")
    public String doSalvar(@ModelAttribute @Valid Postagem p, Errors errors){
        if (errors.hasErrors()){
            return "cadastrarPage";
        }else{
            service.save(p);
            return "redirect:/index";
        }
    }
    @GetMapping("/editarPage/{id}")
    public String getEditarPage(@PathVariable(name = "id") String id, Model model){

        Optional<Postagem> p = service.findById(id);
        if (p.isPresent()){
            model.addAttribute("postagem", p.get());
        }else{
            return "redirect:/index";
        }

        return "editarPage";
    }

    @GetMapping("/deletar/{id}")
    public String doDeletar(@PathVariable(name = "id") String id){
        Optional<Postagem> postagem = service.findById(id);
        if (postagem.isPresent()) {
            service.delete(id);
        }
        return "redirect:/index";
    }
}



