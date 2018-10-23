package Negocios;

import modelo.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ControleRepositorio {
	
	public Repositorio repos;
	public ArrayList<Repositorio> repositorios = new ArrayList();
	public ArrayList<String> gravador = new ArrayList();
	
	public Repositorio getRepositorio(String nome) {
		for(int i = 0; i < repositorios.size();i++)
			if(repositorios.get(i).nome.equals(nome))
				return repositorios.get(i);
		
			return null;
	}
	
	public String getDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
	
	public String menu1() {
		return "-- Git Simulator -- \n1-> Criar Repositório\n2-> Acessar Repositório\n3-> Listar Repositorios \n0-> Sair"; 
	}
	
	public String menu2() {
		return "1-> Adicionar Arquivo\n2-> Listar Arquivos\n3-> Editar ou Remover\n4-> Git add\n5-> Reset\n6-> Commit\n7-> Status\n"
				+ "8-> Log\n0-> Sair ";
	}
	
	
	public void listarRepo(ControleRepositorio control) {
		for(int i =0;i < control.repositorios.size();i++)
			System.out.println("Nome: "+ control.repositorios.get(i).nome + "\n Quantidade de arquivos: " + control.repositorios.get(i).arquivos.size());
	}
	
	public void listarArq(Repositorio repo) {
		for(int i = 0;i <repo.arquivos.size(); i++) {
			System.out.println("Arquivo -> " + i + " " + repo.arquivos.get(i).nome + repo.arquivos.get(i).tipo +"\n" + "Conteúdo: "+repo.arquivos.get(i).conteudo
					+ "\n" + "Status: "+ repo.arquivos.get(i).status);
	}
	
	}
	
	public void stg_listar(Repositorio repo) {
		for(int i = 0;i < repo.stg_arquivos.size();i++) {
			if(repo.stg_arquivos.get(i).editado == false & repo.stg_arquivos.get(i).removido == false)
				System.out.println("Novo " + repo.stg_arquivos.get(i).nome + repo.stg_arquivos.get(i).tipo );
			
			else if(repo.stg_arquivos.get(i).editado == true & repo.stg_arquivos.get(i).removido == false)
				System.out.println("Modificado " + repo.stg_arquivos.get(i).nome + repo.stg_arquivos.get(i).tipo );
			
			else if(repo.stg_arquivos.get(i).removido == true)
				System.out.println("Deletado " + repo.stg_arquivos.get(i).nome + repo.stg_arquivos.get(i).tipo );
		}
			
	}
	
	public void unstg_listar(Repositorio repo) {
		for(int i = 0;i < repo.arquivos.size();i++) {
			if(repo.arquivos.get(i).status.equals("untracked"))
				System.out.println("" + repo.arquivos.get(i).nome + repo.arquivos.get(i).tipo );
		}
			
	}
	
	public void mudanças(Arquivo a) {
		for(int i = 0; i < a.mudanças.size(); i++) {
			System.out.println("Alterações realizadas no arquivos ->" + "Versão " + i + a.mudanças.get(i));
		}
	}
	
	public void listarArquivosCommited(Repositorio repo) {
		for(int i = 0;i < repo.arquivos.size();i ++) {
			this.mudanças(repo.arquivos.get(i));
			
		}
}
	public String log(Repositorio repo) {
		String s = "";
		for(int i = 0; i < repo.commits.size();i++) {
			s = "Commit: " + repo.commits.get(i).hashCode() + "\nData: "+ repo.commits.get(i).data + "\n" + repo.commits.get(i).message + 
					"\nQuantidade de arquivos: " + repo.commits.get(i).qtdArquivos;
	}
		return s;	
}
	
}
