/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetourna.controller;

import java.util.List;
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
        this.dadosEleitores.iniciarListas();
            
    }
    
    public boolean ValidarUsuario(String name, String possword){ 
        
        if(name != null && possword != null){ // vendo se os campos foram preenchidos
            String nome = name.toUpperCase();
            String senha = possword.toLowerCase();
        
            

            List<EleitorAssinante> listaAssinantes = dadosEleitores.getListAssinantes();
            List<EleitorAssinante> listVotou = dadosEleitores.getListVotaramAssinante();

            
            for (EleitorAssinante assinante : listaAssinantes) { //lendo array de assinantes
                if (assinante.getNome().equals(nome) && assinante.getEmail().equals(senha)) { //verificando se os dados batem com algum assinante
                    if (listVotou.isEmpty()){ // verificando se a lista de quem votou está vazia
                        dadosEleitores.addVotaram(nome, senha, null);
                        return true;
                    }else{
                        for(EleitorAssinante votou : listVotou){ //lendo lista  de assinantes que ja votaram
                            if (votou.getNome().equals(nome) && votou.getEmail().equals(senha)){//verificando se o usuário ja votou
                                return false;
                            }else{
                                dadosEleitores.addVotaram(nome, senha, null);
                                return true;
                            }
                        }
                        return true;
    
                    }
                }else{
                    return false;
                }

            }
        }
       
        return false;
     }
}
