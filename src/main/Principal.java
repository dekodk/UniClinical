package main;

import controller.AgendamentoDao;
import controller.ClienteDao;
import controller.ColaboradorDao;
import controller.InsumoDao;
import controller.ProcedimentoDao;
import controller.ContasReceberDao;
import controller.ProdutoDao;
import controller.DespesaDao;
import entidade.Agendamento;
import entidade.Cliente;
import entidade.Colaborador;
import entidade.Insumo;
import entidade.Procedimento;
import entidade.Export;
import entidade.Produto;
import entidade.ContasReceber;
import entidade.Despesa;

import java.util.ArrayList;

/**
 *
 * @author deko_
 */
public class Principal {
    public static Cliente cliente = new Cliente();
    public static ClienteDao clienteDao = new ClienteDao();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    public static Insumo insumo = new Insumo();
    public static InsumoDao insumoDao = new InsumoDao();
    public static ArrayList<Insumo> insumos = new ArrayList<Insumo>();
    
    public static Procedimento procedimento = new Procedimento();
    public static ProcedimentoDao procedimentoDao = new ProcedimentoDao();
    public static ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>();
    
    public static Colaborador colaborador = new Colaborador();
    public static ColaboradorDao colaboradorDao = new ColaboradorDao();
    public static ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    
    public static Agendamento agendamento = new Agendamento();
    public static AgendamentoDao agendamentodDao = new AgendamentoDao();
    public static ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
    
    public static ContasReceber contasReceber = new ContasReceber();
    public static ContasReceberDao contasReceberDao = new ContasReceberDao();
    public static ArrayList<ContasReceber> contasRecebers = new ArrayList<ContasReceber>();
    
    public static Despesa despesa = new Despesa();
    public static DespesaDao despesaDao = new DespesaDao();
    public static ArrayList<Despesa> despesas = new ArrayList<Despesa>();
    
    public static Produto produto = new Produto();
    public static ProdutoDao produtoDao = new ProdutoDao();
    public static ArrayList<Produto> produtos = new ArrayList<Produto>();
    
    public static Export export = new Export();
    public static ArrayList<Export> exports = new ArrayList<Export>();
    
    public static void main(String[] args) {
        
    }
}
