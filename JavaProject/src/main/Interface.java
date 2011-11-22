package main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

import jp.co.csk.vdm.toolbox.VDM.CGException;
import jp.co.csk.vdm.toolbox.VDM.UTIL;

public class Interface {
	
	//TODO Arranjar a parte de adicionar automaticamente as citações (VDM)

	static Scanner in = new Scanner(System.in);
	static Indexer i;
	
	public static void main(String[] args) throws CGException {
		
		i = new Indexer();
		int op;
		
		
		do{
			System.out.println("\n\n\nScientific Paper Indexer\n\nOpções:");
			System.out.println("1 - Adicionar autor;");
			System.out.println("2 - Listar autores;");
			System.out.println("3 - Adicionar afiliações;");
			System.out.println("4 - Listar afiliações;");
			System.out.println("5 - Relacionar autor e afiliação;");
			System.out.println("6 - Adicionar publicação;");
			System.out.println("7 - Listar publicações;");
			System.out.print("\n0 - Sair\nOpção: ");
			op = in.nextInt();
			switch(op)  {
			
			case 1:
				addAuthor();
				break;
			case 2:
				listAuthors(true);
				break;
			case 3: 
				addAffiliation();
				break;
			case 4: 
				listAffiliations(true);
				break;
			case 5:
				relateAffiliationAuthor();
				break;
			case 6:
				addPublication();
				break;
			case 7: 
				listPublications(true);
				break;
		
				
			case 9:
				calcPathBetweenAuthors();
				break;
			default:
				break;
			
			}
			
			
		}while(op!=0);
		
	}

	@SuppressWarnings("unchecked")
	private static void calcPathBetweenAuthors() throws NumberFormatException, CGException {
		
		listAuthors(false);
		
		in = new Scanner(System.in);
		System.out.print("Indique os dois autores no formato autor1-autor2: ");
		
		
		String linha = in.nextLine();
		String[] temp2;
		String delimiter = ",";
		temp2 = linha.split(delimiter);
		
		Vector<Author> res = new Vector<Author>();
		res = i.pathBetween((Author)i.authors.keySet().toArray()[Integer.parseInt(temp2[0])-1], (Author)i.authors.keySet().toArray()[Integer.parseInt(temp2[1])-1]);
		
		for(Author a : (Author[])res.toArray())
			System.out.print(a.name);
	}

