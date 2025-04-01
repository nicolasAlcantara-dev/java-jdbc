import dao.AlunoDAO;
import model.Aluno;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = null;

        // Create
        AlunoDAO dao = new AlunoDAO();
        Aluno al = new Aluno();
//        al.setNome("Nicolas");
//        al.setIdade(19);
//        al.setEstado("SP");
//        dao.create(al);
//        al.setNome("Vitoria");
//        al.setIdade(19);
//        al.setEstado("CE");
//        dao.create(al);
//        al.setNome("Vini");
//        al.setIdade(18);
//        al.setEstado("SP");
//        dao.create(al);
//        al.setNome("Rebeca");
//        al.setIdade(20);
//        al.setEstado("BA");
//        dao.create(al);


        // Update
        Aluno alu = dao.findByID(10);
        alu.setNome("Rebeca Bahia");
        alu.setIdade(19);
        alu.setEstado("SP");
        dao.update(alu);

        // Read
//        System.out.println(dao.findByID(1));


        // Delete
//       dao.delete(7);
         dao.getAluno().forEach(System.out::println);
    }
}
