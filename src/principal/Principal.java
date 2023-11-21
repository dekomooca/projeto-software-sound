package principal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.AutorControle;
import controller.CategoriaControle;
import controller.MusicaControle;
import model.Autor;
import model.Categoria;
import model.Musica;

public class Principal {
    static Connection connection;
    
    public static void main(String[] args) throws SQLException {
    	
    	System.out.println("Iniciando Software SOUND... \n");
    	AutorControle ac = new AutorControle();
    	CategoriaControle cc = new CategoriaControle();
    	MusicaControle mc = new MusicaControle();
    	System.out.println("Software SOUND iniciado com sucesso !\n");
    	
    	// ---------------
    	//CRIAÇÃO DOS AUTORES
    	// ---------------
    	System.out.println("Iniciando processo de Inserção de dados - INSERT \n");
    	System.out.println("Autor - Instanciando objetos. \n");
    	Autor autor1 = new Autor(1, "68574287008", "Lucas da Silva", "Luma Samba");
    	Autor autor2 = new Autor(2, "24674116058", "Isabela Costa Pereira", "DJ Raizes");
    	Autor autor3 = new Autor(3, "39216992077", "Thiago Santos Oliveira", "Brisa Tropical");
    	Autor autor4 = new Autor(4, "33245232063", " Camila Almeida Souza", "Lua Melodia");
    	Autor autor5 = new Autor(5, "53092819080", "Rafaela Pereira Lima", "Mare Alta");
        ac.createAutor(autor1);
        ac.createAutor(autor2);
        ac.createAutor(autor3);
        ac.createAutor(autor4);
        ac.createAutor(autor5);
        System.out.println("Autores criados no DB com sucesso ! \n");
        
        
        
    	// ---------------
        //CRIAÇÃO DAS CATEGORIAS
    	// ---------------
        System.out.println("Categoria - Instanciando objetos. \n");
        Categoria categoria1 = new Categoria(1, "Rock");
        Categoria categoria2 = new Categoria(2, "HipHop");
        Categoria categoria3 = new Categoria(3, "Samba");
        Categoria categoria4 = new Categoria(4, "Sertanejo");
        cc.createCategoria(categoria1);
        cc.createCategoria(categoria2);
        cc.createCategoria(categoria3);
        cc.createCategoria(categoria4);
        System.out.println("Categorias criadas no DB com sucesso ! \n");
        
        
        
    	// ---------------
        //CRIAÇÃO DAS MUSICAS
    	// ---------------
        System.out.println("Musica - Iniciando objetos. \n");
        Musica musica1 = new Musica(1, "Noite de Samba", "Na calada da noite, o samba ecoa pelos becos", 2, "03:45", LocalDate.of(2023, 07, 30));
        Musica musica2 = new Musica(2, "Aquarela Brasileira", "Pinceladas de cores na tela da vida brasileira", 1, "04:22", LocalDate.of(2022, 06, 15));
        Musica musica3 = new Musica(3, "Amor Tropical", "Sob o sol ardente, o amor floresce tropicalmente", 2, "03:30", LocalDate.of(2021, 05, 22));
        Musica musica4 = new Musica(4, "Cidade dos Sonhos", "Entre arranha-céus, os sonhos ganham vida", 4, "05:15", LocalDate.of(2023, 01, 10));
        Musica musica5 = new Musica(5, "Balada da Lua Cheia", "Sob o luar, corações dançam ao ritmo da paixão", 3, "04:10", LocalDate.of(2022, 02, 11));
        Musica musica6 = new Musica(6, "Ritmo da Floresta", "Entre árvores altas, a floresta canta seu ritmo", 3, "02:22", LocalDate.of(2021, 03, 14));
        Musica musica7 = new Musica(7, "Melodia Urbana", "O som da cidade, uma sinfonia urbana", 2, "03:07", LocalDate.of(2023, 04, 22));
        Musica musica8 = new Musica(8, "Serenata da Primavera", "Flores desabrocham ao som da serenata", 2, "04:02", LocalDate.of(2022, 05, 27));
        Musica musica9 = new Musica(9, "Batuque na Praia", "O batuque das ondas se mistura com a areia", 2, "03:44", LocalDate.of(2021, 06, 28));
        Musica musica10 = new Musica(10, "Valsa da Saudade", "Notas suaves que contam histórias de saudade", 3, "05:09", LocalDate.of(2023, 07, 29));
        mc.createMusica(1,musica1);
        mc.createMusica(2,musica2);
        mc.createMusica(3,musica3);
        mc.createMusica(4,musica4);
        mc.createMusica(5,musica5);
        mc.createMusica(6,musica6);
        mc.createMusica(7,musica7);
        mc.createMusica(8,musica8);
        mc.createMusica(9,musica9);
        mc.createMusica(10,musica10);
        System.out.println("Musicas criadas no DB com sucesso ! \n");

        
        // ---------------
    	//LISTANDO TODOS AUTORES, CATEGORIAS E MUSICAS
    	// ---------------
        System.out.println("------------------------------------------------------------------------------------------ \n");
        listarTodos(ac, cc, mc);
        
        // ---------------
    	//LISTANDO DADOS ESPECIFICOS DE AUTORES, CATEGORIAS E MUSICAS
    	// ---------------
        System.out.println("Iniciando processo de Busca de dados - SELECT \n");
        System.out.println("Listando dados especificos de um Autor : \n");
        String rock = "Rock";
        System.out.println("Listando qual autor canta o ritmo "  + rock + "... \n");
        Autor ritmo = ac.selectAutor(rock);
        System.out.println("-> O cantor " + ritmo.getNomeOriginal() + " canta o ritmo " + rock + " \n");
        
        System.out.println("---------------------------------------------------- \n");
        
        System.out.println("Listando dados especificos de uma Categoria : \n");
        String hiphop = "HipHop";
        System.out.println("Listando qual o id da categoria " + hiphop + " na tabela : \n");
        Categoria idCategoria = cc.selectCategoria(hiphop);
        System.out.println("-> O id da categoria " + hiphop + " é : " + idCategoria.getId() + " \n");
        
        System.out.println("---------------------------------------------------- \n");
        
        System.out.println("Listando dados especificos de uma Musica : \n");
        String samba = "Samba";
        System.out.println("Listando quais os titulos das musicas que tem na categoria " + samba + " : \n");
        ArrayList<Musica> todosmusicas = mc.selectMusica(samba);
        for (Musica musica : todosmusicas) {
        	System.out.println("-> Titulo da musica : " + musica.getTitulo() + " \n");
		}
        System.out.println("------------------------------------------------------------------------------------------");
        
        
        System.out.println("Iniciando processo de Atualização de dados - UPDATE \n");
        String name = "Rafaela Pereira Lima";
        String newName = "Rafa de Souza 123";
        System.out.println("Atualizando o nome artistico da Autora '" + name + "' para '" + newName + "' \n");
        ac.updateAutor(name, newName);
        
        String mpb = "Mpb";
        System.out.println("Atualizando o nome da Categoria '" + rock + "' para Categoria '" + mpb + "' \n");
        cc.updateCategoria(rock, mpb);
        
        String titulo = "Aquarela Brasileira";
        String novaLetra = "Andei demais até encontrar voce, vamos procurar a felicidade...";
        System.out.println("Atualizando a letra da musica '" + titulo + "' para '" + novaLetra + "' \n");
        mc.updateMusica(titulo, novaLetra);
        
        
        listarTodos(ac, cc, mc);
        
        System.out.println("------------------------------------------------------------------------------------------ \n");
        
        System.out.println("Iniciando processo de Remoção dos dados - DELETE \n");
        
        String cpfAutor = "33245232063";
        System.out.println("Deletando autor que apresenta o cpf '" + cpfAutor + "' \n");
        ac.deleteAutor(cpfAutor);
        
        System.out.println("Deletando musica de titulo: '" + titulo + "' \n");
        mc.deleteMusica(titulo);
        
        System.out.println("Deletando categoria '" + mpb + "' \n");
        cc.deleteCategoria(mpb);
        
        listarTodos(ac, cc, mc);
    }

	private static void listarTodos(AutorControle adao, CategoriaControle cdao, MusicaControle mdao) {
		System.out.println("Listando todos os Autores: \n");
        ArrayList<Autor> todosAutores = adao.selectAllAutores();
        
        for (Autor autor : todosAutores) {
        	System.out.println("Nome original: " + autor.getNomeOriginal() + " - Nome artistico : " + autor.getNomeArtistico());
        	System.out.println(autor.toString() + "\n");
		}
        System.out.println("------------------------------------------------------------------------------------------");
        
        System.out.println("\nListando todas as Categorias: \n");
        ArrayList<Categoria> todasCategorias = cdao.selectAllCategorias();
        for (Categoria ctg : todasCategorias) {
        	System.out.println(ctg.getNome());
        	System.out.println(ctg.toString() + "\n");
		}
        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\nListando todas as Musicas: \n");
        ArrayList<Musica> todasMusicas = mdao.selectAllMusicas();
        for (Musica ctg : todasMusicas) {
        	System.out.println("Musica: " + ctg.getTitulo());
        	System.out.println(ctg.toString() + "\n");
		}
        System.out.println("------------------------------------------------------------------------------------------");
		
	}
}