	private static void addPublication() throws CGException {
		
		in = new Scanner(System.in);
		System.out.print("Nome: ");
		String name = in.nextLine();
		System.out.print("Descrição: ");
		String des = in.nextLine();
		System.out.print("Data (dd-mm-aaaa): ");
		String data = in.nextLine();
		
		String[] temp;
		String delimiter = "-";
		temp = data.split(delimiter);
		
		Date d = new Date(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
		
		listPublications(false);
		
		in = new Scanner(System.in);
		System.out.print("Indique as referencias separadas por virgula e no formato publicacao-capitulo-linha: (0 para ignorar) ");
		
		
		String linha = in.nextLine();
		String[] temp2;
		delimiter = ",";
		temp2 = linha.split(delimiter);
		
		HashSet<Reference> refs = new HashSet<Reference>();
		for(String t : temp2)
		{
			if(t.equals("0"))
				break;
			String[] temp3;
			delimiter = "-";
			temp3 = t.split(delimiter);
			Reference r = new Reference(Integer.parseInt(temp3[1]), Integer.parseInt(temp3[2]), (Publication) i.publications.toArray()[Integer.parseInt(temp3[0])-1]);
			refs.add(r);
		}
		
		listAuthors(false);
		linha = in.nextLine();
		String[] temp4;
		delimiter = "-";
		temp4 = linha.split(delimiter);
		
		HashSet<Author> authors = new HashSet<Author>();
		for(String t : temp4)
		{
			authors.add((Author) i.authors.keySet().toArray()[Integer.parseInt(t)-1]);
		}
		
		listAffiliations(false);
		linha = in.nextLine();
		
		Publication p = new Publication(name, des, d, authors, (Affiliation) i.affiliations.toArray()[Integer.parseInt(linha)-1], refs);
		
		i.addPublication(p);
		
	}


	private static void listPublications(boolean total) {
		System.out.println("\nPublicações presentes no indexer: ");
		int z = 1;
		for( Object a : i.publications.toArray()) {
			if(total)
			{
				System.out.println("Nome: " + ((Publication)a).name);
				System.out.println("Descrição: " + ((Publication)a).description);
				
				System.out.println("Autores: ");
				for(Object author: ((Publication)a).authors)
				{
					System.out.println(((Author) author).name);
				}
				
				if(!((Publication)a).references.isEmpty()) 
					System.out.println("Referências (Capítulo | Linha | Publicação) : ");
				for(Object ref: ((Publication)a).references)
				{
					System.out.println(((Reference) ref).chapter + " | " + ((Reference) ref).line + " | " + ((Reference) ref).publication.name);
				}
				
				if(!((Publication)a).citations.isEmpty()) 
					System.out.println("Citações (Capítulo | Linha | Publicação) : ");
				for(Object ref: ((Publication)a).citations)
				{
					System.out.println(((Reference) ref).chapter + " | " + ((Reference) ref).line + " | " + ((Reference) ref).publication.name);
				}
				
			}
			else
				System.out.println(z+" - " + ((Publication)a).name);
			z++;
			
		}
		
	}


	private static void relateAffiliationAuthor() throws NumberFormatException, CGException {
	
		listAuthors(false);
		listAffiliations(false);
		in = new Scanner(System.in);
		System.out.print("Estabeleça a relação separando por - os ids: ");
		String linha = in.nextLine();
		String[] temp;
		String delimiter = "-";
		temp = linha.split(delimiter);
		
		i.addAffiliation((Author)i.authors.keySet().toArray()[Integer.parseInt(temp[0])-1], (Affiliation)i.affiliations.toArray()[Integer.parseInt(temp[1])-1]);
		
		
	}

	@SuppressWarnings("unchecked")
	private static void listAuthors(boolean total) {
	
		System.out.println("\nAutores presentes no indexer: ");
		int z = 1;
		for( Object a : i.authors.keySet().toArray()) {
			
			if(total)
			{
			System.out.println("Nome: " +  ((Author)a).name);
			
			
			if(!((Author)a).interests.isEmpty()) 
				System.out.println("Interesses: ");
			for(Object inter: ((Author)a).interests)
			{
				System.out.println(((Interest) inter).name);
			}
			
			if(!((HashSet<Affiliation>)i.authors.get(((Author)a))).isEmpty()) 
				System.out.println("Afiliações: ");
			for(Object aff: ((HashSet<Affiliation>)i.authors.get(((Author)a))))
			{
				System.out.println(((Affiliation) aff).name);
			}
			}
			else
				System.out.println(z+" - " + ((Author)a).name);
			z++;
		}
		
	}

	private static void addAuthor() throws CGException {

		in = new Scanner(System.in);
		System.out.print("Nome: ");
		String name = in.nextLine();
		Author a = new Author(name);
		i.addAuthor(a);
		
	}
	
	@SuppressWarnings("unchecked")
	private static void addAffiliation() throws CGException {

		in = new Scanner(System.in);
		System.out.print("Nome: ");
		String name = in.nextLine();
		Affiliation a = new Affiliation(name);
		i.affiliations.add(a);
		
	}
	
	private static void listAffiliations(boolean total) {
		
		System.out.println("\nAfiliações presentes no indexer: ");
		int z = 1;
		for( Object a : i.affiliations.toArray()) {
			if(total)
				System.out.println(z + " - " + ((Affiliation)a).name);
			else
				System.out.println("Nome: " + ((Affiliation)a).name);
			z++;
		}
		
	}

	
}
