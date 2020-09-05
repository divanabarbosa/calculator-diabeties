
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AntenaDAO {

    // No CRUD o salvar = CREATE
    public void salvar(Antena novaAntena) {
        // Cria um objeto da classe conexao
        Connection conexao;
        try {
            // conecta ao banco de dados
            conexao = ConexaoBD.abreConexao();
            // realiza a inserção
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO antena(numero,frequencia,modelo) VALUES (?,?,?);");
            ps.setInt(1, novaAntena.getNumero());
            ps.setInt(2, novaAntena.getFrequencia());
            ps.setString(3, novaAntena.getModelo());
            ps.execute();
            // fecha conexao com o banco de dados
            ConexaoBD.fechaConexao();
        } catch (SQLException ex) {
            System.out.println("ERRO 2!");
        }

    }

    // No CRUD o buscar = RETRIEVE
    public List<Antena> buscar() {
        // Cria um objeto da classe conexao
        Connection conexao;
        // Cria uma lista auxiliar que recebera os dados do banco de dados
        List<Antena> antenas = new ArrayList<>();
        try {
            // conecta ao banco de dados
            conexao = ConexaoBD.abreConexao();
            // recupera os dados dos bancos de dados
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM antena;");

            while (rs.next()) {
                Antena antenaAux = new Antena();
                antenaAux.setNumero(rs.getInt("numero"));
                antenaAux.setFrequencia(rs.getInt("frequencia"));
                antenaAux.setModelo(rs.getString("modelo"));
                antenas.add(antenaAux);
            }
            // fecha conexao com o banco de dados
            ConexaoBD.fechaConexao();
        } catch (SQLException ex) {
            System.out.println("ERRO 5!");
        }
        return antenas;
    }

}
