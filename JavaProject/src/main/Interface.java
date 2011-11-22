package main;

import java.util.HashSet;
import java.util.Scanner;

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
				listAuthors();
				break;
			case 3: 
				addAffiliation();
				break;
			case 4: 
				listAffiliations();
				break;
			case 5:
				relateAffiliationAuthor();
				break;
			case 6:
				addPublication();
				break;
			case 7: 
				listPublications();
				break;
		
			default:
				break;
			
			}
			
			
		}while(op!=0);
		
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
		
		listPublications();
		
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
		if(!refs.isEmpty())
			System.out.println(((Reference)refs.toArray()[0]).publication.toString());
		
		listAuthors();
		linha = in.nextLine();
		String[] temp4;
		delimiter = "-";
		temp4 = linha.split(delimiter);
		
		HashSet<Author> authors = new HashSet<Author>();
		for(String t : temp4)
		{
			authors.add((Author) i.authors.keySet().toArray()[Integer.parseInt(t)-1]);
		}
		
		listAffiliations();
		linha = in.nextLine();
		
		
		
		Publication p = new Publication(name, des, d, authors, (Affiliation) i.affiliations.toArray()[Integer.parseInt(linha)-1], refs);
		
		i.addPublication(p);
		
		System.out.println(p.toString());
		
	}


	private static void listPublications() {
		System.out.println("\nPublicações presentes no indexer: ");
		int z = 1;
		for( Object a : i.publications.toArray()) {
			System.out.println(z+" - " + ((Publication)a).name);
		
			// TODO: Imprimir as merdas das publicações
			System.out.println("Referências: " + ((Publication)a).references.toString());
			System.out.println("Citações: " + ((Publication)a).citations.toString());
			z++;
		}
		
		
	}


	private static void relateAffiliationAuthor() throws NumberFormatException, CGException {
	
		listAuthors();
		listAffiliations();
		in = new Scanner(System.in);
		System.out.print("Estabeleça a relação separando por - os ids: ");
		String linha = in.nextLine();
		String[] temp;
		String delimiter = "-";
		temp = linha.split(delimiter);
		
		i.addAffiliation((Author)i.authors.keySet().toArray()[Integer.parseInt(temp[0])-1], (Affiliation)i.affiliations.toArray()[Integer.parseInt(temp[1])-1]);
		
		
	}

	private static void listAuthors() {
	
		System.out.println("\nAutores presentes no indexer: ");
		int z = 1;
		for( Object a : i.authors.keySet().toArray()) {
			System.out.println(z+" - " + ((Author)a).name);
		
			// TODO: Imprimir o nome dos interesses e das afiliações
			System.out.println("Interesses: " + ((Author)a).interests.toString());
			System.out.println("Afiliações: " + i.authors.get(a).toString());
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
	
	private static void listAffiliations() {
		
		System.out.println("\nAfiliações presentes no indexer: ");
		int z = 1;
		for( Object a : i.affiliations.toArray()) {
			System.out.println(z + " - " + ((Affiliation)a).name);
			z++;
		}
		
	}

	
}
