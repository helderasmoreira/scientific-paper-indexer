package main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

import jp.co.csk.vdm.toolbox.VDM.CGException;
import jp.co.csk.vdm.toolbox.VDM.UTIL;


public class Interface {
	
	//TODO Arranjar a parte de adicionar automaticamente as cita��es (VDM)

	static Scanner in = new Scanner(System.in);
	static Indexer i;
	
	
@SuppressWarnings("unchecked")
private static void fillData() throws CGException {
		
		Author a = new Author("H�lder Moreira");
		Author b = new Author("Tiago Babo");
		Author c = new Author("Adriana Lima");
		Author d = new Author("Carlos Santos");
		
		Interest i1 = new Interest("Programa��o");
		Interest i2 = new Interest("Jogos");
		Interest i3 = new Interest("M�sica");
		
		a.addInterest(i1);
		a.addInterest(i2);
		a.addInterest(i3);
		b.addInterest(i1);
		c.addInterest(i2);
		d.addInterest(i3);
		
		i.addAuthor(a);
		i.addAuthor(b);
		i.addAuthor(c);
		i.addAuthor(d);
		
		Affiliation aff = new Affiliation("FEUP");
		i.affiliations.add(aff);
		i.addAffiliation(a, aff);
		i.addAffiliation(b, aff);
		i.addAffiliation(c, aff);
		i.addAffiliation(d, aff);
		
		HashSet<Author> h1 = new HashSet<Author>();
		h1.add(a);
		h1.add(b);
		HashSet<Author> h2 = new HashSet<Author>();
		h2.add(b);
		h2.add(c);
		HashSet<Author> h3 = new HashSet<Author>();
		h3.add(c);
		h3.add(d);

		HashSet<Reference> hr0 = new HashSet<Reference>();
		Publication p1 = new Publication("FEUP", "FEUP", new Date(21,11,1990), h1, aff, hr0);
		i.addPublication(p1);
		
		
		HashSet<Reference> hr1 = new HashSet<Reference>();
		Reference r1 = new Reference(1,1,p1);
		hr1.add(r1);
		Publication p2 = new Publication("VDM", "VDM", new Date(21,11,1990), h2, aff, hr1);
		i.addPublication(p2);
		
		HashSet<Reference> hr2 = new HashSet<Reference>();
		Reference r2 = new Reference(1,1,p2);
		hr2.add(r2);
		hr2.add(r1);
		Publication p3 = new Publication("MFES", "MFES", new Date(21,11,1990), h3, aff, hr2);
		i.addPublication(p3);
		
	}

	
	public static void main(String[] args) throws CGException {
		
		i = new Indexer();
		fillData();
		int op;
		
		
		do{
			System.out.println("\n\n\nScientific Paper Indexer\n\nOp��es:");
			System.out.println("1 - Adicionar autor;");
			System.out.println("2 - Listar autores;");
			System.out.println("3 - Adicionar afilia��es;");
			System.out.println("4 - Listar afilia��es;");
			System.out.println("5 - Relacionar autor e afilia��o;");
			System.out.println("6 - Adicionar publica��o;");
			System.out.println("7 - Listar publica��es;");
			System.out.println("8 - Adicionar Interesse a um autor;");
			System.out.println("9 - Calcular caminho entre 2 autores;");
			System.out.println("10 - Calcular cita��es pelo pr�prio autor;");
			System.out.println("11 - Calcular cita��es de um autor feitas por outro;");
			System.out.println("12 - Contar publica��es de um autor;");
			System.out.println("13 - Calcular dist�ncia entre dois autores;");
			System.out.println("14 - Encontrar autores por afilia��o;");
			System.out.println("15 - Publica��es por autor;");
			System.out.print("\n0 - Sair\nOp��o: ");
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
				if(!i.authors.isEmpty())
					addPublication();
				else System.out.println("Adicione autores...");
				break;
			case 7: 
				listPublications(true);
				break;
			case 9:
				calcPathBetweenAuthors();
				break;
			case 8:
				addAuthorInterest();
				break;
			case 10:
				countSelfCitations();
				break;
			case 11:
				countOthersCitations();
			case 12:
				countPublications();
				break;	
			case 13:
				calcDistanceBetweenAuthors();
				break;
			case 14:
				findAuthorsByAffiliation();
				break;
			case 15:
				findPublicationsByAuthor();
				break;	
				
			default:
				break;
			
			}
			in = new Scanner(System.in);
			
			System.out.println("Prima ENTER para continuar...");
			in.nextLine();
			
		}while(op!=0);
		
	}

	private static void findPublicationsByAuthor() throws CGException {
		listAuthors(false);
		in = new Scanner(System.in);
		System.out.print("Escolha o autor: ");
		
		int n = in.nextInt();
		System.out.println("Publica��es do autor: ");
		
		for( Object a : i.getPublicationsByAuthor((Author)i.authors.keySet().toArray()[n-1]).toArray()) {
			
				System.out.println("Nome: " + ((Publication)a).name);
				System.out.println("Descri��o: " + ((Publication)a).description);
				
				System.out.println("Autores: ");
				for(Object author: ((Publication)a).authors)
				{
					System.out.println(((Author) author).name);
				}
				
				if(!((Publication)a).references.isEmpty()) 
					System.out.println("Refer�ncias (Cap�tulo | Linha | Publica��o) : ");
				for(Object ref: ((Publication)a).references)
				{
					System.out.println(((Reference) ref).chapter + " | " + ((Reference) ref).line + " | " + ((Reference) ref).publication.name);
				}
				
				if(!((Publication)a).citations.isEmpty()) 
					System.out.println("Cita��es (Cap�tulo | Linha | Publica��o) : ");
				for(Object ref: ((Publication)a).citations)
				{
					System.out.println(((Reference) ref).chapter + " | " + ((Reference) ref).line + " | " + ((Reference) ref).publication.name);
				}
				System.out.println();
			
		}
		
		
	}


	@SuppressWarnings("unchecked")
	private static void findAuthorsByAffiliation() throws CGException {
		listAffiliations(false);
		in = new Scanner(System.in);
		System.out.print("Escolha a afilia��o: ");
		
		int n = in.nextInt();
		
		System.out.println("Autores na base de dados: ");
		HashSet<Author> a = i.getAuthorsByAff((Affiliation)i.affiliations.toArray()[n-1]);
		for(int i = 0; i < a.size(); i++)
			System.out.println(((Author)a.toArray()[i]).name);
	}


	private static void calcDistanceBetweenAuthors() throws NumberFormatException, CGException {
	listAuthors(false);
		
		in = new Scanner(System.in);
		System.out.print("Indique os dois autores no formato autor1-autor2: ");
		
		
		String linha = in.nextLine();
		String[] temp2;
		String delimiter = "-";
		temp2 = linha.split(delimiter);
		
		
		Double res = i.distanceBetween((Author)i.authors.keySet().toArray()[Integer.parseInt(temp2[0])-1], (Author)i.authors.keySet().toArray()[Integer.parseInt(temp2[1])-1]);
		
		System.out.println("Resultado: " + res.intValue());
		
	}


	private static void countPublications() throws CGException {
		listAuthors(false);
		in = new Scanner(System.in);
		System.out.print("Escolha o autor: ");
		
		int n = in.nextInt();
		
		System.out.println("Publica��es na base de dados: " + i.countPublicationsByAuthor((Author)i.authors.keySet().toArray()[n-1]).intValue());
		
	}

	private static void countSelfCitations() throws CGException {
		listAuthors(false);
		in = new Scanner(System.in);
		System.out.print("Escolha o autor: ");
		
		int n = in.nextInt();
		
		System.out.println("Cita��es por si mesmo: " + i.countCitationsByMyself((Author)i.authors.keySet().toArray()[n-1]).intValue());
		
	}
	
	private static void countOthersCitations() throws CGException {
		listAuthors(false);
		in = new Scanner(System.in);
		System.out.print("Escolha o autor: ");
		
		int n = in.nextInt();
		
		System.out.println("Cita��es por outros autores: " + i.countCitationsByOthers((Author)i.authors.keySet().toArray()[n-1]).intValue());
		
	}

	@SuppressWarnings("unchecked")
	private static void calcPathBetweenAuthors() throws NumberFormatException, CGException {
		
		listAuthors(false);
		
		in = new Scanner(System.in);
		System.out.print("Indique os dois autores no formato autor1-autor2: ");
		
		
		String linha = in.nextLine();
		String[] temp2;
		String delimiter = "-";
		temp2 = linha.split(delimiter);
		
		Vector<Author> res = new Vector<Author>();
		res = i.pathBetween((Author)i.authors.keySet().toArray()[Integer.parseInt(temp2[0])-1], (Author)i.authors.keySet().toArray()[Integer.parseInt(temp2[1])-1]);
		if(res.size() == 0)
			System.out.println("N�o se encontram ligados");
		else
		{
			for(int i = 0; i < res.size(); i++)
				if (i != res.size()-1)
					System.out.print(res.get(i).name + " -> ");
				else
					System.out.println(res.get(i).name);
		}
	}
	
	private static void addAuthorInterest() throws CGException {
		
		listAuthors(false);
		in = new Scanner(System.in);
		System.out.print("Escolha o autor: ");
		
		int a = in.nextInt();
		in = new Scanner(System.in);
		System.out.print("Interesse a adicionar: " );
		
		String inter= in.nextLine();
		Interest interest = new Interest(inter);
		
		((Author) i.authors.keySet().toArray()[a-1]).addInterest(interest);

	}

	private static void addPublication() throws CGException {
		
		in = new Scanner(System.in);
		System.out.print("Nome: ");
		String name = in.nextLine();
		System.out.print("Descri��o: ");
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
		System.out.println("Indique os autores separados por - : ");
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
		System.out.println("\nPublica��es presentes no indexer: ");
		int z = 1;
		for( Object a : i.publications.toArray()) {
			if(total)
			{
				System.out.println("Nome: " + ((Publication)a).name);
				System.out.println("Descri��o: " + ((Publication)a).description);
				
				System.out.println("Autores: ");
				for(Object author: ((Publication)a).authors)
				{
					System.out.println(((Author) author).name);
				}
				
				if(!((Publication)a).references.isEmpty()) 
					System.out.println("Refer�ncias (Cap�tulo | Linha | Publica��o) : ");
				for(Object ref: ((Publication)a).references)
				{
					System.out.println(((Reference) ref).chapter + " | " + ((Reference) ref).line + " | " + ((Reference) ref).publication.name);
				}
				
				if(!((Publication)a).citations.isEmpty()) 
					System.out.println("Cita��es (Cap�tulo | Linha | Publica��o) : ");
				for(Object ref: ((Publication)a).citations)
				{
					System.out.println(((Reference) ref).chapter + " | " + ((Reference) ref).line + " | " + ((Reference) ref).publication.name);
				}
				System.out.println();
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
		System.out.print("Estabele�a a rela��o separando por - os ids: ");
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
					System.out.println("Afilia��es: ");
				for(Object aff: ((HashSet<Affiliation>)i.authors.get(((Author)a))))
				{
					System.out.println(((Affiliation) aff).name);
				}
				System.out.println();
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
		
		System.out.println("\nAfilia��es presentes no indexer: ");
		int z = 1;
		for( Object a : i.affiliations.toArray()) {
			if(total)
				System.out.println("Nome: " + ((Affiliation)a).name);
			else
				System.out.println(z + " - " + ((Affiliation)a).name);
			z++;
		}
		
	}

	
}
