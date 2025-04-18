package dao;

import connection.ConnectionFactory;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO {

    public List<Aluno> getAluno() throws ClassNotFoundException{
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Aluno> alunos = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT * FROM aluno");
            rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));

                alunos.add(aluno);
            }

        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        return alunos;
    }

    public Aluno findByID(Integer id) throws  ClassNotFoundException{
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        Aluno aluno = new Aluno();

        try {
            ps = conn.prepareStatement("SELECT * FROM aluno WHERE ID = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()) {
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        return aluno;
    }

    public void create(Aluno aluno) throws ClassNotFoundException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("INSERT INTO aluno(nome, idade, estado)VALUES(?, ?, ?)");
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setString(3, aluno.getEstado());
            ps.executeUpdate();
            if(ps != null) {
                System.out.println("Success");
            }
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Something wrong");
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

    }

    public void delete(Integer id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("DELETE FROM aluno WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Something wrong");
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public void update(Aluno aluno) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("UPDATE aluno SET `nome` = ?, `idade` = ?, `estado` = ? WHERE `aluno`.`id` = ?");
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setString(3, aluno.getEstado());
            ps.setInt(4, aluno.getId());
            ps.executeUpdate();
            System.out.println("Success");
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Something wrong");
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

}



