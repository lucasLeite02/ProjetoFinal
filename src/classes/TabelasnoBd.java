//Classe para gerar objeto que armazena os nomes de tabelas do bd

package classes;

import classesBd.VendasBD;

public class TabelasnoBd {
    
    String nome;

    public TabelasnoBd(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }        
}
