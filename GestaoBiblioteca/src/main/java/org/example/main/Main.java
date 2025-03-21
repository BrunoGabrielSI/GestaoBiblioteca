package org.example.main;

import org.example.biblioteca.Biblioteca;
import org.example.model.Livro;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Livro livro1 = new Livro("Exemplo_nome1", "Bruno Gabriel", 2004);
        Livro livro2 = new Livro("Exemplo_nome2", "Bruno Rodrigues", 2003);
        Livro livro3 = new Livro("Exemplo_nome3", "Bruno Souza", 2002);
        Livro livro4 = new Livro("Exemplo_nome4", "Bruno Cesar", 2001);
        Livro livro5 = new Livro("Exemplo_nome5", "Bruno Dantas", 2000);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    pesquisarLivroPorTitulo(scanner, biblioteca);
                    break;
                case 2:
                    listarLivrosPorAno(biblioteca);
                    break;
                case 3:
                    contarLivrosPorAutor(biblioteca);
                    break;
                case 4:
                    listarLivrosUnicos(biblioteca);
                    break;
                case 5:
                    listarLivrosAntesDeAno(scanner, biblioteca);
                    break;
                case 0:
                    System.out.println("Saindo... Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n--- Menu da Biblioteca ---");
        System.out.println("1. Pesquisar livro por título");
        System.out.println("2. Listar livros por ano de publicação");
        System.out.println("3. Contar livros por autor");
        System.out.println("4. Listar livros únicos");
        System.out.println("5. Listar livros publicados antes de um determinado ano");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void pesquisarLivroPorTitulo(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o título do livro: ");
        String tituloForncecido = scanner.nextLine();
        List<Livro> resultadoTitulo = biblioteca.buscarLivroPorTitulo(tituloForncecido);

        if (resultadoTitulo.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o título inserido.");
        } else {
            resultadoTitulo.forEach(livro -> System.out.println(
                    String.format("Título: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                            livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));
        }
    }

    private static void listarLivrosPorAno(Biblioteca biblioteca) {
        List<Livro> resultadoAno = biblioteca.listarLivrosPorAno();
        resultadoAno.forEach(livro -> System.out.println(
                String.format("Título: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                        livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));
    }

    private static void contarLivrosPorAutor(Biblioteca biblioteca) {
        Map<String, Integer> contagemLivrosPorAutor = biblioteca.contarLivrosPorAutor();
        contagemLivrosPorAutor.forEach((autor, contagem) ->
                System.out.println("Autor: " + autor + " | N° de livros: " + contagem));
    }

    private static void listarLivrosUnicos(Biblioteca biblioteca) {
        Set<Livro> livrosUnicos = biblioteca.listarLivrosUnicos();
        livrosUnicos.forEach(livro -> System.out.println(
                String.format("Título: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                        livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));
    }

    private static void listarLivrosAntesDeAno(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite um ano para listar os livros publicados antes dele: ");
        int anoInformado = scanner.nextInt();
        List<Livro> livrosAntesDeAno = biblioteca.listarLivrosAntesDe(anoInformado);

        if (livrosAntesDeAno.isEmpty()) {
            System.out.println("Nenhum livro encontrado antes do ano " + anoInformado);
        } else {
            livrosAntesDeAno.forEach(livro -> System.out.println(
                    String.format("Título: \"%s\", Autor: \"%s\", Ano de publicação: \"%d\"",
                            livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao())));
        }
    }
}