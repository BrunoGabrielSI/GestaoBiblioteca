package org.example.main;


import org.example.biblioteca.Biblioteca;
import org.example.model.Livro;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Livro livro1 = new Livro("Dom Quixote", "Miguel de Cervantes", 1612);
        Livro livro2 = new Livro("Um Conto de Duas Cidades", "Charles Dickens", 1859);
        Livro livro3 = new Livro("O Senhor dos Anéis", "J. R. R. Tolkien", 1954);
        Livro livro4 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
        Livro livro5 = new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowling", 1997);


        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);


        String tituloForncecido = scanner.nextLine();
        List<Livro> resultadoTitulo = biblioteca.buscarLivroPorTitulo(tituloForncecido);

        resultadoTitulo.forEach(livro ->
                System.out.println(String.format("Titulo: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                        livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));



        List<Livro> resultadoAno = biblioteca.listarLivrosPorAno();

        resultadoAno.forEach(livro ->
                System.out.println(String.format("Titulo: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                        livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));



        Map<String, Integer> contagemLivrosPorAutor = biblioteca.contarLivrosPorAutor();
        contagemLivrosPorAutor.forEach(
                (autor, contagem) ->
                        System.out.println("Autor: " + autor + " | N° de livros: " + contagem));


        Set<Livro> livrosUnicos = biblioteca.listarLivrosUnicos();
        livrosUnicos.forEach(livro ->
                System.out.println(String.format("Titulo: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                        livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));


        System.out.print("\nDigite um ano para listar os livros publicados antes dele: ");
        int anoInformado = scanner.nextInt();

        biblioteca.listarLivrosAntesDe(anoInformado)
                .forEach(livro -> System.out.println(
                        String.format("Título: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                                livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));

    }
}