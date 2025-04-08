package br.pucrs.stefanodpcarraro.starter;

import org.springframework.web.bind.annotation.RestController;
import br.pucrs.stefanodpcarraro.starter.Livro;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/biblioteca")
public class ControllerExemplo {

    public List<Livro> livros;

    public ControllerExemplo(){
        livros = new ArrayList<Livro>();
        livros.add(new Livro(1, "Magico de OZ", "Frank Baun", 2012));
        livros.add(new Livro(2, "Harry Potter", "JK Rowling", 1998));
        livros.add(new Livro(3, "Percy Jackson", "Rick Riordan", 2008));
    }

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return livros;
    }

    @GetMapping("/titulos")
    public List<String> getTitulos(){
        List<String> titulos = new ArrayList<String>();
        for(Livro liv : livros){
            titulos.add(liv.getTitle());
        }
        return titulos;
    }

    @GetMapping("/autores")
    public List<String> getAutores(){
        List<String> autores = new ArrayList<String>();
        for(Livro liv : livros){
            autores.add(liv.getAuthor());
        }
        return autores;
    }
}