/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetourna.controller;

import projetourna.model.Arquivos;
import java.util.List;

import projetourna.model.Critico;
import projetourna.model.EleitorAssinante;

/**
 *
 * @author Jeferson
 */
public class LoginController {
    
    private Arquivos dadosEleitores;
    

    public void iniciar(){

        this.dadosEleitores = new Arquivos();
        dadosEleitores.lerAssinante();
        dadosEleitores.lerCritico();
        this.dadosEleitores.iniciarListas();
            
    }
    
    public String ValidarUsuario(String name, String possword, String id){ 
         // o metodo retorna true quando o eleitor puder votar, e false caso contrário

        if(name.length() > 0 && possword.length() > 0 && id.length() == 0){ // vendo se os campos foram preenchidos
        
            String nome = name.toUpperCase();
            String senha = possword.toLowerCase();
            Boolean encontrado = false;
            String situacao = "";

            List<EleitorAssinante> listaAssinantes = dadosEleitores.getListAssinantes();
            for(EleitorAssinante eleitor : listaAssinantes){
                System.out.println(eleitor.enviarDados());
            }
            
            
            for (EleitorAssinante assinante : listaAssinantes) { //lendo array de assinantes
                if (assinante.getNome().equals(nome) && assinante.getEmail().equals(senha)) { //verificando se os dados batem com algum assinante
                  encontrado = true;
                  break;
                }
            }
            if(encontrado){
                if (dadosEleitores.lerJaVotaram(nome, senha, null).equals("Usuário ainda não votou")){ // verificando se o assinante ja votou
                    situacao = dadosEleitores.addVotaram(nome, senha, null) ? "Assinante já votou" : "Assinante ainda não votou";
                }else{

                    situacao = "Assinante já votou";
                }
                System.out.println(situacao);
                return situacao;
            }else{
                situacao = "Assinante não encontrado";
            }
            System.out.println(situacao);
            return situacao;
            
        }else if(name != null && possword != null && id != null){
           
            

            String nome = name.toUpperCase();
            String senha = possword.toLowerCase();
            String iD = id;
            String situacao = "";
            Boolean encontrado = false;
            
            List<Critico> listaCriticos = dadosEleitores.getListCriticos();
            List<Critico> votaram = dadosEleitores.getListVotaramCritico();
            for(Critico eleitor : votaram){
                System.out.println(eleitor.enviarDados()+"--Critico");
            }

            for (Critico critico : listaCriticos) { //lendo array de assinantes
                System.out.println(critico.getNome()+critico.getEmail()+critico.getId());
                if (critico.getNome().equals(nome) && critico.getEmail().equals(senha) && critico.getId().equals(iD)) { //verificando se os dados batem com algum critico
                   encontrado = true;
                   break;
                }
            }
            if(encontrado){
                if (dadosEleitores.lerJaVotaram(nome, senha, id).equals("Usuário ainda não votou")){ // verificando se o critico ja votou
                    situacao = dadosEleitores.addVotaram(nome, senha, iD) ? "Critico já votou" : "Critico ainda não votou";
                }else{
                    situacao = "Critico já votou";
                }
                System.out.println(situacao);
                return situacao;
            }else{
                situacao = "Critico não encontrado!";
            }
            System.out.println(situacao);
            
        }else{
            return "Preencha os dados corretamente";
        }
       
        return "Preencha os dados corretamente";
     }
}
// 