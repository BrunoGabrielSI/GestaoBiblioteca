package org.example.main;


import org.example.biblioteca.Biblioteca;
import org.example.model.Livro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Livro livro1 = new Livro("Dom Quixote", "Miguel de Cervantes", 1612);
        Livro livro2 = new Livro("Um Conto de Duas Cidades", "Charles Dickens", 1859);
        Livro livro3 = new Livro("O Senhor dos Anéis", "J. R. R. Tolkien", 1954);
        Livro livro4 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
        Livro livro5 = new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowling", 1997);

        // Livros adicionads na biblioteca
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);


        // Pesquisa por titulo
        String tituloForncecido = scanner.nextLine();
        List<Livro> resultado = biblioteca.buscarLivroPorTitulo(tituloForncecido);

        resultado.forEach(livro ->
                System.out.println(String.format("Titulo: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                        livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));


    }
}