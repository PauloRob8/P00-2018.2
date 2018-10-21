package modelo;
import java.util.ArrayList;

public class Repositorio {
	
	public ArrayList<Arquivo> arquivos = new ArrayList();
	public ArrayList<Arquivo> stg_arquivos = new ArrayList();
	public ArrayList<Arquivo> unstg_arquivos = new ArrayList();
	
	public String nome;

	public Repositorio(String n){
		this.nome = n;
		
	}
	
	public String addArquivo(Arquivo a) {
		arquivos.add(a);
		return "Arquivo adicionado com sucesso!";
	}
	
	public String removerArquivo(Arquivo a) {
		for(int i = 0; i < arquivos.size(); i++) {
			if(arquivos.contains(a)) {
				arquivos.remove(a);
				return "Arquivo removido com sucesso";
			}
			else if(!arquivos.contains(a))
				return "Arquivo não encontrado";
			
		}
		return "Operação finalizada";
		
	}
	
	public String stg_addArquivo(Arquivo a) {
		stg_arquivos.add(a);
		return "Arquivo adicionado com sucesso!";
	}
	
	public String stg_removerArquivo(Arquivo a) {
		for(int i = 0; i < stg_arquivos.size(); i++) {
			if(stg_arquivos.contains(a)) {
				stg_arquivos.remove(a);
				return "Arquivo removido com sucesso";
			}
			else if(!stg_arquivos.contains(a))
				return "Arquivo não encontrado";
			
		}
		return "Operação finalizada";
		
	}
	
	public String unstg_addArquivo(Arquivo a) {
		unstg_arquivos.add(a);
		return "Arquivo adicionado com sucesso!";
	}
	
	public String unstg_removerArquivo(Arquivo a) {
		for(int i = 0; i < unstg_arquivos.size(); i++) {
			if(unstg_arquivos.contains(a)) {
				unstg_arquivos.remove(a);
				return "Arquivo removido com sucesso";
			}
			else if(!unstg_arquivos.contains(a))
				return "Arquivo não encontrado";
			
		}
		return "Operação finalizada";
		
	}

}
