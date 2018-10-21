package App;

import modelo.*;

import java.io.PrintWriter;

import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.IOException;
import Negocios.*
;
public class GitSimulator {
	
	public static void main(String[] args) throws IOException {
		
		Repositorio repo1 = new Repositorio("Repo1");
		Repositorio repo2 = new Repositorio("Repo2");
		Arquivo file1 = new Arquivo("File1",".txt");
		Arquivo file2 = new Arquivo("File2",".txt");
		Arquivo file3 = new Arquivo("File3",".png");
		
		repo1.addArquivo(file2);
		repo1.addArquivo(file1);
		
		ControleRepositorio control = new ControleRepositorio();
		
		control.repositorios.add(repo1);
		control.repositorios.add(repo2);
		
		int option1 = Integer.parseInt(JOptionPane.showInputDialog(control.menu1()));
		while(option1 != 0) {
			switch(option1) {
				case 1:
					String nomeRepo = JOptionPane.showInputDialog("Insira nome do seu repositório: ");
					control.repositorios.add(new Repositorio(nomeRepo));
					JOptionPane.showMessageDialog(null, "Repositorio " + nomeRepo +" criado com sucesso!");
					option1 = Integer.parseInt(JOptionPane.showInputDialog(control.menu1()));
					break;
					
				case 3:
					control.listarRepo(control);
					System.out.println("-----------------------");
					option1 = Integer.parseInt(JOptionPane.showInputDialog(control.menu1()));
					break;
					
				case 2:
					String nomeRepo2 = JOptionPane.showInputDialog("Insira o nome do repositório que deseja acessar: ");
					for(int i = 0; i < control.repositorios.size(); i ++) {
						if(control.repositorios.get(i).nome.equals(nomeRepo2)) {
							int option2 = Integer.parseInt(JOptionPane.showInputDialog(control.menu2()));
							while(option2 != 0) {
								switch(option2) {
								case 1:
									String nomeArq = JOptionPane.showInputDialog("Digite o nome do arquivo: ");
									String tipo = JOptionPane.showInputDialog("Digite a extensão do arquivo: ");
									control.repositorios.get(i).arquivos.add(new Arquivo(nomeArq,tipo));
									JOptionPane.showMessageDialog(null, "Arquivo " + nomeArq + " criado com sucesso!");
									option2 = Integer.parseInt(JOptionPane.showInputDialog(control.menu2()));
									break;
									
								case 2:
									System.out.println("Arquivos do repositorio " + control.repositorios.get(i).nome);
									control.listarArq(control.repositorios.get(i));
									System.out.println("/------------------------------/");
									option2 = Integer.parseInt(JOptionPane.showInputDialog(control.menu2()));
									break;
									
								case 3:
									String nomeArq1 = JOptionPane.showInputDialog("Digite o nome do arquivo a ser editado: ");
									Repositorio temp = control.repositorios.get(i);
									int tamanho = temp.arquivos.size();
									for(int x = 0; x < tamanho ;x++)
										if(temp.arquivos.get(x).nome.equals(nomeArq1)) {
											String edit = JOptionPane.showInputDialog("Contéudo do arquivo:\n"+ temp.arquivos.get(x).conteudo+"\nInsira as mudanças no arquivo(Digite remove caso queira remove-lo):\nCopie e cole para adicionar mudanças:");
											if(edit.equals("remove")) {
												for(int z = 0; z < temp.stg_arquivos.size();z++) {
													if(temp.stg_arquivos.get(z).nome.equals(nomeArq1))
														temp.stg_arquivos.get(z).removido = true;
												}
												
												temp.arquivos.remove(x);
												break;
											}	
											else
												temp.arquivos.get(x).editar(edit);
												if(temp.arquivos.get(x).status.equals("Stage Zone"))
													temp.arquivos.get(x).editado = true;
											JOptionPane.showMessageDialog(null, "Alterações realizadas com sucesso!");
											break;
										}
									option2 = Integer.parseInt(JOptionPane.showInputDialog(control.menu2()));
									break;
									
								case 4:
									String nomeArq2 = JOptionPane.showInputDialog("Digite o nome do arquivo a entrar em stage zone ou digite all para inserir todos: ");
									Repositorio temp2 = control.repositorios.get(i);
									for(int y = 0; y < temp2.arquivos.size();y++)
										if(temp2.arquivos.get(y).nome.equals(nomeArq2)) {
											if(temp2.arquivos.get(y).editado == false) {
												temp2.arquivos.get(y).add();
												temp2.stg_arquivos.add(temp2.arquivos.get(y));
												temp2.unstg_arquivos.remove(temp2.arquivos.get(y));
											}
											else
												temp2.arquivos.get(y).editado = false;
												temp2.arquivos.get(y).add();
												temp2.stg_arquivos.add(temp2.arquivos.get(y));
												temp2.unstg_arquivos.remove(temp2.arquivos.get(y));
											
										}
										else if(nomeArq2.equals("all") & temp2.arquivos.get(y).status.equals("untracked")) {
											temp2.arquivos.get(y).add();
											temp2.stg_arquivos.add(temp2.arquivos.get(y));
											temp2.unstg_arquivos.remove(temp2.arquivos.get(y));
										}
										
									option2 = Integer.parseInt(JOptionPane.showInputDialog(control.menu2()));
									break;
									
								case 5:
									String nomeArq3 = JOptionPane.showInputDialog("Digite o nome do arquivo a sair da stage zone ou digite all para remover todos: ");
									Repositorio temp3 = control.repositorios.get(i);
									for(int y = 0; y < temp3.arquivos.size();y++)
										if(temp3.arquivos.get(y).nome.equals(nomeArq3)) {
											temp3.arquivos.get(y).reset();
											temp3.stg_arquivos.remove(temp3.arquivos.get(y));
											temp3.unstg_arquivos.add(temp3.arquivos.get(y));
											
										}
										else if(nomeArq3.equals("all") & temp3.arquivos.get(y).status.equals("Stage Zone") ) {
											temp3.arquivos.get(y).reset();
											temp3.stg_arquivos.remove(temp3.arquivos.get(y));
											temp3.unstg_arquivos.add(temp3.arquivos.get(y));
										}
									option2 = Integer.parseInt(JOptionPane.showInputDialog(control.menu2()));
									break;
											
									
								case 6:
									String message = JOptionPane.showInputDialog("Digite a mensagem do seu commit: ");
									Repositorio temp5 = control.repositorios.get(i);
									for(int z = 0; z < temp5.stg_arquivos.size();z++) {
										temp5.stg_arquivos.removeAll(temp5.stg_arquivos);
										control.commits.add(new Commit(message));
									}	
									option2 = Integer.parseInt(JOptionPane.showInputDialog(control.menu2()));
									break;
									
								case 7:
									Repositorio temp4 = control.repositorios.get(i);
									System.out.println("Arquivos rastreados");
									control.stg_listar(temp4);
									System.out.println("--------------------------------");
									System.out.println("Arquivos não rastreados");
									control.unstg_listar(temp4);
									System.out.println("--------------------------------");
									
									option2 = Integer.parseInt(JOptionPane.showInputDialog(control.menu2()));
									break;
									
								case 8:
									
									
									break;
								}		
							}
						}
					
							
					}
					if(!control.repositorios.contains(nomeRepo2))
						JOptionPane.showMessageDialog(null, "Repositorio não encontrado!");
					option1 = Integer.parseInt(JOptionPane.showInputDialog(control.menu1()));
		}
	}
	}
}
