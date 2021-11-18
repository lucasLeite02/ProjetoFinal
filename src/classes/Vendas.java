//classe para instanciar objeto de venda

package classes;

import java.util.Objects;

public class Vendas { 
    //atributos da venda
    
   Integer id;
   String data;
   String cliente;
   double valorBruto;
   double comissao;
   String tipoPag;
   double valorliquido;
   double comissaoVenda;

       //contrutores de venda (Sobrecarga de métodos)
    public Vendas() {
    }
    
    public Vendas(String data, String cliente, double valorBruto, double comissao, String tipoPag) {
        this.data = data;
        this.cliente = cliente;
        this.valorBruto = valorBruto;
        this.tipoPag = tipoPag;
        this.comissao = comissao;
    }

    public Vendas(Integer id, String data, String cliente, double valorBruto, double comissao, String tipoPag) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.valorBruto = valorBruto;
        this.tipoPag = tipoPag;
        this.comissao = comissao;
    }

    public Vendas(Integer id, String data, String cliente, double valorBruto, double comissao, String tipoPag, double valorliquido, double comissaoVenda) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.valorBruto = valorBruto;
        this.tipoPag = tipoPag;
        this.comissao = comissao;
        this.valorliquido = valorliquido;
        this.comissaoVenda = comissaoVenda;
    }

    
    @Override //método para comparação de objetos
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { 
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vendas other = (Vendas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    //getters e setters 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public String getTipoPag() {
        return tipoPag;
    }

    public void setTipoPag(String tipoPag) {
        this.tipoPag = tipoPag;
    }

    public double getValorliquido() {
        return valorliquido;
    }

    public void setValorliquido(double valorliquido) {
        this.valorliquido = valorliquido;
    }

    public double getComissaoVenda() {
        return comissaoVenda;
    }

    public void setComissaoVenda(double comissaoVenda) {
        this.comissaoVenda = comissaoVenda;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override //conversor para retornar um objeto em forma de string
    public String toString() {
        return "Vendas{" + "id=" + id + ", data=" + data + ", cliente=" + cliente + ", valorBruto=" + valorBruto + ", tipoPag=" + tipoPag + ", valorliquido=" + valorliquido + ", comissaoVenda=" + comissaoVenda + '}';
    }


  
 
    
    
    
    
    
    
    
    
    
    
}
