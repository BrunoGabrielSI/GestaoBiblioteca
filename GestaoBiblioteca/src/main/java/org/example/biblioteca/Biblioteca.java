package org.example.biblioteca;

import org.example.model.Livro;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public List<Livro> buscarLivroPorTitulo(String titulo){
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }

    public List<Livro> listarLivrosPorAno(){
        return livros.stream()
                .sorted(Comparator.comparingInt(Livro::getAnoPublicacao))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> contarLivrosPorAutor(){
        Map<String, Integer> contagemPorAutor = new HashMap<>();

        for (Livro livro : livros){
            contagemPorAutor.put(livro.getAutor(),
                    contagemPorAutor.getOrDefault(livro.getAutor(),
                            0)+1);
        }
        return contagemPorAutor;
    }

    public Set<Livro> listarLivrosUnicos(){
        return new HashSet<>(livros);
    }
}
